package idm.compiler.python.actions

import idm.compiler.python.PythonCompiler
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Lines
import idm.qsv.Print
import idm.compiler.python.LineFilters
import idm.compiler.python.ConcreteValues

class PrintAction implements Action {
	Print print
	String csvDataVariable
	String code

	extension LineFilters lineFiltering
	extension ConcreteValues pythonValues

	new(Print p, String dataVariable) {
		print = p
		csvDataVariable = dataVariable
		lineFiltering = new LineFilters(csvDataVariable)
		pythonValues = new ConcreteValues

	}

	override String compile() {
		code = ""
		if (print.selector !== null) {
			val Lines lineSelection = print.selector.lineSelection
			if (lineSelection !== null) {
				code += lineSelection.select()
			}
			val Columns columnSelection = print.selector.columnSelection
			if (columnSelection !== null) {
				code += columnSelection.select()
			}
		}
		code += '''«PythonCompiler.PRINT_FUNCTION_NAME»(«csvDataVariable»)'''
		return code
	}

	private def String select(Columns selection) {
		code += '''«csvDataVariable» = «csvDataVariable»[['''
		var columnNames = selection.columns.getPythonNames()
		code += columnNames.join(',')
		code += "]]\n"
		code += PythonCompiler.NEWLINE
		return code
	}

	private def select(Lines selection) {
		var Condition condition = selection.cond
		if (condition !== null) {
			var filter = PythonCompiler.newFilterName
			code += condition.createFilter(filter)
			code += '''«csvDataVariable» = «csvDataVariable»[«filter»]'''
			code += PythonCompiler.NEWLINE
		}
	}

}
