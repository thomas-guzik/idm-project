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
import idm.analyzer.AnalyzerValue.ValueType2

class CompilerBashBinCond {

	BinCond binCond
	AnalyzerBinCond analyzer

	new(BinCond b) {
		binCond = b
		analyzer = new AnalyzerBinCond(binCond)
	}

	def String genBashCode() {
		return '''«analyzer.columnId» «genCodeOperator(analyzer.operator, analyzer.valueType)» «analyzer.value»'''
	}

	def dispatch genCodeOperator(OpComp op, ValueType2 t) {}

	def dispatch genCodeOperator(CompareEqual op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-eq"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			return "="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareNotEqual op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-ne"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			return "!="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLower op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-lt"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			throw new Exception("Only integer can be compare with lower operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreater op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-gt"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			throw new Exception("Only integer can be compare with greater operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLowerOrEqual op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-le"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			throw new Exception("Only integer can be compare with lower or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreaterOrEqual op, ValueType2 t) {
		if (t === ValueType2.INT) {
			return "-ge"
		} else if (t === ValueType2.STRING || t === ValueType2.BOOL) {
			throw new Exception("Only integer can be compare with greater or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}
}
