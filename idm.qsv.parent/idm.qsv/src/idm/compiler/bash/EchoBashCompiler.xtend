package idm.compiler.bash

import idm.qsv.Echo
import idm.analyzer.ValueType

class EchoBashCompiler implements BashCompiler {

	Echo echo
	String varName

	new(Echo c) {
		echo = c
		varName = echo.variable.value.substring(1)
	}

	override String compile() {
		var varType = BashCompilerHelper.getVariableType(varName)
		if (varType === ValueType.VAR) {
			return '''
				echo "$v_«varName»"
			'''
		} else if(varType === ValueType.COL) {
			return '''
			n=0
			echo "$v_«varName»" | tr ',' '\n' | while read c
			do
			printf "$n	$c\n"
			n=$((n + 1))
			done
			'''
		} else {
			throw new Exception("Error cant print other variable")
		}

	}

}
