# Test Cases by Technique: Equivalence Partitioning

**Total Test Cases:** 51

- **Quan's Test Cases:** 28
- **Lam's Test Cases:** 23

---

## QUAN'S TEST CASES

### 1. TC_BM_06

**Description:** Verify room type validation with AC value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select room type = "AC"
3. Attempt to save room

**Test Data:** roomType = "AC"

**Expected Result:** System accepts AC room type

**Actual Result:** roomType.equals("AC") = true

**Status:** PASS

**Comments:** Equivalence (Room Type, (1))

---

### 2. TC_BM_07

**Description:** Verify room type validation with NON AC value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select room type = "NON AC"
3. Attempt to save room

**Test Data:** roomType = "NON AC"

**Expected Result:** System accepts NON AC room type

**Actual Result:** roomType.equals("NON AC") = true

**Status:** PASS

**Comments:** Equivalence (Room Type, (2))

---

### 3. TC_BM_08

**Description:** Verify room type validation with invalid value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room type = "LUXURY"
3. Attempt to save room

**Test Data:** roomType = "LUXURY"

**Expected Result:** System rejects invalid room type

**Actual Result:** Valid type check = false

**Status:** PASS

**Comments:** Equivalence (Room Type, (3))

---

### 4. TC_BM_09

**Description:** Verify bed type validation with Single value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select bed type = "Single"
3. Attempt to save room

**Test Data:** bedType = "Single"

**Expected Result:** System accepts Single bed type

**Actual Result:** bedType.equals("Single") = true

**Status:** PASS

**Comments:** Equivalence (Bed Type, (1))

---

### 5. TC_BM_10

**Description:** Verify bed type validation with Double value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select bed type = "Double"
3. Attempt to save room

**Test Data:** bedType = "Double"

**Expected Result:** System accepts Double bed type

**Actual Result:** bedType.equals("Double") = true

**Status:** PASS

**Comments:** Equivalence (Bed Type, (2))

---

### 6. TC_BM_11

**Description:** Verify room status validation with Not Booked value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Set room status = "Not Booked"
3. Verify status

**Test Data:** status = "Not Booked"

**Expected Result:** System accepts Not Booked status

**Actual Result:** status.equals("Not Booked") = true

**Status:** PASS

**Comments:** Equivalence (Room Status, (1))

---

### 7. TC_BM_12

**Description:** Verify room status validation with Booked value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Set room status = "Booked"
3. Verify status

**Test Data:** status = "Booked"

**Expected Result:** System accepts Booked status

**Actual Result:** status.equals("Booked") = true

**Status:** PASS

**Comments:** Equivalence (Room Status, (2))

---

### 8. TC_CM_06

**Description:** Verify gender validation with Male value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Select gender = "Male"
3. Attempt to save customer

**Test Data:** gender = "Male"

**Expected Result:** System accepts Male gender

**Actual Result:** gender.equals("Male") = true

**Status:** PASS

**Comments:** Equivalence (Gender, (1))

---

### 9. TC_CM_07

**Description:** Verify gender validation with Female value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Select gender = "Female"
3. Attempt to save customer

**Test Data:** gender = "Female"

**Expected Result:** System accepts Female gender

**Actual Result:** gender.equals("Female") = true

**Status:** PASS

**Comments:** Equivalence (Gender, (2))

---

### 10. TC_CM_08

**Description:** Verify gender validation with Other value

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Select gender = "Other"
3. Attempt to save customer

**Test Data:** gender = "Other"

**Expected Result:** System accepts Other gender

**Actual Result:** gender.equals("Other") = true

**Status:** PASS

**Comments:** Equivalence (Gender, (3))

---

### 11. TC_CM_09

**Description:** Verify email validation with valid email containing @ symbol

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Enter email = "test@example.com"
3. Attempt to save customer

**Test Data:** email = "test@example.com"

**Expected Result:** System accepts valid email with @ symbol

**Actual Result:** email.contains("@") = true

**Status:** PASS

**Comments:** Equivalence (Email Validation, (1))

---

### 12. TC_CM_10

**Description:** Verify email validation with invalid email without @ symbol

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Open customer check-in form
2. Enter email = "invalidemail.com"
3. Attempt to save customer

**Test Data:** email = "invalidemail.com"

**Expected Result:** System rejects invalid email without @ symbol

**Actual Result:** email.contains("@") = false

**Status:** PASS

**Comments:** Equivalence (Email Validation, (2))

---

### 13. TC_CM_20

**Description:** Verify amount calculation with valid price and days

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Open customer checkout form
2. Enter price = 1500.00
3. Enter days = 4
4. Calculate amount

**Test Data:** price = 1500.00, days = 4

**Expected Result:** Amount calculated as 6000.00

**Actual Result:** amount = 6000.00 (price * days)

**Status:** PASS

**Comments:** Equivalence (Customer Checkout Decision, (1))

---

### 14. TC_NS_01

**Description:** Verify success message display for registration

**Precondition:** System is running, user registration module is accessible

**Test Steps:**
1. Complete user registration with valid data
2. Submit registration form
3. Check displayed message

**Test Data:** Registration successful

**Expected Result:** Success message contains "Successfully"

**Actual Result:** message contains "Successfully" = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (1))

---

### 15. TC_NS_02

**Description:** Verify success message display for check-in

**Precondition:** System is running, customer check-in module is accessible

**Test Steps:**
1. Complete customer check-in with valid data
2. Submit check-in form
3. Check displayed message

**Test Data:** Check-in successful

**Expected Result:** Success message "Room Alloted" displayed

**Actual Result:** Message "Room Alloted" displayed = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (1))

---

### 16. TC_NS_03

**Description:** Verify success message display for check-out

**Precondition:** System is running, customer checkout module is accessible

**Test Steps:**
1. Complete customer checkout with valid data
2. Submit checkout form
3. Check displayed message

**Test Data:** Check-out successful

**Expected Result:** Success message "Check out Successfully." displayed

**Actual Result:** Message "Check out Successfully." displayed = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (1))

---

### 17. TC_NS_04

**Description:** Verify error message display when record not found

**Precondition:** System is running, search functionality is accessible

**Test Steps:**
1. Search for non-existent record
2. Submit search
3. Check displayed message

**Test Data:** Record search failed

**Expected Result:** Error message "Record Not Found" displayed

**Actual Result:** Message "Record Not Found" displayed = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (2))

---

### 18. TC_NS_05

**Description:** Verify confirmation message display for logout

**Precondition:** System is running, user is logged in

**Test Steps:**
1. Click logout button
2. Check displayed confirmation message

**Test Data:** Logout button clicked

**Expected Result:** Confirmation message contains "?"

**Actual Result:** message contains "?" = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (3))

---

### 19. TC_NS_06

**Description:** Verify confirmation message display for exit

**Precondition:** System is running, application is open

**Test Steps:**
1. Click exit button
2. Check displayed confirmation message

**Test Data:** Exit button clicked

**Expected Result:** Confirmation message contains "?"

**Actual Result:** message contains "?" = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (3))

---

### 20. TC_NS_07

**Description:** Verify info message display for password reset

**Precondition:** System is running, password reset module is accessible

**Test Steps:**
1. Complete password reset with valid data
2. Submit reset form
3. Check displayed message

**Test Data:** Password reset successful

**Expected Result:** Info message contains "Reset"

**Actual Result:** message contains "Reset" = true

**Status:** PASS

**Comments:** Equivalence (Message Types, (3))

---

### 21. TC_DH_01

**Description:** Verify Manage Room button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Manage Room button
3. Verify button exists

**Test Data:** button = "ManageRoom"

**Expected Result:** Manage Room button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Button Click Decision, (1))

---

### 22. TC_DH_02

**Description:** Verify Customer Check In button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Check In button
3. Verify button exists

**Test Data:** button = "CustomerCheckIn"

**Expected Result:** Customer Check In button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Button Click Decision, (1))

---

### 23. TC_DH_03

**Description:** Verify Customer Check Out button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Check Out button
3. Verify button exists

**Test Data:** button = "CustomerCheckOut"

**Expected Result:** Customer Check Out button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Button Click Decision, (1))

---

### 24. TC_DH_04

**Description:** Verify Customer Details Bill button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Details Bill button
3. Verify button exists

**Test Data:** button = "CustomerDetailsBill"

**Expected Result:** Customer Details Bill button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Button Click Decision, (1))

---

### 25. TC_DH_10

**Description:** Verify all dashboard buttons exist

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Count all buttons
3. Verify 6 buttons exist

**Test Data:** All dashboard buttons

**Expected Result:** 6 buttons exist on dashboard

**Actual Result:** 6 buttons exist = true

**Status:** PASS

**Comments:** Equivalence (Button Click Decision, (1))

---

### 26. TC_AM_01

**Description:** Verify user status validation with pending value

**Precondition:** System is running, admin module is accessible, test user exists

**Test Steps:**
1. Open admin management form
2. Test sets status to "panding" for test61@test.com
3. Search for user "test61@test.com"
4. Check user status

**Test Data:** email = "test61@test.com", status initially "approved", test sets to "panding"

**Expected Result:** User status is "panding"

**Actual Result:** Status is "panding" = true

**Status:** PASS

**Comments:** Equivalence (User Status, (1)). Note: User starts as "approved", test sets status to "panding" before checking.

---

### 27. TC_AM_02

**Description:** Verify user status validation with approved value

**Precondition:** System is running, admin module is accessible, test user exists

**Test Steps:**
1. Open admin management form
2. Search for user "test62@test.com"
3. Check user status

**Test Data:** email = "test62@test.com", status = "approved"

**Expected Result:** User status is "approved"

**Actual Result:** Status is "approved" = true

**Status:** PASS

**Comments:** Equivalence (User Status, (2))

---

### 28. TC_AM_10

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

### 1. TC_LL_05

**Description:** Verify admin login with admin credentials

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Enter email = "admin"
3. Enter password = "admin"
4. Click login button

**Test Data:** email = "admin", password = "admin"

**Expected Result:** Admin login successful

**Actual Result:** isAdmin = true

**Status:** PASS

**Comments:** Equivalence (Admin Credentials, (1))

---

### 2. TC_LL_06

**Description:** Verify approved user can login

**Precondition:** System is running, user exists with status "approved"

**Test Steps:**
1. Open login form
2. Enter email = "lamtest06@test.com"
3. Enter password = "pass"
4. Click login button

**Test Data:** email = "lamtest06@test.com", password = "pass", status = "approved"

**Expected Result:** User login successful

**Actual Result:** User found in database = true

**Status:** PASS

**Comments:** Equivalence (User Status, (1))

---

### 3. TC_LL_07

**Description:** Verify pending user cannot login

**Precondition:** System is running, user exists
Note: User starts as "approved", test sets status to "panding" first

**Test Steps:**
1. Test sets status to "panding" for lamtest07@test.com
2. Open login form
3. Enter email = "lamtest07@test.com"
4. Enter password = "pass"
5. Click login button

**Test Data:** email = "lamtest07@test.com", password = "pass", status initially "approved", test sets to "panding"

**Expected Result:** User login denied

**Actual Result:** User found with status "approved" = false

**Status:** PASS

**Comments:** Equivalence (User Status, (2)). Note: User starts as "approved", test sets status to "panding" before checking.

---

### 4. TC_LL_08

**Description:** Verify wrong password cannot login

**Precondition:** System is running, user exists with correct password "correctpass"

**Test Steps:**
1. Open login form
2. Enter email = "lamtest08@test.com"
3. Enter password = "wrongpass"
4. Click login button

**Test Data:** email = "lamtest08@test.com", password = "wrongpass" (correct = "correctpass")

**Expected Result:** Login denied due to wrong password

**Actual Result:** User found = false

**Status:** PASS

**Comments:** Equivalence (Admin Credentials, (3))

---

### 5. TC_LL_14

**Description:** Verify email format validation with @ symbol

**Precondition:** System is running, login form is accessible

**Test Steps:**
1. Open login form
2. Enter email = "test@example.com"
3. Verify email format

**Test Data:** email = "test@example.com"

**Expected Result:** Email contains @ symbol

**Actual Result:** email.contains("@") = true

**Status:** PASS

**Comments:** Equivalence (Email Field, (2))

---

### 6. TC_RM_05

**Description:** Verify room type validation with AC value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select room type = "AC"
3. Attempt to save room

**Test Data:** roomType = "AC"

**Expected Result:** System accepts AC room type

**Actual Result:** roomType.equals("AC") = true

**Status:** PASS

**Comments:** Equivalence (Room Type, (1))

---

### 7. TC_RM_06

**Description:** Verify room type validation with NON AC value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select room type = "NON AC"
3. Attempt to save room

**Test Data:** roomType = "NON AC"

**Expected Result:** System accepts NON AC room type

**Actual Result:** roomType.equals("NON AC") = true

**Status:** PASS

**Comments:** Equivalence (Room Type, (2))

---

### 8. TC_RM_07

**Description:** Verify room type validation with invalid value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Enter room type = "LUXURY"
3. Attempt to save room

**Test Data:** roomType = "LUXURY"

**Expected Result:** System rejects invalid room type

**Actual Result:** Valid type check = false

**Status:** PASS

**Comments:** Equivalence (Room Type, (3))

---

### 9. TC_RM_08

**Description:** Verify bed type validation with Single value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select bed type = "Single"
3. Attempt to save room

**Test Data:** bedType = "Single"

**Expected Result:** System accepts Single bed type

**Actual Result:** bedType.equals("Single") = true

**Status:** PASS

**Comments:** Equivalence (Bed Type, (1))

---

### 10. TC_RM_09

**Description:** Verify bed type validation with Double value

**Precondition:** System is running, room management module is accessible

**Test Steps:**
1. Open room management form
2. Select bed type = "Double"
3. Attempt to save room

**Test Data:** bedType = "Double"

**Expected Result:** System accepts Double bed type

**Actual Result:** bedType.equals("Double") = true

**Status:** PASS

**Comments:** Equivalence (Bed Type, (2))

---

### 11. TC_PI_05

**Description:** Verify payment calculation with valid inputs

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter price = 1500.00
3. Enter days = 3
4. Calculate amount

**Test Data:** price = 1500.00, days = 3

**Expected Result:** Amount calculated as 4500.00

**Actual Result:** amount = 4500.00 (price * days)

**Status:** PASS

**Comments:** Equivalence (Payment Calculation, (1))

---

### 12. TC_PI_06

**Description:** Verify payment calculation with zero days

**Precondition:** System is running, payment module is accessible

**Test Steps:**
1. Open payment form
2. Enter price = 1500.00
3. Enter days = 0
4. Calculate amount

**Test Data:** price = 1500.00, days = 0

**Expected Result:** Amount calculated as 1500.00 (minimum charge)

**Actual Result:** amount = 1500.00 (minimum charge)

**Status:** PASS

**Comments:** Equivalence (Payment Calculation, (2))

---

### 13. TC_PI_14

**Description:** Verify bill ID format validation

**Precondition:** System is running, bill module is accessible

**Test Steps:**
1. Open bill form
2. Enter bill ID = "BILL123456789"
3. Verify bill ID format

**Test Data:** billid = "BILL123456789"

**Expected Result:** Bill ID starts with "BILL"

**Actual Result:** billid.startsWith("BILL") = true

**Status:** PASS

**Comments:** Equivalence (Bill ID Format, (1))

---

### 14. TC_DL_01

**Description:** Verify Manage Room button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Manage Room button
3. Verify button exists

**Test Data:** button = "ManageRoom"

**Expected Result:** Manage Room button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (1))

---

### 15. TC_DL_02

**Description:** Verify Customer Check In button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Check In button
3. Verify button exists

**Test Data:** button = "CustomerCheckIn"

**Expected Result:** Customer Check In button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (2))

---

### 16. TC_DL_03

**Description:** Verify Customer Check Out button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Check Out button
3. Verify button exists

**Test Data:** button = "CustomerCheckOut"

**Expected Result:** Customer Check Out button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (3))

---

### 17. TC_DL_04

**Description:** Verify Customer Details Bill button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Customer Details Bill button
3. Verify button exists

**Test Data:** button = "CustomerDetailsBill"

**Expected Result:** Customer Details Bill button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (4))

---

### 18. TC_DL_05

**Description:** Verify Logout button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Logout button
3. Verify button exists

**Test Data:** button = "Logout"

**Expected Result:** Logout button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (5))

---

### 19. TC_DL_06

**Description:** Verify Exit button exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for Exit button
3. Verify button exists

**Test Data:** button = "Exit"

**Expected Result:** Exit button exists on dashboard

**Actual Result:** Button exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Buttons, (6))

---

### 20. TC_DL_10

**Description:** Verify background image exists on dashboard

**Precondition:** System is running, user is logged in, dashboard is displayed

**Test Steps:**
1. Open dashboard/home page
2. Check for background image
3. Verify image exists

**Test Data:** background = "/image/home.jpg"

**Expected Result:** Background image exists

**Actual Result:** Background exists = true

**Status:** PASS

**Comments:** Equivalence (Dashboard Background, (1))

---

### 21. TC_RG_03

**Description:** Verify bill exists in database

**Precondition:** System is running, bill "BILLLTEST58" exists in database

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLLTEST58"
3. Query database

**Test Data:** billid = "BILLLTEST58"

**Expected Result:** Bill found in database

**Actual Result:** Bill found in database = true

**Status:** PASS

**Comments:** Equivalence (Bill Status, (1))

---

### 22. TC_RG_04

**Description:** Verify bill does not exist in database

**Precondition:** System is running, bill "BILLNONEXISTENT" does not exist

**Test Steps:**
1. Open report generation form
2. Enter bill ID = "BILLNONEXISTENT"
3. Query database

**Test Data:** billid = "BILLNONEXISTENT"

**Expected Result:** Bill not found

**Actual Result:** Bill not found = false

**Status:** PASS

**Comments:** Equivalence (Bill Status, (2))

---

### 23. TC_DI_05

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

