
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

select * from invoice;

CREATE OR REPLACE FUNCTION get_avg(),
RETURN NUMBER
IS
BEGIN  
    RETURN SELECT AVG(total) from invoice;
END;
/

select avg(total) from invoice;

select * from track;
CREATE OR REPLACE FUNCTION max_track(),
RETURN NUMBER
IS
BEGIN
    RETURN SELECT MAX(unitprice) from track;
END;
/

--3.3


CREATE OR REPLACE FUNCTION get_avg(),
RETURN NUMBER
IS
BEGIN  
    RETURN SELECT AVG(total) from invoice;
END;
/

select avg(total) from invoice;


--3.4

select * from employee;

select * from employee where birthdate>01-JAN-68;


--4.1

CREATE OR REPLACE PROCEDURE get_first_last(),
IS
BEGIN
    SELECT firstname, lastname from employee;
END;
/


--4.2
select * from employee;
CREATE OR REPLACE PROCEDURE update_info(city IN VARCHAR2, EMPLOYEEID IN NUMBER)
IS
BEGIN
    UPDATE set CITY = city where Employeeid = EMPLOYEEID
    COMMIT;
END;
/



CREATE OR REPLACE PROCEDURE get_manager(EMPLOYEEID IN NUMBER)
IS
BEGIN
    SELECT * FROM EMPLOYEE where EMPLOYEEID=(select reportsto from employee where employeeid=EMPLOYEEID)
    COMMIT;
END;
/


--4.3
select * from customer;

CREATE OR REPLACE PROCEDURE get_name_and_company_of_customer(CUSTOMERID IN NUMBER, firstname OUT 
                                            customer.firstname%TYPE, lastname OUT
                                            customer.lastname%TYPE, company OUT
                                            customer.company%TYPE)
IS
BEGIN
    SELECT firstname INTO firstname, lastname INTO lastname, company INTO company from CUSTOMER where CUSTOMERID=CUSTOMERID
END;
/


--5.0

select * from invoice;

select * from invoiceline;

CREATE OR REPLACE PROCEDURE delete_invoice(INVOICEIDa IN INVOICE.invoiceid%type)
IS
BEGIN
    DELETE FROM INVOICELINE where invoiceid=INVOICEIDa;
    DELETE FROM INVOICE where invoiceid=INVOICEIDa;
    COMMIT;
END;
/



BEGIN
    delete_invoice(111);
END;
/

select * from customer;

CREATE OR REPLACE PROCEDURE insert_new_customer_record
    (firstname in customer.firstname%type,
    lastname in customer.lastname%type,
    company in customer.company%type,
    address in customer.address%type,
    city in customer.city%type,
    state in customer.state%type,
    country in customer.country%type,
    postalcode in customer.postalcode%type,
    phone in customer.phone%type,
    fax in customer.fax%type,
    email in customer.email%type,
    supportrepid in customer.supportrepid%type)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES((select max(customerid) from customer) + 1,
                            firstname,
                            lastname,
                            company,
                            address,
                            city,
                            state,
                            country,
                            postalcode,
                            phone,
                            fax,
                            email,
                            supportrepid
                            );
                COMMIT;
END;
/



--6.1

CREATE OR REPLACE TRIGGER after_employee_insert
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO!');
END;
/


CREATE OR REPLACE TRIGGER after_album_update
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO!');
END;
/

CREATE OR REPLACE TRIGGER after_customer_delete
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO!');
END;
/



--7.1
select customer.firstname, customer.lastname, invoice.invoiceid
from customer inner join invoice 
on customer.customerid = invoice.customerid;

--7.2
select customer.customerid, customer.firstname,
        customer.lastname, invoice.invoiceid,
        invoice.total
from customer left outer join invoice
on (customer.customerid = invoice.customerid);

--7.3
select artist.name, album.title
from artist right outer join album
on artist.artistid=album.artistid;

--7.4
select artist.name
from album cross join artist
order by artist.name asc;

--7.5
select * from 
employee e1, employee 
where e1.reportsto=employee.reportsto;

