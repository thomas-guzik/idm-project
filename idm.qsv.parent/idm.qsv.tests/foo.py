def printData(data):
	    if data.empty:
	        print()
	    else:
	        print(data)

import pandas as pd
my_data = pd.read_csv("foo_numbers.csv", header='infer')
filter = my_data["col1"] >= 5
my_data = my_data[filter]
printData(my_data)