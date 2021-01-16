package idm.interpreter.csv

import java.util.List

interface Filter {
	
	def boolean eval(List<String> names, List<String> values)
	
}