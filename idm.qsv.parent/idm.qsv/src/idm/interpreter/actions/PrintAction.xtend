package idm.interpreter.actions

import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Lines
import idm.qsv.Print

class PrintAction implements Action {

	CsvData csvData
	Print print

	extension LineFilters lineFiltering
	extension ConcreteValues values

	new(Print p, CsvData data) {
		print = p
		csvData = data
		lineFiltering = new LineFilters(csvData)
		values = new ConcreteValues
	}

	override interpret() {
		if (print.selector !== null) {
			val Lines lineSelection = print.selector.lineSelection
			if (lineSelection !== null) {
				lineSelection.select()
			}
			val Columns columnSelection = print.selector.columnSelection
			if (columnSelection !== null) {
				columnSelection.select()
			}
		}
		val printed = csvData.toString()
		csvData.resetFilters()
		return printed
	}

	private def select(Columns selection) {
		csvData.selectColumns(selection.columns.names)
	}

	private def select(Lines selection) {
		val Condition condition = selection.cond
//		val Line line = selection.line
//		val LineRange lineRange = selection.range
//		if (line !== null) {
//			val index = line.number
//			code += '''«printVariable» = «printVariable».iloc[[«index»]]'''
//			code += PythonCompiler.NEWLINE
//		}
//		if (lineRange !== null) {
//			val start = lineRange.start
//			val end = lineRange.end
//			code += '''«printVariable» = «printVariable».iloc[range(«start»,«end» + 1)]'''
//			code += PythonCompiler.NEWLINE
//		}
		if (condition !== null) {
			
//			val filter = PythonCompiler.newFilterName
			condition.createFilter()
//			code += '''«printVariable» = «printVariable»[«filter»]'''
//			code += PythonCompiler.NEWLINE
		}
	}

}
