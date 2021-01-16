package idm.compiler.bash

import idm.qsv.BinCond
import idm.analyzer.AnalyzerBinCond
import idm.qsv.OpComp
import idm.qsv.CompareEqual
import idm.qsv.CompareNotEqual
import idm.qsv.CompareLower
import idm.qsv.CompareGreater
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareGreaterOrEqual
import idm.analyzer.AnalyzerValue.ValueType

class CompilerBashBinCond {

	BinCond binCond
	AnalyzerBinCond analyzer

	new(BinCond b) {
		binCond = b
		analyzer = new AnalyzerBinCond(binCond)
	}

	def String genBashCode() {
		return '''${c[$loc_«analyzer.columnId»]} «genCodeOperator(analyzer.operator, analyzer.valueType)» «analyzer.value»'''
	}

	def dispatch genCodeOperator(OpComp op, ValueType t) {}

	def dispatch genCodeOperator(CompareEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-eq"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return "="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareNotEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-ne"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return "!="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLower op, ValueType t) {
		if (t === ValueType.INT) {
			return "-lt"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreater op, ValueType t) {
		if (t === ValueType.INT) {
			return "-gt"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLowerOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-le"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreaterOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-ge"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}
}
