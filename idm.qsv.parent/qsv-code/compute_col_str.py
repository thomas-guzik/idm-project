import pandas as pd
from pandas.api.types import is_numeric_dtype
import functools
def print_data(data):
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
def print_data_separator(data, separator):
    if type(data) is pd.DataFrame:
        if data.empty:
            printed = ""
            for col in data.columns:
                printed += separator + str(col)
            print(printed)
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
    for i, line in zip(data.index, data.values):
        line_to_print = str(i) + separator
        line_to_print += separator.join(map(str, line))
        lines_to_print.append(line_to_print)
    table_to_print += "\n".join(lines_to_print)
    print(table_to_print)
def print_data_pretty(data):
    if type(data) is pd.DataFrame:
        print_data_frame_pretty(data)
        return
    if type(data) is pd.Series:
	    print(data.to_string())
	    return
    print(data)

def print_data_frame_pretty(data):
    separator = "  "
    if(len(data.values) > 0):
        size_largest_column_nb = size_largest_word_of_column(data.index)
        printed = [" " * (size_largest_column_nb) + separator]
        for line_i, i in zip(data.index, range(0, len(data.index))):
            printed.append(str(line_i) + " " * (size_largest_column_nb - word_size(str(line_i))) + separator)
        for i in range(0, len(data.columns)):
            col_i = data.columns[i]
            not_last_column = i != len(data.columns) - 1
            col_width = word_size(col_i)
            target_size = size_largest_word_of_column(data[col_i])
            printed[0] += str(col_i) + (" " * (target_size - col_width) + separator) * not_last_column
            for word, j in zip(data[col_i], range(0, len(data[col_i]))):
                printed[j+1] += str(word) + (" " * (target_size - word_size(word)) + separator) * not_last_column
        print("\n".join(printed))
    else:
        print(separator.join(data.columns))

def size_largest_word_of_column(column):
    max_size = -1
    for word in column:
        max_size = max(len(str(word)), max_size)
    return max_size

def word_size(word):
    return len(str(word))

my_data = pd.read_csv("big.csv", header=None, sep=",")

column_index = len(my_data.columns)
user_sumCol0 = my_data["col0"].sum()
