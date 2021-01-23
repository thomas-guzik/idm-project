package idm.compiler.bash

import java.util.Set
import idm.analyzer.ColumnSelectType
import java.util.HashMap
import idm.analyzer.ValueType
import java.util.HashSet

class BashCompilerHelper {

	static String csvSep = ""
	static Boolean hasColumnName
	static HashMap<String, ValueType> variables = new HashMap<String, ValueType>()

	def static setCsvSep(String sep) {
		csvSep = sep
	}

	def static setHasColumnName(Boolean b) {
		hasColumnName = b
	}

	def static String genNbCol() {
		return '''
			nbCol=$(( $(echo "$index" | tr '«csvSep»' '\n' | wc -l) - 1))
		'''
	}

	def static String genHeader() {
		return '''
			«IF hasColumnName»
				header=$(echo "$file" | head -1)
			«ENDIF»
		'''
	}

	def static String genLocVariable(Set<String> s, String echoVar) {
		if (s !== null) {
			return '''
				«FOR v : s»
					loc_«v»=$(( $(echo "$«echoVar»" | tr '«csvSep»' '\n' | grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
				«ENDFOR»
			'''
		} else {
			return ""
		}
	}

	def static genInput(ColumnSelectType colSelectType) {
		var code = '''< <(echo "$file"'''

		if (hasColumnName) {
			code += '''| tail -n +2'''
		}

		if (colSelectType !== ColumnSelectType.ALL) {
			code += '''| cut -d "«csvSep»" -f "$nb_cut"'''
		}
		code += ''')'''
		return code
	}

	def static genPrintf(String colSep) {
		return '''
			for((i=0; i <= $nbCol; i++))
			do
			printf "${c[$i]}«csvSep»"
			done
			printf "\\b\n"
		'''

	}

	def static genEcho(String colSep) {
		return '''
			$(eval echo '${c['$(seq -s ']}«colSep»${c[' 0 $nbCol)']}')
		'''
	}

	def static addVariable(String varName, ValueType varType) {
		variables.put(varName, varType)
	}

	def static getVariableType(String varName) {
		var type = variables.get(varName)
		if (type === null) {
			throw new Exception("Unreferreced variable")
		}
		return type
	}

	def static genCut(HashSet<String> cols, String echoVar) {
		return '''
			«FOR c : cols»
				cut_«c»=$(echo "$«echoVar»" | tr '«csvSep»' '\n' | grep -n -w "^«c»" |  awk -F ":" '{print $1}')
			«ENDFOR»
		'''
	}

}
