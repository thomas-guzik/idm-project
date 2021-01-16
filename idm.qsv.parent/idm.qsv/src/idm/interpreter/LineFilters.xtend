package idm.interpreter

import idm.compiler.python.MissingConcreteImplementationException
import idm.interpreter.csv.And
import idm.interpreter.csv.CsvData
import idm.interpreter.csv.Filter
import idm.interpreter.csv.Nested
import idm.interpreter.csv.Or
import idm.interpreter.csv.Single
import idm.qsv.Condition
import idm.qsv.HighestPriority
import idm.qsv.MidPriority

class LineFilters {

	String code
	CsvData csvData
	extension ConcreteValues values

	new(CsvData data) {
		csvData = data
		values = new ConcreteValues
	}
	
	def void createFilter(Condition condition) {
		val filter = condition.compileFilterRec
		csvData.apply(filter)
	}
	
	
	private def Filter compileFilterRec(Condition condition) {
		var leftSidefilter = condition.mid.compileFilterRec
		var or = condition.orCondition
		if (or !== null) {
			var rightSideFilter = or.compileFilterRec
			val orFilter = new Or(leftSidefilter, rightSideFilter)
			return orFilter
		}
		return leftSidefilter
	}

	private def Filter compileFilterRec(MidPriority mid) {
		var leftSidefilter = mid.high.compileFilter
		var and = mid.andCondition
		if (and !== null) {
			var rightSideFilter = and.compileFilterRec
			var andFilter = new And(leftSidefilter, rightSideFilter)
			return andFilter
		}
		return leftSidefilter
	}

	private def Filter compileFilter(HighestPriority high) {
		var baseCondition = high.baseCondition
		var nestedCondition = high.nestedCondition
		if (baseCondition !== null) {
			return new Single(baseCondition)
		}
		if (nestedCondition !== null) {
			return new Nested(nestedCondition.compileFilterRec)
		}
		throw new MissingConcreteImplementationException("HighestPriority")
	}

}
