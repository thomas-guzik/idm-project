package idm.compiler.bash

import idm.qsv.Update

class CompilerBashUpdate implements CompilerBash {

	Update update

	new(Update u) {
		update = u
	}

	override String compile() {
		return ""
	}
}
