package idm.compiler.python.actions

import idm.compiler.python.PythonCompiler
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Delete
import idm.qsv.Lines
import idm.compiler.python.LineFilters
import idm.compiler.python.ConcreteValues

class DeleteAction implements Action {
	Delete delete
	String csvDataVariable
	String code

	extension LineFilters lineFiltering
	extension ConcreteValues pythonValues

	new(Delete d, String dataVariable) {
		delete = d
		csvDataVariable = dataVariable
		lineFiltering = new LineFilters(csvDataVariable)
		pythonValues = new ConcreteValues
	}

	override String compile() {
		code = ""
		var deleteAll = true
		var deleteAllLines = false
		var deleteAllColumns = false
		if (delete.selector !== null) {
			deleteAll = false
			val Lines lineSelection = delete.selector.lineSelection
			if (lineSelection !== null) {
				deleteAllLines = lineSelection.cond === null
				if (!deleteAllLines) {
					code += lineSelection.select()
				}
			}
			val Columns columnSelection = delete.selector.columnSelection
			if (columnSelection !== null) {
				deleteAllColumns = columnSelection.columns === null
				if (!deleteAllColumns) {
					code += columnSelection.select()
				}
			}
		}
		if (deleteAll) {
			code += '''«csvDataVariable» = «csvDataVariable»[0:0]'''
			code += PythonCompiler.NEWLINE
			code += '''«csvDataVariable» = «csvDataVariable».drop(«csvDataVariable».columns, axis='columns')'''
		}
		if (deleteAllLines) {
			code += '''«csvDataVariable» = «csvDataVariable»[0:0]'''
			code += PythonCompiler.NEWLINE
		}
		if (deleteAllColumns) {
			code += '''«csvDataVariable» = «csvDataVariable».drop(«csvDataVariable».columns, axis='columns')'''
			code += PythonCompiler.NEWLINE

		}
		code += PythonCompiler.NEWLINE
		return code
	}

	private def String select(Columns selection) {
		code += '''«csvDataVariable» = «csvDataVariable».drop(['''
		var columnNames = selection.columns.getPythonNames()
		code += columnNames.join(',')
		code += "], axis='columns')"
		code += PythonCompiler.NEWLINE
		return code
	}

	private def select(Lines selection) {
		var Condition condition = selection.cond
		if (condition !== null) {
			var filter = PythonCompiler.newFilterName
			code += condition.createFilter(filter)
			code += '''«csvDataVariable» = «csvDataVariable».drop(«csvDataVariable»[«filter»].index)'''
			code += PythonCompiler.NEWLINE
		}
	}

}
