package idm.compiler

import com.google.common.io.Files

import idm.qsv.QuerySeparatedValues
import idm.qsv.Header
import idm.qsv.Statement
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
import idm.qsv.Print
import idm.qsv.Selector
import idm.qsv.ColumnName
import idm.qsv.Column

class BashCompiler {
	QuerySeparatedValues qsv
	String csvDataVariable
	
	String separator
	Boolean hasColumnName
	
	String[] cols
	String[] lines

	new() {
	}

	new(QuerySeparatedValues q) {
		qsv = q
	}

	def setQsv(QuerySeparatedValues q) {
		qsv = q
		return this
	}

	def TerminalOutput run(String code) {
		return code.executeOnFile("tmp.sh")
	}

	def String compile() {
		var String code = ""
		code += qsv.getHeader().compile();
		for (Statement s : qsv.getStatements()) {
			code += s.compile();
		}
		return code
	}

	def String compile(Header header) {
		var code = ""
		
		var String nameFile = qsv.getHeader().getNameFile()
		hasColumnName = header.isHasColumnName()
		separator = ","
		
		code += '''OLD_IFS=$IFS'''
		
		if(hasColumnName){
			code += '''IFS="«separator»" read -a columnNames <<< head -1 «nameFile»'''
		}
		
		code += '''f=cat   «nameFile»'''
		
		return code
	}

	def String compile(Statement statement) {
	}
	
	def compile(Print print) {
		print.getSelector().compile()
		return "rien"
		
	}
	
	def compile(Selector selector) {
		var columnSelection =  selector.getColumnSelection()
		var lineSelection = selector.getLineSelection()
		
		if(columnSelection === null) {
			cols = #[]
		} else {
			columnSelection.columns.forEach[e |
				e.compile()
			]
		}
		
		if(lineSelection === null) {
			
		} else {
			
		}
	}
	
	def compile(Column c){
		println("what happend ?")
	} 
	
	def compile(ColumnName c) {
		
	}

	def TerminalOutput executeOnFile(String code, String filename) {
		Files.write(code.getBytes(), new File(filename))
		var Process p = Runtime.getRuntime().exec('''bash «filename»''')
		var BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()))
		var BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()))

		var String o
		var String output = ""
		while ((o = stdInput.readLine()) !== null) {
			output += o + "\n"
			println(o)
		}

		var String err
		var String error = ""
		while ((err = stdError.readLine()) !== null) {
			error += err + "\n"
			println(err)
		}
		return new TerminalOutput(output, error)
	}

}
