package idm.compiler.bash

import idm.qsv.Condition
import idm.qsv.MidPriority
import idm.qsv.HighestPriority
import idm.analyzer.ValueType
import idm.analyzer.ConditionAnalyzer

class ConditionBashCompiler {

	Condition condition
	ConditionAnalyzer analyzer

	new(Condition c) {
		condition = c
		analyzer = new ConditionAnalyzer(condition)
	}

	def getColSelectedByNumber() {
		return analyzer.colSelectedByNumber
	}

	def getColSelectedByName() {
		return analyzer.colSelectedByName
	}

	def genBashCondition() {
		return condition.genCode()
	}

	def String genCode(Condition cond) {
		var code = cond.mid.genCode()
		if (cond.orCondition !== null) {
			code += " || " + cond.orCondition.genCode()
		}
		return code
	}

	def String genCode(MidPriority mid) {
		var code = mid.high.genCode()
		if (mid.andCondition !== null) {
			code += " && " + mid.andCondition.genCode()
		}
		return code
	}

	def String genCode(HighestPriority high) {
		if (high.baseCondition !== null) {
			var binCondGen = new BinCondBashCompiler(high.baseCondition)
			return binCondGen.genBashCode()
		} else if (high.nestedCondition !== null) {
			return ''' ( «high.nestedCondition.genCode()» )'''
		} else {
			throw new Exception("Error during conditions analyzing")
		}
	}
	
	def genBeforeCondition() {
		println("deb before Cond")
		var code = ''''''
		for(varWithOp : analyzer.variableWithOperator) {
			println("boucle")
			var v = varWithOp.getKey()
			var op = new OpCompBashCompiler(varWithOp.getValue(), "")
			var opString = op.genOperatorString()
			if(opString === "eq" || opString === "ne") {
				code += '''
				if [[ $v_«v.value» =~ ^[0-9]+$ ]] ; then
				op_«v.value»_«opString»="«op.genCodeOperator(ValueType.INT)»"
				else
				op_«v.value»_«opString»="«op.genCodeOperator(ValueType.STRING)»"
				fi
				'''
			}
			else {
				code += '''
				op_«v.value»_«opString»="«op.genCodeOperator(ValueType.INT)»"
				'''
			}
		}
		println("fin before cond")
		return code
	}
}
