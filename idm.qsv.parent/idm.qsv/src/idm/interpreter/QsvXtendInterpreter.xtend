package idm.interpreter

import idm.interpreter.csv.CsvData
import idm.qsv.Header
import idm.qsv.QuerySeparatedValues
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.List

class QsvXtendInterpreter {
	QuerySeparatedValues qsv
	String printed
	String csvFileName
	CsvData csvData

	new(QuerySeparatedValues q) {
		qsv = q
	}

	def InterpreterOutput interpret() {
		printed = ""
		qsv.getHeader().interpret()
		val output = new InterpreterOutput(printed, "")
		return output
	}

	def void interpret(Header header) {
		csvFileName = qsv.getHeader().getNameFile()
		val hasColumnName = header.isHasColumnName()
		csvData = new CsvData(csvFileName.getFileContent(), hasColumnName, ",")
		printed += csvData.toString()
	}

	def List<String> getFileContent(String filename) {
		val content = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
		return content
	}

}
