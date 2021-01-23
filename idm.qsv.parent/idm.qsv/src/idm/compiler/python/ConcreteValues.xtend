package idm.compiler.python

import idm.qsv.Column
import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNameIdentifier
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumberIdentifier
import idm.qsv.ColumnNumbers
import idm.qsv.CompareEqual
import idm.qsv.CompareGreater
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.CompareLower
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareNotEqual
import idm.qsv.ContentDescription
import idm.qsv.ContentList
import idm.qsv.IntegerValue
import idm.qsv.OpComp
import idm.qsv.StringValue
import idm.qsv.Value
import idm.qsv.VariableIdentifier
import java.util.List

class ConcreteValues {

	def dispatch String getPythonColumn(ColumnIdentifier id) {
		throw new MissingConcreteImplementationException("ColumnIdentifier")
	}

	def dispatch String getPythonColumn(ColumnNameIdentifier id) {
		return '''"«id.value»"'''
	}

	def dispatch String getPythonColumn(ColumnNumberIdentifier id) {
		return id.value.replaceAll("[^0-9.]", "")
	}

	def dispatch String getPythonValue(VariableIdentifier id) {
		return "user_" + id.value.substring(1)
	}

	def dispatch String getPythonValue(Value value) {
		throw new MissingConcreteImplementationException("Value")
	}

	def dispatch String getPythonValue(IntegerValue integer) {
		return integer.value + ""
	}

	def dispatch String getPythonValue(StringValue string) {
		return '''"«string.value»"'''
	}

	def dispatch String getPythonOperator(OpComp operator) {
		throw new MissingConcreteImplementationException("OpComp")
	}

	def dispatch String getPythonOperator(CompareEqual equal) {
		return "=="
	}

	def dispatch String getPythonOperator(CompareNotEqual notEqual) {
		return "!="
	}

	def dispatch String getPythonOperator(CompareLower lower) {
		return "<"
	}

	def dispatch String getPythonOperator(CompareGreater greater) {
		return ">"
	}

	def dispatch String getPythonOperator(CompareLowerOrEqual lowerOrEqual) {
		return "<="
	}

	def dispatch String getPythonOperator(CompareGreaterOrEqual greaterOrEqual) {
		return ">="
	}

	def dispatch List<String> getPythonNames(Column column) {
		println(column.class)
		throw new MissingConcreteImplementationException("Column")
	}

	def dispatch List<String> getPythonNames(ColumnNames names) {
		return names.names.toList.map[n|'''"«n»"''']
	}

	def dispatch List<String> getPythonNames(ColumnNumbers numbers) {
		return numbers.numbers.toList.map[n|n.replaceAll("[^0-9.]", "")]
	}

	def dispatch getPythonRowContent(ContentDescription contentDescription) {
		throw new MissingConcreteImplementationException("ContentDescription")
	}

	def dispatch getPythonRowContent(ContentList contentList) {
		return '''[«contentList.values.map[v|v.pythonValue].reduce[v1, v2|'''«v1», «v2»''']»]'''
	}

	def dispatch getPythonRowContent(VariableIdentifier id) {
		return id.pythonValue
	}
}
