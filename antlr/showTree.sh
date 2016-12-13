#!/bin/bash
./build.sh
javac -cp .:../lib/antlr-4.5.3-complete.jar *.java
# -treeまたは-guiを指定する
java -cp .:../lib/antlr-4.5.3-complete.jar org.antlr.v4.gui.TestRig Karaffe compileUnit -tree $@
