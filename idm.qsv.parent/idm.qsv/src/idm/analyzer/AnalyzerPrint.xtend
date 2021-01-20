package idm.analyzer

import idm.qsv.Print
import idm.qsv.Format
import idm.qsv.PrettyFormat
import idm.qsv.SeparatorFormat

enum FormatType {
	DEFAULT,
	PRETTY,
	SEPARATOR
}

class AnalyzerPrint {

	Print print
	FormatType formatType
	String separator

	new(Print print) {
		this.print = print
		print.analyze()
	}

	def void analyze(Print print) {
		if (print.format !== null) {
			print.format.analyzeFormat()
		} else {
			formatType = FormatType.DEFAULT
			separator = "\t"
		}
	}

	def dispatch void analyzeFormat(Format format) {}

	def dispatch void analyzeFormat(PrettyFormat format) {
		formatType = FormatType.PRETTY
		separator = "\t"
	}

	def dispatch void analyzeFormat(SeparatorFormat format) {
		formatType = FormatType.SEPARATOR
		separator = format.separator
	}

	def FormatType getFormatType() {
		return formatType
	}

	def String getSeparator() {
		return separator
	}
}
