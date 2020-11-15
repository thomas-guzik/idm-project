package idm.tests

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import com.google.common.io.Files
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement

class PythonCompiler {
	QuerySeparatedValues qsv

	package new(QuerySeparatedValues q) {
		qsv = q
	}

	def void compileAndRun() throws IOException {
		var String python = ""
		var String nameFile = qsv.getHeader().getNameFile()
		var Boolean hasColumnName = qsv.getHeader().isHasColumnName()
		python += "import pandas as pd\n"
		python += '''df = pd.read_csv("«nameFile»")
'''
		for (Statement s : qsv.getStatements()) { // s.compile();
		}
		python += "print(df)"
		// serialize code into Python filename
		var String PYTHON_OUTPUT = "foo.py"
		/*
		 * FileWriter fw = new FileWriter(PYTHON_OUTPUT); fw.write(pythonCode);
		 * fw.flush(); fw.close();
		 */
		// or shorter
		Files.write(python.getBytes(), new File(PYTHON_OUTPUT))
		// execute the generated Python code
		// roughly: exec "python foo.py"
		var Process p = Runtime.getRuntime().exec('''python «PYTHON_OUTPUT»''')
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
