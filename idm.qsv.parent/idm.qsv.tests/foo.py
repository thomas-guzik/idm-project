import pandas as pd
def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

my_data = pd.read_csv("foo_mix_int_str.csv", header='infer')
my_data.insert(loc=len(my_data.columns), column="ef", value=["ar", "zt"])
printData(my_data)