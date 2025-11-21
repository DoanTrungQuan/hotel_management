-- Alternative Customer Table with Auto-Increment BillID
-- Use this version if you want billid to be auto-generated

CREATE TABLE IF NOT EXISTS customer (
    billid INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Auto-generated Bill ID',
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
    FOREIGN KEY (roomnumber) REFERENCES room(roomnumber) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

