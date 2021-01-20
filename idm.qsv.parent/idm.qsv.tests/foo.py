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

my_data = pd.read_csv("foo_numbers.csv", header='infer')

columnIndex = len(my_data.columns)
filter79 = my_data["col1"] < 5
filter78 = filter79
my_data = my_data.drop(my_data[filter78].index)

my_data.reset_index(drop=True, inplace=True)
tmp62 = my_data
printData(tmp62)
