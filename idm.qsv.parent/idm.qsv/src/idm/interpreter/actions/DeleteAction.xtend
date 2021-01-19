package idm.interpreter.actions

import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Delete
import idm.qsv.Lines

class DeleteAction implements Action {

	CsvData csvData
	Delete delete

	extension LineFilters lineFiltering
	extension ConcreteValues values

	new(Delete d, CsvData data) {
		delete = d
		csvData = data
		lineFiltering = new LineFilters(csvData)
		values = new ConcreteValues
	}

	override interpret() {
		var deleteAll = true
		var deleteAllLines = false
		var deleteAllColumns = false
		if (delete.selector !== null) {
			deleteAll = false
			val Lines lineSelection = delete.selector.lineSelection
			if (lineSelection !== null) {
				deleteAllLines = lineSelection.cond === null
				if (!deleteAllLines) {
					lineSelection.select()
				}
			}
			val Columns columnSelection = delete.selector.columnSelection
			if (columnSelection !== null) {
				deleteAllColumns = columnSelection.columns === null
				if (!deleteAllColumns) {
					columnSelection.select()
				}
			}
		}
		if (deleteAll) {
			csvData.deleteAllData
		}
		if (deleteAllLines) {
			csvData.deleteAllLines()
		}
		if (deleteAllColumns) {
			csvData.deleteAllData

		}
		csvData.resetFilters
		return ""
	}

	private def select(Columns selection) {
		var columnNames = selection.columns.names
		for (String columnName : columnNames) {
			csvData.deleteColumn(columnName)
		}
	}

	private def select(Lines selection) {
		var Condition condition = selection.cond
		if (condition !== null) {
			condition.createFilter()
			csvData.deleteSelectedLines
		}
	}

}
