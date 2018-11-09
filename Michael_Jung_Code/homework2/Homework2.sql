
--2.1
select * from employee;
select * from employee where lastname='King';
select * from employee where firstname='Andrew' AND reportsto IS NULL;


--2.2
select * from album order By title DESC;
select firstname from customer order By city ASC;

--2.3
select * from genre;
insert into genre values((select count(*) from album) , 'orchestral');
insert into genre values((select count(*) from album), 'music2');
--insert into 
select * from employee;
insert into employee values((select count(*) from employee), 'lastname1', 'firstname1', 'New Employee', 1, '19-FEB-58', '555 Address Lane', 'City1', 'State1', 'Country1', 'Postal Code1', '+1 (555) 555-5555', '+1 (555) 555-5555', 'email1@email.com');
insert into employee values((select count(*) from employee), 'lastname2', 'firstname2', 'New Employee', 1, '19-MAR-58', '558 Address Lane', 'City2', 'State2', 'Country2', 'Postal Code2', '+1 (555) 555-5558', '+1 (555) 555-5558', 'email2@email.com');

select * from customer;
insert into customer values((select count(*) from customer), 'firstname1', 'lastname1', 'Company1', 'Address1', 'City1', 'State1', 'Country1', 'Postal Code1', '+1 (555) 555-5555', '+1 (555) 555-5555', 'email1@email.com', 5);
insert into customer values((select count(*) from customer), 'firstname2', 'lastname2', 'Company2', 'Address2', 'City2', 'State2', 'Country2', 'Postal Code2', '+1 (555) 555-5558', '+1 (555) 555-5558', 'email2@email.com', 2);

--2.4
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE customerid=32;

select * from artist where name='Creedence Clearwater Revival';
UPDATE artist SET name='CCR' where name='Creedence Clearwater Revival';

--2.5
select * from invoice;
select * from invoice where billingaddress like 'T%';

--2.6
select * from invoice where total between 15 AND 50;
select * from employee;
select * from employee where hiredate between '01-JUN-03' AND '01-MAR-04';

--2.7
select * from customer;
select * from invoice where customerid=32;
select * from invoiceline;
delete from invoiceline where invoiceid=116;
delete from invoiceline where invoiceid=342;
delete from invoiceline where invoiceid=245;
delete from invoiceline where invoiceid=268;
delete from invoiceline where invoiceid=290;
delete from invoiceline where invoiceid=50;
delete from invoiceline where invoiceid=61;
delete from invoice where customerid=32;
delete from customer where firstname='Robert' AND lastname='Walter';





--3.1


CREATE OR REPLACE FUNCTION get_current_time
RETURN NUMBER
IS
    current_time NUMBER;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO current_time;
        RETURN current_time;
END;
/

/*select * from mediatype;
CREATE OR REPLACE FUNCTION media_type_length
RETURN NUMBER
IS
    length NUMBER;
BEGIN
    SELECT LEN*/
    






DECLARE
    max_id NUMBER;
BEGIN 
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('max pokemon: ' || max_id);
END;
/

CREATE OR REPLACE FUNCTION get_max(num1 IN NUMBER,
                        num2 IN NUMBER)
RETURN NUMBER
IS
BEGIN
    IF num1>num2 THEN
        RETURN num1;
    ELSE
        RETURN num2;
    END IF;
END;
/

DECLARE
    greater NUMBER;
BEGIN
    greater := get_max(550, 100);
    DBMS_OUTPUT.PUT_LINE('max num is: ' || greater);
END;
/

SELECT get_max(33, 79) FROM dual;

--3.2


