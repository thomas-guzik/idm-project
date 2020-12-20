package idm.compiler.python.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.BinCond
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.Columns
import idm.qsv.CompareEqual
import idm.qsv.CompareGreater
import idm.qsv.Condition
import idm.qsv.Lines
import idm.qsv.OpComp
import idm.qsv.Print
import java.util.ArrayList
import java.util.stream.Collectors
import idm.qsv.CompareNotEqual
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.CompareLower

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
			val Lines lineSelection = print.selector.lineSelection
			if (lineSelection !== null) {
				code += lineSelection.select()
			}
		}
		code += '''«PythonCompiler.PRINT_FUNCTION_NAME»(«csvDataVariable»)'''
		return code
	}

	private def String select(Columns selection) {
		var code = '''«csvDataVariable» = «csvDataVariable»[['''
		var columnNames = selection.columns.getNames().stream().map([name|'''"«name»"''']).collect(Collectors.toList)
		code += columnNames.join(',')
		code += "]]\n"
		code += PythonCompiler.NEWLINE
		return code
	}

	private def String select(Lines selection) {
		var code = ""
		var Condition condition = selection.cond
		if (condition !== null) {
			var filterVariable = "filter"
			var BinCond baseCondition = condition.mid.high.baseCondition
			var String column = baseCondition.colId
			var String operator = baseCondition.operator.pythonOperator
			var Integer value = baseCondition.compValue
			code += '''«filterVariable» = «csvDataVariable»["«column»"] «operator» «value»'''
			code += PythonCompiler.NEWLINE
			code += '''«csvDataVariable» = «csvDataVariable»[«filterVariable»]'''
			code += PythonCompiler.NEWLINE
		}
		return code
	}

	private def dispatch String getPythonOperator(OpComp operator) {
		throw new MissingConcreteImplementationException("OpComp")
	}

	private def dispatch String getPythonOperator(CompareEqual equal) {
		return "=="
	}

	private def dispatch String getPythonOperator(CompareNotEqual notEqual) {
		return "!="
	}

	private def dispatch String getPythonOperator(CompareLower lower) {
		return "<"
	}

	private def dispatch String getPythonOperator(CompareGreater greater) {
		return ">"
	}

	private def dispatch String getPythonOperator(CompareLowerOrEqual lowerOrEqual) {
		return "<="
	}

	private def dispatch String getPythonOperator(CompareGreaterOrEqual greaterOrEqual) {
		return ">="
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
