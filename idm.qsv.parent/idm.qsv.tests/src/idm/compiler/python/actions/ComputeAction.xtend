package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.LineFilters
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumLines

class ComputeAction implements Action {
	Compute compute
	String csvDataVariable
	String code

	extension LineFilters lineFiltering
	extension ConcreteValues pythonValues

	new(Compute c, String dataVariable) {
		compute = c
		csvDataVariable = dataVariable
		lineFiltering = new LineFilters(csvDataVariable)
		pythonValues = new ConcreteValues
	}

	override compile() {
		code = ""
		val variable = compute.variable.pythonValue
		compute.function.compile(variable)
		code += PythonCompiler.NEWLINE
		return code
	}

	private def dispatch compile(Function function, String variable) {
		throw new MissingConcreteImplementationException("Function")
	}

	private def dispatch compile(SumLines sumLines, String variable) {
		val column = sumLines.column.pythonColumn
		code += '''«variable» = «csvDataVariable»[«column»].sum()'''
	}

}
