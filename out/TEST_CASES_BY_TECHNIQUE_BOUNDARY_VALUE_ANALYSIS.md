# Test Cases by Technique: Boundary Value Analysis

**Total Test Cases:** 27

- **Quan's Test Cases:** 11
- **Lam's Test Cases:** 16

---

## QUAN'S TEST CASES

### 1. TC_BM_01

**Description:** Verify room price validation with zero value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room price = 0.0
3. Attempt to save room

**Test Data:** price = 0.0

**Expected Result:** System rejects zero price, shows error message "Price must be greater than zero"

**Actual Result:** price <= 0 = true (invalid), error message shown

**Status:** PASS

**Comments:** Boundary Value Analysis - Price = -1 (below boundary, invalid), Price = 0 (boundary value, invalid), Price = 0.01 (above boundary, valid) (Bảng 1: Room Price)

---

### 2. TC_BM_02

**Description:** Verify room price validation with positive value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room price = 1500.00
3. Attempt to save room

**Test Data:** price = 1500.00

**Expected Result:** System accepts positive price

**Actual Result:** price > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Price = 1500.00 (valid - typical value within range) (Bảng 1: Room Price)

---

### 3. TC_BM_03

**Description:** Verify room price validation with minimum valid value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room price = 0.01
3. Attempt to save room

**Test Data:** price = 0.01

**Expected Result:** System accepts minimum valid price

**Actual Result:** price > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Price = 0 (boundary value, invalid), Price = 0.01 (just above boundary, valid) (Bảng 1: Room Price)

---

### 4. TC_BM_04

**Description:** Verify room number validation with empty value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Leave room number field empty
3. Attempt to save room

**Test Data:** roomNumber = ""

**Expected Result:** System rejects empty room number

**Actual Result:** roomNumber.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Room Number = "" (boundary value, invalid - empty string) (Bảng 4: Room Number)

---

### 5. TC_BM_05

**Description:** Verify room number validation with valid value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room number = "QTEST05"
3. Attempt to save room

**Test Data:** roomNumber = "QTEST05"

**Expected Result:** System accepts valid room number

**Actual Result:** !roomNumber.isEmpty() = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Room Number = "" (boundary value, invalid), Room Number = "QTEST05" (above boundary, valid - non-empty) (Bảng 4: Room Number)

---

### 6. TC_CM_01

**Description:** Verify mobile number validation with empty value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Leave mobile number field empty
3. Attempt to save customer

**Test Data:** mobile = ""

**Expected Result:** System rejects empty mobile number

**Actual Result:** mobile.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Mobile = "" (boundary value, invalid - empty string) (Bảng 2: Mobile Number)

---

### 7. TC_CM_02

**Description:** Verify mobile number validation with valid 10-digit value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Enter mobile number = "1234567890"
3. Attempt to save customer

**Test Data:** mobile = "1234567890" (10 digits)

**Expected Result:** System accepts valid 10-digit mobile number

**Actual Result:** mobile.length() == 10 = true

**Status:** PASS

**Comments:** Boundary Value Analysis - Mobile = "123456789" (below boundary, invalid - 9 digits), Mobile = "1234567890" (boundary value, valid - 10 digits), Mobile = "12345678901" (above boundary, invalid - 11 digits) (Bảng 2: Mobile Number)

---

### 8. TC_CM_03

**Description:** Verify aadhar number validation with valid 12-digit value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Enter aadhar number = "123456789012"
3. Attempt to save customer

**Test Data:** aadhar = "123456789012" (12 digits)

**Expected Result:** System accepts valid 12-digit aadhar number

**Actual Result:** aadhar.length() == 12 = true

**Status:** PASS

**Comments:** Boundary Value Analysis - Mobile = "123456789" (below boundary, invalid - 9 digits), Mobile = "1234567890" (boundary value, valid - 10 digits), Mobile = "12345678901" (above boundary, invalid - 11 digits) (Bảng 2: Mobile Number)

---

### 9. TC_CM_04

**Description:** Verify days stayed validation with zero value

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter days stayed = 0
3. Calculate bill amount

**Test Data:** days = 0

**Expected Result:** System converts zero days to 1 (minimum charge)

**Actual Result:** actualDays = 1 (minimum charge)

**Status:** PASS

**Comments:** Boundary Value Analysis - Days = -1 (below boundary, invalid), Days = 0 (boundary value, invalid), Days = 1 (above boundary, valid) (Bảng 3: Days Stayed)

---

### 10. TC_CM_05

**Description:** Verify days stayed validation with positive value

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter days stayed = 3
3. Calculate bill amount

**Test Data:** days = 3

**Expected Result:** System accepts positive days value

**Actual Result:** days > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Days = 364 (below boundary, valid), Days = 365 (boundary value, valid), Days = 366 (above boundary, invalid) (Bảng 3: Days Stayed)

---

### 11. TC_AM_10

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

### 1. TC_LL_01

**Description:** Verify email field validation with empty value

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Leave email field empty
3. Attempt to login

**Test Data:** email = ""

**Expected Result:** System rejects empty email

**Actual Result:** email.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Email = "" (boundary value, invalid - empty string) (Bảng 1: Email Field)

---

### 2. TC_LL_02

**Description:** Verify email field validation with valid email containing @ symbol

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Enter email = "test@example.com"
3. Attempt to login

**Test Data:** email = "test@example.com"

**Expected Result:** System accepts valid email with @ symbol

**Actual Result:** email.contains("@") = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Email = "" (boundary value, invalid), Email = "test@example.com" (above boundary, valid - contains @) (Bảng 1: Email Field)

---

### 3. TC_LL_03

**Description:** Verify password field validation with empty value

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Leave password field empty
3. Attempt to login

**Test Data:** password = ""

**Expected Result:** System rejects empty password

**Actual Result:** password.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Password = "" (boundary value, invalid - empty string) (Bảng 2: Password Field)

---

### 4. TC_LL_04

**Description:** Verify password field validation with valid password

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Enter password = "password123"
3. Attempt to login

**Test Data:** password = "password123"

**Expected Result:** System accepts valid non-empty password

**Actual Result:** !password.isEmpty() = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Password = "" (boundary value, invalid), Password = "password123" (above boundary, valid - non-empty) (Bảng 2: Password Field)

---

### 5. TC_LL_15

**Description:** Verify password length validation with minimum 1 character

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Enter password = "p" (1 character)
3. Verify password length

**Test Data:** password = "p" (1 character)

**Expected Result:** Password length is at least 1

**Actual Result:** password.length() >= 1 = true

**Status:** PASS

**Comments:** Boundary Value Analysis - Password = "" (below boundary, invalid), Password = "p" (boundary value, valid - 1 character), Password = "ab" (above boundary, valid - 2 characters) (Bảng 2: Password Field)

---

### 6. TC_RM_01

**Description:** Verify room price validation with zero value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room price = 0.0
3. Attempt to save room

**Test Data:** price = 0.0

**Expected Result:** System rejects zero price, shows error message "Price must be greater than zero"

**Actual Result:** price <= 0 = true (invalid), error message shown

**Status:** PASS

**Comments:** Boundary Value Analysis - Price = -1 (below boundary, invalid), Price = 0 (boundary value, invalid), Price = 0.01 (above boundary, valid) (Bảng 6: Room Price)

---

### 7. TC_RM_02

**Description:** Verify room price validation with positive value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room price = 1500.00
3. Attempt to save room

**Test Data:** price = 1500.00

**Expected Result:** System accepts positive price

**Actual Result:** price > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Price = 1500.00 (valid - typical value within range) (Bảng 6: Room Price)

---

### 8. TC_RM_03

**Description:** Verify room number validation with empty value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Leave room number field empty
3. Attempt to save room

**Test Data:** roomNumber = ""

**Expected Result:** System rejects empty room number

**Actual Result:** roomNumber.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Room Number = "" (boundary value, invalid - empty string) (Bảng 7: Room Number)

---

### 9. TC_RM_04

**Description:** Verify room number validation with valid value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room number = "LTEST19"
3. Attempt to save room

**Test Data:** roomNumber = "LTEST19"

**Expected Result:** System accepts valid room number

**Actual Result:** !roomNumber.isEmpty() = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Room Number = "" (boundary value, invalid), Room Number = "LTEST19" (above boundary, valid - non-empty) (Bảng 7: Room Number)

---

### 10. TC_PI_01

**Description:** Verify payment amount validation with zero value

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter amount = 0.0
3. Attempt to process payment

**Test Data:** amount = 0.0

**Expected Result:** System rejects zero amount (price validation ensures room price > 0, so calculated amount cannot be zero)

**Actual Result:** amount > 0 = false (invalid), amount rejected

**Status:** PASS

**Comments:** Boundary Value Analysis - Amount = -1 (below boundary, invalid), Amount = 0 (boundary value, invalid), Amount = 0.01 (above boundary, valid) (Bảng 11: Payment Amount). Note: Amount is calculated from price * days, and price validation ensures price > 0.

---

### 11. TC_PI_02

**Description:** Verify payment amount validation with positive value

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter amount = 4500.00
3. Attempt to process payment

**Test Data:** amount = 4500.00

**Expected Result:** System accepts positive amount

**Actual Result:** amount > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Amount = 4500.00 (valid - typical value within range) (Bảng 11: Payment Amount)

---

### 12. TC_PI_03

**Description:** Verify days stayed validation with zero value

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter days stayed = 0
3. Calculate bill amount

**Test Data:** days = 0

**Expected Result:** System converts zero days to 1 (minimum charge)

**Actual Result:** actualDays = 1 (minimum charge)

**Status:** PASS

**Comments:** Boundary Value Analysis - Days = -1 (below boundary, invalid), Days = 0 (boundary value, invalid), Days = 1 (above boundary, valid) (Bảng 12: Days Stayed)

---

### 13. TC_PI_04

**Description:** Verify days stayed validation with positive value

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter days stayed = 3
3. Calculate bill amount

**Test Data:** days = 3

**Expected Result:** System accepts positive days value

**Actual Result:** days > 0 = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Days = 364 (below boundary, valid), Days = 365 (boundary value, valid), Days = 366 (above boundary, invalid) (Bảng 12: Days Stayed)

---

### 14. TC_RG_01

**Description:** Verify bill ID validation with empty value

**Precondition:** System is running, report generation module is accessible

**Test Steps:**
1. Open report generation form
2. Leave bill ID field empty
3. Attempt to generate report

**Test Data:** billid = ""

**Expected Result:** System rejects empty bill ID

**Actual Result:** billid.isEmpty() = true (invalid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Bill ID = "" (boundary value, invalid - empty string) (Bảng 19: Bill ID)

---

### 15. TC_RG_02

**Description:** Verify bill ID validation with valid format

**Precondition:** System is running, report generation module is accessible

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILL123456789"
3. Attempt to generate report

**Test Data:** billid = "BILL123456789"

**Expected Result:** System accepts valid bill ID format

**Actual Result:** billid.startsWith("BILL") = true (valid)

**Status:** PASS

**Comments:** Boundary Value Analysis - Bill ID = "" (boundary value, invalid), Bill ID = "BILLLTEST62" (above boundary, valid - non-empty) (Bảng 19: Bill ID)

---

### 16. TC_DI_05

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

