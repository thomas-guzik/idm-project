package idm.compiler.python.actions

import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.Columns
import idm.qsv.CompareEqual
import idm.qsv.CompareGreater
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.CompareLower
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareNotEqual
import idm.qsv.Condition
import idm.qsv.HighestPriority
import idm.qsv.Lines
import idm.qsv.MidPriority
import idm.qsv.OpComp
import idm.qsv.Print
import java.util.ArrayList
import java.util.stream.Collectors

class PrintAction implements Action {
	Print print
	String csvDataVariable
	String code
	static Integer filterCount = 0

	new(Print p, String dataVariable) {
		print = p
		csvDataVariable = dataVariable
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
		var columnNames = selection.columns.getNames().stream().map([name|'''"«name»"''']).collect(Collectors.toList)
		code += columnNames.join(',')
		code += "]]\n"
		code += PythonCompiler.NEWLINE
		return code
	}

	private def select(Lines selection) {
		var Condition condition = selection.cond
		if (condition !== null) {
			var filter = condition.compileFilterRec
			code += '''«csvDataVariable» = «csvDataVariable»[«filter»]'''
			code += PythonCompiler.NEWLINE
		}
	}

	def String compileFilterRec(Condition condition) {
		var filter = condition.mid.compileFilterRec
		var or = condition.orCondition
		if (or !== null) {
			var rightSideFilter = or.compileFilterRec
			var orFilter = createNewFilterName()
			code += '''«orFilter» = «filter» | «rightSideFilter»'''
			code += PythonCompiler.NEWLINE
			filter = orFilter
		}
		return filter
	}

	def String compileFilterRec(MidPriority mid) {
		var filter = mid.high.compileFilter
		var and = mid.andCondition
		if (and !== null) {
			var rightSideFilter = and.compileFilterRec
			var andFilter = createNewFilterName()
			code += '''«andFilter» = «filter» & «rightSideFilter»'''
			code += PythonCompiler.NEWLINE
			filter = andFilter
		}
		return filter
	}

	def String compileFilter(HighestPriority high) {
		var baseCondition = high.baseCondition
		var nestedCondition = high.nestedCondition
		if (baseCondition !== null) {
			var filter = createNewFilterName()
			var String column = baseCondition.colId
			var String operator = baseCondition.operator.pythonOperator
			var Integer value = baseCondition.compValue
			code += '''«filter» = «csvDataVariable»["«column»"] «operator» «value»'''
			code += PythonCompiler.NEWLINE
			return filter
		}
		if (nestedCondition !== null) {
			return nestedCondition.compileFilterRec
		}
		throw new MissingConcreteImplementationException("HighestPriority")
	}

	def String createNewFilterName() {
		return "filter" + filterCount++
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
