package idm.compiler.bash

import idm.qsv.Print


class CompilerBashPrint implements CompilerBash {

	Print print
	Boolean hasColumnName
	String csvSep
	String colSep
	Boolean withCondition
	
	CompilerBashSelector c

	new(Print p, Boolean hasColumnName, String csvSep, String colSep) {
		print = p
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep
		this.colSep = colSep
		withCondition = false

		c = new CompilerBashSelector(print.selector, hasColumnName, csvSep, colSep)
	}

	override String compile() {
		c.analyze()
		withCondition = c.isWithCondition()
		return print.genCode()
	}

	def String genCode(Print print) {
		
		return '''
			«c.genBeforeWhile()»
			«c.genColTitle()»
			n=0
			«c.genInput()» while read -a c
			do
			«IF withCondition»
				if [[ «c.genCond()» ]] ; then
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
