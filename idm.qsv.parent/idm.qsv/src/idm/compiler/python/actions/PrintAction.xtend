package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.LineFilters
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.Columns
import idm.qsv.Condition
import idm.qsv.Format
import idm.qsv.Line
import idm.qsv.LineRange
import idm.qsv.Lines
import idm.qsv.PrettyFormat
import idm.qsv.Print
import idm.qsv.SeparatorFormat

class PrintAction implements Action {
	Print print
	String csvDataVariable
	String printVariable
	String code

	extension LineFilters lineFiltering
	extension ConcreteValues pythonValues

	new(Print p, String dataVariable) {
		print = p
		csvDataVariable = dataVariable
		printVariable = PythonCompiler.newTmpVariable
		lineFiltering = new LineFilters(printVariable)
		pythonValues = new ConcreteValues
	}

	override String compile() {
		code = ""
		code += '''«printVariable» = «csvDataVariable»'''
		code += PythonCompiler.NEWLINE
		if (print.selector !== null) {
			val Lines lineSelection = print.selector.lineSelection
			if (lineSelection !== null) {
				lineSelection.select()
			}
			val Columns columnSelection = print.selector.columnSelection
			if (columnSelection !== null) {
				columnSelection.select()
			}
		}
		val format = print.format
		if (format === null) {
			code += '''«PythonCompiler.PRINT_SEPARATOR_FUNCTION_NAME»(«printVariable», "\t")'''
			code += PythonCompiler.NEWLINE
			return code
		}
		format.makePretty()
		return code
	}

	def dispatch void makePretty(Format format) {
		throw new MissingConcreteImplementationException("Format")

	}

	def dispatch void makePretty(SeparatorFormat format) {
		val separator = format.separator
		code += '''«PythonCompiler.PRINT_SEPARATOR_FUNCTION_NAME»(«printVariable»,"«separator»")'''
		code += PythonCompiler.NEWLINE
	}

	def dispatch void makePretty(PrettyFormat format) {
		code += '''«PythonCompiler.PRINT_PRETTY_FUNCTION_NAME»(«printVariable»)'''
		code += PythonCompiler.NEWLINE
	}

	private def String select(Columns selection) {
		if (selection.columns !== null) {
			val columnsVariable = "printCols"
			val columnNames = selection.columns.getPythonNames()
			code += '''«columnsVariable» = [«columnNames.join(',')»]'''
			code += PythonCompiler.NEWLINE

			code += '''
				if «csvDataVariable».columns.is_object():
					«columnsVariable».sort(key=lambda x: «csvDataVariable».columns.tolist().index(x))
				else:
					«columnsVariable».sort()
			'''

			code += PythonCompiler.NEWLINE
			code += '''«printVariable» = «printVariable»[«columnsVariable»]'''
			code += PythonCompiler.NEWLINE
		}
		return code
	}

	private def select(Lines selection) {
		val Condition condition = selection.cond
		val Line line = selection.line
		val LineRange lineRange = selection.range
		if (line !== null) {
			val index = line.number
			code += '''«printVariable» = «printVariable».iloc[[«index»]]'''
			code += PythonCompiler.NEWLINE
		}
		if (lineRange !== null) {
			val start = lineRange.start
			val end = lineRange.end
			code += '''«printVariable» = «printVariable».iloc[range(«start»,«end» + 1)]'''
			code += PythonCompiler.NEWLINE
		}
		if (condition !== null) {
			val filter = PythonCompiler.newFilterName
			code += condition.createFilter(filter)
			code += '''«printVariable» = «printVariable»[«filter»]'''
			code += PythonCompiler.NEWLINE
		}
	}

}
