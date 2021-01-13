## Build the compiler in docker:

```
cd idm.qsv.parent/
docker build -t qsv .
```

## Compiling QSV and running generated code:

### bash

```
cd idm.qsv.parent/qsv-code/
./compile-sh test.qsv
./run-sh test.sh
```

### for python

```
cd idm.qsv.parent/qsv-code/
./compile-py test.qsv
./run-py test.py
```

