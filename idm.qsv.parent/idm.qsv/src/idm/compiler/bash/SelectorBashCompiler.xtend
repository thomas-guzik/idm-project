package idm.compiler.bash

import idm.qsv.Selector
import idm.qsv.Lines
import idm.qsv.LineRange
import idm.qsv.Line
import idm.qsv.Condition
import idm.analyzer.SelectorAnalyzer

class SelectorBashCompiler {

	Selector selector
	
	SelectorAnalyzer analyzer

	new(Selector s) {
		println("selector")
		selector = s
		analyzer = new SelectorAnalyzer(selector)
		println("analyzer")
		println("fin analyze")
	}
	
	def genCond() {
		if (selector.lineSelection !== null) {
			return selector.lineSelection.genCode()
		} else {
			return ""
		}
	}

	def genCode(Lines lines) {
		var code = ""
		if (lines.range !== null) {
			code += lines.range.genCode();
		} else if (lines.line !== null) {
			code += lines.line.genCode();
		}
		if (lines.cond !== null) {
			if (!code.isEmpty) {
				code += " '&&' "
			}
			code += lines.cond.genCode();
		}
		code = code
		return code
	}

	def genCode(LineRange range) {
		return ''' $n -ge «range.start» '&&' $n -le «range.end» '''
	}

	def genCode(Line line) {
		return ''' $n -eq «line.number» '''
	}

	def String genCode(Condition cond) {
		var cmpCondition = new ConditionBashCompiler(cond)
		var code = cmpCondition.genBashCondition()
		return code
	}
	
	def String genBeforeCondition() {
		if(selector.lineSelection !== null && selector.lineSelection.cond !== null) {
			var cmpCondition = new ConditionBashCompiler(selector.lineSelection.cond)
			return cmpCondition.genBeforeCondition()		
		}
		else {
			return ""
		}
	}
	
	def getColSelectType() {
		return analyzer.colSelectType
	}
	
	def getColSelected() {
		return analyzer.colSelected
	}

	def Boolean isWithCondition() {
		return analyzer.withCondition
	}
	
	def getColNameInCondition() {
		return analyzer.colNameInCondition
	}
	
	def getColNumberInCondition() {
		return analyzer.colNumberInCondition
	}

}
