#!/bin/bash
#fscServer控制脚本

SERVER=./fsc-server-0.1.0.war
PIDFILE=./server.pid
CONFIG=./


#重定标准向输出到文件
exec 1>>server.info
case $1 in
	start ) 
        nohup java -jar $SERVER &
		;;
	 stop ) 
        if [ -f $PIDFILE ]; then
            pid=$(cat ./server.pid)
            kill $pid
            rm $PIDFILE
            echo "服务端已关闭"
        else
            echo "服务未启动"
        fi
        ;;
   status ) 
if [ ! -f $PIDFILE ]; then
    echo "服务端未启动"
   # else
    #    if [ ! -x /proc/${$(cat $PIDFILE)} ]; then
    #        echo "服务端未启动"
    #        else
    #            echo "服务端正在运动 PID:$(cat $PIDFILE)"
     #   fi
fi
        
        ;;
 restart ) ;;
* ) 
echo "指令错误";;
esac

pid=$!

echo "$pid" >$PIDFILE


#trap "执行完成" EXIT
