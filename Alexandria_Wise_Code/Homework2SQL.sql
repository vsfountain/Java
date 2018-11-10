9----Homework2:SQL Week

--2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname ='King';
SELECT * FROM employee WHERE firstname ='Andrew' AND reportsto != 'null';

--2.2 ORDER BY
SELECT * FROM album;
SELECT * FROM album ORDER BY title DESC;
SELECT * FROM customer;
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
DESC genre;
SELECT * FROM genre;
INSERT INTO genre VALUES(26, 'Disney');
INSERT INTO genre VALUES(27, 'Mash-Ups');

DESC employee;
SELECT * FROM employee;
INSERT INTO employee VALUES(9, 'Gellar', 'Ross', 'Paleontologist', 6, DATE'1967-10-18', DATE'1994-09-22',
                            'P Sherman 42 Wallaby Way', 'Sydney', 'NSW','Australia','2006',
                            '+1 (864) 313-9830','+1 (864) 297-6786', 'rgellar@chinookcorp.com'); 
INSERT INTO employee VALUES(10, 'Green', 'Rachel', 'Assistant Buyer', 4, DATE'1969-05-05', DATE'1994-09-22',
                            'P Sherman 42 Wallaby Way', 'Sydney', 'NSW','Australia','2006',
                            '+1 (864) 555-0121','+1 (864) 555-1210', 'rgreen@chinookcorp.com'); 
                            
DESC customer;
SELECT * FROM customer;
INSERT INTO customer VALUES(60, 'Chandler', 'Bing', 'Advertisers International', '11 Woods Edge Ct.', 
                        'Greenville', 'SC', 'United States', '29607', '(864) 525-2643', '(864) 285-1933',
                        'cmbing@international.com', 7);
INSERT INTO customer VALUES(61, 'Monica', 'Gellar-Bing', 'Javu', '11 Woods Edge Ct.', 
                        'Greenville', 'SC', 'United States', '29607', '(864) 303-2253', '(864) 297-1263',
                        'mmgellar@javufood.com', 4);
                        
--2.4 UPDATE
SELECT * FROM customer;
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell'; 
SELECT * FROM customer WHERE lastname = 'Walter';
SELECT artistid FROM artist WHERE name = 'Creedence Clearwater Revival';
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
SELECT * FROM artist;

--2.5 LIKE
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN DATE'2003-06-01' AND DATE'2004-03-01';

commit;

--2.7 DELETE 
SELECT * FROM customer WHERE customerid=32;
SELECT customerid FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
DELETE FROM invoice WHERE customerid = 32;
SELECT * FROM invoice WHERE customerid = 32;
DELETE FROM invoiceline WHERE invoiceid = 342;
DELETE FROM invoiceline WHERE invoiceid = 50;
DELETE FROM invoiceline WHERE invoiceid = 61;
DELETE FROM invoiceline WHERE invoiceid = 116;
DELETE FROM invoiceline WHERE invoiceid = 245;
DELETE FROM invoiceline WHERE invoiceid = 268;
DELETE FROM invoiceline WHERE invoiceid = 290;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
commit;

--3.1 SYSTEM DEFINED FUNCTIONS
-- function and execution to get the current date
CREATE OR REPLACE FUNCTION get_time
RETURN TIMESTAMP
IS
    current_time TIMESTAMP;
BEGIN
    SELECT SYSTIMESTAMP INTO current_time FROM dual;
    RETURN current_time;
END;
/

DECLARE
    current_time TIMESTAMP;
BEGIN
    current_time := get_time();
    DBMS_OUTPUT.PUT_LINE('The current time is: ' || current_time);
END;
/

SELECT * FROM mediatype;
DESC mediatype;

-- getting the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_length(my_mediatype IN NUMBER)
RETURN NUMBER
IS
    my_length NUMBER;
BEGIN
    SELECT length(to_char(my_mediatype))INTO my_length FROM mediatype;
    RETURN my_length;
END;
/

DECLARE
    my_length NUMBER;
BEGIN
    my_length := get_length(mediatypeid);
    DBMS_OUTPUT.PUT_LINE('The length of the mediatype is: ' || my_length);
END;
/

--3.2 SYSTEM DEFINED AGGREGATE FUNCTION
--average of all invoice totals
SELECT * fROM invoice;
DESC invoice;

CREATE OR REPLACE FUNCTION get_invoice_average
RETURN NUMBER
IS 
    inv_avg NUMBER;
BEGIN
    SELECT AVG(total) INTO inv_avg FROM invoice;
    RETURN inv_avg;
END;
/

DECLARE
    inv_avg NUMBER;
BEGIN
    inv_avg := get_invoice_average();
    DBMS_OUTPUT.PUT_LINE('average invoice total: ' || inv_avg);
END;
/

--most expensive track
SELECT * FROM track;
DESC track;
CREATE OR REPLACE FUNCTION get_max_track
RETURN VARCHAR2
IS 
    max_track VARCHAR2;
BEGIN
    SELECT name INTO max_track FROM track HAVING unitprice = MAX(unitprice);
    RETURN max_track;
END;
/

DECLARE
    max_track VARCHAR2;
BEGIN
    max_track := get_max_track();
    DBMS_OUTPUT.PUT_LINE('most expensive track: ' || max_track);
END;
/

--3.3 USER DEFINED SCALAR FUNCTION
DESC invoiceline;
SELECT * FROM invoiceline;

CREATE OR REPLACE FUNCTION get_avg_price
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/

DECLARE 
    avg_price NUMBER;
BEGIN
    avg_price := get_avg_price();
    DBMS_OUTPUT.PUT_LINE('average invoice price: '||avg_price);
END;
/

--3.4 USER DEFINED TABLE VALUED FUNCTIONS 
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

--4.1 FIRST AND LAST NAMES
CREATE OR REPLACE PROCEDURE get_names
IS
BEGIN
    SELECT firstname, lastname INTO FROM employee;
END;
/

BEGIN
    get_names;
END;
/

--4.2 STORED PROCEDURE INPUT PARAMETERS
SELECT * FROM employee;
DESC employee;
CREATE OR REPLACE PROCEDURE update_employee_info (employee_id NUMBER,
                                                    lastname VARCHAR2,
                                                    firstname VARCHAR2,
                                                    birthdate DATE)
IS
BEGIN
    UPDATE employee SET VALUES(lastname, firstname, birthdate) WHERE employeeid = employee_id ;
END;
/

SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE get_managers(employee_id IN NUMBER, manager
         OUT employee.employeeid%TYPE)
                        --dynamically find a data type
IS
BEGIN
    SELECT reportsto INTO manager FROM employee WHERE employeeid=employee_id;
END;
/
--exec
DECLARE
    manager NUMBER;
BEGIN
    get_managers(3, manager);
    DBMS_OUTPUT.PUT_LINE('manager: ' || manager);
END;
/

--4.3 
DESC customer;
CREATE OR REPLACE PROCEDURE get_customer_info(cust_id IN NUMBER, 
                            f_name OUT VARCHAR2,
                            comp OUT VARCHAR2)
IS
BEGIN
    SELECT firstname INTO f_name FROM customer WHERE customerid=cust_id;
    SELECT company INTO comp FROM customer WHERE customerid = cust_id;
END;
/   

DECLARE
    f_name NUMBER;
    comp NUMBER;
BEGIN
    get_customer_info(3, f_name, comp);
    DBMS_OUTPUT.PUT_LINE('customer name: ' || f_name);
    DBMS_OUTPUT.PUT_LINE('customer company: ' || comp);
END;
/

--5.0 TRANSACTIONS
CREATE OR REPLACE PROCEDURE delete_invoice(invoice_id NUMBER ON DELETE CASCADE)
IS
BEGIN
    DELETE FROM invoice WHERE invoiceid = invoice_id;
END;

DECLARE
    invoice_id NUMBER;
BEGIN
    delete_invoice(invoice_id);
END;






--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER after_insert
AFTER INSERT ON employee
FOR EACH ROW
    new_employee NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('new_employee: '|| new_employee);
END;
/



--7.1 INNER JOIN
DESC invoice;
DESC customer;
SELECT firstname, lastname, invoiceid FROM customer a INNER JOIN invoice b ON a.customerid = b.customerid;

--7.2 OUTER JOIN
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a FULL OUTER JOIN invoice b ON a.customerid = b.customerid;

--7.3 RIGHT JOIN
SELECT * FROM artist;
SELECT * FROM album;
SELECT a.name, b.title FROM artist a RIGHT JOIN album b ON a.artistid = b.artistid;

--7.4 CROSS
SELECT * FROM album a CROSS JOIN artist b ORDER BY b.name;

--7.5 SELF
SELECT * FROM employee a INNER JOIN employee b ON a.REPORTSTO=b.reportsto;






