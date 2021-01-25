#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat big.csv)
lastColIndex=$(( $(head -1 <(echo "$file") | tr ',' '\n' | wc -l) - 1))
index=$(seq -s ',' 0 $lastColIndex)
v_sumCol0=""
header=$(echo "$file" | head -1)
cut_col0=$(echo "$header" | tr ',' '\n' | grep -n -w "^col0" |  awk -F ":" '{print $1}')
nb_cut="$cut_col0"
type=""
while read c
do
if ! [[ $c =~ ^[0-9]+$ ]] ; then
type="str"
break
fi
done < <(echo "$file"| tail -n +2| cut -d "," -f "$nb_cut")

while read c
do
if [[ $type = "str" ]] ; then	
v_sumCol0="$v_sumCol0$c"
else 
v_sumCol0=$(( $v_sumCol0 + $c ))
fi
done < <(echo "$file"| tail -n +2| cut -d "," -f "$nb_cut")
