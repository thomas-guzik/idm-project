package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.MissingConcreteImplementationException
import idm.compiler.python.PythonCompiler
import idm.qsv.Compute
import idm.qsv.Function
import idm.qsv.SumColumns
import idm.qsv.SumValuesInColumn

class ComputeAction implements Action {
	Compute compute
	String csvDataVariable
	String code

	extension ConcreteValues pythonValues

	new(Compute c, String dataVariable) {
		compute = c
		csvDataVariable = dataVariable
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

	private def dispatch compile(SumValuesInColumn sumLines, String variable) {
		val column = sumLines.column.pythonColumn
		code += '''«variable» = «csvDataVariable»[«column»].sum()'''
	}

	private def dispatch compile(SumColumns sumLines, String variable) {
		val pythonColumnsVariable = "cols_to_sum"
		val pythonColumns = '''[«sumLines.columns.map[c|c.pythonColumn].join(", ")»]'''
		code += '''«pythonColumnsVariable» = «pythonColumns»'''
		code += PythonCompiler.NEWLINE
		code += '''all_int = all([is_numeric_dtype(«csvDataVariable»[col]) for col in «pythonColumnsVariable»])'''
		code += PythonCompiler.NEWLINE
		code += '''
		if all_int:
			«variable» = «csvDataVariable»[«pythonColumnsVariable»].sum(axis=1)
		else:
			«variable» = functools.reduce(lambda a,b: «csvDataVariable»[a].map(str) + «csvDataVariable»[b].map(str), «pythonColumnsVariable»)'''
		code += PythonCompiler.NEWLINE
		code += PythonCompiler.NEWLINE
	}

}
