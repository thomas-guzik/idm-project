package idm.interpreter.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.ConcreteValues
import idm.interpreter.QsvXtendInterpreter
import idm.interpreter.csv.CsvData
import idm.qsv.ColumnDescription
import idm.qsv.ColumnInsertion
import idm.qsv.ContentDescription
import idm.qsv.ContentList
import idm.qsv.Insert
import idm.qsv.Insertion
import idm.qsv.LineInsertion
import idm.qsv.VariableIdentifier
import java.util.List

class InsertAction implements Action {

	CsvData csvData
	Insert insert

	extension ConcreteValues values

	new(Insert i, CsvData data) {
		insert = i
		csvData = data
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
			description.content.insertWithName(name)

		}
	}

	def dispatch void insertWithName(ContentDescription description, String name) {
		throw new MissingConcreteImplementationException("ContentDescription")
	}

	def dispatch void insertWithName(ContentList contentList, String name) {
		csvData.insertColumn(name, contentList.values.map[v|v.value])
	}

	def dispatch void insertWithName(VariableIdentifier id, String name) {
		val otherCsv = QsvXtendInterpreter.getCsv(id.value)
		csvData.insertColumnsFromCsv(List.of(name), otherCsv)
	}

	def dispatch getRowContent(ContentDescription contentDescription) {
		throw new MissingConcreteImplementationException("ContentDescription")
	}

	def dispatch getRowContent(ContentList contentList) {
		return contentList.values.map[v|v.value]
	}

	def dispatch getRowContent(VariableIdentifier id) {
		return List.of()
//		return id.value
	}

}
