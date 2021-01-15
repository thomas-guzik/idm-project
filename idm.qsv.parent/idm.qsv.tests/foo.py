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

columnIndex = len(my_data.columns)
tmp31 = my_data
filter59 = tmp31["col1"] >= 5
filter58 = filter59
tmp31 = tmp31[filter58]
printData(tmp31)
