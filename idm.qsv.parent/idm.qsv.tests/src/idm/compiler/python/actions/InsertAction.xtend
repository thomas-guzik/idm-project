package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
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
		val columnName = columnInsertion.columnName.value
		val content = '''[«columnInsertion.content.pythonRowContent»]'''
		code +=
			'''«csvDataVariable».insert(loc=len(«csvDataVariable».columns), column="«columnName»", value=«content»)'''
		code += PythonCompiler.NEWLINE
	}

	private def getPythonRowContent(ContentList contentList) {
		return contentList.values.map[v|v.pythonValue].reduce[v1, v2|'''«v1», «v2»''']
	}

}
