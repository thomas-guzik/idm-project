package idm.compiler.bash

import idm.qsv.Echo
import idm.analyzer.ValueType

class CompilerBashEcho implements CompilerBash {

	Echo echo

	new(Echo c) {
		echo = c
	}

	override String compile() {
		var varType = CompilerBashHelper.getVariableType(echo.variable.value)
		if (varType === ValueType.VAR) {
			return '''
				echo "$v_«echo.variable.value»"
			'''
		} else if(varType === ValueType.COL) {
			return '''
			n=0
			echo "$v_«echo.variable.value»" | while read c
			do
			echo "$n $c"
			n=$((n + 1))
			done
			'''
		} else {
			throw new Exception("Error cant print other variable")
		}

	}

}
