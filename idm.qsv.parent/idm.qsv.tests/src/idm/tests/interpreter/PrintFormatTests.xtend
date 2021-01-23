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
class PrintFormatTests {
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
	def void printFormatWithSeparator() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :separator ","
		''')
		val expectedResult = '''
			,0,1,2
			0,f1,f2,f3
			1,v1,v2,v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatWithDashSeparator() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :separator "-"
		''')
		val expectedResult = '''
			-0-1-2
			0-f1-f2-f3
			1-v1-v2-v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatPretty() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :pretty
		''')
		val expectedResult = '''
			   0   1   2
			0  f1  f2  f3
			1  v1  v2  v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatPretty2() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print
				:columns #0, #2
				:lines #1 = "v2"
				:pretty
		''')
		val expectedResult = '''
			   0   2
			1  v1  v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatPretty3() {
		val parseTree = parseHelper.parse('''
			using "test_variable2.csv" with column names: no
			print
				:pretty
		''')
		val expectedResult = '''
			   0    1           2  3
			0  a    b           c  d
			1  1    10          v  vvvv
			2  2    9           v  10
			3  333  10          v  w
			4  4    110fd54fez  v  0
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatDefault() {
		val parseTree = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}

	@Test
	def void printFormatWithDashSeparatorAndHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print :separator "-"
		''')
		val expectedResult = '''
			-f1-f2-f3
			0-v1-v2-v3
			1-v1-v7-v3
		'''
		assertInterpretation(parseTree, expectedResult)
	}
}
