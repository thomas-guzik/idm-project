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

	@Test
	def void deleteLinesWhereStringCondition() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			delete
				:lines f2 = "v2"
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f2  f3
			1  v1  v7  v3
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void deleteLinesWhereStringConditionNoColumnNames() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			delete
				:lines #1 = "v2"
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			    0   1   2
			0  f1  f2  f3
			2  v1  v7  v3
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void deleteOneColumn() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			delete
				:columns f2
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f3
			0  v1  v3
			1  v1  v3
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void deleteTwoColumns() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			delete
				:columns f3, f1
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f2
			0  v2
			1  v7
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void deleteOneColumnNoHeader() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			delete
				:columns #1
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			    0   2
			0  f1  f3
			1  v1  v3
			2  v1  v3
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void deleteTwoColumnsNoHeader() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			delete
				:columns #2, #0
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			    1
			0  f2
			1  v2
			2  v7
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}
}
