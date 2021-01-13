**Build the compiler in docker**

```
cd idm.qsv.parent/
docker build -t qsv .
```


**Compiling and running generated code**


**1. Using bash**

```
cd idm.qsv.parent/qsv-code/
./compile-sh test.qsv
./run-sh test.sh
```

**2. Using python**

```
cd idm.qsv.parent/qsv-code/
./compile-py test.qsv
./run-py test.py
```

