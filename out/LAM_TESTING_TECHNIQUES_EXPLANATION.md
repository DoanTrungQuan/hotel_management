Testing Techniques Explanation for Lam

BOUNDARY VALUE ANALYSIS

Example 1: Email Field (Login/Logout Module)
- Empty/Non-empty: Cannot be empty

Example 2: Password Field (Login/Logout Module)
- String length: Minimum 1 character

Example 3: Room Price (Room Management Module)
- Price: 0 -> 99999.99

Example 4: Room Number (Room Management Module)
- Empty/Non-empty: Cannot be empty

Example 5: Payment Amount (Payment and Invoice Module)
- Amount: 0 -> 999999.99

Note: Payment amount is automatically calculated from (room price × days stayed) when searching for a room number in the checkout form. The amount field is read-only and cannot be manually entered.

Example 6: Days Stayed (Payment and Invoice Module)
- Days: 1 -> 365

Note: Days stayed are automatically calculated from check-in date to today when searching for a room number in the checkout form. Zero or negative days are automatically converted to 1 (minimum charge). The days field is automatically filled and cannot be manually entered.

Example 7: Bill ID (Report Generation Module)
- Empty/Non-empty: Cannot be empty

EQUIVALENCE PARTITIONING

Example 1: User Status (Login/Logout Module)
| Stt | Condition   | Valid Number | Invalid Number |
|-----|-------------|--------------|----------------|
| 1   | User Status | "approved" 1 | "active" 3     |
| 2   | User Status | "panding" 2  | "inactive" 4   |
| 3   | User Status | -            | empty 5, null 6 |

Note: When a new user signs up, status is automatically set to "panding" (database default). Admin can double-click on a user in the admin page to change status from "panding" to "approved". Only users with "approved" status can login.

Example 2: Admin Credentials (Login/Logout Module)
| Stt | Condition         | Valid Number                    | Invalid Number                    |
|-----|-------------------|---------------------------------|-----------------------------------|
| 1   | Admin Login       | email="admin", password="admin" 1 | wrong email, wrong password 3     |
| 2   | User Login        | email with @, approved status 2   | pending status 4                  |

Example 3: Room Type (Room Management Module)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Room Type | "AC" 1       | -              |
| 2   | Room Type | "NON AC" 2   | -              |

Note: Room Type is a dropdown selection with only 2 options. Invalid values cannot be entered.

Example 4: Bed Type (Room Management Module)
| Stt | Condition | Valid Number | Invalid Number |
|-----|-----------|--------------|----------------|
| 1   | Bed Type  | "Single" 1   | -              |
| 2   | Bed Type  | "Double" 2   | -              |

Note: Bed Type is a dropdown selection with only 2 options. Invalid values cannot be entered.

Example 5: Payment Calculation (Payment and Invoice Module)
| Stt | Condition         | Valid Number        | Invalid Number        |
|-----|-------------------|---------------------|-----------------------|
| 1   | Payment Calculation | price > 0 AND days > 0 1 | price <= 0 OR days < 0 2 |

Note: Payment calculation is automatic. When searching for a room number in the checkout form, the system automatically:
- Calculates days from check-in date to today
- Converts zero/negative days to 1 (minimum charge)
- Calculates amount as (room price × days)
- Fills the amount and days fields automatically (read-only fields)

Example 6: Bill Status (Report Generation Module)
| Stt | Condition   | Valid Number        | Invalid Number |
|-----|-------------|---------------------|----------------|
| 1   | Bill Status | Bill exists 1       | -              |
| 2   | Bill Status | Bill does not exist 2 | -              |
- Invalid Class: Bill ID empty or null

Test Cases:
- Bill ID = "BILL123" (exists) = Valid - Show bill
- Bill ID = "BILLNONE" (not exists) = Valid - Show error
- Bill ID = "" (empty) = Invalid

Example 7: Email Uniqueness (Database Integrity Module)
Equivalence Classes:
- Valid Class: Unique email (can insert)
- Invalid Class: Duplicate email (cannot insert)

Test Cases:
- Email = "new@test.com" (unique) = Can insert
- Email = "existing@test.com" (duplicate) = Cannot insert

DECISION TABLE
Example 1: Login Decision (Login/Logout Module)
Conditions:
- Email: Valid / Invalid / admin
- Password: Valid / Invalid / admin
- Status: approved / panding

Decision Table (Full):
| Condition/Action      | TC1 | TC2 | TC3 | TC4 | TC5 | TC6 | TC7 | TC8 | TC9 | TC10 | TC11 | TC12 |
|-----------------------|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|------|------|
| Email = Valid?        | Y   | Y   | Y   | Y   | N   | N   | N   | N   | N   | N    | N    | N    |
| Email = Invalid?      | N   | N   | N   | N   | Y   | Y   | Y   | Y   | N   | N    | N    | N    |
| Email = admin?        | N   | N   | N   | N   | N   | N   | N   | N   | Y   | Y    | Y    | Y    |
| Password = Valid?     | Y   | Y   | N   | N   | Y   | Y   | N   | N   | Y   | Y    | N    | N    |
| Password = Invalid?   | N   | N   | Y   | Y   | N   | N   | Y   | Y   | N   | N    | Y    | Y    |
| Password = admin?     | N   | N   | N   | N   | N   | N   | N   | N   | N   | N    | N    | N    |
| Status = approved?    | Y   | N   | Y   | N   | Y   | N   | Y   | N   | Y   | N    | Y    | N    |
| Status = panding?     | N   | Y   | N   | Y   | N   | Y   | N   | Y   | N   | Y    | N    | Y    |
| Expected Result       | Can Login | Cannot | Cannot | Cannot | Cannot | Cannot | Cannot | Cannot | Can Login | Cannot | Cannot | Cannot |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action      | TC1 | TC2 | TC3 | TC4 | TC5 |
|-----------------------|-----|-----|-----|-----|-----|
| Email = Valid?        | Y   | Y   | N   | N   | N   |
| Email = Invalid?      | N   | N   | Y   | N   | N   |
| Email = admin?        | N   | N   | N   | Y   | N   |
| Password = Valid?     | Y   | Y   | Y   | Y   | N   |
| Password = Invalid?   | N   | N   | N   | N   | Y   |
| Status = approved?    | Y   | N   | Y   | Y   | Y   |
| Status = panding?     | N   | Y   | N   | N   | N   |
| Expected Result       | Can Login | Cannot | Cannot | Can Login | Cannot |

Legend:
- TC1 (Green): When Email = "Valid", Password = "Valid", and Status = "approved", only one test case is needed.
- TC2 (Yellow): When Email = "Valid", Password = "Valid", and Status = "panding", only one test case is needed (Cannot Login).
- TC3 (Yellow): When Email = "Invalid", regardless of Password and Status, only one test case is needed (Cannot Login).
- TC4 (Blue): When Email = "admin" and Password = "admin", regardless of Status, only one test case is needed (Can Login as Admin).
- TC5 (Yellow): When Password = "Invalid", regardless of Email and Status, only one test case is needed (Cannot Login).

Test Cases Selected:
- TC1: Valid Email + Valid Password + approved = Can Login
- TC2: Valid Email + Valid Password + panding = Cannot Login
- TC3: Invalid Email = Cannot Login
- TC4: admin + admin = Can Login (Admin)
- TC5: Invalid Password = Cannot Login

Example 2: Room Addition Decision (Room Management Module)
Conditions:
- Room Number: Unique / Duplicate
- Room Type: Valid / Invalid
- Price: Valid / Invalid

Decision Table (Full):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 | TC5 | TC6 | TC7 | TC8 |
|---------------------------|-----|-----|-----|-----|-----|-----|-----|-----|
| Room Number = Unique?     | Y   | Y   | Y   | Y   | N   | N   | N   | N   |
| Room Number = Duplicate?  | N   | N   | N   | N   | Y   | Y   | Y   | Y   |
| Room Type = Valid?        | Y   | Y   | N   | N   | Y   | Y   | N   | N   |
| Room Type = Invalid?      | N   | N   | Y   | Y   | N   | N   | Y   | Y   |
| Price = Valid?            | Y   | N   | Y   | N   | Y   | N   | Y   | N   |
| Price = Invalid?          | N   | Y   | N   | Y   | N   | Y   | N   | Y   |
| Expected Result           | Can Add | Cannot | Cannot | Cannot | Cannot | Cannot | Cannot | Cannot |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 |
|---------------------------|-----|-----|-----|-----|
| Room Number = Unique?     | Y   | Y   | Y   | N   |
| Room Number = Duplicate?  | N   | N   | N   | Y   |
| Room Type = Valid?        | Y   | Y   | N   | Y   |
| Room Type = Invalid?      | N   | N   | Y   | N   |
| Price = Valid?            | Y   | N   | Y   | Y   |
| Price = Invalid?          | N   | Y   | N   | N   |
| Expected Result           | Can Add | Cannot | Cannot | Cannot |

Legend:
- TC1 (Green): When Room Number = "Unique", Room Type = "Valid", and Price = "Valid", only one test case is needed.
- TC2 (Yellow): When Price = "Invalid", regardless of Room Number and Room Type, only one test case is needed (Cannot Add).
- TC3 (Yellow): When Room Type = "Invalid", regardless of Room Number and Price, only one test case is needed (Cannot Add).
- TC4 (Blue): When Room Number = "Duplicate", regardless of Room Type and Price, only one test case is needed (Cannot Add).

Test Cases Selected:
- TC1: Unique Number + Valid Type + Valid Price = Can Add
- TC2: Unique Number + Valid Type + Invalid Price = Cannot Add
- TC3: Unique Number + Invalid Type + Valid Price = Cannot Add
- TC4: Duplicate Number + Valid Type + Valid Price = Cannot Add

Example 3: Checkout Decision (Payment and Invoice Module)
Conditions:
- Customer Status: checked in / checked out
- Amount: Valid / Invalid (automatically calculated)
- Days: Valid / Invalid (automatically calculated)

Note: Amount and days are automatically calculated when searching for a room number. Amount = (room price × days). Days are calculated from check-in date to today. If calculation fails (e.g., invalid price), amount remains empty and checkout is prevented.

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
- TC1: Checked in + Valid Amount + Valid Days = Can Checkout (Amount and days automatically calculated)
- TC2: Checked in + Invalid Amount = Cannot Checkout (Amount calculation failed, e.g., invalid price)
- TC3: Checked in + Invalid Days = Cannot Checkout (Days calculation failed)
- TC4: Checked out = Already Checked Out

Note: Amount and days are automatically calculated when searching for room number. Users cannot manually enter these values.

Example 4: Bill Query Decision (Report Generation Module)
Conditions:
- Bill ID: Valid Format / Invalid Format
- Bill ID: Exists / Not Exists

Decision Table (Full):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 |
|---------------------------|-----|-----|-----|-----|
| Bill ID Format = Valid?   | Y   | Y   | N   | N   |
| Bill ID Format = Invalid? | N   | N   | Y   | Y   |
| Bill ID Exists?           | Y   | N   | Y   | N   |
| Bill ID Not Exists?       | N   | Y   | N   | Y   |
| Expected Result           | Show Bill | Show Error | Show Error | Show Error |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 | TC3 |
|---------------------------|-----|-----|-----|
| Bill ID Format = Valid?   | Y   | Y   | N   |
| Bill ID Format = Invalid? | N   | N   | Y   |
| Bill ID Exists?           | Y   | N   | N   |
| Bill ID Not Exists?       | N   | Y   | Y   |
| Expected Result           | Show Bill | Show Error | Show Error |

Legend:
- TC1 (Green): When Bill ID Format = "Valid" and Bill ID Exists, only one test case is needed.
- TC2 (Yellow): When Bill ID Format = "Valid" and Bill ID Not Exists, only one test case is needed (Show Error).
- TC3 (Blue): When Bill ID Format = "Invalid", regardless of whether it exists, only one test case is needed (Show Error).

Test Cases Selected:
- TC1: Valid Format + Exists = Show Bill Data
- TC2: Valid Format + Not Exists = Show Error
- TC3: Invalid Format = Show Error

Example 5:   (Database Integrity Module)
Conditions:
- Email: Unique / Duplicate
- Room Number: Unique / Duplicate

Decision Table (Full):
| Condition/Action          | TC1 | TC2 | TC3 | TC4 |
|---------------------------|-----|-----|-----|-----|
| Email = Unique?           | Y   | Y   | N   | N   |
| Email = Duplicate?        | N   | N   | Y   | Y   |
| Room Number = Unique?      | Y   | N   | Y   | N   |
| Room Number = Duplicate?  | N   | Y   | N   | Y   |
| Expected Result           | Can Insert | Cannot | Cannot | Cannot |

Decision Table (Reduced - Test Cases Selected):
| Condition/Action          | TC1 | TC2 | TC3 |
|---------------------------|-----|-----|-----|
| Email = Unique?           | Y   | Y   | N   |
| Email = Duplicate?        | N   | N   | Y   |
| Room Number = Unique?      | Y   | N   | Y   |
| Room Number = Duplicate?  | N   | Y   | N   |
| Expected Result           | Can Insert | Cannot | Cannot |

Legend:
- TC1 (Green): When Email = "Unique" and Room Number = "Unique", only one test case is needed.
- TC2 (Yellow): When Room Number = "Duplicate", regardless of Email, only one test case is needed (Cannot Insert Room).
- TC3 (Blue): When Email = "Duplicate", regardless of Room Number, only one test case is needed (Cannot Insert Email).

Test Cases Selected:
- TC1: Unique Email + Unique Room = Can Insert Both
- TC2: Unique Email + Duplicate Room = Cannot Insert Room
- TC3: Duplicate Email + Unique Room = Cannot Insert Email

BASIC PATH TESTING

Example 1: User Login (Login/Logout Module)
- Path: Enter → Validate email format → Validate password → Check user status → Return login result
- Test: Valid email, valid password, approved status

Example 2: Add Room (Room Management Module)
- Path: Enter → Validate all fields → Check duplicate → Insert into database → Return success
- Test: All valid fields + Unique room number

Example 3: Update Room Price (Room Management Module)
- Path: Enter → Find room by number → Update price → Return success
- Test: Room number exists + New valid price

Example 4: Delete Room (Room Management Module)
- Path: Enter → Find room by number → Delete from database → Return success
- Test: Valid room number

Example 5: Calculate Payment (Payment and Invoice Module)
- Path: Search for room number → Get room price → Calculate days from check-in date to today → Multiply price * days → Auto-fill amount field → Return amount
- Test: Price = 1500, Days = 3 (automatically calculated), Amount = 4500 (automatically calculated)
- Note: Amount and days are automatically calculated when searching for room number. Users cannot manually enter these values.

Example 6: Generate Bill (Payment and Invoice Module)
- Path: Get customer details → Get room details → Calculate amount → Generate bill ID → Save bill → Return bill ID
- Test: Valid customer + Valid room + Valid days

Example 7: Get Bill Data (Report Generation Module)
- Path: Enter → Validate bill ID format → Query database → Return bill data
- Test: Valid bill ID

Example 8: Insert User (Database Integrity Module)
- Path: Enter → Validate email uniqueness → Insert into database → Return success
- Test: Unique email + All valid fields

BRANCH TESTING

Example 1: Login Status Branch (Login/Logout Module)
- Branch 1: status == "approved" → can login
- Branch 2: status == "panding" → cannot login

Example 2: Logout Confirmation Branch (Login/Logout Module)
- Branch 1: userChoice == YES (0) → logout
- Branch 2: userChoice == NO (1) → stay logged in

Example 3: Room Status Branch (Room Management Module)
- Branch 1: status == "Not Booked" → can book
- Branch 2: status == "Booked" → cannot book

Example 4: Payment Amount Branch (Payment and Invoice Module)
- Branch 1: amount > 0 → valid payment (automatically calculated)
- Branch 2: amount <= 0 → invalid payment (calculation failed or amount empty)

Note: Amount is automatically calculated from (room price × days) when searching for room number. The amount field is read-only.

Example 5: Days Validation Branch (Payment and Invoice Module)
- Branch 1: days <= 0 → set days = 1 (minimum charge, automatically calculated)
- Branch 2: days > 0 → use actual days (automatically calculated)

Note: Days are automatically calculated from check-in date to today when searching for room number. Zero/negative days are automatically converted to 1 (minimum charge). The days field is automatically filled.

Example 6: Bill Exists Branch (Report Generation Module)
- Branch 1: bill exists → show bill data
- Branch 2: bill not exists → show error

Example 7: Email Uniqueness Branch (Database Integrity Module)
Branches:
- If email unique → can insert
- If email duplicate → cannot insert (error)

Test Cases:
- Unique email → Branch 1 executed (can insert)
- Duplicate email → Branch 2 executed (cannot insert)

WHEN TO USE EACH TECHNIQUE FOR LAM'S MODULES

Use Boundary Value Analysis When:
- Testing email/password fields (empty, 1 character, valid)
- Testing room prices (-1, 0, 0.01, 99999.98, 99999.99, 100000)
- Testing payment amounts (-1, 0, 0.01, 999999.98, 999999.99, 1000000) - Note: Amount is automatically calculated
- Testing days stayed (0, 1, 364, 365, 366) - Note: Days are automatically calculated from check-in date to today
- Testing bill ID format (empty, valid format, invalid)

Use Equivalence Partitioning When:
- Testing user status (approved, pending, invalid)
- Testing room types (AC, NON AC, invalid)
- Testing bed types (Single, Double, invalid)
- Testing bill status (exists, not exists)
- Testing email uniqueness (unique, duplicate)

Use Decision Table When:
- Testing login combinations (email + password + status)
- Testing room addition (number + type + price)
- Testing checkout combinations (status + amount + days)
- Testing bill query (format + existence)
- Testing database constraints (email + room uniqueness)

Use Basic Path Testing When:
- Testing login flow (all valid inputs)
- Testing add/update/delete operations (happy path)
- Testing payment calculation (simple math) - Note: Calculation is automatic when searching for room number
- Testing bill generation (complete flow)
- Testing database insert (all valid)

Use Branch Testing When:
- Testing login status (approved vs pending)
- Testing logout confirmation (YES vs NO)
- Testing room status (Not Booked vs Booked)
- Testing payment validation (valid vs invalid) - Note: Amount is automatically calculated
- Testing days validation (zero vs positive) - Note: Days are automatically calculated, zero converts to 1
- Testing bill existence (found vs not found)
- Testing database constraints (unique vs duplicate)

COMBINING TECHNIQUES FOR LAM'S MODULES

In practice, we combine techniques for comprehensive coverage:

Example: Login (Login/Logout Module)
- Boundary Value: Test email/password boundaries (empty, valid)
- Equivalence: Test status values (approved, pending, invalid)
- Decision Table: Test combinations (email + password + status)
- Branch: Test status branches (approved → can login, pending → cannot)

Example: Payment Checkout (Payment and Invoice Module)
- Boundary Value: Test amount boundaries (-1, 0, 0.01, 999999.98, 999999.99, 1000000) and days (0, 1, 364, 365, 366) - Note: Amount and days are automatically calculated
- Equivalence: Test calculation types (valid, invalid) - Note: Calculation is automatic when searching for room number
- Decision Table: Test combinations (checked in + valid amount = can checkout) - Note: Amount and days are auto-calculated
- Branch: Test amount branches (positive → valid, zero → invalid) - Note: Amount is auto-calculated, cannot be manually entered

This comprehensive approach ensures:
1. All boundary conditions are tested
2. All input types are covered
3. All logical combinations are verified
4. All code paths are executed