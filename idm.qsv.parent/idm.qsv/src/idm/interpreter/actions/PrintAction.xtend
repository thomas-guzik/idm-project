package idm.interpreter.actions

import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Line
import idm.qsv.LineRange
import idm.qsv.Lines
import idm.qsv.Print
import java.util.List
import java.util.stream.Collectors
import java.util.stream.IntStream
import idm.qsv.Format
import idm.qsv.SeparatorFormat
import idm.compiler.python.MissingConcreteImplementationException

class PrintAction implements Action {

	CsvData csvData
	Print print
	String NEWLINE = "\n"

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
		val format = print.format
		if (format === null) {
			val printed = csvData.toString()
			csvData.resetFilters()
			return printed + NEWLINE
		}
		val printed = format.makePretty()
		csvData.resetFilters()
		return printed + NEWLINE
	}

	def dispatch String makePretty(Format format) {
		throw new MissingConcreteImplementationException("Format")

	}

	def dispatch String makePretty(SeparatorFormat format) {
		val separator = format.separator
		return csvData.toStringWithSeparator(separator)
//		code += '''«PythonCompiler.PRETTY_PRINT_FUNCTION_NAME»(«printVariable»,"«separator»")'''
	}

	private def select(Columns selection) {
		if (selection.columns !== null) {
			csvData.selectColumns(selection.columns.names)
		}
	}

	private def select(Lines selection) {
		val Condition condition = selection.cond
		val Line line = selection.line
		val LineRange lineRange = selection.range
		if (line !== null) {
			val index = line.number
			csvData.selectLines(List.of(index))
		}
		if (lineRange !== null) {
			val start = lineRange.start
			val end = lineRange.end
			val range = IntStream.range(start, end + 1).boxed.collect(Collectors.toList)
			csvData.selectLines(range)
		}
		if (condition !== null) {
			condition.createFilter()
		}
	}

}
