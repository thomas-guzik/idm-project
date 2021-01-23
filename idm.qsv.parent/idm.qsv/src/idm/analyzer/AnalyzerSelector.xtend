package idm.analyzer

import idm.qsv.Selector
import java.util.List
import java.util.Set
import idm.qsv.Lines

class AnalyzerSelector {
	
	Selector selector
	
	Boolean withCondition
	ColumnSelectType colSelectType
	List<String> colSelected
	Set<String> colNameInCond
	Set<String> colNumberInCond
	
	new (Selector s) {
		selector = s
		
		colSelectType = ColumnSelectType.ALL
		colSelected = newArrayList
		withCondition = false
		analyze()
	}
	
	def analyze()  {
		var columnSelection = selector.getColumnSelection()

		if (columnSelection !== null) {
			if (columnSelection.columns !== null) {
				var analyzerColumn = new ColumnAnalyzer(columnSelection.columns)
				colSelected = analyzerColumn.columnsList
				colSelectType = analyzerColumn.columnSelectType
			}
		}

		if (selector.lineSelection !== null) {
			selector.lineSelection.analyze()
			withCondition = true
		}	
	}
	
	def void analyze(Lines l) {
		if (l.cond !== null) {
			println("analyze cond")
			var analyzerCond = new ConditionAnalyzer(l.cond)
			println("fin analyze cond")
			colNameInCond = analyzerCond.colSelectedByName
			colNumberInCond = analyzerCond.colSelectedByNumber
		}
	}
	
	def getColSelectType() {
		return colSelectType
	}
	
	def getColSelected() {
		return colSelected
	}

	def Boolean isWithCondition() {
		return withCondition
	}
	
	def getColNameInCondition() {
		return colNameInCond
	}
	
	def getColNumberInCondition() {
		return colNumberInCond
	}
}