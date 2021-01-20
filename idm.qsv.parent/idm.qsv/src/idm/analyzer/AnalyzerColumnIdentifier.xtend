package idm.analyzer

import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNameIdentifier
import idm.qsv.ColumnNumberIdentifier

enum ColumnIdentifierType {
	NAME,
	NUMBER
}

class AnalyzerColumnIdentifier {
	
	ColumnIdentifier columnIdentifier
	
	new(ColumnIdentifier c) {
		columnIdentifier = c
	}
	
	def getColumnIdentifierType() {
		return columnIdentifier.getColumnIdentifierType()
	}
	
	def dispatch getColumnIdentifierType(ColumnIdentifier c) {}
	
	def dispatch getColumnIdentifierType(ColumnNameIdentifier c) {
		return ColumnIdentifierType.NAME
	}
	
	def dispatch getColumnIdentifierType(ColumnNumberIdentifier c) {
		return ColumnIdentifierType.NUMBER
	}
	
	def getColumnIdentifier() {
		return columnIdentifier.getColumnIdentifier()
	}
	
	def dispatch getColumnIdentifier(ColumnIdentifier c) {}
	
	def dispatch getColumnIdentifier(ColumnNameIdentifier c) {
		return c.value
	}
	
	def dispatch getColumnIdentifier(ColumnNumberIdentifier c) {
		return '''«c.value.substring(1)»'''
	}
	
	
	
}