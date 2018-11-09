-SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various 
------actions against the database
--3.1 System Defined Functions
--Task ? Create a function that returns the current time.
--Task ? create a function that returns the length of a mediatype from the mediatype table
--3.2 System Defined Aggregate Functions
--Task ? Create a function that returns the average total of all invoices
--Task ? Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task ? Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task ? Create a function that returns all employees who are born after 1968.

SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;
SELECT LENGTH('of a mediatype from the mediatype table') "Length in characters" FROM DUAL;

select avg(total) from invoice;
select max(total) from invoice;
select * from invoiceline;
select * from invoice;
select avg(total) from invoice group by (invoiceid);
select * from employee;

SELECT column_name, COUNT(*)
FROM table_name
GROUP BY column_name
HAVING COUNT(*) > value;

Select birthdate from employee having birthdate > 31-DEC-67;

select * from employee;
SELECT birthdate
FROM Employee
WHERE birthdate> '31-DEC-67';
