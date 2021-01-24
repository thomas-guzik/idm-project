package idm.compiler.python

import com.google.common.io.Files
import idm.compiler.python.actions.ComputeAction
import idm.compiler.python.actions.DeleteAction
import idm.compiler.python.actions.EchoAction
import idm.compiler.python.actions.InsertAction
import idm.compiler.python.actions.PrintAction
import idm.compiler.python.actions.SaveAction
import idm.compiler.python.actions.UpdateAction
import idm.qsv.Compute
import idm.qsv.Delete
import idm.qsv.Echo
import idm.qsv.Header
import idm.qsv.Insert
import idm.qsv.Print
import idm.qsv.QuerySeparatedValues
import idm.qsv.Save
import idm.qsv.Statement
import idm.qsv.Update
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

class PythonCompiler {
	QuerySeparatedValues qsv
	String csvDataVariable
	String columnIndexVariable = "column_index"
	String csvFileName
	public static String NEWLINE = "\n"
	public static String PRINT_FUNCTION_NAME = "print_data"
	public static String PRINT_SEPARATOR_FUNCTION_NAME = "print_data_separator"
	public static String PRINT_PRETTY_FUNCTION_NAME = "print_data_pretty"
	static Integer filterCount = 0
	static Integer tmpVariableCount = 0
	String printIfNotEmptyFunction = '''def «PRINT_FUNCTION_NAME»(data):
    if type(data) is pd.DataFrame:
        if data.empty:
            printed = ""
            for col in data.columns:
                printed += "\t" + str(col)
            print(printed)
            return
    if type(data) is pd.Series:
    	print(data.to_string())
    	return
    print(data)
	    '''

	String printSeparatorIfNotEmptyFunction = '''def «PRINT_SEPARATOR_FUNCTION_NAME»(data, separator):
    if type(data) is pd.DataFrame:
        if data.empty:
            printed = ""
            for col in data.columns:
                printed += separator + str(col)
            print(printed)
            return
        print_data_frame(data, separator)
        return
    if type(data) is pd.Series:
        print(data.to_string())
        return
    print(data)

def print_data_frame(data, separator):
    table_to_print = separator
    table_to_print += separator.join(map(str, data.columns))
    table_to_print += "\n"
    lines_to_print = []
    for i, line in zip(data.index, data.values):
        line_to_print = str(i) + separator
        line_to_print += separator.join(map(str, line))
        lines_to_print.append(line_to_print)
    table_to_print += "\n".join(lines_to_print)
    print(table_to_print)
	    '''

	String printPrettyIfNotEmptyFunction = '''def «PRINT_PRETTY_FUNCTION_NAME»(data):
    if type(data) is pd.DataFrame:
        print_data_frame_pretty(data)
        return
    if type(data) is pd.Series:
	    print(data.to_string())
	    return
    print(data)

def print_data_frame_pretty(data):
    separator = "  "
    if(len(data.values) > 0):
        size_largest_column_nb = size_largest_word_of_column(data.index)
        printed = [" " * (size_largest_column_nb) + separator]
        for line_i, i in zip(data.index, range(0, len(data.index))):
            printed.append(str(line_i) + " " * (size_largest_column_nb - word_size(str(line_i))) + separator)
        for i in range(0, len(data.columns)):
            col_i = data.columns[i]
            not_last_column = i != len(data.columns) - 1
            col_width = word_size(col_i)
            target_size = size_largest_word_of_column(data[col_i])
            printed[0] += str(col_i) + (" " * (target_size - col_width) + separator) * not_last_column
            for word, j in zip(data[col_i], range(0, len(data[col_i]))):
                printed[j+1] += str(word) + (" " * (target_size - word_size(word)) + separator) * not_last_column
        print("\n".join(printed))
    else:
        print(separator.join(data.columns))

def size_largest_word_of_column(column):
    max_size = -1
    for word in column:
        max_size = max(len(str(word)), max_size)
    return max_size

def word_size(word):
    return len(str(word))

	    '''

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
		var String pythonCode = ""
		pythonCode += '''
			import pandas as pd
			from pandas.api.types import is_numeric_dtype
			import functools
			«printIfNotEmptyFunction»
			«printSeparatorIfNotEmptyFunction»
			«printPrettyIfNotEmptyFunction»
		'''
		pythonCode += qsv.getHeader().compile()
		for (Statement s : qsv.getStatements()) {
			pythonCode += s.compile();
		}
		return pythonCode
	}

	private def dispatch compile(Header header) {
		csvFileName = qsv.getHeader().getNameFile()
		val hasColumnName = header.isHasColumnName()
		val readSeparator = header.csvSep === null ? "," : header.csvSep
		var code = ""
		code += '''«csvDataVariable» = pd.read_csv("«csvFileName»", header=«hasColumnName? "'infer'" : "None"», sep="«readSeparator»")
'''
		code += NEWLINE
		code += '''«columnIndexVariable» = len(«csvDataVariable».columns)'''
		code += NEWLINE
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
		var inserter = new InsertAction(delete, csvDataVariable, columnIndexVariable)
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

	private def dispatch compile(Save save) {
		var saver = new SaveAction(save, csvDataVariable, csvFileName)
		var code = saver.compile
		return code
	}

	static def getNewFilterName() {
		return "filter" + filterCount++
	}

	static def getNewTmpVariable() {
		return "tmp" + tmpVariableCount++
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
		}
		return new PythonCompilerOutput(output, error)

	}
}
