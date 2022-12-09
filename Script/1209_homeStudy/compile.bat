cls
@echo off
echo write your compile java file that you want!
set /p code=
del *.class
cls
javac -encoding utf8 %code%.java

java %code%
