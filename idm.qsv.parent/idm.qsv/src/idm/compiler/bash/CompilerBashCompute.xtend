package idm.compiler.bash

import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumLines
import idm.qsv.SumColumns
import idm.analyzer.ValueType
import idm.analyzer.AnalyzerCompute
import idm.analyzer.ColumnSelectType
import java.util.HashSet

class CompilerBashCompute implements CompilerBash {

	Compute compute
	String varName
	HashSet<String> colName
	HashSet<String> colNumber

	new(Compute c) {
		compute = c
		varName = varName

	}

	override String compile() {

		if (compute.function.class === SumColumns) {
			CompilerBashHelper.addVariable(varName, ValueType.COL)
		} else {
			CompilerBashHelper.addVariable(varName, ValueType.VAR)
		}

		var analyzer = new AnalyzerCompute(compute)
		colName = analyzer.columnsName
		colNumber = analyzer.columnsNumber
		return genCode()
	}

	def genCode() {
		return '''v_«varName»=""
		«compute.function.genCode()»
		'''
	}

	def dispatch genCode(Function f) {}

	def dispatch genCode(SumLines f) {
		return '''
			«genCut()»
			«CompilerBashHelper.genInput(ColumnSelectType.NAME)» | while c
			do
			if [[ $c =~ '^[0-9]+$' ]] ; then
			v_«varName»=$(( $v_«varName» + $c ))
			else 
			v_«varName»="$v_«varName»,$c"
			fi
			done
		'''
	}

	def dispatch genCode(SumColumns f) {
		return '''
		«genCut()»
		nbCol=$(( $(echo "$nb_cut" | tr ',' '\n' | wc -l) -1))
		«CompilerBashHelper.genInput(ColumnSelectType.NAME)» | while -a c
		do
		if [[ ${c[0]} =~ '^[0-9]+$' ]] ; then
		v_«varName»=v_«varName»,$(eval $(( '${c['$(seq -s ']}+${c[' 0 $nbCol)']}' )) )
		else 
		v_«varName»=v_«varName»,$(eval '${c['$(seq -s ']}${c[' 0 $nbCol)']}')
		fi
		done
		v_«varName»=${v_«varName»:1}'''
	}

	def genCut() {
		return '''
			«IF colName.size !== 0»
				«IF colNumber.size !== 0»
					«CompilerBashHelper.genCut(colName, "header")»
					«CompilerBashHelper.genCut(colNumber, "index")»
					nb_cut="$cut_«String.join(',$cut_',colName)»,$cut_«String.join(',$cut_',colNumber)»"
				«ELSE»
				«CompilerBashHelper.genCut(colName, "header")»
				nb_cut="$cut_«String.join(',$cut_',colName)»"
				«ENDIF»
			«ELSE»
			«CompilerBashHelper.genCut(colName, "index")»
			nb_cut="$cut_«String.join(',$cut_',colNumber)»"
			«ENDIF»
		'''
	}
}
