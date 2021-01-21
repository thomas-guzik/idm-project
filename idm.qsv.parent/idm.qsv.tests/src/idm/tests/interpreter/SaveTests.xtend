package idm.tests.interpreter

import com.google.inject.Inject
import idm.interpreter.InterpreterOutput
import idm.interpreter.QsvXtendInterpreter
import idm.qsv.QuerySeparatedValues
import idm.tests.QsvInjectorProvider
import java.io.File
import java.io.FileWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class SaveTests {
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

	List<String> tempCsvNames = List.of("bla.csv", "yes.csv")
	List<String> tempJsonNames = List.of("something.json", "foo3.json")

	@AfterEach
	def void resetFiles() {
		val foo3Content = '''
			f1,f2,f3
			v1,v2,v3
			v1,v7,v3
		'''
		val File foo3 = new File("foo3.csv");
		val FileWriter f3 = new FileWriter(foo3, false);
		f3.write(foo3Content);
		f3.close();

		for (String filename : tempCsvNames) {
			val file = new File(filename);
			file.delete()
		}

		for (String filename : tempJsonNames) {
			val file = new File(filename);
			file.delete()
		}

	}

	def String getFileContent(String filename) {
		val content = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
		return content.join("\n")
	}

	@Test
	def void saveToOtherCsv() {
		val filename = tempCsvNames.get(0)
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			save
				:csv "«filename»"
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
		f1,f2,f3
		v1,v2,v3
		v1,v7,v3
		v8,v0,v5'''
		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)

		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}

	@Test
	def void saveToSameCsv() {
		val filename = "foo3.csv"
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			save
				:csv
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
		f1,f2,f3
		v1,v2,v3
		v1,v7,v3
		v8,v0,v5'''
		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)

		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}

	@Test
	def void saveToJsonFile() {
		val filename = tempJsonNames.get(0)
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			save
				:json "«filename»"
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
		{"f1":{"0":"v1","1":"v1","2":"v8"},"f2":{"0":"v2","1":"v7","2":"v0"},"f3":{"0":"v3","1":"v3","2":"v5"}}'''
		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)

		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}

	@Test
	def void saveToJsonNoFilename() {
		val filename = tempJsonNames.get(1)
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			save
				:json
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
		{"f1":{"0":"v1","1":"v1","2":"v8"},"f2":{"0":"v2","1":"v7","2":"v0"},"f3":{"0":"v3","1":"v3","2":"v5"}}'''
		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)

		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}

	@Test
	def void saveToCsvWithDashSeparator() {
		val filename = "foo3.csv"
		val parseTree = parseHelper.parse('''
			using "foo3.csv" with column names: yes
			insert
				:lines ("v8", "v0", "v5")
			save
				:csv
				:separator "-"
		''')
		parseTree.assertNoErrors

		val expectedResult = '''
		f1-f2-f3
		v1-v2-v3
		v1-v7-v3
		v8-v0-v5'''
		val result = interpret(parseTree)
		Assertions.assertEquals("", result.output.strip)
		Assertions.assertEquals("", result.getError)

		Assertions.assertEquals(expectedResult, getFileContent(filename))
	}

}
