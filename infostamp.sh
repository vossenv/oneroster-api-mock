#!/bin/sh

function trim(){
	echo $1 | awk '{gsub(/^ +| +$/,"")} {print $0}'
}

name=$(trim $(git log -1 --pretty=format:'%ce'))
hash=$(trim $(git log -1 --pretty=format:'%H'))
subject=$(trim $(git log -1 --pretty=format:'%s'))
date=$(date +%m-%d-%Y' '%H:%M:%S)

echo $name $date
echo $(git log -1 --pretty=format:'%H' | tr -d '[:space:]') > test.txt
echo $(trim $(git log -1 --pretty=format:'%ce')) >> test.txt
var=$(git log -1 --pretty=format:'%s' | tr -d '[:space:]')
var=$(date +%m-%d-%Y' '%H:%M:%S | tr -d '[:space:]')
