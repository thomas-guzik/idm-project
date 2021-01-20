import pandas as pd
from pandas.api.types import is_numeric_dtype
import functools
def printData(data):
    if type(data) is pd.DataFrame:
        if data.empty:
            printed = ""
            for col in data.columns:
                printed += "\t" + str(col)
            print(printed)
            return
    if type(data) is pd.Series:
    	print(data.to_string())
    	return
    print(data)
def prettyPrintData(data, separator):
	    if type(data) is pd.DataFrame:
	        if data.empty:
	            print()
	            return
	        print_data_frame(data, separator)
	        return
	    if type(data) is pd.Series:
	    	print(data.to_string())
	    	return
	    print(data)
def print_data_frame(data, separator):
		    table_to_print = separator
		    table_to_print += separator.join(map(str, data.columns))
		    table_to_print += "\n"
		    lines_to_print = []
		    for i, line in zip(range(0, len(data.values)), data.values):
		        line_to_print = str(i) + separator
		        line_to_print += separator.join(map(str, line))
		        lines_to_print.append(line_to_print)
		    table_to_print += "\n".join(lines_to_print)
		    print(table_to_print)
my_data = pd.read_csv("foo_numbers.csv", header='infer')

columnIndex = len(my_data.columns)
filter79 = my_data["col1"] < 5
filter78 = filter79
my_data = my_data.drop(my_data[filter78].index)

my_data.reset_index(drop=True, inplace=True)
tmp63 = my_data
printData(tmp63)
