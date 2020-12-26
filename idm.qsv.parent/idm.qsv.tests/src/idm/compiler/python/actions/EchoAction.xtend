package idm.compiler.python.actions

import idm.compiler.python.ConcreteValues
import idm.compiler.python.PythonCompiler
import idm.qsv.Echo

class EchoAction implements Action {
	Echo echo
	String code

	extension ConcreteValues pythonValues

	new(Echo e) {
		echo = e
		pythonValues = new ConcreteValues
	}

	override compile() {
		code = ""
		code += '''«PythonCompiler.PRINT_FUNCTION_NAME»(«echo.variable.pythonValue»)'''
		code += PythonCompiler.NEWLINE
		return code
	}

}
