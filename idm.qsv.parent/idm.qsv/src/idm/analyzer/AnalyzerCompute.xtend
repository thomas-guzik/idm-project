package idm.analyzer

import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumLines
import java.util.Set
import java.util.HashSet
import idm.qsv.SumColumns
import idm.qsv.ColumnIdentifier

class AnalyzerCompute {
	
	Compute c
	HashSet<String> colName = new HashSet<String>()
	HashSet<String> colNumber = new HashSet<String>()
	
	new(Compute c) {
		this.c = c
	}
	
	def analyze() {
		c.analyze()
	}
	
	def analyze(Compute c) {
		c.function.analyzeFunction()
	}
	
	def dispatch analyzeFunction(Function f) {}
	
	def dispatch analyzeFunction(SumLines f) {
		addToTheGoodColumns(f.column)
	}
	
	def dispatch analyzeFunction(SumColumns f) {
		for(c : f.columns) {
			addToTheGoodColumns(c)
		}
	}
	
	def addToTheGoodColumns(ColumnIdentifier c) {
		var analyzer = new AnalyzerColumnIdentifier(c)
		if(analyzer.columnIdentifierType === ColumnIdentifierType.NAME) {			
			colName.add(analyzer.columnIdentifier)
		} else {
			colNumber.add(analyzer.columnIdentifier)
		}	
	}
	
	def getColumnsName() {
		return colName
	}
	
	def getColumnsNumber() {
		return colNumber
	}
}