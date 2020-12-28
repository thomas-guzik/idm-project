package idm.compiler.bash

import idm.qsv.Print
import idm.qsv.Selector
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.LineRange
import idm.qsv.Line
import idm.qsv.Condition

class CompilerBashPrint extends CompilerBash {

	Print print
	Boolean hasColumnName
	String[] cols
	Boolean areLinesSelected
	String linesConditions

	new(Print p, Boolean hasColumnName) {
		print = p
		this.hasColumnName = hasColumnName

		cols = #[]
		areLinesSelected = false
		linesConditions = ""
	}

	override String compile() {
		return print.analyse().genCode()
	}

	def Print analyse(Print print) {
		var selector = print.getSelector()
		if (selector !== null) {
			selector.analyse()
		}
		return print
	}

	def String genCode(Print print) {
		var colNameVariable = #["line"]
		return '''
			n=0
			while read «FOR c : colNameVariable»«c» «ENDFOR»
			do
			«IF areLinesSelected»
				if «linesConditions» ; then
				  echo «FOR c : colNameVariable»$«c» «ENDFOR»
				fi
			«ELSE»
				echo «FOR c : colNameVariable»$«c» «ENDFOR»
			«ENDIF»
			  n=$(( $n + 1 )))
			done
		'''
	}

	def Selector analyse(Selector selector) {
		var columnSelection = selector.getColumnSelection()
		var lineSelection = selector.getLineSelection()

		if (columnSelection !== null) {
			var columns = columnSelection.getColumns()
			if (columns !== null) {
				columns.analyze()
			}
		}

		if (lineSelection !== null) {
			var range = lineSelection.getRange()
			var line = lineSelection.getLine()
			var cond = lineSelection.getCond()
			if (range !== null) {
				range.analyse();
			} else if (line !== null) {
				line.analyse();
			}

			if (cond !== null) {
				cond.analyse();
			}
		}
		return selector
	}

	def dispatch analyze(Column c) {}

	def dispatch analyze(ColumnNames c) {
		if (hasColumnName == false) {
			throw new Exception()
		}
		c.getNames().forEach[n|cols.add(n)]
	}

	def dispatch analyze(ColumnNumbers c) {
		c.getNumbers().forEach[n|cols.add(n)]
	}

	def analyse(LineRange range) {
	}

	def analyse(Line line) {
	}

	def analyse(Condition cond) {
	}

}
