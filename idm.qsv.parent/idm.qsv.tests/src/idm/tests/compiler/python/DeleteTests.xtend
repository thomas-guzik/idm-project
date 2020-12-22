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
class DeleteTests {
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
	def void deleteAllData() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			delete
			print
		''')
		parseTree.assertNoErrors

		val result = pythonCompileAndRun(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)
	}
	
		@Test
	def void deleteLinesWhereIntCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			delete
				:lines col1 < 5
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   col0  col1
			1     2     7
			3     3     5
			5     1    10
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}
}
