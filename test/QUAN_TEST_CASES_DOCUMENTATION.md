Quan Test Suite - 70 Test Cases Documentation

Testing Techniques:
Black Box Testing: Boundary Value Analysis, Equivalence Partitioning, Decision Table
White Box Testing: Basic Path Testing, Branch Testing

IMPORTANT NOTE - USER STATUS WORKFLOW:
- When a new user signs up, status is automatically set to "panding" (database default)
- Admin can double-click on a user in the admin page to change status from "panding" to "approved"
- Only users with "approved" status can login
- Test users are initialized as needed for each test case

MODULE 1: BOOKING MODULE (Tests TC_BM_01 to TC_BM_20)

Test Case ID: TC_BM_01
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
Comments: Boundary Value Analysis - Price = -1 (below boundary, invalid), Price = 0 (boundary value, invalid), Price = 0.01 (above boundary, valid) (Bảng 1: Room Price)

Test Case ID: TC_BM_02
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
Comments: Boundary Value Analysis - Price = 1500.00 (valid - typical value within range) (Bảng 1: Room Price)

Test Case ID: TC_BM_03
Description: Verify room price validation with minimum valid value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room price = 0.01
3. Attempt to save room
Test Data: price = 0.01
Expected Result: System accepts minimum valid price
Actual Result: price > 0 = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Price = 0 (boundary value, invalid), Price = 0.01 (just above boundary, valid) (Bảng 1: Room Price)

Test Case ID: TC_BM_04
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
Comments: Boundary Value Analysis - Room Number = "" (boundary value, invalid - empty string) (Bảng 4: Room Number)

Test Case ID: TC_BM_05
Description: Verify room number validation with valid value
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Enter room number = "QTEST05"
3. Attempt to save room
Test Data: roomNumber = "QTEST05"
Expected Result: System accepts valid room number
Actual Result: !roomNumber.isEmpty() = true (valid)
Status: PASS
Comments: Boundary Value Analysis - Room Number = "" (boundary value, invalid), Room Number = "QTEST05" (above boundary, valid - non-empty) (Bảng 4: Room Number)

Test Case ID: TC_BM_06
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

Test Case ID: TC_BM_07
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

Test Case ID: TC_BM_08
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

Test Case ID: TC_BM_09
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

Test Case ID: TC_BM_10
Description: Verify room status is automatically set to "Not Booked" when adding new room
Precondition: System is running, room management module is accessible
Test Steps:
1. Open room management form
2. Add a new room with valid data
3. Verify room status is automatically set to "Not Booked"
Test Data: New room added
Expected Result: Room status is automatically "Not Booked" when room is created
Actual Result: status.equals("Not Booked") = true (automatically set)
Status: PASS
Comments: Basic Path Testing - Room status automatically set during room creation

Test Case ID: TC_BM_11
Description: Verify room status changes to "Booked" when customer checks in
Precondition: System is running, room exists with status "Not Booked", customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Complete customer check-in for a room
3. Verify room status automatically changes to "Booked"
Test Data: Customer checks in to room
Expected Result: Room status automatically changes to "Booked" when customer checks in
Actual Result: status.equals("Booked") = true (automatically set)
Status: PASS
Comments: Basic Path Testing - Room status automatically changes during check-in

Test Case ID: TC_BM_12
Description: Verify room status remains "Booked" after check-in until check-out
Precondition: System is running, room exists with status "Booked" (after customer check-in)
Test Steps:
1. Search for room that has been checked in
2. Verify room status is "Booked"
3. Confirm room cannot be booked again while status is "Booked"
Test Data: Room with status "Booked"
Expected Result: Room status remains "Booked" and room cannot be booked again
Actual Result: status.equals("Booked") = true, room not available for booking
Status: PASS
Comments: Branch Testing - Branch 2: If status == "Booked" → cannot book

Test Case ID: TC_BM_13
Description: Verify room booking when room is available
Precondition: System is running, room exists with status "Not Booked"
Test Steps:
1. Search for room with number "QTEST13"
2. Check room status is "Not Booked"
3. Attempt to book the room
Test Data: roomNumber = "QTEST13", status = "Not Booked"
Expected Result: Room can be booked successfully
Actual Result: Room found and available = true
Status: PASS
Comments: Decision Table - TC1: Status = "Not Booked" (Y), Room Number = "Valid" (Y) → Can Book (Bảng 12: Room Booking Decision, TC1)

Test Case ID: TC_BM_14
Description: Verify room booking when room is already booked
Precondition: System is running, room exists with status "Booked"
Test Steps:
1. Search for room with number "QTEST14"
2. Check room status is "Booked"
3. Attempt to book the room
Test Data: roomNumber = "QTEST14", status = "Booked"
Expected Result: Room cannot be booked
Actual Result: Room not available = false
Status: PASS
Comments: Decision Table - TC3: Status = "Booked" (Y), Room Number = "Valid" (Y) → Cannot Book (Bảng 12: Room Booking Decision, TC3)

Test Case ID: TC_BM_15
Description: Verify add new room operation with all valid fields
Precondition: System is running, room management module is accessible, database connection available
Test Steps:
1. Open room management form
2. Enter all valid room details (number, type, bed, price, status)
3. Click save button
Test Data: roomNumber = "QTEST15", type = "AC", bed = "Single", price = 1500.00, status = "Not Booked"
Expected Result: Room added successfully to database
Actual Result: Room added successfully
Status: PASS
Comments: Basic Path Testing - Simple path through add room function

Test Case ID: TC_BM_16
Description: Verify update room price operation
Precondition: System is running, room "QTEST16" exists in database
Test Steps:
1. Open room management form
2. Double-click on row for room "QTEST16" in the table
3. Dialog "Input" appears with instructions
4. Type "update" in the input field
5. Click "OK" button
6. Room details are loaded into form fields
7. Update price to 2000.00
8. Click "Update" button (replaces "Add Room" button)
Test Data: roomNumber = "QTEST16", newPrice = 2000.00
Expected Result: Room price updated successfully
Actual Result: Room updated successfully
Status: PASS
Comments: Basic Path Testing - Simple path through update room function: Double-click row → Type "update" → OK → Modify fields → Update button

Test Case ID: TC_BM_17
Description: Verify delete room operation
Precondition: System is running, room "QTEST17" exists in database
Test Steps:
1. Open room management form
2. Double-click on row for room "QTEST17" in the table
3. Dialog "Input" appears with instructions
4. Type "Delete" in the input field
5. Click "OK" button
6. Confirm deletion
Test Data: roomNumber = "QTEST17"
Expected Result: Room deleted successfully from database
Actual Result: Room deleted successfully
Status: PASS
Comments: Basic Path Testing - Simple path through delete room function: Double-click row → Type "Delete" → OK → Room deleted

Test Case ID: TC_BM_18
Description: Verify room status branch when status is Not Booked
Precondition: System is running, room "QTEST18" exists with status "Not Booked"
Test Steps:
1. Query room "QTEST18" from database
2. Check room status
3. Verify status branch logic
Test Data: roomNumber = "QTEST18", status = "Not Booked"
Expected Result: Status branch for "Not Booked" is executed
Actual Result: Status is "Not Booked" = true
Status: PASS
Comments: Branch Testing - Branch 1: If status == "Not Booked"

Test Case ID: TC_BM_19
Description: Verify room status branch when status is Booked
Precondition: System is running, room "QTEST19" exists with status "Booked"
Test Steps:
1. Query room "QTEST19" from database
2. Check room status
3. Verify status branch logic
Test Data: roomNumber = "QTEST19", status = "Booked"
Expected Result: Status branch for "Booked" is executed
Actual Result: Status is "Booked" = true
Status: PASS
Comments: Branch Testing - Branch 2: If status == "Booked"

Test Case ID: TC_BM_20
Description: Verify duplicate room number prevention
Precondition: System is running, room "QTEST20" already exists in database
Test Steps:
1. Open room management form
2. Enter room number "QTEST20" (duplicate)
3. Enter other room details
4. Attempt to save
Test Data: roomNumber = "QTEST20" (already exists)
Expected Result: System prevents duplicate, shows error
Actual Result: SQLException (duplicate prevented)
Status: PASS
Comments: Decision Table - TC2: Room Number = "Invalid" (Y) → Cannot Book (Bảng 12: Room Booking Decision, TC2)

MODULE 2: CUSTOMER MODULE (Tests TC_CM_01 to TC_CM_20)

Test Case ID: TC_CM_01
Description: Verify mobile number validation with empty value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Leave mobile number field empty
3. Attempt to save customer
Test Data: mobile = ""
Expected Result: System rejects empty mobile number
Actual Result: mobile.isEmpty() = true (invalid)
Status: PASS
Comments: Boundary Value Analysis - Mobile = "" (boundary value, invalid - empty string) (Bảng 2: Mobile Number)

Test Case ID: TC_CM_02
Description: Verify mobile number validation with valid 10-digit value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Enter mobile number = "1234567890"
3. Attempt to save customer
Test Data: mobile = "1234567890" (10 digits)
Expected Result: System accepts valid 10-digit mobile number
Actual Result: mobile.length() == 10 = true
Status: PASS
Comments: Boundary Value Analysis - Mobile = "123456789" (below boundary, invalid - 9 digits), Mobile = "1234567890" (boundary value, valid - 10 digits), Mobile = "12345678901" (above boundary, invalid - 11 digits) (Bảng 2: Mobile Number)

Test Case ID: TC_CM_03
Description: Verify aadhar number validation with valid 12-digit value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Enter aadhar number = "123456789012"
3. Attempt to save customer
Test Data: aadhar = "123456789012" (12 digits)
Expected Result: System accepts valid 12-digit aadhar number
Actual Result: aadhar.length() == 12 = true
Status: PASS
Comments: Boundary Value Analysis - Mobile = "123456789" (below boundary, invalid - 9 digits), Mobile = "1234567890" (boundary value, valid - 10 digits), Mobile = "12345678901" (above boundary, invalid - 11 digits) (Bảng 2: Mobile Number)

Test Case ID: TC_CM_04
Description: Verify checkout search when room number does not exist
Precondition: System is running, customer checkout module is accessible, table shows all booked rooms
Test Steps:
1. Open customer checkout form
2. Verify table displays all booked rooms
3. Enter room number that does not exist in table
4. Click search button
Test Data: roomNumber = "NONEXISTENT"
Expected Result: Message "Record Not Found." displayed
Actual Result: Message "Record Not Found." displayed = true
Status: PASS
Comments: Decision Table - TC2: Room Number = "Not Exists" (Y) → Show "Record Not Found" (Bảng 13: Customer Checkout Decision, TC2)

Test Case ID: TC_CM_05
Description: Verify automatic calculation of days and amount when room exists
Precondition: System is running, customer checkout module is accessible, customer is checked in with room "QTEST35"
Test Steps:
1. Open customer checkout form
2. Enter room number "QTEST35" in search box
3. Click search button
4. Verify information is automatically filled
5. Verify days and amount are automatically calculated
Test Data: roomNumber = "QTEST35" (exists and booked)
Expected Result: Customer information automatically filled, days and amount automatically calculated
Actual Result: Information filled automatically = true, days and amount calculated automatically = true
Status: PASS
Comments: Basic Path Testing - Automatic calculation of days (from check-in date to today) and amount (days * price)

Test Case ID: TC_CM_06
Description: Verify gender validation with Male value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Select gender = "Male"
3. Attempt to save customer
Test Data: gender = "Male"
Expected Result: System accepts Male gender
Actual Result: gender.equals("Male") = true
Status: PASS
Comments: Equivalence (Gender, (1))

Test Case ID: TC_CM_07
Description: Verify gender validation with Female value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Select gender = "Female"
3. Attempt to save customer
Test Data: gender = "Female"
Expected Result: System accepts Female gender
Actual Result: gender.equals("Female") = true
Status: PASS
Comments: Equivalence (Gender, (2))

Test Case ID: TC_CM_08
Description: Verify gender validation with Other value
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Select gender = "Other"
3. Attempt to save customer
Test Data: gender = "Other"
Expected Result: System accepts Other gender
Actual Result: gender.equals("Other") = true
Status: PASS
Comments: Equivalence (Gender, (3))

Test Case ID: TC_CM_09
Description: Verify email validation with valid email containing @ symbol
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Enter email = "test@example.com"
3. Attempt to save customer
Test Data: email = "test@example.com"
Expected Result: System accepts valid email with @ symbol
Actual Result: email.contains("@") = true
Status: PASS
Comments: Equivalence (Email Validation, (1))

Test Case ID: TC_CM_10
Description: Verify email validation with invalid email without @ symbol
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Open customer check-in form
2. Enter email = "invalidemail.com"
3. Attempt to save customer
Test Data: email = "invalidemail.com"
Expected Result: System rejects invalid email without @ symbol
Actual Result: email.contains("@") = false
Status: PASS
Comments: Equivalence (Email Validation, (2))

Test Case ID: TC_CM_11
Description: Verify customer check-in with all valid data
Precondition: System is running, room "QTEST31" exists and is available
Test Steps:
1. Open customer check-in form
2. Enter all valid customer details
3. Select available room "QTEST31"
4. Click save button
Test Data: All customer fields valid, room available
Expected Result: Customer checked in successfully
Actual Result: Check-in successful, INSERT result = 1
Status: PASS
Comments: Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 13: Customer Checkout Decision, TC1)

Test Case ID: TC_CM_12
Description: Verify customer checkout with valid room number search
Precondition: System is running, customer is checked in, room "QTEST32" is booked
Test Steps:
1. Open customer checkout form
2. Verify table displays all booked rooms
3. Enter room number "QTEST32" in search box
4. Click search button
5. Verify customer information is automatically filled (name, email, mobile, date, price)
6. Verify days and amount are automatically calculated
7. Click checkout button
Test Data: roomNumber = "QTEST32" (exists and booked)
Expected Result: Customer information automatically filled, days and amount automatically calculated, checkout successful
Actual Result: Information filled automatically = true, checkout successful, UPDATE result = 1
Status: PASS
Comments: Decision Table - TC1: Status = "checked in" (Y), Amount = "Valid" (Y), Days = "Valid" (Y) → Can Checkout (Bảng 13: Customer Checkout Decision, TC1)

Test Case ID: TC_CM_13
Description: Verify customer checkout when already checked out
Precondition: System is running, customer is already checked out, room "QTEST33" is not in booked rooms table
Test Steps:
1. Open customer checkout form
2. Verify table does not show room "QTEST33" (already checked out)
3. Enter room number "QTEST33" in search box
4. Click search button
5. Verify "Record Not Found." message is displayed
Test Data: roomNumber = "QTEST33" (already checked out, not in booked rooms table)
Expected Result: Message "Record Not Found." displayed (room not in booked rooms table)
Actual Result: Message "Record Not Found." displayed = true
Status: PASS
Comments: Decision Table - TC4: Status = "checked out" (Y) → Already Checked Out (Bảng 13: Customer Checkout Decision, TC4). Room not in booked rooms table, so search shows "Record Not Found."

Test Case ID: TC_CM_14
Description: Verify customer check-in operation simple path
Precondition: System is running, room "QTEST34" exists and is available
Test Steps:
1. Open customer check-in form
2. Enter all valid customer fields
3. Select room "QTEST34"
4. Click save button
Test Data: New customer with all valid fields
Expected Result: Customer checked in successfully
Actual Result: Customer checked in successfully
Status: PASS
Comments: Basic Path Testing - Simple path through check-in function

Test Case ID: TC_CM_15
Description: Verify automatic bill calculation when searching for booked room
Precondition: System is running, customer checkout module is accessible, customer is checked in with room "QTEST36" (price = 1500.00, checked in 3 days ago)
Test Steps:
1. Open customer checkout form
2. Enter room number "QTEST36" in search box
3. Click search button
4. Verify price is automatically filled from database
5. Verify days are automatically calculated (from check-in date to today)
6. Verify amount is automatically calculated (days * price)
Test Data: roomNumber = "QTEST36", price = 1500.00, days = 3 (automatically calculated)
Expected Result: Price filled automatically, days calculated automatically as 3, amount calculated automatically as 4500.00
Actual Result: price = 1500.00 (auto-filled), days = 3 (auto-calculated), amount = 4500.00 (auto-calculated)
Status: PASS
Comments: Basic Path Testing - Automatic calculation: days (from check-in date to today) and amount (days * price) when searching for booked room

Test Case ID: TC_CM_16
Description: Verify customer status branch when status is NULL (checked in)
Precondition: System is running, customer is checked in with status "NULL"
Test Steps:
1. Query customer by room number "QTEST36"
2. Check customer status
3. Verify status branch logic
Test Data: Customer checked in, status = "NULL"
Expected Result: Status branch for "NULL" is executed
Actual Result: Status is "NULL" = true
Status: PASS
Comments: Branch Testing - Branch 1: If status == "NULL"

Test Case ID: TC_CM_17
Description: Verify customer status branch when status is check out
Precondition: System is running, customer is checked out
Test Steps:
1. Query customer by room number "QTEST37"
2. Check customer status
3. Verify status branch logic
Test Data: Customer checked out, status = "check out"
Expected Result: Status branch for "check out" is executed
Actual Result: Status is "check out" = true
Status: PASS
Comments: Branch Testing - Branch 2: If status == "check out"

Test Case ID: TC_CM_18
Description: Verify days validation branch when calculated days is zero or negative
Precondition: System is running, customer checkout module is accessible, customer checked in today (same day checkout)
Test Steps:
1. Open customer checkout form
2. Enter room number of customer checked in today
3. Click search button
4. Verify days are automatically calculated
5. Verify system converts zero or negative days to 1 (minimum charge)
Test Data: Customer checked in today, days calculated as 0 or negative
Expected Result: Days branch converts zero/negative to 1 (minimum charge)
Actual Result: actualDays = 1 (minimum charge applied)
Status: PASS
Comments: Branch Testing - Branch 1: If days <= 0 → convert to 1 (minimum charge). Days are automatically calculated from check-in date to today.

Test Case ID: TC_CM_19
Description: Verify days validation branch when calculated days is positive
Precondition: System is running, customer checkout module is accessible, customer checked in multiple days ago
Test Steps:
1. Open customer checkout form
2. Enter room number of customer checked in 5 days ago
3. Click search button
4. Verify days are automatically calculated as positive value
5. Verify amount is calculated correctly
Test Data: Customer checked in 5 days ago, days automatically calculated as 5
Expected Result: Days branch uses actual calculated days value (> 0)
Actual Result: days > 0 = true, days = 5 (automatically calculated)
Status: PASS
Comments: Branch Testing - Branch 2: If days > 0 → use actual calculated days. Days are automatically calculated from check-in date to today.

Test Case ID: TC_CM_20
Description: Verify clear button functionality in checkout form
Precondition: System is running, customer checkout module is accessible, customer information is filled
Test Steps:
1. Open customer checkout form
2. Enter room number and search (information is filled)
3. Click clear button
4. Verify all fields are cleared
Test Data: Customer information filled, then clear button clicked
Expected Result: All fields (name, email, mobile, date, price, days, amount) are cleared
Actual Result: All fields cleared = true
Status: PASS
Comments: Basic Path Testing - Clear button clears all form fields

MODULE 3: NOTIFICATION SYSTEM (Tests TC_NS_01 to TC_NS_10)

Test Case ID: TC_NS_01
Description: Verify success message display for registration
Precondition: System is running, user registration module is accessible
Test Steps:
1. Complete user registration with valid data
2. Submit registration form
3. Check displayed message
Test Data: Registration successful
Expected Result: Success message contains "Successfully"
Actual Result: message contains "Successfully" = true
Status: PASS
Comments: Equivalence (Message Types, (1))

Test Case ID: TC_NS_02
Description: Verify success message display for check-in
Precondition: System is running, customer check-in module is accessible
Test Steps:
1. Complete customer check-in with valid data
2. Submit check-in form
3. Check displayed message
Test Data: Check-in successful
Expected Result: Success message "Room Alloted" displayed
Actual Result: Message "Room Alloted" displayed = true
Status: PASS
Comments: Equivalence (Message Types, (1))

Test Case ID: TC_NS_03
Description: Verify success message display for check-out
Precondition: System is running, customer checkout module is accessible
Test Steps:
1. Complete customer checkout with valid data
2. Submit checkout form
3. Check displayed message
Test Data: Check-out successful
Expected Result: Success message "Check out Successfully." displayed
Actual Result: Message "Check out Successfully." displayed = true
Status: PASS
Comments: Equivalence (Message Types, (1))

Test Case ID: TC_NS_04
Description: Verify error message display when record not found
Precondition: System is running, search functionality is accessible
Test Steps:
1. Search for non-existent record
2. Submit search
3. Check displayed message
Test Data: Record search failed
Expected Result: Error message "Record Not Found" displayed
Actual Result: Message "Record Not Found" displayed = true
Status: PASS
Comments: Equivalence (Message Types, (2))

Test Case ID: TC_NS_05
Description: Verify confirmation message display for logout
Precondition: System is running, user is logged in
Test Steps:
1. Click logout button
2. Check displayed confirmation message
Test Data: Logout button clicked
Expected Result: Confirmation message contains "?"
Actual Result: message contains "?" = true
Status: PASS
Comments: Equivalence (Message Types, (3))

Test Case ID: TC_NS_06
Description: Verify confirmation message display for exit
Precondition: System is running, application is open
Test Steps:
1. Click exit button
2. Check displayed confirmation message
Test Data: Exit button clicked
Expected Result: Confirmation message contains "?"
Actual Result: message contains "?" = true
Status: PASS
Comments: Equivalence (Message Types, (3))

Test Case ID: TC_NS_07
Description: Verify info message display for password reset
Precondition: System is running, password reset module is accessible
Test Steps:
1. Complete password reset with valid data
2. Submit reset form
3. Check displayed message
Test Data: Password reset successful
Expected Result: Info message contains "Reset"
Actual Result: message contains "Reset" = true
Status: PASS
Comments: Equivalence (Message Types, (3))

Test Case ID: TC_NS_08
Description: Verify success message display when operation succeeds
Precondition: System is running, operation module is accessible
Test Steps:
1. Perform operation that succeeds
2. Check displayed message
Test Data: operationSuccess = true
Expected Result: Success message is shown
Actual Result: Success message shown = true
Status: PASS
Comments: Decision Table - TC1: Operation = "Success" (Y), Action = "Confirm" (Y) → Show Success Message (Bảng 14: Notification Display Decision, TC1)

Test Case ID: TC_NS_09
Description: Verify error message display when operation fails
Precondition: System is running, operation module is accessible
Test Steps:
1. Perform operation that fails
2. Check displayed message
Test Data: operationError = true
Expected Result: Error message is shown
Actual Result: Error message shown = true
Status: PASS
Comments: Decision Table - TC3: Operation = "Error" (Y), Action = "Confirm" (Y) → Show Error Message (Bảng 14: Notification Display Decision, TC3)

Test Case ID: TC_NS_10
Description: Verify user confirmation branch when user confirms YES
Precondition: System is running, confirmation dialog is displayed
Test Steps:
1. Display confirmation dialog
2. User selects YES (0)
3. Check system response
Test Data: userChoice = 0 (YES)
Expected Result: Operation proceeds
Actual Result: Proceed with operation = true
Status: PASS
Comments: Branch Testing - Branch 1: If userChoice == YES (0)

MODULE 4: WEBSITE HOME/DASHBOARD (Tests TC_DH_01 to TC_DH_10)

Test Case ID: TC_DH_01
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
Comments: Decision Table - TC1: Button = "Valid" (Y) → Button Works (Bảng 16: Button Click Decision, TC1)

Test Case ID: TC_DH_02
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
Comments: Decision Table - TC1: Button = "Valid" (Y) → Button Works (Bảng 16: Button Click Decision, TC1)

Test Case ID: TC_DH_03
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
Comments: Decision Table - TC1: Button = "Valid" (Y) → Button Works (Bảng 16: Button Click Decision, TC1)

Test Case ID: TC_DH_04
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
Comments: Decision Table - TC1: Button = "Valid" (Y) → Button Works (Bảng 16: Button Click Decision, TC1)

Test Case ID: TC_DH_05
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
Comments: Decision Table - Button Click: ManageRoom (Bảng 16: Button Click Decision, Dòng 1)

Test Case ID: TC_DH_06
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

Test Case ID: TC_DH_07
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

Test Case ID: TC_DH_08
Description: Verify exit confirmation when user says YES
Precondition: System is running, application is open
Test Steps:
1. Click exit button
2. Confirmation dialog appears
3. Select YES
4. Verify application exits
Test Data: choice = 0 (YES)
Expected Result: Application exits
Actual Result: Should exit = true
Status: PASS
Comments: Branch Testing - Branch 1: If user confirms YES

Test Case ID: TC_DH_09
Description: Verify exit confirmation when user says NO
Precondition: System is running, application is open
Test Steps:
1. Click exit button
2. Confirmation dialog appears
3. Select NO
4. Verify application stays open
Test Data: choice = 1 (NO)
Expected Result: Application stays open
Actual Result: Should not exit = false
Status: PASS
Comments: Branch Testing - Branch 2: If user confirms NO

Test Case ID: TC_DH_10
Description: Verify all dashboard buttons exist
Precondition: System is running, user is logged in, dashboard is displayed
Test Steps:
1. Open dashboard/home page
2. Count all buttons
3. Verify 6 buttons exist
Test Data: All dashboard buttons
Expected Result: 6 buttons exist on dashboard
Actual Result: 6 buttons exist = true
Status: PASS
Comments: Decision Table - TC1: Button = "Valid" (Y) → Button Works (Bảng 16: Button Click Decision, TC1)

MODULE 5: ADMIN MANAGEMENT (Tests TC_AM_01 to TC_AM_10)

Test Case ID: TC_AM_01
Description: Verify user status validation with pending value
Precondition: System is running, admin module is accessible, user exists with status "panding" (from signup)
Test Steps:
1. Open admin management form
2. Search for user "test61@test.com"
3. Check user status
Test Data: email = "test61@test.com", status = "panding" (from signup)
Expected Result: User status is "panding"
Actual Result: Status is "panding" = true
Status: PASS
Comments: Equivalence (User Status, (1)). Note: New users start as "panding" after signup (automatic, database default).

Test Case ID: TC_AM_02
Description: Verify user status validation with approved value
Precondition: System is running, admin module is accessible, user exists with status "approved" (admin has approved the user)
Test Steps:
1. Open admin management form
2. Search for user "test62@test.com"
3. Check user status
Test Data: email = "test62@test.com", status = "approved" (admin has approved)
Expected Result: User status is "approved"
Actual Result: Status is "approved" = true
Status: PASS
Comments: Equivalence (User Status, (2)). Note: User has been approved by admin (status changed from "panding" to "approved" via double-click).
Comments: Equivalence (User Status, (2))

Test Case ID: TC_AM_03
Description: Verify status change from pending to approved
Precondition: System is running, admin module is accessible, user exists with status "panding" (from signup)
Test Steps:
1. Open admin management form
2. Search for user "test63@test.com" (user has "panding" status from signup)
3. Double-click on user row
4. Confirm status change to "approved"
Test Data: email = "test63@test.com", status = "panding" (from signup), changes to "approved"
Expected Result: Status updated successfully to "approved"
Actual Result: Status updated successfully, UPDATE result = 1
Status: PASS
Comments: Decision Table - TC1: Status = "pending" (Y), Action = "Change to approved" (Y) → Success (Bảng 15: Admin Status Change Decision, TC1). Note: New users start as "panding" after signup, admin approves by double-clicking.

Test Case ID: TC_AM_04
Description: Verify status change from approved to pending
Precondition: System is running, admin module is accessible, user exists with status "approved"
Test Steps:
1. Open admin management form
2. Search for user "test64@test.com"
3. Double-click on user row
4. Confirm status change to "panding"
Test Data: email = "test64@test.com", status change from "approved" to "panding"
Expected Result: Status updated successfully to "panding"
Actual Result: Status updated successfully, UPDATE result = 1
Status: PASS
Comments: Decision Table - TC2: Status = "approved" (Y), Action = "Change to pending" (Y) → Success (Bảng 15: Admin Status Change Decision, TC2)

Test Case ID: TC_AM_05
Description: Verify user search when user exists
Precondition: System is running, admin module is accessible, user exists in database
Test Steps:
1. Open admin management form
2. Enter email "test65@test.com" in search field
3. Click search button
Test Data: email = "test65@test.com" (exists)
Expected Result: User found and displayed
Actual Result: User found = true
Status: PASS
Comments: Decision Table - TC1: User = "Exists" (Y) → Show User Data (Bảng 19: Admin Search Decision, TC1)

Test Case ID: TC_AM_06
Description: Verify user search when user does not exist
Precondition: System is running, admin module is accessible
Test Steps:
1. Open admin management form
2. Enter email "nonexistent@test.com" in search field
3. Click search button
Test Data: email = "nonexistent@test.com" (not exists)
Expected Result: Message "Record Not Found" displayed
Actual Result: Message "Record Not Found" displayed = true
Status: PASS
Comments: Decision Table - TC2: User = "Not Exists" (Y) → Show "Record Not Found" (Bảng 19: Admin Search Decision, TC2)

Test Case ID: TC_AM_07
Description: Verify view all users operation simple path
Precondition: System is running, admin module is accessible, database connection available
Test Steps:
1. Open admin management form
2. Click refresh or load all users
3. Verify user list is displayed
Test Data: Query all users
Expected Result: All users are displayed with count
Actual Result: Returns count >= 0
Status: PASS
Comments: Basic Path Testing - Simple path through view all users function

Test Case ID: TC_AM_08
Description: Verify refresh user list operation simple path
Precondition: System is running, admin module is accessible, user list is displayed
Test Steps:
1. Open admin management form
2. User list is already displayed
3. Click refresh button
4. Verify updated list is displayed
Test Data: Refresh query
Expected Result: Updated user list is displayed
Actual Result: Returns updated count >= 0
Status: PASS
Comments: Basic Path Testing - Simple path through refresh function

Test Case ID: TC_AM_09
Description: Verify double click triggers status change dialog
Precondition: System is running, admin module is accessible, user list is displayed
Test Steps:
1. Open admin management form
2. User list is displayed
3. Double-click on any user row
4. Verify status change dialog appears
Test Data: clickCount = 2
Expected Result: Status change dialog is triggered
Actual Result: Status change dialog triggered = true
Status: PASS
Comments: Branch Testing - Branch: If clickCount == 2

Test Case ID: TC_AM_10
Description: Verify approve user operation simple path
Precondition: System is running, admin module is accessible, user exists with status "panding"
Test Steps:
1. Open admin management form
2. Search for user "test70@test.com" (user has "panding" status from signup)
3. Double-click on user row to change status
4. Confirm status change to "approved"
5. Verify status is updated
Test Data: email = "test70@test.com", status = "panding" (from signup), changes to "approved"
Expected Result: User approved successfully
Actual Result: User approved successfully
Status: PASS
Comments: Basic Path Testing - Simple path through approve user function. New users start as "panding" after signup, admin approves by double-clicking.

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
