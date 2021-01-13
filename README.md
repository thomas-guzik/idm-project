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

NB: if you need to run docker using `sudo`, you can first update the necessary files using:

```
sed -i 's/docker/sudo docker/g' qsv-code/compile-py qsv-code/compile-sh qsv-code/run-py
```
(also in the `idm.qsv.parent` directory)
