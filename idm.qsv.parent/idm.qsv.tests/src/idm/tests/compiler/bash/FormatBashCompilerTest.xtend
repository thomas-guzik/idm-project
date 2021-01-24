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
class FormatBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

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
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
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
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
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
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}
}
