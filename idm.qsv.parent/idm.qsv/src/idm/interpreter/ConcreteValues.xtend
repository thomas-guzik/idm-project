package idm.interpreter

import idm.compiler.python.MissingConcreteImplementationException
import idm.qsv.BooleanValue
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

	def dispatch String getColumnId(ColumnIdentifier id) {
		throw new MissingConcreteImplementationException("ColumnIdentifier")
	}

	def dispatch String getColumnId(ColumnNameIdentifier id) {
		return id.value
	}

	def dispatch String getColumnId(ColumnNumberIdentifier id) {
		return id.value.replaceAll("[^0-9.]", "")
	}

	def dispatch String getValue(VariableIdentifier id) {
		return id.value.substring(1)
	}

	def dispatch Object getValue(Value value) {
		throw new MissingConcreteImplementationException("Value")
	}

	def dispatch Object getValue(IntegerValue integer) {
		return integer.value
	}

	def dispatch Object getValue(BooleanValue bool) {
		return bool.truthy ? 1 : 0
	}

	def dispatch Object getValue(StringValue string) {
		return string.value
	}

	def dispatch (Object, Object)=>boolean getOperator(OpComp operator) {
		throw new MissingConcreteImplementationException("OpComp")
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareEqual equal) {
		return [Object a, Object b|a == b]
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareNotEqual notEqual) {
		return [Object a, Object b|a !== b]
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareLower lower) {
		return [ Object a, Object b |
			if (a.class == Integer && b.class == Integer) {
				return (a as Integer) < (b as Integer)
			}
			throw new IllegalArgumentException
		]
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareGreater greater) {
		return [ Object a, Object b |
			if (a.class == Integer && b.class == Integer) {
				return (a as Integer) > (b as Integer)
			}
			throw new IllegalArgumentException
		]
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareLowerOrEqual lowerOrEqual) {
		return [ Object a, Object b |
			if (a.class == Integer && b.class == Integer) {
				return (a as Integer) <= (b as Integer)
			}
			throw new IllegalArgumentException
		]
	}

	def dispatch (Object, Object)=>boolean getOperator(CompareGreaterOrEqual greaterOrEqual) {
		return [ Object a, Object b |
			if (a.class == Integer && b.class == Integer) {
				return (a as Integer) >= (b as Integer)
			}
			throw new IllegalArgumentException
		]
	}

	def dispatch getRowContent(ContentDescription contentDescription) {
		throw new MissingConcreteImplementationException("ContentDescription")
	}

	def dispatch getRowContent(ContentList contentList) {
		return contentList.values.map[v|v.value]
	}

	def dispatch getRowContent(VariableIdentifier id) {
		return QsvXtendInterpreter.getValue(id.value)
	}

	def dispatch List<String> getNames(Column column) {
		throw new MissingConcreteImplementationException("Column")
	}

	def dispatch List<String> getNames(ColumnNames names) {
		return names.names.toList
	}

	def dispatch List<String> getNames(ColumnNumbers numbers) {
		return numbers.numbers.toList.map[n|n.replaceAll("[^0-9.]", "")]
	}
}
