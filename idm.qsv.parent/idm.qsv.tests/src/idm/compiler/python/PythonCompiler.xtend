package idm.compiler.python

import com.google.common.io.Files
import idm.compiler.python.actions.ComputeAction
import idm.compiler.python.actions.DeleteAction
import idm.compiler.python.actions.EchoAction
import idm.compiler.python.actions.InsertAction
import idm.compiler.python.actions.PrintAction
import idm.compiler.python.actions.UpdateAction
import idm.qsv.Compute
import idm.qsv.Delete
import idm.qsv.Echo
import idm.qsv.Header
import idm.qsv.Insert
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Statement
import idm.qsv.Update
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

class PythonCompiler {
	QuerySeparatedValues qsv
	String csvDataVariable
	public static String NEWLINE = "\n"
	public static String PRINT_FUNCTION_NAME = "printData"
	static Integer filterCount = 0
	String printIfNotEmptyFunction = '''def «PRINT_FUNCTION_NAME»(data):
    if type(data) is pd.DataFrame:
        if data.empty:
            print()
            return
    print(data)
	    '''

	new(QuerySeparatedValues q) {
		qsv = q
	}

	def PythonCompilerOutput compileAndRun() throws IOException {
		csvDataVariable = "my_data"
		var pythonCode = compile()
		println(pythonCode)
		var String PYTHON_OUTPUT = "foo.py"
		return writeToFileAndExecute(PYTHON_OUTPUT, pythonCode)
	}

	private def String compile() {
		var String pythonCode = ""
		pythonCode += "import pandas as pd"
		pythonCode += NEWLINE
		pythonCode += printIfNotEmptyFunction
		pythonCode += NEWLINE
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

	private def dispatch compile(Delete delete) {
		var deleter = new DeleteAction(delete, csvDataVariable)
		var code = deleter.compile
		return code
	}

	private def dispatch compile(Insert delete) {
		var inserter = new InsertAction(delete, csvDataVariable)
		var code = inserter.compile
		return code
	}

	private def dispatch compile(Update update) {
		var updater = new UpdateAction(update, csvDataVariable)
		var code = updater.compile
		return code
	}

	private def dispatch compile(Compute compute) {
		var computer = new ComputeAction(compute, csvDataVariable)
		var code = computer.compile
		return code
	}

	private def dispatch compile(Echo echo) {
		var echoer = new EchoAction(echo)
		var code = echoer.compile
		return code
	}

	static def getNewFilterName() {
		return "filter" + filterCount++
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
