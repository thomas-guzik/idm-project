package idm.analyzer

import idm.qsv.Value
import idm.qsv.VariableIdentifier
import idm.qsv.BooleanValue
import idm.qsv.StringValue
import idm.qsv.IntegerValue



class AnalyzerValue {
enum ValueType2 {
	INT,
	STRING,
	BOOL,
	VAR
}
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
		return v.value
	}

	def getValueType() {
		return v.getValueType()
	}

	def dispatch getValueType(Value v) {}

	def dispatch getValueType(IntegerValue v) {
		return ValueType2.INT
	}

	def dispatch getValueType(StringValue v) {
		return ValueType2.STRING
	}

	def dispatch getValueType(BooleanValue v) {
		return ValueType2.BOOL
	}

	def dispatch getValueType(VariableIdentifier v) {
		return ValueType2.VAR
	}

}
