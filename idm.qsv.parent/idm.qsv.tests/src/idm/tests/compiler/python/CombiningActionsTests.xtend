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
	def void sumLinesThenUpdateAndPrint() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0
				:sumLines col0
			update
				:set $sumCol0
				:columns col0
				:lines col0 = 1
			print
				:columns col1
				:lines col0 = $sumCol0
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   col1
			2     3
			5    10
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
			   col0  col1  newcol
			0     4     3       7
			1     2     7       9
			2     1     3       4
			3     3     5       8
			4     5     1       6
			5     1    10      11
			6     5     1       6
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

}
