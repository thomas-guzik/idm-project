import pandas as pd
def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

my_data = pd.read_csv("foo_numbers.csv", header='infer')
filter11 = my_data["col1"] < 5
filter10 = filter11
my_data = my_data.drop(my_data[filter10].index)

printData(my_data)