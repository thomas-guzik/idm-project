package idm.analyzer

import idm.qsv.Condition
import idm.qsv.MidPriority
import idm.qsv.HighestPriority
import idm.qsv.BinCond
import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNumberIdentifier
import idm.qsv.ColumnNameIdentifier
import java.util.Set
import java.util.HashSet

class AnalyzerCondition {

	Condition condition
	Set<String> colSelectedByNumber = new HashSet<String>()
	Set<String> colSelectedByName = new HashSet<String>()

	new(Condition c) {
		condition = c
		condition.analyze()
	}

	def getColSelectedByNumber() {
		return colSelectedByNumber
	}

	def getColSelectedByName() {
		return colSelectedByName
	}

	def void analyze(Condition c) {
		c.mid.analyze()
		if (c.orCondition !== null) {
			c.orCondition.analyze()
		}
	}

	def void analyze(MidPriority m) {
		m.high.analyze()
		if (m.andCondition !== null) {
			m.andCondition.analyze()
		}
	}

	def void analyze(HighestPriority h) {
		if (h.nestedCondition !== null) {
			h.nestedCondition.analyze()
		} else if (h.baseCondition !== null) {
			h.baseCondition.analyze()
		}
	}

	def void analyze(BinCond b) {
		b.columnId.analyzeColumnIdentifier()
	}

	def dispatch void analyzeColumnIdentifier(ColumnIdentifier c) {}

	def dispatch void analyzeColumnIdentifier(ColumnNumberIdentifier c) {
		colSelectedByNumber.add(c.value.substring(1))
	}

	def dispatch void analyzeColumnIdentifier(ColumnNameIdentifier c) {
		colSelectedByName.add(c.value)
	}
}
