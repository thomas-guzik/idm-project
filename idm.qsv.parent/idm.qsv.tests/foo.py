import pandas as pd
def printData(data):
    if type(data) is pd.DataFrame:
        if data.empty:
            print()
            return
    print(data)

my_data = pd.read_csv("foo_numbers.csv", header='infer')
filter65 = my_data["col1"] < 5
filter64 = filter65
my_data = my_data.drop(my_data[filter64].index)

printData(my_data)