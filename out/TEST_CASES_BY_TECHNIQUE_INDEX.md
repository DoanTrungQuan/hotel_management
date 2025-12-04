# Test Cases by Technique - Index

This directory contains test cases organized by testing technique. Each file lists all test cases that use a specific testing technique.

---

## Files Created

### 1. TEST_CASES_BY_TECHNIQUE_BOUNDARY_VALUE_ANALYSIS.md
**Total Test Cases:** 27
- **Quan's Test Cases:** 11
- **Lam's Test Cases:** 16

**Description:** Contains all test cases that use Boundary Value Analysis technique. These tests focus on boundary values such as minimum, maximum, just below, just above, and typical values within valid ranges.

**Examples:**
- Room price: -1, 0, 0.01, 1500.00
- Mobile number: 9 digits, 10 digits, 11 digits
- Days stayed: -1, 0, 1, 364, 365, 366

---

### 2. TEST_CASES_BY_TECHNIQUE_EQUIVALENCE_PARTITIONING.md
**Total Test Cases:** 51
- **Quan's Test Cases:** 28
- **Lam's Test Cases:** 23

**Description:** Contains all test cases that use Equivalence Partitioning technique. These tests group input values into equivalence classes and test representative values from each class.

**Examples:**
- Room Type: AC, NON AC, LUXURY (invalid)
- Gender: Male, Female, Other
- User Status: approved, panding
- Email: Contains @, No @

---

### 3. TEST_CASES_BY_TECHNIQUE_DECISION_TABLE.md
**Total Test Cases:** 28
- **Quan's Test Cases:** 14
- **Lam's Test Cases:** 14

**Description:** Contains all test cases that use Decision Table technique. These tests cover different combinations of conditions and their corresponding actions based on decision tables.

**Examples:**
- Room Booking Decision: Status (Not Booked/Booked) × Room Number (Valid/Invalid)
- Login Decision: Email (Valid/Invalid) × Password (Valid/Invalid) × Status (approved/panding)
- Payment Calculation Decision: Price > 0 × Days > 0

---

### 4. TEST_CASES_BY_TECHNIQUE_BASIC_PATH_TESTING.md
**Total Test Cases:** 17
- **Quan's Test Cases:** 8
- **Lam's Test Cases:** 9

**Description:** Contains all test cases that use Basic Path Testing technique. These tests cover the basic execution paths through the code, ensuring all statements are executed at least once.

**Examples:**
- Add Room Path: Enter → Validate → Insert → Return
- Login Path: Enter → Validate Email → Validate Password → Check Status → Return
- Calculate Payment Path: Get Price → Get Days → Multiply → Return

---

### 5. TEST_CASES_BY_TECHNIQUE_BRANCH_TESTING.md
**Total Test Cases:** 25
- **Quan's Test Cases:** 13
- **Lam's Test Cases:** 12

**Description:** Contains all test cases that use Branch Testing technique. These tests ensure all branches (true/false paths) of conditional statements are executed.

**Examples:**
- Room Status Branch: If status == "Not Booked" → can book, If status == "Booked" → cannot book
- Login Status Branch: If status == "approved" → can login, If status == "panding" → cannot login
- Logout Confirmation Branch: If YES → logout, If NO → stay logged in

---

## Summary Statistics

| Technique | Total Test Cases | Quan | Lam |
|-----------|-----------------|------|-----|
| Boundary Value Analysis | 27 | 11 | 16 |
| Equivalence Partitioning | 51 | 28 | 23 |
| Decision Table | 28 | 14 | 14 |
| Basic Path Testing | 17 | 8 | 9 |
| Branch Testing | 25 | 13 | 12 |
| **TOTAL** | **148** | **74** | **74** |

*Note: Some test cases may use multiple techniques, so the total may exceed 140 unique test cases.*

---

## File Structure

Each technique file contains:
1. **Header** - Total test cases count and breakdown by developer
2. **QUAN'S TEST CASES** - All test cases from Quan's modules using the technique
3. **LAM'S TEST CASES** - All test cases from Lam's modules using the technique

Each test case entry includes:
- Test Case ID
- Description
- Precondition
- Test Steps
- Test Data
- Expected Result
- Actual Result
- Status
- Comments (showing how the technique is applied)

---

## Usage

These files are useful for:
- Understanding which test cases use which testing techniques
- Reviewing test coverage by technique
- Identifying gaps in testing technique application
- Training on different testing techniques
- Documentation for testing methodology

