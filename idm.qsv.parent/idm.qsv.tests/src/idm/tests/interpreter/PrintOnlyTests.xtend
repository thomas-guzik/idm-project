package idm.tests.interpreter

import com.google.inject.Inject
import idm.qsv.QuerySeparatedValues
import idm.tests.QsvInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import idm.interpreter.QsvXtendInterpreter
import idm.interpreter.InterpreterOutput

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class PrintOnlyTests {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper
	@Inject extension ValidationTestHelper

	def void assertInterpretation(QuerySeparatedValues qsv, String expectedStdOut) {
		val errors = qsv.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
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
	def void printWithHeader() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print
		''')
		parseTree.assertNoErrors
		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printWithoutHeader() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
		'''
		assertInterpretation(parseTree, expectedResult)

	}

	@Test
	def void printAllLinesAndColumns() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:lines
				:columns
		''')
		parseTree.assertNoErrors
		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
			1	v1	v7	v3
		'''
		assertInterpretation(parseTree, expectedResult)

	}

	@Test
	def void printAllColumnsAndLines() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns
				:lines
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
			1	v1	v7	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printColumnsWithSingleNameSelection() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f2
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
	def void printColumnsWithSingleNumberSelection() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:columns #1
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

	@Test
	def void printColumnsWithSingleSelectionAllLines() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f2
				:lines
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
	def void printColumnsWithMultipleNameSelectionKeepsFileOrder() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f3, f1
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
	def void printColumnsWithMultipleNumberSelectionKeepsFileOrder() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:columns #2, #0
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
	def void printLinesWhereColumnsEqualInt() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 = 1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			2	1	3
			5	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printTwice() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 = 1
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			2	1	3
			5	1	10
				col0	col1
			0	4	3
			1	2	7
			2	1	3
			3	3	5
			4	5	1
			5	1	10
			6	5	1
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWhereColumnsEqualIntNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			print
				:lines #0 = 5
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1
			4	5	1
			6	5	1
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWhereColumnsEqualString() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:lines f2 = "v7"
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3
			1	v1	v7	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWhereColumnsIntegerComparison() {
		// CompareEqual
		val parseTreeEqual = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 = 2
		''')
		parseTreeEqual.assertNoErrors

		val expectedResultEqual = '''
				col0	col1
			1	2	7
		'''
		assertInterpretation(parseTreeEqual, expectedResultEqual)

		// CompareNotEqual
		val parseTreeNotEqual = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 != 5
		''')
		parseTreeNotEqual.assertNoErrors

		val expectedResultNotEqual = '''
				col0	col1
			0	4	3
			1	2	7
			2	1	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTreeNotEqual, expectedResultNotEqual)

		// CompareLower
		val parseTreeLower = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 < 4
		''')
		parseTreeLower.assertNoErrors

		val expectedResultLower = '''
				col0	col1
			1	2	7
			2	1	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTreeLower, expectedResultLower)

		// CompareGreater
		val parseTreeGreater = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col1 > 3
		''')
		parseTreeGreater.assertNoErrors

		val expectedResultGreater = '''
				col0	col1
			1	2	7
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTreeGreater, expectedResultGreater)

		// CompareLowerOrEqual
		val parseTreeLowerOrEqual = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 <= 3
		''')
		parseTreeLowerOrEqual.assertNoErrors

		val expectedResultLowerOrEqual = '''
				col0	col1
			1	2	7
			2	1	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTreeLowerOrEqual, expectedResultLowerOrEqual)

		// CompareGreaterOrEqual
		val parseTreeGreaterOrEqual = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col1 >= 5
		''')
		parseTreeGreaterOrEqual.assertNoErrors

		val expectedResultGreaterOrEqual = '''
				col0	col1
			1	2	7
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTreeGreaterOrEqual, expectedResultGreaterOrEqual)
	}

	@Test
	def void printEmptyData() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 = -1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			«"\t"»col0	col1
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWithOrCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 = 1 or col0 = 3
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			2	1	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWithAndCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines col0 > 2 and col0 < 5
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			0	4	3
			3	3	5
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWithNestedCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines (col0 > 2 and col0 < 5) or col1 = 10
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			0	4	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesAndColumnWithNestedCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:columns col1
				:lines (col0 > 2 and col0 < 5) or col1 = 10
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col1
			0	3
			3	5
			5	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printLinesWithNestedConditions() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines (col0 <= 3 or col0 = 4) and (col1 != 3 or (col0 < 3 and col0 < 2))
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				col0	col1
			1	2	7
			2	1	3
			3	3	5
			5	1	10
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printOneLine() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:lines #1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			1	v1	v2	v3
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printOneLineWithTrueCondition() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:lines #1 #0 = "v1"
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			1	v1	v2	v3
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printOneLineWithFalseCondition() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:lines #1 #2 = 5
		''')
		parseTree.assertNoErrors

		val expectedResultGreaterOrEqual = '''
			«"\t"»0	1	2
		'''
		assertInterpretation(parseTree, expectedResultGreaterOrEqual)
	}

	@Test
	def void printLineRange() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:lines #1-2
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			1	v1	v2	v3
			2	v1	v7	v3
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void combineLineRangeAndConditionNoHeader() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print
				:lines #1-2 #1 = "v7"
		''')
		val expectedResult = '''
				0	1	2
			2	v1	v7	v3
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void combineLineRangeAndCondition() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			print
				:lines #2-5 col1 > 2
		''')
		val expectedResult = '''
				col0	col1
			2	1	3
			3	3	5
			5	1	10
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printConditionBoolYes() {
		val parseTree = parseHelper.parse('''
			using "bool_with_header.csv" with column names: yes
			print :lines a = yes
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			2	1	1	1	0
			3	1	0	0	0
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printConditionBoolNo() {
		val parseTree = parseHelper.parse('''
			using "bool_with_header.csv" with column names: yes
			print :lines a = no
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	1	0	1
			4	0	1	1	0
		'''
		assertInterpretation(parseTree, expectedResult)

	}
}
