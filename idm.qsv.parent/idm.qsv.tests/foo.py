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

my_data = pd.read_csv("foo3.csv", header='infer')

my_data = my_data.append(dict(zip(my_data.columns,["v8", "v0", "v5"])), ignore_index=True)
my_data.to_csv("bla.csv", index=False)