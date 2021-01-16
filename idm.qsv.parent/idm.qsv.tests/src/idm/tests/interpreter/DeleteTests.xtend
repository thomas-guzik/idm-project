package idm.tests.interpreter

import com.google.inject.Inject
import idm.interpreter.InterpreterOutput
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
class DeleteTests {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper
	@Inject extension ValidationTestHelper

	def void assertInterpretation(QuerySeparatedValues qsv, String expectedStdOut) {
		val outputResult = interpret(qsv)
		Assertions.assertEquals(expectedStdOut, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	def InterpreterOutput interpret(QuerySeparatedValues qsv) {
		val QsvXtendInterpreter interpreter = new QsvXtendInterpreter(qsv)
		val outputResult = interpreter.interpret
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

		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)
	}

	@Test
	def void deleteAllDataLines() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			delete
				:lines
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			«"\t"»f1	f2	f3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void deleteAllDataColumns() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			delete
				:columns
			print
		''')
		parseTree.assertNoErrors

		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)
	}

	@Test
	def void deleteAllDataColumnsAndLines() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			delete
				:lines
				:columns
			print
		''')
		parseTree.assertNoErrors

		val result = interpret(parseTree)
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
				col0	col1
			0	2	7
			1	3	5
			2	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void deleteLinesWhereIntMultipleCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			delete
				:lines col0 > 4 or (col0 = 2 and col1 = 7)
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			0	4	3
			1	1	3
			2	3	5
			3	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
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
				f1	f2	f3
			0	v1	v7	v3
		'''
		assertInterpretation(parseTree, expectedResult)
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
				0	1	2
			0	f1	f2	f3
			1	v1	v7	v3
		'''
		assertInterpretation(parseTree, expectedResult)
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
				f1	f3
			0	v1	v3
			1	v1	v3
		'''
		assertInterpretation(parseTree, expectedResult)
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
			0	v2
			1	v7
		'''
		assertInterpretation(parseTree, expectedResult)
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
				0	2
			0	f1	f3
			1	v1	v3
			2	v1	v3
		'''
		assertInterpretation(parseTree, expectedResult)
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
			0	f2
			1	v2
			2	v7
		'''
		assertInterpretation(parseTree, expectedResult)
	}
}
