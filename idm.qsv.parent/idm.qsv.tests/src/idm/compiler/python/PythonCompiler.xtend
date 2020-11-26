package idm.compiler.python

import com.google.common.io.Files
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.Columns
import idm.qsv.Header
import idm.qsv.Lines
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.stream.Collectors

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

	private def dispatch compile(Header header) {
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

	private def dispatch compile(Print print) {
		var code = ""
		if (print.selector !== null) {
			val Columns columnSelection = print.selector.columnSelection
			if (columnSelection !== null) {
				code += columnSelection.select()
			}
			val Lines lines = print.selector.lineSelection
		}
		code += '''print(«csvDataVariable»)'''
		return code
	}

	private def select(Columns selection) {
		var code = '''«csvDataVariable» = «csvDataVariable»[['''
		var codeNames = selection.columns.getNames().stream().map([name|'''"«name»"''']).collect(Collectors.toList)
		code += codeNames.join(',')
		code += "]]\n"
		return code
	}

	private def dispatch getNames(Column column) {
		return new ArrayList<String>()
	}

	private def dispatch getNames(ColumnNames names) {
		return names.ids.toList
	}

	private def dispatch getNames(ColumnNumbers numbers) {
		return new ArrayList<String>()
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
