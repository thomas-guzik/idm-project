package idm.compiler.bash

import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumLines
import idm.qsv.SumColumns
import idm.analyzer.ValueType
import idm.analyzer.AnalyzerCompute
import idm.analyzer.ColumnSelectType
import java.util.HashSet
import idm.analyzer.FunctionName

class ComputeBashCompiler implements BashCompiler {

	Compute compute
	String varName
	HashSet<String> colName
	HashSet<String> colNumber

	AnalyzerCompute analyzer
	
	FunctionName functionName

	new(Compute c) {
		compute = c
		analyzer = new AnalyzerCompute(compute)
		varName = analyzer.getVariableName()
		functionName = analyzer.getFunctionName()

	}

	override String compile() {

		println("compute")
		println(varName)
		if (functionName === FunctionName.SUMCOL) {
			println("summmm")
			BashCompilerHelper.addVariable(varName, ValueType.COL)
		} else {
			BashCompilerHelper.addVariable(varName, ValueType.VAR)
		}

		var analyzer = new AnalyzerCompute(compute)
		analyzer.analyze()
		colName = analyzer.columnsName
		println(colName)
		colNumber = analyzer.columnsNumber
		println("gencode")
		return genCode()
	}

	def genCode() {
		return '''
		v_«varName»=""
		«compute.function.genCode()»
		'''
	}

	def dispatch genCode(Function f) {
		println("fc")
	}

	def dispatch genCode(SumLines f) {
		println("sumline")
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
		println("sumcol")
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
		println("genCut")
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
