#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat big.csv)
lastColIndex=$(( $(head -1 <(echo "$file") | tr ',' '\n' | wc -l) - 1))
index=$(seq -s ',' 0 $lastColIndex)
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) -1))
header=$(echo "$file" | head -1)
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) - 1))
n=0
file=$(while read -a c
do
if eval ! [[  $n -ge 3000 '&&' $n -le 7000  ]] ; then
for((i=0; i <= $nbCol; i++))
do
printf "${c[$i]},"
done
printf "\\b\n"
fi
n=$(( $n + 1 ))
done < <(echo "$file"| tail -n +2))
file="$header
$file"