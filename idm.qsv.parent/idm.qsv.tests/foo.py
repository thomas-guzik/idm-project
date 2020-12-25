import pandas as pd
def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

my_data = pd.read_csv("foo2.csv", header=None)

my_data = my_data.append(dict(zip(my_data.columns,["v4", "v1", "v0"])), ignore_index=True)
printData(my_data)