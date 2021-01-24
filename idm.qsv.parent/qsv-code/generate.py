#!/usr/bin/python3

import random

alphabet = list(map(chr, range(97, 123)))

colname = []

for l in alphabet:
    for i in range(1,11):
        colname.append(l+str(i))

# csv = ",".join(colname)
# csv += "\n"

# l = []
# for i in range(0,10000):
#     for j in range(0,len(colname)):
#         csv += str(random.randint(1,1000))
#         if j != len(colname)-1:
#             csv += ","
#     csv += "\n"

# with open("big.csv", "w") as f:
#     f.write(csv)

csv_str = ",".join(colname)
csv_str = "\n"

l = []
for i in range(0,10000):
    for j in range(0,len(colname)):
        csv_str += alphabet[random.randint(0,len(alphabet)-1)]
        if j != len(colname)-1:
            csv_str += ","
    csv_str += "\n"

with open("big_str.csv", "w") as f:
    f.write(csv_str)




col = []
for l in alphabet[5:20]:
    for i in range(1,11):
        col.append(l+str(i))

delete_col = """
using "big.csv" with column names: yes 
delete :columns """ + ",".join(col)

with open("delete_col.qsv", "w") as f:
    f.write(delete_col)

delete_line = """
using "big.csv" with column names: yes
delete :lines #3000-7000"""

with open("delete_line.qsv", "w") as f:
    f.write(delete_line)

delete_cond = """
using "big.csv" with column names: yes
delete :lines a > 500"""

with open("delete_cond.qsv", "w") as f:
    f.write(delete_cond)

delete_cond = """
using "big.csv" with column names: yes
delete :lines a > 500"""

with open("delete_cond.qsv", "w") as f:
    f.write(delete_cond)

insert_line = """
using "big.csv" with column names: yes
insert :lines"""

for i in range(0,100):
    insert_line += "("
    for j in range(len(colname)):
        insert_line += str(random.randint(1,1000))
        if j != len(colname)-1:
            insert_line += ","
    insert_line += ")"
    if i != 99:
        insert_line += ","

with open("insert_line.qsv", "w") as f:
    f.write(insert_line)

insert_col = """
using "big.csv" with column names: yes
insert :columns"""

for i in range(0,20):

    insert_col += alphabet[i] + "("
    for j in range(10000):
        insert_col += str(random.randint(1,1000))
        if j != 9999:
            insert_col += ","
    insert_col += ")"
    if i != 19:
        insert_col += ","

with open("insert_col.qsv", "w") as f:
    f.write(insert_col)


update = """
using "big.csv" with column names: yes
:set "w" :columns #1
"""

with open("update.qsv", "w") as f:
    f.write(update)

update_cond = """
using "big.csv" with column names: yes
:set "w" :columns #1 :condition #1 > 500
"""

with open("update_cond.qsv", "w") as f:
    f.write(update_cond)


compute_col_nb = """
using "big.csv" with column names: yes
	compute $sumCol0
	    :sumValuesInColumn col0
"""

with open("compute_col_nb.qsv", "w") as f:
    f.write(compute_col_nb)

compute_col_str = """
using "big.csv" with column names: no
	compute $sumCol0
	    :sumValuesInColumn col0
"""

with open("compute_col_str.qsv", "w") as f:
    f.write(compute_col_str)

compute_line_nb = """
using "big.csv" with column names: yes
	compute $sumCol0
	    :sumColumns """

for l in alphabet[5:10]:
    for i in range(2,7):
        compute_line_nb += l+str(i)
        if i != 6 and l != alphabet[10]:
            compute_line_nb += ","

with open("compute_line_nb.qsv", "w") as f:
    f.write(compute_line_nb)

compute_line_str = """
using "big_str.csv" with column names: yes
	compute $sumCol0
	    :sumColumns """

for l in alphabet[5:10]:
    for i in range(2,7):
        compute_line_str += l+str(i)
        if i != 6 and l != alphabet[10]:
            compute_line_str += ","

with open("compute_line_str.qsv", "w") as f:
    f.write(compute_line_str)