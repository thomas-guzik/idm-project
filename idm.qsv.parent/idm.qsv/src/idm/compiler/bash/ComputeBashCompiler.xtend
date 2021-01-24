package idm.compiler.bash

import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumColumns
import idm.analyzer.ValueType
import idm.analyzer.ColumnSelectType
import java.util.HashSet
import idm.analyzer.FunctionName
import idm.qsv.SumValuesInColumn
import idm.analyzer.ComputeAnalyzer

class ComputeBashCompiler implements BashCompiler {

	Compute compute
	String varName
	HashSet<String> colName
	HashSet<String> colNumber

	ComputeAnalyzer analyzer

	FunctionName functionName

	new(Compute c) {
		compute = c
		analyzer = new ComputeAnalyzer(compute)
		varName = analyzer.getVariableName()
		functionName = analyzer.getFunctionName()
	}

	override String compile() {

		if (functionName === FunctionName.SUMCOL) {
			BashCompilerHelper.addVariable(varName, ValueType.COL)
		} else {
			BashCompilerHelper.addVariable(varName, ValueType.VAR)
		}

		var analyzer = new ComputeAnalyzer(compute)
		colName = analyzer.columnsName
		colNumber = analyzer.columnsNumber
		return genCode()
	}

	def genCode() {
		return '''
			v_«varName»=""
			«compute.function.genCode()»
		'''
	}

	def dispatch genCode(Function f) {}

	def dispatch genCode(SumValuesInColumn f) {
		return '''
			«genCut()»
			type=""
			while read c
			do
			if ! [[ $c =~ ^[0-9]+$ ]] ; then
			type="str"
			break
			fi
			done «BashCompilerHelper.genInput(ColumnSelectType.NAME)»
			
			while read c
			do
			if [[ $type = "str" ]] ; then	
			v_«varName»="$v_«varName»$c"
			else 
			v_«varName»=$(( $v_«varName» + $c ))
			fi
			done «BashCompilerHelper.genInput(ColumnSelectType.NAME)»
		'''
	}

	def dispatch genCode(SumColumns f) {
		return '''
		«genCut()»
		nbCol=$(( $(echo "$nb_cut" | tr ',' '\n' | wc -l) -1))
		while read -a c
		do
		type=""
		for (( i=0 ; i <= $nbCol ; i++ ))
		do
		if ! [[ $c =~ ^[0-9]+$ ]] ; then
		type="str"
		break
		fi
		done
		
		if [[ type = "str" ]] ; then
		v_«varName»=$v_«varName»,$(eval echo '${c['$(seq -s ']}${c[' 0 $nbCol)']}')
		else 
		v_«varName»=$v_«varName»,$(( $( eval echo '${c['$(seq -s ']}+${c[' 0 $nbCol)']}' ) ))
		fi
		done «BashCompilerHelper.genInput(ColumnSelectType.NAME)»
		v_«varName»=${v_«varName»:1}'''
	}

	def genCut() {
		return '''
			«IF colName.size !== 0»
				header=$(echo "$file" | head -1)
				«IF colNumber.size !== 0»
					«BashCompilerHelper.genCut(colName, "header")»
					«BashCompilerHelper.genCut(colNumber, "index")»
					nb_cut="$cut_«String.join(',$cut_',colName)»,$cut_«String.join(',$cut_',colNumber)»"
				«ELSE»
					«BashCompilerHelper.genCut(colName, "header")»
					nb_cut="$cut_«String.join(',$cut_',colName)»"
				«ENDIF»
			«ELSE»
				«BashCompilerHelper.genCut(colNumber, "index")»
				nb_cut="$cut_«String.join(',$cut_',colNumber)»"
			«ENDIF»
		'''
	}
}
