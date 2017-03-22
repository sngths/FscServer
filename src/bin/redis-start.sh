#!/bin/bash
BASE_PATH=pwd
BIN_PATH=${BASE_PATH}/bin
../libs/redis-3.2.8/src/redis-server ../config/redis.conf daemonize yes
