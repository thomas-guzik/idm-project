package idm.compiler.bash

import com.google.common.io.Files

import idm.qsv.QuerySeparatedValues
import idm.qsv.Header
import idm.qsv.Statement
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
import idm.qsv.Compute
import idm.qsv.Echo
import idm.qsv.Print
import idm.qsv.Update
import idm.qsv.Insert
import idm.qsv.Delete
import idm.qsv.Save

class QsvBashCompiler implements BashCompiler {
	QuerySeparatedValues qsv
	Boolean hasColumnName
	String csvSep
	String nameFile

	new(QuerySeparatedValues q) {
		qsv = q
		hasColumnName = false
	}

	def TerminalOutput run(String code) {
		return code.executeOnFile("tmp.sh")
	}

	override String compile() {
		var String code = ""
		code += qsv.getHeader().analyze().genCode();
		for (Statement s : qsv.getStatements()) {
			code += s.compile();
		}
		return code
	}

	def Header analyze(Header header) {
		hasColumnName = header.isHasColumnName()
		nameFile = header.nameFile
		if(header.csvSep !== null) {
			csvSep = header.csvSep
		}
		else {
			csvSep = ","
		}
		BashCompilerHelper.setCsvSep(csvSep)
		BashCompilerHelper.setHasColumnName(hasColumnName)
		return header
	}

	def String genCode(Header header) {
		return '''
			#!/bin/bash
			OLD_IFS=$IFS
			IFS="«csvSep»"
			file=$(cat «nameFile»)
			lastColIndex=$(( $(head -1 <(echo "$file") | tr '«csvSep»' '\n' | wc -l) - 1))
			index=$(seq -s ',' 0 $lastColIndex)
		'''
	}

	def dispatch String compile(Statement statement) {
		throw new Exception()
	}

	def dispatch String compile(Compute compute) {
		return new ComputeBashCompiler(compute).compile()
	}
	
	def dispatch String compile(Delete delete) {
		return new DeleteBashCompiler(delete, hasColumnName, csvSep).compile()
	}

	def dispatch String compile(Echo echo) {
		return new EchoBashCompiler(echo).compile()
	}
	
	def dispatch String compile(Insert insert) {
		return new InsertBashCompiler(insert, csvSep).compile()
	}

	def dispatch String compile(Print print) {
		return new PrintBashCompiler(print, hasColumnName, csvSep).compile()
	}
	
	def dispatch String compile(Save save) {
		return new SaveBashCompiler(save, nameFile, hasColumnName).compile()
	}

	def dispatch String compile(Update update) {
		return new UpdateBashCompiler(update, hasColumnName, csvSep).compile()
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
		}

		var String err
		var String error = ""
		while ((err = stdError.readLine()) !== null) {
			error += err + "\n"
		}
		return new TerminalOutput(output, error)
	}

}
