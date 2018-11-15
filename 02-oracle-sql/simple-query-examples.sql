----different types of selects-----------
SELECT * FROM employee;
SELECT * FROM employee WHERE title='Sales manager';--case sensitive for quotes
SELECT * FROM employee WHERE title='Sales Manager';
SELECT * FROM employee WHERE title='Sales Support Agent';
SELECT * FROM employee WHERE title='Sales Support Agent' AND firstname='Jane';
SELECT * FROM employee WHERE firstname='Andrew' OR firstname='Nancy'
                OR firstname='Margaret';
--different ways to say not equals
SELECT * FROM employee WHERE firstname != 'Jane';
SELECT * FROM employee WHERE NOT firstname = 'Jane';
SELECT * FROM employee WHERE firstname <> 'Jane';
SELECT * FROM employee WHERE firstname ^= 'Jane';
--   >, <, <=, >=
--NULL references
SELECT * FROM employee WHERE reportsto=null;--this won't work
SELECT * FROM employee WHERE reportsto='null';--this won't work
SELECT * FROM employee WHERE reportsto IS NULL;
SELECT * FROM employee WHERE reportsto IS NOT NULL;

DESC album;
SELECT * FROM album;
---LIKE keyword
---  % means zero or more character wildcard     
--   _ means single character wildcard
SELECT * FROM album WHERE title='Big Ones';
SELECT * FROM album WHERE title LIKE 'B%';
SELECT * FROM album WHERE title LIKE '%g Ones';
SELECT * FROM album WHERE title LIKE '_ig Ones';
SELECT * FROM album WHERE title LIKE 'Big Ones';
SELECT * FROM album WHERE title LIKE '_i_ O%s';

---ORDER BY, sorting
--DEFAULTS to ascending order
DESC employee;
SELECT * FROM employee;
SELECT * FROM employee ORDER BY lastname;
SELECT * FROM employee ORDER BY lastname DESC;
SELECT * FROM employee ORDER BY lastname ASC;
SELECT * FROM employee ORDER BY title, lastname;
SELECT * FROM employee ORDER BY 4, 2;

----BETWEEN keyword
-------inclusive range
SELECT * FROM employee WHERE employeeid BETWEEN 5 AND 7;

----IN keyword example
SELECT * FROM employee;
SELECT * FROM employee WHERE firstname='Andrew' OR firstname='Nancy'
                OR firstname='Margaret';
SELECT * FROM employee WHERE firstname IN ('Andrew', 'Nancy', 'Margaret');
--this is a nested query as well as another way to use the IN keyword
SELECT * FROM employee WHERE firstname IN
    (SELECT firstname FROM employee WHERE firstname='Andrew' OR firstname='Nancy'
                OR firstname='Margaret');

----------AGGREGATE FUNCTIONS---------------
--what is an aggregate function?
----a function that works on all the data entries as a whole.
---   COUNT, MAX, MIN, AVG, SUM, DISTINCT    there are more but i want
--                                          to highligh these six
SELECT * FROM album;
SELECT COUNT(*) FROM album;
SELECT * FROM employee;
SELECT COUNT(*) FROM employee WHERE title='Sales Support Agent';
SELECT COUNT(DISTINCT(title)) FROM employee;

SELECT * FROM invoice;
SELECT invoiceid, customerid, total FROM invoice;
SELECT MAX(total) FROM invoice;
SELECT MIN(total) FROM invoice;
SELECT AVG(total) FROM invoice;
SELECT SUM(total) FROM invoice;
--GROUP BY keyword
-- group by is used with aggregate functions
SELECT * FROM invoice;
SELECT billingcountry, COUNT(*) FROM invoice GROUP BY billingcountry;

----HAVING keyword example
SELECT billingcountry, SUM(total) FROM invoice GROUP BY billingcountry;
SELECT billingcountry, SUM(total) FROM invoice GROUP BY billingcountry
    HAVING billingcountry IN ('Ireland','Germany');
SELECT billingcountry, SUM(total) FROM invoice WHERE billingcountry='Ireland'
    OR billingcountry='Germany' GROUP BY billingcountry;
--why separate the keywords if they acheive the same thing?
SELECT billingcountry, sum(total) FROM invoice GROUP BY billingcountry
    HAVING sum(total)<50;
--SELECT billingcountry, sum(total) FROM invoice WHERE SUM(total)<50
 --       GROUP BY billingcountry;
--WHERE can only be used on entries before it is aggregated
--HAVING can be used on entries before OR after aggregation


-----------------SCALAR FUNCTIONS
--what in the blue blazes is a scalar function?
--scalar functions act on an individual record/entry

--TYPES:  numeric, character, date, conversion
SELECT 7*10 FROM dual;
SELECT 'dummy table' FROM dual;
SELECT * FROM dual;
--NUMERIC   there are lots of these. Including but not limited to:
--      abs(x), ceil(x), floor(x), trunc(x,y), round(x,y)
SELECT abs(-99) FROM dual;
SELECT floor(88.77) FROM DUAL;

--CHARACTER     lots of these, inclulding but not limited to:
--          upper(x), lower(x), length(x)
SELECT UPPER('HELLO world') FROM DUAL;
SELECT lower('HELLO world') FROM DUAL;
SELECT length('HELLO world') FROM DUAL;
--DATE    there are lots of these....
--      next_day(x, 'week_day'), last_day(x), sysdate
SELECT sysdate FROM DUAL;
SELECT last_day(sysdate) FROM dual;

--CONVERSION       converts data types
--      to_char(), to_date()   and more
SELECT * FROM invoice;
SELECT billingcountry, billingcity FROM invoice;
SELECT UPPER(billingcountry), billingcity FROM invoice;

--------SUB QUERIES example----------
-- query within a query
DESC customer;
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT * FROM customer WHERE customerid IN(
        SELECT customerid FROM invoice WHERE total>16.0);
        
--another sub query
SELECT customerid, total, invoiceid FROM (select * from invoice where total>16.0)
            WHERE invoiceid>200;

