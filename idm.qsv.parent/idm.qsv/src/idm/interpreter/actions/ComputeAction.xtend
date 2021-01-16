package idm.interpreter.actions

import idm.interpreter.ConcreteValues
import idm.interpreter.LineFilters
import idm.interpreter.csv.CsvData
import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumLines
import idm.qsv.SumColumns
import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.QsvXtendInterpreter

class ComputeAction implements Action {

	CsvData csvData
	Compute compute

	extension LineFilters lineFiltering
	extension ConcreteValues values

	new(Compute c, CsvData data) {
		compute = c
		csvData = data
		lineFiltering = new LineFilters(csvData)
		values = new ConcreteValues
	}

	override interpret() {
		val variable = compute.variable.value
		compute.function.interpret(variable)
		return ""
	}

	private def dispatch interpret(Function function, String variable) {
		throw new MissingConcreteImplementationException("Function")
	}

	private def dispatch interpret(SumLines sumLines, String variable) {
		val column = sumLines.column.columnId
		val result = csvData.sumLinesOfColumn(column)
		QsvXtendInterpreter.storeValue(variable, result)
	}

	private def dispatch interpret(SumColumns sumLines, String variable) {
		val columns = sumLines.columns.map[c|c.columnId]
		val result = csvData.sumColumns(columns)
		QsvXtendInterpreter.storeCsv(variable, result)
	}

}
