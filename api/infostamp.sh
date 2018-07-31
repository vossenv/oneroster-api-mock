#!/bin/sh

function trim(){
	echo $1 | awk '{gsub(/^ +| +$/,"")} {print $0}'
}

echo $(trim $(git log -1 --pretty=format:'%ce'))




echo $(git log -1 --pretty=format:'%H' | tr -d '[:space:]') > test.txt
echo $(trim $(git log -1 --pretty=format:'%ce')) >> test.txt
var=$(git log -1 --pretty=format:'%s' | tr -d '[:space:]')
var=$(date +%m-%d-%Y' '%H:%M:%S | tr -d '[:space:]')
