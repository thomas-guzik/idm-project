package idm.compiler.bash

import idm.qsv.Print
import idm.qsv.Selector
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.LineRange
import idm.qsv.Line
import idm.qsv.Condition
import java.util.ArrayList
import idm.qsv.MidPriority
import idm.qsv.HighestPriority
import idm.qsv.BinCond
import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNameIdentifier
import idm.qsv.ColumnNumberIdentifier
import idm.qsv.Lines
import idm.qsv.OpComp
import idm.qsv.CompareEqual
import idm.qsv.CompareNotEqual
import idm.qsv.CompareLower
import idm.qsv.CompareGreater
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.Value
import idm.qsv.IntegerValue
import idm.qsv.StringValue
import idm.qsv.VariableIdentifier
import idm.qsv.BooleanValue

class CompilerBashPrint implements CompilerBash {

	Print print
	Boolean hasColumnName
	String nameFile
	String csvSep
	String colSep

	CompilerBashSelector c

	new(Print p, Boolean hasColumnName, String nameFile, String separator) {
		print = p
		this.hasColumnName = hasColumnName
		this.nameFile = nameFile
		this.csvSep = separator
		colSep = " "

		c = new CompilerBashSelector(print.selector, hasColumnName, nameFile, separator)
	}

	override String compile() {
		c.analyze()
		return print.genCode()
	}

	def String genCode(Print print) {
		var cond = c.analyzeAndgenCodeLines()
		return '''
			
			«c.genBeforeWhile()»
			«c.genColTitle()»
			n=0
			«c.genInput()» while read «c.genRead()»
			do
			«IF !cond.isEmpty()»
				«String.join("\n", c.beforeCond)»
				if [[ «cond» ]] ; then
				  echo $n «c.genEcho()»
				fi
			«ELSE»
				echo $n «c.genEcho()»
			«ENDIF»
			n=$(( $n + 1 ))
			done
		'''
	}

}
