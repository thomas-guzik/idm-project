#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat foo1.csv)
lastColIndex=$(( $(head -1 <(echo "$file") | tr ',' '\n' | wc -l) - 1))
index=$(seq -s ',' 0 $lastColIndex)
header=$(echo "$file" | head -1)
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) - 1))
n=0
echo "  $(echo "$header" | tr ',' ' ')"
echo "$file" | tail -n +2 | while read -a c
do
echo $n $(eval echo '${c['$(seq -s ']} ${c[' 0 $nbCol)]'}')
n=$(( $n + 1 ))
done
