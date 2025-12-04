# Setting Up Tests in IntelliJ IDEA

## Quick Setup Guide

### Step 1: Download JUnit Libraries

1. Download **JUnit 4.13.2**: https://junit.org/junit4/
   - Direct link: https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar

2. Download **Hamcrest Core 1.3**: https://github.com/hamcrest/JavaHamcrest
   - Direct link: https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

3. Create directory and place JARs:
   ```bash
   mkdir -p test/lib
   # Place junit-4.13.2.jar and hamcrest-core-1.3.jar in test/lib/
   ```

### Step 2: Configure IntelliJ IDEA

1. **Mark test directory as Test Sources:**
   - Right-click on `test` folder
   - Select "Mark Directory as" → "Test Sources Root"
   - The folder should turn green

2. **Add JUnit Library:**
   - File → Project Structure (Ctrl+Alt+Shift+S / Cmd+;)
   - Go to "Libraries"
   - Click "+" → "Java"
   - Navigate to `test/lib/` and select both JAR files:
     - `junit-4.13.2.jar`
     - `hamcrest-core-1.3.jar`
   - Click "OK"

3. **Verify Module Settings:**
   - In Project Structure → Modules → hotel
   - Check that:
     - `src/` is marked as "Sources"
     - `test/` is marked as "Tests"
     - JUnit library is listed in dependencies

### Step 3: Run Tests

#### Option A: Run Individual Test
1. Open any test file (e.g., `ConnectionProviderTest.java`)
2. Right-click on the class name or test method
3. Select "Run 'ConnectionProviderTest'" or "Run 'testGetConnection()'"

#### Option B: Run All Tests
1. Open `AllTests.java`
2. Right-click on the class name
3. Select "Run 'AllTests'"

#### Option C: Run from Test Directory
1. Right-click on `test` folder
2. Select "Run 'All Tests'"

### Step 4: View Test Results

After running tests, you'll see:
- **Green checkmarks (✓)** for passed tests
- **Red X marks** for failed tests
- **Test output** in the console showing detailed results

## Test Execution Output

You should see output like:
```
Testing database connection...
✓ Database connection successful
Testing user login with correct credentials...
✓ User login with correct credentials successful
...
```

## Troubleshooting

### "Cannot resolve symbol 'junit'"
- Ensure JUnit JARs are added to the project libraries
- File → Invalidate Caches / Restart

### "Class not found: org.junit"
- Check that JUnit library is in the classpath
- Re-add JUnit library in Project Structure

### Tests fail with database errors
- Ensure MySQL is running
- Verify database `hotel` exists
- Check connection credentials in `ConnectionProvider.java`

### "Test sources root not configured"
- Right-click `test` folder → "Mark Directory as" → "Test Sources Root"

## Running Tests from Command Line

See `TEST_README.md` for command-line instructions.

## Continuous Integration

For CI/CD pipelines, you can use:
- Maven (if you convert to Maven project)
- Gradle (if you convert to Gradle project)
- Or use the provided shell scripts in `test/` directory

