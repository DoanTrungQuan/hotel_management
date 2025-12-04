Manual Testing Guide - How to Test Manually and Match Automated Test Results

This guide shows you how to manually test the application to get the same results as the automated test cases.

PREREQUISITES:
1. Database is running (MySQL)
2. Application is compiled and ready to run
3. Test suite has been run at least once (to populate test data)

================================================================================
STEP 1: RUN THE TEST SUITE FIRST (To Initialize Test Data)
================================================================================

Before manual testing, you MUST run the automated test suite once to populate the database with test data.

Option A: Run from IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to: test/project/QuanTestSuite.java
3. Right-click on the file or class name
4. Select "Run 'QuanTestSuite'"
5. Wait for all 70 tests to complete
6. Check console output - you should see "✓ Test database initialized with test data"

Option B: Run from Command Line
1. Open terminal in the project root directory
2. Navigate to test directory: cd test
3. Run the test script: ./run_tests.sh (or run_all_tests.sh)
4. Wait for tests to complete

WHY: The test suite automatically creates all test users, rooms, and customers needed for manual testing.

================================================================================
STEP 2: TEST DATA THAT WAS CREATED
================================================================================

After running the test suite, the following test data is available:

TEST USERS (in signup table):
NOTE: All users start with "approved" status for easy manual testing.
Tests that need "panding" status will set it themselves during execution.

- Email: test61@test.com | Password: pass | Status: approved (can login)
- Email: test62@test.com | Password: pass | Status: approved (can login)
- Email: test63@test.com | Password: pass | Status: approved (can login)
- Email: test64@test.com | Password: pass | Status: approved (can login)
- Email: test65@test.com | Password: pass | Status: approved (can login) ← For Admin search test
- Email: test66@test.com | Password: pass | Status: approved (can login)
- Email: test67@test.com | Password: pass | Status: approved (can login)
- Email: test68@test.com | Password: pass | Status: approved (can login)
- Email: test69@test.com | Password: pass | Status: approved (can login)
- Email: test70@test.com | Password: pass | Status: approved (can login)

TEST ROOMS (in room table):
- Room Number: QTEST01 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST02 | Type: AC | Bed: Double | Price: 2000.00 | Status: Not Booked
- Room Number: QTEST03 | Type: NON AC | Bed: Single | Price: 1000.00 | Status: Booked
- Room Number: QTEST04 | Type: NON AC | Bed: Double | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST05 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST32 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST33 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST34 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST35 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked
- Room Number: QTEST36 | Type: AC | Bed: Single | Price: 1500.00 | Status: Booked
- Room Number: QTEST37 | Type: AC | Bed: Single | Price: 1500.00 | Status: Not Booked

================================================================================
STEP 3: MANUAL TESTING STEPS (Examples Matching Automated Tests)
================================================================================

MODULE 1: ADMIN MANAGEMENT TESTS

Test TC_AM_05: Search User - Exists (Found)
1. Start the application
2. Login as admin:
   - Email: admin
   - Password: admin
3. You should see the Admin panel
4. In the "Search by Email" field, enter: test65@test.com
5. Click the "Search" button
6. Expected Result: User should appear in the table below
   - Name: Test User
   - Email: test65@test.com
   - Status: approved
7. If you see the user → Test PASS (matches automated test result)
8. If "Record Not Found" → Test FAIL (data not initialized properly)

Test TC_AM_06: Search User - Not Exists (Not Found)
1. In Admin panel, search for: nonexistent@test.com
2. Click "Search"
3. Expected Result: Message "Record Not Found" or empty table
4. If you see "Record Not Found" → Test PASS (matches automated test result)

Test TC_AM_01: Check User Status - Pending
NOTE: This test sets status to "panding" before checking it.
1. Login as admin (admin/admin)
2. In the Admin panel, look at the table
3. Find email: test61@test.com
4. Check the Status column
5. Expected Result: After running automated test, status should be "panding"
   (For manual testing: New users start as "panding" after signup. Admin can double-click to approve them.)
6. If status matches expected → Test PASS

Test TC_AM_02: Check User Status - Approved
1. In Admin panel, find email: test62@test.com
2. Check the Status column
3. Expected Result: Status should be "approved"
4. If status is "approved" → Test PASS

Test TC_AM_03: Change Status from Pending to Approved
NOTE: This test sets status to "panding" first, then changes to "approved".
1. In Admin panel, first set status to "panding" for test63@test.com (double-click row)
2. Confirm the change to "panding"
3. Double-click on the row again (as instructed: "Double Click on Table row to change Status")
4. Confirm the change when prompted
5. Expected Result: Status changes from "panding" to "approved"
6. Refresh if needed (click Refresh button)
7. Verify status is now "approved" → Test PASS

Test TC_AM_04: Change Status from Approved to Pending
1. In Admin panel, find email: test64@test.com (should be "approved")
2. Double-click on the row
3. Confirm the change
4. Expected Result: Status changes to "panding"
5. Refresh and verify → Test PASS

MODULE 2: BOOKING MODULE TESTS

Test TC_BM_13: Room Available - Can Book
1. Login as regular user:
   - Email: test62@test.com (approved status - can login immediately)
   - Password: pass
2. Click "Manage Room" button
3. Try to add/check a room with number: QTEST01
4. Check if room status is "Not Booked"
5. Expected Result: Room should be available for booking
6. If room is available → Test PASS

Test TC_BM_04: Room Number Validation - Empty
1. In Manage Room form
2. Try to save a room with empty room number field
3. Expected Result: Should show validation error or not save
4. If error shown → Test PASS

MODULE 3: CUSTOMER MODULE TESTS

Test TC_CM_11: Customer Check-In - Valid Data
1. Login as regular user (test62@test.com / pass)
2. Click "Customer Check In" button
3. Fill in customer details:
   - Name: Test Customer
   - Mobile: 9876543210
   - Email: customer@test.com
   - Gender: Male
   - Address: 123 Test St
   - ID: 999999999999
   - Nationality: Indian
   - Room Number: QTEST32 (must be "Not Booked")
   - Bed: Single
   - Room Type: AC
   - Price: 1500.00
4. Click "Check In" or Save button
5. Expected Result: Customer check-in successful message
6. If successful → Test PASS

Test TC_CM_12: Customer Check-Out - Valid Data
1. First, ensure a customer is checked in (use Check In from previous test)
2. Click "Customer Check Out" button
3. Enter room number where customer is checked in
4. Click "Search" to load customer details
5. Calculate amount (if not auto-calculated)
6. Click "Check Out" button
7. Expected Result: Check-out successful message
8. If successful → Test PASS

================================================================================
STEP 4: VERIFY RESULTS MATCH AUTOMATED TESTS
================================================================================

After each manual test, compare your result with the automated test result:

Automated Test Output:
- Look at the test console output when you ran QuanTestSuite
- Find the corresponding test (e.g., "Test 65 [ADMIN]: Search user - exists = found")
- Check if it says "PASS" or shows an error

Manual Test Result:
- Compare what you observed manually
- Should match the automated test result

Example Match:
Automated: Test 65 [ADMIN]: Search user - exists = found PASS: User found
Manual: Search for test65@test.com → User found in table → MATCH ✓

================================================================================
STEP 5: TROUBLESHOOTING
================================================================================

If manual test results don't match automated tests:

1. Check if test data exists:
   - Connect to MySQL database
   - Run: SELECT * FROM signup WHERE email LIKE 'test%';
   - Should show 10 test users
   - If empty → Run test suite again

2. Check if database connection is correct:
   - Verify MySQL is running
   - Check connection string in ConnectionProvider.java
   - Default: jdbc:mysql://localhost:3306/hotel

3. Check if user status allows login:
   - All test users start with "approved" status - all can login immediately
   - Admin login: admin/admin (always works)
   - If a user cannot login, check if status was changed (some tests change status)

4. Refresh the application:
   - Close and reopen the application
   - Click "Refresh" buttons in forms
   - Data might need to be reloaded

5. Re-run test suite:
   - If data is missing, run the test suite again
   - This will recreate all test data
   - Then try manual testing again

================================================================================
QUICK REFERENCE: TEST DATA SUMMARY
================================================================================

LOGIN CREDENTIALS:
- Admin: email=admin, password=admin
- ALL TEST USERS: All can login (all start with "approved" status)
  - User 1: email=test61@test.com, password=pass (approved - can login)
  - User 2: email=test62@test.com, password=pass (approved - can login)
  - User 3: email=test65@test.com, password=pass (approved - can login)
  - (Same for all test61@test.com through test70@test.com)

ROOMS FOR TESTING:
- Available: QTEST01, QTEST02, QTEST04, QTEST05, QTEST32-QTEST35, QTEST37
- Booked: QTEST03, QTEST36

TEST USERS FOR ADMIN MODULE:
- ALL USERS START AS: approved (all test61@test.com through test70@test.com)
- Tests that need "panding" status will change it during test execution
- For manual testing: You can use any email immediately - all are approved

================================================================================
IMPORTANT NOTES
================================================================================

1. Test data persists after running tests (unlike before)
   - Data is NOT deleted after tests complete
   - You can manually test anytime after running test suite
   - To reset data, run test suite again

2. ALL TEST USERS START AS "APPROVED" STATUS
   - All test users (test61@test.com through test70@test.com) are created with "approved" status
   - You can immediately login with any test email for manual testing
   - No prerequisites needed - any test can run independently
   - Tests that need "panding" status will set it themselves during execution

2. If you modify data during manual testing:
   - The next automated test run will recreate data
   - Manual changes will be overwritten
   - To keep manual changes, don't run tests again

3. Test data email pattern:
   - All test users: email LIKE 'test%'
   - All test rooms: roomnumber LIKE 'QTEST%'
   - These patterns are used for cleanup/recreation

4. Running tests multiple times:
   - Safe to run multiple times
   - Data is recreated each time
   - Manual testing can be done between test runs

================================================================================
NEXT STEPS
================================================================================

1. Run the automated test suite once
2. Verify test data exists in database
3. Start manual testing using the steps above
4. Compare manual results with automated test results
5. Report any mismatches or issues

Good luck with your manual testing!

