package idm.interpreter.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.ColumnDescription
import idm.qsv.ColumnInsertion
import idm.qsv.ContentList
import idm.qsv.Insert
import idm.qsv.Insertion
import idm.qsv.LineInsertion

class InsertAction implements Action {

	CsvData csvData
	Insert insert

	extension LineFilters lineFiltering
	extension ConcreteValues values

	new(Insert i, CsvData data) {
		insert = i
		csvData = data
		lineFiltering = new LineFilters(csvData)
		values = new ConcreteValues
	}

	override interpret() {
		insert.inserted.insert()
		return ""
	}

	private def dispatch insert(Insertion insertion) {
		throw new MissingConcreteImplementationException("Insertion")
	}

	private def dispatch insert(LineInsertion lineInsertion) {
		val insertedLines = lineInsertion.rows
		for (ContentList line : insertedLines) {
			val content = line.rowContent
			csvData.insertLine(content)
		}
	}

	private def dispatch insert(ColumnInsertion columnInsertion) {
		for (ColumnDescription description : columnInsertion.descriptions) {
			val name = description.columnName === null ? null : description.columnName.value
			val content = description.content.rowContent
			csvData.insertColumn(name, content)
		}
	}

}
