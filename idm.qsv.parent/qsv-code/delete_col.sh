#!/bin/bash
OLD_IFS=$IFS
IFS=","
file=$(cat big.csv)
lastColIndex=$(( $(head -1 <(echo "$file") | tr ',' '\n' | wc -l) - 1))
index=$(seq -s ',' 0 $lastColIndex)
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) -1))
header_cut=""
header_array=($(echo "$header" | tr ',' ' '))
index_cut=""
index_array=($(echo "$index"))
for((i=0 ; i <= $nbCol ; i++ ))
do
if [[ ${header_array[$i]} != "f1" && ${header_array[$i]} != "f2" && ${header_array[$i]} != "f3" && ${header_array[$i]} != "f4" && ${header_array[$i]} != "f5" && ${header_array[$i]} != "f6" && ${header_array[$i]} != "f7" && ${header_array[$i]} != "f8" && ${header_array[$i]} != "f9" && ${header_array[$i]} != "f10" && ${header_array[$i]} != "g1" && ${header_array[$i]} != "g2" && ${header_array[$i]} != "g3" && ${header_array[$i]} != "g4" && ${header_array[$i]} != "g5" && ${header_array[$i]} != "g6" && ${header_array[$i]} != "g7" && ${header_array[$i]} != "g8" && ${header_array[$i]} != "g9" && ${header_array[$i]} != "g10" && ${header_array[$i]} != "h1" && ${header_array[$i]} != "h2" && ${header_array[$i]} != "h3" && ${header_array[$i]} != "h4" && ${header_array[$i]} != "h5" && ${header_array[$i]} != "h6" && ${header_array[$i]} != "h7" && ${header_array[$i]} != "h8" && ${header_array[$i]} != "h9" && ${header_array[$i]} != "h10" && ${header_array[$i]} != "i1" && ${header_array[$i]} != "i2" && ${header_array[$i]} != "i3" && ${header_array[$i]} != "i4" && ${header_array[$i]} != "i5" && ${header_array[$i]} != "i6" && ${header_array[$i]} != "i7" && ${header_array[$i]} != "i8" && ${header_array[$i]} != "i9" && ${header_array[$i]} != "i10" && ${header_array[$i]} != "j1" && ${header_array[$i]} != "j2" && ${header_array[$i]} != "j3" && ${header_array[$i]} != "j4" && ${header_array[$i]} != "j5" && ${header_array[$i]} != "j6" && ${header_array[$i]} != "j7" && ${header_array[$i]} != "j8" && ${header_array[$i]} != "j9" && ${header_array[$i]} != "j10" && ${header_array[$i]} != "k1" && ${header_array[$i]} != "k2" && ${header_array[$i]} != "k3" && ${header_array[$i]} != "k4" && ${header_array[$i]} != "k5" && ${header_array[$i]} != "k6" && ${header_array[$i]} != "k7" && ${header_array[$i]} != "k8" && ${header_array[$i]} != "k9" && ${header_array[$i]} != "k10" && ${header_array[$i]} != "l1" && ${header_array[$i]} != "l2" && ${header_array[$i]} != "l3" && ${header_array[$i]} != "l4" && ${header_array[$i]} != "l5" && ${header_array[$i]} != "l6" && ${header_array[$i]} != "l7" && ${header_array[$i]} != "l8" && ${header_array[$i]} != "l9" && ${header_array[$i]} != "l10" && ${header_array[$i]} != "m1" && ${header_array[$i]} != "m2" && ${header_array[$i]} != "m3" && ${header_array[$i]} != "m4" && ${header_array[$i]} != "m5" && ${header_array[$i]} != "m6" && ${header_array[$i]} != "m7" && ${header_array[$i]} != "m8" && ${header_array[$i]} != "m9" && ${header_array[$i]} != "m10" && ${header_array[$i]} != "n1" && ${header_array[$i]} != "n2" && ${header_array[$i]} != "n3" && ${header_array[$i]} != "n4" && ${header_array[$i]} != "n5" && ${header_array[$i]} != "n6" && ${header_array[$i]} != "n7" && ${header_array[$i]} != "n8" && ${header_array[$i]} != "n9" && ${header_array[$i]} != "n10" && ${header_array[$i]} != "o1" && ${header_array[$i]} != "o2" && ${header_array[$i]} != "o3" && ${header_array[$i]} != "o4" && ${header_array[$i]} != "o5" && ${header_array[$i]} != "o6" && ${header_array[$i]} != "o7" && ${header_array[$i]} != "o8" && ${header_array[$i]} != "o9" && ${header_array[$i]} != "o10" && ${header_array[$i]} != "p1" && ${header_array[$i]} != "p2" && ${header_array[$i]} != "p3" && ${header_array[$i]} != "p4" && ${header_array[$i]} != "p5" && ${header_array[$i]} != "p6" && ${header_array[$i]} != "p7" && ${header_array[$i]} != "p8" && ${header_array[$i]} != "p9" && ${header_array[$i]} != "p10" && ${header_array[$i]} != "q1" && ${header_array[$i]} != "q2" && ${header_array[$i]} != "q3" && ${header_array[$i]} != "q4" && ${header_array[$i]} != "q5" && ${header_array[$i]} != "q6" && ${header_array[$i]} != "q7" && ${header_array[$i]} != "q8" && ${header_array[$i]} != "q9" && ${header_array[$i]} != "q10" && ${header_array[$i]} != "r1" && ${header_array[$i]} != "r2" && ${header_array[$i]} != "r3" && ${header_array[$i]} != "r4" && ${header_array[$i]} != "r5" && ${header_array[$i]} != "r6" && ${header_array[$i]} != "r7" && ${header_array[$i]} != "r8" && ${header_array[$i]} != "r9" && ${header_array[$i]} != "r10" && ${header_array[$i]} != "s1" && ${header_array[$i]} != "s2" && ${header_array[$i]} != "s3" && ${header_array[$i]} != "s4" && ${header_array[$i]} != "s5" && ${header_array[$i]} != "s6" && ${header_array[$i]} != "s7" && ${header_array[$i]} != "s8" && ${header_array[$i]} != "s9" && ${header_array[$i]} != "s10" && ${header_array[$i]} != "t1" && ${header_array[$i]} != "t2" && ${header_array[$i]} != "t3" && ${header_array[$i]} != "t4" && ${header_array[$i]} != "t5" && ${header_array[$i]} != "t6" && ${header_array[$i]} != "t7" && ${header_array[$i]} != "t8" && ${header_array[$i]} != "t9" && ${header_array[$i]} != "t10" ]]
then
header_cut=$header_cut${header_array[$i]},
index_cut=$index_cut${index_array[$i]},
nb_cut=$nb_cut$(($i+1)),
fi
done
header=${header_cut::-1}
index=${index_cut::-1}
nb_cut=${nb_cut::-1}
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) -1))
nbCol=$(( $(echo "$index" | tr ',' '\n' | wc -l) - 1))
n=0
file=$(while read -a c
do
for((i=0; i <= $nbCol; i++))
do
printf "${c[$i]},"
done
printf "\\b\n"
n=$(( $n + 1 ))
done < <(echo "$file"| tail -n +2| cut -d "," -f "$nb_cut"))
file="$header
$file"
