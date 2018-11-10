SELECT * FROM employee;
SELECT * FROM employee WHERE LASTNAME = 'King';
SELECT * FROM employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
SELECT * FROM album;
SELECT * FROM album ORDER BY album.title DESC;
SELECT * FROM CUSTOMER;
SELECT Firstname FROM Customer  ORDER BY CITY ASC;
SELECT * FROM Genre;
INSERT INTO Genre ( GenreID, name) VALUES (26, 'Soca');
INSERT INTO Genre ( GenreID, name) VALUES (27, 'Calypso');
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
SELECT * FROM CUSTOMER;
CREATE SEQUENCE CUSTOMER_SEQ
START WITH 59 
INCREMENT BY 1;
CREATE OR REPLACE TRIGGER customertable
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
---INSERT INTO CUSTOMER values (61, 'KrisTEN', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');
    DBMS_OUTPUT.PUT_Line('insert COMPLETE');
--DROP TRIGGER customertable;
END;
/
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER values (60,'60', 'Krissy', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');
INSERT INTO CUSTOMER values (61, '60', 'KrisTEN', 'Apple', 'Talented ONLY', '466 Maple st', 'Orange','FL', '45676','123-404-8549','786-812-6789','kave@me.com','6');
commit;
/
SELECT * FROM Customer;

SELECT * FROM CUSTOMER;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' and lastname ='Mitchell';
commit;
/
UPDATE ARTIST SET NAME = 'CCR' WHERE  NAME = 'Creedence Clearwater Revival';
commit;
/
select * From invoice where billingaddress like 'T%';
commit;
/
SELECT * from invoice where total between 15 and 50;
commit;
/
SELECT * from employee where hiredate between '01-jun-03' and '01-mar-04';
commit;
/
SELECT * from  CUSTOMER;
Delete from customer where  firstname = 'Robert' and Lastname = 'Walter';// delete the invoice
commit;
/
CREATE OR REPLACE PROCEDURE current_time_in_Tampa AS
        BEGIN
            DBMS_OUTPUT.PUT_lINE ('The current time in virginia is' 
             || to_Char (SYSDATE, 'MM-DD-YY HH:MI:SS AM'));
        END;
/
SELECT SYSDATE FROM DUAL;
SELECT * FROM MEDIATYPE;
SELECT length ('name')as len
from 
mediatype
order by len;
/
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
--EXEC INVOICELINE_TOTAL;
SELECT * FROM INVOICE
SELECT MAX (TOTAL) FROM INVOICE;
Task – Create a function that returns the most expensive track
CREATE FUNCTION Mostexpensive(@invoiceline_total)
return
select Title,unitprice
from invoiceline;
where unitprice > 1.00;
end;

--EXEC INVOICELINE_TOTAL;
--SELECT * FROM INVOICE;
--SELECT MAX (TOTAL) FROM INVOICE;
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;
SELECT AVG (unitprice) FROM INVOICELINE;
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

SELECT * FROM employee;
SELECT * FROM employee where birthdate > DATE '1968-01-01';

--compiled unable to execute
Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure GetEmployeesnames 
as
select Firstname, Lastname from Employee
where lastname is not null;
commit;
/

EXEC GetEmployeesnames;
-----
Stored Procedure Input Parameters
---- compiled
section 4.2 Task – Create a stored procedure that updates the personal information of an employee.
Create or Replace procedure update_employee(employeeID in number, lastname in varchar2, 
firstname in varchar2, birthdate in date, address in varchar2);
is 
begin
update employee values (employeeID,lastname,firstname,birthdate,address);
commit;
end;
/
--compiled
Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE procedure stpr_first_last_emp(vc_cursor out SYS_REFCURSOR)
 is 
 employee_c sys_refcursor;
 BEGIN 
 open employee c for SELECT *FROM EMPLOYEE WHERE 
 REPORTSTO >=1 IS  not NULL;
 return employee_c
 end;
 /
SELECT * FROM CUSTOMER;
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
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
9.0 ADMINISTRATION
In this section you will be creating backup files of your database. After you create the backup file you
will also restore the database. Research or try random things then communicate with batchmates, do
not ask trainer.
Task – Create a .bak file for the Chinook database.

BOUNUS 
Join EVERY TABLE in the chinook database in a single join statement.