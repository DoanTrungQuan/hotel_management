# Test Cases by Technique: Basic Path Testing

**Total Test Cases:** 17

- **Quan's Test Cases:** 8
- **Lam's Test Cases:** 9

---

## QUAN'S TEST CASES

### 1. TC_BM_15

**Description:** Verify add new room operation with all valid fields

**Precondition:** System is running, room management module is accessible, database connection available

**Test Steps:**
1. Open room management form
2. Enter all valid room details (number, type, bed, price, status)
3. Click save button

**Test Data:** roomNumber = "QTEST15", type = "AC", bed = "Single", price = 1500.00, status = "Not Booked"

**Expected Result:** Room added successfully to database

**Actual Result:** Room added successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through add room function

---

### 2. TC_BM_16

**Description:** Verify update room price operation

**Precondition:** System is running, room "QTEST16" exists in database

**Test Steps:**
1. Open room management form
2. Search for room "QTEST16"
3. Update price to 2000.00
4. Click save button

**Test Data:** roomNumber = "QTEST16", newPrice = 2000.00

**Expected Result:** Room price updated successfully

**Actual Result:** Room updated successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through update room function

---

### 3. TC_BM_17

**Description:** Verify delete room operation

**Precondition:** System is running, room "QTEST17" exists in database

**Test Steps:**
1. Open room management form
2. Search for room "QTEST17"
3. Click delete button
4. Confirm deletion

**Test Data:** roomNumber = "QTEST17"

**Expected Result:** Room deleted successfully from database

**Actual Result:** Room deleted successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through delete room function

---

### 4. TC_CM_14

**Description:** Verify customer check-in operation simple path

**Precondition:** System is running, room "QTEST34" exists and is available

**Test Steps:**
1. Open customer check-in form
2. Enter all valid customer fields
3. Select room "QTEST34"
4. Click save button

**Test Data:** New customer with all valid fields

**Expected Result:** Customer checked in successfully

**Actual Result:** Customer checked in successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through check-in function

---

### 5. TC_CM_15

**Description:** Verify bill calculation simple path

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter price = 1500.00
3. Enter days = 3
4. Calculate amount

**Test Data:** price = 1500.00, days = 3

**Expected Result:** Amount calculated as 4500.00

**Actual Result:** amount = 4500.00

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through calculation function

---

### 6. TC_AM_07

**Description:** Verify view all users operation simple path

**Precondition:** System is running, admin module is accessible, database connection available

**Test Steps:**
1. Open admin management form
2. Click refresh or load all users
3. Verify user list is displayed

**Test Data:** Query all users

**Expected Result:** All users are displayed with count

**Actual Result:** Returns count >= 0

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through view all users function

---

### 7. TC_AM_08

**Description:** Verify refresh user list operation simple path

**Precondition:** System is running, admin module is accessible, user list is displayed

**Test Steps:**
1. Open admin management form
2. User list is already displayed
3. Click refresh button
4. Verify updated list is displayed

**Test Data:** Refresh query

**Expected Result:** Updated user list is displayed

**Actual Result:** Returns updated count >= 0

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through refresh function

---

### 8. TC_AM_10

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

### 1. TC_LL_11

**Description:** Verify login simple path with all fields valid

**Precondition:** System is running, user exists with status "approved"

**Test Steps:**
1. Open login form
2. Enter email = "lamtest11@test.com"
3. Enter password = "pass123"
4. Click login button
5. Verify login success

**Test Data:** email = "lamtest11@test.com", password = "pass123", status = "approved"

**Expected Result:** User found and email matches

**Actual Result:** User found and email matches = true

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through login function

---

### 2. TC_RM_12

**Description:** Verify add new room operation simple path

**Precondition:** System is running, room management module is accessible, database connection available

**Test Steps:**
1. Open room management form
2. Enter all valid room details
3. Click save button

**Test Data:** New room with all valid fields

**Expected Result:** Room added successfully

**Actual Result:** Room added successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through add room function

---

### 3. TC_RM_13

**Description:** Verify update room price operation simple path

**Precondition:** System is running, room "LTEST28" exists in database

**Test Steps:**
1. Open room management form
2. Search for room "LTEST28"
3. Update price to 2000.00
4. Click save button

**Test Data:** roomNumber = "LTEST28", newPrice = 2000.00

**Expected Result:** Room price updated successfully

**Actual Result:** Room updated successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through update room function

---

### 4. TC_RM_14

**Description:** Verify delete room operation simple path

**Precondition:** System is running, room "LTEST29" exists in database

**Test Steps:**
1. Open room management form
2. Search for room "LTEST29"
3. Click delete button
4. Confirm deletion

**Test Data:** roomNumber = "LTEST29"

**Expected Result:** Room deleted successfully

**Actual Result:** Room deleted successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through delete room function

---

### 5. TC_PI_09

**Description:** Verify generate bill operation simple path

**Precondition:** System is running, bill generation module is accessible, customer data available

**Test Steps:**
1. Open bill generation form
2. Enter bill ID = "BILLLTEST39"
3. Generate bill

**Test Data:** billid = "BILLLTEST39"

**Expected Result:** Bill data exists in database

**Actual Result:** Bill data exists in database

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through generate bill function

---

### 6. TC_PI_15

**Description:** Verify invoice has all required fields

**Precondition:** System is running, invoice module is accessible, bill exists

**Test Steps:**
1. Open invoice form
2. Enter bill ID = "BILLLTEST45"
3. Generate invoice
4. Verify all fields present

**Test Data:** billid = "BILLLTEST45"

**Expected Result:** Invoice contains billid, name, amount, days

**Actual Result:** Invoice has billid, name, amount, days = true

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through invoice generation function

---

### 7. TC_RG_07

**Description:** Verify get bill data operation simple path

**Precondition:** System is running, bill "BILLLTEST62" exists in database

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLLTEST62"
3. Query database
4. Retrieve bill data

**Test Data:** billid = "BILLLTEST62"

**Expected Result:** Bill data retrieved successfully

**Actual Result:** Bill data retrieved successfully

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through get bill data function

---

### 8. TC_RG_08

**Description:** Verify list all checked out customers operation simple path

**Precondition:** System is running, report generation module is accessible, database connection available

**Test Steps:**
1. Open report generation form
2. Query all customers with status "check out"
3. Display results

**Test Data:** Query all customers with status = "check out"

**Expected Result:** List of checked out customers displayed

**Actual Result:** Returns count >= 0

**Status:** PASS

**Comments:** Basic Path Testing - Simple path through list function

---

### 9. TC_DI_05

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

