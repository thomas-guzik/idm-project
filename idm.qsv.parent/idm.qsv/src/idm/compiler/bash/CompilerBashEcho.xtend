package idm.compiler.bash

import idm.qsv.Echo

class CompilerBashEcho implements CompilerBash {

	Echo echo

	new(Echo c) {
		echo = c
	}

	override String compile() {
		return ""
	}

}
