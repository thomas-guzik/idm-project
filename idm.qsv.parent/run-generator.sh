#! /bin/bash

java -jar idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar test.qsv

echo "Output code:"
cat src-gen/greetings.txt
