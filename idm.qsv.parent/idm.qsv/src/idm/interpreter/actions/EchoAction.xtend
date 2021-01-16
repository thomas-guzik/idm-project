package idm.interpreter.actions

import idm.interpreter.QsvXtendInterpreter
import idm.interpreter.csv.CsvData
import idm.qsv.Echo

class EchoAction implements Action {

	CsvData csvData
	Echo echo
	String NEWLINE = "\n"

	new(Echo e, CsvData data) {
		echo = e
		csvData = data
	}

	override interpret() {
		val variable = echo.variable.value
		return QsvXtendInterpreter.getVariable(variable) + NEWLINE
	}

}
