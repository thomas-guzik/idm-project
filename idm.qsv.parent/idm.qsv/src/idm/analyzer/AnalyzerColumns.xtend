package idm.analyzer

import idm.qsv.Columns
import java.util.ArrayList
import java.util.List

enum ColumnSelectType {
	ALL,
	NAME,
	NUMBER
}

class AnalyzerColumns {

	Columns columns
	List<String> cols

	ColumnAnalyzer analyzerColumn

	new(Columns c) {
		columns = c
		cols = new ArrayList<String>()

		if (columns.columns !== null) {
			analyzerColumn = new ColumnAnalyzer(columns.columns)
		} else {
			analyzerColumn = null
		}
	}

	def getColumnSelectType() {
		if (analyzerColumn !== null) {
			return analyzerColumn.getColumnSelectType()
		} else {
			return ColumnSelectType.ALL
		}
	}

	def getColumnsList() {
		if (analyzerColumn !== null) {
			return analyzerColumn.getColumnsList()
		} else {
			return cols
		}
	}
}
