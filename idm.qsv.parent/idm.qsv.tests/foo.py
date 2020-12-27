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
filter71 = my_data["col1"] < 5
filter70 = filter71
my_data = my_data.drop(my_data[filter70].index)

tmp54 = my_data
printData(tmp54)
