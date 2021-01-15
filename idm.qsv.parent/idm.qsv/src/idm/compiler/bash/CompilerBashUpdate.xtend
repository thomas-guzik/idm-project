package idm.compiler.bash

import idm.qsv.Update
import idm.analyzer.AnalyzerValue
import idm.analyzer.AnalyzerColumn
import idm.analyzer.ColumnSelectType
import java.util.HashSet
import java.util.Set

class CompilerBashUpdate implements CompilerBash {

	Update update
	
	Boolean hasColumnName
	String csvSep
	
	String value = ""
	
	Set<String> cols = new HashSet<String>()
	
	Set<String> colSelectedByNumber = new HashSet<String>()
	Set<String> colSelectedByName = new HashSet<String>()
	
	Boolean withCondition = false
	CompilerBashCondition cmpCond

	new(Update u, Boolean hasColumnName, String csvSep) {
		update = u
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep
	}

	override String compile() {
		update.analyze()
		return update.genCode()
	}
	
	def Update analyze(Update u) {
		var analyzerValue = new AnalyzerValue(u.value)
		value = analyzerValue.getValue()
		
		var analyzerColumn = new AnalyzerColumn(u.columns)
		if(analyzerColumn.columnSelectType === ColumnSelectType.NUMBER) {
			colSelectedByNumber.addAll(analyzerColumn.columnsList)
		}
		else {
			colSelectedByName.addAll(analyzerColumn.columnsList)
		}
		cols.addAll(analyzerColumn.columnsList)
		
		if(u.cond !== null) {
			withCondition = true
			cmpCond = new CompilerBashCondition(u.cond)
			colSelectedByNumber.addAll(cmpCond.colSelectedByNumber)
			colSelectedByName.addAll(cmpCond.colSelectedByName)
		}
		
		return u
	}
	
	def String genCode(Update u) {
		return '''
			nbCol=$(( $(echo "$index" | tr '«csvSep»' '\n' | wc -l) - 1))
			«CompilerBashHelper.genLocVariable(colSelectedByNumber, "index")»
			«CompilerBashHelper.genLocVariable(colSelectedByName, "header")»
			file=$( «genInput()» while read -a c
			do
			«IF withCondition»if [[ «cmpCond.genBashCondition()» ]] ; then«ENDIF»
			«FOR v : cols»
			  c[$loc_«v»]="«value»"
			«ENDFOR»
			«IF withCondition»fi«ENDIF»
			echo «CompilerBashHelper.genEcho(csvSep)»
			done)
		'''
	}
	
	def genInput() {
		return 
		'''
		echo "$file" |«IF hasColumnName» tail -n +2 |«ENDIF»
		'''
	}
}

