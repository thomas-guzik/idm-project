package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.ColumnDescription
import idm.qsv.ColumnInsertion
import idm.qsv.ContentList
import idm.qsv.Insert
import idm.qsv.Insertion
import idm.qsv.LineInsertion

class InsertAction implements Action {
	Insert insert
	String csvDataVariable
	String code

	extension ConcreteValues pythonValues

	new(Insert i, String dataVariable) {
		insert = i
		csvDataVariable = dataVariable
		pythonValues = new ConcreteValues
	}

	override compile() {
		code = ""
		insert.inserted.insert()
		return code
	}

	private def dispatch insert(Insertion insertion) {
		throw new MissingConcreteImplementationException("Insertion")
	}

	private def dispatch insert(LineInsertion lineInsertion) {
		val insertedLines = lineInsertion.rows
		for (ContentList line : insertedLines) {
			val content = '''[«line.pythonRowContent»]'''
			code += PythonCompiler.NEWLINE
			code +=
				'''«csvDataVariable» = «csvDataVariable».append(dict(zip(«csvDataVariable».columns,«content»)), ignore_index=True)'''
			code += PythonCompiler.NEWLINE
		}
	}

	private def dispatch insert(ColumnInsertion columnInsertion) {
		for (ColumnDescription description : columnInsertion.descriptions) {
			val hasColumnName = description.columnName !== null
			val content = '''[«description.content.pythonRowContent»]'''
			if (hasColumnName) {
				val columnName = description.columnName.value
				code +=
					'''«csvDataVariable».insert(loc=len(«csvDataVariable».columns), column="«columnName»", value=«content»)'''
			} else {
				code += '''«csvDataVariable»[len(«csvDataVariable».columns)] = «content»'''
			}
			code += PythonCompiler.NEWLINE
		}
	}

}
