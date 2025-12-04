@echo off
REM Script to run JUnit tests for Hotel Management System (Windows)
REM Make sure JUnit and Hamcrest JARs are in test\lib\ directory

echo ==========================================
echo Hotel Management System - Test Runner
echo ==========================================
echo.

REM Check if JUnit JARs exist
if not exist "test\lib\junit-4.13.2.jar" (
    echo ERROR: junit-4.13.2.jar not found in test\lib\
    echo Please download JUnit 4.13.2 from https://junit.org/junit4/
    exit /b 1
)

if not exist "test\lib\hamcrest-core-1.3.jar" (
    echo ERROR: hamcrest-core-1.3.jar not found in test\lib\
    echo Please download Hamcrest Core 1.3 from https://github.com/hamcrest/JavaHamcrest
    exit /b 1
)

REM Compile test classes
echo Compiling test classes...
javac -cp "dist\lib\mysql-connector-j-9.4.0.jar;test\lib\junit-4.13.2.jar;test\lib\hamcrest-core-1.3.jar;out\production\hotel" ^
      -d out\test ^
      test\project\*.java

if errorlevel 1 (
    echo ERROR: Compilation failed
    exit /b 1
)

echo Compilation successful
echo.

REM Run tests
echo Running tests...
echo.

java -cp "out\test;out\production\hotel;dist\lib\mysql-connector-j-9.4.0.jar;test\lib\junit-4.13.2.jar;test\lib\hamcrest-core-1.3.jar" ^
     org.junit.runner.JUnitCore project.AllTests

echo.
echo ==========================================
echo Test execution completed
echo ==========================================
pause

