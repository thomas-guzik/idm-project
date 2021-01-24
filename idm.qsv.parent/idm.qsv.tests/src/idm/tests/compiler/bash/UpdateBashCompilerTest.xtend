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
class UpdateBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void updateOneColumn() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			update :set "w" :columns #1
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	w	f3
			1	v1	w	v3
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
	def void updateOneColumnWithCondition() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			update :set "w" :columns #1 :condition #1 = "f2"
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	w	f3
			1	v1	v2	v3
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
