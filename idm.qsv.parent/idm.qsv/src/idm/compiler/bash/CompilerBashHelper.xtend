package idm.compiler.bash

import java.util.Set
import idm.analyzer.ColumnSelectType

class CompilerBashHelper {
	
	static String csvSep = ""
	static Boolean hasColumnName
	
	def static setCsvSep(String sep) {
		idm.compiler.bash.CompilerBashHelper.csvSep = sep
	}
	
	def static setHasColumnName(Boolean b) {
		hasColumnName = b
	}

	def static String genStart() {
		return '''
			n=0
			nbCol=$(( $(echo "$index" | tr '«idm.compiler.bash.CompilerBashHelper.csvSep»' '\n' | wc -l) - 1))
		'''
	}

	def static String genNbCol() {
		return '''
			nbCol=$(( $(echo "$index" | tr '«idm.compiler.bash.CompilerBashHelper.csvSep»' '\n' | wc -l) - 1))
		'''
	}

	def static String genLocVariable(Set<String> s, String echoVar) {
		if (s !== null) {
			return '''
				«FOR v : s»
					loc_«v»=$(( $(echo "$«echoVar»" | tr '«idm.compiler.bash.CompilerBashHelper.csvSep»' '\n' | grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
				«ENDFOR»
			'''
		} else {
			return ""
		}
	}

	def static genInput(ColumnSelectType colSelectType) {
		var code = '''echo "$file" |'''

		if (hasColumnName) {
			code += ''' tail -n +2 |'''
		}

		if (colSelectType !== ColumnSelectType.ALL) {
			code += ''' cut -d "«idm.compiler.bash.CompilerBashHelper.csvSep»" -f "$nb_cut" |'''
		}
		return code
	}

	def static genEcho(String colSep) {
		return '''
			$(eval echo '${c['$(seq -s ']}«colSep»${c[' 0 $nbCol)]'}')
		'''
	}

}
