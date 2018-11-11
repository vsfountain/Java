2.1 SELECT
Task – Select all records from the Employee table.

SELECT * FROM employee;

Task – Select all records from the Employee table where last name is King.

SELECT * FROM employee WHERE LASTNAME = 'King';

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM album;
SELECT * FROM album ORDER BY album.title DESC;

Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER;
SELECT Firstname FROM Customer  ORDER BY CITY ASC;

Task – Insert two new records into Genre table
SELECT * FROM Genre;
INSERT INTO Genre ( GenreID, name) VALUES (26, 'Soca');
INSERT INTO Genre ( GenreID, name) VALUES (27, 'Calypso');

task - Insert two new records into employee table,

SELECT * FROM Employee;
CREATE OR REPLACE TRIGGER employeeTable
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('insert was sucessful');
END;
/
SELECT * FROM employee;
INSERT INTO employee VALUES(9, 'Johnson', 'Mary', 'Sales nothing', '1', '2-jun-18', '1-jan-18', '32 red street', 'flowers', 'FL', 'United States', '301 a35', '+1 (770) 567-4565', '+1 (678) 453-8723', 'Mjay@me.com');
INSERT INTO employee VALUES(10, 'Brown', 'Jane', 'Sales everything', '2', '7-jun-67', '1-jan-18', '55 red street', 'flowers', 'FL', 'United States', '301 a35', '+1 (770) 587-7634', '+1 (678) 453-1234', 'jaybrown@me.com');
commit;
/
Insert two new records into Customer table

CREATE OR REPLACE TRIGGER customertable
AFTER INSERT ON  CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('insert COMPLETE');
END;
/
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER values (60, 'Krissy', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');
INSERT INTO CUSTOMER values (61, 'KrisTEN', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');
commit;
/
2.4 Update
Task- Update Aaron Mitchell in Customer table to Robert Walter.
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' and lastname ='Mitchell';
commit;
/
Task- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE ARTIST SET NAME = 'CCR' WHERE  NAME = 'Creedence Clearwater Revival';
commit;
/
2.5 LIKE
SELECT * From invoice where billingaddress like 'T%';
commit;
/
2.6 BETWEEN
Task- Select all invoices that have a total between 15 and 50.
SELECT * from invoice where total between 15 and 50;
/
Task - Select all employees hired between 1st of June 2003  and 1st of March 2004
SELECT * from employee where hiredate between '01-jun-03' and '01-mar-04';
/

2.7 Delete

Task- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this,
find out how to resolve them).

SELECT * from  CUSTOMER;
Delete * from customer where  firstname = 'Robert' and Lastname = 'Walter';
SELECT * FROM INVOICE WHERE CUSTOMERID = 32;
SELECT * FROM invoice;
SELECT * FROM invoiceline;
DELETE FROM invoiceline WHERE invoiceid IN (SELECT invoiceid from invoiceline)INTERSECT (SELECT invoiceid FROM INVOICE WHERE customerid = 32);
DELETE FROM CUSTOMER WHERE firstname = 'Robert' AND lastname = 'Walter';
commit;
/
3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform
various actions against the database

3.1 System Defined Functions
Task-Create a function that returns the average total of all invoices.
CREATE OR REPLACE PROCEDURE current_time_in_Tampa AS
        BEGIN
            DBMS_OUTPUT.PUT_lINE ('The current time in virginia is' 
             || to_Char (SYSDATE, 'MM-DD-YY HH:MI:SS AM'));
        END;
/
SELECT SYSDATE FROM DUAL;
/
Task- Create a function that returns the length of a mediatype from the mediatype table
SELECT * FROM MEDIATYPE;
SELECT length ('name')as len
from 
mediatype
order by len;
/
System defined Aggregate Functions
Task-Create a function that returns the average total of all invoices.
create or replace function INVOICELINE_TOTAL
  (invoice_id in number)
  return number
is
  tNumber number := 0;
  
  cursor total is
  select unitprice,quantity 
    from invoiceline
    where invoiceid = invoice_id;
   
begin
  for invoice_rec in t1
    loop
    tNumber := invoice_rec.unitprice * invoice_rec.quantity + tNumber;
  end loop;
    return tNumber;
end;
/
Task-Create a function that returns the most expensive track.
SELECT * FROM track;
CREATE OR REPLACE FUNCTION get_most_expensivetrack
RETURN VARCHAR2
IS 
trackname VARCHAR2 (100)
BEGIN
SELECT name into trackname FROM track WHERE trackid = (SELECT MIN (trackid) FROM 
track WHERE unitprice = ( (SELECT MAX(unitprice) FROM track)));
return trackname;
END;
/
DECLARE
trackname (VARCHAR2(100);
BEGIN
trackname := get_most_expensive_track();
DBMS_OUTPUT.PUT_LINE('Most Expensive track:' || trackname);
END;
/
SELECT * FROM INVOICE;
SELECT MAX (TOTAL) FROM INVOICE;
SELECT MAX (TOTAL) FROM INVOICE;
Task – Create a function that returns the most expensive track
CREATE FUNCTION Mostexpensive(@invoiceline_total)
return
select Title,unitprice
from invoiceline;
where unitprice > 1.00;
end;
/

Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;
SELECT AVG (unitprice)FROM INVOICELINE;
/
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
is
    EMPLOYEE_C SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE 
    BIRTHDATE >= TO_DATE('01-01-1968', 'DD-MM-YYYY');
    return EMPLOYEE_C;
END;
/

select after_1968 from dual;
/

SELECT * FROM employee;
/
SELECT * FROM employee where birthdate > DATE '1968-01-01';
/

4.0 Stored Procedures
In this section you will be creating and executing stored procedures. You will be creating various types
of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.


create or replace procedure GetEmployeenames (temp out SYS_REFCURSOR)
IS
BEGIN
OPEN TEMP FOR SELECT Firstname, Lastname  INTO TEMP from Employee;
END;
/
DECLARE 
TEMP SYS_REFCURSOR;
BEGIN
GetEmployeenames(temp);
SELECT TEMP FROM DUAL;
END;
/

EXEC GetEmployeesnames;

Stored Procedure Input Parameters
select * from employee;
section 4.2 Task – Create a stored procedure that updates the personal information of an employee.
Create or Replace procedure update_employee(employeeID in number, lastname in varchar2, 
firstname in varchar2, title in VARCHAR2, reportsto in number, birthdate in date);
is 
begin
update employee values (employeeID,lastname,firstname,birthdate,address);
END;
/
BEGIN
update_employee_info('Laura', 'Callahan', 'IT Staff', '6', '09-JAN-68' );
END;
/

Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE procedure getmanagers(empeefirstname in varchar, empeelastnamein varchar2, temp out SYS_REFCURSOR)
 is 
 BEGIN 
 DECLARE
 loop_value NUMBER (2) :=0;
 Empfirstname VARCHAR2(10):= 'Laura';
 emplastname VARCHAR2(10):='Callahan';
 reportsto number (6) :=0;
 BEGIN
 WHILE loop_value <5
 LOOP
  DBMS_OUPUT.PUT_LINE('not');
 SELECT reportsto INTO reportsto FROM employee WERE firstname = empeefirstname and lastname =empeelatname;
 IF reportsto IS NULL THEN 
 loop_value :=7;
 ELSE
 DMBS_OUPUT.PUT_LINE(reportsto);
 SELECT firstname into empeefirstname FROM EMPLOYEE WHERE employeeID = reportsto;
 DBMS_OUPUT.PUT_LINE(empeefirstname);
 SELECT lastname INTO empeelast FROM employee WHERE emplyeeid = reportsto;
 DBMS_OUTPUT.PUT_LINE (empeelastname);
 loop_value := loop_value+1;
 END IF;
 END LOOP;
 END;
 /
 
 4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUST_COMP RETURN SYS_REFCURSOR
IS 
CUSTOMER _C_SYS_REFCURSOR;
BEGIN 
OPEN CUSTOMER_C FOR SELECT * FROM CUSTOMER  
WHERE FIRSTNAME, LASTNAME, IS NOT NULL;
return Customer_C;
END;
/
--EXEC CUST_COMP;
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored
procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
rely on this, find out how to resolve them).

--DELETE FROM INVOICE WHERE INVOICEDID = 'invoiced'; 

SELECT  * FROM Invoice;
CREATE/ALTER PROCEDURE InvoiceID int
AS
BEGIN
  BEGIN TRY
BEGIN TRANSACTION;
WITH R AS(
      SELECT ArticleID, SUM(Quantity)ReclaimedQuantity
      FROM InvoiceLine
      WHERE InvoiceID = InvoiceID
      GROUP BY ArticleID
    )
    UPDATE Article
    SET Quantity = Quantity + R.ReclaimedQuantity
    FROM Article INNER JOIN
         R ON Article.ArticleID = R.ArticleID;

    -- This reclaims inventory to the Article table
    ----WITH R AS (
      ---SELECT ArticleID, SUM(Quantity) ReclaimedQuantity
      ---FROM InvoiCElINE
    -- Removes invoice line items
    DELETE FROM InvoiceLine
    WHERE InvoiceID = InvoiceID;

    -- Removes the invoice header item
    DELETE FROM Invoice
    WHERE InvoiceID = InvoiceID;

    COMMIT TRANSACTION;
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
  END CATCH
END;

Create a transaction nested within a stored procedure that inserts a new record in the Customer
table.
CREATE OR REPLACE PROCEDURE INSERT _CUSTOMER_NULLID (
INSERT INTO CUSTOMER values (61,'61','KrisTEN', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');

6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are
executed on a table.

Create an after insert trigger on the employee table fired after a new record is inserted into the
table.
CREATE OR REPLACE TRIGGER emp_Table
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('insert was sucessful');
END;
/


Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER empee_up_Table
AFTER UPDATE ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('insert was sucessful');
END;
/
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER empee_del_Table
AFTER DELETE ON employee
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_Line('DELETE sucessful');
END;
/
COMMIT;
7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work
with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and
the invoiceId.
SELECT * FROM customer;
SELECT * FROM INVOICE;
SELECT * FROM customer INNER JOIN orders ON customer.FIRSTNAME = invoice.invoiceid;
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.
SELECT * FROM customer TABLE a FULL OUTER JOIN invoice TABLE on customer.customerid,customer.firstname,customer.lastname = invoice.invoiceID, invoice.total;

7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
SELECT * FROM artist,album where artist.name (+)=album.title;
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT count(*) FROM album;
SELECT count (*) FROM artist;
SELECT COUNT (*) FROM album CROSS JOIN artist;
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee;
SELECT 
concat(employee.lastname,employee.firstname)employee, 
CONCAT (employee.reportsto)employee
from employee table 
INNER JOIN
employee on EMPLOYEE.EMPLOYEEID = EMPLOYEE.REPORTSTO;
/
9.0 ADMINISTRATION
In this section you will be creating backup files of your database. After you create the backup file you
will also restore the database. Research or try random things then communicate with batchmates, do
not ask trainer.
Task – Create a .bak file for the Chinook database.
/*
Click tools on the top of the screen 
select the database from the "connection" drop down menu 
click the next button * 4 
 then the finish button 
to restore database from a backup:
open.bak file in tex editor(notepad or notepad++)
copy file in and open .sql file in oracle sql 
click on the run script button.
*/




BOUNUS 
Join EVERY TABLE in the chinook database in a single join statement.
SELECT
CONCAT (EMPLoyee. 