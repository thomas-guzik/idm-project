package idm.analyzer

import idm.qsv.Value
import idm.qsv.VariableIdentifier
import idm.qsv.BooleanValue
import idm.qsv.StringValue
import idm.qsv.IntegerValue
import idm.compiler.bash.BashCompilerHelper

enum ValueType {
	INT,
	STRING,
	BOOL,
	COL,
	VAR

}

class ValueAnalyzer {
	Value v

	new(Value v) {
		this.v = v
	}

	def getValue() {
		return v.getValue()
	}

	def dispatch getValue(Value v) {}

	def dispatch getValue(IntegerValue v) { return '''«v.value»''' }

	def dispatch getValue(StringValue v) { return v.value }

	def dispatch getValue(BooleanValue v) { return v.truthy ? "1" : "0" }

	def dispatch getValue(VariableIdentifier v) {
		return '''«v.value.substring(1)»'''
	}

	def getValueType() {
		return v.getValueType()
	}

	def dispatch getValueType(Value v) {}

	def dispatch getValueType(IntegerValue v) {
		return ValueType.INT
	}

	def dispatch getValueType(StringValue v) {
		return ValueType.STRING
	}

	def dispatch getValueType(BooleanValue v) {
		return ValueType.BOOL
	}

	def dispatch getValueType(VariableIdentifier v) {
		return BashCompilerHelper.getVariableType(this.getValue(v))
	}

}
