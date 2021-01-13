#! /bin/bash

if [ $# -lt 1 ];then
    echo "Please provide at least one QSV file"
    exit 1
fi

for file in "$@"; do
    if [[ ! -f "$file" ]]; then
        echo "File $file does not exist"
        exit 1
    fi
done

echo "Found all QSV files."

for file in "$@"; do
    echo "Processing $file ..."
    java -jar idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar test.qsv
    echo "Generated code:"
    echo
    cat src-gen/greetings.txt
    echo
    echo
done

echo "Finished"
