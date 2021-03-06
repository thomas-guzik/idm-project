#!/bin/bash

target_language=$1
case "$target_language" in
    sh | py | int)
        # it's a valid target language
        ;;
    *)
        # it's not
        echo "Please provide a valid target language first: sh, py or int (for interpretation)"
        exit 1
        ;;
esac


# remove first parameter
set -- "${@:2}"

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

for file in "$@"; do
    echo "Processing $file ..."
    echo
    java -jar idm.qsv/build/libs/idm.qsv-1.0.0-SNAPSHOT.jar "$target_language" "$FILES_LOCATION/$file"
    echo
    echo "Done processing $file"
    echo
done

