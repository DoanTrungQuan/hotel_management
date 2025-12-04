# Test Cases by Technique: Branch Testing

**Total Test Cases:** 25

- **Quan's Test Cases:** 13
- **Lam's Test Cases:** 12

---

## QUAN'S TEST CASES

### 1. TC_BM_18

**Description:** Verify room status branch when status is Not Booked

**Precondition:** System is running, room "QTEST18" exists with status "Not Booked"

**Test Steps:**
1. Query room "QTEST18" from database
2. Check room status
3. Verify status branch logic

**Test Data:** roomNumber = "QTEST18", status = "Not Booked"

**Expected Result:** Status branch for "Not Booked" is executed

**Actual Result:** Status is "Not Booked" = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If status == "Not Booked"

---

### 2. TC_BM_19

**Description:** Verify room status branch when status is Booked

**Precondition:** System is running, room "QTEST19" exists with status "Booked"

**Test Steps:**
1. Query room "QTEST19" from database
2. Check room status
3. Verify status branch logic

**Test Data:** roomNumber = "QTEST19", status = "Booked"

**Expected Result:** Status branch for "Booked" is executed

**Actual Result:** Status is "Booked" = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If status == "Booked"

---

### 3. TC_CM_16

**Description:** Verify customer status branch when status is NULL (checked in)

**Precondition:** System is running, customer is checked in with status "NULL"

**Test Steps:**
1. Query customer by room number "QTEST36"
2. Check customer status
3. Verify status branch logic

**Test Data:** Customer checked in, status = "NULL"

**Expected Result:** Status branch for "NULL" is executed

**Actual Result:** Status is "NULL" = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If status == "NULL"

---

### 4. TC_CM_17

**Description:** Verify customer status branch when status is check out

**Precondition:** System is running, customer is checked out

**Test Steps:**
1. Query customer by room number "QTEST37"
2. Check customer status
3. Verify status branch logic

**Test Data:** Customer checked out, status = "check out"

**Expected Result:** Status branch for "check out" is executed

**Actual Result:** Status is "check out" = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If status == "check out"

---

### 5. TC_CM_18

**Description:** Verify days validation branch when days is zero

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter days = 0
3. Calculate bill

**Test Data:** days = 0

**Expected Result:** Days branch converts zero to 1

**Actual Result:** actualDays = 1

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If days <= 0

---

### 6. TC_CM_19

**Description:** Verify days validation branch when days is positive

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter days = 5
3. Calculate bill

**Test Data:** days = 5

**Expected Result:** Days branch uses actual days value

**Actual Result:** days > 0 = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If days > 0

---

### 7. TC_NS_10

**Description:** Verify user confirmation branch when user confirms YES

**Precondition:** System is running, confirmation dialog is displayed

**Test Steps:**
1. Display confirmation dialog
2. User selects YES (0)
3. Check system response

**Test Data:** userChoice = 0 (YES)

**Expected Result:** Operation proceeds

**Actual Result:** Proceed with operation = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If userChoice == YES (0)

---

### 8. TC_DH_06

**Description:** Verify logout confirmation when user says YES

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select YES
4. Verify logout occurs

**Test Data:** choice = 0 (YES)

**Expected Result:** User is logged out

**Actual Result:** Should logout = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If user confirms YES

---

### 9. TC_DH_07

**Description:** Verify logout confirmation when user says NO

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select NO
4. Verify user stays logged in

**Test Data:** choice = 1 (NO)

**Expected Result:** User stays logged in

**Actual Result:** Should not logout = false

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If user confirms NO

---

### 10. TC_DH_08

**Description:** Verify exit confirmation when user says YES

**Precondition:** System is running, application is open

**Test Steps:**
1. Click exit button
2. Confirmation dialog appears
3. Select YES
4. Verify application exits

**Test Data:** choice = 0 (YES)

**Expected Result:** Application exits

**Actual Result:** Should exit = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If user confirms YES

---

### 11. TC_DH_09

**Description:** Verify exit confirmation when user says NO

**Precondition:** System is running, application is open

**Test Steps:**
1. Click exit button
2. Confirmation dialog appears
3. Select NO
4. Verify application stays open

**Test Data:** choice = 1 (NO)

**Expected Result:** Application stays open

**Actual Result:** Should not exit = false

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If user confirms NO

---

### 12. TC_AM_09

**Description:** Verify double click triggers status change dialog

**Precondition:** System is running, admin module is accessible, user list is displayed

**Test Steps:**
1. Open admin management form
2. User list is displayed
3. Double-click on any user row
4. Verify status change dialog appears

**Test Data:** clickCount = 2

**Expected Result:** Status change dialog is triggered

**Actual Result:** Status change dialog triggered = true

**Status:** PASS

**Comments:** Branch Testing - Branch: If clickCount == 2

---

### 13. TC_AM_10

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

### 1. TC_LL_12

**Description:** Verify logout confirmation when user confirms YES

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select YES (0)
4. Verify logout occurs

**Test Data:** userChoice = 0 (YES)

**Expected Result:** User is logged out

**Actual Result:** shouldLogout = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If userChoice == YES (0)

---

### 2. TC_LL_13

**Description:** Verify logout confirmation when user confirms NO

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select NO (1)
4. Verify user stays logged in

**Test Data:** userChoice = 1 (NO)

**Expected Result:** User stays logged in

**Actual Result:** shouldLogout = false

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If userChoice == NO (1)

---

### 3. TC_RM_15

**Description:** Verify room status branch when status is Not Booked

**Precondition:** System is running, room "LTEST30" exists with status "Not Booked"

**Test Steps:**
1. Query room "LTEST30" from database
2. Check room status
3. Verify status branch logic

**Test Data:** roomNumber = "LTEST30", status = "Not Booked"

**Expected Result:** Status branch for "Not Booked" is executed

**Actual Result:** Status is "Not Booked" = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If status == "Not Booked"

---

### 4. TC_PI_10

**Description:** Verify payment amount branch when amount is positive

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter amount = 5000.00
3. Verify amount branch logic

**Test Data:** amount = 5000.00

**Expected Result:** Positive amount branch is executed

**Actual Result:** Positive amount accepted = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If amount > 0

---

### 5. TC_PI_11

**Description:** Verify payment amount branch when amount is zero

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter amount = 0.0
3. Verify amount branch logic

**Test Data:** amount = 0.0

**Expected Result:** Zero amount branch is executed

**Actual Result:** Zero amount rejected = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If amount <= 0

---

### 6. TC_PI_12

**Description:** Verify days validation branch when days is positive

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter days = 5
3. Verify days branch logic

**Test Data:** days = 5

**Expected Result:** Positive days branch is executed

**Actual Result:** Positive days accepted = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If days > 0

---

### 7. TC_PI_13

**Description:** Verify days validation branch when days is zero

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter days = 0
3. Verify days branch logic

**Test Data:** days = 0

**Expected Result:** Zero days branch converts to 1

**Actual Result:** Zero days becomes 1 = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If days <= 0

---

### 8. TC_DL_08

**Description:** Verify logout confirmation when user says YES

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select YES
4. Verify logout occurs

**Test Data:** choice = 0 (YES)

**Expected Result:** User is logged out

**Actual Result:** Should logout = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If user confirms YES

---

### 9. TC_DL_09

**Description:** Verify logout confirmation when user says NO

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Confirmation dialog appears
3. Select NO
4. Verify user stays logged in

**Test Data:** choice = 1 (NO)

**Expected Result:** User stays logged in

**Actual Result:** Should not logout = false

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If user confirms NO

---

### 10. TC_RG_09

**Description:** Verify bill exists branch shows data

**Precondition:** System is running, bill "BILLLTEST64" exists in database

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLLTEST64"
3. Query database
4. Verify bill data is shown

**Test Data:** billid = "BILLLTEST64" (exists)

**Expected Result:** Bill data is displayed

**Actual Result:** Bill data shown = true

**Status:** PASS

**Comments:** Branch Testing - Branch 1: If bill exists

---

### 11. TC_RG_10

**Description:** Verify bill not exists branch shows error

**Precondition:** System is running, bill "BILLNONEXISTENT" does not exist

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLNONEXISTENT"
3. Query database
4. Verify error message is shown

**Test Data:** billid = "BILLNONEXISTENT" (not exists)

**Expected Result:** Error message is displayed

**Actual Result:** Error message shown = true

**Status:** PASS

**Comments:** Branch Testing - Branch 2: If bill not exists

---

### 12. TC_DI_05

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

