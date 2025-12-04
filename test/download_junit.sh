#!/bin/bash

# Script to automatically download JUnit libraries

echo "=========================================="
echo "Downloading JUnit Test Libraries"
echo "=========================================="
echo ""

# Create lib directory if it doesn't exist
mkdir -p lib

# Change to lib directory
cd lib

echo "Downloading JUnit 4.13.2..."
curl -L -o junit-4.13.2.jar https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar

if [ $? -eq 0 ]; then
    echo "✓ JUnit downloaded successfully"
else
    echo "✗ Failed to download JUnit"
    exit 1
fi

echo ""
echo "Downloading Hamcrest Core 1.3..."
curl -L -o hamcrest-core-1.3.jar https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

if [ $? -eq 0 ]; then
    echo "✓ Hamcrest Core downloaded successfully"
else
    echo "✗ Failed to download Hamcrest Core"
    exit 1
fi

echo ""
echo "Verifying downloads..."
ls -lh *.jar

echo ""
echo "=========================================="
echo "✓ All libraries downloaded successfully!"
echo "=========================================="
echo ""
echo "Next steps:"
echo "1. Open IntelliJ IDEA"
echo "2. Mark 'test' folder as Test Sources Root"
echo "3. Add JUnit library in Project Structure"
echo "4. Run AllTests.java"
echo ""
echo "See HOW_TO_RUN_TESTS.md for detailed instructions"

