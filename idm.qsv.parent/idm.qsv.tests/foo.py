import pandas as pd
def printData(data):
    if type(data) is pd.DataFrame:
        if data.empty:
            print()
            return
    if type(data) is pd.Series:
    	print(data.to_string())
    	return
    print(data)

my_data = pd.read_csv("foo_numbers.csv", header='infer')
sumCol0Col1 = my_data[["col0", "col1"]].sum(axis=1)
my_data.insert(loc=len(my_data.columns), column="newcol", value=sumCol0Col1)
tmp1 = my_data
printData(tmp1)
