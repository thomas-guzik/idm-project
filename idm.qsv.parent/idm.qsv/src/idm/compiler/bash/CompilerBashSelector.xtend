package idm.compiler.bash

import idm.qsv.Selector
import java.util.ArrayList
import idm.qsv.Lines
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.LineRange
import idm.qsv.Line
import idm.qsv.Condition
import idm.qsv.MidPriority
import idm.qsv.HighestPriority
import idm.qsv.BinCond
import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNameIdentifier
import idm.qsv.ColumnNumberIdentifier
import idm.qsv.OpComp
import idm.qsv.CompareEqual
import idm.qsv.CompareNotEqual
import idm.qsv.CompareLower
import idm.qsv.CompareGreater
import idm.qsv.CompareLowerOrEqual
import idm.qsv.CompareGreaterOrEqual
import idm.qsv.Value
import idm.qsv.IntegerValue
import idm.qsv.StringValue
import idm.qsv.VariableIdentifier
import idm.qsv.BooleanValue

enum ColSelectType {
	ALL,
	BYNAME,
	BYNUMBER
}

enum ValueType {
	INT,
	STRING,
	BOOL
}

class CompilerBashSelector extends CompilerBash {

	Selector selector
	Boolean hasColumnName
	ColSelectType colSelectType
	ArrayList<String> cols
	String nameFile
	String csvSep
	String colSep

	Lines lines
	ArrayList<String> beforeCond
	ArrayList<String> locName

	new(Selector s, Boolean hasColumnName, String nameFile, String separator) {
		selector = s
		this.hasColumnName = hasColumnName
		this.nameFile = nameFile
		this.csvSep = separator
		colSep = " "

		colSelectType = ColSelectType.ALL
		cols = newArrayList
		lines = null
		beforeCond = newArrayList
		locName = newArrayList

	}

	def genBeforeWhile() {
		return '''
			header=`head -1 «nameFile»`
			«IF colSelectType == ColSelectType.ALL»
				nbCol=$(( `echo "$header" | tr '«csvSep»' '\n' | wc -l` - 1))
			«ENDIF»
			«genLocVariable»
		'''
	}

	def genLocVariable() {
		switch (colSelectType) {
			case ColSelectType.BYNAME: {
				return '''
					«FOR c : cols»
						cut_«c»=`echo "$header" | tr '«csvSep»' '\n' | nl | grep -w "«c»" | tr -d " " |  awk -F " " '{print $1}'`
						loc_«c»=$(( $cut_«c» - 1))
					«ENDFOR»
				'''
			}
			default: {
				return '''
					«FOR v : locName»
						loc_«v»=$(( `echo "$header" | tr '«csvSep»' '\n' | nl | grep -w "«v»" | tr -d " " |  awk -F " " '{print $1}'` - 1))
					«ENDFOR»
				'''
			}
		}
	}

	def genInput() {
		switch (colSelectType) {
			case ColSelectType.ALL: {
				if (hasColumnName) {
					return '''<(tail -n +2 «nameFile»)'''
				} else {
					return nameFile
				}
			}
			case ColSelectType.BYNAME: {
				return '''
					<(cut -d "«csvSep»" -f $cut_«String.join(",$cut_", cols)»  «nameFile» | tail -n +2)
				'''
			}
			case ColSelectType.BYNUMBER: {
				return '''
					<(cut -d "«csvSep»" -f «String.join(",", cols.map[c | String.valueOf(Integer.valueOf(c)+1)])» «nameFile» «IF hasColumnName»| tail -n +2 «ENDIF»)
				'''
			}
		}
	}

	def genColTitle() {
		switch (colSelectType) {
			case ColSelectType.ALL: {
				if (hasColumnName) {
					return '''echo "  `echo "$header" | tr '«csvSep»' '«colSep»'`"'''
				} else {
					return '''echo "  `seq -s '«colSep»' 0 $nbCol`"'''
				}
			}
			case ColSelectType.BYNAME: {
				return '''
					echo "  `echo "$header" | cut -d "«csvSep»" -f $cut_«String.join(",$cut_", cols)» | tr ',' ' '`"
				'''
			}
			case ColSelectType.BYNUMBER: {
				if (hasColumnName) {
					return '''
						echo "  `echo "$header" | cut -d "«csvSep»" -f «String.join(",", cols.map[c | String.valueOf(Integer.valueOf(c)+1)])» | tr ',' ' '`"
					'''
				} else {
					return '''
						echo "  «String.join(colSep, cols)»"
					'''
				}
			}
			default: {
				return ""
			}
		}
	}

	def genRead() {
		switch (colSelectType) {
			case ColSelectType.ALL: {
				return '''-a c'''
			}
			case ColSelectType.BYNAME: {
				return '''c$loc_«String.join(" c$loc_", cols)»'''
			}
			case ColSelectType.BYNUMBER: {
				return '''c«String.join(" c", cols)»'''
			}
		}
	}

	def genEcho() {
		switch (colSelectType) {
			case ColSelectType.ALL: {
				return '''$(eval echo '${c['`seq -s ']} ${c[' 0 $nbCol`]'}')'''
			}
			case ColSelectType.BYNAME: {
				return '''$(eval echo '$c'$loc_«String.join(" '$c'$loc_", cols)»)'''
			}
			case ColSelectType.BYNUMBER: {
				return '''$c«String.join(" $c", cols)»'''
			}
		}
	}

	def analyze() {
		if (selector !== null) {
			selector.analyze()
		}
	}

	def analyze(Selector selector) {
		var columnSelection = selector.getColumnSelection()

		if (columnSelection !== null) {
			if (columnSelection.columns !== null) {
				columnSelection.columns.analyzeColumn()
			}
		}

		if (selector.lineSelection !== null) {
			lines = selector.lineSelection
		}
		return this
	}

	def dispatch analyzeColumn(Column c) {}

	def dispatch analyzeColumn(ColumnNames c) {
		if (hasColumnName == false) {
			throw new Exception("You select columns name but file hasn't columns name")
		}
		c.getNames().forEach[n|cols.add(n)]
		colSelectType = ColSelectType.BYNAME
	}

	def dispatch analyzeColumn(ColumnNumbers c) {
		c.numbers.forEach[n|cols.add(n.substring(1))]
		colSelectType = ColSelectType.BYNUMBER
	}

	def analyzeAndgenCodeLines() {
		if (lines !== null) {
			return lines.genCode()
		} else {
			return ""
		}
	}

	def genCode(Lines lines) {
		var code = ""
		if (lines.range !== null) {
			code += lines.range.genCode();
		} else if (lines.line !== null) {
			code += lines.line.genCode();
		}
		if (lines.cond !== null) {
			if (!code.isEmpty) {
				code += " && "
			}
			code += lines.cond.genCode();
		}
		code = code
		return code
	}

	def genCode(LineRange range) {
		return ''' $n -ge «range.start» && $n -le «range.end» '''
	}

	def genCode(Line line) {
		return ''' $n -eq «line.number» '''
	}

	def String genCode(Condition cond) {
		var code = cond.mid.genCode()
		if (cond.orCondition !== null) {
			code += " || " + cond.orCondition.genCode()
		}
		return code
	}

	def String genCode(MidPriority mid) {
		var code = mid.high.genCode()
		if (mid.andCondition !== null) {
			code += " && " + mid.andCondition.genCode()
		}
		return code
	}

	def String genCode(HighestPriority high) {
		if (high.baseCondition !== null) {
			return high.baseCondition.genCode()
		} else if (high.nestedCondition !== null) {
			return ''' ( «high.nestedCondition.genCode()» )'''
		} else {
			throw new Exception("Error during conditions analyzing")
		}
	}

	def genCode(BinCond bin) {
		var type = bin.compValue.analyzeValue()

		var code = bin.columnId.genCodeColumnIdentifier()
		code += bin.operator.genCodeOperator(type)
		code += bin.compValue.genCodeValue()
		return code
	}

	def dispatch genCodeColumnIdentifier(ColumnIdentifier c) {}

	def dispatch genCodeColumnIdentifier(ColumnNumberIdentifier c) {
		var v = c.value.substring(1)

		if (colSelectType === ColSelectType.ALL) {
			return ''' ${c[«v»]}'''
		} else {
			return ''' $c«v»'''
		}
	}

	def dispatch genCodeColumnIdentifier(ColumnNameIdentifier c) {
		var v = c.value
		var before = ""

		if (!locName.contains(v)) {
			locName.add(v)
		}

		if (colSelectType === ColSelectType.ALL) {
			before = '''id_«v»=${c[$loc_«v»]}'''
			if (!beforeCond.contains(before)) {
				beforeCond.add(before)
			}
			return ''' $id_«v» '''
		} else {
			before = '''id_«v»=$(eval echo '$c'$loc_«v»)'''
			if (!beforeCond.contains(before)) {
				beforeCond.add(before)
			}
			return ''' $id_«v»'''
		}
	}

	def dispatch analyzeValue(Value v) {}

	def dispatch analyzeValue(IntegerValue v) { return ValueType.INT }

	def dispatch analyzeValue(StringValue v) { return ValueType.STRING }

	def dispatch analyzeValue(BooleanValue v) {
		return ValueType.BOOL
	}

	def dispatch analyzeValue(VariableIdentifier v) {
		throw new Exception("Variable not implemented")
	}

	def dispatch genCodeOperator(OpComp op, ValueType t) {}

	def dispatch genCodeOperator(CompareEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return " -eq"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return " ="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareNotEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return " -ne"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			return " !="
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLower op, ValueType t) {
		if (t === ValueType.INT) {
			return " -lt"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreater op, ValueType t) {
		if (t === ValueType.INT) {
			return " -gt"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareLowerOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return " -le"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with lower or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeOperator(CompareGreaterOrEqual op, ValueType t) {
		if (t === ValueType.INT) {
			return " -ge"
		} else if (t === ValueType.STRING || t === ValueType.BOOL) {
			throw new Exception("Only integer can be compare with greater or equal operator")
		} else {
			throw new Exception("Error during generating code for condition")
		}
	}

	def dispatch genCodeValue(Value v) {}

	def dispatch genCodeValue(IntegerValue v) { return ''' «v.value» ''' }

	def dispatch genCodeValue(StringValue v) { return ''' «v.value» ''' }

	def dispatch genCodeValue(BooleanValue v) { return v.truthy ? " 1 " : " 0 " }

	def dispatch genCodeValue(VariableIdentifier v) {
		throw new Exception("Variable not implemented")
	}

	def getBeforeCond() {
		return beforeCond
	}

}
