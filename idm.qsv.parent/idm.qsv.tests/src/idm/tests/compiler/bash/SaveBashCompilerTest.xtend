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
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import idm.compiler.bash.QsvBashCompiler

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class SaveBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	def String getFileContent(String filename) {
		val content = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
		return content.join("\n")
	}

	@Test
	def void saveToJson() {
		val filename = "test.json"
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			save :json "«filename»"
		''')
		val expectedResult = '''
			{"f1":{"0":"v1","1":"v1"},"f2":{"0":"v2","1":"v7"},"f3":{"0":"v3","1":"v3"}}'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		cmpBash.run(code)
		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}
	
		@Test
	def void saveToCsv() {
		val filename = "test.csv"
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			save :csv "«filename»"
		''')
		val expectedResult = '''
			f1,f2,f3
			v1,v2,v3
			v1,v7,v3'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(parseTree)
		val code = cmpBash.compile()
		cmpBash.run(code)
		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}
	
}