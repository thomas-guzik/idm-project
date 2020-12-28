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

class CompilerBashQsv extends CompilerBash {
	QuerySeparatedValues qsv
	Boolean hasColumnName
	String separator

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
			println("ici")
			code += s.compile();
		}
		return code
	}

	def Header analyze(Header header) {
		separator = "," // TODO Penser à ajouter la selection du separateur dans la grammaire
		hasColumnName = header.isHasColumnName()
		return header
	}

	def String genCode(Header header) {
		return '''
			#!/bin/bash
			OLD_IFS=$IFS
			IFS="«separator»"
			exec < «header.getNameFile()»
			«IF hasColumnName»
				read -a header
			«ENDIF»
		'''
	}

	def dispatch String compile(Statement statement) {
		throw new Exception()
	}

	def dispatch String compile(Compute compute) {
		return new CompilerBashCompute(compute).compile()
	}

	def dispatch String compile(Echo echo) {
		return new CompilerBashEcho(echo).compile()
	}

	def dispatch String compile(Print print) {
		return new CompilerBashPrint(print, hasColumnName).compile()
	}

	def dispatch String compile(Update update) {
		return new CompilerBashUpdate(update).compile()
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
