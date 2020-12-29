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

enum ColSelection {
	ALL,
	BYNAME,
	BYNUMBER
}

class CompilerBashPrint extends CompilerBash {

	Print print
	Boolean hasColumnName
	ColSelection colSelection
	ArrayList<String> cols
	ArrayList<String> conditions
	String nameFile
	String separator

	new(Print p, Boolean hasColumnName, String nameFile, String separator) {
		print = p
		this.hasColumnName = hasColumnName
		this.nameFile = nameFile
		this.separator = separator

		cols = newArrayList
		conditions = newArrayList
		colSelection = ColSelection.ALL
	}

	override String compile() {
		return print.analyse().genCode()
	}

	def Print analyse(Print print) {
		var selector = print.getSelector()
		if (selector !== null) {
			println("debut analyse")
			selector.analyse()
		}
		println("fin analyse")
		return print
	}

	def String genCode(Print print) {
		println("gencode")
		var colVariable = newArrayList
		var input = ""
		var beforeWhile = ""
		switch (colSelection) {
			case ColSelection.ALL: {
				colVariable.add("line")
				if (hasColumnName) {
					input = '''<(tail -n +2 «nameFile»)'''
					beforeWhile = '''echo "  "`head -1 «nameFile» | tr '«separator»' " "`'''
				} else {
					input = nameFile
					beforeWhile = '''
					nbCol=$(( `head -1 «nameFile» | tr '«separator»' '\n' | wc -l` - 1))
					echo " " `seq -s "  " 0 $nbCol`'''
				}
			}
			case ColSelection.BYNAME: {
				colVariable = cols
				input = '''<(cut -d "«separator»" -f '''
				for (var i = 0; i < cols.size; i++) {
					beforeWhile += '''loc«i»=`head -1 «nameFile» | tr '«separator»' '\n' | nl | grep -w "«cols.get(i)»" | tr -d " " |  awk -F " " '{print $1}'`
					'''
					input += '''${loc«i»}'''
					if (i < cols.size - 1) {
						input += ","
					}
				}
				input += ''' «nameFile» | tail -n +2)'''
				beforeWhile += '''echo " " `cut -d "«separator»" -f '''
				for (var i = 0; i < cols.size; i++) {
					beforeWhile += '''$loc«i»'''
					if (i < cols.size - 1) {
						beforeWhile += ","
					}
				}
				beforeWhile += ''' «nameFile» | head -1`'''
			}
			case ColSelection.BYNUMBER: {
				beforeWhile += '''echo "'''
				for (var i = 0; i < cols.size; i++) {
					colVariable.add("c" + String.valueOf(i))
					beforeWhile += '''  «Integer.valueOf(cols.get(i)) - 1»'''
				}
				beforeWhile += '''"'''

				input = '''<(cut -d "«separator»" -f «String.join(",", cols)» «nameFile»'''
				if (hasColumnName) {
					input += ''' | tail -n +2)'''
				} else {
					input += ''')'''
				}
			}
		}

		return '''
			«beforeWhile»
			n=0
			while read «FOR c : colVariable»«c» «ENDFOR»
			do
			«IF conditions.length != 0»
				if «String.join(" && ", conditions)» ; then
				  echo $n «FOR c : colVariable»$«c» «ENDFOR»
				fi
			«ELSE»
				echo $n «FOR c : colVariable»$«c» «ENDFOR»
			«ENDIF»
			n=$(( $n + 1 ))
			done < «input»
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
			throw new Exception("You select columns name but file hasn't columns name")
		}
		c.getNames().forEach[n|cols.add(n)]
		colSelection = colSelection.BYNAME
	}

	def dispatch analyze(ColumnNumbers c) {
		c.numbers.forEach[n|cols.add(String.valueOf(Integer.valueOf(n.substring(1)) + 1))]
		colSelection = colSelection.BYNUMBER
	}

	def analyse(LineRange range) {
		conditions.add('''[ $n -ge «range.getStart()» ]''')
		conditions.add('''[ $n -le «range.getEnd()» ]''')
	}

	def analyse(Line line) {
		conditions.add('''[ $n -eq «line.number» ]''')
	}

	def analyse(Condition cond) {
	}

	def addCondition(String a, String cond) {
		var newConditon = a
		if (newConditon.length != 0) {
			newConditon += " && "
		}
		newConditon += cond
		return newConditon
	}

	def convertListTo(String a, String number) {
	}

}
