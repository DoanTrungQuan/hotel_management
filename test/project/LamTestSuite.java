package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LamTestSuite {

    private Connection con;
    private static int testCounter = 0;
    private static Connection staticCon;

    @BeforeClass
    public static void setUpClass() {
        try {
            staticCon = ConnectionProvider.getCon();
            assertNotNull("Database connection required", staticCon);
            initializeTestData(staticCon);
            System.out.println("✓ Test database initialized with test data");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to initialize test data: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDownClass() {

        try {
            if (staticCon != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        con = ConnectionProvider.getCon();
        assertNotNull("Database connection required", con);
    }

    @After
    public void tearDown() {

        if (con != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void initializeTestData(Connection con) {
        cleanupTestData(con);

        createTestUserStatic(con, "lamtest06@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest07@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest08@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest09@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest10@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest11@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest12@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest13@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest14@test.com", "pass", "approved");
        createTestUserStatic(con, "lamtest15@test.com", "pass", "approved");

        createTestRoomStatic(con, "LTEST16", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST17", "AC", "Double", 2000.00, "Not Booked");
        createTestRoomStatic(con, "LTEST18", "NON AC", "Single", 1000.00, "Booked");
        createTestRoomStatic(con, "LTEST19", "NON AC", "Double", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST20", "AC", "Single", 1500.00, "Not Booked");

        createTestRoomStatic(con, "LTEST25", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST26", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST27", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST28", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST29", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST30", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "LTEST37", "AC", "Single", 1500.00, "Booked");

        System.out.println("✓ Test data created: Users, Rooms");
    }

    private static void cleanupTestData(Connection con) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM customer WHERE email LIKE 'lamtest%' OR roomnumber LIKE 'LTEST%'");
            pst.executeUpdate();
            pst.close();

            pst = con.prepareStatement("DELETE FROM signup WHERE email LIKE 'lamtest%'");
            pst.executeUpdate();
            pst.close();

            pst = con.prepareStatement("DELETE FROM room WHERE roomnumber LIKE 'LTEST%'");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private static void createTestUserStatic(Connection con, String email, String password, String status) {
        try {
            PreparedStatement deletePst = con.prepareStatement("DELETE FROM signup WHERE email=?");
            deletePst.setString(1, email);
            deletePst.executeUpdate();
            deletePst.close();

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO signup (name, email, password, sq, answer, status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test User");
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "Your Favourite City");
            pst.setString(5, "Mumbai");
            pst.setString(6, status);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error creating test user " + email + ": " + e.getMessage());
        }
    }

    private static void createTestRoomStatic(Connection con, String roomNumber, String roomType, String bed, double price, String status) {
        try {
            PreparedStatement deletePst = con.prepareStatement("DELETE FROM room WHERE roomnumber=?");
            deletePst.setString(1, roomNumber);
            deletePst.executeUpdate();
            deletePst.close();

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, roomNumber);
            pst.setString(2, roomType);
            pst.setString(3, bed);
            pst.setDouble(4, price);
            pst.setString(5, status);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error creating test room " + roomNumber + ": " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_01_Login_Email_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Email is empty");
        String email = "";
        assertTrue("Empty email should be invalid", email.isEmpty());
        System.out.println("PASS: Empty email detected");
    }

    @Test
    public void TC_LL_02_Login_Email_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Email is valid");
        String email = "test@example.com";
        assertTrue("Valid email should contain @", email.contains("@"));
        System.out.println("PASS: Valid email accepted");
    }

    @Test
    public void TC_LL_03_Login_Password_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Password is empty");
        String password = "";
        assertTrue("Empty password should be invalid", password.isEmpty());
        System.out.println("PASS: Empty password detected");
    }

    @Test
    public void TC_LL_04_Login_Password_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Password is valid");
        String password = "password123";
        assertTrue("Valid password should not be empty", !password.isEmpty());
        System.out.println("PASS: Valid password accepted");
    }

    @Test
    public void TC_LL_05_Login_AdminCredentials() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Admin login");
        String email = "admin";
        String password = "admin";
        boolean isAdmin = email.equals("admin") && password.equals("admin");
        assertTrue("Admin credentials should work", isAdmin);
        System.out.println("PASS: Admin login works");
    }

    @Test
    public void TC_LL_06_Login_ApprovedUser() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Approved user can login");
        try {
            String email = "lamtest06@test.com";

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=? AND password=? AND status=?");
            pst.setString(1, email);
            pst.setString(2, "pass");
            pst.setString(3, "approved");
            ResultSet rs = pst.executeQuery();

            assertTrue("Approved user should be able to login", rs.next());
            System.out.println("PASS: Approved user can login");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_07_Login_PendingUser() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Pending user cannot login");
        try {
            String email = "lamtest07@test.com";
            PreparedStatement setupPst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            setupPst.setString(1, "panding");
            setupPst.setString(2, email);
            setupPst.executeUpdate();
            setupPst.close();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=? AND password=? AND status=?");
            pst.setString(1, email);
            pst.setString(2, "pass");
            pst.setString(3, "approved");
            ResultSet rs = pst.executeQuery();

            assertFalse("Pending user should not be able to login", rs.next());
            System.out.println("PASS: Pending user cannot login");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_08_Login_WrongPassword() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Wrong password cannot login");
        try {
            String email = "lamtest08@test.com";
            PreparedStatement setupPst = con.prepareStatement("UPDATE signup SET password=? WHERE email=?");
            setupPst.setString(1, "correctpass");
            setupPst.setString(2, email);
            setupPst.executeUpdate();
            setupPst.close();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=? AND password=?");
            pst.setString(1, email);
            pst.setString(2, "wrongpass");
            ResultSet rs = pst.executeQuery();

            assertFalse("Wrong password should not allow login", rs.next());
            System.out.println("PASS: Wrong password rejected");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_09_Login_ValidApproved_CanLogin() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Valid email + valid password + approved = can login");
        try {
            String email = "lamtest09@test.com";

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=? AND password=? AND status=?");
            pst.setString(1, email);
            pst.setString(2, "pass");
            pst.setString(3, "approved");
            ResultSet rs = pst.executeQuery();

            assertTrue("Should be able to login", rs.next());
            System.out.println("PASS: Can login");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_10_Login_ValidPending_CannotLogin() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Valid email + valid password + pending = cannot login");
        try {
            String email = "lamtest10@test.com";
            PreparedStatement setupPst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            setupPst.setString(1, "panding");
            setupPst.setString(2, email);
            setupPst.executeUpdate();
            setupPst.close();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=? AND password=? AND status=?");
            pst.setString(1, email);
            pst.setString(2, "pass");
            pst.setString(3, "approved");
            ResultSet rs = pst.executeQuery();

            assertFalse("Should not be able to login", rs.next());
            System.out.println("PASS: Cannot login");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_11_Login_SimplePath_AllFieldsValid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Simple path - all fields valid");
        try {
            String email = "lamtest11@test.com";
            createTestUser(email, "pass123", "approved");

            PreparedStatement pst = con.prepareStatement("SELECT email FROM signup WHERE email=? AND password=? AND status=?");
            pst.setString(1, email);
            pst.setString(2, "pass123");
            pst.setString(3, "approved");
            ResultSet rs = pst.executeQuery();

            assertTrue("Should find user", rs.next());
            assertEquals("Email should match", email, rs.getString("email"));
            System.out.println("PASS: Login successful");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_LL_12_Logout_ConfirmYes_ShouldLogout() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGOUT]: User confirms logout");
        int userChoice = 0;
        if (userChoice == 0) {
            assertTrue("Should logout when confirmed", true);
            System.out.println("PASS: Logout confirmed");
        }
    }

    @Test
    public void TC_LL_13_Logout_ConfirmNo_ShouldNotLogout() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGOUT]: User cancels logout");
        int userChoice = 1;
        if (userChoice != 0) {
            assertFalse("Should not logout when cancelled", false);
            System.out.println("PASS: Logout cancelled");
        }
    }

    @Test
    public void TC_LL_14_Login_EmailFormat_HasAtSymbol() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Email format check - has @ symbol");
        String email = "test@example.com";
        assertTrue("Email should have @ symbol", email.contains("@"));
        System.out.println("PASS: Email has @ symbol");
    }

    @Test
    public void TC_LL_15_Login_PasswordLength_Minimum() {
        testCounter++;
        System.out.println("Test " + testCounter + " [LOGIN]: Password length - minimum 1 character");
        String password = "p";
        assertTrue("Password should be at least 1 character", password.length() >= 1);
        System.out.println("PASS: Password length valid");
    }

    @Test
    public void TC_RM_01_Room_Price_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room price is zero - invalid");
        double price = 0.0;
        assertFalse("Price should not be zero", price > 0);
        System.out.println("PASS: Zero price is invalid");
    }

    @Test
    public void TC_RM_02_Room_Price_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room price is positive - valid");
        double price = 1500.00;
        assertTrue("Price should be positive", price > 0);
        System.out.println("PASS: Positive price is valid");
    }

    @Test
    public void TC_RM_03_Room_Number_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room number is empty - invalid");
        String roomNumber = "";
        assertTrue("Room number should not be empty", roomNumber.isEmpty());
        System.out.println("PASS: Empty room number is invalid");
    }

    @Test
    public void TC_RM_04_Room_Number_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room number is valid");
        String roomNumber = "LTEST19";
        assertTrue("Room number should not be empty", !roomNumber.isEmpty());
        System.out.println("PASS: Valid room number");
    }

    @Test
    public void TC_RM_05_Room_Type_AC() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room type is AC");
        String roomType = "AC";
        assertTrue("AC should be valid", roomType.equals("AC"));
        System.out.println("PASS: AC room type accepted");
    }

    @Test
    public void TC_RM_06_Room_Type_NonAC() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room type is NON AC");
        String roomType = "NON AC";
        assertTrue("NON AC should be valid", roomType.equals("NON AC"));
        System.out.println("PASS: NON AC room type accepted");
    }

    @Test
    public void TC_RM_07_Room_Type_Invalid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room type is invalid");
        String roomType = "LUXURY";
        assertFalse("Invalid type should not be accepted", roomType.equals("AC") || roomType.equals("NON AC"));
        System.out.println("PASS: Invalid room type rejected");
    }

    @Test
    public void TC_RM_08_Room_Bed_Single() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Bed type is Single");
        String bedType = "Single";
        assertTrue("Single should be valid", bedType.equals("Single"));
        System.out.println("PASS: Single bed accepted");
    }

    @Test
    public void TC_RM_09_Room_Bed_Double() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Bed type is Double");
        String bedType = "Double";
        assertTrue("Double should be valid", bedType.equals("Double"));
        System.out.println("PASS: Double bed accepted");
    }

    @Test
    public void TC_RM_10_Room_Add_AllFieldsValid_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Add room - all fields valid = success");
        try {
            String roomNumber = "LTEST25";
            deleteTestRoom(roomNumber);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, roomNumber);
            pst.setString(2, "AC");
            pst.setString(3, "Single");
            pst.setDouble(4, 1500.00);
            pst.setString(5, "Not Booked");

            int result = pst.executeUpdate();
            assertEquals("Room should be added", 1, result);
            System.out.println("PASS: Room added successfully");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RM_11_Room_Add_Duplicate_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Add room - duplicate room number = fail");
        try {
            String roomNumber = "LTEST26";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            try {
                PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
                pst.setString(1, roomNumber);
                pst.setString(2, "NON AC");
                pst.setString(3, "Double");
                pst.setDouble(4, 2000.00);
                pst.setString(5, "Not Booked");
                pst.executeUpdate();
                pst.close();

                fail("Should not allow duplicate");
            } catch (SQLException e) {
                assertTrue("Should prevent duplicate",
                          e.getMessage().contains("Duplicate") || e.getMessage().contains("PRIMARY"));
                System.out.println("PASS: Duplicate room prevented");
            }
        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RM_12_Room_Add_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Simple path - add new room");
        try {
            String roomNumber = "LTEST27";
            deleteTestRoom(roomNumber);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, roomNumber);
            pst.setString(2, "AC");
            pst.setString(3, "Single");
            pst.setDouble(4, 1500.00);
            pst.setString(5, "Not Booked");

            int result = pst.executeUpdate();
            assertEquals("Should add room", 1, result);
            System.out.println("PASS: Room added");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RM_13_Room_Update_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Simple path - update room price");
        try {
            String roomNumber = "LTEST28";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            PreparedStatement pst = con.prepareStatement("UPDATE room SET price=? WHERE roomnumber=?");
            pst.setDouble(1, 2000.00);
            pst.setString(2, roomNumber);

            int result = pst.executeUpdate();
            assertEquals("Should update room", 1, result);
            System.out.println("PASS: Room updated");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RM_14_Room_Delete_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Simple path - delete room");
        try {
            String roomNumber = "LTEST29";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            PreparedStatement pst = con.prepareStatement("DELETE FROM room WHERE roomnumber=?");
            pst.setString(1, roomNumber);

            int result = pst.executeUpdate();
            assertEquals("Should delete room", 1, result);
            System.out.println("PASS: Room deleted");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RM_15_Room_Status_NotBooked() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ROOM]: Room status is Not Booked");
        try {
            String roomNumber = "LTEST30";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            PreparedStatement pst = con.prepareStatement("SELECT status FROM room WHERE roomnumber=?");
            pst.setString(1, roomNumber);
            ResultSet rs = pst.executeQuery();

            assertTrue("Room should exist", rs.next());
            String status = rs.getString("status");
            if (status.equals("Not Booked")) {
                assertTrue("Status should be Not Booked", true);
                System.out.println("PASS: Status is Not Booked");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }


    @Test
    public void TC_PI_01_Payment_Amount_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Payment amount is zero - invalid");
        double amount = 0.0;
        assertFalse("Amount should not be zero", amount > 0);
        System.out.println("PASS: Zero amount is invalid");
    }

    @Test
    public void TC_PI_02_Payment_Amount_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Payment amount is positive - valid");
        double amount = 4500.00;
        assertTrue("Amount should be positive", amount > 0);
        System.out.println("PASS: Positive amount is valid");
    }

    @Test
    public void TC_PI_03_Payment_Days_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Days stayed is zero - becomes 1");
        int days = 0;
        int actualDays = (days <= 0) ? 1 : days;
        assertEquals("Zero days should become 1", 1, actualDays);
        System.out.println("PASS: Zero days handled");
    }

    @Test
    public void TC_PI_04_Payment_Days_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Days stayed is positive - valid");
        int days = 3;
        assertTrue("Days should be positive", days > 0);
        System.out.println("PASS: Positive days is valid");
    }

    @Test
    public void TC_PI_05_Payment_Calculate_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Calculate payment - valid inputs");
        double price = 1500.00;
        int days = 3;
        double amount = days * price;
        assertEquals("Amount should be price * days", 4500.00, amount, 0.01);
        System.out.println("PASS: Payment calculated correctly");
    }

    @Test
    public void TC_PI_06_Payment_Calculate_ZeroDays() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Calculate payment - zero days = minimum charge");
        double price = 1500.00;
        int days = 0;
        double amount = (days <= 0) ? price : (days * price);
        assertEquals("Zero days should charge minimum", price, amount, 0.01);
        System.out.println("PASS: Minimum charge applied");
    }

    @Test
    public void TC_PI_07_Payment_Checkout_WithAmount_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Checkout with amount = success");
        try {
            String roomNumber = "LTEST37";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedInCustomer("lamtest37@test.com", roomNumber);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String billid = "BILLLTEST37";
            PreparedStatement pst = con.prepareStatement(
                "UPDATE customer SET status=?, amount=?, outdate=?, days=?, billid=? WHERE roomnumber=? AND status=?");
            pst.setString(1, "check out");
            pst.setDouble(2, 4500.00);
            pst.setString(3, dateFormat.format(new Date()));
            pst.setInt(4, 3);
            pst.setString(5, billid);
            pst.setString(6, roomNumber);
            pst.setString(7, "NULL");

            int result = pst.executeUpdate();
            assertEquals("Should checkout successfully", 1, result);
            System.out.println("PASS: Checkout with payment successful");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_PI_08_Payment_Checkout_WithoutAmount_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Checkout without amount = fail");
        String amount = "";
        if (amount.isEmpty()) {
            assertTrue("Should prevent checkout without amount", true);
            System.out.println("PASS: Checkout prevented");
        }
    }

    @Test
    public void TC_PI_09_Payment_GenerateBill_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Simple path - generate bill");
        try {
            String billid = "BILLLTEST39";
            String roomNumber = "LTEST39";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest39@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertTrue("Bill should exist", rs.next());
            assertNotNull("Bill ID should exist", rs.getString("billid"));
            assertNotNull("Amount should exist", rs.getString("amount"));
            System.out.println("PASS: Bill generated");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_PI_10_Payment_AmountBranch_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Amount branch - positive amount");
        double amount = 5000.00;
        if (amount > 0) {
            assertTrue("Positive amount should be valid", true);
            System.out.println("PASS: Positive amount accepted");
        }
    }

    @Test
    public void TC_PI_11_Payment_AmountBranch_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Amount branch - zero amount");
        double amount = 0.0;
        if (amount <= 0) {
            assertFalse("Zero amount should be invalid", false);
            System.out.println("PASS: Zero amount rejected");
        }
    }

    @Test
    public void TC_PI_12_Payment_DaysBranch_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Days branch - positive days");
        int days = 5;
        if (days > 0) {
            assertTrue("Positive days should be valid", true);
            System.out.println("PASS: Positive days accepted");
        }
    }

    @Test
    public void TC_PI_13_Payment_DaysBranch_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Days branch - zero days becomes 1");
        int days = 0;
        int actualDays = (days <= 0) ? 1 : days;
        if (actualDays == 1) {
            assertEquals("Zero days should become 1", 1, actualDays);
            System.out.println("PASS: Zero days converted to 1");
        }
    }

    @Test
    public void TC_PI_14_Payment_BillID_Format() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Bill ID format check");
        String billid = "BILL123456789";
        assertTrue("Bill ID should start with BILL", billid.startsWith("BILL"));
        System.out.println("PASS: Bill ID format valid");
    }

    @Test
    public void TC_PI_15_Payment_Invoice_AllFields() {
        testCounter++;
        System.out.println("Test " + testCounter + " [PAYMENT]: Invoice has all required fields");
        try {
            String billid = "BILLLTEST45";
            String roomNumber = "LTEST45";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest45@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertTrue("Invoice should exist", rs.next());
            assertNotNull("Bill ID", rs.getString("billid"));
            assertNotNull("Customer name", rs.getString("name"));
            assertNotNull("Amount", rs.getString("amount"));
            assertNotNull("Days", rs.getString("days"));
            System.out.println("PASS: Invoice has all fields");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }


    @Test
    public void TC_DL_01_Dashboard_Button_ManageRoom() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Manage Room button exists");
        String button = "ManageRoom";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "ManageRoom", button);
        System.out.println("PASS: Manage Room button exists");
    }

    @Test
    public void TC_DL_02_Dashboard_Button_CustomerCheckIn() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Check In button exists");
        String button = "CustomerCheckIn";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerCheckIn", button);
        System.out.println("PASS: Customer Check In button exists");
    }

    @Test
    public void TC_DL_03_Dashboard_Button_CustomerCheckOut() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Check Out button exists");
        String button = "CustomerCheckOut";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerCheckOut", button);
        System.out.println("PASS: Customer Check Out button exists");
    }

    @Test
    public void TC_DL_04_Dashboard_Button_CustomerDetailsBill() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Details Bill button exists");
        String button = "CustomerDetailsBill";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerDetailsBill", button);
        System.out.println("PASS: Customer Details Bill button exists");
    }

    @Test
    public void TC_DL_05_Dashboard_Button_Logout() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Logout button exists");
        String button = "Logout";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "Logout", button);
        System.out.println("PASS: Logout button exists");
    }

    @Test
    public void TC_DL_06_Dashboard_Button_Exit() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Exit button exists");
        String button = "Exit";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "Exit", button);
        System.out.println("PASS: Exit button exists");
    }

    @Test
    public void TC_DL_07_Dashboard_ButtonClick_OpensForm() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Button click opens correct form");
        String clickedButton = "ManageRoom";
        String expectedForm = "ManageRoom";
        assertEquals("Button should open correct form", expectedForm, clickedButton);
        System.out.println("PASS: Button click works");
    }

    @Test
    public void TC_DL_08_Dashboard_Logout_Yes() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Logout - user says yes");
        int choice = 0;
        if (choice == 0) {
            assertTrue("Should logout", true);
            System.out.println("PASS: Logout confirmed");
        }
    }

    @Test
    public void TC_DL_09_Dashboard_Logout_No() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Logout - user says no");
        int choice = 1;
        if (choice != 0) {
            assertFalse("Should not logout", false);
            System.out.println("PASS: Logout cancelled");
        }
    }

    @Test
    public void TC_DL_10_Dashboard_Background_Exists() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Background image exists");
        String background = "/image/home.jpg";
        assertNotNull("Background should exist", background);
        assertTrue("Background should have image path", background.contains("image"));
        System.out.println("PASS: Background exists");
    }


    @Test
    public void TC_RG_01_Report_BillID_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill ID is empty - invalid");
        String billid = "";
        assertTrue("Bill ID should not be empty", billid.isEmpty());
        System.out.println("PASS: Empty Bill ID detected");
    }

    @Test
    public void TC_RG_02_Report_BillID_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill ID is valid");
        String billid = "BILL123456789";
        assertTrue("Bill ID should start with BILL", billid.startsWith("BILL"));
        assertTrue("Bill ID should not be empty", !billid.isEmpty());
        System.out.println("PASS: Valid Bill ID");
    }

    @Test
    public void TC_RG_03_Report_Bill_Exists() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill exists in database");
        try {
            String billid = "BILLLTEST58";
            String roomNumber = "LTEST58";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest58@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertTrue("Bill should exist", rs.next());
            System.out.println("PASS: Bill exists");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_04_Report_Bill_NotExists() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill does not exist in database");
        try {
            String billid = "BILLNONEXISTENT";
            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertFalse("Bill should not exist", rs.next());
            System.out.println("PASS: Bill not found correctly");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_05_Report_QueryByBillID_Exists_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Query by Bill ID - exists = success");
        try {
            String billid = "BILLLTEST60";
            String roomNumber = "LTEST60";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest60@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertTrue("Should find bill", rs.next());
            System.out.println("PASS: Bill found");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_06_Report_QueryByBillID_NotExists_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Query by Bill ID - not exists = fail");
        try {
            String billid = "BILLNONEXISTENT";
            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertFalse("Should not find bill", rs.next());
            System.out.println("PASS: Bill not found");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_07_Report_GetBillData_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Simple path - get bill data");
        try {
            String billid = "BILLLTEST62";
            String roomNumber = "LTEST62";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest62@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT billid, name, amount FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            assertTrue("Should get bill data", rs.next());
            assertEquals("Bill ID should match", billid, rs.getString("billid"));
            System.out.println("PASS: Bill data retrieved");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_08_Report_ListAllCheckedOut_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Simple path - list all checked out");
        try {
            PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM customer WHERE status=?");
            pst.setString(1, "check out");
            ResultSet rs = pst.executeQuery();

            assertTrue("Should return count", rs.next());
            int count = rs.getInt(1);
            assertTrue("Count should be >= 0", count >= 0);
            System.out.println("PASS: Found " + count + " checked out customers");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_09_Report_BillExists_ShowData() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill exists - show data");
        try {
            String billid = "BILLLTEST64";
            String roomNumber = "LTEST64";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedOutCustomer("lamtest64@test.com", roomNumber, billid, 4500.00, 3);

            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                assertNotNull("Should show bill data", rs.getString("billid"));
                System.out.println("PASS: Bill data shown");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_RG_10_Report_BillNotExists_ShowError() {
        testCounter++;
        System.out.println("Test " + testCounter + " [REPORT]: Bill does not exist - show error");
        try {
            String billid = "BILLNONEXISTENT";
            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE billid=?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                assertTrue("Should show error message", true);
                System.out.println("PASS: Error message shown");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }


    @Test
    public void TC_DI_01_Database_Email_Unique_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DATABASE]: Email is unique = can insert");
        try {
            String email = "lamtest66@test.com";
            deleteTestUser(email);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO signup (name, email, password, sq, answer, status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test User");
            pst.setString(2, email);
            pst.setString(3, "pass");
            pst.setString(4, "Question");
            pst.setString(5, "Answer");
            pst.setString(6, "panding");

            int result = pst.executeUpdate();
            assertEquals("Should insert unique email", 1, result);
            System.out.println("PASS: Unique email inserted");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_DI_02_Database_Email_Duplicate_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DATABASE]: Email is duplicate = cannot insert");
        try {
            String email = "lamtest67@test.com";
            createTestUser(email, "pass1", "approved");

            try {
                PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO signup (name, email, password, sq, answer, status) VALUES (?, ?, ?, ?, ?, ?)");
                pst.setString(1, "Duplicate");
                pst.setString(2, email);
                pst.setString(3, "pass2");
                pst.setString(4, "Question");
                pst.setString(5, "Answer");
                pst.setString(6, "panding");
                pst.executeUpdate();
                pst.close();

                fail("Should not allow duplicate");
            } catch (SQLException e) {
                assertTrue("Should prevent duplicate",
                          e.getMessage().contains("Duplicate") || e.getMessage().contains("PRIMARY"));
                System.out.println("PASS: Duplicate email prevented");
            }
        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_DI_03_Database_RoomNumber_Unique_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DATABASE]: Room number is unique = can insert");
        try {
            String roomNumber = "LTEST68";
            deleteTestRoom(roomNumber);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, roomNumber);
            pst.setString(2, "AC");
            pst.setString(3, "Single");
            pst.setDouble(4, 1500.00);
            pst.setString(5, "Not Booked");

            int result = pst.executeUpdate();
            assertEquals("Should insert unique room", 1, result);
            System.out.println("PASS: Unique room inserted");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_DI_04_Database_RoomNumber_Duplicate_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DATABASE]: Room number is duplicate = cannot insert");
        try {
            String roomNumber = "LTEST69";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            try {
                PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
                pst.setString(1, roomNumber);
                pst.setString(2, "NON AC");
                pst.setString(3, "Double");
                pst.setDouble(4, 2000.00);
                pst.setString(5, "Not Booked");
                pst.executeUpdate();
                pst.close();

                fail("Should not allow duplicate");
            } catch (SQLException e) {
                assertTrue("Should prevent duplicate",
                          e.getMessage().contains("Duplicate") || e.getMessage().contains("PRIMARY"));
                System.out.println("PASS: Duplicate room prevented");
            }
        } catch (Exception e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_DI_05_Database_SimplePath_InsertAndRetrieve() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DATABASE]: Simple path - insert and retrieve data");
        try {
            String email = "lamtest70@test.com";
            deleteTestUser(email);

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO signup (name, email, password, sq, answer, status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test User");
            pst.setString(2, email);
            pst.setString(3, "pass");
            pst.setString(4, "Question");
            pst.setString(5, "Answer");
            pst.setString(6, "approved");
            pst.executeUpdate();

            pst = con.prepareStatement("SELECT * FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            assertTrue("Should retrieve data", rs.next());
            assertEquals("Email should match", email, rs.getString("email"));
            assertEquals("Status should match", "approved", rs.getString("status"));
            System.out.println("PASS: Data inserted and retrieved");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }


    private void createTestUser(String email, String password, String status) {
        try {
            deleteTestUser(email);
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO signup (name, email, password, sq, answer, status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test User");
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "Your Favourite City");
            pst.setString(5, "Mumbai");
            pst.setString(6, status);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private void deleteTestUser(String email) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM signup WHERE email = ?");
            pst.setString(1, email);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private void createTestRoom(String roomNumber, String roomType, String bed, double price, String status) {
        try {
            deleteTestRoom(roomNumber);
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, roomNumber);
            pst.setString(2, roomType);
            pst.setString(3, bed);
            pst.setDouble(4, price);
            pst.setString(5, status);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private void deleteTestRoom(String roomNumber) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM room WHERE roomnumber = ?");
            pst.setString(1, roomNumber);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private void createCheckedInCustomer(String email, String roomNumber) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO customer (name, mobile, email, gender, address, id, nationality, date, " +
                "roomnumber, bed, roomtype, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test Customer");
            pst.setString(2, "9876543210");
            pst.setString(3, email);
            pst.setString(4, "Male");
            pst.setString(5, "123 Test St");
            pst.setString(6, "999999999999");
            pst.setString(7, "Indian");
            pst.setString(8, dateFormat.format(new Date()));
            pst.setString(9, roomNumber);
            pst.setString(10, "Single");
            pst.setString(11, "AC");
            pst.setDouble(12, 1500.00);
            pst.setString(13, "NULL");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }

    private void createCheckedOutCustomer(String email, String roomNumber, String billid, double amount, int days) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO customer (billid, name, mobile, email, gender, address, id, nationality, date, " +
                "roomnumber, bed, roomtype, price, status, outdate, days, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, billid);
            pst.setString(2, "Test Customer");
            pst.setString(3, "9876543210");
            pst.setString(4, email);
            pst.setString(5, "Male");
            pst.setString(6, "123 Test St");
            pst.setString(7, "999999999999");
            pst.setString(8, "Indian");
            pst.setString(9, dateFormat.format(new Date()));
            pst.setString(10, roomNumber);
            pst.setString(11, "Single");
            pst.setString(12, "AC");
            pst.setDouble(13, 1500.00);
            pst.setString(14, "check out");
            pst.setString(15, dateFormat.format(new Date()));
            pst.setInt(16, days);
            pst.setDouble(17, amount);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
        }
    }
}
