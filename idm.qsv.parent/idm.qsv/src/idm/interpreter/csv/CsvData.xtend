package idm.interpreter.csv

import java.util.ArrayList
import java.util.Arrays
import java.util.List
import java.util.stream.Collectors
import java.util.stream.IntStream

class CsvData {

	List<String> columns
	int nbColumns
	List<List<String>> table
	boolean header
	String separator
	final String NEWLINE = "\n"
	final String PRINT_SEPARATOR = "\t"

	new(List<String> data, boolean h, String s) {
		header = h
		separator = s
		if (data.isEmpty) {
			columns = List.of()
			table = List.of()
		} else {
			initColumns(data)
			initTable(data)
		}
	}

	def private void initColumns(List<String> data) {
		nbColumns = data.get(0).split(separator).size()
		if (header) {
			columns = Arrays.asList(data.get(0).split(separator))
			data.remove(0)
		} else {
			columns = IntStream.range(0, nbColumns).mapToObj[i|i + ""].collect(Collectors.toList)
		}
	}
	
	def private void initTable(List<String> data) {
		table = data.map[row | Arrays.asList(row.split(separator))]
	}
	
	override String toString() {
		var data = ""
		
		val printedColumns = new ArrayList<String>()
		printedColumns.add("")
		printedColumns.addAll(columns)
		
		val printedRows = new ArrayList<List<String>>()
		val nbRows = table.size()
		IntStream.range(0, nbRows).forEach[i | printedRows.add(new ArrayList<String>()) ; printedRows.get(i).add(i + "") ; printedRows.get(i).addAll(table.get(i))]
		
		data += printedColumns.join(PRINT_SEPARATOR)
		data += NEWLINE
		data += printedRows.map[row | row.join(PRINT_SEPARATOR)].join(NEWLINE)
		data += NEWLINE
	}
}
