#! /bin/bash

if [ $# -lt 1 ];then
    echo "Please provide at least one QSV file"
    exit 1
fi

FILES_LOCATION=/qsv-code

for file in "$@"; do
    if [[ ! -f "$FILES_LOCATION/$file" ]]; then
        echo "File $file does not exist in the .$FILES_LOCATION directory"
        exit 1
    fi
    case "$file" in
        *.qsv)
            # it's a qsv file
            ;;
        *)
            # it's not
            echo "Please provide only .qsv files"
            exit 1
            ;;
    esac
done

echo "Found all QSV files."

for file in "$@"; do
    echo "Processing $file ..."
    echo
    java -jar idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar "$FILES_LOCATION/$file"
    echo
    echo
done

echo "Finished for all the files"
