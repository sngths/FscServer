#!/usr/bin/env bash

COMPILER=/Applications/protoc-3.2.0-osx-x86_64/bin/protoc
SRC_DIR=../main/resources/protobuf
DST_DIR=../main/java

$COMPILER -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/$1
