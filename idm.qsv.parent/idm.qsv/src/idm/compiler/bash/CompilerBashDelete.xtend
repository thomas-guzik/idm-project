package idm.compiler.bash

import idm.qsv.Delete

class CompilerBashDelete implements CompilerBash {

	Delete delete
	Boolean hasColumnName
	String nameFile
	String csvSep
	String colSep

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
		return delete.genCode()
	}

	def String genCode(Delete delete) {
//		var cond = c.analyzeAndgenCodeLines()
//		return '''
//			«c.genBeforeWhile()»
//			n=0
//			file=$(«c.genInput()» while read «c.genRead()»
//			do
//			«IF !cond.isEmpty()»
//				«String.join("\n", c.beforeCond)»
//				if [[ ! ( «cond» ) ]] ; then
//				  echo «c.genEcho()»
//				fi
//			«ELSE»
//				echo «c.genEcho()»
//			«ENDIF»
//			n=$(( $n + 1 ))
//			done)
//		'''
		return ""
	}

}
