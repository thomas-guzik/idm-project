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

my_data = pd.read_csv("foo_mix_int_str2.csv", header='infer')

columnIndex = len(my_data.columns)
cols_to_sum = ["f2", "f3"]
all_int = all([is_numeric_dtype(my_data[col]) for col in cols_to_sum])
if all_int:
	sumCol0Col1 = my_data[cols_to_sum].sum(axis=1)
else:
	sumCol0Col1 = functools.reduce(lambda a,b: my_data[a].map(str) + my_data[b].map(str), cols_to_sum)


printData(sumCol0Col1)
