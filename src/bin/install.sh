#!/usr/bin/env bash

LIBS_PATH=../libs

#检查redis包是否存在
if [[ -e ${LIBS_PATH}/redis-3.2.8.tar.gz ]]; then
 echo "redis安装包已存在"
 #检查是否已解压
 if [[ -d  ${LIBS_PATH}/redis-3.2.8/src ]]; then
     echo
 fi
else
 echo "redis安装包不存在 开始下载redis-3.2.8.tar.gz"
 wget http://download.redis.io/releases/redis-3.2.8.tar.gz

 #tar xzf redis-3.2.8.tar.gz
 #cd redis-3.2.8
 #./make
fi

