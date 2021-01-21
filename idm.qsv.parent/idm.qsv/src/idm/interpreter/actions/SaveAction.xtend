package idm.interpreter.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.csv.CsvData
import idm.qsv.Save
import idm.qsv.SaveCsv
import idm.qsv.SaveJson
import idm.qsv.SaveMethod

class SaveAction implements Action {

	CsvData csvData
	Save save
	String originalFileName

	new(Save s, CsvData data, String originalFile) {
		save = s
		csvData = data
		originalFileName = originalFile
	}

	override interpret() {
		save.method.saveFile()
		return ""
	}

	private def dispatch saveFile(SaveMethod method) {
		throw new MissingConcreteImplementationException("SaveMethod")
	}

	private def dispatch saveFile(SaveJson jsonMethod) {
		val file = jsonMethod.filename === null ? nameToJson(originalFileName) : jsonMethod.filename
		csvData.saveJsonTo(file)
	}

	private def dispatch saveFile(SaveCsv csvMethod) {
		val file = csvMethod.filename === null ? originalFileName : csvMethod.filename
		csvData.saveTo(file)
	}

	private def String nameToJson(String filename) {
		var jsonName = filename
		if (filename.endsWith(".csv")) {
			jsonName = filename.substring(0, filename.lastIndexOf(".csv"))
		}
		jsonName += ".json"
		return jsonName
	}

}
