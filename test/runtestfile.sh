#!/bin/bash
file=$1
java -jar Karaffe-Compiler.jar $file > "${file}_compiler-output" 2>&1
compilerstatus=$?
diff "${file}_compiler-output" ${file}_out > /dev/null 2>&1
diffstatus=$?
if [ $diffstatus = 2 ] && [ $compilerstatus = 0 ]; then
    echo -n "W"
    {
        echo "WARN  : ${file}" >> testoutputs
        echo "Warning: no out file found. but compilation is succeed." >> testoutputs
        echo 
    } >> testoutputs
    exit 1
fi

if [ $diffstatus = 0 ]  && [ $compilerstatus = 0 ]; then
    echo -n "."
    exit 0
else
    echo -n "E"
    {
        echo "ERROR  : ${file}"
        echo "CompilerStatus : ${compilerstatus}"
        echo "----COMPILEROUTPUT----"
        if [ -e "${file}_compiler-output" ]; then
          cat "${file}_compiler-output"
        fi
        echo "-------EXPECTED-------"
        cat ${file}_out
        echo "----------------------"
        echo
    } >> ${file}_testoutputs
    exit 2
fi