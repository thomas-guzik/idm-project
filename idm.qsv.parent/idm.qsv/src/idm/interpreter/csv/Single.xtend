package idm.interpreter.csv

import idm.interpreter.ConcreteValues
import idm.qsv.BinCond
import java.util.List

class Single implements Filter {

	BinCond condition
	extension ConcreteValues values

	new(BinCond c) {
		condition = c
		values = new ConcreteValues
	}

	override eval(List<String> names, List<String> values) {
		val columnName = condition.columnId.columnId
		val function = condition.operator.operator
		val comparisonValue = condition.compValue.value
		var Object actualValue = values.get(names.indexOf(columnName))
		if (actualValue.class !== comparisonValue.class) {
			try {
				actualValue = Integer.parseInt(actualValue + "")
			} catch (NumberFormatException exception) {
				return false
			}
		}
		return function.apply(actualValue, comparisonValue)
	}

}
