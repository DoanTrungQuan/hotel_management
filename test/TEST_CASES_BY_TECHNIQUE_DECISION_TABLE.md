# Test Cases by Technique: Decision Table

**Total Test Cases:** 28

- **Quan's Test Cases:** 14
- **Lam's Test Cases:** 14

---

## QUAN'S TEST CASES

### 1. TC_BM_13

**Description:** Verify room booking when room is available

**Precondition:** System is running, room exists with status "Not Booked"

**Test Steps:**
1. Search for room with number "QTEST13"
2. Check room status is "Not Booked"
3. Attempt to book the room

**Test Data:** roomNumber = "QTEST13", status = "Not Booked"

**Expected Result:** Room can be booked successfully

**Actual Result:** Room found and available = true

**Status:** PASS

**Comments:** Decision Table - TC1: Status = "Not Booked" (Y), Room Number = "Valid" (Y) → Can Book (Bảng 12: Room Booking Decision, TC1)

---

### 2. TC_BM_14

**Description:** Verify room booking when room is already booked

**Precondition:** System is running, room exists with status "Booked"

**Test Steps:**
1. Search for room with number "QTEST14"
2. Check room status is "Booked"
3. Attempt to book the room

**Test Data:** roomNumber = "QTEST14", status = "Booked"

**Expected Result:** Room cannot be booked

**Actual Result:** Room not available = false

**Status:** PASS

**Comments:** Decision Table - TC3: Status = "Booked" (Y), Room Number = "Valid" (Y) → Cannot Book (Bảng 12: Room Booking Decision, TC3)

---

### 3. TC_BM_20

**Description:** Verify duplicate room number prevention

**Precondition:** System is running, room "QTEST20" already exists in database

**Test Steps:**
1. Open room management form
2. Enter room number "QTEST20" (duplicate)
3. Enter other room details
4. Attempt to save

**Test Data:** roomNumber = "QTEST20" (already exists)

**Expected Result:** System prevents duplicate, shows error

**Actual Result:** SQLException (duplicate prevented)

**Status:** PASS

**Comments:** Decision Table - TC2: Room Number = "Invalid" (Y) → Cannot Book (Bảng 12: Room Booking Decision, TC2)

---

### 4. TC_CM_11

**Description:** Verify customer check-in with all valid data

**Precondition:** System is running, room "QTEST31" exists and is available

**Test Steps:**
1. Open customer check-in form
2. Enter all valid customer details
3. Select available room "QTEST31"
4. Click save button

**Test Data:** All customer fields valid, room available

**Expected Result:** Customer checked in successfully

**Actual Result:** Check-in successful, INSERT result = 1

**Status:** PASS

**Comments:** Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 13: Customer Checkout Decision, TC1)

---

### 5. TC_CM_12

**Description:** Verify customer checkout with valid amount and days

**Precondition:** System is running, customer is checked in, room "QTEST32" is booked

**Test Steps:**
1. Open customer checkout form
2. Search for customer by room number "QTEST32"
3. Enter amount = 4500.00, days = 3
4. Click checkout button

**Test Data:** Customer checked in, amount = 4500.00, days = 3

**Expected Result:** Customer checked out successfully

**Actual Result:** Check-out successful, UPDATE result = 1

**Status:** PASS

**Comments:** Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 13: Customer Checkout Decision, TC1)

---

### 6. TC_CM_13

**Description:** Verify customer checkout when already checked out

**Precondition:** System is running, customer is already checked out

**Test Steps:**
1. Open customer checkout form
2. Search for customer by room number "QTEST33"
3. Attempt to checkout again

**Test Data:** Customer already checked out

**Expected Result:** System prevents duplicate checkout

**Actual Result:** Cannot checkout again = true

**Status:** PASS

**Comments:** Decision Table - TC4: Status = "checked out" (Y) → Already Checked Out (Bảng 13: Customer Checkout Decision, TC4)

---

### 7. TC_NS_08

**Description:** Verify success message display when operation succeeds

**Precondition:** System is running, operation module is accessible

**Test Steps:**
1. Perform operation that succeeds
2. Check displayed message

**Test Data:** operationSuccess = true

**Expected Result:** Success message is shown

**Actual Result:** Success message shown = true

**Status:** PASS

**Comments:** Decision Table - TC1: Operation = "Success" (Y), Action = "Confirm" (Y) → Show Success Message (Bảng 14: Notification Display Decision, TC1)

---

### 8. TC_NS_09

**Description:** Verify error message display when operation fails

**Precondition:** System is running, operation module is accessible

**Test Steps:**
1. Perform operation that fails
2. Check displayed message

**Test Data:** operationError = true

**Expected Result:** Error message is shown

**Actual Result:** Error message shown = true

**Status:** PASS

**Comments:** Decision Table - TC3: Operation = "Error" (Y), Action = "Confirm" (Y) → Show Error Message (Bảng 14: Notification Display Decision, TC3)

---

### 9. TC_DH_05

**Description:** Verify button click opens correct form

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Click Manage Room button
3. Verify correct form opens

**Test Data:** clickedButton = "ManageRoom"

**Expected Result:** ManageRoom form opens

**Actual Result:** Opens correct form = true

**Status:** PASS

**Comments:** Decision Table - Button Click: ManageRoom (Bảng 16: Button Click Decision, Dòng 1)

---

### 10. TC_AM_03

**Description:** Verify status change from pending to approved

**Precondition:** System is running, admin module is accessible, user exists

**Test Steps:**
1. Open admin management form
2. Test sets status to "panding" for test63@test.com
3. Search for user "test63@test.com"
4. Double-click on user row
5. Confirm status change to "approved"

**Test Data:** email = "test63@test.com", status initially "approved", test sets to "panding" then changes to "approved"

**Expected Result:** Status updated successfully to "approved"

**Actual Result:** Status updated successfully, UPDATE result = 1

**Status:** PASS

**Comments:** Decision Table - TC1: Status = "pending" (Y), Action = "Change to approved" (Y) → Success (Bảng 15: Admin Status Change Decision, TC1). Note: User starts as "approved", test sets status to "panding" first.

---

### 11. TC_AM_04

**Description:** Verify status change from approved to pending

**Precondition:** System is running, admin module is accessible, user exists with status "approved"

**Test Steps:**
1. Open admin management form
2. Search for user "test64@test.com"
3. Double-click on user row
4. Confirm status change to "panding"

**Test Data:** email = "test64@test.com", status change from "approved" to "panding"

**Expected Result:** Status updated successfully to "panding"

**Actual Result:** Status updated successfully, UPDATE result = 1

**Status:** PASS

**Comments:** Decision Table - TC2: Status = "approved" (Y), Action = "Change to pending" (Y) → Success (Bảng 15: Admin Status Change Decision, TC2)

---

### 12. TC_AM_05

**Description:** Verify user search when user exists

**Precondition:** System is running, admin module is accessible, user exists in database

**Test Steps:**
1. Open admin management form
2. Enter email "test65@test.com" in search field
3. Click search button

**Test Data:** email = "test65@test.com" (exists)

**Expected Result:** User found and displayed

**Actual Result:** User found = true

**Status:** PASS

**Comments:** Decision Table - TC1: User = "Exists" (Y) → Show User Data (Bảng 19: Admin Search Decision, TC1)

---

### 13. TC_AM_06

**Description:** Verify user search when user does not exist

**Precondition:** System is running, admin module is accessible

**Test Steps:**
1. Open admin management form
2. Enter email "nonexistent@test.com" in search field
3. Click search button

**Test Data:** email = "nonexistent@test.com" (not exists)

**Expected Result:** Message "Record Not Found" displayed

**Actual Result:** Message "Record Not Found" displayed = true

**Status:** PASS

**Comments:** Decision Table - TC2: User = "Not Exists" (Y) → Show "Record Not Found" (Bảng 19: Admin Search Decision, TC2)

---

### 14. TC_AM_10

**Description:** Verify approve user operation simple path

**Precondition:** System is running, admin module is accessible, user exists
Note: User starts as "approved", test sets status to "panding" first, then approves it

**Test Steps:**
1. Open admin management form
2. Test sets status to "panding" for test70@test.com
3. Search for user "test70@test.com"
4. Double-click to change status
5. Change status to "approved"
6. Verify status is updated

**Test Data:** email = "test70@test.com", status initially "approved", test sets to "panding" then changes to "approved"

**Expected Result:** User approved successfully

**Actual Result:** User approved successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through approve user function

Test Summary

Module  Test Count  Status

1. Booking Module  20  ALL PASS
2. Customer Module  20  ALL PASS
3. Notification System  10  ALL PASS
4. Website Home/Dashboard  10  ALL PASS
5. Admin Management  10  ALL PASS
TOTAL  70  ALL PASS

Testing Techniques Used

Black Box Testing
Boundary Value Analysis: 11 tests
Equivalence Partitioning: 21 tests
Decision Table: 18 tests

White Box Testing
Basic Path Testing: 10 tests
Branch Testing: 10 tests

Total Test Cases: 70
All Tests Status: PASS

---

## LAM'S TEST CASES

### 1. TC_LL_09

**Description:** Verify login decision with valid email, valid password, and approved status

**Precondition:** System is running, user exists with status "approved"

**Test Steps:**
1. Open login form
2. Enter email = "lamtest09@test.com"
3. Enter password = "pass"
4. Click login button

**Test Data:** email = "lamtest09@test.com", password = "pass", status = "approved"

**Expected Result:** Login successful

**Actual Result:** Login successful = true

**Status:** PASS

**Comments:** Decision Table - TC1: Email = "Valid" (Y), Password = "Valid" (Y), Status = "approved" (Y) → Can Login (Bảng 5: Login Decision, TC1)

---

### 2. TC_LL_10

**Description:** Verify login decision with valid email, valid password, and pending status

**Precondition:** System is running, user exists
Note: User starts as "approved", test sets status to "panding" first

**Test Steps:**
1. Test sets status to "panding" for lamtest10@test.com
2. Open login form
3. Enter email = "lamtest10@test.com"
4. Enter password = "pass"
5. Click login button

**Test Data:** email = "lamtest10@test.com", password = "pass", status initially "approved", test sets to "panding"

**Expected Result:** Login denied

**Actual Result:** Login denied = false

**Status:** PASS

**Comments:** Decision Table - TC2: Email = "Valid" (Y), Password = "Valid" (Y), Status = "panding" (Y) → Cannot Login (Bảng 5: Login Decision, TC2). Note: User starts as "approved", test sets status to "panding" before checking.

---

### 3. TC_RM_10

**Description:** Verify add room decision with all fields valid

**Precondition:** System is running, room management module is accessible, database connection available

**Test Steps:**
1. Open room management form
2. Enter room number = "LTEST25"
3. Select type = "AC", bed = "Single"
4. Enter price = 1500.00, status = "Not Booked"
5. Click save button

**Test Data:** roomNumber = "LTEST25", type = "AC", bed = "Single", price = 1500.00, status = "Not Booked"

**Expected Result:** Room added successfully

**Actual Result:** INSERT result = 1 (success)

**Status:** PASS

**Comments:** Decision Table - TC1: Room Number = "Unique" (Y), Room Type = "Valid" (Y), Price = "Valid" (Y) → Can Add (Bảng 10: Room Addition Decision, TC1)

---

### 4. TC_RM_11

**Description:** Verify add room decision with duplicate room number

**Precondition:** System is running, room "LTEST26" already exists in database

**Test Steps:**
1. Open room management form
2. Enter room number = "LTEST26" (duplicate)
3. Enter other valid fields
4. Attempt to save

**Test Data:** roomNumber = "LTEST26" (already exists)

**Expected Result:** System prevents duplicate room number

**Actual Result:** SQLException (duplicate prevented)

**Status:** PASS

**Comments:** Decision Table - TC4: Room Number = "Duplicate" (Y) → Cannot Add (Bảng 10: Room Addition Decision, TC4)

---

### 5. TC_PI_07

**Description:** Verify checkout decision with valid amount and days

**Precondition:** System is running, customer is checked in

**Test Steps:**
1. Open checkout form
2. Search for checked-in customer
3. Enter amount = 4500.00, days = 3
4. Click checkout button

**Test Data:** Customer checked in, amount = 4500.00, days = 3

**Expected Result:** Checkout successful

**Actual Result:** Checkout successful, UPDATE result = 1

**Status:** PASS

**Comments:** Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 14: Checkout Decision, TC1)

---

### 6. TC_PI_08

**Description:** Verify checkout decision without amount

**Precondition:** System is running, customer is checked in

**Test Steps:**
1. Open checkout form
2. Search for checked-in customer
3. Leave amount field empty
4. Attempt to checkout

**Test Data:** amount = "" (empty)

**Expected Result:** Checkout prevented

**Actual Result:** Checkout prevented = true

**Status:** PASS

**Comments:** Decision Table - TC2: Status = "checked in" (Y), Amount = "Invalid" (Y) → Cannot Checkout (Bảng 14: Checkout Decision, TC2)

---

### 7. TC_DL_07

**Description:** Verify button click opens correct form

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Click Manage Room button
3. Verify correct form opens

**Test Data:** clickedButton = "ManageRoom"

**Expected Result:** ManageRoom form opens

**Actual Result:** Opens correct form = true

**Status:** PASS

**Comments:** Decision Table - Button Click: ManageRoom (Bảng 17: Button Click Decision, Dòng 1)

---

### 8. TC_RG_05

**Description:** Verify query by bill ID decision when bill exists

**Precondition:** System is running, bill "BILLLTEST60" exists in database

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLLTEST60"
3. Click search button

**Test Data:** billid = "BILLLTEST60" (exists)

**Expected Result:** Bill found and displayed

**Actual Result:** Bill found = true

**Status:** PASS

**Comments:** Decision Table - TC1: Bill ID Format = "Valid" (Y), Bill Exists = "Exists" (Y) → Show Bill Data (Bảng 21: Bill Query Decision, TC1)

---

### 9. TC_RG_06

**Description:** Verify query by bill ID decision when bill does not exist

**Precondition:** System is running, bill "BILLNONEXISTENT" does not exist

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLNONEXISTENT"
3. Click search button

**Test Data:** billid = "BILLNONEXISTENT" (not exists)

**Expected Result:** Bill not found message displayed

**Actual Result:** Bill not found = false

**Status:** PASS

**Comments:** Decision Table - TC2: Bill ID Format = "Valid" (Y), Bill Exists = "Not Exists" (Y) → Show Error (Bảng 21: Bill Query Decision, TC2)

---

### 10. TC_DI_01

**Description:** Verify email uniqueness constraint - unique email can insert

**Precondition:** System is running, database is accessible, email "lamtest66@test.com" does not exist

**Test Steps:**
1. Open user registration form
2. Enter email = "lamtest66@test.com" (unique)
3. Enter other valid fields
4. Attempt to save

**Test Data:** email = "lamtest66@test.com" (unique)

**Expected Result:** User inserted successfully

**Actual Result:** INSERT result = 1 (success)

**Status:** PASS

**Comments:** Decision Table - TC1: Email = "Unique" (Y), Room Number = "Unique" (Y) → Can Insert (Bảng 22: Database Insert Decision, TC1)

---

### 11. TC_DI_02

**Description:** Verify email uniqueness constraint - duplicate email cannot insert

**Precondition:** System is running, email "lamtest67@test.com" already exists in database

**Test Steps:**
1. Open user registration form
2. Enter email = "lamtest67@test.com" (duplicate)
3. Enter other valid fields
4. Attempt to save

**Test Data:** email = "lamtest67@test.com" (already exists)

**Expected Result:** System prevents duplicate email

**Actual Result:** SQLException (duplicate prevented)

**Status:** PASS

**Comments:** Decision Table - TC3: Email = "Duplicate" (Y) → Cannot Insert Email (Bảng 22: Database Insert Decision, TC3)

---

### 12. TC_DI_03

**Description:** Verify room number uniqueness constraint - unique room number can insert

**Precondition:** System is running, database is accessible, room number "LTEST68" does not exist

**Test Steps:**
1. Open room management form
2. Enter room number = "LTEST68" (unique)
3. Enter other valid fields
4. Attempt to save

**Test Data:** roomNumber = "LTEST68" (unique)

**Expected Result:** Room inserted successfully

**Actual Result:** INSERT result = 1 (success)

**Status:** PASS

**Comments:** Decision Table - TC1: Email = "Unique" (Y), Room Number = "Unique" (Y) → Can Insert (Bảng 22: Database Insert Decision, TC1)

---

### 13. TC_DI_04

**Description:** Verify room number uniqueness constraint - duplicate room number cannot insert

**Precondition:** System is running, room number "LTEST69" already exists in database

**Test Steps:**
1. Open room management form
2. Enter room number = "LTEST69" (duplicate)
3. Enter other valid fields
4. Attempt to save

**Test Data:** roomNumber = "LTEST69" (already exists)

**Expected Result:** System prevents duplicate room number

**Actual Result:** SQLException (duplicate prevented)

**Status:** PASS

**Comments:** Decision Table - TC2: Room Number = "Duplicate" (Y) → Cannot Insert Room (Bảng 22: Database Insert Decision, TC2)

---

### 14. TC_DI_05

**Description:** Verify insert and retrieve operation simple path

**Precondition:** System is running, database is accessible

**Test Steps:**
1. Insert new user with unique email
2. Query database by email
3. Verify data matches

**Test Data:** Insert user, then retrieve by email

**Expected Result:** Data inserted and retrieved correctly

**Actual Result:** Data inserted and retrieved correctly

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through insert and retrieve function

Test Summary

Module  Test Count  Status

1. Login/Logout  15  ALL PASS
2. Room Management  15  ALL PASS
3. Payment and Invoice  15  ALL PASS
4. Dashboard Layout  10  ALL PASS
5. Report Generation  10  ALL PASS
6. Database Integrity  5  ALL PASS
TOTAL  70  ALL PASS

Testing Techniques Used

Black Box Testing
Boundary Value Analysis: 15 tests
Equivalence Partitioning: 18 tests
Decision Table: 17 tests

White Box Testing
Basic Path Testing: 8 tests
Branch Testing: 12 tests

Total Test Cases: 70
All Tests Status: PASS

---

