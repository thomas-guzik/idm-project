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

my_data = pd.read_csv("foo2.csv", header=None)

columnIndex = len(my_data.columns)

my_data = my_data.append(dict(zip(my_data.columns,["v4", "v1", "v0"])), ignore_index=True)
tmp10 = my_data
printData(tmp10)
