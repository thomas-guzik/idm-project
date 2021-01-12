package idm.compiler.python.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.ColumnDescription
import idm.qsv.ColumnInsertion
import idm.qsv.ContentList
import idm.qsv.LineInsertion
import idm.qsv.Save
import idm.qsv.SaveCsv
import idm.qsv.SaveJson
import idm.qsv.SaveMethod

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
		throw new MissingConcreteImplementationException("SaveJson")
	}

	private def dispatch saveFile(SaveCsv csvMethod) {
		val file = csvMethod.filename === null ? originalFileName : csvMethod.filename
		code += '''«csvDataVariable».to_csv("«file»", index=False)'''
	}

	private def dispatch insert(LineInsertion lineInsertion) {
		val insertedLines = lineInsertion.rows
		for (ContentList line : insertedLines) {
			code += PythonCompiler.NEWLINE
			code +=
				'''«csvDataVariable» = «csvDataVariable».append(dict(zip(«csvDataVariable».columns,«""»)), ignore_index=True)'''
			code += PythonCompiler.NEWLINE
		}
	}

	private def dispatch insert(ColumnInsertion columnInsertion) {
		for (ColumnDescription description : columnInsertion.descriptions) {
			val hasColumnName = description.columnName !== null
			if (hasColumnName) {
				val columnName = description.columnName.value
				code +=
					'''«csvDataVariable».insert(loc=len(«csvDataVariable».columns), column="«columnName»", value=«""»)'''
			}
			code += PythonCompiler.NEWLINE
		}
	}

}
