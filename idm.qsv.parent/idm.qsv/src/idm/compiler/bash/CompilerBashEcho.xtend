package idm.compiler.bash

import idm.qsv.Echo

class CompilerBashEcho extends CompilerBash {

	Echo echo

	new(Echo c) {
		echo = c
	}

	override String compile() {
		return ""
	}

}
