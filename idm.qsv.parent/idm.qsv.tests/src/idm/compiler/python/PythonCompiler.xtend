package idm.compiler.python

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import com.google.common.io.Files
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
import idm.qsv.Header

class PythonCompiler {
	QuerySeparatedValues qsv

	new(QuerySeparatedValues q) {
		qsv = q
	}

	def void compileAndRun() throws IOException {
		var String python = ""
		python += qsv.getHeader().compile()
		for (Statement s : qsv.getStatements()) {
			python += s.compile();
		}
		python += "print(df)"
		var String PYTHON_OUTPUT = "foo.py"
		writeToFileAndExecute(PYTHON_OUTPUT, python)
		
	}
	
	private def compile(Header header) {
		var String nameFile = qsv.getHeader().getNameFile()
		var String code = ""
		code += "import pandas as pd\n"
		code += '''df = pd.read_csv("«nameFile»")
'''
		var Boolean hasColumnName = header.isHasColumnName()
		return code
	}
	
	private def compile(Statement statement) {
		
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
		while ((o = stdInput.readLine()) !== null) {
			System.out.println(o)
		}
		var String err
		while ((err = stdError.readLine()) !== null) {
			System.out.println(err)
		}
	}
}
