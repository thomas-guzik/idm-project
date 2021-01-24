package idm.compiler.bash

import idm.qsv.BinCond
import idm.qsv.OpComp
import idm.qsv.CompareEqual
import idm.qsv.CompareNotEqual
import idm.qsv.CompareLower
import idm.qsv.CompareGreater
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareGreaterOrEqual
import idm.analyzer.ValueType
import idm.analyzer.BinCondAnalyzer

class BinCondBashCompiler {

	BinCond binCond
	BinCondAnalyzer analyzer

	new(BinCond b) {
		binCond = b
		analyzer = new BinCondAnalyzer(binCond)
		
	}

	def String genBashCode() {
		return '''${c[$loc_«analyzer.columnId»]} «binCond.operator.genCodeOperator(analyzer.valueType)» «genCodeValue»'''
	}

	def dispatch genCodeOperator(OpComp op, ValueType t) {}

	def dispatch genCodeOperator(CompareEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-eq"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return "="
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareNotEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-ne"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return "!="
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLower op, ValueType t) {
		if (t === ValueType.INT) {
			return "-lt"
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreater op, ValueType t) {
		if (t === ValueType.INT) {
			return "-gt"
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLowerOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-le"
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreaterOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return "-ge"
		} else if (t == ValueType.VAR) {
			return genCodeOperatorForVar()
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}
	
	def dispatch genOperatorString(OpComp op) {}
	
	def dispatch genOperatorString(CompareEqual op) {
		return "eq"
	}
	
	def dispatch genOperatorString(CompareNotEqual op) {
		return "ne"
	}
	
	def dispatch genOperatorString(CompareLower op) {
		return "lt"
	}
	
	def dispatch genOperatorString(CompareGreater op) {
		return "gt"
	}
	
	def dispatch genOperatorString(CompareLowerOrEqual op) {
		return "le"
	}
	
	def dispatch genOperatorString(CompareGreaterOrEqual op) {
		return "ge"
	}
	
	def genCodeOperatorForVar() {
		return '''$op_«analyzer.value»_«binCond.operator.genOperatorString()»'''
	}
	
	def genCodeValue() {
		if(analyzer.valueType === ValueType.VAR) {
			return '''$v_«analyzer.value»'''
		} else if (analyzer.valueType === ValueType.COL) {
			throw new Exception("Can not used a column in a condition")
		} else {
			return '''«analyzer.value»'''
		}
	}
}
