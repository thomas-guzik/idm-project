package idm.analyzer

import idm.qsv.Compute
import idm.qsv.Function
import java.util.HashSet
import idm.qsv.SumColumns
import idm.qsv.ColumnIdentifier
import idm.qsv.SumValuesInColumn

enum FunctionName {
	SUMLINES,
	SUMCOL
}

class ComputeAnalyzer {
	
	Compute c
	HashSet<String> colName = new HashSet<String>()
	HashSet<String> colNumber = new HashSet<String>()
	FunctionName functionName
	String variable
	
	new(Compute c) {
		this.c = c
		this.c.analyze()
	}
		
	def analyze(Compute c) {
		variable = new ValueAnalyzer(c.variable).getValue()
		c.function.analyzeFunction()
	}
	
	def dispatch analyzeFunction(Function f) {}
	
	def dispatch analyzeFunction(SumValuesInColumn f) {
		addToTheGoodColumns(f.column)
		functionName = FunctionName.SUMLINES
	}
	
	def dispatch analyzeFunction(SumColumns f) {
		for(c : f.columns) {
			addToTheGoodColumns(c)
		}
		functionName = FunctionName.SUMCOL
	}
	
	def addToTheGoodColumns(ColumnIdentifier c) {
		var analyzer = new ColumnIdentifierAnalyzer(c)
		if(analyzer.columnIdentifierType === ColumnIdentifierType.NAME) {			
			colName.add(analyzer.columnIdentifier)
		} else {
			colNumber.add(analyzer.columnIdentifier)
		}	
	}
	
	def getFunctionName() {
		return functionName
	}
	
	def getColumnsName() {
		return colName
	}
	
	def getColumnsNumber() {
		return colNumber
	}
	
	def getVariableName()  {
		return variable
	}
}