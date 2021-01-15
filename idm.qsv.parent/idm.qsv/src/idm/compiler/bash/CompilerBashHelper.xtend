package idm.compiler.bash

import java.util.Map
import java.util.ArrayList
import idm.analyzer.ColumnSelectType
import java.util.List
import java.util.Set

class CompilerBashHelper {

	def static String genStart(String csvSep) {
		return '''
			n=0
			nbCol=$(( $(echo "$index" | tr '«csvSep»' '\n' | wc -l) - 1))
		'''
	}

	def static String genLocVariable(Map<String, ArrayList<String>> map, ColumnSelectType colSelectType,
		String csvSep) {
		if (map !== null) {
			var echoVarForName = ""
			var echoVarForNumber = ""
			if (colSelectType == ColumnSelectType.ALL) {
				echoVarForName = "$header"
				echoVarForNumber = "$index"
			} else {
				echoVarForName = "$header_cut"
				echoVarForNumber = "$index_cut"
			}
			println("genLoc")
			return '''
				«IF map.get("name") !== null»
					«genLocVariable(map.get("number"), echoVarForName, csvSep)»
				«ENDIF»
				«IF map.get("number") !== null»
					«genLocVariable(map.get("number"), echoVarForNumber, csvSep)»
				«ENDIF»
			'''
		} else {
			return ""
		}
	}
	
	def static String genLocVariable(List<String> l, String echoVarForName, String csvSep) {
		return '''
		«FOR v : l»
			loc_«v»=$(( $(echo "«echoVarForName»" | tr '«csvSep»' '\n' | grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
		«ENDFOR»
		'''
	}
	
	def static String genLocVariable(Set<String> s, String echoVar, String csvSep) {
		return '''
		«FOR v : s»
			loc_«v»=$(( $(echo "$«echoVar»" | tr '«csvSep»' '\n' | grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
		«ENDFOR»
		'''
	}

	def static genEcho(String colSep) {
		println("genEcho")
		return '''
			$(eval echo '${c['`seq -s ']}«colSep»${c[' 0 $nbCol`]'}')
		'''
	}

}
