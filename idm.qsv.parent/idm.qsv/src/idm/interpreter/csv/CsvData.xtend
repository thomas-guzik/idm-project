package idm.interpreter.csv

import java.io.File
import java.io.FileWriter
import java.util.ArrayList
import java.util.Collections
import java.util.List
import java.util.stream.Collectors
import java.util.stream.IntStream

class CsvData {

	List<String> columns
	List<Integer> selectedColumns
	Integer maxColumnsIndex
	List<List<String>> table
	List<Integer> selectedRows
	boolean header
	boolean filtered = false
	String separator
	final String NEWLINE = "\n"
	final String DEFAULT_PRINT_SEPARATOR = "\t"
	final String PRETTY_SEPARATOR = "  "

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
		maxColumnsIndex = nbColumns()
	}

	new(List<String> cols, List<List<String>> tab, boolean h, String s) {
		columns = cols
		table = tab
		header = h
		separator = s
		selectedColumns = new ArrayList<Integer>()
		selectedRows = new ArrayList<Integer>()
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
		return toStringWithSeparator(DEFAULT_PRINT_SEPARATOR)
	}

	def String toStringWithSeparator(String separator) {
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

		if (!printedColumns.isEmpty) {
			data += printedColumns.join(separator)
		}
		if (!printedRows.isEmpty && !columns.isEmpty) {
			data += NEWLINE
		}

		data += printedRows.map[row|row.join(separator)].join(NEWLINE)
		return data
	}

	def toStringPretty() {
		val printedColumns = new ArrayList<String>()
		printedColumns.add("")
		if (selectedColumns.isEmpty) {
			printedColumns.addAll(columns)
		} else {
			selectedColumns.forEach[i|printedColumns.add(columns.get(i))]
		}

		val printed = new ArrayList<String>()

		val printedRows = new ArrayList<List<String>>()
		printed.add("")

		IntStream.range(0, nbRows).filter[i|!filtered || selectedRows.contains(i)].forEach [ i |
			val newRow = new ArrayList<String>()
			printedRows.add(newRow)
			newRow.add(i + "")

			if (selectedColumns.isEmpty) {
				newRow.addAll(table.get(i))
			} else {
				selectedColumns.forEach[columnIndex|newRow.add(table.get(i).get(columnIndex))]
			}
			printed.add("")
		]

		for (var columnIndex = 0; columnIndex < printedColumns.length; columnIndex++) {
			val isLastColumn = columnIndex === printedColumns.length - 1
			val column = printedColumns.get(columnIndex)
			val widest = getWidestForColumn(columnIndex, printedColumns, printedRows)
			val newHeader = printed.get(0) + (isLastColumn ? column : fitSpace(column, widest) + PRETTY_SEPARATOR)
			printed.set(0, newHeader)
			for (var rowIndex = 0; rowIndex < printedRows.length; rowIndex++) {
				val row = printedRows.get(rowIndex)
				val word = row.get(columnIndex)
				val newRow = printed.get(rowIndex+1) + (isLastColumn ? word : fitSpace(word, widest) + PRETTY_SEPARATOR)
				printed.set(rowIndex+1, newRow)
			}
		}

		return printed.join(NEWLINE)
	}
	
	private def Integer getWidestForColumn(int columnIndex, ArrayList<String> columns, List<List<String>> rows) {
		val columnNameSize = wordSize(columns.get(columnIndex))
		val columnContent = rows.map[row | row.get(columnIndex)]
		val widestContent = columnContent.map[word | wordSize(word)].reduce[a, b | Integer.max(a, b)]
		return Integer.max(columnNameSize, widestContent)
	}

	private def String fitSpace(String word, int spaceToFill) {
		var newWord = word
		while (wordSize(newWord) < spaceToFill) {
			newWord += " "
		}
		return newWord
	}

	private def Integer wordSize(Object object) {
		return object.toString().length
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
			columns.add(maxColumnsIndex + "")
		}
		IntStream.range(0, column.size()).forEach [ i |
			table.get(i).add(column.get(i) + "")
		]
		maxColumnsIndex++
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

	def void saveTo(String filename, String separator) {
		var content = columns.join(separator)
		content += NEWLINE
		content += table.map[row|row.join(separator)].join(NEWLINE)
		val File file = new File(filename);
		val FileWriter writer = new FileWriter(file, false);
		writer.write(content);
		writer.close();
	}

	def void saveJsonTo(String filename) {
		var content = IntStream.range(0, nbColumns).mapToObj [ columnIndex |
			'''"«columns.get(columnIndex)»":
			{«IntStream.range(0, nbRows).mapToObj[rowIndex|
					'''"«rowIndex»":"«table.get(rowIndex).get(columnIndex)»"'''
				].collect(Collectors.toList).join(",")»}'''
		].collect(Collectors.toList).join(",")
		content = '''{«content»}'''
		val File file = new File(filename);
		val FileWriter writer = new FileWriter(file, false);
		writer.write(content.replaceAll("\\s+", ""));
		writer.close();
	}

	def String sumLinesOfColumn(String column) {
		val indexOfColumn = columns.indexOf(column)
		try {
			val valuesOfColumn = table.map[row|Integer.parseInt(row.get(indexOfColumn))]
			return valuesOfColumn.reduce[a, b|a + b] + ""
		} catch (NumberFormatException exception) {
			val valuesOfColumn = table.map[row|row.get(indexOfColumn)]
			return valuesOfColumn.reduce[a, b|a + b]
		}
	}

	def sumColumns(List<String> sumColumns) {
		val columnIndexes = sumColumns.map[col|columns.indexOf(col)]
		val result = new ArrayList<String>()
		try {
			val intRows = table.map[row|columnIndexes.map[i|Integer.parseInt(row.get(i))]]
			result.addAll(intRows.map[row|row.reduce[v1, v2|v1 + v2]].map[toString])
		} catch (NumberFormatException e) {
			val stringRows = table.map[row|columnIndexes.map[i|row.get(i)]]
			result.addAll(stringRows.map[row|row.reduce[v1, v2|v1 + v2]])
		}

		val resultTable = new ArrayList<List<String>>()
		IntStream.range(0, nbRows).forEach [ rowIndex |
			val newRow = new ArrayList<String>()
			newRow.add(result.get(rowIndex) + "")
			resultTable.add(newRow)
		]

		val data = new CsvData(List.of(), resultTable, header, separator)
		return data
	}

	def insertColumnsFromCsv(List<String> names, CsvData data) {
		if (data.nbRows !== nbRows) {
			throw new IllegalArgumentException
		}
		columns.addAll(names)
		IntStream.range(0, nbRows).forEach [ rowIndex |
			table.get(rowIndex).addAll(data.table.get(rowIndex))
		]
	}

	def void deleteAllLines() {
		table = new ArrayList<List<String>>()
	}

}
