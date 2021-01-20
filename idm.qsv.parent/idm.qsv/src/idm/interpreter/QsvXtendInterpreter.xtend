package idm.interpreter

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.actions.ComputeAction
import idm.interpreter.actions.DeleteAction
import idm.interpreter.actions.EchoAction
import idm.interpreter.actions.InsertAction
import idm.interpreter.actions.PrintAction
import idm.interpreter.actions.SaveAction
import idm.interpreter.actions.UpdateAction
import idm.interpreter.csv.CsvData
import idm.qsv.Compute
import idm.qsv.Delete
import idm.qsv.Echo
import idm.qsv.Header
import idm.qsv.Insert
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Save
import idm.qsv.Statement
import idm.qsv.Update
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.List
import java.util.Map
import java.util.HashMap

class QsvXtendInterpreter {
	QuerySeparatedValues qsv
	String printed
	String csvFileName
	CsvData csvData
	String filesLocation
	static Map<String, String> valueStore
	static Map<String, CsvData> csvDataStore

	new(QuerySeparatedValues q) {
		qsv = q
		filesLocation = ""
	}

	new(QuerySeparatedValues q, String files) {
		qsv = q
		filesLocation = files
	}

	def InterpreterOutput interpret() {
		printed = ""
		valueStore = new HashMap
		csvDataStore = new HashMap
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

	private def dispatch void interpret(Update statement) {
		var updater = new UpdateAction(statement, csvData)
		updater.interpret
	}

	private def dispatch void interpret(Save statement) {
		var saver = new SaveAction(statement, csvData, csvFileName)
		saver.interpret
	}

	private def dispatch void interpret(Compute statement) {
		var computer = new ComputeAction(statement, csvData)
		computer.interpret
	}

	private def dispatch void interpret(Echo statement) {
		var echoer = new EchoAction(statement, csvData)
		printed += echoer.interpret
	}

	def List<String> getFileContent(String filename) {
		val content = Files.readAllLines(Paths.get(filesLocation + filename), StandardCharsets.UTF_8);
		return content
	}

	def static Object getVariable(String variable) {
		val value = valueStore.get(variable)
		val data = csvDataStore.get(variable)
		return value === null ? data : value
	}

	def static void storeValue(String variable, String value) {
		valueStore.put(variable, value)
		if (csvDataStore.containsKey(variable)) {
			csvDataStore.remove(variable)
		}
	}

	def static String getValue(String variable) {
		valueStore.get(variable)
	}

	def static void storeCsv(String variable, CsvData value) {
		csvDataStore.put(variable, value)
		if (valueStore.containsKey(variable)) {
			valueStore.remove(variable)
		}
	}

	def static CsvData getCsv(String variable) {
		csvDataStore.get(variable)
	}

}
