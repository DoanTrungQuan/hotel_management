package project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite to run all tests - Quan's Test Suite
 * 70 test cases covering 5 modules:
 * 1. Booking Module (Tests 1-20)
 * 2. Customer Module (Tests 21-40)
 * 3. Notification System (Tests 41-50)
 * 4. Website Home/Dashboard (Tests 51-60)
 * 5. Admin Management (Tests 61-70)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    QuanTestSuite.class,
        LamTestSuite.class
})
public class AllTests {
}

