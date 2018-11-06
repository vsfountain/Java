-- 2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS null;

-- 2.2 ORDER BY
SELECT * FROM album;
SELECT title FROM album ORDER BY title DESC;

SELECT * FROM customer;
SELECT firstname FROM customer ORDER BY city;

-- 2.3 INSERT INTO
SELECT * FROM genre;
DESC genre;
DESC employee;
DESC customer;
INSERT INTO genre VALUES(26, 'Bluegrass');
INSERT INTO genre VALUES(27, 'German House Music');

INSERT INTO employee(employeeid, lastname, firstname, title) VALUES(12, 'Lightyear', 'Buzz', 'Space Ranger');
INSERT INTO employee (employeeid, lastname, firstname, title) VALUES(10, 'Ryan', 'Williams', 'Software Developer');

INSERT INTO customer(customerid, firstname, lastname, email) VALUES(60, 'Phillip', 'Pride', 'ppride@gmail.com');
INSERT INTO customer(customerid, firstname, lastname, email) VALUES(61, 'Ryan', 'Williams', 'rwilliams@gmail.com');

-- 2.4 UPDATE
UPDATE customer SET firstname = 'Robert' WHERE firstname='Aaron';
UPDATE customer SET lastname = 'Walter' WHERE lastname='Mitchell';
Select * FROM artist WHERE artistid = 76;
UPDATE artist SET name = 'CCR' WHERE artistid=76;

-- 2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('01-JUN-03') AND TO_DATE('01-MAR-04');

-- 2.7 DELETE
SELECT * FROM customer WHERE firstname = 'Robert';
commit;
SELECT * FROM invoice WHERE customerid=29;
DELETE FROM customer WHERE firstname = 'Robert';
DELETE FROM invoiceline WHERE invoiceid = 245;
DELETE FROM invoiceline WHERE invoiceid = 268;
DELETE FROM invoiceline WHERE invoiceid = 290;
DELETE FROM invoiceline WHERE invoiceid = 342;
DELETE FROM invoiceline WHERE invoiceid = 50;
DELETE FROM invoiceline WHERE invoiceid = 61;
DELETE FROM invoiceline WHERE invoiceid = 116;
DELETE FROM invoiceline WHERE invoiceid IN (245, 268, 290);
DELETE FROM invoice WHERE customerid=(SELECT customerid FROM customer WHERE firstname = 'Robert' AND lastname='Walter');
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';

-- 3.0 Functions
-- 3.1 System Defined Functions
SELECT current_timestamp(1) FROM dual;
SELECT name, length(name) FROM mediatype;

-- 3.2 System Defined Aggregate Functions
SELECT trunc(avg(total),3) FROM invoice;
SELECT * FROM track;
SELECT max(unitprice) FROM track;

-- 3.3 User Defined Scalar Functions
SELECT * FROM invoiceline;
CREATE OR REPLACE FUNCTION get_avg_price
RETURN NUMBER
IS 
    avg_price NUMBER;
BEGIN
    SELECT trunc(avg(unitprice),3) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/
DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := get_avg_price();
    DBMS_OUTPUT.PUT_LINE('Average price of items: ' || avg_price);
END;
/

CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
is
    EMPLOYEE_C SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968', 'DD-MM-YYYY');
    return EMPLOYEE_C;
END;
/

select after_1968 from dual;
select * from employee;

SET SERVEROUTPUT ON;

-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedures
CREATE OR REPLACE PROCEDURE get_employee_names
IS
    --employee_name SYS_REFCURSOR;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Some employee');
    --RETURN employee_name;

END;
/
DECLARE
    --employee_name SYS_REFCURSOR;
    --last_name VARCHAR(20);
Begin
    
    get_employee_names;
    --SELECT employee_name FROM dual;
    
End;
/

-- 4.2 Stored Procedures Input Parameters
CREATE OR REPLACE PROCEDURE update_employee(first_name IN VARCHAR2, last_name IN VARCHAR2, new_phone IN VARCHAR2, new_email IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET phone = new_phone, email = new_email WHERE firstname = first_name AND lastname = last_name;
END;
/

DECLARE
    f_name VARCHAR2(40);
    l_name VARCHAR2(40);
    new_phone VARCHAR2(40);
    new_email VARCHAR2(50);
BEGIN
    f_name := 'Robert';
    l_name := 'King';
    new_phone := '+1 (403) 555-5552';
    new_email := 'kingr1@chinookcorp.com';
    
    update_employee(f_name, l_name, new_phone, new_email);
END;
/

CREATE OR REPLACE PROCEDURE get_managers(first_name IN VARCHAR2, last_name IN VARCHAR2, manager OUT VARCHAR2)
IS
BEGIN
    SELECT reportsto INTO manager FROM employee WHERE firstname = first_name AND lastname = last_name;
   
END;
/

DECLARE
    f_name VARCHAR2(40);
    l_name VARCHAR2(40);
    manager VARCHAR(40);
BEGIN
    f_name := 'Robert';
    l_name := 'King';
    
    get_managers(f_name, l_name, manager);
    DBMS_OUTPUT.PUT_LINE();
    
END;
/

CREATE OR REPLACE PROCEDURE get_customer_info(customer_id IN NUMBER, 
                                                    f_name OUT VARCHAR2, l_name OUT VARCHAR2, c_company OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, lastname, company INTO f_name, l_name, c_company FROM customer WHERE customerid=customer_id;
   
END;
/

DECLARE
    customerid NUMBER(20);
    f_name VARCHAR2(40);
    l_name VARCHAR2(40);
    company VARCHAR(40);
BEGIN
    customerid:=5;
    
    get_customer_info(customerid, f_name, l_name, company);
    DBMS_OUTPUT.PUT_LINE('Name: ' || f_name ||' ' || l_name || ' Company: ' || company);
    
END;
/

DESC employee;
SELECT * FROM customer;

-- 5.0 Transaction
DECLARE
    invoice_id NUMBER(30);
BEGIN
    invoice_id := 221;
    DELETE FROM invoiceline WHERE invoiceid=invoice_id;
    DELETE FROM invoice WHERE invoiceid=invoice_id;
    commit;
END;
/

SELECT * FROM invoice WHERE invoiceid=invoice_id;

CREATE OR REPLACE PROCEDURE insert_customer(customer_id IN NUMBER, f_name IN VARCHAR2, l_name IN VARCHAR2, email IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email) VALUES(customer_id, f_name, l_name, email);   
    commit;
END;
/

DECLARE
    customerid NUMBER(20);
    firstname VARCHAR(40);
    lastname VARCHAR(40);
    email VARCHAR(40);
BEGIN
    customerid := 99;
    firstname := 'Thomas';
    lastname := 'The-Train-Engine';
    email := 'ttetom@gmail.com';
    insert_customer(customerid, firstname, lastname, email);
END;
/

SELECT * FROM album;
-- 6.0 Triggers
-- 6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER new_employee
AFTER INSERT ON employee
for each row
BEGIN
    DBMS_OUTPUT.PUT_LINE('We have a new employee');
END;
/
CREATE OR REPLACE TRIGGER new_album
AFTER UPDATE ON album
for each row
BEGIN
    DBMS_OUTPUT.PUT_LINE('New album alert!');
END;
/
INSERT INTO employee(employeeid, lastname, firstname, title) VALUES(14, 'Rex', 'T', 'Dinosaur');
commit;
UPDATE album SET title = 'Tha Carter IV' WHERE title = 'Tha Carter III';

CREATE OR REPLACE TRIGGER customer_deleted
AFTER DELETE ON customer
for each row
BEGIN
    DBMS_OUTPUT.PUT_LINE('Another one bites the dust.');
END;
/

SELECT * FROM employee;
DELETE FROM customer WHERE customerid = 98;
commit;

-- 7.0 Joins
-- 7.1 INNER
SELECT a.customerid, b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid=b.customerid;

-- 7.2 OUTER
SELECT a.customerid, a.firstname , a.lastname, b.invoiceid, b.total FROM customer a LEFT OUTER JOIN invoice b ON a.customerid=b.customerid;

-- 7.3 RIGHT
SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid=b.artistid;

-- 7.4 CROSS
SELECT * FROM artist a CROSS JOIN album b ORDER BY a.name;

-- 7.5 SELF
SELECT * FROM employee a INNER JOIN employee b ON a.employeeid=b.reportsto;