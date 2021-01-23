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
class UpdateTests {
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
	def void updateWholeColumnString() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			update
				:set "v8"
				:columns f2
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3
			0	v1	v8	v3
			1	v1	v8	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	def void updateWholeColumnInt() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			update
				:set 5
				:columns col0
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
			   col0  col1
			0     5     3
			1     5     7
			2     5     3
			3     5     5
			4     5     1
			5     5    10
			6     5     1
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void updateWholeTwoColumnsString() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			update
				:set "v8"
				:columns f2, f1
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3
			0	v8	v8	v3
			1	v8	v8	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void updateStringWhereCondition() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			update
				:set "v9"
				:columns f3
				:condition f2 = "v7"
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
			1	v1	v7	v9
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void updateStringWhereConditionNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: no
			update
				:set "v6"
				:columns #2
				:condition #0 = "v1"
			print
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v6
			2	v1	v7	v6
		'''
		assertInterpretation(parseTree, expectedResult)
	}

}
