--@block
create table employee(
    employeeID VARCHAR(4) primary key,
    employeePassword VARCHAR(255),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    employeeAddress VARCHAR(255),
    SSN VARCHAR(11),
    phoneNumber VARCHAR(10),
    dateOfBirth DATE,
    isManager BOOLEAN
);

--@block
insert into employee(employeeID, employeePassword, firstName, lastName, employeeAddress, SSN, phoneNumber, dateOfBirth, isManager)
VALUES
    ('1001', 'pass123', 'John', 'Doe', '123 Main St, Cityville', '123-45-6789', '555-1234', '1990-05-15', TRUE),
    ('1002', 'secret456', 'Jane', 'Smith', '456 Oak St, Townsville', '987-65-4321', '555-5678', '1985-09-22', FALSE),
    ('1003', 'pwd789', 'Bob', 'Johnson', '789 Pine St, Villagetown', '543-21-8765', '555-9876', '1995-02-10', FALSE);

--@block 
select employeePassword from employee where employeeID = '1001';

--@block
select employeeId from employee where employeeID = "1001";

--@block
select isManager from employee where employeeID = '1001';

--@block 
select * from employee;

--@block
truncate employee;

create table employeeEarnings(
    employeeID VARCHAR(4),
    FOREIGN KEY (employeeID) REFERENCES employee(employeeID),
    employeeTotalRunningSales INT,
    employeeCommissionCurrent FLOAT
);

--@block
insert into employeeEarnings(employeeID, employeeTotalRunningSales, employeeCommissionCurrent)
values('1001', 6, 5600.78);

--@block
insert into employeeEarnings(employeeCommissionCurrent) where employeeID = "1001"
values(5600.78);

--@block
UPDATE employeeEarnings SET employeeCommissionCurrent = 5600.90 WHERE employeeID = "1001";

--@block
select employeeComissionCurrent from employeeEarnings where employeeID = "1001";

--@block
select * from employeeEarnings;

--@block
drop table employeeEarnings;

--@block
create table vehicle(
    vehicleVIN VARCHAR(17) PRIMARY KEY,
    vehicleMake VARCHAR(25),
    vehicleModel VARCHAR(25),
    vehicleType VARCHAR(25),
    vehicleColor VARCHAR(25),
    vehicleYear VARCHAR(4),
    vehicleTransmission VARCHAR(25),
    vehicleMileage INT,
    vehicleCondition VARCHAR(25),
    vehicleSalePrice FLOAT,
    vehicleAvailability VARCHAR(25)
);
--@block
drop table vehicle;

--@block
INSERT INTO vehicle (vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition, vehicleSalePrice, vehicleAvailability)
VALUES
    ('1HGCM82633A123456', 'Honda', 'Accord', 'sedan', 'Blue', '2020', 'Automatic', 30000, 'Excellent', 20000.50, 'In Stock'),
    ('2T3ZFREV8EW123457', 'Toyota', 'RAV4', 'suv', 'Red', '2019', 'Automatic', 25000, 'Good', 18000.75, 'In Stock'),
    ('JH4DA1850GS012345', 'Acura', 'Integra','coupe', 'Silver', '2015', 'Manual', 40000, 'Fair', 15000.25, 'Sold'),
    ('5XYZT3LB7HG123458', 'Hyundai', 'Santa Fe', 'suv', 'White', '2021', 'Automatic', 15000, 'Like New', 23000.00, 'In Stock');


--@block
insert into vehicle (vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition, vehicleSalePrice, vehicleAvailability)
VALUE('1', '1', '1', '1', '1','1','1','1','1','1','1');

--@block 
select vehicleMake from vehicle where vehicleVIN = '1HGCM82633A123456'

--@block 
select * from vehicle where vehicleMake = 'Honda' and vehicleModel = 'accord' and vehicleType = 'sedan' and vehicleColor = 'blue' and vehicleYear = '2020' and vehicleMileage = 30000;

--@block
select * from vehicle

--@block
create table customer(
    customerID INT(4) PRIMARY KEY AUTO_INCREMENT,
    SSN VARCHAR(11),
    driversLicense VARCHAR(9),
    dateOfBirth DATE,
    phoneNumber VARCHAR(10),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    customerAddress VARCHAR(255),
    downPayment FLOAT,
    creditScore VARCHAR(3),
    insuranceNo VARCHAR(10),
    paymentType VARCHAR(20)
);

--@block 
INSERT INTO customer (
    SSN, driversLicense, dateOfBirth, phoneNumber, firstName, lastName, customerAddress, downPayment, creditScore, insuranceNo, paymentType) 
VALUES 
('123-45-6789', 'DL1234567', '1990-05-15', '555-1234', 'John', 'Doe', '123 Main St, Cityville, USA', 2000.00, '750', 'INS456789', 'Credit Card'), 
( '987-65-4321', 'DL7654321', '1985-08-22', '555-5678', 'Jane', 'Smith', '456 Oak St, Townsville, USA', 1500.50, '800', 'INS987654', 'Credit Card');

--@block
SELECT * FROM customer

--@block
SELECT customerID FROM customer where SSN = '123-45-6789';

--@block
DROP TABLE customer

--@block
create table deal(
    ID INT primary key,
    vehicleType VARCHAR(25),
    discount FLOAT
);

--@block
INSERT INTO deal(ID, vehicleType, discount)
VALUES
(1, 'None', 0);

--@block
drop table deal

--@block 
truncate table deal

--@block
Update deal 
SET vehicleType = 'sedan' , discount = 0.20 

--@block
select discount from deal where vehicleType = 'sedan'
