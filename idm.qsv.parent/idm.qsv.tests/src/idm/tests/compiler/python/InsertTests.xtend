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
class InsertTests {
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
	def void insertOneStringLine() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f2  f3
			0  v1  v2  v3
			1  v1  v7  v3
			2  v8  v0  v5
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void insertOneStringLineNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			insert
				:lines ("v4", "v1", "v0")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			    0   1   2
			0  f1  f2  f3
			1  v1  v2  v3
			2  v1  v7  v3
			3  v4  v1  v0
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void insertThreeStringLines() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			insert
				:lines ("v6", "v5", "v4"), ("v8", "v0", "v5"), ("v3", "v9", "v6")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f2  f3
			0  v1  v2  v3
			1  v1  v7  v3
			2  v6  v5  v4
			3  v8  v0  v5
			4  v3  v9  v6
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void insertIntegerLines() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			insert
				:lines (7, 2), (4, 8)
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   col0  col1
			0     4     3
			1     2     7
			2     1     3
			3     3     5
			4     5     1
			5     1    10
			6     5     1
			7     7     2
			8     4     8
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

	@Test
	def void insertLinesIntegerAndString() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:lines ("v0", 5, "v6"), ("v5", 4, "v9")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f2  f3
			0  v1   2  v3
			1  v6   7  v4
			2  v0   5  v6
			3  v5   4  v9
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}
	
		@Test
	def void insertColumnAllString() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:column ef ("ar", "zt")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   f1  f2  f3  ef
			0  v1   2  v3  ar
			1  v6   7  v4  zt
		'''
		assertPythonCompilesAndRuns(parseTree, expectedResult)
	}

}
