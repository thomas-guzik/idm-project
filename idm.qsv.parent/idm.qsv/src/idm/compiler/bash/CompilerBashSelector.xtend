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
import java.util.HashMap

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

class CompilerBashSelector implements CompilerBash {

	Selector selector
	Boolean hasColumnName
	ColSelectType colSelectType
	ArrayList<String> colOfColumns
	HashMap<String, ArrayList<String>> colOfConditions
	String csvSep
	String colSep

	ArrayList<String> beforeCond
	Boolean withCondition

	new(Selector s, Boolean hasColumnName, String csvSep, String colSep) {
		selector = s
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep
		this.colSep = colSep

		colSelectType = ColSelectType.ALL
		colOfColumns = newArrayList
		beforeCond = newArrayList
		colOfConditions = new HashMap<String, ArrayList<String>>()
		colOfConditions.put("number", new ArrayList<String>())
		colOfConditions.put("name", new ArrayList<String>())
		withCondition = false

	}

	def genBeforeWhile() {
		return '''
			header=$(echo "$file" | head -1)
			«IF colSelectType == ColSelectType.ALL»
				nbCol=$(( $(echo "$header" | tr '«csvSep»' '\n' | wc -l) - 1))
			«ENDIF»
			«genCutVariable»
			«genLocVariable»
		'''
	}

	def genBeforeWhileDelete() {
		var keyword = ""
		if (colSelectType === ColSelectType.BYNAME) {
			keyword = "header"

		} else if (colSelectType === ColSelectType.BYNUMBER) {
			keyword = "index"
		}
		return
		'''
		«IF hasColumnName»
		header_cut=""
		header_array=($(echo "$header" | tr ',' ' '))
		«ENDIF»
		index_cut=""
		index_array=($(echo "$index" | tr ',' ' '))
		nbCol=$(echo "$index" | tr ',' '\n' | wc -l)
		for((i=0 ; i < $nbCol ; i++ ))
		do
		if [[ ${«keyword»_array[$i]} != "«String.join('''" && ${«keyword»_array[$i]} != "''', colOfColumns)»" ]]
		then
		«IF hasColumnName»
		header_cut=$header_cut${header_array[$i]},
		«ENDIF»
		index_cut=$index_cut$i{index_array[$i]},
		nb_cut=$nb_cut$(($i+1))
		fi
		done
		«IF hasColumnName»
		header=${header_cut::-1}
		«ENDIF»
		index=${index_cut::-1}
		nb_cut=${nb_cut::-1}
		«genLocVariable()»
		'''

//		var code = ""
//		var echoVar = ""
//		if(colSelectType === ColSelectType.BYNAME) {
//			echoVar = "$header"
//			'''
//			index_cut=$(echo "$header" | tr ',' '\n' | nl -n ln | grep -v -w "«String.join('''$" | grep -v -w "''',colOfColumns)»" | awk -F " " '{print $1}')
//			index_cut=$(echo "$index_cut" | tr '\n' ';p' 
//			'''
//		} else if(colSelectType == ColSelectType.BYNUMBER) {
//			echoVar = "$index"
//		}
	}

	def genCutVariable() {
		var code = ""
		if (colSelectType !== ColSelectType.ALL) {
			var echoVar = ""
			if (colSelectType === ColSelectType.BYNAME) {
				echoVar = "$header"
			} else if (colSelectType === ColSelectType.BYNUMBER) {
				echoVar = "$index"
			}
			code += '''
				«FOR c : colOfColumns»
					cut_«c»=$(echo "«echoVar»" | tr '«csvSep»' '\n' | grep -n -w "^«c»" |  awk -F ":" '{print $1}')
				«ENDFOR»
				nb_cut=$cut_c«String.join(',$cut_',colOfColumns)»
			'''

			if (hasColumnName) {
				code += '''
					header_cut=$(echo "$header" | cut -d '«csvSep»' -f $cut_«String.join(',$cut_',colOfColumns)»)
				'''
			}
			code += '''
				index_cut=$(echo "$index" | cut -d '«csvSep»' -f $cut_«String.join(',$cut_',colOfColumns)»)
				nbCol=$(( $(echo "$index_cut" | tr '«csvSep»' '\n' | wc -l) - 1))
			'''
		}
		return code
	}

	def genLocVariable() {
		var echoVarForName = ""
		var echoVarForNumber = ""
		if (colSelectType == ColSelectType.ALL) {
			echoVarForName = "$header"
			echoVarForNumber = "$index"
		} else {
			echoVarForName = "$header_cut"
			echoVarForNumber = "$index_cut"
		}
		return '''
			«FOR v : colOfConditions.get("name")»
				loc_«v»=$(( $(echo "«echoVarForName»" | tr '«csvSep»' '\n' | grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
			«ENDFOR»
			«FOR v : colOfConditions.get("number")»
				loc_«v»=$(( $(echo "«echoVarForNumber»" | tr '«csvSep»' '\n'| grep -n -w "^«v»" |  awk -F ":" '{print $1}') - 1))
			«ENDFOR»
		'''
	}

	def genInput() {
		var code = '''echo "$file" |'''

		if (hasColumnName) {
			code += ''' tail -n +2 |'''
		}

		if (colSelectType !== ColSelectType.ALL) {
			code += ''' cut -d "«csvSep»" -f $nb_cut |'''
		}
		return code
	}

	def genColTitle() {
		var echoVar = ""

		switch (colSelectType) {
			case ColSelectType.ALL: {
				if (hasColumnName) {
					echoVar = "$header"
				} else {
					echoVar = "$index"
				}
			}
			case ColSelectType.BYNAME: {
				echoVar = "$header_cut"
			}
			case ColSelectType.BYNUMBER: {
				if (hasColumnName) {
					echoVar = "$header_cut"
				} else {
					echoVar = "$index_cut"
				}
			}
		}

		return '''echo "  $(echo "«echoVar»" | tr '«csvSep»' '«colSep»')"'''
	}

	def genEcho() {
		return '''$(eval echo '${c['`seq -s ']}«colSep»${c[' 0 $nbCol`]'}')'''
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
			selector.lineSelection.analyze()
			withCondition = true
		}
		return this
	}

	def dispatch analyzeColumn(Column c) {}

	def dispatch analyzeColumn(ColumnNames c) {
		if (hasColumnName == false) {
			throw new Exception("You select columns name but file hasn't columns name")
		}
		c.getNames().forEach[n|colOfColumns.add(n)]
		colSelectType = ColSelectType.BYNAME
	}

	def dispatch analyzeColumn(ColumnNumbers c) {
		c.numbers.forEach[n|colOfColumns.add(n.substring(1))]
		colSelectType = ColSelectType.BYNUMBER
	}

	def void analyze(Lines l) {
		if (l.cond !== null) {
			l.cond.analyze()
		}
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
		colOfConditions.get("number").add(c.value.substring(1))
	}

	def dispatch void analyzeColumnIdentifier(ColumnNameIdentifier c) {
		colOfConditions.get("name").add(c.value)
	}

	def genCond() {
		if (selector.lineSelection !== null) {
			return selector.lineSelection.genCode()
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
		return ''' ${c[$loc_«c.value.substring(1)»]}'''
	}

	def dispatch genCodeColumnIdentifier(ColumnNameIdentifier c) {
		return ''' ${c[$loc_«c.value»]}'''
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

	def Boolean isWithCondition() {
		return withCondition
	}

}
