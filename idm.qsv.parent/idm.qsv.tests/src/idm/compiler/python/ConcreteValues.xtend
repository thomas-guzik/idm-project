package idm.compiler.python

import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.CompareEqual
import idm.qsv.CompareGreater
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.CompareLower
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareNotEqual
import idm.qsv.IntegerValue
import idm.qsv.OpComp
import idm.qsv.StringValue
import idm.qsv.Value
import java.util.List

class ConcreteValues {
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
		throw new MissingConcreteImplementationException("Column")
	}

	def dispatch List<String> getPythonNames(ColumnNames names) {
		return names.names.toList.map[n|'''"«n»"''']
	}

	def dispatch List<String> getPythonNames(ColumnNumbers numbers) {
		return numbers.numbers.toList.map[n|n.replaceAll("[^0-9.]", "")]
	}
}
