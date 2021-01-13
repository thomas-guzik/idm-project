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
import idm.compiler.bash.CompilerBashQsv

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class BashCompilerInsertTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void insertOneLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :lines ("w1","w2","w3")
			print
		''')
		val expectedResult = '''
			  0 1 2
			0 f1 f2 f3
			1 v1 v2 v3
			2 w1 w2 w3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void insertMultipleLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :lines ("w1","w2","w3"),("y1","y2","y3")
			print
		''')
		val expectedResult = '''
			  0 1 2
			0 f1 f2 f3
			1 v1 v2 v3
			2 w1 w2 w3
			3 y1 y2 y3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void insertOneColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :columns ("f4","v4")
			print
		''')
		val expectedResult = '''
			  0 1 2 3
			0 f1 f2 f3 f4
			1 v1 v2 v3 v4
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void insertMultipleColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			insert :columns ("f4","v4"), ("f5", "v5")
			print
		''')
		val expectedResult = '''
			  0 1 2 3 4
			0 f1 f2 f3 f4 f5
			1 v1 v2 v3 v4 v5
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}

}
