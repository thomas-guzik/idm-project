package idm.compiler.bash

import idm.qsv.Save
import idm.qsv.SaveCsv
import idm.qsv.SaveJson
import idm.analyzer.ColumnSelectType
import idm.qsv.SaveMethod

class SaveBashCompiler implements BashCompiler {
	Save save
	String nameFile
	Boolean hasColumnName
	
	new(Save s, String nameFile, Boolean hasColumnName) {
		save = s
		this.nameFile = nameFile
		this.hasColumnName = hasColumnName
	}
	
	override compile() {
		println("la")
		return save.method.genCode()
	}
	
	def dispatch genCode(SaveMethod s) {}
	
	def dispatch genCode(SaveCsv s) {
		var filename = ""
		if(s.filename  === null) {
			filename = nameFile
		}
		else {
			filename = s.filename
		}
		return '''
		
		echo "$file" > «filename»
		'''
	}
	
	def dispatch genCode(SaveJson s) {
		println("ava ici")
		var filename = ""
		if(s.filename  === null) {
			filename = nameFile+".json"
		}
		else {
			filename = s.filename
		}
		println("casse")
		var refVar = ""
		if(hasColumnName) {
			refVar = "$header"
		}
		else  {
			refVar = "$index"
		}
		// "0":"v1","1":"v1","2":"v8"
		println("ici")
		return '''
		«BashCompilerHelper.genNbCol»
		«IF hasColumnName»
		header=$(echo "$file" | head -1) 
		«ENDIF»
		n=0
		while read -a c
		do
		for(( i=0 ; i <= $nbCol; i++))
		do
		j[$i]="${j[$i]},\"$n\":\"${c[$i]}\""
		done
		n=$(( $n + 1 ))
		done «BashCompilerHelper.genInput(ColumnSelectType.ALL)»
		while read -a c
		do
		for(( i=0 ; i <= $nbCol; i++))
		do
		j[$i]="\"${c[$i]}\":{${j[$i]:1}}"
		done
		done < <(echo "«refVar»")
		json=""
		for(( i=0 ; i <= $nbCol ; i++ ))
		do
		json="$json,${j[$i]}"
		done
		json="{${json:1}}"
		echo "$json" > «filename»
		'''
	}
}