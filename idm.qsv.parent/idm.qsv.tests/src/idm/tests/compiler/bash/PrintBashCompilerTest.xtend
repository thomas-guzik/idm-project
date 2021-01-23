package idm.tests.compiler.bash

/*
 * generated by Xtext 2.23.0
 */
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
class PrintBashCompilerTest {
	@Inject
	ParseHelper<QuerySeparatedValues> parseHelper

	@Test
	def void printWithoutColumnName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
			1	v1	v2	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
		
	}

	@Test
	def void printWithColumnName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print
		''')
		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printFirstLineWithoutColumnName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :lines #0
		''')
		val expectedResult = '''
				0	1	2
			0	f1	f2	f3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printFirstLineWithColumnName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print :lines #0
		''')
		val expectedResult = '''
				f1	f2	f3
			0	v1	v2	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void selectRangeLine() {
		val result = parseHelper.parse('''
			using "foo2.csv" with column names: no
			print :lines #1-2
		''')
		val expectedResult = '''
				0	1	2
			1	v1	v2	v3
			2	v1	v7	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		println(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void selectColumnWithOneNumber() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :columns #0
		''')
		val expectedResult = '''
				0
			0	f1
			1	v1
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void selectColumnWithMultipleNumber() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: no
			print :columns #2,#0
		''')
		val expectedResult = '''
				0	2
			0	f1	f3
			1	v1	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void selectColumnWithOneName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print :columns f1
		''')
		val expectedResult = '''
				f1
			0	v1
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void selectColumnWithMultipleName() {
		val result = parseHelper.parse('''
			using "foo1.csv" with column names: yes
			print :columns f1,f3
		''')
		val expectedResult = '''
				f1	f3
			0	v1	v3
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionEqualInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines d = 1
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionNotEqualInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines d != 1
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	5	6	7
			2	3	9	1	0
			3	1	4	2	8
			4	6	5	3	4
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionGtInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines c > 3
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	5	6	7
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionGeInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines c >= 3
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	5	6	7
			4	6	5	3	4
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionLtInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines b < 4
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionLeInt() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines b <= 4
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionAnd() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines a = 1 and c = 2
		''')
		val expectedResult = '''
				a	b	c	d
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionOr() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines a = 0 or d = 0
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	5	6	7
			2	3	9	1	0
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionVerifyPriorityOfOpertor() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines a = 1 or b = 4 and d = 8
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionParentheses() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines ( a = 1 or b = 4 ) and d = 8
		''')
		val expectedResult = '''
				a	b	c	d
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithSelectLine() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines #3 a = 1
		''')
		val expectedResult = '''
				a	b	c	d
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		println(code)
		val execution = cmpBash.run(code)
		println(execution.output)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNumber() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :lines #0 = 1
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			3	1	4	2	8
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNameWithSelectColumnName() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :columns a,b,c :lines a = 1
		''')
		val expectedResult = '''
				a	b	c
			0	1	1	1
			3	1	4	2
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNameWithSelectLineNumber() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :columns #0,#1,#2 :lines a = 1
		''')
		val expectedResult = '''
				a	b	c
			0	1	1	1
			3	1	4	2
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNumberWithSelectLineName() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :columns a,b,c :lines #0 = 1
		''')
		val expectedResult = '''
				a	b	c
			0	1	1	1
			3	1	4	2
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNumberWithSelectLineNumber() {
		val result = parseHelper.parse('''
			using "nb_with_header.csv" with column names: yes
			print :columns #0,#1,#2 :lines #0 = 1
		''')
		val expectedResult = '''
				a	b	c
			0	1	1	1
			3	1	4	2
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionWithNumberWithSelectLineNumberNoHeader() {
		val result = parseHelper.parse('''
			using "nb_no_header.csv" with column names: no
			print :columns #0,#1,#2 :lines #0 = 1
		''')
		val expectedResult = '''
				0	1	2
			0	1	1	1
			3	1	4	2
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionEqualBetwStr() {
		val result = parseHelper.parse('''
			using "str_with_header.csv" with column names: yes
			print :lines d = "f"
		''')
		val expectedResult = '''
				a	b	c	d
			0	f	f	f	f
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionNotEqualBetwStr() {
		val result = parseHelper.parse('''
			using "str_with_header.csv" with column names: yes
			print :lines d != "f"
		''')
		val expectedResult = '''
				a	b	c	d
			1	e	j	k	l
			2	h	n	f	e
			3	f	i	g	m
			4	k	j	h	i
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionBoolYes() {
		val result = parseHelper.parse('''
			using "bool_with_header.csv" with column names: yes
			print :lines a = yes
		''')
		val expectedResult = '''
				a	b	c	d
			0	1	1	1	1
			2	1	1	1	0
			3	1	0	0	0
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}

	@Test
	def void printConditionBoolNo() {
		val result = parseHelper.parse('''
			using "bool_with_header.csv" with column names: yes
			print :lines a = no
		''')
		val expectedResult = '''
				a	b	c	d
			1	0	1	0	1
			4	0	1	1	0
		'''
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		println(errors)
		val QsvBashCompiler cmpBash = new QsvBashCompiler(result)
		val code = cmpBash.compile()
		val execution = cmpBash.run(code)
		Assertions.assertEquals(expectedResult, execution.output)
		Assertions.assertEquals("", execution.error)
	}
}
