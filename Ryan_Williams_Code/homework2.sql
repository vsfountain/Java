--SQL Queries
--2.1 Select Queries
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND REPORTSTO IS NULL;
---2.2 Order By
SELECT * FROM album ORDER BY title DESC;
SELECT firstname, city FROM customer ORDER BY city;
--2.3 Insert Into
INSERT INTO genre VALUES (26, 'Classic Rap opera');
INSERT INTO genre VALUES (27, 'Historical War Concierto');
SELECT * FROM genre ORDER BY 1;

INSERT INTO employee (employeeid, lastname, firstname) VALUES (9, 'Mitchell', 'Thomas');
INSERT INTO employee (employeeid, lastname, firstname) VALUES(10, 'Williams','Lucas');
SELECT * FROM employee ORDER BY 1;

INSERT INTO customer (customerid, firstname, lastname, email) VALUES (60, 'Harry', 'Weinberg', 'rngemail@gmail.com');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES(61, 'Thomas', 'Thomas', 'rng2email@gmail.com');
SELECT * FROM customer ORDER BY customerid;
--2.4 Update
UPDATE customer SET firstname ='Robert', lastname ='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';
UPDATE artist SET name ='CCR' WHERE name = 'Creedence Clearwater Revival';
SELECT * FROM artist ORDER BY name;
--2.5 Like
SELECT * FROM invoice WHERE BILLINGADDRESS LIKE 'T%';
--2.6 Between
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
--2.7 Delete
--116,  342,  245,   268,  290,  50,   61
DELETE FROM INVOICELINE WHERE invoiceid= 116;
DELETE FROM INVOICELINE WHERE invoiceid= 342;
DELETE FROM INVOICELINE WHERE invoiceid= 245;
DELETE FROM INVOICELINE WHERE invoiceid= 268;
DELETE FROM INVOICELINE WHERE invoiceid= 290;
DELETE FROM INVOICELINE WHERE invoiceid= 50;
DELETE FROM INVOICELINE WHERE invoiceid= 61;
DELETE FROM invoice WHERE customerid = 32;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
SELECT * FROM customer ORDER BY firstname;
--3.0 SQL functions
---3.1 System Defined functions
SELECT current_timestamp (3) FROM dual;-----review this
SELECT Length(name) FROM mediatype WHERE mediatypeid=1;
--3.2 System Defined Aggregate Functions
SELECT AVG(total) FROM invoice;
SELECT MAX(unitprice) FROM track;
--3.3 User defined scalar functions
CREATE OR REPLACE FUNCTION avgprice 
RETURN NUMBER
IS
    avgpricenum NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avgpricenum FROM invoiceline;
    RETURN avgpricenum;
END;
/
DECLARE
    avgpricenum NUMBER;
BEGIN
    avgpricenum := avgprice();
    DBMS_OUTPUT.PUT_LINE('average price: ' || avgpricenum);
END;
/
--3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
is
    EMPLOYEE_C SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968', 'DD-MM-YYYY');
    return EMPLOYEE_C;
END;
/

SELECT after_1968 from dual;
SELECT * FROM employee;

SET SERVEROUTPUT ON;
--4.0 Stored Procedures
---4.1 Basic Stored Procedure

CREATE OR REPLACE PROCEDURE get_employee
IS
    p_fname VARCHAR2(20);
    p_lname VARCHAR2(20);
    i NUMBER;
    tracker NUMBER;
BEGIN
    SELECT COUNT (*) INTO tracker FROM employee;
    for i IN 1 .. tracker
    loop
    SELECT firstname INTO p_fname FROM employee WHERE employeeid=i;
    DBMS_OUTPUT.PUT_LINE(p_fname);
    SELECT lastname INTO p_lname FROM employee WHERE employeeid=i; 
    DBMS_OUTPUT.PUT_LINE(p_lname);
    end loop;
END;
/
  
BEGIN
    get_employee;
END;
/

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE edit_employee
IS

BEGIN
    UPDATE employee SET firstname = 'newnamehere' WHERE employeeid = 2;
END;
/
BEGIN
    edit_employee;
END;
/
SELECT firstname FROM employee WHERE employeeid=2;
CREATE OR REPLACE PROCEDURE find_manager
IS
    p_manager NUMBER;
BEGIN
    SELECT reportsto INTO p_manager FROM employee WHERE employeeid=3;
    DBMS_OUTPUT.PUT_LINE(p_manager);
END;
/
BEGIN
    find_manager;
END;
/
--4.3 Store Procedure Output Parameters
CREATE OR REPLACE PROCEDURE get_customerInfo
IS
    p_fname VARCHAR2(40);
    p_lname VARCHAR2(20);
    p_company VARCHAR2(80);
BEGIN
--DBMS_OUTPUT.PUT_LINE('test');
    SELECT firstname INTO p_fname FROM customer  WHERE customerid = 1;
    SELECT lastname INTO p_lname FROM customer WHERE customerid = 1;
    SELECT company INTO p_company FROM customer WHERE customerid = 1;
    DBMS_OUTPUT.PUT_LINE(p_fname);
    DBMS_OUTPUT.PUT_LINE(p_lname);
    DBMS_OUTPUT.PUT_LINE(p_company);
    
END;
/
BEGIN 
    get_customerinfo;
END;
/
--5.0 Transactions
--2.7 Delete
CREATE OR REPLACE PROCEDURE delete_invoice
IS
BEGIN
--    DELETE FROM INVOICELINE WHERE invoiceid= 116;
--    DELETE FROM INVOICELINE WHERE invoiceid= 342;
--    DELETE FROM INVOICELINE WHERE invoiceid= 245;
--    DELETE FROM INVOICELINE WHERE invoiceid= 268;
--    DELETE FROM INVOICELINE WHERE invoiceid= 290;
--    DELETE FROM INVOICELINE WHERE invoiceid= 50;
--    DELETE FROM INVOICELINE WHERE invoiceid= 61;
--    DELETE FROM invoice WHERE customerid = 32;
    DELETE FROM invoiceline WHERE invoiceid = 122;
    DELETE FROM invoice WHERE invoiceid = 122;
    commit;
END;
/    

BEGIN
    delete_invoice;
END;
/

SELECT * FROM customer;
DESC customer;
CREATE OR REPLACE PROCEDURE set_newcustomerRecord
IS
BEGIN
    INSERT INTO customer (
    customerid,
    firstname,
    lastname,
    email
    )
    VALUES (
        '100',
        'Anuname',
        'Anulastname',
        'anu@gmail.com'
    );
    commit;
END;
/
BEGIN
    SET_NEWCUSTOMERRECORD;
END;
/
--6.0 Triggers
--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER after_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record has been inserted into employee');
END;
/

--INSERT INTO employee 
--    VALUES (50, 'Anuname', 'Anulastname','a',1,'31-OCT-18','30-OCT-18','a','a','a','a','a','a','a','a');
-- commit;
 
CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record has been updated in album');
END;
/
DESC album;
SELECT * FROM album;
--UPDATE album SET title = 'test Halen' WHERE title='Van Halen';
commit;

CREATE OR REPLACE TRIGGER after_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A record has been deleted in customer');
END;
/
--7.0
--7.1 Inner Joins
SELECT customer.customerid, invoiceid  FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid;
--7.2 OUTER
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
--7.3 RIGHT
SELECT artist.name, album.title FROM album RIGHT OUTER JOIN artist ON artist.artistid = album.artistid;
--7.4 CROSS
SELECT artist.name FROM album CROSS JOIN artist ORDER BY artist.name;
--7.5 SELF
SELECT * FROM employee a, employee b WHERE a.reportsto = b.reportsto;
9.0
--Backup
--At the menu bar I selected tools -> database export then hit next until I created the backup file
--Bonus Question
--Join EVERY TABLE in the chinook database in a single join statement.
--Need to see how each table is connected using the erds then join each table at the common columns