/*2.1*/
SELECT * FROM Employee;

SELECT * FROM Employee WHERE LASTNAME = 'King';

SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS null;


/*2.2*/

SELECT * FROM Album ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM Customer ORDER BY CITY ASC;

/*2.3*/
INSERT INTO GENRE VALUES ((SELECT COUNT(NAME) FROM GENRE) + 1, 'a Genre');

INSERT INTO GENRE VALUES ((SELECT COUNT(NAME) FROM GENRE) + 1, 'another Genre');

INSERT INTO EMPLOYEE VALUES ((SELECT COUNT(EMPLOYEEID) FROM EMPLOYEE) + 1, 'First',
'last', 'scrub', 6,(TO_DATE('05/10/1993', 'DD/MM/YYYY')),(TO_DATE('05/10/2010', 'DD/MM/YYYY'))
, '1231', 'Atlanta', 'GA', 'UNITED', 'what', '1', '1', 'Email?');

INSERT INTO EMPLOYEE VALUES ((SELECT COUNT(EMPLOYEEID) FROM EMPLOYEE) + 1, 'second',
'last', 'scrub2', 6,(TO_DATE('12/10/1993', 'DD/MM/YYYY')),(TO_DATE('05/10/2010', 'DD/MM/YYYY'))
, '1231', 'At2lanta', 'GA', 'UNITED', 'what', '1', '1', 'Email?');


DESC customer;

INSERT INTO customer VALUES (44444, 'bob', 'thing', null, null, null, null, null, null, null, null, 1, null);
INSERT INTO customer VALUES (44434, 'dave', 'davidson', null, null, null, null, null, null, null, null, 5, null);

--2.4

UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
DESC artist;
UPDATE artist SET name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5
DESC invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and  '01-MAR-04';

--2.6
--DELETE FROM customer WHERE firstname = 'Robert' and lastname = 'Walter';
--select * from customer;
--CREATE TABLE information as SELECT ainv.INVOICELINEID, ainv.invoiceid, customer.customerid FROM 
--(SELECT inl.INVOICELINEID,inv.invoic, inv.customerid FROM invoice inv  JOIN invoiceline inl ON inv.invoiceid = inl.invoiceid)ainv
--JOIN customer on ainv.customerid = customer.customerid AND customer.firstname = 'Robert' and customer.lastname = 'Brown';
--DELETE FROM invoiceline WHERE invoicelineid in(select * from invoicelineid intersect information);

DELETE FROM invoiceline WHERE invoiceline.invoiceid in (
select invoice.invoiceid from customer join invoice on invoice.customerid = customer.customerid and customer.firstname = 'Emma' AND customer.lastname = 'Jones'
);
delete from invoice where invoice.customerid in (select customerid from customer where customer.firstname = 'Emma' AND customer.lastname = 'Jones');
delete from customer where customer.firstname = 'Emma' AND customer.lastname = 'Jones';
rollback;
commit;
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
--3.1-------------------------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION get_the_time_now
RETURN TIMESTAMP
IS
    currentTime TIMESTAMP;
    
BEGIN
    currentTime := CURRENT_TIMESTAMP;
    RETURN currentTime;
END;
/

select get_the_time_now from dual;

CREATE OR REPLACE FUNCTION get_length(item IN varchar2)
RETURN NUMBER
IS
    lengthOf NUMBER;
    
BEGIN
    lengthOf := LENGTH(item);
    RETURN lengthOf;
END;
/
--execute
select get_length('get it now') from dual;

--3.2-----

CREATE OR REPLACE FUNCTION get_avg
RETURN NUMBER
IS
    theavg NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO theavg FROM track;
    RETURN theavg;
END;
/
    
SELECT get_avg() FROM dual;

CREATE OR REPLACE FUNCTION get_max
RETURN NUMBER
IS
    themax NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO themax FROM track;
    RETURN themax;
END;
/
DECLARE
    max_price NUMBER;
BEGIN
    max_price := get_max();
    DBMS_OUTPUT.PUT_LINE('Max value.' || max_price);
END;
/

CREATE OR REPLACE FUNCTION get_avg_of_item(the_id NUMBER)
RETURN NUMBER
IS
    the_avg NUMBER;
BEGIN
   SELECT AVG(unitprice) INTO the_avg FROM invoiceline WHERE invoiceid = the_id;
   RETURN the_avg;
END;
/
SELECT get_avg_of_item(2) FROM dual;

CREATE OR REPLACE FUNCTION get_born_after(the_year NUMBER)
RETURN SYS_REFCURSOR
IS
    the_employees SYS_REFCURSOR;
BEGIN
    OPEN the_employees FOR 
    SELECT * FROM employee 
    WHERE EXTRACT( year FROM birthdate) >= the_year;
    RETURN the_employees;
END;
/


SELECT get_born_after(1968) FROM dual;
select * from employee;

---------------------------------------
--4.1

CREATE OR REPLACE PROCEDURE get_names(names OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN names FOR SELECT firstname, lastname FROM employee;
END;
/

DECLARE
    names SYS_REFCURSOR;
    TYPE MyRec IS RECORD (col1 VARCHAR2(40), col2 VARCHAR2(40));  --define the record
    rec MyRec;
BEGIN
    get_names(names);
    LOOP
        FETCH names INTO rec;
        EXIT WHEN names%NOTFOUND;
        dbms_output.put_line(rec.col1 || ' ' || rec.col2);
    END LOOP;
    --DBMS_OUTPUT.PUT_LINE(firstName);
    
END;
/
    --4.2  
CREATE OR REPLACE PROCEDURE update_employee(
    the_id NUMBER, lastN VARCHAR2, firstN varchar2,
    titleN VARCHAR, reports2 NUMBER, bday DATE, hday DATE,
    newAddress VARCHAR2, newCity VARCHAR2, newState VARCHAR,
    newCountry VARCHAR2, newPostal VARCHAR2, newPhone VARCHAR2,
    newFax VARCHAR2, newEMail VARCHAR2)
is
BEGIN

    UPDATE employee
    SET lastname = lastN, firstname = firstN, title = titleN, reportsto = reports2,
    birthdate = bday, hiredate = hday, address = newAddress, city = newCity,
    state = newCity, country = newCountry, postalcode = newPostal, phone = newPhone,
    fax = newFax, email = newEMail WHERE employeeid = the_id;
END;
/

BEGIN
    update_employee(1, 'fname', 'lname', null, null, null, null,
    null,null,null,null,null,null,null,null);
END;
/
SELECT * FROM EMPLOYEE;
rollback;

CREATE OR REPLACE PROCEDURE get_manager_of(the_id NUMBER, the_first_name OUT employee.firstname%TYPE,
the_last_name OUT employee.lastname%type)
IS
BEGIN
    SELECT firstname, lastname INTO the_first_name, the_last_name FROM employee WHERE
        (SELECT reportsto FROM employee WHERE employeeid = the_id) = employeeid;
END;
/

DECLARE
    fname varchar2(20);
    lname varchar2(20);
BEGIN
    get_manager_of(2, fname, lname);
    DBMS_OUTPUT.PUT_LINE(fname || ' ' || lname);
END;
/

CREATE OR REPLACE PROCEDURE get_customer(the_id NUMBER, the_first_name OUT customer.firstname%TYPE,
the_last_name OUT customer.lastname%type, the_company OUT customer.company%TYPE )
IS
BEGIN
    SELECT firstname, lastname, company INTO the_first_name, the_last_name, the_company 
    FROM customer 
    WHERE customerid = the_id;
        
END;
/

DECLARE
    fname varchar2(40);
    lname varchar2(20);
    company varchar2(80);
BEGIN
    get_customer(1, fname, lname, company);
    DBMS_OUTPUT.PUT_LINE(fname || ' ' || lname || ' ' || company);
END;
/



---------------5.1

CREATE OR REPLACE PROCEDURE delete_invoice(the_id number)
is
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = the_id;
    DELETE FROM invoice WHERE invoiceid = the_id;
    COMMIT;
END;
/

BEGIN
    delete_invoice(3);
END;
/

CREATE SEQUENCE customerSeq
    START WITH 60
    INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE create_customer(
    lastN VARCHAR2, firstN varchar2, comp VARCHAR2,
    newAddress VARCHAR2, newCity VARCHAR2, newState VARCHAR2,
    newCountry VARCHAR2, newPostal VARCHAR2, newPhone VARCHAR2,
    newFax VARCHAR2, newEMail VARCHAR2, employeeSupport number)
is
BEGIN

    INSERT INTO customer
    VALUES (customerSeq.NEXTVAL, firstN, lastN, comp,
    newAddress, newCity, newState, newCountry,  newPostal,  newPhone,
    newFax, newEMail, employeeSupport);
    commit;
END;
/

BEGIN
    create_customer('n', 'l', null, null, null,null,null,null,null,null,'e',null);
END;
/


--6.1
CREATE OR REPLACE TRIGGER new_employee
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('new employee');
END;
/

INSERT INTO EMPLOYEE VALUES(1000, 'd', 'd', null, null, null,null,null,null,null, null, null,null,null,null);
commit;

CREATE OR REPLACE TRIGGER new_album
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('album updated');
END;
/

INSERT INTO album VALUES(1233323, 'title', '2');
UPDATE album SET title = 'new title' where albumid = 1233323;
commit;

CREATE OR REPLACE TRIGGER customer_gone
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('customer gone');
END;
/

DELETE FROM customer WHERE customerid = 23;
commit;



-------7 JOINS

SELECT firstname, lastname, invoiceid from customer INNER JOIN invoice 
on customer.customerid = invoice.customerid;

SELECT customer.customerid, firstname, lastname, invoiceid, invoice.total from customer FULL OUTER JOIN invoice 
on customer.customerid = invoice.customerid;

SELECT artist.name, album.title from album right join artist on album.artistid = artist.artistid;

SELECT * from album CROSS JOIN artist order by artist.name;

SELECT * from employee a JOIN employee b on a.reportsto = b.employeeid;

--JOIN ALL D:


    Select * from artist join album on artist.artistid = album.artistid
    JOIN track on album.albumid = track.albumid
    JOIN playlisttrack on playlisttrack.trackid = track.trackid
    JOIN playlist on playlisttrack.playlistid = playlist.playlistid
    JOIN genre on track.genreid = genre.genreid
    JOIN mediatype on mediatype.mediatypeid = track.mediatypeid
    JOIN invoiceline on invoiceline.trackid = track.trackid
    JOIN invoice on invoice.invoiceid = invoiceline.invoiceid
    JOIN customer on invoice.customerid = customer.customerid
    JOIN employee Aemp on Aemp.employeeid = customer.supportrepid
    JOIN employee Bemp on Aemp.reportsto = Bemp.employeeid;
  