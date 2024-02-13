--@block
create table employee(
    employeeID VARCHAR(4) primary key,
    employeePassword VARCHAR(255),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    employeeAddress VARCHAR(255),
    SSN VARCHAR(11),
    phoneNumber VARCHAR(10),
    dateOfBirth DATE
);

--@block
insert into employee(employeeID, employeePassword, firstName, lastName, employeeAddress, SSN, phoneNumber, dateOfBirth)
VALUES
('1001', 'pass123', 'John', 'Doe', '123 Main St, Cityville', '123-45-6789', '555-1234', '1990-05-15'),
('1002', 'secret456', 'Jane', 'Smith', '456 Oak St, Townsville', '987-65-4321', '555-5678', '1985-09-22'),
('1003', 'pwd789', 'Bob', 'Johnson', '789 Pine St, Villagetown', '543-21-8765', '555-9876', '1995-02-10');


--@block 
select employeePassword from employee where employeeID = '1001';

--@block
select employeeId from employee where employeeID = "1001";