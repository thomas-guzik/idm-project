package idm.compiler.bash

import idm.qsv.Insert
import idm.qsv.Insertion
import idm.qsv.LineInsertion
import idm.qsv.ColumnInsertion
import idm.qsv.ContentList
import idm.qsv.VariableIdentifier
import idm.qsv.ColumnDescription
import idm.qsv.ContentDescription
import java.util.ArrayList
import idm.analyzer.ValueType
import idm.analyzer.ValueAnalyzer

class InsertBashCompiler implements BashCompiler {

	Insert insert
	String csvSep

	new(Insert i, String csvSep) {
		insert = i
		this.csvSep = csvSep
	}

	override String compile() {
		return insert.genCode()
	}

	def String genCode(Insert insert) {
		return insert.inserted.genCodeInsertion()
	}

	def dispatch String genCodeInsertion(Insertion i) {}

	def dispatch String genCodeInsertion(LineInsertion l) {
		return '''
			file=$(echo -e "$file«FOR r : l.rows»\n«r.genCode()»«ENDFOR»")
		'''
	}

	def String genCode(ContentList l) {
		var list = newArrayList
		for (v : l.values) {
			var analyzerValue = new ValueAnalyzer(v)
			var valueType = analyzerValue.getValueType()
			if (valueType == ValueType.VAR) {
				list.add("$v_" + analyzerValue.value)
			} else {
				list.add(analyzerValue.value)
			}
		}
		return '''«String.join(",",list)»'''
	}

	def dispatch String genCodeInsertion(ColumnInsertion c) {
		var code = ""
		for (d : c.descriptions) {
			code += '''
				lastColIndex=$((lastColIndex + 1))
				index="$index«csvSep»$lastColIndex"
				add=$(echo -e "«d.genCode()»")
				file=$(paste -d«csvSep» <(echo "$file") <(echo "$add"))
				
			'''
		}
		return code
	}

	def genCode(ColumnDescription d) {
		var code = ""
		if (d.columnName !== null) {
			code += d.columnName.value + '''\n'''
		}
		code += d.content.genCodeContentDescription()
		return code
	}

	def dispatch genCodeContentDescription(ContentDescription c) {}

	def dispatch genCodeContentDescription(ContentList l) {
		var code = ""
		for (v : l.values) {
			var analyzerValue = new ValueAnalyzer(v)
			var valueType = analyzerValue.getValueType()
			if (valueType == ValueType.VAR) {
				code += "$v_" + analyzerValue.value + '''\n'''
			} else {
				code += analyzerValue.value + '''\n'''
			}
		}
		return code
	}

	def dispatch genCodeContentDescription(VariableIdentifier v) {
		var varName = v.value.substring(1)
		var varType = BashCompilerHelper.getVariableType(v.value.substring(1))
		if (varType === ValueType.COL) {
			return '''$(echo "$v_«varName»" | tr ',' '\n')'''
		} else {
			throw new Exception("The variable is not a column")
		}
	}
}
