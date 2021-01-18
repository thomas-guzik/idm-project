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
import idm.analyzer.AnalyzerValue
import idm.analyzer.ValueType

class CompilerBashInsert implements CompilerBash {

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
			var analyzerValue = new AnalyzerValue(v)
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
		// TODO Trouver un meilleur code
		var code = ""
		var list = new ArrayList<ArrayList<String>>()
		for (d : c.descriptions) {
			list.add(d.genCode())
		}
		for (var i = 0; i < list.size(); i++) {
			code += '''
				lastColIndex=$((lastColIndex + 1))
				index="$index«csvSep»$lastColIndex"
			'''
		}
		var newList = new ArrayList<ArrayList<String>>()
		for (var i = 0; i < list.get(0).size(); i++) {
			var subList = newArrayList
			for (var j = 0; j < list.size(); j++) {
				subList.add(list.get(j).get(i))
			}
			newList.add(subList)
		}

		var newnewList = new ArrayList<String>()

		for (l : newList) {
			newnewList.add(String.join(",", l))
		}

		return '''
			«code»
			add=$(echo -e "«String.join("\n", newnewList)»")
			file=$(paste -d«csvSep» <(echo "$file") <(echo "$add"))
		'''
	}

	def genCode(ColumnDescription d) {
		var list = new ArrayList<String>()
		list = d.content.genCodeContentDescription()
		var columnName = d.columnName
		if (columnName !== null) {
			list.add(0, columnName.value)
		}
		return list
	}

	def dispatch genCodeContentDescription(ContentDescription c) {}

	def dispatch genCodeContentDescription(ContentList l) {
		var list = new ArrayList<String>()
		for (v : l.values) {
			var analyzerValue = new AnalyzerValue(v)
			var valueType = analyzerValue.getValueType()
			if (valueType == ValueType.VAR) {
				list.add("$v_" + analyzerValue.value)
			} else {
				list.add(analyzerValue.value)
			}
		}
		return list
	}

	def dispatch genCodeContentDescription(VariableIdentifier v) {
		var varName = v.value.substring(1)
		var varType =CompilerBashHelper.getVariableType(v.value.substring(1))
		var list = new ArrayList<String>()
		if(varType === ValueType.COL) {
			list.add("$v_"+varName)
			return list
		}
		else {
			throw new Exception("The variable is not a column")
		}
	}
}
