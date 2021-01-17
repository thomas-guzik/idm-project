**Build the compiler in docker**

```
cd idm.qsv.parent/
docker build -t qsv .
```


**Compiling and running generated code**

```
cd idm.qsv.parent/qsv-code/
./run sh,py,int test.qsv test2.qsv
```

You can use sh,py,int to try out all three versions on all the files. It is also possible to only pick one or two by following the same syntax.

Using the py option for the first time will trigger the build of a Python docker image containing necessary dependencies (such as pandas).


NB: if you need to run docker using `sudo`, you can first update the necessary files using:

```
sed -i 's/docker/sudo docker/g' qsv-code/compile-* qsv-code/run*
```
(also in the `idm.qsv.parent` directory)
