package idm.compiler.python

import com.google.common.io.Files
import idm.compiler.python.actions.PrintAction
import idm.qsv.Header
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

class PythonCompiler {
	QuerySeparatedValues qsv
	String csvDataVariable

	new(QuerySeparatedValues q) {
		qsv = q
	}

	def PythonCompilerOutput compileAndRun() throws IOException {
		csvDataVariable = "my_data"
		var pythonCode = compile()
		var String PYTHON_OUTPUT = "foo.py"
		println(pythonCode)
		return writeToFileAndExecute(PYTHON_OUTPUT, pythonCode)
	}

	private def String compile() {
		var String pythonCode = ""
		pythonCode += qsv.getHeader().compile()
		for (Statement s : qsv.getStatements()) {
			pythonCode += s.compile();
		}
		return pythonCode
	}

	private def dispatch compile(Header header) {
		var String csvFileName = qsv.getHeader().getNameFile()
		var Boolean hasColumnName = header.isHasColumnName()
		var String code = ""
		code += "import pandas as pd\n"
		code += '''«csvDataVariable» = pd.read_csv("«csvFileName»", header=«hasColumnName? "'infer'" : "None"»)
'''
		return code
	}

	private def dispatch compile(Statement statement) {
		throw new MissingConcreteImplementationException("Statement")
	}

	private def dispatch compile(Print print) {
		var printer = new PrintAction(print, csvDataVariable)
		var code = printer.compile
		return code
	}


	private def writeToFileAndExecute(String fileName, String pythonCode) {
		// or shorter
		Files.write(pythonCode.getBytes(), new File(fileName))
		// execute the generated Python code
		// roughly: exec "python foo.py"
		var Process p = Runtime.getRuntime().exec('''python «fileName»''')
		// output
		var BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()))
		// error
		var BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()))
		var String o
		var String output = ""
		while ((o = stdInput.readLine()) !== null) {
			output += o + "\n"
//			System.out.println(o)
		}
		var String err
		var String error = ""
		while ((err = stdError.readLine()) !== null) {
			error += err + "\n"
			System.out.println(err)
		}
		return new PythonCompilerOutput(output, error)

	}
}
