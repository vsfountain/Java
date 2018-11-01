-- 2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS null;

-- 2.2 ORDER BY
SELECT * FROM album;
SELECT title FROM album ORDER BY title DESC;

SELECT * FROM customer;
SELECT firstname FROM customer ORDER BY city;

-- 2.4 INSERT INTO
SELECT * FROM genre;
DESC genre;
DESC employee;
DESC customer;
INSERT INTO genre VALUES(26, 'Bluegrass');
INSERT INTO genre VALUES(27, 'German House Music');

INSERT INTO employee(employeeid, lastname, firstname, title) VALUES(9, 'Pride', 'Phillip', 'Software Developer');
INSERT INTO employee (employeeid, lastname, firstname, title) VALUES(10, 'Ryan', 'Williams', 'Software Developer');

INSERT INTO customer(customerid, firstname, lastname, email) VALUES(60, 'Phillip', 'Pride', 'ppride@gmail.com');
INSERT INTO customer(customerid, firstname, lastname, email) VALUES(61, 'Ryan', 'Williams', 'rwilliams@gmail.com');

