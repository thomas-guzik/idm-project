package idm.compiler.bash

import idm.qsv.Print
import idm.qsv.Selector
import idm.qsv.Column
import idm.qsv.ColumnNames
import idm.qsv.ColumnNumbers
import idm.qsv.LineRange
import idm.qsv.Line
import idm.qsv.Condition
import java.util.ArrayList
import idm.qsv.MidPriority
import idm.qsv.HighestPriority
import idm.qsv.BinCond
import idm.qsv.ColumnIdentifier
import idm.qsv.ColumnNameIdentifier
import idm.qsv.ColumnNumberIdentifier
import idm.qsv.Lines
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
import com.sun.jdi.BooleanValue
import idm.qsv.VariableIdentifier

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

class CompilerBashPrint extends CompilerBash {

	Print print
	Boolean hasColumnName
	ColSelectType colSelectType
	ArrayList<String> cols
	String nameFile
	String csvSep
	String colSep

	Lines lines
	ArrayList<String> beforeCond
	ArrayList<String> locName

	new(Print p, Boolean hasColumnName, String nameFile, String separator) {
		print = p
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

	override String compile() {
		return print.analyze().genCode()
	}

	def Print analyze(Print print) {
		var selector = print.getSelector()
		if (selector !== null) {
			println("debut analyze")
			selector.analyze()
		}
		println("fin analyze")
		return print
	}

	def String genCode(Print print) {
		println("gencode")
		var cond = ""
		if (lines !== null) {
			cond = lines.genCode()
		}
		return '''
			«genBeforeWhile()»
			«genColTitle()»
			n=0
			while read «genRead()»
			do
			«IF !cond.isEmpty()»
				«String.join("\n", beforeCond)»
				if «cond» ; then
				  echo $n «genEcho()»
				fi
			«ELSE»
				echo $n «genEcho()»
			«ENDIF»
			n=$(( $n + 1 ))
			done < «genInput()»
		'''
	}

	def genBeforeWhile() {
		return '''
			«IF colSelectType == ColSelectType.ALL»
				nbCol=$(( `head -1 «nameFile» | tr '«csvSep»' '\n' | wc -l` - 1))
			«ENDIF»
			«genLocVariable»
		'''
	}

	def genLocVariable() {
		switch (colSelectType) {
			case ColSelectType.BYNAME: {
				return '''
					«FOR c : cols»
						loc_«c»=`head -1 «nameFile» | tr '«csvSep»' '\n' | nl | grep -w "«c»" | tr -d " " |  awk -F " " '{print $1}'`
					«ENDFOR»
				'''
			}
			default: {
				return '''
					«FOR v : locName»
						loc_«v»=`head -1 «nameFile» | tr '«csvSep»' '\n' | nl | grep -w "«v»" | tr -d " " |  awk -F " " '{print $1}'`
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
					<(cut -d "«csvSep»" -f $loc_«String.join(",$loc_", cols)»  «nameFile» | tail -n +2)
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
					return '''echo "  `head -1 «nameFile» | tr '«csvSep»' '«colSep»'`"'''
				} else {
					return '''echo "  `seq -s '«colSep»' 0 $nbCol`"'''
				}
			}
			case ColSelectType.BYNAME: {
				return '''
					echo "  `cut -d "«csvSep»" -f $loc_«String.join(",$loc_", cols)» «nameFile» | head -1 | tr ',' ' '`"
				'''
			}
			case ColSelectType.BYNUMBER: {
				if (hasColumnName) {
					return '''
						echo "  `cut -d "«csvSep»" -f «String.join(",", cols)» «nameFile» | head -1 | tr ',' ' '`"
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
				return '''$(eval echo '${c['`seq -s ']} ${c[' 0 2`]'}')'''
			}
			case ColSelectType.BYNAME: {
				return '''$(eval echo '$c'$loc_«String.join(" '$c'$loc_", cols)»)'''
			}
			case ColSelectType.BYNUMBER: {
				return '''$c«String.join(" $c", cols)»'''
			}
		}
	}

	def Selector analyze(Selector selector) {
		var columnSelection = selector.getColumnSelection()

		if (columnSelection !== null) {
			if (columnSelection.columns !== null) {
				columnSelection.columns.analyzeColumn()
			}
		}

		if (selector.lineSelection !== null) {
			lines = selector.lineSelection
		}
		return selector
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
		code = "[[ " + code + " ]]"
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
			return ''' ( «high.nestedCondition.genCode()» ) '''
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
			return ''' ${c[«v»]} '''
		} else {
			return ''' $c«v» '''
		}
	}

	def dispatch genCodeColumnIdentifier(ColumnNameIdentifier c) {
		var v = c.value
		var before = ""

		if (!locName.contains(v)) {
			locName.add(v)
		}

		if (colSelectType === ColSelectType.ALL) {
			before = '''«v»=${c[$loc_«v»]}'''
			if (!beforeCond.contains(before)) {
				beforeCond.add(before)
			}
			return ''' «v» '''
		} else {
			before = '''«v»=$(eval echo '$c'$loc_«v»)'''
			if (!beforeCond.contains(before)) {
				beforeCond.add(before)
			}
			return ''' «v» '''
		}
	}

	def dispatch analyzeValue(Value v) {}

	def dispatch analyzeValue(IntegerValue v) { return ValueType.INT }

	def dispatch analyzeValue(StringValue v) { return ValueType.STRING }

	def dispatch analyzeValue(BooleanValue v) { return ValueType.BOOL }

	def dispatch analyzeValue(VariableIdentifier v) {
		throw new Exception("Variable not implemented")
	}

	def dispatch genCodeOperator(OpComp op, ValueType t) {}

	def dispatch genCodeOperator(CompareEqual op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -eq "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				return " = "
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeOperator(CompareNotEqual op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -ne "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				return " != "
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeOperator(CompareLower op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -lt "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				throw new Exception("Only integer can be compare with lower operator")
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeOperator(CompareGreater op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -gt "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				throw new Exception("Only integer can be compare with greater operator")
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeOperator(CompareLowerOrEqual op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -le "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				throw new Exception("Only integer can be compare with lower or equal operator")
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeOperator(CompareGreaterOrEqual op, ValueType t) {
		switch (t) {
			case ValueType.INT: {
				return " -ge "
			}
			case ValueType.STRING:
				ValueType.BOOL
			: {
				throw new Exception("Only integer can be compare with greater or equal operator")
			}
			default: {
				throw new Exception("Error during generating code for condition")
			}
		}
	}

	def dispatch genCodeValue(Value v) {}

	def dispatch genCodeValue(IntegerValue v) { return ''' «v.value» ''' }

	def dispatch genCodeValue(StringValue v) { return ''' «v.value» ''' }

	def dispatch genCodeValue(BooleanValue v) { return v.value ? " 1 " : " 0 " }

	def dispatch genCodeValue(VariableIdentifier v) {
		throw new Exception("Variable not implemented")
	}
}
