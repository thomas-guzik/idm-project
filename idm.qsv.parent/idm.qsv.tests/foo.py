import pandas as pd
def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

my_data = pd.read_csv("foo_numbers.csv", header='infer')
filter33 = my_data["col1"] >= 5
my_data = my_data[filter33]
printData(my_data)