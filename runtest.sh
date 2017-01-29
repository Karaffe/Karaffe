#!/bin/bash

for file in `/bin/find . | grep "_testoutputs"`; do
  rm $file
done 

./gradlew fatJar > gradleoutput 2>&1

if [ $? -ne 0 ]; then
  cat gradleoutput
  echo "error detected."
  exit -1
fi

mv build/libs/Karaffe-Compiler-*.jar test/Karaffe-Compiler.jar
if [ $? -ne 0 ]; then
  echo "error detected."
  exit -1
fi

cd test/

if [ -e out ]; then
  rm out
fi

if [ -e testoutputs ]; then
  rm testoutputs
fi

/bin/find . | grep "\.krf$" | xargs -P 4 -n 1 ./runtestfile.sh

/bin/find . | grep "_testoutputs" | xargs cat > out

if [ -s out ]; then
  echo 
  cat out
  exit -1
else
  echo
  echo "ALL TEST PASSED"
  exit 0
fi
