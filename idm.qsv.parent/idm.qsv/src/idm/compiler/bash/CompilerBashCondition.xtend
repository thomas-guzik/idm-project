package idm.compiler.bash

import idm.qsv.Condition
import idm.analyzer.AnalyzerCondition
import idm.qsv.MidPriority
import idm.qsv.HighestPriority

class CompilerBashCondition {

	Condition condition
	AnalyzerCondition analyzer

	new(Condition c) {
		condition = c
		analyzer = new AnalyzerCondition(condition)
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
			var binCondGen = new CompilerBashBinCond(high.baseCondition)
			return binCondGen.genBashCode()
		} else if (high.nestedCondition !== null) {
			return ''' ( «high.nestedCondition.genCode()» )'''
		} else {
			throw new Exception("Error during conditions analyzing")
		}
	}
	
	def genBeforeConditon() {
		return '''
		«FOR varWithOp : analyzer.variableWithOperator»
		«var v = varWithOp.getKey()»
		«var op = new CompilerBashOpComp(varWithOp.getValue(), "")»
		if [ $v_«v.value» ] ; then
		op_«v.value»_«op.genOperatorString()»="«op.genCodeOperator(v.valueType)»"
		else
		op_«v.value»_«op.genOperatorString()»="«op.genCodeOperator(v.valueType)»"
		fi
		«ENDFOR»
		'''
	}
}
