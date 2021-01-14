package idm.compiler.bash

import idm.qsv.Delete

class CompilerBashDelete implements CompilerBash {

	Delete delete
	Boolean hasColumnName
	String nameFile
	String csvSep
	String colSep
	Boolean withCondition

	CompilerBashSelector c

	new(Delete d, Boolean hasColumnName, String nameFile, String separator) {
		delete = d
		this.hasColumnName = hasColumnName
		this.nameFile = nameFile
		this.csvSep = separator
		colSep = " "

		c = new CompilerBashSelector(delete.selector, hasColumnName, nameFile, separator)
	}

	override String compile() {
		c.analyze()
		withCondition = c.isWithCondition()
		return delete.genCode()
	}

	def String genCode(Delete delete) {
		return '''
			«c.genBeforeWhileDelete()»
			n=0
			«c.genInput()» while read -a c
			do
			«IF withCondition»
				if [[ ! ( «c.genCond()» ) ]] ; then
				  echo «c.genEcho()»
				fi
			«ELSE»
				echo «c.genEcho()»
			«ENDIF»
			n=$(( $n + 1 ))
			done
		'''
	}

}
