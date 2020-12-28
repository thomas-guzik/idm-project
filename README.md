Build with gradle in docker:

```
cd cd idm.qsv.parent/
docker build -t qsv-gradle .
```

Run the generator:

```
docker run -it qsv-gradle
```

