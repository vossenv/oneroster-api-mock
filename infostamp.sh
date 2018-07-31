#!/bin/sh

path=$1
if [[ $(echo $path | wc -w) -lt 1 ]]; then
	path="api/src/main/resources/version.dat"
fi

function trim(){
	echo $1 | awk '{gsub(/^ +| +$/,"")} {print $0}'
}

gitcmd="git log -1 --pretty=format:"

name=$(trim "$(${gitcmd}'%ce')")
hash=$(trim "$(${gitcmd}'%H')")
subject=$(trim "$(${gitcmd}'%s')")
body=$(trim "$(${gitcmd}'%b')")
date=$(date +%m-%d-%Y' '%H:%M:%S)

cat > $path << EOF
committer_email = $name
commit_hash = $hash
build_timestamp = $date
commit_subject = $subject
commit_body = $body
EOF

