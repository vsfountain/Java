-----2.1 Tasks
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS null;
----2.2 Tasks
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;
----2.3 Tasks
SELECT * FROM genre;
INSERT INTO genre (genreid, name) VALUES (26, 'FUNKY MONKEY');
INSERT INTO genre (genreid, name) VALUES (27, 'FUNKY BANANA');
SELECT * FROM employee;
INSERT INTO employee VALUES (9, 'ADAMS', 'MARGARET', 'GMP Specialist', 1, '09-MAR-89','13-JAN-16', '4703 Portmanteau Ave S', 'Covington', 'NJ', 'USA', '85473', '+1 (612) 889-9427', '+1 (612) 889-9427', 'mm@yahoo.net');
INSERT INTO employee VALUES (10, 'ADAMS', 'MO', 'GMP Specialist', 1, '09-MAR-89','13-JAN-16', '4703 Portmanteau Ave S', 'Covington', 'NJ', 'USA', '85473', '+1 (612) 889-9427', '+1 (612) 889-9427', 'mm@yahoo.net');
SELECT * FROM customer;
INSERT INTO customer VALUES (60,  'MARGARET', 'ADAMS', 'GMP GOV',  '4703 Portmanteau Ave S', 'Covington', 'NJ', 'USA', '85473', '+1 (612) 889-9427', '+1 (612) 889-9427', 'mm@yahoo.net', 2);
INSERT INTO customer VALUES (61, 'MO', 'ADAMS', 'GMP GOV2', '4703 Portmanteau Ave S', 'Covington', 'NJ', 'USA', '85473', '+1 (612) 889-9427', '+1 (612) 889-9427', 'mm@yahoo.net', 1);
-----2.4 Tasks
SELECT * FROM customer;
UPDATE customer SET firstname = 'Robert'  WHERE customerid = 32;
UPDATE customer SET lastname = 'Walter'  WHERE customerid = 32;
SELECT * FROM artist;
UPDATE artist SET name = 'CCR'  WHERE name = 'Creedence Clearwater Revival';
-----2.5 Tasks
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
----2.6 Tasks
SELECT * FROM invoice;
SELECT * FROM invoice WHERE  total BETWEEN 15 AND 50;
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
----2.7 Tasks
SELECT * FROM customer;
SELECT * FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
SELECT * FROM invoice WHERE customerid = 32;
SELECT * FROM invoice;
SELECT * FROM invoiceline;
DELETE  FROM invoiceline WHERE invoiceid IN  (SELECT invoiceid FROM invoiceline) INTERSECT  (SELECT invoiceid FROM invoice WHERE customerid = 32);
DELETE  FROM invoice WHERE customerid = 32;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
















---3.1 Tasks
CREATE OR REPLACE FUNCTION get_current_time (time1 OUT TIMESTAMP)
RETURN TIMESTAMP
IS
BEGIN
       RETURN CURRENT_TIMESTAMP;
END;
/
DECLARE 
           time1 TIMESTAMP;
BEGIN 
        time1 := get_current_time(time1);
        DBMS_OUTPUT.PUT_LINE('Current time is: ' || time1);
END;
/

SELECT * FROM mediatype;
DESC mediatype;
CREATE OR REPLACE FUNCTION get_length_mediatpye (indexof IN NUMBER)
RETURN NUMBER
IS 
    lengthof NUMBER;
BEGIN
     SELECT LENGTH(name) INTO lengthof FROM mediatype WHERE mediatypeid = indexof;
     RETURN lengthof;
END;
/
DECLARE
    lengthof NUMBER;
BEGIN
    lengthof := get_length_mediatpye(2);
    DBMS_OUTPUT.PUT_LINE('Length is: ' || lengthof);
END;
/ 
---3.2 Tasks
SELECT * FROM invoice;
CREATE OR REPLACE FUNCTION get_avg_of_invoice
RETURN NUMBER
IS
    avgtotal NUMBER;
BEGIN
    SELECT AVG(total) INTO avgtotal FROM invoice;
    RETURN avgtotal;
END;
/
DECLARE 
    avgtotal NUMBER;
BEGIN
    avgtotal := get_avg_of_invoice();
    DBMS_OUTPUT.PUT_LINE('The average total for invoice table is: ' || avgtotal);
END;
/

SELECT * FROM track;
CREATE OR REPLACE FUNCTION get_most_expensive_track
RETURN VARCHAR2
IS
    trackname VARCHAR2(100);
BEGIN
    SELECT name INTO trackname FROM track WHERE trackid =  (SELECT MIN(trackid) FROM track WHERE unitprice = ( (SELECT MAX(unitprice) FROM track)));
    RETURN trackname;
END;
/
DECLARE 
    trackname VARCHAR2(100);
BEGIN
    trackname := get_most_expensive_track();
    DBMS_OUTPUT.PUT_LINE('Priciest Track: ' || trackname);
END;
/
---3.1 Tasks
SELECT * FROM invoiceline;
CREATE OR REPLACE FUNCTION get_avg_invoiceline_unitprice
RETURN NUMBER
IS
    avgprice NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avgprice FROM invoiceline;
    RETURN avgprice;
END;
/
DECLARE 
    avgprice NUMBER;
BEGIN
    avgprice := get_avg_invoiceline_unitprice();
    DBMS_OUTPUT.PUT_LINE('Avg Invoiceline unitprice: ' || avgprice);
END;
/

---3.4 Tasks
SELECT * FROM employee;
CREATE OR REPLACE FUNCTION get_employees_born_after_1968
RETURN SYS_REFCURSOR
IS
    temptable SYS_REFCURSOR;
BEGIN
    OPEN temptable FOR SELECT * FROM employee WHERE birthdate >= '01-JAN-69';
    RETURN temptable;
END;
/
SELECT  get_employees_born_after_1968() FROM dual;


















---4.1 Tasks
---------------------------------------------------------------------------------------------------------------------------------------------------------------------BAD NEED FIX
CREATE OR REPLACE PROCEDURE get_employee_first_last(temptable OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN temptable FOR SELECT firstname, lastname INTO temptable FROM employee;
END;
/
DECLARE 
        temptable SYS_REFCURSOR;
BEGIN
        get_employee_first_last(temptable);
        SELECT temptable FROM dual;
END;
/

---4.2 Tasks

--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE update_employee_info(firstnameorig IN VARCHAR2, lastnameorig IN VARCHAR2, firstnamenew IN VARCHAR2, lastnamenew IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET  firstname = firstnamenew, lastname = lastnamenew WHERE  firstname = firstnameorig AND lastname = lastnameorig;
END;
/
BEGIN
    update_employee_info('Andrew', 'Adams', 'Andrew11', 'Adams12');
END;
/

CREATE OR REPLACE PROCEDURE get_managers(employeefirst IN VARCHAR2, employeelast IN VARCHAR2, temptable OUT SYS_REFCURSOR)
IS 
BEGIN
DECLARE 
        loop_value NUMBER(2) := 0;
        employeefirst VARCHAR2(10) := 'Adams';
        employeelast VARCHAR2(10) :='Andrew';
        reportsto NUMBER(2) := 0;
BEGIN
WHILE loop_value < 5
LOOP
        DBMS_OUTPUT.PUT_LINE('sghj');
        SELECT reportsto INTO reportsto FROM employee WHERE firstname = employeefirst AND lastname = employeelast;
        IF reportsto IS null THEN
            loop_value := 7;
        ELSE 
            DBMS_OUTPUT.PUT_LINE(reportsto);
            SELECT firstname INTO employeefirst FROM employee WHERE employeeid = reportsto;
            DBMS_OUTPUT.PUT_LINE(employeefirst);
            SELECT lastname INTO employeelast FROM employee WHERE employeeid = reportsto;
            DBMS_OUTPUT.PUT_LINE(employeelast);
            loop_value := loop_value + 1;
        END IF;
END LOOP;
END; 
/ 

SELECT * FROM employee;
SELECT firstname FROM employee WHERE employeeid = 6;
SELECT reportsto FROM employee WHERE firstname = 'Laura' AND lastname = 'Callahan';

END;
/

---4.3 Tasks
DESC customer;
SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE get_name_and_comp_of_customer(custid IN customer.customerid%TYPE, custfirstname OUT customer.firstname%TYPE, custlastname OUT customer.lastname%TYPE, compname OUT customer.company%TYPE)
IS
BEGIN
    SELECT firstname INTO custfirstname FROM customer WHERE customerid = custid;
    SELECT lastname INTO custlastname FROM customer WHERE customerid = custid;
    SELECT company INTO compname FROM customer WHERE customerid = custid;
END;
/
DECLARE 
    custid NUMBER(2) := 5;
    firstname customer.firstname%TYPE;
    lastname  customer.lastname%TYPE;
    compname customer.company%TYPE;
BEGIN 
    get_name_and_comp_of_customer(custid, firstname, lastname, compname);
    DBMS_OUTPUT.PUT_LINE('customer with id: ' || custid || ' is ' || firstname|| ' ' ||  lastname || ' and works for ' || compname);
END;
/

















--- 5.0 Tasks
SELECT * FROM invoice;
SELECT * FROM invoiceline;
CREATE OR REPLACE PROCEDURE remove_invoiceid(invid IN NUMBER)
IS
BEGIN
--A transaction is a single unit of work. If a transaction is successful, all of the data modifications made during the transaction are committed and become a permanent part of the database
    DELETE FROM invoiceline WHERE invoiceid = invid;
    DELETE FROM invoice WHERE invoiceid = invid;
    commit;
END;
/
BEGIN
    remove_invoiceid(1);
END;
/

SELECT * FROM customer;
DESC customer;
CREATE OR REPLACE PROCEDURE insert_new_customer(firstname IN customer.firstname%TYPE, lastname IN customer.lastname%TYPE, company IN customer.company%TYPE, 
            address IN customer.address%TYPE, city IN customer.city%TYPE, state IN customer.state%TYPE, country IN customer.country%TYPE, 
            zipcode IN customer.postalcode%TYPE, phone IN customer.phone%TYPE, fax IN customer.fax%TYPE, email IN customer.email%TYPE)
IS
    custid NUMBER(3);
BEGIN
    SELECT MAX(customerid) INTO custid FROM customer;
    custid := custid +1;
    INSERT INTO customer VALUES (custid, firstname, lastname, company, address, city, state, country, zipcode, phone, fax, email, 2);--default reportsto is 2
    commit;
END;
/
BEGIN
    insert_new_customer('John', 'Roberts', 'Ryker Ind.', '4701 Main st NW', 'Salisbury', 'GE', 'Steakholm', '910KLJ3', '+1 (612) 999-3058', '+1 (612) 999-3058', 'jr@ryker.org');
END;
/
















--- 6.1 Tasks
CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new employee has been added');
END;
/
---Mytest 
--INSERT INTO employee VALUES (10, 'John', 'Roberts', 'Ryker Ind.', 3, '03-MAR-99', '12-MAR-12', '4701 Main st NW', 'Salisbury', 'GE', 'Steakholm', '910KLJ3', '+1 (612) 999-3058', '+1 (612) 999-3058', 'jr@ryker.org');
--commit;

CREATE OR REPLACE TRIGGER after_update_album
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    --need to commit the change b4 the triiger is fired
    DBMS_OUTPUT.PUT_LINE('An update to album has occur');
END;
/
--MyTest
--UPDATE album SET title = 'Minha Historia 1' WHERE albumid = 23;
--commit;
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A customer record has been deleted');
END;
/
--MyTest
--DELETE FROM customer WHERE customerid = 60;
--commit;















---7.1 Tasks
SELECT * FROM invoice;
SELECT * FROM customer;
SELECT firstname, lastname, invoiceid FROM customer a INNER JOIN invoice b ON a.customerid = b.customerid;

---7.2 Tasks
SELECT a.customerid, firstname, lastname, invoiceid, total FROM customer a FULL OUTER JOIN invoice b ON a.customerid = b.customerid;

---7.3 Tasks
SELECT * FROM album;
SELECT * FROM artist;
SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid = b.artistid;

---7.4 Tasks
SELECT *  FROM artist a CROSS JOIN album b ORDER BY a.name ASC;

---7.5 Tasks
--this is my self join
SELECT * FROM employee a, employee b WHERE a.employeeid = b.reportsto;











---8 Tasks    Extra Credit
--Join EVERY TABLE in the chinook database in a single join statement.
SELECT count(a.unitprice) FROM (SELECT * FROM employee a LEFT JOIN (SELECT * FROM customer a INNER JOIN (SELECT * FROM invoice a LEFT JOIN invoiceline b ON a.invoiceid = b.invoiceid) b ON a.customerid = b.customerid) b ON a.employeeid = b.supportrepid) a INNER JOIN  (SELECT j.name AS artistname, k.name, k.unitprice FROM (SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid = b.artistid) j INNER JOIN (SELECT n.name, n.albumid, n.unitprice FROM mediatype m INNER JOIN (SELECT q.name, trackid, albumid, q.mediatypeid, q.unitprice FROM genre p INNER JOIN (SELECT t.name, trackid, albumid, genreid,mediatypeid, t.unitprice FROM playlist s LEFT JOIN (SELECT z.trackid, name, albumid, mediatypeid, genreid, playlistid, x.unitprice FROM track x LEFT JOIN playlisttrack z ON x.trackid = z.trackid) t ON s.playlistid = t.playlistid) q ON p.genreid = 1) n ON m.mediatypeid = 1) k ON j.title = k.name) b ON a.unitprice = b.unitprice;           








---9.0 Tasks
/*
To ceate a backup of the DB:
Tools >> DataBase Export >> "click db-name" >> next >> next >> next >> next >> next >> finish >> 'wait' >> change filename from .sql to .bak
To restore DB from a backup:
open .bak file in text editor >> copy contents into an open .sql file in oracle sql >> run script >> "congrats"
*/
