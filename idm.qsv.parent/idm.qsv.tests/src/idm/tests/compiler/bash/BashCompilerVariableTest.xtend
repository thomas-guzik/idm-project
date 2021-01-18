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
class BashCompilerVariableTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void sumLinesAndConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b = $dix
		''')
		val expectedResult = '''
			  a b c d
			0 1 10 v vvvv
			2 3 10 v w
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditionNonEqua() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b != $dix
		''')
		val expectedResult = '''
			  a b c d
			1 2 9 v 10
			3 4 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditionGreater() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b > $dix
		''')
		val expectedResult = '''
			  a b c d
			3 4 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("**************")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditionLess() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b < $dix
		''')
		val expectedResult = '''
			  a b c d
			1 2 9 v 10
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("***")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditionGreaterEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b >= $dix
		''')
		val expectedResult = '''
			  a b c d
			0 1 10 v vvvv
			2 3 10 v w
			3 4 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditonLessEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			print :lines b <= $dix
		''')
		val expectedResult = '''
			  a b c d
			0 1 10 v vvvv
			1 2 9 v 10
			2 3 10 v w
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("********")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditonEqualString() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $v
				:sumLines c
			print :lines d = $v
		''')
		val expectedResult = '''
			  a b c d
			0 1 10 v vvvv
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("********")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndConditonNotEqualString() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $v
				:sumLines c
			print :lines d != $v
		''')
		val expectedResult = '''
			  a b c d
			1 2 9 v 10
			2 3 10 v w
			3 4 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("********")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndDeleteConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			delete :lines b = $dix
			print
		''')
		val expectedResult = '''
			  a b c d
			0 2 9 v 10
			1 4 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("****")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}

	@Test
	def void sumLinesAndUpdateConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			update :set $dix :columns a
			print
		''')
		val expectedResult = '''
			  a b c d
			0 10 10 v vvvv
			1 10 9 v 10
			2 10 10 v w
			3 10 11 v 0
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("********")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
		@Test
	def void sumLinesAndInsertLine() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			insert :lines ($dix,$dix,$dix,$dix)
			print
		''')
		val expectedResult = '''
			  a b c d
			0 1 10 v vvvv
			1 2 9 v 10
			2 3 10 v w
			3 4 11 v 0
			4 10 10 10 10
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("**********")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
			@Test
	def void sumLinesAndInsertColumns() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumLines a
			insert :columns e ($dix,$dix,$dix,$dix)
			print
		''')
		val expectedResult = '''
			  a b c d e
			0 1 10 v vvvv 10
			1 2 9 v 10 10
			2 3 10 v w 10
			3 4 11 v 0 10
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("************")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
				@Test
	def void sumLinesAndInsertColumnsFromVar() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: no
			compute $col
				:sumColumns a
			insert :columns e $col
			print
		''')
		val expectedResult = '''
			  a b c d e
			0 1 10 v vvvv 1
			1 2 9 v 10 2
			2 3 10 v w 3
			3 4 11 v 0 4
		'''
		Assertions.assertNotNull(parseTree)
		val errors = parseTree.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val CompilerBashQsv cmpBash = new CompilerBashQsv(parseTree)
		val code = cmpBash.compile()
		println("**************")
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
	}
	
	
}
