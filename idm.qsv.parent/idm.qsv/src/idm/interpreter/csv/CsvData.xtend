package idm.interpreter.csv

import java.util.ArrayList
import java.util.List
import java.util.stream.Collectors
import java.util.stream.IntStream
import java.util.Collections

class CsvData {

	List<String> columns
	List<Integer> selectedColumns
	List<List<String>> table
	List<Integer> selectedRows
	boolean header
	boolean filtered = false
	String separator
	final String NEWLINE = "\n"
	final String PRINT_SEPARATOR = "\t"

	new(List<String> data, boolean h, String s) {
		header = h
		separator = s
		selectedColumns = new ArrayList<Integer>()
		selectedRows = new ArrayList<Integer>()
		if (data.isEmpty) {
			columns = new ArrayList<String>()
			table = new ArrayList<List<String>>()
		} else {
			initColumns(data)
			initTable(data)
		}
	}

	def private void initColumns(List<String> data) {
		val number = data.get(0).split(separator).size()
		if (header) {
			columns = new ArrayList<String>()
			columns.addAll(data.get(0).split(separator))
			data.remove(0)
		} else {
			columns = IntStream.range(0, number).mapToObj[i|i + ""].collect(Collectors.toList)
		}
	}

	def private void initTable(List<String> data) {
		table = new ArrayList<List<String>>()
		for (String row : data) {
			table.add(new ArrayList<String>(row.split(separator)))
		}
	}

	override String toString() {
		var data = ""

		val printedColumns = new ArrayList<String>()
		printedColumns.add("")
		if (selectedColumns.isEmpty) {
			printedColumns.addAll(columns)
		} else {
			selectedColumns.forEach[i|printedColumns.add(columns.get(i))]
		}

		val printedRows = new ArrayList<List<String>>()
		IntStream.range(0, nbRows).filter[i|!filtered || selectedRows.contains(i)].forEach [ i |
			val newRow = new ArrayList<String>()
			printedRows.add(newRow)
			newRow.add(i + "")

			if (selectedColumns.isEmpty) {
				newRow.addAll(table.get(i))
			} else {
				selectedColumns.forEach[columnIndex|newRow.add(table.get(i).get(columnIndex))]
			}
		]

		data += printedColumns.join(PRINT_SEPARATOR)
		data += NEWLINE
		data += printedRows.map[row|row.join(PRINT_SEPARATOR)].join(NEWLINE)
		if (!printedRows.isEmpty) {
			data += NEWLINE
		}
		return data
	}

	def void selectColumns(List<String> selected) {
		if (!selected.isEmpty) {
			selectedColumns = IntStream.range(0, nbColumns).filter(i|selected.contains(columns.get(i))).boxed.collect(
				Collectors.toList)
		}
	}

	def void selectLines(List<Integer> lines) {
		filtered = true
		if (selectedRows.isEmpty) {
			selectedRows = new ArrayList<Integer>()
			selectedRows.addAll(lines)
		} else {
			selectedRows = selectedRows.filter[i|lines.contains(i)].toList
		}
	}

	def void apply(Filter filter) {
		filtered = true
		selectedRows = IntStream.range(0, nbRows).filter(
			i |
				filter.eval(columns, table.get(i)) && (selectedRows.isEmpty || selectedRows.contains(i))
		).boxed.collect(Collectors.toList)
	}

	def void insertLine(List<Object> row) {
		val line = new ArrayList<String>()
		line.addAll(row.map[o|o + ""].toList)
		table.add(line)
	}

	def void insertColumn(String name, List<Object> column) {
		if (header) {
			columns.add(name)
		} else {
			columns.add(nbColumns + "")
		}
		IntStream.range(0, column.size()).forEach [ i |
			table.get(i).add(column.get(i) + "")
		]
	}

	def void deleteColumn(String name) {
		val indexToDelete = columns.indexOf(name)
		columns.remove(indexToDelete)
		table.forEach [ row |
			row.remove(indexToDelete)
		]
	}

	def void deleteSelectedLines() {
		if (filtered) {
			selectedRows.sort(Collections.reverseOrder)
			for (int rowIndex : selectedRows) {
				table.remove(rowIndex)
			}
		}
	}

	def void update(String name, Object value) {
		val indexToUpdate = columns.indexOf(name)
		IntStream.range(0, nbRows).filter[i|!filtered || selectedRows.contains(i)].forEach [ i |
			table.get(i).set(indexToUpdate, value + "")
		]

	}

	def void deleteAllData() {
		columns = new ArrayList<String>()
		table = new ArrayList<List<String>>()
	}

	def Integer nbRows() {
		table.size()
	}

	def Integer nbColumns() {
		columns.size()
	}

	def resetFilters() {
		selectedColumns = new ArrayList<Integer>()
		selectedRows = new ArrayList<Integer>()
		filtered = false
	}
}
