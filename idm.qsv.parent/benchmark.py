from subprocess import PIPE, run
import os
import datetime
import time
import statistics

cwd = os.getcwd()

progs = [
"delete_col",
"delete_line",
"delete_cond",
"insert_line",
"insert_col",
"update",
"update_cond",
"compute_col_nb",
"compute_col_str",
"compute_line_nb",
"compute_line_str"
]

print("Time", "Programme", "Langage", "Second", sep="\t")

for prog in progs:
    for lang in ["sh", "py"]:
        compilation_time = []
        for i in range(0,4):
            t1 = time.perf_counter()
            run(["java","-jar","idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar",lang, cwd+"/qsv-code/"+prog+".qsv"], stdout=PIPE, stderr=PIPE, universal_newlines=True)
            t2 = time.perf_counter()
            t = t2 - t1
            compilation_time.append(t)
        avg = statistics.mean(compilation_time)
        print("Compil", prog, lang, avg, sep="\t")

    execution_time = []
    for command, ext in zip(["bash", "python3"], [".sh", ".py"]):
        for i in range(0,2):
            t1 = time.perf_counter()
            run([command, cwd+"/qsv-code/"+prog+ext], stdout=PIPE, stderr=PIPE, universal_newlines=True)
            t2 = time.perf_counter()
            t = t2 - t1
            execution_time.append(t)
        avg = statistics.mean(execution_time)
        print("Exec", prog, command, avg, sep="\t")

    for i in range(0,2):
        t1 = time.perf_counter()
        run(["java","-jar","idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar","int", cwd+"/qsv-code/"+prog+".qsv"], stdout=PIPE, stderr=PIPE, universal_newlines=True)
        t2 = time.perf_counter()
        t = t2 - t1
        execution_time.append(t)
    avg = statistics.mean(execution_time)
    print("Exec",prog, "int", avg, sep="\t")


