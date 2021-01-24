package idm.compiler.bash

import idm.qsv.Update
import idm.analyzer.ColumnSelectType
import java.util.HashSet
import java.util.Set
import idm.analyzer.ValueType
import idm.analyzer.ColumnAnalyzer
import idm.analyzer.ValueAnalyzer

class UpdateBashCompiler implements BashCompiler {

	Update update
	
	Boolean hasColumnName
	String csvSep
	
	String value = ""
	
	Set<String> cols = new HashSet<String>()
	
	Set<String> colSelectedByNumber = new HashSet<String>()
	Set<String> colSelectedByName = new HashSet<String>()
	
	Boolean withCondition = false
	ConditionBashCompiler cmpCond
	
	ValueType valueType

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
		var analyzerValue = new ValueAnalyzer(u.value)
		value = analyzerValue.getValue()
		valueType = analyzerValue.getValueType()
		
		var analyzerColumn = new ColumnAnalyzer(u.columns)
		if(analyzerColumn.columnSelectType === ColumnSelectType.NUMBER) {
			colSelectedByNumber.addAll(analyzerColumn.columnsList)
		}
		else {
			colSelectedByName.addAll(analyzerColumn.columnsList)
		}
		cols.addAll(analyzerColumn.columnsList)
		
		if(u.cond !== null) {
			withCondition = true
			cmpCond = new ConditionBashCompiler(u.cond)
			colSelectedByNumber.addAll(cmpCond.colSelectedByNumber)
			colSelectedByName.addAll(cmpCond.colSelectedByName)
		}
		
		return u
	}
	
	def String genCode(Update u) {
		return '''
			nbCol=$(( $(echo "$index" | tr '«csvSep»' '\n' | wc -l) - 1))
			«IF hasColumnName»
			header=$(echo "$file" | head -1)
			«ENDIF»
			«BashCompilerHelper.genLocVariable(colSelectedByNumber, "index")»
			«BashCompilerHelper.genLocVariable(colSelectedByName, "header")»
			file=$( «genInput()» while read -a c
			do
			«IF withCondition»if [[ «cmpCond.genBashCondition()» ]] ; then«ENDIF»
			«FOR v : cols»
			  c[$loc_«v»]="«IF valueType === ValueType.VAR»$v_«ENDIF»«value»"
			«ENDFOR»
			«IF withCondition»fi«ENDIF»
			«BashCompilerHelper.genPrintf(csvSep)»
			done)
			«IF hasColumnName»
			file="$header
			$file"
			«ENDIF»
		'''
	}
	
	def genInput() {
		return 
		'''
		echo "$file" |«IF hasColumnName» tail -n +2 |«ENDIF»'''
	}
}

