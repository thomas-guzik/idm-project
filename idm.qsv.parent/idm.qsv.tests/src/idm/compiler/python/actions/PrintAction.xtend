package idm.compiler.python.actions

import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.Columns
import idm.qsv.Lines
import idm.qsv.Print
import java.util.ArrayList
import java.util.stream.Collectors
import idm.compiler.python.MissingConcreteImplementationException

class PrintAction implements Action {
	Print print
	String csvDataVariable

	new(Print p, String dataVariable) {
		print = p
		csvDataVariable = dataVariable
	}

	override String compile() {
		var code = ""
		if (print.selector !== null) {
			val Columns columnSelection = print.selector.columnSelection
			if (columnSelection !== null) {
				code += columnSelection.select()
			}
			val Lines lines = print.selector.lineSelection
		}
		code += '''print(«csvDataVariable»)'''
		return code
	}

	private def select(Columns selection) {
		var code = '''«csvDataVariable» = «csvDataVariable»[['''
		var columnNames = selection.columns.getNames().stream().map([name|'''"«name»"''']).collect(Collectors.toList)
		code += columnNames.join(',')
		code += "]]\n"
		return code
	}

	private def dispatch getNames(Column column) {
		throw new MissingConcreteImplementationException("Column")
	}

	private def dispatch getNames(ColumnNames names) {
		return names.ids.toList
	}

	private def dispatch getNames(ColumnNumbers numbers) {
		return new ArrayList<String>()
	}

}
