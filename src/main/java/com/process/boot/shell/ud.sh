#!/bin/zsh

# quickly cd go to ~

# parameter check, only one param
directory=$1

if [[ -n $directory ]]; then
    cd ${HOME}/${directory};
    target=$(pwd)
else
    exit -1
fi