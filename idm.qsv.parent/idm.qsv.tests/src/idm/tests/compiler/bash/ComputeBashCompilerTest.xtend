package idm.tests.compiler.bash

import com.google.inject.Inject
import idm.qsv.QuerySeparatedValues
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import idm.tests.QsvInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import idm.compiler.bash.QsvBashCompiler

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class ComputeBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void sumLinesOfColumn() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0
				:sumValuesInColumn col0
			echo $sumCol0
		''')
		val expectedResult = '''
			21
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesOfColumnNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			compute $sumCol0
				:sumValuesInColumn #0
			echo $sumCol0
		''')
		val expectedResult = '''
			21
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesOfColumnStrings() {
		val parseTree = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			compute $sumf2
				:sumValuesInColumn f2
			echo $sumf2
		''')
		val expectedResult = '''
			v2v7
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumTwoColumns() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers.csv" with column names: yes
			compute $sumCol0Col1
				:sumColumns col0, col1
			echo $sumCol0Col1
		''')
		val expectedResult = '''
			0	7
			1	9
			2	4
			3	8
			4	6
			5	11
			6	6
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumTwoColumnsNoHeaders() {
		val parseTree = parseHelper.parse('''
			using "foo_numbers_noheaders.csv" with column names: no
			compute $sumCol0Col1
				:sumColumns #1, #0
			echo $sumCol0Col1
		''')
		val expectedResult = '''
			0	7
			1	9
			2	4
			3	8
			4	6
			5	11
			6	6
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

}
