# Quick Start - Running Tests

## Prerequisites Checklist

- [ ] MySQL is running
- [ ] Database `hotel` exists
- [ ] Tables are created (run `QUICK_SETUP.sql`)
- [ ] JUnit 4.13.2 JAR downloaded
- [ ] Hamcrest Core 1.3 JAR downloaded

## Download JUnit Libraries

1. **JUnit 4.13.2:**
   ```
   https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
   ```

2. **Hamcrest Core 1.3:**
   ```
   https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
   ```

3. **Create directory and place files:**
   ```bash
   mkdir -p test/lib
   # Move downloaded JARs to test/lib/
   ```

## IntelliJ IDEA Setup (2 minutes)

1. **Mark test folder:**
   - Right-click `test` folder → "Mark Directory as" → "Test Sources Root"

2. **Add JUnit library:**
   - File → Project Structure → Libraries → "+" → Java
   - Select both JARs from `test/lib/`
   - Click OK

3. **Run tests:**
   - Right-click `AllTests.java` → "Run 'AllTests'"

## Test Files Created

✅ **ConnectionProviderTest.java** - Database connection tests
✅ **DatabaseTest.java** - Table structure and existence tests  
✅ **UserAuthenticationTest.java** - Login and registration tests
✅ **RoomManagementTest.java** - Room CRUD operation tests
✅ **CustomerManagementTest.java** - Check-in/check-out tests
✅ **AdminFunctionsTest.java** - Admin user management tests
✅ **AllTests.java** - Test suite to run all tests

## What Gets Tested

### Database Layer
- Connection establishment
- Table existence
- Table structure validation

### Business Logic
- User authentication
- Room management (add, update, delete, query)
- Customer check-in/check-out
- Bill calculation
- Admin user approval

## Running Tests

### In IntelliJ:
```
Right-click AllTests.java → Run 'AllTests'
```

### Command Line (after setup):
```bash
cd test
./run_tests.sh    # Linux/Mac
run_tests.bat     # Windows
```

## Expected Output

```
Testing database connection...
✓ Database connection successful
Testing signup table exists...
✓ Signup table exists with 11 records
Testing user login with correct credentials...
✓ User login with correct credentials successful
...
```

All tests should show ✓ (green checkmark) when passing.

## Need Help?

See `TEST_README.md` for detailed documentation.
See `INTELLIJ_TEST_SETUP.md` for IntelliJ-specific setup.

