-- 2.1
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE lastname = 'King';

SELECT * FROM EMPLOYEE WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- 2.2
SELECT * FROM ALBUM ORDER BY title DESC;

SELECT firstname FROM EMPLOYEE ORDER BY city ASC;

-- 2.3
SELECT * FROM GENRE;
INSERT INTO GENRE VALUES(26, 'Good');
INSERT INTO GENRE VALUES(27, 'Bad');

INSERT INTO EMPLOYEE VALUES(9,'Doyle','Sean','IT Staff',6,'22-SEP-95','22-OCT-18','14525 Prism Cir.','Tampa','FL','USA','33613','(612) 308-8408','+1 (403) 467-8772','SCDoyle316@gmail.com');
INSERT INTO EMPLOYEE VALUES(10,'Colt','Ossoff','IT Staff',6,'12-JUN-87','22-OCT-18','6211 Farnsworth Dr.','Parma','OH','USA','44129','(440) 465-3141','+1 (403) 467-8772','coltossoff@gmail.com');

SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER VALUES(60,'Doyle','Sean','','14525 Prism Cir.','Tampa','FL','USA','33613','(612) 308-8408','+1 (403) 467-8772','SCDoyle316@gmail.com',4);
INSERT INTO CUSTOMER VALUES(61,'Colt','Ossoff','','6211 Farnsworth Dr.','Parma','OH','USA','44129','(440) 465-3141','+1 (403) 467-8772','coltossoff@gmail.com',4);

-- 2.4
UPDATE CUSTOMER SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

SELECT * FROM ARTIST;
UPDATE ARTIST SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5
SELECT * FROM INVOICE;
SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';

-- 2.6
SELECT * FROM INVOICE WHERE total > 15 AND total < 50;

SELECT * FROM EMPLOYEE WHERE hiredate > '01-JUN-2003' AND hiredate < '01-MAR-2004';

-- 2.7
Select * from customer WHERE firstname='Robert' AND lastname='Walter';
DELETE FROM INVOICELINE WHERE EXISTS (SELECT * FROM INVOICE WHERE customerid = 32);
DELETE FROM INVOICE WHERE customerid = 32;
DELETE FROM CUSTOMER WHERE firstname='Robert' AND lastname='Walter';

-- 3.1
CREATE OR REPLACE FUNCTION get_today
return DATE
IS
BEGIN
    RETURN NEW_TIME (SYSDATE, 'GMT', 'EST');
END;
/
SELECT GET_TODAY FROM DUAL;

CREATE OR REPLACE FUNCTION get_mdt_length(val IN VARCHAR2)
return NUMBER
IS
S VARCHAR2(100);
BEGIN
    SELECT LENGTH(name) INTO S FROM MEDIATYPE WHERE name = val;
    RETURN S;
END;
/
SELECT get_mdt_length('AAC audio file') FROM DUAL;

-- 3.2
CREATE OR REPLACE FUNCTION avg_total
return NUMBER
IS
S NUMBER;
BEGIN
    SELECT AVG(total) INTO S FROM INVOICE;
    RETURN S;
END;
/
SELECT avg_total FROM dual;

CREATE OR REPLACE FUNCTION max_price
return NUMBER
IS
S NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO S FROM TRACK;
    RETURN S;
END;
/
SELECT max_price FROM dual;
SELECT * FROM TRACK;

-- 3.3
CREATE OR REPLACE FUNCTION avg_INVOICELINE
return NUMBER
IS
S NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO S FROM INVOICELINE;
    RETURN S;
END;
/
SELECT avg_INVOICELINE FROM dual;
SELECT * FROM INVOICELINE;

-- 3.4
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

-- 4.1
CREATE OR REPLACE PROCEDURE get_employees(fname OUT EMPLOYEE.firstname, lname OUT EMPLOYEE.lastname)
IS
BEGIN
    SELECT firstname,lastname INTO fname,lname FROM EMPLOYEE;
END;
/
DECLARE
    fname VARCHAR2(100);
    lname VARCHAR2(100);
BEGIN
    (fname, lname) := get_employees(fname,lname);
    DBMS_OUTPUT.PUT_LINE('fname'||fname||'   lname' || lname);
    --SELECT FNAME, LNAME FROM DUAL;
END;
/

-- 4.2
CREATE OR REPLACE PROCEDURE update_employee( eid IN NUMBER,
                                             lname IN VARCHAR2,
                                             fname IN VARCHAR2,
                                             title IN VARCHAR2,
                                             reptto IN VARCHAR2,
                                             bday IN VARCHAR2
                                             hday IN VARCHAR2,
                                             addr IN VARCHAR2(25),
                                             cty IN VARCHAR2,
                                             st IN VARCHAR2,
                                             ctry IN VARCHAR2,
                                             pcode IN VARCHAR2,
                                             pnum IN VARCHAR2,
                                             fxnum IN VARCHAR2,
                                             eml IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE SET (LASTNAME = LNAME, FIRSTNAME = FNAME, TITLE = TITLE, REPORTTO = REPTTO, BIRTHDATE = BDAY, HIREDATE = HDAY, ADDRESS = ADDR,CITY = CTY, STATE = ST,COUNTRY = CTRY, POSTALCODE = PCODE, PHONE = PNUM, FAX = FXNUM, EMAIL = EML) WHERE EMPLOYEEID = EID;
END;
/

