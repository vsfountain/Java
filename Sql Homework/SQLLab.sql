--2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname='King';
SELECT * FROM employee WHERE lastname='Andrew' AND REPORTSTO IS NULL;

--2.2 Order By
SELECT * FROM album ORDER BY title DESC;
SELECT * FROM customer ORDER BY city;

--2.3 INSERT INTO
SELECT * FROM genre;
INSERT INTO genre  VALUES(26, 'Hello');
INSERT INTO genre VALUES(27, 'Howdy');

SELECT * FROM employee;
INSERT INTO employee VALUES(9, 'Grammens', 'Michael', 'Sales Manager', '5', '20-MAY-1993', '10-OCT-1999', '12312 8 eq st', 'New York', 'New York', 'United States', 'T1K 5N9', '230 555-5555', '230 555-5555', 'mike@chinookcorp.com');
INSERT INTO employee VALUES(10, 'Grammens', 'Mike', 'Sales Manager', '5', '20-MAY-1993', '10-OCT-1999', '12312 8 eq st', 'New York', 'New York', 'United States', 'T1K 5N7', '230 555-5555', '230 555-5555', 'michael@chinookcorp.com');

SELECT * FROM customer;
INSERT INTO customer VALUES(60, 'Michael', 'Grammens', 'null', '12312 8 eq st', 'New York', 'New York', 'United States', '3037', '230 555-5555', '230 555-5555', 'mike@chinook.com', '4');
INSERT INTO customer VALUES(61, 'Michael', 'Grammens', 'null', '12312 8 eq st', 'New York', 'New York', 'United States', '3037', '230 555-5555', '230 555-5555', 'mike@chinook.com', '4');

--2.4 UPDATE
SELECT * FROM customer;
SELECT * FROM customer WHERE firstname='Aaron';
SELECT * FROM customer WHERE firstname='Robert';
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';
SELECT * FROM artist;
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM invoice;
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-Jun-03' AND '01-March-04';

--2.7 DELETE
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT * FROM invoiceline;
SELECT * FROM customer WHERE firstname='Robert' AND lastname='Walter';
DELETE invoiceline WHERE  invoiceid=(SELECT invoiceid FROM invoice WHERE customerid=(SELECT customerid FROM customer WHERE firstname='Robert' AND lastname='Walter'));
UPDATE customer SET customerid=NULL WHERE firstname='Robert' AND lastname='Walter';

--3.1 System Defined Functions
SELECT * FROM mediatype;
CREATE OR REPLACE FUNCTION return_time
RETURN VARCHAR2
IS  
    current_time VARCHAR2(100);
BEGIN
    SELECT current_timestamp INTO current_time FROM DUAL;
    RETURN current_time;
END;
/

DECLARE
    get_time VARCHAR2(100);
BEGIN
    get_time := return_time();
    DBMS_OUTPUT.PUT_Line(get_time);
END;
/

CREATE OR REPLACE FUNCTION return_length
RETURN NUMBER
IS
    current_length NUMBER;
BEGIN
    SELECT LENGTH(name) INTO current_length FROM mediatype WHERE mediatypeid='1';
    return current_length;
END;
/

DECLARE
    get_length NUMBER;
BEGIN
    get_length := return_length();
    DBMS_OUTPUT.PUT_Line(get_length);
END;
/
    
--3.2 System Defined Aggregate functions
SELECT * FROM invoice;
SELECT * FROM track;
SELECT AVG(total) FROM invoice;
SELECT MAX(unitprice) FROM track;

--3.3 User Defined Scalar Functions
SELECT AVG(unitprice) FROM invoiceline; ---------------------------------------- NOT A SCALAR FUNCTION THOUGH???
SELECT unitprice a FROM invoiceline WHERE a+(SELECT unitprice FROM invoiceline);

SELECT * FROM invoiceline;
DESC invoiceline;

CREATE OR REPLACE FUNCTION get_avg
RETURN NUMBER
IS
    iterator NUMBER;
    counter NUMBER;
    currNum NUMBER;
    currIdNum NUMBER;
BEGIN
    currNum := 1;
    SELECT COUNT(*) INTO counter FROM invoiceline;
    FOR iterator IN 1 .. counter
    LOOP
        SELECT unitprice INTO currIdNum FROM invoiceline WHERE invoicelineid=iterator;
        currNum := currNum+currIdNum;
    END LOOP;
    currNum := currNum / counter;
    RETURN currNum;
END;
/

DECLARE
    currNum NUMBER;
BEGIN
    currNum := get_avg();
    DBMS_OUTPUT.PUT_Line(currNum);
END;
/

--3.4 User defined table valued functions
SELECT * FROM employee;
DESC employee;

DROP TABLE birthdays;
CREATE TABLE birthdays(
birthdates DATE
);

DECLARE
    birthday DATE;
    iterator NUMBER;
    counter NUMBER;
BEGIN
    SELECT COUNT(*) INTO counter FROM employee;
    FOR iterator IN 1 .. counter
    LOOP
        SELECT birthdate INTO birthday FROM employee WHERE employeeid=iterator;
        IF birthday > '01-JAN-69' THEN
            INSERT INTO birthdays VALUES(birthday);
        END IF;
    END LOOP;
END;
/
SELECT * FROM birthdays;

--4.1 BASIC STORED PROCEDURES
SELECT * FROM employee;
DESC employee;

DROP TABLE employees;
CREATE TABLE employees(
firstname VARCHAR(20),
lastname VARCHAR(20)
);

CREATE OR REPLACE PROCEDURE employee_names
IS
    iterator NUMBER;
    counter NUMBER;
    firstnamee VARCHAR(20);
    lastnamee VARCHAR(20);
BEGIN
    SELECT COUNT(*) INTO counter FROM employee;
    for iterator IN 1 .. counter
    LOOP
        SELECT firstname INTO firstnamee FROM employee WHERE employeeid=iterator;
        SELECT lastname INTO lastnamee FROM employee WHERE employeeid=iterator;
        INSERT INTO employees VALUES(firstnamee, lastnamee);
    END LOOP;
END;
/

BEGIN
    employee_names;
END;
/
SELECT * FROM employees;

--4.2 STORED PROCEDURE INPUT PARAMETERS
SELECT * FROM employee;
DESC employee;
CREATE OR REPLACE PROCEDURE update_employee(employee_id IN NUMBER)
IS
BEGIN
    UPDATE employee SET employeeid=employee_id, lastname='Adams', firstname='Andrew', title='General Manager', reportsto=1, birthdate='18-FEB-62', hiredate='14-AUG-02', address='11120 Jasper Ave NW', city='Edmonton', state='AB', country='Canada', postalcode='T5k 2N1', phone='+1 (780) 428-9482', fax='+1 (780) 428-3457', email='andrew@chinookcorp.com' WHERE employee_id=employeeid;
END;
/

DECLARE
    currEmployee NUMBER;
BEGIN
    currEmployee := 1;
    update_employee(currEmployee);
END;
/

SELECT * FROM employee;
DESC employee;
CREATE OR REPLACE PROCEDURE managers(currEmployee IN NUMBER, firstNameManager OUT employee.firstname%TYPE, lastNameManager OUT employee.lastname%TYPE, firstNameHighManager OUT employee.firstname%TYPE, lastNameHighManager OUT employee.lastname%TYPE, booleanManager OUT NUMBER)
IS
BEGIN
    SELECT firstname INTO firstNameManager FROM employee WHERE currEmployee=employeeid;
    SELECT lastname INTO lastNameManager FROM employee WHERE currEmployee=employeeid;
    IF currEmployee>1 THEN
        booleanManager := 1;
        SELECT firstname INTO firstNameHighManager FROM employee WHERE employeeid=1;
        SELECT lastname INTO lastNameHighManager FROM employee WHERE employeeid=1;
    END IF;
END;
/

DECLARE
    firstNameHighManager VARCHAR2(20);
    lastNameHighManager VARCHAR2(20);
    firstNameManager VARCHAR2(20);
    lastNameManager VARCHAR2(20);
    
    booleanManager NUMBER;
BEGIN
    booleanManager := 0;
    managers(2, firstNameManager, lastNameManager, firstNameHighManager, lastNameHighManager, booleanManager);
    DBMS_OUTPUT.PUT_Line('Current manager: ' || firstNameManager || ' ' || lastNameManager);
    IF booleanManager = 1 THEN
        DBMS_OUTPUT.PUT_Line('Higher up manager: ' || firstNameHighManager || ' ' || lastNameHighManager);
    END IF;
END;
/
--4.3 STORED PROCEDURE OUTPUT PARAMETERS
SELECT * FROM customer;
DESC customer;
CREATE OR REPLACE PROCEDURE customerInfo(customer_Id IN NUMBER, customerName OUT customer.firstname%TYPE, customerCompany OUT customer.company%TYPE)
IS
BEGIN
    SELECT firstname INTO customerName FROM customer WHERE customerid=customer_Id;
    SELECT company INTO customerCompany FROM customer WHERE customerid=customer_Id;
END;
/

DECLARE
    customerName VARCHAR2(40);
    customerCompany VARCHAR2(80);
BEGIN
    customerInfo(1, customerName, customerCompany);
    DBMS_OUTPUT.PUT_Line('Customers name: ' || customerName || ' Customers company: ' || customerCompany);
END;
/
--5.0 TRANSACTIONS
SELECT * FROM invoice;
SELECT * FROM customer;
SELECT * FROM invoiceline;
DESC invoice;
DESC invoiceline;

CREATE OR REPLACE PROCEDURE transactionOne(getinvoice IN NUMBER)
IS
BEGIN
    SET TRANSACTION NAME 'hello';
    DELETE FROM invoiceline WHERE invoiceid=getinvoice;
    DELETE FROM invoice WHERE invoiceid=getinvoice;
    commit;
END;
/

SELECT * FROM invoiceline;
SELECT * FROM invoice;
BEGIN
    transactionOne(2);
END;
/

SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE newCustomer
IS
BEGIN
    SET TRANSACTION NAME 'addNewCustomer';
    INSERT INTO customer VALUES(60, 'Michael', 'Grammens', 'Revature', 'N/A', 'Tampa Bay', 'Florida', 'United States', '14980', '253 548 7010', '(null)', 'mikeanike@awesome.com', '3');
    COMMIT;
END;
/

BEGIN
    newCustomer;
END;
/
SELECT * FROM customer;

--6.1 TRIGGERS (AFTER/FOR)

CREATE OR REPLACE TRIGGER employeeTable
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('An insert took place on table employee');
END;
/
SELECT * FROM employee;
INSERT INTO employee VALUES(16, 'Grammens', 'Michael', 'AwesomeSauce', '1', '20-MAY-93', '23-OCT-18', '1920 compiler error Street', 'YOLO', 'FL', 'United States', 'T5k 2P0', '+1 (230) 278-2523', '+1 (230) 278-2523', 'MichaelsPandaCookies@revature.com');
COMMIT;

CREATE OR REPLACE TRIGGER albumUpdated
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('Updated occured on table album');
END;
/

SELECT * FROM album;
UPDATE album SET TITLE='Hello World' WHERE albumid=5;
COMMIT;

CREATE OR REPLACE TRIGGER customerDeleted
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_Line('A deletion has happened on customer');
END;
/

SELECT * FROM customer;
--DELETE commands
commit;

--7.1 INNER JOIN
SELECT * FROM customer;
SELECT * FROM invoice;

SELECT firstname, lastname, invoiceid FROM customer b INNER JOIN invoice c ON b.customerid=c.customerid;

--7.2 OUTER JOIN
SELECT custom.customerid, firstname, lastname, invoiceid, total FROM customer custom FULL OUTER JOIN invoice c ON custom.customerid=c.customerid;
--7.3 RIGHT JOIN
SELECT * FROM album;
SELECT * FROM artist;
SELECT name, title FROM album a RIGHT JOIN artist b ON a.artistid=b.artistid;
--7.4 CROSS JOIN
SELECT name FROM album a CROSS JOIN artist b;
--7.5 SELF JOIN
SELECT * FROM employee;
SELECT * FROM employee a INNER JOIN employee b ON a.reportsto=b.reportsto; 
--9.0 ADMINISTRATION
--Tools, database export, select the database you wish to export, click on the file type and multiple files. 

DELETE FROM employee WHERE employeeid=1;
--BONUS QUESTION (Join every table in the chinook database in a single join statement)
SELECT * FROM album;                        --albumid, artistid
SELECT * FROM artist;                       --artistid
SELECT * FROM customer;                     --customerid, supportrepid
SELECT * FROM employee;                     --employeeid
SELECT * FROM genre;                        --genreid
SELECT * FROM invoice;                      --invoiceid, customerid
SELECT * FROM invoiceline;                  --invoicelineid, invoiceid, trackid
SELECT * FROM mediatype;                    --mediatypeid
SELECT * FROM playlist;                     ---playlistid
SELECT * FROM playlisttrack;               -----playlistid, trackid
SELECT * FROM track;                      -----trackid, albumid, genreid, mediatypeid
SELECT * FROM employee,
SELECT * FROM employee LEFT OUTER JOIN customer ON employee.employeeid=customer.supportrepid a LEFT OUTER JOIN invoice ON a.customerid=invoice.customerid;
SELECT * FROM track LEFT OUTER JOIN mediatype ON track.mediatypeid=mediatype.mediatypeid;

SELECT *
FROM album, artist, customer, employee, genre, invoice, invoiceline, mediatype, playlist, playlisttrack, track;