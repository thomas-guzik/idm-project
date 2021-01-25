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

my_data = pd.read_csv("big.csv", header='infer', sep=",")

column_index = len(my_data.columns)
my_data = my_data.drop(["f1","f2","f3","f4","f5","f6","f7","f8","f9","f10","g1","g2","g3","g4","g5","g6","g7","g8","g9","g10","h1","h2","h3","h4","h5","h6","h7","h8","h9","h10","i1","i2","i3","i4","i5","i6","i7","i8","i9","i10","j1","j2","j3","j4","j5","j6","j7","j8","j9","j10","k1","k2","k3","k4","k5","k6","k7","k8","k9","k10","l1","l2","l3","l4","l5","l6","l7","l8","l9","l10","m1","m2","m3","m4","m5","m6","m7","m8","m9","m10","n1","n2","n3","n4","n5","n6","n7","n8","n9","n10","o1","o2","o3","o4","o5","o6","o7","o8","o9","o10","p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","q1","q2","q3","q4","q5","q6","q7","q8","q9","q10","r1","r2","r3","r4","r5","r6","r7","r8","r9","r10","s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","t1","t2","t3","t4","t5","t6","t7","t8","t9","t10"], axis='columns')

my_data.reset_index(drop=True, inplace=True)
