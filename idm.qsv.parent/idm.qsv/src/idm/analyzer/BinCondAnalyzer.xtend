package idm.analyzer

import idm.qsv.BinCond

class BinCondAnalyzer {

	BinCond binCond
	ValueAnalyzer analyzerValue
	ColumnIdentifierAnalyzer analyzerColumnIdentifier

	new(BinCond b) {
		binCond = b
		analyzerColumnIdentifier = new ColumnIdentifierAnalyzer(binCond.columnId)
		analyzerValue = new ValueAnalyzer(binCond.compValue)
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
