package idm.interpreter.csv

import java.util.List

class Nested implements Filter {
	Filter nested

	new(Filter n) {
		nested = n
	}
	
	override eval(List<String> names, List<String> values) {
		return nested.eval(names, values)
	}
	
	
}
