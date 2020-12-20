/*
 * generated by Xtext 2.23.0
 */
package idm.tests

import com.google.inject.Inject
import idm.compiler.python.PythonCompiler
import idm.qsv.QuerySeparatedValues
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(QsvInjectorProvider)
class QsvPythonCompilerTests {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void printWithHeader() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print
		''')
		val expectedResult = '''
			   f1  f2  f3
			0  v1  v2  v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printWithoutHeader() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print
		''')
		val expectedResult = '''
			    0   1   2
			0  f1  f2  f3
			1  v1  v2  v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printAllLinesAndColumns() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:lines
				:columns
		''')
		val expectedResult = '''
			   f1  f2  f3
			0  v1  v2  v3
			1  v1  v7  v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printAllColumnsAndLines() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns
				:lines
		''')
		val expectedResult = '''
			   f1  f2  f3
			0  v1  v2  v3
			1  v1  v7  v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printColumnsWithSingleSelection() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f2
		''')
		val expectedResult = '''
			   f2
			0  v2
			1  v7
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printColumnsWithSingleSelectionAllLines() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f2
				:lines
		''')
		val expectedResult = '''
			   f2
			0  v2
			1  v7
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}

	@Test
	def void printColumnsWithMultipleSelectionKeepsOrder() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: yes
			print
				:columns f3, f1
		''')
		val expectedResult = '''
			   f3  f1
			0  v3  v1
			1  v3  v1
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		val PythonCompiler cmpPython = new PythonCompiler(result)
		val outputResult = cmpPython.compileAndRun
		Assertions.assertEquals(expectedResult, outputResult.getOutput)
		Assertions.assertEquals("", outputResult.getError)
	}
}
