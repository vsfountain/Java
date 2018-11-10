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
/*CREATE OR REPLACE TRIGGER customertable
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('insert was sucessful');
END;
/
SELECT * FROM Customer;
INSERT INTO customer values (60, Krissy, Apple, Talented, 466, Maple st, Orange,FL,123-404-8549,786-812-6789,kave@me.com,6);
--delete from Customer( 50, Krissy, Apple, Talented llc, 466 Maple st,Orange,FL,123-404-8549,786-812-6789,kave@me.com,6) 
commit;
/*/
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' and lastname ='Mitchell';
UPDATE ARTIST SET NAME = 'CCR' WHERE  NAME = 'Creedence Clearwater Revival';
select * From invoice where billingaddress like 'T%';
SELECT * from invoice where total between 15 and 50;
SELECT * from employee where hiredate between '01-jun-03' and '01-mar-04';
--SELECT * from  CUSTOMER;
--Delete from customer where  firstname = 'Robert' and Lastname = 'Walter';// delete the invoice
CREATE OR REPLACE PROCEDURE current_time_in_Tampa AS
        BEGIN
            DBMS_OUTPUT.PUT_lINE ('The current time in virginia is' 
             || to_Char (SYSDATE, 'MM-DD-YY HH:MI:SS AM'));
        END;
/
SELECT SYSDATE FROM DUAL;
SELECT * FROM MEDIATYPE;
SELECT length (name)as len
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
Task – Create a function that returns the most expensive track
CREATE FUNCTION Mostexpensive(@invoiceline_total)
return
select Title,unitprice
from invoiceline;
where unitprice>1.00;
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
SELECT * FROM employee;
SELECT * FROM employee where birthdate 
