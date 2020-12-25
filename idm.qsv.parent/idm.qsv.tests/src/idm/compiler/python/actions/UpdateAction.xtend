package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.LineFilters
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.Insertion
import idm.qsv.Update

class UpdateAction implements Action {
	Update update
	String csvDataVariable
	String code

	extension LineFilters lineFiltering
	extension ConcreteValues pythonValues

	new(Update u, String dataVariable) {
		update = u
		csvDataVariable = dataVariable
		lineFiltering = new LineFilters(csvDataVariable)
		pythonValues = new ConcreteValues
	}

	override compile() {
		code = ""
		val value = update.value.pythonValue
		val columns = update.columns.pythonNames
		if (update.cond !== null) {
			var filter = PythonCompiler.newFilterName
			code += update.cond.createFilter(filter)
			for (String column : columns) {
				code += '''«csvDataVariable».loc[«filter», «column»] = «value»'''
				code += PythonCompiler.NEWLINE
			}
		} else {
			for (String column : columns) {
				code += '''«csvDataVariable»[«column»] = «value»'''
				code += PythonCompiler.NEWLINE
			}
		}
		return code
	}

	private def dispatch insert(Insertion insertion) {
		throw new MissingConcreteImplementationException("Insertion")
	}

}
