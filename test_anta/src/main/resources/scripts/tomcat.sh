#!/bin/bash

function restartTomcat()
{
	pid=${PIDS[$1-1]}
	tomcat=${TOMCATS[$1-1]}

#	[ "$pid" -a "$tomcat" ] && echo "$tomcat: $pid, restart $tomcat"
	[ ! "$pid" ] && echo "$tomcat: $pid, start $tomcat" && cd $DIR && service $tomcat start;
	[ "$pid" -a "$tomcat" ] && echo "$tomcat: $pid, restart $tomcat" && kill -9 $pid && cd $DIR && service $tomcat start;
}

DIR=/usr/local

declare -a TOMCATS
declare -a PIDS
i=0
for var in $(ls $DIR | grep 'tomcat')
do
	TOMCATS[i]=$var
	pid=$(ps -ef | grep $var | grep -v grep | awk '{print $2}')
	PIDS[i]=$pid
	let i+=1
done

case $1 in
1)
	restartTomcat 1
	;;
2)
	restartTomcat 2
	;;
3)
	restartTomcat 3
	;;
4)
	restartTomcat 4
	;;
5)
	restartTomcat 5
	;;
6)
	restartTomcat 6
	;;
7)
	restartTomcat 7
	;;
*)
	for((i=0;i<${#TOMCATS[@]};i++))
	do
		pid=${PIDS[$i]}
		tomcat=${TOMCATS[$i]}
		echo -e "\033[42;34m $tomcat: $pid \033[0m";
		ls $DIR/$tomcat/webapps;
		echo
	done
	;;
esac

