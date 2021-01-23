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
class ComputeTests {
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
	def void sumLinesOfColumn() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0
				:sumValuesInColumn col0
			echo $sumCol0
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			21
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void sumLinesOfColumnNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			compute $sumCol0
				:sumValuesInColumn #0
			echo $sumCol0
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			21
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void sumLinesOfColumnStrings() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			compute $sumf2
				:sumValuesInColumn f2
			echo $sumf2
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			v2v7
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void sumTwoColumns() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0Col1
				:sumColumns col0, col1
			echo $sumCol0Col1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			0	7
			1	9
			2	4
			3	8
			4	6
			5	11
			6	6
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void sumTwoColumnsNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			compute $sumCol0Col1
				:sumColumns #1, #0
			echo $sumCol0Col1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			0	7
			1	9
			2	4
			3	8
			4	6
			5	11
			6	6
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void mixIntStringInSumTwoColumns() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str2.csv" with column names: yes
			compute $sumCol0Col1
				:sumColumns f2, f3
			echo $sumCol0Col1
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			0	23
			1	7v4
		'''

		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void sumLinesInColumnMixed() {
		val parseTree = parseHelper.parse('''
			using "foo_mix_int_str2.csv" with column names: yes
			compute $sumf2
				:sumValuesInColumn f3
			echo $sumf2
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			3v4
		'''
		assertInterpretation(parseTree, expectedResult)
	}

}
