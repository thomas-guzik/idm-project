package idm.compiler.python

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import com.google.common.io.Files
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
import idm.qsv.Header
import idm.qsv.Print

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
		return writeToFileAndExecute(PYTHON_OUTPUT, pythonCode)
	}

	private def String compile() {
		var String python = ""
		python += qsv.getHeader().compile()
		for (Statement s : qsv.getStatements()) {
			python += s.compile();
		}
		return python
	}

	private def compile(Header header) {
		var String nameFile = qsv.getHeader().getNameFile()
		var Boolean hasColumnName = header.isHasColumnName()
		var String code = ""
		code += "import pandas as pd\n"
		code += '''«csvDataVariable» = pd.read_csv("«nameFile»", header=«hasColumnName? "'infer'" : "None"»)
'''
		return code
	}

	private def dispatch compile(Statement statement) {
		return "should this happen?"
	}
	
	private def dispatch compile(Print statement) {
		return '''print(«csvDataVariable»)'''
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
			System.out.println(o)
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
