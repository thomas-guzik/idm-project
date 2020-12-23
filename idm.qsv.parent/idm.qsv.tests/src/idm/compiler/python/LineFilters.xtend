package idm.compiler.python

import idm.qsv.Condition
import idm.qsv.HighestPriority
import idm.qsv.MidPriority

class LineFilters {

	Integer filterCount = 0
	String code
	String csvDataVariable
	extension ConcreteValues pythonValues

	new(String v) {
		csvDataVariable = v
		pythonValues = new ConcreteValues
	}
	
	def String createFilter(Condition condition, String endFilter) {
		code = ""
		var filter = condition.compileFilterRec
		code += '''«endFilter» = «filter»'''
		code += PythonCompiler.NEWLINE
		return code
	}
	
	
	private def String compileFilterRec(Condition condition) {
		var filter = condition.mid.compileFilterRec
		var or = condition.orCondition
		if (or !== null) {
			var rightSideFilter = or.compileFilterRec
			var orFilter = createNewFilterName()
			code += '''«orFilter» = «filter» | «rightSideFilter»'''
			code += PythonCompiler.NEWLINE
			filter = orFilter
		}
		return filter
	}

	private def String compileFilterRec(MidPriority mid) {
		var filter = mid.high.compileFilter
		var and = mid.andCondition
		if (and !== null) {
			var rightSideFilter = and.compileFilterRec
			var andFilter = createNewFilterName()
			code += '''«andFilter» = «filter» & «rightSideFilter»'''
			code += PythonCompiler.NEWLINE
			filter = andFilter
		}
		return filter
	}

	private def String compileFilter(HighestPriority high) {
		var baseCondition = high.baseCondition
		var nestedCondition = high.nestedCondition
		if (baseCondition !== null) {
			var filter = createNewFilterName()
			var String column = baseCondition.columnId.pythonColumn
			var String operator = baseCondition.operator.pythonOperator
			var String value = baseCondition.compValue.pythonValue
			code += '''«filter» = «csvDataVariable»[«column»] «operator» «value»'''
			code += PythonCompiler.NEWLINE
			return filter
		}
		if (nestedCondition !== null) {
			return nestedCondition.compileFilterRec
		}
		throw new MissingConcreteImplementationException("HighestPriority")
	}

	def String createNewFilterName() {
		return PythonCompiler.newFilterName
	}

}
