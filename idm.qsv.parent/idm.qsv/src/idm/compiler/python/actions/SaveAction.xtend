package idm.compiler.python.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.qsv.Format
import idm.qsv.PrettyFormat
import idm.qsv.Save
import idm.qsv.SaveCsv
import idm.qsv.SaveJson
import idm.qsv.SaveMethod
import idm.qsv.SeparatorFormat

class SaveAction implements Action {
	Save save
	String csvDataVariable
	String code
	String originalFileName

	new(Save s, String dataVariable, String originalFile) {
		save = s
		csvDataVariable = dataVariable
		originalFileName = originalFile
	}

	override compile() {
		code = ""
		save.method.saveFile()
		return code
	}

	private def dispatch saveFile(SaveMethod method) {
		throw new MissingConcreteImplementationException("SaveMethod")
	}

	private def dispatch saveFile(SaveJson jsonMethod) {
		val file = jsonMethod.filename === null ? nameToJson(originalFileName) : jsonMethod.filename
		code += '''«csvDataVariable».to_json("«file»")'''
	}

	private def dispatch saveFile(SaveCsv csvMethod) {
		val file = csvMethod.filename === null ? originalFileName : csvMethod.filename
		var separator = ","
		if (csvMethod.separator !== null) {
			separator = csvMethod.separator.separator
		}
		code += '''«csvDataVariable».to_csv("«file»", index=False, sep="«separator»")'''
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
