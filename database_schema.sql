-- Hotel Management System Database Schema
-- Database: hotel
-- Created for MySQL

-- Drop existing tables if they exist (use with caution in production)
-- DROP TABLE IF EXISTS customer;
-- DROP TABLE IF EXISTS room;
-- DROP TABLE IF EXISTS signup;

-- ============================================
-- 1. SIGNUP TABLE
-- Purpose: User registration and authentication
-- ============================================
CREATE TABLE IF NOT EXISTS signup (
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    sq VARCHAR(200) NOT NULL COMMENT 'Security Question',
    answer VARCHAR(100) NOT NULL,
    status VARCHAR(20) DEFAULT 'panding' COMMENT 'Account status: panding or approved'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- 2. ROOM TABLE
-- Purpose: Room inventory and management
-- ============================================
CREATE TABLE IF NOT EXISTS room (
    roomnumber VARCHAR(20) NOT NULL PRIMARY KEY,
    roomtype VARCHAR(10) NOT NULL COMMENT 'AC or NON AC',
    bed VARCHAR(10) NOT NULL COMMENT 'Single or Double',
    price DECIMAL(10, 2) NOT NULL COMMENT 'Price per day',
    status VARCHAR(20) DEFAULT 'Not Booked' COMMENT 'Not Booked or Booked'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- 3. CUSTOMER TABLE
-- Purpose: Customer check-in/check-out and billing
-- ============================================
-- NOTE: billid is set during check-out, so it can be NULL initially
CREATE TABLE IF NOT EXISTS customer (
    billid VARCHAR(50) DEFAULT NULL COMMENT 'Bill ID (set during check-out)',
    customer_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Auto-increment customer ID',
    name VARCHAR(100) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL COMMENT 'Male, Female, Other',
    address VARCHAR(255) NOT NULL,
    id VARCHAR(20) NOT NULL COMMENT 'Aadhar Number (12 digits)',
    nationality VARCHAR(50) NOT NULL,
    date VARCHAR(20) NOT NULL COMMENT 'Check-in date (format: yyyy/MM/dd)',
    roomnumber VARCHAR(20) NOT NULL,
    bed VARCHAR(10) NOT NULL,
    roomtype VARCHAR(10) NOT NULL,
    price DECIMAL(10, 2) NOT NULL COMMENT 'Price per day',
    status VARCHAR(20) DEFAULT 'NULL' COMMENT 'NULL (checked in) or check out',
    outdate VARCHAR(20) DEFAULT NULL COMMENT 'Check-out date (format: yyyy/MM/dd)',
    days INT DEFAULT NULL COMMENT 'Number of days stayed',
    amount DECIMAL(10, 2) DEFAULT NULL COMMENT 'Total amount',
    INDEX idx_roomnumber (roomnumber),
    INDEX idx_status (status),
    INDEX idx_email (email),
    INDEX idx_billid (billid),
    FOREIGN KEY (roomnumber) REFERENCES room(roomnumber) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- ALTERNATIVE: Customer table without billid as primary key
-- Use this if billid is auto-generated or not unique
-- ============================================
/*
CREATE TABLE IF NOT EXISTS customer (
    billid VARCHAR(50) DEFAULT NULL COMMENT 'Bill ID',
    name VARCHAR(100) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL COMMENT 'Male, Female, Other',
    address VARCHAR(255) NOT NULL,
    id VARCHAR(20) NOT NULL COMMENT 'Aadhar Number (12 digits)',
    nationality VARCHAR(50) NOT NULL,
    date VARCHAR(20) NOT NULL COMMENT 'Check-in date',
    roomnumber VARCHAR(20) NOT NULL,
    bed VARCHAR(10) NOT NULL,
    roomtype VARCHAR(10) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'NULL',
    outdate VARCHAR(20) DEFAULT NULL,
    days INT DEFAULT NULL,
    amount DECIMAL(10, 2) DEFAULT NULL,
    INDEX idx_roomnumber (roomnumber),
    INDEX idx_status (status),
    INDEX idx_email (email),
    INDEX idx_billid (billid),
    FOREIGN KEY (roomnumber) REFERENCES room(roomnumber) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
*/

-- ============================================
-- SAMPLE DATA (Optional - for testing)
-- ============================================

-- Insert sample room data (at least 10 rooms)
INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES
('101', 'AC', 'Single', 1500.00, 'Not Booked'),
('102', 'AC', 'Double', 2000.00, 'Not Booked'),
('103', 'NON AC', 'Single', 1000.00, 'Not Booked'),
('104', 'NON AC', 'Double', 1500.00, 'Not Booked'),
('201', 'AC', 'Single', 1500.00, 'Not Booked'),
('202', 'AC', 'Double', 2000.00, 'Not Booked'),
('203', 'AC', 'Single', 1500.00, 'Not Booked'),
('204', 'NON AC', 'Double', 1500.00, 'Not Booked'),
('301', 'AC', 'Single', 1800.00, 'Not Booked'),
('302', 'AC', 'Double', 2500.00, 'Not Booked'),
('303', 'NON AC', 'Single', 1200.00, 'Not Booked'),
('304', 'NON AC', 'Double', 1800.00, 'Not Booked');

-- Insert sample admin/user (at least 10 users)
-- Password should be hashed in production
INSERT INTO signup (name, email, password, sq, answer, status) VALUES
('Admin', 'admin@hotel.com', 'admin123', 'Your Favourite City', 'Mumbai', 'approved'),
('John Doe', 'john.doe@gmail.com', 'password123', 'Your Favourite Game', 'Chess', 'approved'),
('Jane Smith', 'jane.smith@gmail.com', 'password123', 'Your Favourite City', 'Delhi', 'approved'),
('Bob Wilson', 'bob.wilson@gmail.com', 'password123', 'Your Favourite Book', 'Harry Potter', 'panding'),
('Alice Johnson', 'alice.johnson@gmail.com', 'password123', 'Your Favourite Bike', 'Yamaha', 'approved'),
('Charlie Brown', 'charlie.brown@gmail.com', 'password123', 'Your Favourite Phone', 'iPhone', 'approved'),
('Diana Prince', 'diana.prince@gmail.com', 'password123', 'Your Favourite City', 'Paris', 'approved'),
('Edward Norton', 'edward.norton@gmail.com', 'password123', 'Your Favourite Game', 'Football', 'panding'),
('Fiona Apple', 'fiona.apple@gmail.com', 'password123', 'Your Favourite Book', '1984', 'approved'),
('George Lucas', 'george.lucas@gmail.com', 'password123', 'Your Favourite Bike', 'Honda', 'approved'),
('Helen Keller', 'helen.keller@gmail.com', 'password123', 'Your Favourite Phone', 'Samsung', 'panding');

-- Insert sample customer data (at least 10 customers)
-- First, update some rooms to "Booked" status for checked-in customers
UPDATE room SET status = 'Booked' WHERE roomnumber IN ('101', '102', '201', '203', '301');

-- Insert sample customers (checked in - status = 'NULL')
INSERT INTO customer (billid, name, mobile, email, gender, address, id, nationality, date, roomnumber, bed, roomtype, price, status) VALUES
(NULL, 'Rajesh Kumar', '9876543210', 'rajesh.kumar@gmail.com', 'Male', '123 Main Street, Mumbai', '123456789012', 'Indian', '2024/01/15', '101', 'Single', 'AC', 1500.00, 'NULL'),
(NULL, 'Priya Sharma', '9876543211', 'priya.sharma@gmail.com', 'Female', '456 Park Avenue, Delhi', '234567890123', 'Indian', '2024/01/16', '102', 'Double', 'AC', 2000.00, 'NULL'),
(NULL, 'Amit Patel', '9876543212', 'amit.patel@gmail.com', 'Male', '789 MG Road, Bangalore', '345678901234', 'Indian', '2024/01/17', '201', 'Single', 'AC', 1500.00, 'NULL'),
(NULL, 'Kavita Desai', '9876543215', 'kavita.desai@gmail.com', 'Female', '111 Commercial Street, Pune', '678901234567', 'Indian', '2024/01/18', '203', 'Single', 'AC', 1500.00, 'NULL'),
(NULL, 'Vikram Singh', '9876543216', 'vikram.singh@gmail.com', 'Male', '222 Brigade Road, Kolkata', '789012345678', 'Indian', '2024/01/19', '301', 'Single', 'AC', 1800.00, 'NULL');

-- Insert sample customers (checked out - status = 'check out')
-- Update rooms back to available for these examples
UPDATE room SET status = 'Not Booked' WHERE roomnumber IN ('103', '104', '202', '204', '302');

-- Insert checked-out customers with bill information
INSERT INTO customer (billid, name, mobile, email, gender, address, id, nationality, date, roomnumber, bed, roomtype, price, status, outdate, days, amount) VALUES
('BILL001', 'Suresh Reddy', '9876543213', 'suresh.reddy@gmail.com', 'Male', '321 Gandhi Nagar, Hyderabad', '456789012345', 'Indian', '2024/01/10', '103', 'Single', 'NON AC', 1000.00, 'check out', '2024/01/13', 3, 3000.00),
('BILL002', 'Meera Singh', '9876543214', 'meera.singh@gmail.com', 'Female', '654 Nehru Street, Chennai', '567890123456', 'Indian', '2024/01/12', '104', 'Double', 'NON AC', 1500.00, 'check out', '2024/01/15', 3, 4500.00),
('BILL003', 'Ramesh Iyer', '9876543217', 'ramesh.iyer@gmail.com', 'Male', '333 MG Road, Coimbatore', '890123456789', 'Indian', '2024/01/05', '202', 'Double', 'AC', 2000.00, 'check out', '2024/01/08', 3, 6000.00),
('BILL004', 'Sunita Nair', '9876543218', 'sunita.nair@gmail.com', 'Female', '444 Church Street, Kochi', '901234567890', 'Indian', '2024/01/08', '204', 'Double', 'NON AC', 1500.00, 'check out', '2024/01/11', 3, 4500.00),
('BILL005', 'Anil Kapoor', '9876543219', 'anil.kapoor@gmail.com', 'Male', '555 Marine Drive, Mumbai', '012345678901', 'Indian', '2024/01/01', '302', 'Double', 'AC', 2500.00, 'check out', '2024/01/05', 4, 10000.00);

-- ============================================
-- USEFUL QUERIES
-- ============================================

-- View all tables
-- SHOW TABLES;

-- View table structure
-- DESCRIBE signup;
-- DESCRIBE room;
-- DESCRIBE customer;

-- View all data
-- SELECT * FROM signup;
-- SELECT * FROM room;
-- SELECT * FROM customer;

-- Count records
-- SELECT COUNT(*) FROM signup;
-- SELECT COUNT(*) FROM room;
-- SELECT COUNT(*) FROM customer;

-- Find available rooms
-- SELECT * FROM room WHERE status = 'Not Booked';

-- Find checked-in customers
-- SELECT * FROM customer WHERE status = 'NULL';

-- Find checked-out customers
-- SELECT * FROM customer WHERE status = 'check out';

