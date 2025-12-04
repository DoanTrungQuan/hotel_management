Testing Techniques Explanation for Quan

BOUNDARY VALUE ANALYSIS

Example 1: Room Price (Booking Module)
- Price: 0 -> 99999.99

Example 2: Mobile Number (Customer Module)
- String length: 10 digits

Example 3: Days Stayed (Customer Module)
- Days: 1 -> 365

Example 4: Room Number (Booking Module)
- Empty/Non-empty: Cannot be empty

EQUIVALENCE PARTITIONING

Example 1: Room Type (Booking Module)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Room Type | "AC" 1       | -              |
| 2   | Room Type | "NON AC" 2   | -              |

Note: Room Type is a dropdown selection with only 2 options. Invalid values cannot be entered.

Example 2: Bed Type (Booking Module)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Bed Type  | "Single" 1   | -              |
| 2   | Bed Type  | "Double" 2   | -              |

Note: Bed Type is a dropdown selection with only 2 options. Invalid values cannot be entered.

Example 3: Room Status (Booking Module)
| Stt | Condition   | Valid Number | Invalid Number |
|-----|-------------|--------------|----------------|
| 1   | Room Status | "Not Booked" 1 | -              |
| 2   | Room Status | "Booked" 2     | -              |

Note: Room Status is automatically set by the system. When adding a new room, status is automatically "Not Booked". When customer checks in, status automatically changes to "Booked". No user input required.

Example 4: Gender (Customer Module)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Gender    | "Male" 1     | -              |
| 2   | Gender    | "Female" 2   | -              |
| 3   | Gender    | "Other" 3     | -              |

Note: Gender is a dropdown selection with only 3 options. Invalid values cannot be entered.

Example 5: Email Validation (Customer Module)
| Stt | Condition      | Valid Number | Invalid Number |
|-----|----------------|--------------|----------------|
| 1   | Email Format   | Contains "@" 1 | No "@" symbol 2 |

Example 6: User Status (Admin Module)
| Stt | Condition   | Valid Number | Invalid Number |
|-----|-------------|--------------|----------------|
| 1   | User Status | "panding" 1  | "active" 3     |
| 2   | User Status | "approved" 2 | "inactive" 4   |
| 3   | User Status | -            | empty 5         |

Note: When a new user signs up, status is automatically set to "panding" (database default). Admin can double-click on a user in the admin page to change status from "panding" to "approved". Only users with "approved" status can login.

Example 7: Message Types (Notification System)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Message Type | Success Message 1 | - |
| 2   | Message Type | Error Message 2 | - |
| 3   | Message Type | Confirmation Message 3 | - |

Note: Message Types are system-generated. Success messages (e.g., "Room Alloted", "Check out Successfully."), Error messages (e.g., "Record Not Found"), and Confirmation messages (containing "?") are automatically displayed by the system based on operation results.

DECISION TABLE

Example 1: Room Booking Decision (Booking Module)
Conditions:
- Room Status: Not Booked / Booked
- Room Number: Valid / Invalid

Decision Table (Full):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 |
|---------------------------|-----|-----|-----|-----|
| Status = Not Booked?      | Y   | Y   | N   | N   |
| Status = Booked?          | N   | N   | Y   | Y   |
| Room Number = Valid?       | Y   | N   | Y   | N   |
| Room Number = Invalid?    | N   | Y   | N   | Y   |
| Expected Result           | Can Book | Cannot | Cannot | Cannot |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 | TC3 |
|---------------------------|-----|-----|-----|
| Status = Not Booked?      | Y   | Y   | N   |
| Status = Booked?          | N   | N   | Y   |
| Room Number = Valid?       | Y   | N   | Y   |
| Room Number = Invalid?    | N   | Y   | N   |
| Expected Result           | Can Book | Cannot | Cannot |

Legend:
- TC1 (Green): When Status = "Not Booked" and Room Number = "Valid", only one test case is needed.
- TC2 (Yellow): When Room Number = "Invalid", regardless of Status, only one test case is needed (Cannot Book).
- TC3 (Blue): When Status = "Booked", regardless of Room Number, only one test case is needed (Cannot Book).

Test Cases Selected:
- TC1: Not Booked + Valid Number = Can Book
- TC2: Not Booked + Invalid Number = Cannot Book
- TC3: Booked + Valid Number = Cannot Book

Example 2: Customer Checkout Decision (Customer Module)
Conditions:
- Customer Status: checked in / checked out
- Amount: Valid / Invalid
- Days: Valid / Invalid

Decision Table (Full):
| Condition/Action        | TC1 | TC2 | TC3 | TC4 | TC5 | TC6 | TC7 | TC8 |
|-------------------------|-----|-----|-----|-----|-----|-----|-----|-----|
| Status = checked in?    | Y   | Y   | Y   | Y   | N   | N   | N   | N   |
| Status = checked out?   | N   | N   | N   | N   | Y   | Y   | Y   | Y   |
| Amount = Valid?         | Y   | Y   | N   | N   | Y   | Y   | N   | N   |
| Amount = Invalid?       | N   | N   | Y   | Y   | N   | N   | Y   | Y   |
| Days = Valid?           | Y   | N   | Y   | N   | Y   | N   | Y   | N   |
| Days = Invalid?         | N   | Y   | N   | Y   | N   | Y   | N   | Y   |
| Expected Result         | Can Checkout | Cannot | Cannot | Cannot | Already Out | Already Out | Already Out | Already Out |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action        | TC1 | TC2 | TC3 | TC4 |
|-------------------------|-----|-----|-----|-----|
| Status = checked in?    | Y   | Y   | Y   | N   |
| Status = checked out?   | N   | N   | N   | Y   |
| Amount = Valid?         | Y   | N   | N   | Y   |
| Amount = Invalid?       | N   | Y   | Y   | N   |
| Days = Valid?           | Y   | Y   | N   | Y   |
| Days = Invalid?         | N   | N   | Y   | N   |
| Expected Result         | Can Checkout | Cannot | Cannot | Already Out |

Legend:
- TC1 (Green): When Status = "checked in", Amount = "Valid", and Days = "Valid", only one test case is needed.
- TC2 (Yellow): When Status = "checked in" and Amount = "Invalid", regardless of Days, only one test case is needed (Cannot Checkout).
- TC3 (Yellow): When Status = "checked in" and Days = "Invalid", regardless of Amount, only one test case is needed (Cannot Checkout).
- TC4 (Blue): When Status = "checked out", regardless of Amount and Days, only one test case is needed (Already Checked Out).

Test Cases Selected:
- TC1: Checked in + Valid Amount + Valid Days = Can Checkout
- TC2: Checked in + Invalid Amount = Cannot Checkout
- TC3: Checked in + Invalid Days = Cannot Checkout
- TC4: Checked out = Already Checked Out

Example 3: Notification Display Decision (Notification System)
Conditions:
- Operation Result: Success / Error
- User Action: Confirm / Cancel

Decision Table (Full):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 |
|---------------------------|-----|-----|-----|-----|
| Operation = Success?      | Y   | Y   | N   | N   |
| Operation = Error?         | N   | N   | Y   | Y   |
| Action = Confirm?          | Y   | N   | Y   | N   |
| Action = Cancel?           | N   | Y   | N   | Y   |
| Expected Result           | Show Success | No Action | Show Error | No Action |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 | TC3 |
|---------------------------|-----|-----|-----|
| Operation = Success?      | Y   | Y   | N   |
| Operation = Error?         | N   | N   | Y   |
| Action = Confirm?          | Y   | N   | Y   |
| Action = Cancel?           | N   | Y   | N   |
| Expected Result           | Show Success | No Action | Show Error |

Legend:
- TC1 (Green): When Operation = "Success" and Action = "Confirm", only one test case is needed.
- TC2 (Yellow): When Action = "Cancel", regardless of operation result, only one test case is needed (No Action).
- TC3 (Green): When Operation = "Error" and Action = "Confirm", only one test case is needed.

Test Cases Selected:
- TC1: Success + Confirm = Show Success Message
- TC2: Success + Cancel = No Action (same for Error + Cancel)
- TC3: Error + Confirm = Show Error Message

Example 4: Admin Status Change Decision (Admin Module)
Conditions:
- Current Status: pending / approved
- Action: Change to approved / Change to pending

Decision Table (Full):
| Condition/Action              | TC1 | TC2 | TC3 | TC4 | TC5 | TC6 | TC7 | TC8 |
|-------------------------------|-----|-----|-----|-----|-----|-----|-----|-----|
| Status = pending?             | Y   | Y   | Y   | N   | N   | N   | Y   | N   |
| Status = approved?            | N   | N   | N   | Y   | Y   | Y   | N   | N   |
| Action = Change to approved? | Y   | N   | N   | Y   | N   | N   | N   | Y   |
| Action = Change to pending?  | N   | Y   | N   | N   | Y   | N   | Y   | N   |
| Expected Result               | Success | Success | No Change | Success | Success | No Change | No Change | Success |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action              | TC1 | TC2 | TC3 | TC4 |
|-------------------------------|-----|-----|-----|-----|
| Status = pending?             | Y   | N   | Y   | N   |
| Status = approved?            | N   | Y   | N   | N   |
| Action = Change to approved? | Y   | Y   | N   | N   |
| Action = Change to pending?  | N   | N   | Y   | N   |
| Expected Result               | Success | Success | No Change | Success |

Legend:
- TC1 (Yellow): When Status = "pending" and Action = "Change to approved", only one test case is needed.
- TC2 (Yellow): When Status = "approved" and Action = "Change to approved", this combination is impossible (already approved), so eliminated.
- TC3 (Green): When Status = "pending" and Action = "Change to pending", no change needed, only one test case.
- TC4 (Green): When Status = "approved" and Action = "Change to pending", only one test case is needed.

Test Cases Selected:
- TC1: pending → approved = Status Changed Successfully (Admin double-clicks on user with "panding" status to approve)
- TC2: approved → pending = Status Changed Successfully (Admin double-clicks on user with "approved" status to change back to "panding")
- TC3: pending → pending = No Change (redundant, but tested for completeness)
- TC4: approved → approved = No Change (redundant, but tested for completeness)

Note: New users start as "panding" after signup. Admin approves users by double-clicking on their row in the admin table.

Example 5: Admin Search Decision (Admin Module)
Conditions:
- User: Exists / Not Exists

Decision Table (Full):
| Condition/Action          | TC1 | TC2 |
|---------------------------|-----|-----|
| User = Exists?            | Y   | N   |
| User = Not Exists?        | N   | Y   |
| Expected Result           | Show User Data | Show "Record Not Found" |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 |
|---------------------------|-----|-----|
| User = Exists?            | Y   | N   |
| User = Not Exists?        | N   | Y   |
| Expected Result           | Show User Data | Show "Record Not Found" |

Legend:
- TC1 (Green): When User = "Exists", show user data.
- TC2 (Yellow): When User = "Not Exists", show "Record Not Found" message.

Test Cases Selected:
- TC1: User Exists = Show User Data
- TC2: User Not Exists = Show "Record Not Found"

Example 6: Button Click Decision (Dashboard Module)
Conditions:
- Button: Valid Button / Invalid Button

Decision Table (Full):
| Condition/Action          | TC1 | TC2 |
|---------------------------|-----|-----|
| Button = Valid?           | Y   | N   |
| Button = Invalid?         | N   | Y   |
| Expected Result           | Button Works | Button Not Works |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 |
|---------------------------|-----|
| Button = Valid?           | Y   |
| Expected Result           | Button Works |

Legend:
- TC1 (Green): When Button = "Valid", button works correctly.

Test Cases Selected:
- TC1: Valid Button = Button Works

BASIC PATH TESTING

Example 1: Add Room (Booking Module)
Simple Path:
1. Enter function
2. Validate inputs (room number, type, bed, price, status)
3. Insert into database
4. Return success

Test Case:
- Valid room number, type, bed, price, status = Room added successfully

Example 2: Update Room Price (Booking Module)
Simple Path:
1. Enter function
2. Find room by number
3. Update price in database
4. Return success

Test Case:
- Room number exists + New valid price = Price updated successfully

Example 3: Delete Room (Booking Module)
Simple Path:
1. Enter function
2. Find room by number
3. Delete from database
4. Return success

Test Case:
- Valid room number = Room deleted successfully

Example 4: Customer Check-In (Customer Module)
Simple Path:
1. Enter function
2. Validate all customer fields
3. Check room availability
4. Insert customer record
5. Return success

Test Case:
- All valid fields + Available room = Check-in successful

Example 5: Calculate Bill (Customer Module)
Simple Path:
1. Get room price
2. Get days stayed
3. Multiply price * days
4. Return amount

Test Case:
- Price = 1500, Days = 3 = Amount = 4500

Example 6: View All Users (Admin Module)
Simple Path:
1. Enter function
2. Query all users from database
3. Display results
4. Return count

Test Case:
- Query all users = Returns count of users

BRANCH TESTING

Example 1: Room Status Branch (Booking Module)
- Branch 1: status == "Not Booked" → can book
- Branch 2: status == "Booked" → cannot book
- Test: Status = "Not Booked", Status = "Booked"

Example 2: Days Validation Branch (Customer Module)
- Branch 1: days <= 0 → set days = 1 (minimum charge)
- Branch 2: days > 0 → use actual days
- Test: Days = 0, Days = 5

Example 3: Customer Status Branch (Customer Module)
- Branch 1: status == "NULL" → customer is checked in
- Branch 2: status == "check out" → customer is checked out
- Test: Status = "NULL", Status = "check out"

Example 4: User Confirmation Branch (Notification System)
- Branch 1: userChoice == YES (0) → proceed with operation
- Branch 2: userChoice == NO (1) → cancel operation
- Test: Choice = 0 (YES), Choice = 1 (NO)

Example 5: Logout Branch (Dashboard Module)
- Branch 1: user confirms YES → logout
- Branch 2: user confirms NO → stay logged in
- Test: Logout YES, Logout NO

Example 6: Exit Branch (Dashboard Module)
- Branch 1: user confirms YES → exit application
- Branch 2: user confirms NO → stay in application
- Test: Exit YES, Exit NO

WHEN TO USE EACH TECHNIQUE FOR QUAN'S MODULES

Use Boundary Value Analysis When:
- Testing room prices (-1, 0, 0.01, 99999.98, 99999.99, 100000)
- Testing mobile numbers (9, 10, 11 digits)
- Testing days stayed (-1, 0, 1, 364, 365, 366)
- Testing string lengths (empty, valid, too long)

Use Equivalence Partitioning When:
- Testing room types (AC, NON AC, invalid)
- Testing bed types (Single, Double, invalid)
- Testing gender values (Male, Female, Other)
- Testing user status (pending, approved, invalid)

Use Decision Table When:
- Testing room booking combinations (status + number + price)
- Testing checkout combinations (status + amount + days)
- Testing notification display (result + action)
- Testing admin status changes (current + desired status)

Use Basic Path Testing When:
- Testing add/update/delete operations (happy path)
- Testing check-in flow (all valid inputs)
- Testing bill calculation (simple math)
- Testing user list display (basic query)

Use Branch Testing When:
- Testing status conditions (Not Booked vs Booked)
- Testing days validation (zero vs positive)
- Testing confirmation dialogs (YES vs NO)
- Testing logout/exit flows (confirm vs cancel)

COMBINING TECHNIQUES FOR QUAN'S MODULES

In practice, we combine techniques for comprehensive coverage:

Example: Room Booking (Booking Module)
- Boundary Value: Test price boundaries (-1, 0, 0.01, 99999.98, 99999.99, 100000)
- Equivalence: Test room types (AC, NON AC, invalid)
- Decision Table: Test combinations (available + valid price = can book)
- Branch: Test status branches (Not Booked → can book, Booked → cannot)

Example: Customer Checkout (Customer Module)
- Boundary Value: Test days boundaries (-1, 0, 1, 364, 365, 366)
- Equivalence: Test amount validation (valid, invalid)
- Decision Table: Test combinations (checked in + valid amount = can checkout)
- Branch: Test status branches (NULL → can checkout, check out → cannot)

This comprehensive approach ensures:
1. All boundary conditions are tested
2. All input types are covered
3. All logical combinations are verified
4. All code paths are executed

