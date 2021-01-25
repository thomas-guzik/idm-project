#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat big.csv)
lastColIndex=$(( $(head -1 <(echo "$file") | tr ',' '\n' | wc -l) - 1))
index=$(seq -s ',' 0 $lastColIndex)
v_sumCol0=""
header=$(echo "$file" | head -1)
cut_i6j2=$(echo "$header" | tr ',' '\n' | grep -n -w "^i6j2" |  awk -F ":" '{print $1}')
cut_h6i2=$(echo "$header" | tr ',' '\n' | grep -n -w "^h6i2" |  awk -F ":" '{print $1}')
cut_j3=$(echo "$header" | tr ',' '\n' | grep -n -w "^j3" |  awk -F ":" '{print $1}')
cut_i3=$(echo "$header" | tr ',' '\n' | grep -n -w "^i3" |  awk -F ":" '{print $1}')
cut_j4=$(echo "$header" | tr ',' '\n' | grep -n -w "^j4" |  awk -F ":" '{print $1}')
cut_h3=$(echo "$header" | tr ',' '\n' | grep -n -w "^h3" |  awk -F ":" '{print $1}')
cut_i4=$(echo "$header" | tr ',' '\n' | grep -n -w "^i4" |  awk -F ":" '{print $1}')
cut_j5=$(echo "$header" | tr ',' '\n' | grep -n -w "^j5" |  awk -F ":" '{print $1}')
cut_f2=$(echo "$header" | tr ',' '\n' | grep -n -w "^f2" |  awk -F ":" '{print $1}')
cut_g3=$(echo "$header" | tr ',' '\n' | grep -n -w "^g3" |  awk -F ":" '{print $1}')
cut_h4=$(echo "$header" | tr ',' '\n' | grep -n -w "^h4" |  awk -F ":" '{print $1}')
cut_i5=$(echo "$header" | tr ',' '\n' | grep -n -w "^i5" |  awk -F ":" '{print $1}')
cut_j6=$(echo "$header" | tr ',' '\n' | grep -n -w "^j6" |  awk -F ":" '{print $1}')
cut_f3=$(echo "$header" | tr ',' '\n' | grep -n -w "^f3" |  awk -F ":" '{print $1}')
cut_g4=$(echo "$header" | tr ',' '\n' | grep -n -w "^g4" |  awk -F ":" '{print $1}')
cut_h5=$(echo "$header" | tr ',' '\n' | grep -n -w "^h5" |  awk -F ":" '{print $1}')
cut_f4=$(echo "$header" | tr ',' '\n' | grep -n -w "^f4" |  awk -F ":" '{print $1}')
cut_g5=$(echo "$header" | tr ',' '\n' | grep -n -w "^g5" |  awk -F ":" '{print $1}')
cut_f5=$(echo "$header" | tr ',' '\n' | grep -n -w "^f5" |  awk -F ":" '{print $1}')
cut_f6g2=$(echo "$header" | tr ',' '\n' | grep -n -w "^f6g2" |  awk -F ":" '{print $1}')
cut_g6h2=$(echo "$header" | tr ',' '\n' | grep -n -w "^g6h2" |  awk -F ":" '{print $1}')
nb_cut="$cut_i6j2,$cut_h6i2,$cut_j3,$cut_i3,$cut_j4,$cut_h3,$cut_i4,$cut_j5,$cut_f2,$cut_g3,$cut_h4,$cut_i5,$cut_j6,$cut_f3,$cut_g4,$cut_h5,$cut_f4,$cut_g5,$cut_f5,$cut_f6g2,$cut_g6h2"
nbCol=$(( $(echo "$nb_cut" | tr ',' '\n' | wc -l) -1))
while read -a c
do
type=""
for (( i=0 ; i <= $nbCol ; i++ ))
do
if ! [[ $c =~ ^[0-9]+$ ]] ; then
type="str"
break
fi
done

if [[ type = "str" ]] ; then
v_sumCol0=$v_sumCol0,$(eval echo '${c['$(seq -s ']}${c[' 0 $nbCol)']}')
else 
v_sumCol0=$v_sumCol0,$(( $( eval echo '${c['$(seq -s ']}+${c[' 0 $nbCol)']}' ) ))
fi
done < <(echo "$file"| tail -n +2| cut -d "," -f "$nb_cut")
v_sumCol0=${v_sumCol0:1}
