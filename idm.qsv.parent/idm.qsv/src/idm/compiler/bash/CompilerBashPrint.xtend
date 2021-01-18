package idm.compiler.bash

import idm.qsv.Print
import idm.analyzer.ColumnSelectType
import java.util.List
import java.util.Set

class CompilerBashPrint implements CompilerBash {

	Print print
	Boolean hasColumnName
	String csvSep
	String colSep

	Boolean withCondition
	ColumnSelectType colSelectType
	List<String> colSelected

	Set<String> colNameInCond
	Set<String> colNumberInCond

	CompilerBashSelector c

	new(Print p, Boolean hasColumnName, String csvSep, String colSep) {
		print = p
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep
		this.colSep = colSep

		if (print.selector !== null) {
			c = new CompilerBashSelector(print.selector)
			colSelectType = c.colSelectType
			colSelected = c.colSelected
			withCondition = c.isWithCondition()
			colNameInCond = c.colNameInCondition
			colNumberInCond = c.colNumberInCondition
		} else {
			c = null
			colSelectType = ColumnSelectType.ALL
			colSelected = null
			withCondition = false
			colNameInCond = null
			colNumberInCond = null
		}
	}

	override String compile() {
		return print.genCode()
	}

	def String genCode(Print print) {
		return '''
			«genBeforeWhile()»
			n=0
			«genColTitle()»
			while read -a c
			do
			
			«IF withCondition»if eval [[ «c.genCond()» ]] ; then«ENDIF»
			echo $n «CompilerBashHelper.genEcho(colSep)»
			«IF withCondition»fi«ENDIF»
			n=$(( $n + 1 ))
			done «CompilerBashHelper.genInput(colSelectType)»
		'''
	}

	def genBeforeWhile() {
		return '''
			header=$(echo "$file" | head -1)
			«IF colSelectType == ColumnSelectType.ALL»
				nbCol=$(( $(echo "$index" | tr '«csvSep»' '\n' | wc -l) - 1))
			«ENDIF»
			«genCutVariable»
			«genLocVariable»
			«genCondVariable»
		'''
	}
	
	def genCondVariable() {
		if(c === null) {
			return ""
		} else {
			return c.genBeforeCondition()
		}
	}

	def genCutVariable() {
		var code = ""
		if (colSelectType !== ColumnSelectType.ALL) {
			var echoVar = ""
			if (colSelectType === ColumnSelectType.NAME) {
				echoVar = "$header"
			} else if (colSelectType === ColumnSelectType.NUMBER) {
				echoVar = "$index"
			}
			code += '''
				«FOR c : colSelected»
					cut_«c»=$(echo "«echoVar»" | tr '«csvSep»' '\n' | grep -n -w "^«c»" |  awk -F ":" '{print $1}')
				«ENDFOR»
				nb_cut="$cut_«String.join(',$cut_',colSelected)»"
			'''

			if (hasColumnName) {
				code += '''
					header_cut=$(echo "$header" | cut -d '«csvSep»' -f "$nb_cut")
				'''
			}
			code += '''
				index_cut=$(echo "$index" | cut -d '«csvSep»' -f "$nb_cut")
				nbCol=$(( $(echo "$index_cut" | tr '«csvSep»' '\n' | wc -l) - 1))
			'''
		}
		return code
	}

	def genLocVariable() {
		var echoVarForName = ""
		var echoVarForNumber = ""
		if (colSelectType == ColumnSelectType.ALL) {
			echoVarForName = "header"
			echoVarForNumber = "index"
		} else {
			echoVarForName = "header_cut"
			echoVarForNumber = "index_cut"
		}
		return '''
			«CompilerBashHelper.genLocVariable(colNameInCond, echoVarForName)»
			«CompilerBashHelper.genLocVariable(colNumberInCond, echoVarForNumber)»
		'''
	}

	def genColTitle() {
		var echoVar = ""
		switch (colSelectType) {
			case ColumnSelectType.ALL: {
				if (hasColumnName) {
					echoVar = "$header"
				} else {
					echoVar = "$index"
				}
			}
			case ColumnSelectType.NAME: {
				echoVar = "$header_cut"
			}
			case ColumnSelectType.NUMBER: {
				if (hasColumnName) {
					echoVar = "$header_cut"
				} else {
					echoVar = "$index_cut"
				}
			}
		}
		return '''echo "  $(echo "«echoVar»" | tr '«csvSep»' '«colSep»')"'''
	}

}
