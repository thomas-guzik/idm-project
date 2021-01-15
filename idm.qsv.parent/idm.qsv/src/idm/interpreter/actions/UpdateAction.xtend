package idm.interpreter.actions

import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Lines
import idm.qsv.Update

class UpdateAction implements Action {

	CsvData csvData
	Update update

	extension LineFilters lineFiltering
	extension ConcreteValues values

	new(Update u, CsvData data) {
		update = u
		csvData = data
		lineFiltering = new LineFilters(csvData)
		values = new ConcreteValues
	}

	override interpret() {
		val value = update.value.value
		val columns = update.columns.names
		if (update.cond !== null) {
			update.cond.createFilter

		}
		for (String column : columns) {
			csvData.update(column, value)
		}
		csvData.resetFilters
		return ""
	}

}
