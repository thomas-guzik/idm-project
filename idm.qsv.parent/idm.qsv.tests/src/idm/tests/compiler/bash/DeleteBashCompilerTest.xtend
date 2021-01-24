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
class DeleteBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void deleteOneLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			delete :lines #1
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
		@Test
	def void deleteOtherLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			delete :lines #0
			print
		''')
		val expectedResult = '''
				0	1	2
			0	v1	v2	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
			@Test
	def void deleteLineWithCondition() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			delete :lines a = 1
			print
		''')
		val expectedResult = '''
				a	b	c	d
			0	0	5	6	7
			1	3	9	1	0
			2	6	5	3	4
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
		@Test
	def void deleteMultipleLine() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			delete :lines #1-3
			print
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			1	6	5	3	4
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
	@Test
	def void deleteOneColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			delete :columns #1
			print
		''')
		val expectedResult = '''
				0	2
			0	f1	f3
			1	v1	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}


	@Test
	def void deleteTwoColumns() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			delete :columns #1,#0
			print
		''')
		val expectedResult = '''
				2
			0	f3
			1	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
	}
}