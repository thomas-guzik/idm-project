/*
 * generated by Xtext 2.23.0
 */
package idm.tests.common

import com.google.inject.Inject
import idm.compiler.bash.QsvBashCompiler
import idm.compiler.python.PythonCompiler
import idm.interpreter.QsvXtendInterpreter
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

	def void assertEqualResultBashPythonInterpreter(QuerySeparatedValues qsv, String expectedStdOut) {
		val errors = qsv.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val pythonResult = pythonRun(qsv)
		val bashResult = bashRun(qsv)
		val interpreterResult = interpreterRun(qsv)
		Assertions.assertEquals(pythonResult, bashResult, "Expected python, got bash")
		Assertions.assertEquals(bashResult, interpreterResult, "Expected bash, got interpreter")
	}

	def String pythonRun(QuerySeparatedValues qsv) {
		val PythonCompiler cmpPython = new PythonCompiler(qsv)
		val outputResult = cmpPython.compileAndRun
		return outputResult.getOutput.trim
	}

	def String bashRun(QuerySeparatedValues qsv) {
		val QsvBashCompiler cmpBash = new QsvBashCompiler(qsv)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		return execution.output.trim
	}

	def String interpreterRun(QuerySeparatedValues qsv) {
		val QsvXtendInterpreter interpreter = new QsvXtendInterpreter(qsv)
		val outputResult = interpreter.interpret
		return outputResult.getOutput.trim
	}

	@Test
	def void insertOneLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :lines ("w1","w2","w3")
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
			2	w1	w2	w3
		'''
		assertEqualResultBashPythonInterpreter(result, expectedResult)

	}

	@Test
	def void insertMultipleLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :lines ("w1","w2","w3"),("y1","y2","y3")
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
			2	w1	w2	w3
			3	y1	y2	y3
		'''
		assertEqualResultBashPythonInterpreter(result, expectedResult)

	}

	@Test
	def void insertOneColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :columns ("f4","v4")
			print
		''')
		val expectedResult = '''
				0	1	2	3
			0	f1	f2	f3	f4
			1	v1	v2	v3	v4
		'''
		assertEqualResultBashPythonInterpreter(result, expectedResult)

	}

	@Test
	def void insertMultipleColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :columns ("f4","v4"), ("f5", "v5")
			print
		''')
		val expectedResult = '''
				0	1	2	3	4
			0	f1	f2	f3	f4	f5
			1	v1	v2	v3	v4	v5
		'''
		assertEqualResultBashPythonInterpreter(result, expectedResult)

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
				f1	f2	f3
			0	v1	v2	v3
			1	v1	v7	v3
			2	v8	v0	v5
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
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
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
			2	v1	v7	v3
			3	v4	v1	v0
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
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
				f1	f2	f3
			0	v1	v2	v3
			1	v1	v7	v3
			2	v6	v5	v4
			3	v8	v0	v5
			4	v3	v9	v6
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
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
				col0	col1
			0	4	3
			1	2	7
			2	1	3
			3	3	5
			4	5	1
			5	1	10
			6	5	1
			7	7	2
			8	4	8
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
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
				f1	f2	f3
			0	v1	2	v3
			1	v6	7	v4
			2	v0	5	v6
			3	v5	4	v9
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertColumnAllString() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:columns ef ("ar", "zt")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3	ef
			0	v1	2	v3	ar
			1	v6	7	v4	zt
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertThreeColumnsAllString() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:columns ef ("ar", "zt"), th ("gb", "hn"), il ("ol", "pm")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3	ef	th	il
			0	v1	2	v3	ar	gb	ol
			1	v6	7	v4	zt	hn	pm
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertColumnAllInt() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:columns ef (8, 6)
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3	ef
			0	v1	2	v3	8
			1	v6	7	v4	6
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertColumnAllIntNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			insert
				:columns (7, 6, 5, 4, 3, 2, 1)
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			0	4	3	7
			1	2	7	6
			2	1	3	5
			3	3	5	4
			4	5	1	3
			5	1	10	2
			6	5	1	1
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertTwoColumnsAllIntNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			insert
				:columns (7, 6, 5, 4, 3, 2, 1), (6, 8, 1, 3, 5, 7, 9)
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2	3
			0	4	3	7	6
			1	2	7	6	8
			2	1	3	5	1
			3	3	5	4	3
			4	5	1	3	5
			5	1	10	2	7
			6	5	1	1	9
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

	@Test
	def void insertColumnMixIntString() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str.csv" with column names: yes
			insert
				:columns ef (8, "e")
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3	ef
			0	v1	2	v3	8
			1	v6	7	v4	e
		'''
		assertEqualResultBashPythonInterpreter(parseTree, expectedResult)
	}

}
