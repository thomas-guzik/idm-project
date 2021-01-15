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
class BashCompilerUpdatetTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void insertOneLine() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			update :set "w" :columns #1
			print
		''')
		val expectedResult = '''
			  0 1 2
			0 f1 w f3
			1 v1 w v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(result)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}
}
