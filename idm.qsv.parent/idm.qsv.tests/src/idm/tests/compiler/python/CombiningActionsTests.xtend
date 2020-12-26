package idm.tests.compiler.python

import com.google.inject.Inject
import idm.compiler.python.PythonCompiler
import idm.compiler.python.PythonCompilerOutput
import idm.qsv.QuerySeparatedValues
import idm.tests.QsvInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class CombiningActionsTests {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper
	@Inject extension ValidationTestHelper

	def void assertPythonCompilesAndRuns(QuerySeparatedValues qsv, String expectedStdOut) {
		val outputResult = pythonCompileAndRun(qsv)
		Assertions.assertEquals(expectedStdOut, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	def PythonCompilerOutput pythonCompileAndRun(QuerySeparatedValues qsv) {
		val PythonCompiler cmpPython = new PythonCompiler(qsv)
		val outputResult = cmpPython.compileAndRun
		return outputResult
	}

	@Test
	def void sumLinesThenUpdate() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0
				:sumLines col0
			echo $sumCol0
			TODO
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			TODO
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void sumTwoColumnsThenInsert() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0Col1
				:sumColumns col0, col1
			insert
				:columns newcol $sumCol0Col1
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			TODO
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

}
