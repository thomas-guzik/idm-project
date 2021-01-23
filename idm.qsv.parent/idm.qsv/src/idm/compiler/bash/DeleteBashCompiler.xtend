package idm.compiler.bash

import idm.qsv.Delete
import idm.analyzer.ColumnSelectType
import java.util.List
import java.util.Set

class DeleteBashCompiler implements BashCompiler {

	Delete delete
	Boolean hasColumnName
	String csvSep

	Boolean withCondition
	ColumnSelectType colSelectType
	List<String> colSelected

	Set<String> colNameInCond
	Set<String> colNumberInCond

	SelectorBashCompiler c

	new(Delete d, Boolean hasColumnName, String csvSep) {
		delete = d
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep

		c = new SelectorBashCompiler(delete.selector)
	}

	override String compile() {
		colSelectType = c.colSelectType
		colSelected = c.colSelected
		withCondition = c.isWithCondition()
		colNameInCond = c.colNameInCondition
		colNumberInCond = c.colNumberInCondition
		return delete.genCode()
	}

	def String genCode(Delete delete) {
		return '''
			«genBeforeWhile()»
			«genCondVariable()»
			«BashCompilerHelper.genLocVariable(colNameInCond,"header")»
			«BashCompilerHelper.genLocVariable(colNumberInCond,"index")»
			«BashCompilerHelper.genNbCol()»
			n=0
			file=$(while read -a c
			do
			«IF withCondition»if eval ! [[ «c.genCond()» ]] ; then«ENDIF»
			echo «BashCompilerHelper.genEcho(csvSep)»
			«IF withCondition»fi«ENDIF»
			n=$(( $n + 1 ))
			done «BashCompilerHelper.genInput(colSelectType)»)
			«IF hasColumnName»file="$header
			$file"«ENDIF»
		'''
	}

	def genBeforeWhile() {
		var code = '''nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) -1))
		'''
		if (colSelectType !== ColumnSelectType.ALL) {

			var keyword = ""
			if (colSelectType === ColumnSelectType.NAME) {
				keyword = '''header'''

			} else if (colSelectType === ColumnSelectType.NUMBER) {
				keyword = '''index'''
			}
			code += '''
				«IF hasColumnName»
					header_cut=""
					header_array=($(echo "$header" | tr ',' ' '))
				«ENDIF»
				index_cut=""
				index_array=($(echo "$index"))
				for((i=0 ; i <= $nbCol ; i++ ))
				do
				if [[ ${«keyword»_array[$i]} != "«String.join('''" && ${«keyword»_array[$i]} != "''', colSelected)»" ]]
				then
				«IF hasColumnName»
					header_cut=$header_cut${header_array[$i]},
				«ENDIF»
				index_cut=$index_cut${index_array[$i]},
				nb_cut=$nb_cut$(($i+1)),
				fi
				done
				«IF hasColumnName»
					header=${header_cut::-1}
				«ENDIF»
				index=${index_cut::-1}
				nb_cut=${nb_cut::-1}
				nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) -1))
			'''
		}
		else {
			if(hasColumnName) {
				code +='''header=$(echo "$file" | head -1)'''
			}
		}
		return code
	}
	
	def genCondVariable() {
		if(c === null) {
			return ""
		} else {
			return c.genBeforeCondition()
		}
	}
}
