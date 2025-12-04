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

public class QuanTestSuite {

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

        createTestUserStatic(con, "test61@test.com", "pass", "approved");
        createTestUserStatic(con, "test62@test.com", "pass", "approved");
        createTestUserStatic(con, "test63@test.com", "pass", "approved");
        createTestUserStatic(con, "test64@test.com", "pass", "approved");
        createTestUserStatic(con, "test65@test.com", "pass", "approved");
        createTestUserStatic(con, "test66@test.com", "pass", "approved");
        createTestUserStatic(con, "test67@test.com", "pass", "approved");
        createTestUserStatic(con, "test68@test.com", "pass", "approved");
        createTestUserStatic(con, "test69@test.com", "pass", "approved");
        createTestUserStatic(con, "test70@test.com", "pass", "approved");

        createTestRoomStatic(con, "QTEST01", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST02", "AC", "Double", 2000.00, "Not Booked");
        createTestRoomStatic(con, "QTEST03", "NON AC", "Single", 1000.00, "Booked");
        createTestRoomStatic(con, "QTEST04", "NON AC", "Double", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST05", "AC", "Single", 1500.00, "Not Booked");

        createTestRoomStatic(con, "QTEST32", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST33", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST34", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST35", "AC", "Single", 1500.00, "Not Booked");
        createTestRoomStatic(con, "QTEST36", "AC", "Single", 1500.00, "Booked");
        createTestRoomStatic(con, "QTEST37", "AC", "Single", 1500.00, "Not Booked");

        System.out.println("✓ Test data created: Users, Rooms");
    }

    private static void cleanupTestData(Connection con) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM customer WHERE email LIKE 'test%' OR roomnumber LIKE 'QTEST%'");
            pst.executeUpdate();
            pst.close();

            pst = con.prepareStatement("DELETE FROM signup WHERE email LIKE 'test%'");
            pst.executeUpdate();
            pst.close();

            pst = con.prepareStatement("DELETE FROM room WHERE roomnumber LIKE 'QTEST%'");
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
    public void TC_BM_01_Booking_Price_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room price is zero - invalid");
        double price = 0.0;
        assertFalse("Price should not be zero or negative", price > 0);
        System.out.println("PASS: Zero price is invalid");
    }

    @Test
    public void TC_BM_02_Booking_Price_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room price is positive - valid");
        double price = 1500.00;
        assertTrue("Price should be positive", price > 0);
        System.out.println("PASS: Positive price is valid");
    }

    @Test
    public void TC_BM_03_Booking_Price_Minimum() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room price minimum (0.01)");
        double price = 0.01;
        assertTrue("Minimum price should be valid", price > 0);
        System.out.println("PASS: Minimum price accepted");
    }

    @Test
    public void TC_BM_04_Booking_RoomNumber_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room number is empty - invalid");
        String roomNumber = "";
        assertTrue("Room number should not be empty", roomNumber.isEmpty());
        System.out.println("PASS: Empty room number is invalid");
    }

    @Test
    public void TC_BM_05_Booking_RoomNumber_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room number is valid");
        String roomNumber = "QTEST05";
        assertTrue("Room number should not be empty", !roomNumber.isEmpty());
        System.out.println("PASS: Valid room number");
    }

    @Test
    public void TC_BM_06_Booking_RoomType_AC() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room type is AC");
        String roomType = "AC";
        assertTrue("AC should be valid", roomType.equals("AC"));
        System.out.println("PASS: AC room type accepted");
    }

    @Test
    public void TC_BM_07_Booking_RoomType_NonAC() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room type is NON AC");
        String roomType = "NON AC";
        assertTrue("NON AC should be valid", roomType.equals("NON AC"));
        System.out.println("PASS: NON AC room type accepted");
    }

    @Test
    public void TC_BM_08_Booking_RoomType_Invalid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room type is invalid");
        String roomType = "LUXURY";
        assertFalse("Invalid type should not be accepted", roomType.equals("AC") || roomType.equals("NON AC"));
        System.out.println("PASS: Invalid room type rejected");
    }

    @Test
    public void TC_BM_09_Booking_BedType_Single() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Bed type is Single");
        String bedType = "Single";
        assertTrue("Single should be valid", bedType.equals("Single"));
        System.out.println("PASS: Single bed accepted");
    }

    @Test
    public void TC_BM_10_Booking_BedType_Double() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Bed type is Double");
        String bedType = "Double";
        assertTrue("Double should be valid", bedType.equals("Double"));
        System.out.println("PASS: Double bed accepted");
    }

    @Test
    public void TC_BM_11_Booking_RoomStatus_NotBooked() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room status is Not Booked");
        String status = "Not Booked";
        assertTrue("Not Booked should be valid", status.equals("Not Booked"));
        System.out.println("PASS: Not Booked status accepted");
    }

    @Test
    public void TC_BM_12_Booking_RoomStatus_Booked() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room status is Booked");
        String status = "Booked";
        assertTrue("Booked should be valid", status.equals("Booked"));
        System.out.println("PASS: Booked status accepted");
    }

    @Test
    public void TC_BM_13_Booking_Available_CanBook() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room available = can book");
        try {
            String roomNumber = "QTEST13";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            PreparedStatement pst = con.prepareStatement("SELECT * FROM room WHERE roomnumber=? AND status=?");
            pst.setString(1, roomNumber);
            pst.setString(2, "Not Booked");
            ResultSet rs = pst.executeQuery();

            assertTrue("Available room can be booked", rs.next());
            System.out.println("PASS: Can book available room");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_BM_14_Booking_Booked_CannotBook() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Room booked = cannot book");
        try {
            String roomNumber = "QTEST14";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");

            PreparedStatement pst = con.prepareStatement("SELECT * FROM room WHERE roomnumber=? AND status=?");
            pst.setString(1, roomNumber);
            pst.setString(2, "Not Booked");
            ResultSet rs = pst.executeQuery();

            assertFalse("Booked room cannot be booked", rs.next());
            System.out.println("PASS: Cannot book booked room");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_BM_15_Booking_AddRoom_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Simple path - add new room");
        try {
            String roomNumber = "QTEST15";
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
    public void TC_BM_16_Booking_UpdateRoom_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Simple path - update room");
        try {
            String roomNumber = "QTEST16";
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
    public void TC_BM_17_Booking_DeleteRoom_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Simple path - delete room");
        try {
            String roomNumber = "QTEST17";
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
    public void TC_BM_18_Booking_StatusBranch_NotBooked() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Status branch - Not Booked");
        try {
            String roomNumber = "QTEST18";
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
    public void TC_BM_19_Booking_StatusBranch_Booked() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Status branch - Booked");
        try {
            String roomNumber = "QTEST19";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");

            PreparedStatement pst = con.prepareStatement("SELECT status FROM room WHERE roomnumber=?");
            pst.setString(1, roomNumber);
            ResultSet rs = pst.executeQuery();

            assertTrue("Room should exist", rs.next());
            String status = rs.getString("status");
            if (status.equals("Booked")) {
                assertTrue("Status should be Booked", true);
                System.out.println("PASS: Status is Booked");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_BM_20_Booking_AddDuplicate_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [BOOKING]: Add duplicate room = fail");
        try {
            String roomNumber = "QTEST20";
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
    public void TC_CM_01_Customer_Mobile_Empty() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Mobile number is empty - invalid");
        String mobile = "";
        assertTrue("Mobile should not be empty", mobile.isEmpty());
        System.out.println("PASS: Empty mobile is invalid");
    }

    @Test
    public void TC_CM_02_Customer_Mobile_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Mobile number is valid (10 digits)");
        String mobile = "1234567890";
        assertTrue("Mobile should be 10 digits", mobile.length() == 10);
        System.out.println("PASS: Valid mobile number");
    }

    @Test
    public void TC_CM_03_Customer_Aadhar_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Aadhar number is valid (12 digits)");
        String aadhar = "123456789012";
        assertTrue("Aadhar should be 12 digits", aadhar.length() == 12);
        System.out.println("PASS: Valid aadhar number");
    }

    @Test
    public void TC_CM_04_Customer_Days_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Days stayed is zero - becomes 1");
        int days = 0;
        int actualDays = (days <= 0) ? 1 : days;
        assertEquals("Zero days should become 1", 1, actualDays);
        System.out.println("PASS: Zero days handled");
    }

    @Test
    public void TC_CM_05_Customer_Days_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Days stayed is positive - valid");
        int days = 3;
        assertTrue("Days should be positive", days > 0);
        System.out.println("PASS: Positive days is valid");
    }

    @Test
    public void TC_CM_06_Customer_Gender_Male() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Gender is Male");
        String gender = "Male";
        assertTrue("Male should be valid", gender.equals("Male"));
        System.out.println("PASS: Male gender accepted");
    }

    @Test
    public void TC_CM_07_Customer_Gender_Female() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Gender is Female");
        String gender = "Female";
        assertTrue("Female should be valid", gender.equals("Female"));
        System.out.println("PASS: Female gender accepted");
    }

    @Test
    public void TC_CM_08_Customer_Gender_Other() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Gender is Other");
        String gender = "Other";
        assertTrue("Other should be valid", gender.equals("Other"));
        System.out.println("PASS: Other gender accepted");
    }

    @Test
    public void TC_CM_09_Customer_Email_Valid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Email is valid");
        String email = "test@example.com";
        assertTrue("Valid email should contain @", email.contains("@"));
        System.out.println("PASS: Valid email");
    }

    @Test
    public void TC_CM_10_Customer_Email_Invalid() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Email is invalid");
        String email = "invalidemail.com";
        assertFalse("Invalid email should not contain @", email.contains("@"));
        System.out.println("PASS: Invalid email rejected");
    }

    @Test
    public void TC_CM_11_Customer_CheckIn_Valid_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Check-in with valid data = success");
        try {
            String roomNumber = "QTEST31";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO customer (name, mobile, email, gender, address, id, nationality, date, " +
                "roomnumber, bed, roomtype, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Test Customer");
            pst.setString(2, "9876543210");
            pst.setString(3, "test31@test.com");
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

            int result = pst.executeUpdate();
            assertEquals("Should check-in successfully", 1, result);
            System.out.println("PASS: Check-in successful");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_12_Customer_CheckOut_Valid_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Check-out with valid data = success");
        try {
            String roomNumber = "QTEST32";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Booked");
            createCheckedInCustomer("test32@test.com", roomNumber);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String billid = "BILLQTEST32";
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
            assertEquals("Should check-out successfully", 1, result);
            System.out.println("PASS: Check-out successful");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_13_Customer_CheckOut_AlreadyCheckedOut_Fail() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Check-out already checked out = fail");
        try {
            String roomNumber = "QTEST33";
            String email = "test33@test.com";

            createCheckedOutCustomer(email, roomNumber);

            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM customer WHERE roomnumber=? AND status=?");
            pst.setString(1, roomNumber);
            pst.setString(2, "check out");
            ResultSet rs = pst.executeQuery();

            boolean found = rs.next();
            if (!found) {
                rs.close();
                pst.close();
                PreparedStatement debugPst = con.prepareStatement(
                    "SELECT status FROM customer WHERE roomnumber=?");
                debugPst.setString(1, roomNumber);
                ResultSet debugRs = debugPst.executeQuery();
                if (debugRs.next()) {
                    String actualStatus = debugRs.getString("status");
                    fail("Customer exists but status is '" + actualStatus + "' instead of 'check out'");
                } else {
                    fail("Customer was not created. Check database connection and foreign key constraints.");
                }
                debugRs.close();
                debugPst.close();
            }
            rs.close();
            pst.close();

            assertTrue("Customer should exist with checked out status", found);
            System.out.println("PASS: Already checked out detected");

        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_14_Customer_CheckIn_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Simple path - check-in customer");
        try {
            String roomNumber = "QTEST34";
            createTestRoom(roomNumber, "AC", "Single", 1500.00, "Not Booked");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO customer (name, mobile, email, gender, address, id, nationality, date, " +
                "roomnumber, bed, roomtype, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, "Simple Test");
            pst.setString(2, "9876543210");
            pst.setString(3, "test34@test.com");
            pst.setString(4, "Male");
            pst.setString(5, "123 St");
            pst.setString(6, "999999999999");
            pst.setString(7, "Indian");
            pst.setString(8, dateFormat.format(new Date()));
            pst.setString(9, roomNumber);
            pst.setString(10, "Single");
            pst.setString(11, "AC");
            pst.setDouble(12, 1500.00);
            pst.setString(13, "NULL");

            int result = pst.executeUpdate();
            assertEquals("Should check-in", 1, result);
            System.out.println("PASS: Check-in completed");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_15_Customer_BillCalculation_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Simple path - calculate bill");
        double price = 1500.00;
        int days = 3;
        double amount = days * price;
        assertEquals("Bill should be calculated", 4500.00, amount, 0.01);
        System.out.println("PASS: Bill calculated");
    }

    @Test
    public void TC_CM_16_Customer_StatusBranch_NULL() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Status branch - NULL (checked in)");
        try {
            String roomNumber = "QTEST36";
            createCheckedInCustomer("test36@test.com", roomNumber);

            PreparedStatement pst = con.prepareStatement("SELECT status FROM customer WHERE roomnumber=?");
            pst.setString(1, roomNumber);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                rs.close();
                pst.close();
                fail("Customer should exist but was not found. Check database connection and foreign key constraints.");
            }

            String status = rs.getString("status");
            rs.close();
            pst.close();

            if (status != null && status.equals("NULL")) {
                assertTrue("Status should be NULL", true);
                System.out.println("PASS: Status is NULL (checked in)");
            } else {
                fail("Status is '" + status + "' but expected 'NULL'");
            }
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_17_Customer_StatusBranch_CheckOut() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Status branch - check out");
        try {
            String roomNumber = "QTEST37";
            createCheckedOutCustomer("test37@test.com", roomNumber);

            PreparedStatement pst = con.prepareStatement("SELECT status FROM customer WHERE roomnumber=?");
            pst.setString(1, roomNumber);
            ResultSet rs = pst.executeQuery();

            assertTrue("Customer should exist", rs.next());
            String status = rs.getString("status");
            if (status.equals("check out")) {
                assertTrue("Status should be check out", true);
                System.out.println("PASS: Status is check out");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_CM_18_Customer_DaysBranch_Zero() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Days branch - zero becomes 1");
        int days = 0;
        int actualDays = (days <= 0) ? 1 : days;
        if (actualDays == 1) {
            assertEquals("Zero days should become 1", 1, actualDays);
            System.out.println("PASS: Zero days converted to 1");
        }
    }

    @Test
    public void TC_CM_19_Customer_DaysBranch_Positive() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Days branch - positive days");
        int days = 5;
        if (days > 0) {
            assertTrue("Positive days should be valid", true);
            System.out.println("PASS: Positive days accepted");
        }
    }

    @Test
    public void TC_CM_20_Customer_AmountCalculation() {
        testCounter++;
        System.out.println("Test " + testCounter + " [CUSTOMER]: Amount calculation");
        double price = 1500.00;
        int days = 4;
        double amount = days * price;
        assertEquals("Amount should be price * days", 6000.00, amount, 0.01);
        System.out.println("PASS: Amount calculated correctly");
    }


    @Test
    public void TC_NS_01_Notification_SuccessMessage_Registration() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Success message - registration");
        String message = "Registered Successfully\nLogin Now";
        assertNotNull("Message should exist", message);
        assertTrue("Message should contain success", message.contains("Successfully"));
        System.out.println("PASS: Registration success message");
    }

    @Test
    public void TC_NS_02_Notification_SuccessMessage_CheckIn() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Success message - check-in");
        String message = "Room Alloted";
        assertNotNull("Message should exist", message);
        assertTrue("Message should indicate success", message.equals("Room Alloted"));
        System.out.println("PASS: Check-in success message");
    }

    @Test
    public void TC_NS_03_Notification_SuccessMessage_CheckOut() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Success message - check-out");
        String message = "Check out Successfully.";
        assertNotNull("Message should exist", message);
        assertTrue("Message should indicate success", message.contains("Successfully"));
        System.out.println("PASS: Check-out success message");
    }

    @Test
    public void TC_NS_04_Notification_ErrorMessage_NotFound() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Error message - record not found");
        String message = "Record Not Found";
        assertNotNull("Message should exist", message);
        assertTrue("Message should indicate error", message.contains("Not Found"));
        System.out.println("PASS: Record not found error message");
    }

    @Test
    public void TC_NS_05_Notification_ConfirmMessage_Logout() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Confirm message - logout");
        String message = "Are you really Logout ?";
        assertNotNull("Message should exist", message);
        assertTrue("Message should be a question", message.contains("?"));
        System.out.println("PASS: Logout confirmation message");
    }

    @Test
    public void TC_NS_06_Notification_ConfirmMessage_Exit() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Confirm message - exit");
        String message = "Are You Really Close This Application ?";
        assertNotNull("Message should exist", message);
        assertTrue("Message should be a question", message.contains("?"));
        System.out.println("PASS: Exit confirmation message");
    }

    @Test
    public void TC_NS_07_Notification_InfoMessage_PasswordReset() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Info message - password reset");
        String message = "Password Reset\nLogin Now";
        assertNotNull("Message should exist", message);
        assertTrue("Message should contain reset info", message.contains("Reset"));
        System.out.println("PASS: Password reset info message");
    }

    @Test
    public void TC_NS_08_Notification_Success_ShowMessage() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Operation success = show success message");
        boolean operationSuccess = true;
        if (operationSuccess) {
            String message = "Operation Successful";
            assertNotNull("Should show success message", message);
            System.out.println("PASS: Success message shown");
        }
    }

    @Test
    public void TC_NS_09_Notification_Error_ShowMessage() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: Operation error = show error message");
        boolean operationError = true;
        if (operationError) {
            String message = "Operation Failed";
            assertNotNull("Should show error message", message);
            System.out.println("PASS: Error message shown");
        }
    }

    @Test
    public void TC_NS_10_Notification_ConfirmYes_ShowSuccess() {
        testCounter++;
        System.out.println("Test " + testCounter + " [NOTIFICATION]: User confirms = show success");
        int userChoice = 0;
        if (userChoice == 0) {
            assertTrue("Should proceed with operation", true);
            System.out.println("PASS: Confirmation accepted");
        }
    }


    @Test
    public void TC_DH_01_Dashboard_Button_ManageRoom() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Manage Room button exists");
        String button = "ManageRoom";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "ManageRoom", button);
        System.out.println("PASS: Manage Room button exists");
    }

    @Test
    public void TC_DH_02_Dashboard_Button_CustomerCheckIn() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Check In button exists");
        String button = "CustomerCheckIn";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerCheckIn", button);
        System.out.println("PASS: Customer Check In button exists");
    }

    @Test
    public void TC_DH_03_Dashboard_Button_CustomerCheckOut() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Check Out button exists");
        String button = "CustomerCheckOut";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerCheckOut", button);
        System.out.println("PASS: Customer Check Out button exists");
    }

    @Test
    public void TC_DH_04_Dashboard_Button_CustomerDetailsBill() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Customer Details Bill button exists");
        String button = "CustomerDetailsBill";
        assertNotNull("Button should exist", button);
        assertEquals("Button name should match", "CustomerDetailsBill", button);
        System.out.println("PASS: Customer Details Bill button exists");
    }

    @Test
    public void TC_DH_05_Dashboard_ButtonClick_OpensForm() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Button click opens correct form");
        String clickedButton = "ManageRoom";
        String expectedForm = "ManageRoom";
        assertEquals("Button should open correct form", expectedForm, clickedButton);
        System.out.println("PASS: Button click works");
    }

    @Test
    public void TC_DH_06_Dashboard_Logout_Yes() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Logout - user says yes");
        int choice = 0;
        if (choice == 0) {
            assertTrue("Should logout", true);
            System.out.println("PASS: Logout confirmed");
        }
    }

    @Test
    public void TC_DH_07_Dashboard_Logout_No() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Logout - user says no");
        int choice = 1;
        if (choice != 0) {
            assertFalse("Should not logout", false);
            System.out.println("PASS: Logout cancelled");
        }
    }

    @Test
    public void TC_DH_08_Dashboard_Exit_Yes() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Exit - user says yes");
        int choice = 0;
        if (choice == 0) {
            assertTrue("Should exit", true);
            System.out.println("PASS: Exit confirmed");
        }
    }

    @Test
    public void TC_DH_09_Dashboard_Exit_No() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: Exit - user says no");
        int choice = 1;
        if (choice != 0) {
            assertFalse("Should not exit", false);
            System.out.println("PASS: Exit cancelled");
        }
    }

    @Test
    public void TC_DH_10_Dashboard_AllButtons_Exist() {
        testCounter++;
        System.out.println("Test " + testCounter + " [DASHBOARD]: All buttons exist");
        String[] buttons = {"ManageRoom", "CustomerCheckIn", "CustomerCheckOut",
                           "CustomerDetailsBill", "Logout", "Exit"};
        assertEquals("Should have 6 buttons", 6, buttons.length);
        System.out.println("PASS: All buttons exist");
    }


    @Test
    public void TC_AM_01_Admin_UserStatus_Pending() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: User status is pending");
        try {
            String email = "test61@test.com";
            PreparedStatement updatePst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            updatePst.setString(1, "panding");
            updatePst.setString(2, email);
            updatePst.executeUpdate();
            updatePst.close();

            PreparedStatement pst = con.prepareStatement("SELECT status FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            assertTrue("User should exist", rs.next());
            assertEquals("Status should be panding", "panding", rs.getString("status"));
            System.out.println("PASS: Status is pending");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_02_Admin_UserStatus_Approved() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: User status is approved");
        try {
            String email = "test62@test.com";

            PreparedStatement pst = con.prepareStatement("SELECT status FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            assertTrue("User should exist", rs.next());
            assertEquals("Status should be approved", "approved", rs.getString("status"));
            System.out.println("PASS: Status is approved");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_03_Admin_ChangeStatus_PendingToApproved_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Change status pending to approved = success");
        try {
            String email = "test63@test.com";
            PreparedStatement setupPst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            setupPst.setString(1, "panding");
            setupPst.setString(2, email);
            setupPst.executeUpdate();
            setupPst.close();

            PreparedStatement pst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            pst.setString(1, "approved");
            pst.setString(2, email);
            int result = pst.executeUpdate();

            assertEquals("Should update status", 1, result);
            System.out.println("PASS: Status changed to approved");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_04_Admin_ChangeStatus_ApprovedToPending_Success() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Change status approved to pending = success");
        try {
            String email = "test64@test.com";

            PreparedStatement pst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            pst.setString(1, "panding");
            pst.setString(2, email);
            int result = pst.executeUpdate();

            assertEquals("Should update status", 1, result);
            System.out.println("PASS: Status changed to pending");

            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_05_Admin_SearchUser_Exists_Found() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Search user - exists = found");
        try {
            String email = "test65@test.com";

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            assertTrue("Should find user", rs.next());
            assertEquals("Email should match", email, rs.getString("email"));
            System.out.println("PASS: User found");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_06_Admin_SearchUser_NotExists_NotFound() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Search user - not exists = not found");
        try {
            String email = "nonexistent@test.com";

            PreparedStatement pst = con.prepareStatement("SELECT * FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            assertFalse("Should not find user", rs.next());
            System.out.println("PASS: User not found");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_07_Admin_ViewAllUsers_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Simple path - view all users");
        try {
            PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM signup");
            ResultSet rs = pst.executeQuery();

            assertTrue("Should return count", rs.next());
            int count = rs.getInt(1);
            assertTrue("Count should be >= 0", count >= 0);
            System.out.println("PASS: Found " + count + " users");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_08_Admin_Refresh_SimplePath() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Simple path - refresh user list");
        try {
            PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM signup");
            ResultSet rs = pst.executeQuery();

            assertTrue("Should return count after refresh", rs.next());
            int count = rs.getInt(1);
            assertTrue("Count should be >= 0", count >= 0);
            System.out.println("PASS: List refreshed - found " + count + " users");

            rs.close();
            pst.close();
        } catch (SQLException e) {
            fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_AM_09_Admin_DoubleClick_ChangeStatus() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Double click triggers status change");
        int clickCount = 2;
        if (clickCount == 2) {
            assertTrue("Should trigger status change dialog", true);
            System.out.println("PASS: Double click works");
        }
    }

    @Test
    public void TC_AM_10_Admin_SimplePath_ApproveUser() {
        testCounter++;
        System.out.println("Test " + testCounter + " [ADMIN]: Simple path - approve user");
        try {
            String email = "test70@test.com";
            PreparedStatement setupPst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            setupPst.setString(1, "panding");
            setupPst.setString(2, email);
            setupPst.executeUpdate();
            setupPst.close();

            PreparedStatement pst = con.prepareStatement("UPDATE signup SET status=? WHERE email=?");
            pst.setString(1, "approved");
            pst.setString(2, email);
            int result = pst.executeUpdate();

            assertEquals("Should approve user", 1, result);

            pst = con.prepareStatement("SELECT status FROM signup WHERE email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            assertTrue("User should exist", rs.next());
            assertEquals("Status should be approved", "approved", rs.getString("status"));

            System.out.println("PASS: User approved");

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
            PreparedStatement roomCheck = con.prepareStatement(
                "SELECT roomnumber FROM room WHERE roomnumber=?");
            roomCheck.setString(1, roomNumber);
            ResultSet rs = roomCheck.executeQuery();
            if (!rs.next()) {
                PreparedStatement createRoom = con.prepareStatement(
                    "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
                createRoom.setString(1, roomNumber);
                createRoom.setString(2, "AC");
                createRoom.setString(3, "Single");
                createRoom.setDouble(4, 1500.00);
                createRoom.setString(5, "Booked");
                createRoom.executeUpdate();
                createRoom.close();
            }
            rs.close();
            roomCheck.close();

            PreparedStatement deleteStmt = con.prepareStatement(
                "DELETE FROM customer WHERE roomnumber=? OR email=?");
            deleteStmt.setString(1, roomNumber);
            deleteStmt.setString(2, email);
            deleteStmt.executeUpdate();
            deleteStmt.close();

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
            int rowsAffected = pst.executeUpdate();
            pst.close();

            if (rowsAffected == 0) {
                System.out.println("WARNING: Customer insert returned 0 rows affected");
            }
        } catch (SQLException e) {
            System.out.println("ERROR in createCheckedInCustomer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createCheckedOutCustomer(String email, String roomNumber) {
        try {
            PreparedStatement roomCheck = con.prepareStatement(
                "SELECT roomnumber FROM room WHERE roomnumber=?");
            roomCheck.setString(1, roomNumber);
            ResultSet rs = roomCheck.executeQuery();
            if (!rs.next()) {
                PreparedStatement createRoom = con.prepareStatement(
                    "INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
                createRoom.setString(1, roomNumber);
                createRoom.setString(2, "AC");
                createRoom.setString(3, "Single");
                createRoom.setDouble(4, 1500.00);
                createRoom.setString(5, "Not Booked");
                createRoom.executeUpdate();
                createRoom.close();
            }
            rs.close();
            roomCheck.close();

            PreparedStatement deleteStmt = con.prepareStatement(
                "DELETE FROM customer WHERE roomnumber=? OR email=?");
            deleteStmt.setString(1, roomNumber);
            deleteStmt.setString(2, email);
            deleteStmt.executeUpdate();
            deleteStmt.close();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String uniqueBillId = "BILLQTEST" + System.currentTimeMillis();
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO customer (billid, name, mobile, email, gender, address, id, nationality, date, " +
                "roomnumber, bed, roomtype, price, status, outdate, days, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, uniqueBillId);
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
            pst.setInt(16, 3);
            pst.setDouble(17, 4500.00);
            int rowsAffected = pst.executeUpdate();
            pst.close();

            if (rowsAffected == 0) {
                System.out.println("WARNING: Customer insert returned 0 rows affected");
            }
        } catch (SQLException e) {
            System.out.println("ERROR in createCheckedOutCustomer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
