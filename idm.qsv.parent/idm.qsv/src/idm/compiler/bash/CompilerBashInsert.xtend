package idm.compiler.bash

import idm.qsv.Insert
import idm.qsv.Insertion
import idm.qsv.LineInsertion
import idm.qsv.ColumnInsertion
import idm.qsv.ContentList
import idm.qsv.Value
import idm.qsv.IntegerValue
import idm.qsv.StringValue
import idm.qsv.BooleanValue
import idm.qsv.VariableIdentifier
import idm.qsv.ColumnDescription
import idm.qsv.ContentDescription
import java.util.ArrayList

class CompilerBashInsert implements CompilerBash {

	Insert insert
	Boolean hasColumnName
	String csvSep
	String colSep

	new(Insert i, Boolean hasColumnName, String csvSep, String colSep) {
		insert = i
		this.hasColumnName = hasColumnName
		this.csvSep = csvSep
		this.colSep = colSep
	}

	override String compile() {
		return insert.genCode()
	}

	def String genCode(Insert insert) {
		return insert.inserted.genCodeInsertion()
	}

	def dispatch String genCodeInsertion(Insertion i) {}

	def dispatch String genCodeInsertion(LineInsertion l) {
		return '''file=$(echo -e "$file«FOR r : l.rows»\n«r.genCode()»«ENDFOR»")
		'''
	}

	def String genCode(ContentList l) {
		var list = newArrayList
		for (v : l.values) {
			list.add(v.genCodeValue())
		}
		return '''«String.join(",",list)»'''
	}

	def dispatch String genCodeInsertion(ColumnInsertion c) {
		var code = ""
		var list = new ArrayList<ArrayList<String>>()
		for (d : c.descriptions) {
			list.add(d.genCode())
		}
		for(var i = 0; i < list.size(); i++ ) {
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
			list.add(v.genCodeValue())
		}
		return list
	}

	def dispatch genCodeContentDescription(VariableIdentifier v) {
		return newArrayList
	}

	def dispatch genCodeValue(Value v) {}

	def dispatch genCodeValue(IntegerValue v) { return '''«v.value»''' }

	def dispatch genCodeValue(StringValue v) { return '''«v.value»''' }

	def dispatch genCodeValue(BooleanValue v) { return v.truthy ? "1" : "0" }

	def dispatch genCodeValue(VariableIdentifier v) {
		throw new Exception("Variable not implemented")
	}

}
