--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task � Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task � Create a stored procedure that updates the personal information of an employee.
--Task � Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task � Create a stored procedure that returns the name and company of a customer.

Select firstname,lastname from employee;

UPDATE EMPLOYEE
SET Lastname = 'Paige'
WHERE Lastname = 'Edwards';

select firstname, lastname,employeeid,reportsto from employee where employeeid = '2' or reportsto = '2';

select * from employee;

select * from customer;

select firstname, lastname, company from customer;

