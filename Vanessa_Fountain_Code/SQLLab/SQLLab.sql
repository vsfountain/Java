--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from Employee;
select * from Employee where lastname = 'King';
select * from Employee where firstname = 'Andrew' and reportsto is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city
select * from Album order by title desc;
select firstname,city from Customer order by city;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table
 insert into Genre(genreid,name) 
 VALUEs('1111' ,'record1');
 select*from genre;

 insert into Employee 
 VALUEs('2222','record2','record2','record2',null ,null ,null,null,null,null,null,null,null,null,null);
 insert into Employee 
 VALUEs('1111','record1','record1','record1',null ,null ,null,null,null,null,null,null,null,null,null);

insert into Customer
 VALUEs('2222','record2','record2','record2',null ,null ,null,null,null,null,null,'someone@the.email',null);
 insert into Customer 
 VALUEs('1111','record1','record1','record1',null ,null ,null,null,null,null,null,'this@this.email',null); 
 
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Customer
SET Firstname = 'Robert', Lastname = 'Walter'
WHERE Firstname = 'Aaron' and Lastname = 'Mitchell';

update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
Select * from INVOICE where BILLINGADDRESS like 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
Select * from invoice where total between 15 and 50;
select * from employee;
select * from EMPLOYEE where hiredate BETWEEN '01-JUN-03' and '01-MAR-04';
commit;
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). 
Delete from Customer where firstname = 'Robert' and lastname = 'Walter'; 
--696 osborn street
Select * from customer;
select * from invoice id where customerid = 32;
delete from invoice id where customerid = 32;
select * from invoiceline;
delete from invoiceline where customerid = 32;
delete from invoiceline where INVOICEID = 245;
delete from invoiceline where INVOICEID =268;
delete from invoiceline where INVOICEID =290;
delete from invoiceline where INVOICEID =342;
delete from invoiceline where INVOICEID =50;
delete from invoiceline where INVOICEID =61;
delete from invoiceline where INVOICEID =116;

commit;

--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of a mediatype from the mediatype table
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
