#!/bin/bash

# Script to run all 70 comprehensive test cases
# Usage: ./run_all_tests.sh

echo "=========================================="
echo "Running All 70 Test Cases"
echo "=========================================="
echo ""

# Get the project root directory
PROJECT_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$PROJECT_ROOT"

# Check if JUnit libraries exist
if [ ! -f "test/lib/junit-4.13.2.jar" ] || [ ! -f "test/lib/hamcrest-core-1.3.jar" ]; then
    echo "❌ JUnit libraries not found!"
    echo "Downloading JUnit libraries..."
    if [ -f "test/download_junit.sh" ]; then
        bash test/download_junit.sh
    else
        echo "Please download JUnit manually or run: test/download_junit.sh"
        exit 1
    fi
fi

# Create output directory
mkdir -p test/classes

# Compile test classes
echo "📦 Compiling test classes..."
javac -cp "test/lib/junit-4.13.2.jar:test/lib/hamcrest-core-1.3.jar:src" \
      -d test/classes \
      test/project/ComprehensiveTestSuite.java \
      src/project/ConnectionProvider.java 2>&1

if [ $? -ne 0 ]; then
    echo "❌ Compilation failed!"
    exit 1
fi

echo "✅ Compilation successful!"
echo ""

# Run tests
echo "🧪 Running all 70 test cases..."
echo ""

java -cp "test/lib/junit-4.13.2.jar:test/lib/hamcrest-core-1.3.jar:test/classes:src" \
     org.junit.runner.JUnitCore project.ComprehensiveTestSuite

TEST_RESULT=$?

echo ""
if [ $TEST_RESULT -eq 0 ]; then
    echo "=========================================="
    echo "✅ All tests completed successfully!"
    echo "=========================================="
else
    echo "=========================================="
    echo "❌ Some tests failed. Check output above."
    echo "=========================================="
fi

exit $TEST_RESULT

