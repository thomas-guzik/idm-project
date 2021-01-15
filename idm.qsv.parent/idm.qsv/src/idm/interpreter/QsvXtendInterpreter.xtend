package idm.interpreter

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.actions.DeleteAction
import idm.interpreter.actions.InsertAction
import idm.interpreter.actions.PrintAction
import idm.interpreter.csv.CsvData
import idm.qsv.Delete
import idm.qsv.Header
import idm.qsv.Insert
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
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
		for (Statement s : qsv.getStatements()) {
			s.interpret();
		}
		val output = new InterpreterOutput(printed, "")
		return output
	}

	private def dispatch void interpret(Header header) {
		csvFileName = qsv.getHeader().getNameFile()
		val hasColumnName = header.isHasColumnName()
		csvData = new CsvData(csvFileName.getFileContent(), hasColumnName, ",")
	}

	private def dispatch void interpret(Statement statement) {
		throw new MissingConcreteImplementationException("Statement")
	}

	private def dispatch void interpret(Print statement) {
		var printer = new PrintAction(statement, csvData)
		printed += printer.interpret
	}

	private def dispatch void interpret(Insert statement) {
		var inserter = new InsertAction(statement, csvData)
		inserter.interpret
	}
	
		private def dispatch void interpret(Delete statement) {
		var deleter = new DeleteAction(statement, csvData)
		deleter.interpret
	}

	def List<String> getFileContent(String filename) {
		val content = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
		return content
	}

}
