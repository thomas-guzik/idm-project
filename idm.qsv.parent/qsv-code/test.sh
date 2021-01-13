#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat foo1.csv)

header=`echo "$file" | head -1`
nbCol=$(( `echo "$header" | tr ',' '\n' | wc -l` - 1))
echo "  `echo "$header" | tr ',' ' '`"
n=0
echo "$file" | tail -n +2 | while read -a c
do
echo $n $(eval echo '${c['`seq -s ']} ${c[' 0 $nbCol`]'}')
n=$(( $n + 1 ))
done
