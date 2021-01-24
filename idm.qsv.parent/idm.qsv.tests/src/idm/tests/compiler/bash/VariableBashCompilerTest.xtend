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
class VariableBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void sumValuesInColumnAndConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b = $dix
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	10	v	vvvv
			2	3	10	v	w
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
	def void sumValuesInColumnAndConditionNonEqua() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b != $dix
		''')
		val expectedResult = '''
				a	b	c	d
			1	2	9	v	10
			3	4	11	v	0
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
	def void sumValuesInColumnAndConditionGreater() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b > $dix
		''')
		val expectedResult = '''
				a	b	c	d
			3	4	11	v	0
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
	def void sumValuesInColumnAndConditionLess() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b < $dix
		''')
		val expectedResult = '''
				a	b	c	d
			1	2	9	v	10
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
	def void sumValuesInColumnAndConditionGreaterEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b >= $dix
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	10	v	vvvv
			2	3	10	v	w
			3	4	11	v	0
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
	def void sumValuesInColumnAndConditonLessEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			print :lines b <= $dix
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	10	v	vvvv
			1	2	9	v	10
			2	3	10	v	w
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
	def void sumValuesInColumnAndConditonEqualString() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $v
				:sumValuesInColumn c
			print :lines d = $v
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	10	v	vvvv
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
	def void sumValuesInColumnAndConditonNotEqualString() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $v
				:sumValuesInColumn c
			print :lines d != $v
		''')
		val expectedResult = '''
				a	b	c	d
			1	2	9	v	10
			2	3	10	v	w
			3	4	11	v	0
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
	def void sumValuesInColumnAndDeleteConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			delete :lines b = $dix
			print
		''')
		val expectedResult = '''
				a	b	c	d
			0	2	9	v	10
			1	4	11	v	0
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
	def void sumValuesInColumnAndUpdateConditionEqual() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			update :set $dix :columns a
			print
		''')
		val expectedResult = '''
				a	b	c	d
			0	10	10	v	vvvv
			1	10	9	v	10
			2	10	10	v	w
			3	10	11	v	0
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
	def void sumValuesInColumnAndInsertLine() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			insert :lines ($dix,$dix,$dix,$dix)
			print
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	10	v	vvvv
			1	2	9	v	10
			2	3	10	v	w
			3	4	11	v	0
			4	10	10	10	10
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
	def void sumValuesInColumnAndInsertColumns() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $dix
				:sumValuesInColumn a
			insert :columns e ($dix,$dix,$dix,$dix)
			print
		''')
		val expectedResult = '''
				a	b	c	d	e
			0	1	10	v	vvvv	10
			1	2	9	v	10	10
			2	3	10	v	w	10
			3	4	11	v	0	10
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
	def void sumColumnsAndInsertColumnsFromVar() {
		val parseTree = parseHelper.parse('''
			using "test_variable.csv" with column names: yes
			compute $col
				:sumColumns a
			insert :columns e $col
			print
		''')
		val expectedResult = '''
				a	b	c	d	e
			0	1	10	v	vvvv	1
			1	2	9	v	10	2
			2	3	10	v	w	3
			3	4	11	v	0	4
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
