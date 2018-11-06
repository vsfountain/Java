--2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname='King';
SELECT * FROM employee WHERE firstname='Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city;
--2.3 INSERT INTO
SELECT * FROM genre;
INSERT INTO genre VALUES(26,'Reiki');
INSERT INTO genre VALUES(27,'Sleep Sounds');
SELECT * FROM employee;
INSERT INTO employee VALUES(9, 'John','Savath','Student','2','06-MAY-85','09-JAN-99',
    '6500 Glenmore Ave','Philadelphia','PA','USA','19142','+1 (267) 444-3695', '+1 (267) 444-3699','johnsavath@chinookcorp.com');
INSERT INTO employee VALUES(10, 'Lu','Zheying','Student','1','12-AUG-86','09-JAN-99',
    '6500 Glenmore Ave','Philadelphia','PA','USA','19142','+1 (267) 893-8899', '+1 (267) 333-6767','zheyinglu@chinookcorp.com');
SELECT * FROM customer;
INSERT INTO customer VALUES(60, 'BingBing','Fan',null,
    '2121 Hollywood BLVD', 'Los Angeles', 'CA','USA','90210','+1 (310) 234-9754',null,'fanbb@yahoo.com','3');
INSERT INTO customer VALUES(61, 'Tony','Starks',null,
    '1 Google Drive', 'Los Angeles', 'CA','USA','90210','+1 (310) 420-2121',null,'tonystarks@twitter.com','2');
--2.4 UPDATE
SELECT * FROM customer;--displaying customer table to look at fields
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE customerid='32';
SELECT * FROM artist ORDER BY name;--double checking my work
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';
--2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
--2.7 DELETE
ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;-----remove constraint from invoice table to delete Robert Walter
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';
------3.0 SQL FUNCTIONS------
--3.1 System Defined Functions
SELECT CURRENT_TIMESTAMP from dual;
SELECT LENGTH(name) "Length of MPEG audio file" 
    FROM mediatype WHERE name='MPEG audio file';
--3.2 System Defined Aggregate Functions
SELECT AVG(total) FROM invoice;
SELECT MAX(unitprice) FROM track;
--3.3 User Defined Scalar Functions
SELECT AVG(unitprice) FROM INVOICELINE;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
--3.4 User Defined Table Valued Functions
SELECT * FROM employee WHERE birthdate > '01-DEC-68';
------4.0 Stored Procedures-----
--4.1 Basic Stored Procedure
drop procedure GET_EMPLOYEE_NAME_procedure;
drop procedure GET_EMPLOYEE_NAME;
-------------------------------------------------------
CREATE OR REPLACE PROCEDURE employee_details(
        e_selectall IN OUT SYS_REFCURSOR)
IS
BEGIN
    
  OPEN e_selectall FOR
  SELECT firstname, lastname
  from  employee;

END;
/
----------------------------

DECLARE 
   myrefcur sys_refcursor;
   firstname employee.firstname%type;
   lastname employee.lastname%type;
 BEGIN
   employee_details(myrefcur);
   LOOP
     FETCH myrefcur INTO firstname,lastname;
     EXIT WHEN myrefcur%notfound;
     dbms_output.put('NAME: '|| firstname|| ' ');
     dbms_output.put_line(lastname);
   END LOOP;
   CLOSE myrefcur;
 END;
/
------------------------------------------------------
--4.2 Stored Procedure Input Parameters

CREATE OR REPLACE PROCEDURE set_employee_bdate(
        e_id IN employee.employeeid%TYPE, 
        e_fname OUT employee.firstname%TYPE, e_lname OUT employee.lastname%TYPE,
        e_birthdate IN employee.birthdate%TYPE)
IS    
BEGIN
    UPDATE employee SET birthdate = e_birthdate where employeeid = e_id;
    COMMIT;    
END;
/

DECLARE
    e_id NUMBER;
    e_fname VARCHAR2(4000);
    e_lname VARCHAR2(4000);
    e_birthdate DATE;
BEGIN
    set_employee_bdate(9,e_fname, e_lname,'11-MAY-87');
END;
/

--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE get_customer_name(c_id IN NUMBER
        , c_fname OUT customer.firstname%TYPE, c_lname OUT customer.lastname%TYPE,
        c_company OUT customer.company%TYPE)
IS    
BEGIN
    SELECT firstname, lastname, company 
        INTO c_fname, c_lname, c_company FROM customer WHERE customerid = c_id;
END;
/
DECLARE
    c_id NUMBER;
    c_fname VARCHAR2(4000);
    c_lname VARCHAR2(4000);
    c_company VARCHAR2(4000);
BEGIN
    get_customer_name(19,c_fname,c_lname,c_company);
    DBMS_OUTPUT.PUT_LINE('Name: ' || c_fname|| ' '  || c_lname);
    DBMS_OUTPUT.PUT_LINE('Company: ' || c_company);
END;
/
------5.0 Transactions-------
--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
SET TRANSACTION NAME 'del_invoice_id';
ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;-----remove constraint from invoice table to delete Robert Walter
DELETE FROM INVOICE WHERE invoiceid=223;
commit;---END of transaction name del_invoice_id
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
SET TRANSACTION NAME 'insert_new_customer';
CREATE OR REPLACE PROCEDURE add_new_customer(
        c_id IN customer.customerid%TYPE, 
        c_fname IN customer.firstname%TYPE, c_lname IN customer.lastname%TYPE,
        c_company IN customer.company%TYPE, c_address IN customer.address%TYPE,
        c_city IN customer.city%TYPE, c_state IN customer.state%TYPE, c_country IN customer.country%TYPE,
        c_postalcode IN customer.postalcode%TYPE, c_phone IN customer.phone%TYPE, c_fax IN customer.fax%TYPE,
        c_email IN customer.email%TYPE, c_supportrepid IN customer.supportrepid%TYPE)
IS    
BEGIN
    INSERT INTO customer VALUES(c_id, c_fname, c_lname, c_company, c_address, c_city, c_state, c_country, 
    c_postalcode, c_phone, c_fax, c_email, c_supportrepid);
    COMMIT;    
END;
/
DECLARE
BEGIN
    ADD_NEW_CUSTOMER(62, 'Kira','Fabel',null,
    '212 Comic Lane', 'Philadelphia', 'PA','USA','19142','+1 (215) 345-1199',null,'KiraF@gmail.com','1');
END;
/
------6.0 Triggers-----------
--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER employee_insert
AFTER INSERT ON employee
FOR EACH ROW
DECLARE
BEGIN

        DBMS_OUTPUT.PUT_LINE('AFTER TRIGGER INSERT HAS HAPPENED');
END;
/
DROP TRIGGER new_employee_insert;
--exec
INSERT INTO employee VALUES(11,'Buddy','Tom',null,null,
    '','','','','',
    '','','','','');
commit;--after trigger will print my created dbms output once it is committed

DELETE FROM employee where employeeid=11;
-----------------------
CREATE OR REPLACE TRIGGER album_update
AFTER UPDATE ON album
FOR EACH ROW
DECLARE
BEGIN
        DBMS_OUTPUT.PUT_LINE('AFTER TRIGGER UPDATE HAS HAPPENED');
END;
/
-------------------------
UPDATE album SET title='Exile' WHERE title='Facelift';
commit;
--------------------------
CREATE OR REPLACE TRIGGER customer_delete
AFTER DELETE ON customer
FOR EACH ROW
DECLARE
BEGIN
        DBMS_OUTPUT.PUT_LINE('AFTER TRIGGER DELETE HAS HAPPENED');
END;
/

------------------------------

SELECT * FROM customer;

----------------------------------
DELETE FROM customer WHERE firstname='Kara' AND lastname='Nielsen';
commit;--dbms output will print after commit 
-------7.0 JOINS-------
--7.1 INNER
SELECT a.firstname, a.lastname,b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid=b.invoiceid;
--7.2 OUTER
SELECT a.customerid, a.firstname, a.lastname, b.INVOICEID,b.TOTAL
    FROM customer a LEFT OUTER JOIN invoice b ON a.customerid=b.invoiceid;
--7.3 RIGHT
SELECT name AS artist,title FROM artist a RIGHT OUTER JOIN album b ON a.artistid = b.artistid; 
--7.4 CROSS
SELECT b.NAME,a.TITLE FROM album a CROSS JOIN artist b ORDER BY b.NAME; 
--7.5 SELF
SELECT * FROM employee a INNER JOIN employee b ON a.employeeid=b.reportsto;
------9.0 Administration
--exporting a database into a .sql file to .bak
--Tools>>Database Export >> Selection connection>> checkbox all DDL as true >> 
-- rename file type from sql to bak >> next >> next >> next >> next (for a forth time) >> finish.

--file saved as sqlhomework.bak


----------------BONUS QUESTION--------------
---Join EVERY TABLE in the chinook database 
--in a single join statement.
--TRACKID from TRACK
--PLAYLISTID from PLAYLIST
--MEDIATYPEID FROM MEDIATYPE
--INVOICELINEID FROM INVOICELINE
--INVOICEID FROM INVOICE
--GENREID FROM GENRE
--EMPLOYEEID FROM EMPLOYEE
--CUSTOMERID FROM CUSTOMER
--ARTISTID FROM ARTIST
--ALBUMID FROM ALBUM
SELECT * FROM album JOIN artist ON ALBUM.ALBUMID = artist.ARTISTID
JOIN customer ON artist.ARTISTID = customer.CUSTOMERID
JOIN employee ON customer.CUSTOMERID = employee.EMPLOYEEID
JOIN genre ON employee.EMPLOYEEID = genre.GENREID
JOIN INVOICE ON genre.GENREID = INVOICE.INVOICEID
JOIN INVOICELINE ON INVOICE.INVOICEID = INVOICELINE.INVOICEID
JOIN MEDIATYPE ON MEDIATYPE.MEDIATYPEID = INVOICELINE.INVOICEID
JOIN PLAYLIST ON PLAYLIST.PLAYLISTID = MEDIATYPE.MEDIATYPEID
JOIN PLAYLISTTRACK ON PLAYLISTTRACK.PLAYLISTID = PLAYLIST.PLAYLISTID 
JOIN TRACK ON TRACK.TRACKID = PLAYLISTTRACK.PLAYLISTID;


