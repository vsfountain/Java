--Chinook SQL lab

--question 1.0 set up chinook database....done (we ran chinook script)

--question 2.0 queries
--2.1
Select * from EMPLOYEE;
select * from employee where lastname = 'King';
select * from employee where firstname ='Andrew' and REPORTSTO is null ;

--2.2
select * from ALBUM order by title desc;
select firstname, city from customer order by city;--question doesnt ask for city but i put it to show its sorted

--2.3
INSERT INTO GENRE VALUES (26, 'Hipster Music');
INSERT INTO GENRE VALUES (27, 'Dikoko Beats');
select* from genre order by 1,2;
select * from employee;
desc employee;
INSERT INTO employee values(9, 'James', 'Graham', 'Research and Development', 1, '24-SEP-94', '22-OCT-18', '2225 N Street', 'Paris', 'AB', 'France', 'T2P', '+1 (404) 442-3691', '+1 (404) 442-3691', 'obidikoko@outlook.com');
INSERT INTO employee values(10, 'Clement', 'Dikoko', 'Research and Development', 9, '24-SEP-94', '22-OCT-18', '2226 N Street', 'Paris', 'AB', 'France', 'T2P', '+1 (414) 442-3691', '+1 (404) 445-3691', 'obialetdikoko@outlook.com');
commit;

--2.4 
update customer set firstname = 'Robert' where firstname = 'Aaron';
update customer set lastname = 'Walter' where lastname = 'Mitchell';
commit;
select * from customer;

update artist set artist.name = 'CCR' where artist.name = 'Creedence Clearwater Revival';
select * from artist;

--2.5
Select * from INVOICE where billingaddress Like 'T%';

--2.6
select * from invoice where total between 15 and 50;

--2.7
delete from customer where firstname = 'Robert ' and lastname = 'Walter';
select * from customer where firstname = 'Robert';
-----------------------------------------------------------------
--3.1
select sysdate todays_date from dual;
select length(name) as "SIZE 'Name' Col" from mediatype;

--3.2

select avg(total) from invoice;
select max(total) from invoice;

    select 
        name, 
        max(unitprice) Price 
    from track 
        group by name
        order by price desc
;


--3.3
select avg(total)from invoice;


--3.4
select * from EMPLOYEE where birthdate > '31-dec-68';

--4.0
CREATE OR REPLACE PROCEDURE LETSGETTHEM
AS
BEGIN
SELECT * FROM EMPLOYEES
END;
/
