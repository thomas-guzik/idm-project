package idm.analyzer

import idm.qsv.Column
import java.util.ArrayList
import java.util.List
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers

class ColumnAnalyzer {
	
	Column columns
	List<String> cols
	
	new (Column c) {
		columns = c
		cols = new ArrayList<String>()
	}
	
	def getColumnSelectType() {
		return columns.getColumnSelectType()
	}
	
	def dispatch getColumnSelectType(Column c) {}
	
	def dispatch getColumnSelectType(ColumnNames c) {
		return ColumnSelectType.NAME
	}
	
	def dispatch getColumnSelectType(ColumnNumbers c) {
		return ColumnSelectType.NUMBER
	}
	
	def getColumnsList() {
		return columns.getColumnsList()
	}
	
	def dispatch getColumnsList(Column c) {}
	
	def dispatch getColumnsList(ColumnNames c) {
		c.names.forEach[n|cols.add(n)]
		return cols
	}
	
	def dispatch getColumnsList(ColumnNumbers c) {
		c.numbers.forEach[n|cols.add(n.substring(1))]
		return cols
	}
	
}