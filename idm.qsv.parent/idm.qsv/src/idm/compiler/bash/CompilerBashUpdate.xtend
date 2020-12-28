package idm.compiler.bash

import idm.qsv.Update

class CompilerBashUpdate extends CompilerBash {

	Update update

	new(Update u) {
		update = u
	}

	override String compile() {
		return ""
	}
}
