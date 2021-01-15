package idm.interpreter.csv

import java.util.List

class Or implements Filter {
	
	Filter left
	Filter right
	
	new (Filter l, Filter r) {
		left = l
		right = r
	}
	
	override eval(List<String> names, List<String> values) {
		return left.eval(names, values) || right.eval(names, values)
	}
	
}