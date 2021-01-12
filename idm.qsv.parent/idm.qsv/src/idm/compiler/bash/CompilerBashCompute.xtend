package idm.compiler.bash

import idm.qsv.Compute

class CompilerBashCompute implements CompilerBash {

	Compute compute

	new(Compute c) {
		compute = c
	}

	override String compile() {
		return ""
	}

}
