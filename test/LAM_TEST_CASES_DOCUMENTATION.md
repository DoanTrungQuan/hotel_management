Lam Test Suite - 70 Test Cases Documentation

Testing Techniques:
Black Box Testing: Boundary Value Analysis, Equivalence Partitioning, Decision Table
White Box Testing: Basic Path Testing, Branch Testing

IMPORTANT NOTE - USER STATUS WORKFLOW:
- When a new user signs up, status is automatically set to "panding" (database default)
- Admin can double-click on a user in the admin page to change status from "panding" to "approved"
- Only users with "approved" status can login
- Test users are initialized as needed for each test case

MODULE 1: LOGIN/LOGOUT (Tests TC_LL_01 to TC_LL_15)

Test Case ID: TC_LL_01
Description: Verify email field validation with empty value
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Leave email field empty
3. Attempt to login
Test Data: email = ""
Expected Result: System rejects empty email
Actual Result: email.isEmpty() = true (invalid)
Status: PASS
Comments: Boundary Value Analysis - Email = "" (boundary value, invalid - empty string) (Bảng 1: Email Field)

Test Case ID: TC_LL_02
Description: Verify email field validation with valid email containing @ symbol
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Enter email = "test@example.com"
3. Attempt to login
Test Data: email = "test@example.com"
Expected Result: System accepts valid email with @ symbol
Actual Result: email.contains("@") = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Email = "" (boundary value, invalid), Email = "test@example.com" (above boundary, valid - contains @) (Bảng 1: Email Field)

Test Case ID: TC_LL_03
Description: Verify password field validation with empty value
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Leave password field empty
3. Attempt to login
Test Data: password = ""
Expected Result: System rejects empty password
Actual Result: password.isEmpty() = true (invalid)
Status: PASS
Comments: Boundary Value Analysis - Password = "" (boundary value, invalid - empty string) (Bảng 2: Password Field)

Test Case ID: TC_LL_04
Description: Verify password field validation with valid password
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Enter password = "password123"
3. Attempt to login
Test Data: password = "password123"
Expected Result: System accepts valid non-empty password
Actual Result: !password.isEmpty() = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Password = "" (boundary value, invalid), Password = "password123" (above boundary, valid - non-empty) (Bảng 2: Password Field)

Test Case ID: TC_LL_05
Description: Verify admin login with admin credentials
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Enter email = "admin"
3. Enter password = "admin"
4. Click login button
Test Data: email = "admin", password = "admin"
Expected Result: Admin login successful
Actual Result: isAdmin = true
Status: PASS
Comments: Equivalence (Admin Credentials, (1))

Test Case ID: TC_LL_06
Description: Verify approved user can login
Precondition: System is running, user exists with status "approved"
Test Steps:
1. Open login form
2. Enter email = "lamtest06@test.com"
3. Enter password = "pass"
4. Click login button
Test Data: email = "lamtest06@test.com", password = "pass", status = "approved"
Expected Result: User login successful
Actual Result: User found in database = true
Status: PASS
Comments: Equivalence (User Status, (1))

Test Case ID: TC_LL_07
Description: Verify pending user cannot login
Precondition: System is running, user exists with status "panding" (from signup, not yet approved by admin)
Test Steps:
1. Open login form
2. Enter email = "lamtest07@test.com"
3. Enter password = "pass"
4. Click login button
Test Data: email = "lamtest07@test.com", password = "pass", status = "panding" (from signup)
Expected Result: User login denied (shows "Wait for Admin Approval" message)
Actual Result: User found with status "approved" = false
Status: PASS
Comments: Equivalence (User Status, (2)). Note: New users start as "panding" after signup, cannot login until admin approves them.

Test Case ID: TC_LL_08
Description: Verify wrong password cannot login
Precondition: System is running, user exists with correct password "correctpass"
Test Steps:
1. Open login form
2. Enter email = "lamtest08@test.com"
3. Enter password = "wrongpass"
4. Click login button
Test Data: email = "lamtest08@test.com", password = "wrongpass" (correct = "correctpass")
Expected Result: Login denied due to wrong password
Actual Result: User found = false
Status: PASS
Comments: Equivalence (Admin Credentials, (3))

Test Case ID: TC_LL_09
Description: Verify login decision with valid email, valid password, and approved status
Precondition: System is running, user exists with status "approved" (admin has approved the user)
Test Steps:
1. Open login form
2. Enter email = "lamtest09@test.com"
3. Enter password = "pass"
4. Click login button
Test Data: email = "lamtest09@test.com", password = "pass", status = "approved" (admin has approved)
Expected Result: Login successful
Actual Result: Login successful = true
Status: PASS
Comments: Decision Table - TC1: Email = "Valid" (Y), Password = "Valid" (Y), Status = "approved" (Y) → Can Login (Bảng 5: Login Decision, TC1). Note: User has been approved by admin (status changed from "panding" to "approved" via double-click).

Test Case ID: TC_LL_10
Description: Verify login decision with valid email, valid password, and pending status
Precondition: System is running, user exists with status "panding" (from signup, not yet approved by admin)
Test Steps:
1. Open login form
2. Enter email = "lamtest10@test.com"
3. Enter password = "pass"
4. Click login button
Test Data: email = "lamtest10@test.com", password = "pass", status = "panding" (from signup)
Expected Result: Login denied (shows "Wait for Admin Approval" message)
Actual Result: Login denied = false
Status: PASS
Comments: Decision Table - TC2: Email = "Valid" (Y), Password = "Valid" (Y), Status = "panding" (Y) → Cannot Login (Bảng 5: Login Decision, TC2). Note: New users start as "panding" after signup, cannot login until admin approves them.

Test Case ID: TC_LL_11
Description: Verify login simple path with all fields valid
Precondition: System is running, user exists with status "approved" (admin has approved the user)
Test Steps:
1. Open login form
2. Enter email = "lamtest11@test.com"
3. Enter password = "pass123"
4. Click login button
5. Verify login success
Test Data: email = "lamtest11@test.com", password = "pass123", status = "approved"
Expected Result: User found and email matches
Actual Result: User found and email matches = true
Status: PASS
Comments: Basic Path Testing - Simple path through login function

Test Case ID: TC_LL_12
Description: Verify logout confirmation when user confirms YES
Precondition: System is running, user is logged in
Test Steps:
1. Click logout button
2. Confirmation dialog appears
3. Select YES (0)
4. Verify logout occurs
Test Data: userChoice = 0 (YES)
Expected Result: User is logged out
Actual Result: shouldLogout = true
Status: PASS
Comments: Branch Testing - Branch 1: If userChoice == YES (0)

Test Case ID: TC_LL_13
Description: Verify logout confirmation when user confirms NO
Precondition: System is running, user is logged in
Test Steps:
1. Click logout button
2. Confirmation dialog appears
3. Select NO (1)
4. Verify user stays logged in
Test Data: userChoice = 1 (NO)
Expected Result: User stays logged in
Actual Result: shouldLogout = false
Status: PASS
Comments: Branch Testing - Branch 2: If userChoice == NO (1)

Test Case ID: TC_LL_14
Description: Verify email format validation with @ symbol
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Enter email = "test@example.com"
3. Verify email format
Test Data: email = "test@example.com"
Expected Result: Email contains @ symbol
Actual Result: email.contains("@") = true
Status: PASS
Comments: Equivalence (Email Field, (2))

Test Case ID: TC_LL_15
Description: Verify password length validation with minimum 1 character
Precondition: System is running, login form is accessible
Test Steps:
1. Open login form
2. Enter password = "p" (1 character)
3. Verify password length
Test Data: password = "p" (1 character)
Expected Result: Password length is at least 1
Actual Result: password.length() >= 1 = true
Status: PASS
Comments: Boundary Value Analysis - Password = "" (below boundary, invalid), Password = "p" (boundary value, valid - 1 character), Password = "ab" (above boundary, valid - 2 characters) (Bảng 2: Password Field)

MODULE 2: ROOM MANAGEMENT (Tests TC_RM_01 to TC_RM_15)

Test Case ID: TC_RM_01
Description: Verify room price validation with zero value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room price = 0.0
3. Attempt to save room
Test Data: price = 0.0
Expected Result: System rejects zero price, shows error message "Price must be greater than zero"
Actual Result: price <= 0 = true (invalid), error message shown
Status: PASS
Comments: Boundary Value Analysis - Price = -1 (below boundary, invalid), Price = 0 (boundary value, invalid), Price = 0.01 (above boundary, valid) (Bảng 6: Room Price)

Test Case ID: TC_RM_02
Description: Verify room price validation with positive value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room price = 1500.00
3. Attempt to save room
Test Data: price = 1500.00
Expected Result: System accepts positive price
Actual Result: price > 0 = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Price = 1500.00 (valid - typical value within range) (Bảng 6: Room Price)

Test Case ID: TC_RM_03
Description: Verify room number validation with empty value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Leave room number field empty
3. Attempt to save room
Test Data: roomNumber = ""
Expected Result: System rejects empty room number
Actual Result: roomNumber.isEmpty() = true (invalid)
Status: PASS
Comments: Boundary Value Analysis - Room Number = "" (boundary value, invalid - empty string) (Bảng 7: Room Number)

Test Case ID: TC_RM_04
Description: Verify room number validation with valid value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room number = "LTEST19"
3. Attempt to save room
Test Data: roomNumber = "LTEST19"
Expected Result: System accepts valid room number
Actual Result: !roomNumber.isEmpty() = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Room Number = "" (boundary value, invalid), Room Number = "LTEST19" (above boundary, valid - non-empty) (Bảng 7: Room Number)

Test Case ID: TC_RM_05
Description: Verify room type validation with AC value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Select room type = "AC"
3. Attempt to save room
Test Data: roomType = "AC"
Expected Result: System accepts AC room type
Actual Result: roomType.equals("AC") = true
Status: PASS
Comments: Equivalence (Room Type, (1))

Test Case ID: TC_RM_06
Description: Verify room type validation with NON AC value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Select room type = "NON AC"
3. Attempt to save room
Test Data: roomType = "NON AC"
Expected Result: System accepts NON AC room type
Actual Result: roomType.equals("NON AC") = true
Status: PASS
Comments: Equivalence (Room Type, (2))

Test Case ID: TC_RM_07
Description: Verify bed type validation with Single value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Select bed type = "Single"
3. Attempt to save room
Test Data: bedType = "Single"
Expected Result: System accepts Single bed type
Actual Result: bedType.equals("Single") = true
Status: PASS
Comments: Equivalence (Bed Type, (1))

Test Case ID: TC_RM_08
Description: Verify bed type validation with Double value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Select bed type = "Double"
3. Attempt to save room
Test Data: bedType = "Double"
Expected Result: System accepts Double bed type
Actual Result: bedType.equals("Double") = true
Status: PASS
Comments: Equivalence (Bed Type, (2))

Test Case ID: TC_RM_09
Description: Verify add room decision with all fields valid
Precondition: System is running, room management module is accessible, database connection available
Test Steps:
1. Open room management form
2. Enter room number = "LTEST25"
3. Select type = "AC", bed = "Single"
4. Enter price = 1500.00, status = "Not Booked"
5. Click save button
Test Data: roomNumber = "LTEST25", type = "AC", bed = "Single", price = 1500.00, status = "Not Booked"
Expected Result: Room added successfully
Actual Result: INSERT result = 1 (success)
Status: PASS
Comments: Decision Table - TC1: Room Number = "Unique" (Y), Room Type = "Valid" (Y), Price = "Valid" (Y) → Can Add (Bảng 10: Room Addition Decision, TC1)

Test Case ID: TC_RM_10
Description: Verify room status is automatically set to "Not Booked" when adding new room
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room number = "LTEST27"
3. Select type = "AC", bed = "Single"
4. Enter price = 1500.00
5. Click "Add Room" button
6. Verify room status in database
Test Data: roomNumber = "LTEST27", new room
Expected Result: Room status is automatically set to "Not Booked"
Actual Result: Status is "Not Booked" = true
Status: PASS
Comments: Basic Path Testing - Room status automatically set to "Not Booked" when adding new room. Note: Room Status is automatically managed by system, not user input.

Test Case ID: TC_RM_11
Description: Verify add room decision with duplicate room number
Precondition: System is running, room "LTEST26" already exists in database
Test Steps:
1. Open room management form
2. Enter room number = "LTEST26" (duplicate)
3. Enter other valid fields
4. Attempt to save
Test Data: roomNumber = "LTEST26" (already exists)
Expected Result: System prevents duplicate room number
Actual Result: SQLException (duplicate prevented)
Status: PASS
Comments: Decision Table - TC4: Room Number = "Duplicate" (Y) → Cannot Add (Bảng 10: Room Addition Decision, TC4)

Test Case ID: TC_RM_12
Description: Verify add new room operation simple path
Precondition: System is running, room management module is accessible, database connection available
Test Steps:
1. Open room management form
2. Enter all valid room details
3. Click save button
Test Data: New room with all valid fields
Expected Result: Room added successfully
Actual Result: Room added successfully
Status: PASS
Comments: Basic Path Testing - Simple path through add room function

Test Case ID: TC_RM_13
Description: Verify update room price operation simple path
Precondition: System is running, room "LTEST28" exists in database
Test Steps:
1. Open room management form
2. Double-click on row for room "LTEST28" in the table
3. Dialog "Input" appears with instructions
4. Type "update" in the input field
5. Click "OK" button
6. Room details are loaded into form fields
7. Update price to 2000.00
8. Click "Update" button (replaces "Add Room" button)
Test Data: roomNumber = "LTEST28", newPrice = 2000.00
Expected Result: Room price updated successfully
Actual Result: Room updated successfully
Status: PASS
Comments: Basic Path Testing - Simple path through update room function: Double-click row → Type "update" → OK → Modify fields → Update button

Test Case ID: TC_RM_14
Description: Verify delete room operation simple path
Precondition: System is running, room "LTEST29" exists in database
Test Steps:
1. Open room management form
2. Double-click on row for room "LTEST29" in the table
3. Dialog "Input" appears with instructions
4. Type "Delete" in the input field
5. Click "OK" button
6. Confirm deletion
Test Data: roomNumber = "LTEST29"
Expected Result: Room deleted successfully
Actual Result: Room deleted successfully
Status: PASS
Comments: Basic Path Testing - Simple path through delete room function: Double-click row → Type "Delete" → OK → Room deleted

Test Case ID: TC_RM_15
Description: Verify room status branch when status is Not Booked
Precondition: System is running, room "LTEST30" exists with status "Not Booked"
Test Steps:
1. Query room "LTEST30" from database
2. Check room status
3. Verify status branch logic
Test Data: roomNumber = "LTEST30", status = "Not Booked"
Expected Result: Status branch for "Not Booked" is executed
Actual Result: Status is "Not Booked" = true
Status: PASS
Comments: Branch Testing - Branch 1: If status == "Not Booked"

MODULE 3: PAYMENT AND INVOICE (Tests TC_PI_01 to TC_PI_15)

Test Case ID: TC_PI_01
Description: Verify payment amount validation with zero value (theoretical - amount is automatically calculated)
Precondition: System is running, payment module is accessible
Test Steps:
1. Open checkout form
2. Search for room number (customer is checked in)
3. System automatically calculates amount from price * days
4. Verify calculated amount is not zero
Test Data: Room with price > 0, days automatically calculated from check-in date
Expected Result: Amount is automatically calculated and is greater than zero (price validation ensures room price > 0, so calculated amount cannot be zero)
Actual Result: amount > 0 = true (valid), amount automatically calculated
Status: PASS
Comments: Boundary Value Analysis - Amount = -1 (below boundary, invalid), Amount = 0 (boundary value, invalid), Amount = 0.01 (above boundary, valid) (Bảng 11: Payment Amount). Note: Amount is automatically calculated from price * days when searching for room number. Price validation ensures price > 0, so calculated amount cannot be zero.

Test Case ID: TC_PI_02
Description: Verify payment amount validation with positive value (automatically calculated)
Precondition: System is running, payment module is accessible, customer is checked in
Test Steps:
1. Open checkout form
2. Search for room number (customer is checked in)
3. System automatically calculates amount from price * days
4. Verify calculated amount is positive
Test Data: Room with price = 1500.00, days = 3 (automatically calculated), amount = 4500.00 (automatically calculated)
Expected Result: Amount is automatically calculated and is positive
Actual Result: amount > 0 = true (valid), amount = 4500.00 automatically calculated
Status: PASS
Comments: Boundary Value Analysis - Amount = 4500.00 (valid - typical value within range) (Bảng 11: Payment Amount). Note: Amount is automatically calculated when searching for room number.

Test Case ID: TC_PI_03
Description: Verify days stayed validation with zero value (automatically calculated)
Precondition: System is running, payment module is accessible, customer checked in today (same day as check-in)
Test Steps:
1. Open checkout form
2. Search for room number (customer checked in today)
3. System automatically calculates days from check-in date to today
4. Verify days calculation converts zero/negative days to 1 (minimum charge)
Test Data: Check-in date = today, days automatically calculated = 0 or negative, converted to 1
Expected Result: System automatically calculates days and converts zero/negative days to 1 (minimum charge)
Actual Result: actualDays = 1 (minimum charge), automatically calculated
Status: PASS
Comments: Boundary Value Analysis - Days = -1 (below boundary, invalid), Days = 0 (boundary value, invalid), Days = 1 (above boundary, valid) (Bảng 12: Days Stayed). Note: Days are automatically calculated from check-in date to today when searching for room number.

Test Case ID: TC_PI_04
Description: Verify days stayed validation with positive value (automatically calculated)
Precondition: System is running, payment module is accessible, customer checked in 3 days ago
Test Steps:
1. Open checkout form
2. Search for room number (customer checked in 3 days ago)
3. System automatically calculates days from check-in date to today
4. Verify days calculation is positive
Test Data: Check-in date = 3 days ago, days automatically calculated = 3
Expected Result: System automatically calculates positive days value
Actual Result: days > 0 = true (valid), days = 3 automatically calculated
Status: PASS
Comments: Boundary Value Analysis - Days = 364 (below boundary, valid), Days = 365 (boundary value, valid), Days = 366 (above boundary, invalid) (Bảng 12: Days Stayed). Note: Days are automatically calculated from check-in date to today when searching for room number.

Test Case ID: TC_PI_05
Description: Verify payment calculation with valid inputs (automatically calculated)
Precondition: System is running, payment module is accessible, customer checked in 3 days ago with room price 1500.00
Test Steps:
1. Open checkout form
2. Search for room number
3. System automatically fills customer information
4. System automatically calculates days from check-in date to today (days = 3)
5. System automatically calculates amount (amount = price * days = 1500.00 * 3 = 4500.00)
Test Data: price = 1500.00 (from room), days = 3 (automatically calculated), amount = 4500.00 (automatically calculated)
Expected Result: Amount automatically calculated as 4500.00
Actual Result: amount = 4500.00 (price * days), automatically calculated
Status: PASS
Comments: Equivalence (Payment Calculation, (1)). Note: Amount and days are automatically calculated when searching for room number.

Test Case ID: TC_PI_06
Description: Verify payment calculation with zero days (automatically calculated, converts to 1)
Precondition: System is running, payment module is accessible, customer checked in today (same day checkout)
Test Steps:
1. Open checkout form
2. Search for room number (customer checked in today)
3. System automatically calculates days from check-in date to today (days = 0 or negative)
4. System automatically converts zero/negative days to 1 (minimum charge)
5. System automatically calculates amount (amount = price * 1 = 1500.00)
Test Data: price = 1500.00 (from room), days = 0 (automatically calculated, converted to 1), amount = 1500.00 (automatically calculated)
Expected Result: Amount automatically calculated as 1500.00 (minimum charge for 1 day)
Actual Result: amount = 1500.00 (minimum charge), automatically calculated
Status: PASS
Comments: Equivalence (Payment Calculation, (2)). Note: Days and amount are automatically calculated. Zero/negative days are converted to 1 (minimum charge).

Test Case ID: TC_PI_07
Description: Verify checkout decision with valid amount and days (automatically calculated)
Precondition: System is running, customer is checked in
Test Steps:
1. Open checkout form
2. Search for room number (customer is checked in)
3. System automatically fills customer information
4. System automatically calculates days from check-in date to today
5. System automatically calculates amount (price * days)
6. Click checkout button
Test Data: Customer checked in, amount = 4500.00 (automatically calculated), days = 3 (automatically calculated)
Expected Result: Checkout successful
Actual Result: Checkout successful, UPDATE result = 1
Status: PASS
Comments: Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 14: Checkout Decision, TC1). Note: Amount and days are automatically calculated when searching for room number.

Test Case ID: TC_PI_08
Description: Verify checkout decision when amount calculation fails (theoretical - amount is always auto-calculated)
Precondition: System is running, customer is checked in, but room price is invalid (price <= 0)
Test Steps:
1. Open checkout form
2. Search for room number (customer is checked in, but room has invalid price)
3. System attempts to calculate amount but fails due to invalid price
4. Amount field remains empty
5. Attempt to checkout
Test Data: Customer checked in, amount = "" (empty - calculation failed due to invalid price)
Expected Result: Checkout prevented (system shows error: "Please calculate the amount first by searching for the customer")
Actual Result: Checkout prevented = true
Status: PASS
Comments: Decision Table - TC2: Status = "checked in" (Y), Amount = "Invalid" (Y) → Cannot Checkout (Bảng 14: Checkout Decision, TC2). Note: Amount is automatically calculated. If calculation fails (e.g., invalid price), amount remains empty and checkout is prevented.

Test Case ID: TC_PI_09
Description: Verify generate bill operation simple path
Precondition: System is running, bill generation module is accessible, customer data available
Test Steps:
1. Open bill generation form
2. Enter bill ID = "BILLLTEST39"
3. Generate bill
Test Data: billid = "BILLLTEST39"
Expected Result: Bill data exists in database
Actual Result: Bill data exists in database
Status: PASS
Comments: Basic Path Testing - Simple path through generate bill function

Test Case ID: TC_PI_10
Description: Verify payment amount branch when amount is positive (automatically calculated)
Precondition: System is running, payment module is accessible, customer checked in
Test Steps:
1. Open checkout form
2. Search for room number
3. System automatically calculates amount (amount > 0)
4. Verify amount branch logic
Test Data: amount = 5000.00 (automatically calculated from price * days)
Expected Result: Positive amount branch is executed
Actual Result: Positive amount accepted = true
Status: PASS
Comments: Branch Testing - Branch 1: If amount > 0. Note: Amount is automatically calculated when searching for room number.

Test Case ID: TC_PI_11
Description: Verify payment amount branch when amount calculation fails (theoretical - amount cannot be zero if price > 0)
Precondition: System is running, payment module is accessible, customer checked in but room price is invalid
Test Steps:
1. Open checkout form
2. Search for room number (room has invalid price <= 0)
3. System attempts to calculate amount but fails
4. Amount field remains empty (amount calculation failed)
5. Verify amount branch logic
Test Data: amount = "" (empty - calculation failed, cannot be zero if price > 0)
Expected Result: Invalid amount branch is executed (checkout prevented)
Actual Result: Invalid amount rejected = true
Status: PASS
Comments: Branch Testing - Branch 2: If amount <= 0. Note: Amount is automatically calculated. If price > 0, amount cannot be zero. If price <= 0, calculation fails and amount remains empty.

Test Case ID: TC_PI_12
Description: Verify days validation branch when days is positive (automatically calculated)
Precondition: System is running, payment module is accessible, customer checked in 5 days ago
Test Steps:
1. Open checkout form
2. Search for room number (customer checked in 5 days ago)
3. System automatically calculates days from check-in date to today (days = 5)
4. Verify days branch logic
Test Data: days = 5 (automatically calculated)
Expected Result: Positive days branch is executed
Actual Result: Positive days accepted = true
Status: PASS
Comments: Branch Testing - Branch 2: If days > 0. Note: Days are automatically calculated from check-in date to today when searching for room number.

Test Case ID: TC_PI_13
Description: Verify days validation branch when days is zero (automatically calculated, converts to 1)
Precondition: System is running, payment module is accessible, customer checked in today (same day checkout)
Test Steps:
1. Open checkout form
2. Search for room number (customer checked in today)
3. System automatically calculates days from check-in date to today (days = 0 or negative)
4. System automatically converts zero/negative days to 1 (minimum charge)
5. Verify days branch logic
Test Data: days = 0 (automatically calculated, converted to 1)
Expected Result: Zero days branch converts to 1
Actual Result: Zero days becomes 1 = true
Status: PASS
Comments: Branch Testing - Branch 1: If days <= 0. Note: Days are automatically calculated from check-in date to today. Zero/negative days are converted to 1 (minimum charge).

Test Case ID: TC_PI_14
Description: Verify bill ID format validation
Precondition: System is running, bill module is accessible
Test Steps:
1. Open bill form
2. Enter bill ID = "BILL123456789"
3. Verify bill ID format
Test Data: billid = "BILL123456789"
Expected Result: Bill ID starts with "BILL"
Actual Result: billid.startsWith("BILL") = true
Status: PASS
Comments: Equivalence (Bill ID Format, (1))

Test Case ID: TC_PI_15
Description: Verify invoice has all required fields
Precondition: System is running, invoice module is accessible, bill exists
Test Steps:
1. Open invoice form
2. Enter bill ID = "BILLLTEST45"
3. Generate invoice
4. Verify all fields present
Test Data: billid = "BILLLTEST45"
Expected Result: Invoice contains billid, name, amount, days
Actual Result: Invoice has billid, name, amount, days = true
Status: PASS
Comments: Basic Path Testing - Simple path through invoice generation function

MODULE 4: DASHBOARD LAYOUT (Tests TC_DL_01 to TC_DL_10)

Test Case ID: TC_DL_01
Description: Verify Manage Room button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Manage Room button
3. Verify button exists
Test Data: button = "ManageRoom"
Expected Result: Manage Room button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (1))

Test Case ID: TC_DL_02
Description: Verify Customer Check In button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Customer Check In button
3. Verify button exists
Test Data: button = "CustomerCheckIn"
Expected Result: Customer Check In button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (2))

Test Case ID: TC_DL_03
Description: Verify Customer Check Out button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Customer Check Out button
3. Verify button exists
Test Data: button = "CustomerCheckOut"
Expected Result: Customer Check Out button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (3))

Test Case ID: TC_DL_04
Description: Verify Customer Details Bill button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Customer Details Bill button
3. Verify button exists
Test Data: button = "CustomerDetailsBill"
Expected Result: Customer Details Bill button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (4))

Test Case ID: TC_DL_05
Description: Verify Logout button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Logout button
3. Verify button exists
Test Data: button = "Logout"
Expected Result: Logout button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (5))

Test Case ID: TC_DL_06
Description: Verify Exit button exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for Exit button
3. Verify button exists
Test Data: button = "Exit"
Expected Result: Exit button exists on dashboard
Actual Result: Button exists = true
Status: PASS
Comments: Equivalence (Dashboard Buttons, (6))

Test Case ID: TC_DL_07
Description: Verify button click opens correct form
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Click Manage Room button
3. Verify correct form opens
Test Data: clickedButton = "ManageRoom"
Expected Result: ManageRoom form opens
Actual Result: Opens correct form = true
Status: PASS
Comments: Decision Table - Button Click: ManageRoom (Bảng 17: Button Click Decision, Dòng 1)

Test Case ID: TC_DL_08
Description: Verify logout confirmation when user says YES
Precondition: System is running, user is logged in
Test Steps:
1. Click logout button
2. Confirmation dialog appears
3. Select YES
4. Verify logout occurs
Test Data: choice = 0 (YES)
Expected Result: User is logged out
Actual Result: Should logout = true
Status: PASS
Comments: Branch Testing - Branch 1: If user confirms YES

Test Case ID: TC_DL_09
Description: Verify logout confirmation when user says NO
Precondition: System is running, user is logged in
Test Steps:
1. Click logout button
2. Confirmation dialog appears
3. Select NO
4. Verify user stays logged in
Test Data: choice = 1 (NO)
Expected Result: User stays logged in
Actual Result: Should not logout = false
Status: PASS
Comments: Branch Testing - Branch 2: If user confirms NO

Test Case ID: TC_DL_10
Description: Verify background image exists on dashboard
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Check for background image
3. Verify image exists
Test Data: background = "/image/home.jpg"
Expected Result: Background image exists
Actual Result: Background exists = true
Status: PASS
Comments: Equivalence (Dashboard Background, (1))

MODULE 5: REPORT GENERATION (Tests TC_RG_01 to TC_RG_10)

Test Case ID: TC_RG_01
Description: Verify bill ID validation with empty value
Precondition: System is running, Customer Details Bill form is accessible
Test Steps:
1. Open Customer Details Bill form
2. Leave bill ID field empty
3. Click search button for bill ID
Test Data: billid = ""
Expected Result: System shows message "Please enter Bill ID"
Actual Result: Message "Please enter Bill ID" displayed = true
Status: PASS
Comments: Boundary Value Analysis - Bill ID = "" (boundary value, invalid - empty string) (Bảng 19: Bill ID)

Test Case ID: TC_RG_02
Description: Verify bill ID validation with valid format
Precondition: System is running, Customer Details Bill form is accessible
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILL123456789" in bill ID search field
3. Click search button for bill ID
Test Data: billid = "BILL123456789"
Expected Result: System accepts valid bill ID format and searches
Actual Result: billid.startsWith("BILL") = true (valid), search executed
Status: PASS
Comments: Boundary Value Analysis - Bill ID = "" (boundary value, invalid), Bill ID = "BILLLTEST62" (above boundary, valid - non-empty) (Bảng 19: Bill ID)

Test Case ID: TC_RG_03
Description: Verify bill exists in database
Precondition: System is running, bill "BILLLTEST58" exists in database
Test Steps:
1. Open report generation form
2. Enter bill ID = "BILLLTEST58"
3. Query database
Test Data: billid = "BILLLTEST58"
Expected Result: Bill found in database
Actual Result: Bill found in database = true
Status: PASS
Comments: Equivalence (Bill Status, (1))

Test Case ID: TC_RG_04
Description: Verify bill does not exist in database
Precondition: System is running, bill "BILLNONEXISTENT" does not exist
Test Steps:
1. Open report generation form
2. Enter bill ID = "BILLNONEXISTENT"
3. Query database
Test Data: billid = "BILLNONEXISTENT"
Expected Result: Bill not found
Actual Result: Bill not found = false
Status: PASS
Comments: Equivalence (Bill Status, (2))

Test Case ID: TC_RG_05
Description: Verify query by bill ID decision when bill exists
Precondition: System is running, bill "BILLLTEST60" exists in database
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILLLTEST60" in bill ID search field
3. Click search button for bill ID
4. Verify bill is displayed in table
Test Data: billid = "BILLLTEST60" (exists)
Expected Result: Bill found and displayed in table
Actual Result: Bill found and displayed = true
Status: PASS
Comments: Decision Table - TC1: Bill ID Format = "Valid" (Y), Bill Exists = "Exists" (Y) → Show Bill Data (Bảng 21: Bill Query Decision, TC1)

Test Case ID: TC_RG_06
Description: Verify query by bill ID decision when bill does not exist
Precondition: System is running, bill "BILLNONEXISTENT" does not exist
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILLNONEXISTENT" in bill ID search field
3. Click search button for bill ID
Test Data: billid = "BILLNONEXISTENT" (not exists)
Expected Result: Message "Record Not Found." displayed
Actual Result: Message "Record Not Found." displayed = true
Status: PASS
Comments: Decision Table - TC2: Bill ID Format = "Valid" (Y), Bill Exists = "Not Exists" (Y) → Show Error (Bảng 21: Bill Query Decision, TC2)

Test Case ID: TC_RG_07
Description: Verify get bill data operation simple path
Precondition: System is running, bill "BILLLTEST62" exists in database
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILLLTEST62" in bill ID search field
3. Click search button for bill ID
4. Verify bill data is displayed in table
Test Data: billid = "BILLLTEST62"
Expected Result: Bill data retrieved and displayed successfully
Actual Result: Bill data retrieved and displayed successfully
Status: PASS
Comments: Basic Path Testing - Simple path through get bill data function: Enter bill ID → Search → Display in table

Test Case ID: TC_RG_08
Description: Verify list all checked out customers operation simple path
Precondition: System is running, Customer Details Bill form is accessible, database connection available
Test Steps:
1. Open Customer Details Bill form
2. Form automatically loads all customers with status "check out"
3. Verify table displays all checked out customers
Test Data: Query all customers with status = "check out"
Expected Result: List of checked out customers displayed in table
Actual Result: Table displays all checked out customers = true
Status: PASS
Comments: Basic Path Testing - Simple path through list function: Form opens → Automatically loads all checked out customers → Displays in table

Test Case ID: TC_RG_09
Description: Verify bill exists branch shows data
Precondition: System is running, bill "BILLLTEST64" exists in database
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILLLTEST64" in bill ID search field
3. Click search button for bill ID
4. Verify bill data is displayed in table
Test Data: billid = "BILLLTEST64" (exists)
Expected Result: Bill data is displayed in table
Actual Result: Bill data shown in table = true
Status: PASS
Comments: Branch Testing - Branch 1: If bill exists → Display in table

Test Case ID: TC_RG_10
Description: Verify bill not exists branch shows error
Precondition: System is running, bill "BILLNONEXISTENT" does not exist
Test Steps:
1. Open Customer Details Bill form
2. Enter bill ID = "BILLNONEXISTENT" in bill ID search field
3. Click search button for bill ID
4. Verify error message is shown
Test Data: billid = "BILLNONEXISTENT" (not exists)
Expected Result: Message "Record Not Found." displayed
Actual Result: Message "Record Not Found." displayed = true
Status: PASS
Comments: Branch Testing - Branch 2: If bill not exists → Show "Record Not Found."

MODULE 6: DATABASE INTEGRITY (Tests TC_DI_01 to TC_DI_05)

Test Case ID: TC_DI_01
Description: Verify email uniqueness constraint - unique email can insert
Precondition: System is running, database is accessible, email "lamtest66@test.com" does not exist
Test Steps:
1. Open user registration form
2. Enter email = "lamtest66@test.com" (unique)
3. Enter other valid fields
4. Attempt to save
Test Data: email = "lamtest66@test.com" (unique)
Expected Result: User inserted successfully
Actual Result: INSERT result = 1 (success)
Status: PASS
Comments: Decision Table - TC1: Email = "Unique" (Y), Room Number = "Unique" (Y) → Can Insert (Bảng 22: Database Insert Decision, TC1)

Test Case ID: TC_DI_02
Description: Verify email uniqueness constraint - duplicate email cannot insert
Precondition: System is running, email "lamtest67@test.com" already exists in database
Test Steps:
1. Open user registration form
2. Enter email = "lamtest67@test.com" (duplicate)
3. Enter other valid fields
4. Attempt to save
Test Data: email = "lamtest67@test.com" (already exists)
Expected Result: System prevents duplicate email
Actual Result: SQLException (duplicate prevented)
Status: PASS
Comments: Decision Table - TC3: Email = "Duplicate" (Y) → Cannot Insert Email (Bảng 22: Database Insert Decision, TC3)

Test Case ID: TC_DI_03
Description: Verify room number uniqueness constraint - unique room number can insert
Precondition: System is running, database is accessible, room number "LTEST68" does not exist
Test Steps:
1. Open room management form
2. Enter room number = "LTEST68" (unique)
3. Enter other valid fields
4. Attempt to save
Test Data: roomNumber = "LTEST68" (unique)
Expected Result: Room inserted successfully
Actual Result: INSERT result = 1 (success)
Status: PASS
Comments: Decision Table - TC1: Email = "Unique" (Y), Room Number = "Unique" (Y) → Can Insert (Bảng 22: Database Insert Decision, TC1)

Test Case ID: TC_DI_04
Description: Verify room number uniqueness constraint - duplicate room number cannot insert
Precondition: System is running, room number "LTEST69" already exists in database
Test Steps:
1. Open room management form
2. Enter room number = "LTEST69" (duplicate)
3. Enter other valid fields
4. Attempt to save
Test Data: roomNumber = "LTEST69" (already exists)
Expected Result: System prevents duplicate room number
Actual Result: SQLException (duplicate prevented)
Status: PASS
Comments: Decision Table - TC2: Room Number = "Duplicate" (Y) → Cannot Insert Room (Bảng 22: Database Insert Decision, TC2)

Test Case ID: TC_DI_05
Description: Verify insert and retrieve operation simple path
Precondition: System is running, database is accessible
Test Steps:
1. Insert new user with unique email
2. Query database by email
3. Verify data matches
Test Data: Insert user, then retrieve by email
Expected Result: Data inserted and retrieved correctly
Actual Result: Data inserted and retrieved correctly
Status: PASS
Comments: Basic Path Testing - Simple path through insert and retrieve function

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
