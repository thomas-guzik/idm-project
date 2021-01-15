package idm.analyzer

import idm.qsv.BinCond

class AnalyzerBinCond {

	BinCond binCond
	AnalyzerValue analyzerValue
	AnalyzerColumnIdentifier analyzerColumnIdentifier

	new(BinCond b) {
		binCond = b
		analyzerColumnIdentifier = new AnalyzerColumnIdentifier(binCond.columnId)
		analyzerValue = new AnalyzerValue(binCond.compValue)
	}

	def getColumnId() {
		analyzerColumnIdentifier.getColumnIdentifier()
	}

	def getColumnIdType() {
		analyzerColumnIdentifier.getColumnIdentifierType()
	}

	def getValue() {
		analyzerValue.getValue()
	}

	def getValueType() {
		analyzerValue.getValueType()
	}

	def getOperator() {
		return binCond.operator
	}
}
