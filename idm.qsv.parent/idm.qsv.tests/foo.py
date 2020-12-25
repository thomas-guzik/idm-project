import pandas as pd
def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

my_data = pd.read_csv("foo2.csv", header='infer')
my_data["f2"] = "v8"
my_data["f1"] = "v8"
printData(my_data)