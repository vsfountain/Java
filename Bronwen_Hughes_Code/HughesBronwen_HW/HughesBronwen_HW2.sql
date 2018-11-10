/*2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.*/
    /*2.1 SELECT*/
        /*Task – Select all records from the Employee table.*/
        SELECT * FROM employee;
        
        /*Task – Select all records from the Employee table where last name is King.*/
        SELECT * FROM employee WHERE lastname = 'King';
        
        /*Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
        SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;
    
    /*2.2 ORDER BY*/
        /*Task – Select all albums in Album table and sort result set in descending order by title.*/
        SELECT * FROM album ORDER BY title DESC;
        /*Task – Select first name from Customer and sort result set in ascending order by city*/
        SELECT * FROM customer ORDER BY city;
    
    /*2.3 INSERT INTO*/
        /*Task – Insert two new records into Genre table*/
        SELECT * FROM genre;
        INSERT INTO genre(GENREID, NAME) VALUES(26, 'Vaporwave');
        INSERT INTO genre(GENREID, NAME) VALUES(27, 'Chillstep');
    
        /*Task – Insert two new records into Employee table*/
        SELECT * FROM employee;
        INSERT INTO employee VALUES(9, 'Hughes', 'Bronwen', 'IT Staff', ' 6', '09-NOV-94', '09-MAR-04', '221B Baker Street', 'London', null, 'United Kingdon', 'T92 J15', '+1 (493) 392-2931', '+1 (293)231-5931', 'bronwen@hughesnet.org');
        INSERT INTO employee VALUES(10, 'Hughes', 'Dylan', 'IT Staff', ' 6', '27-OCT-97', '01-OCT-07', '221A Baker Street', 'London', null, 'United Kingdon', 'T92 J15', '+1 (493) 392-2931', '+1 (293)231-5931', 'bronwen@hughesnet.org');
        
        /*Task – Insert two new records into Customer table*/
        SELECT * FROM customer;
        INSERT INTO customer VALUES(60, 'James', 'Smith', null, '21 IDK Street', 'London', null, 'United Kingdom', 'EH4 1HH', '+44 293 2939 2932', null, 'mm@yahoonet', 4);
        INSERT INTO customer VALUES(61, 'Jane', 'Smith', null, '21 IDK Street', 'London', null, 'United Kingdom', 'EH4 1HH', '+44 293 2939 2932', null, 'jm@yahoonet', 4);
        
        /*2.4 UPDATE*/
        /*Task – Update Aaron Mitchell in Customer table to Robert Walter*/
        SELECT * FROM customer;
        SELECT * FROM customer WHERE firstname ='Aaron';
        UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE customerid = 32;
        
        /*Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”*/
        SELECT * FROM artist WHERE name ='Creedence Clearwater Revival';
        UPDATE artist SET name = 'CCR' WHERE artistid = 76;
    
    /*2.5 LIKE*/
        /*Task – Select all invoices with a billing address like “T%”*/
        SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
    
    /*2.6 BETWEEN*/
        /*Task – Select all invoices that have a total between 15 and 50*/
        SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
    
        /*Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004*/
        SELECT * FROM employee;
        SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
    
    /*2.7 DELETE*/
        /*Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
        that rely on this, find out how to resolve them).*/
        
        DELETE FROM customer WHERE firstname = 'Robert' AND lastname ='Walter';
        SELECT * FROM customer WHERE firstname = 'Robert';
        SELECT * FROM invoice WHERE customerid = 32;
        DELETE FROM invoice WHERE customerid = 32;
        SELECT * FROM INVOICELINE;
        DELETE FROM invoiceline WHERE invoiceid IN(245,268,290,342,50,61,116);
       
        COMMIT;
        

/* 2.0 ENDS*/

/*3.0 SQL Functions*/
/*In this section you will be using the Oracle system functions, as well as your own functions, to perform
various actions against the database*/
    /*3.1 System Defined Functions*/
        /*Task – Create a function that returns the current time.*/
        CREATE OR REPLACE FUNCTION print_date
        RETURN VARCHAR2
        IS
            current_time VARCHAR2(100);
        BEGIN
            SELECT current_timestamp INTO current_time FROM DUAL; 
            RETURN current_time;
        END;
        /
        
        DECLARE
            current_time VARCHAR2(100);
        BEGIN
            current_time := print_date();
            DBMS_OUTPUT.PUT_LINE('date: ' || current_time);
        END;
        /
            
        /*Task – create a function that returns the length of a mediatype from the mediatype table*/
        CREATE OR REPLACE FUNCTION mediatype_length
        RETURN NUMBER
        IS
           length NUMBER;
        BEGIN
            SELECT LENGTH(name) INTO length  FROM  mediatype WHERE mediatypeid = '1';
            -- FROM dual; 
            RETURN length;
        END;
        /
        
        SELECT COUNT( *) FROM mediatype;
        
        DECLARE
            length NUMBER;
        BEGIN
            length := mediatype_length();
            DBMS_OUTPUT.PUT_LINE('Mediatype length: ' || length);
        END;
        /
        
        SELECT *  FROM invoice;
        SELECT AVG(count) INTO num FROM invoice;
    /*3.2 System Defined Aggregate Functions*/
        /*Task – Create a function that returns the average total of all invoices*/
        CREATE OR REPLACE FUNCTION returns_avg_invoice
        RETURN NUMBER
        IS
            num NUMBER;
        BEGIN
            SELECT AVG(total) INTO num FROM invoice;
            RETURN num;
        END;
        /
        
        DECLARE
            num NUMBER;
        BEGIN
            num := returns_avg_invoice();
            DBMS_OUTPUT.PUT_LINE('Average Total of All Invoices: ' || num);
        END;
        /
        
        /*Task – Create a function that returns the most expensive track*/
        CREATE OR REPLACE FUNCTION find_expensive_track
        RETURN NUMBER
        IS
            num NUMBER;
        BEGIN
            SELECT MAX(unitprice) INTO num FROM track;
            RETURN num;
        END;
        /
        
        DECLARE
            num NUMBER;
        BEGIN    
            num := find_expensive_track();
            DBMS_OUTPUT.PUT_LINE('Most Expensive Track: ' || num);
        END;
        /
            
       /* 3.3 User Defined Scalar Functions*/
        /*Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/
        CREATE OR REPLACE FUNCTION average_price_invoice
        RETURN NUMBER
        IS
            sumNum NUMBER;
            amt NUMBER;
        BEGIN
            SELECT SUM(unitprice) INTO sumNum FROM invoiceline;
            SELECT COUNT(unitprice) INTO amt FROM invoiceline;
            RETURN sumNum / amt;
        END;
        /
        
        DECLARE
            num NUMBER;
        BEGIN
            num := average_price_invoice();
            DBMS_OUTPUT.PUT_LINE('Average Price Invoice: ' || num);
        END;
        /
        
        SELECT * FROM employee;
        /*3.4 User Defined Table Valued Functions*/
        /*Task – Create a function that returns all employees who are born after 1968.*/
        CREATE OR REPLACE FUNCTION print_employees
        RETURN TABLE
        IS
            employee_table TABLE;
        BEGIN
            SELECT * FROM employee WHERE birthdate > '31-DEC-68' INTO employee_table;
            RETURN employee_table;
        END;
        /
        
        /*4.1 Basic Stored Procedure*/
        /*Task – Create a stored procedure that selects the first and last names of all the employees.*/
         CREATE VIEW employee_view AS SELECT firstname, lastname FROM employee;
         SELECT * FROM employee_view;
        CREATE OR REPLACE PROCEDURE select_employees(p_firstname IN VARCHAR2, p_lastname IN VARCHAR2)
        IS
        BEGIN
           SELECT firstname, lastname INTO employee_view FROM employee;
        END;
        /
        
        CREATE TABLE temp_table(
            firstname VARCHAR2(100),
            lastname VARCHAR2(100)
        );
        CREATE OR REPLACE PROCEDURE select_employees
        IS
        BEGIN
            INSERT INTO temp_table VALUES(SELECT firstname FROM employee, SELECT lastname FROM employee);
        END;
        /
        
        SELECT * FROM employee;
        /* 4.2 Stored Procedure Input Parameters*/
            /*Task – Create a stored procedure that updates the personal information of an employee.*/
            CREATE OR REPLACE PROCEDURE update_employee(employee_id IN NUMBER, employee_lastname IN VARCHAR2, employee_firstname IN VARCHAR2)
            IS
            BEGIN
                   -- SELECT firstname INTO 
                   UPDATE employee SET lastname = employee_lastname, firstname = employee_firstname WHERE employeeid = employee_id;
            END;       
            /
            
            BEGIN
                update_employee(2, 'Hughes', 'Bronwen');
            END;
            /
            
            SELECT * FROM employee;
            /*Task – Create a stored procedure that returns the managers of an employee.*/
            CREATE OR REPLACE PROCEDURE return_manager(employee_id IN NUMBER, employee_reportsto OUT NUMBER, manager_lastname OUT employee.lastname%TYPE, manager_firstname OUT employee.firstname%TYPE)
            IS
            BEGIN
                SELECT reportsto INTO employee_reportsto FROM employee WHERE employeeid = employee_id;         
                SELECT lastname INTO manager_lastname FROM employee WHERE employeeid = employee_reportsto; 
                SELECT firstname INTO manager_firstname FROM employee WHERE employeeid = employee_reportsto; 
            END;
            /
            
            DECLARE
                manager_lastname VARCHAR2(100);
                manager_firstname VARCHAR2(100);
                employee_reportsto NUMBER;
            BEGIN
                return_manager(2, employee_reportsto, manager_lastname, manager_firstname);
                DBMS_OUTPUT.PUT_LINE('Manager is: ' || manager_lastname || ' ' || manager_firstname);
            END;
            /
        
        SELECT * FROM customer;
       /*4.3 Stored Procedure Output Parameters*/
            /*Task – Create a stored procedure that returns the name and company of a customer.*/
        CREATE OR REPLACE PROCEDURE return_customer_info(customer_id IN NUMBER, customer_firstname OUT customer.firstname%TYPE, customer_lastname OUT customer.lastname%TYPE, customer_company OUT customer.company%TYPE)
        IS
        BEGIN
            SELECT firstname INTO customer_firstname FROM customer WHERE customerid = customer_id;
            SELECT lastname INTO customer_lastname FROM customer WHERE customerid = customer_id;
            SELECT company INTO customer_company FROM customer WHERE customerid = customer_id;
        END;
        /
        
        DECLARE
            customer_firstname VARCHAR2(100);
            customer_lastname VARCHAR2(100);
            customer_company VARCHAR2(100);
        BEGIN
            return_customer_info(1, customer_firstname, customer_lastname, customer_company);
            DBMS_OUTPUT.PUT_LINE('Customer: ' || customer_firstname || ' ' || customer_lastname);
            DBMS_OUTPUT.PUT_LINE('Company: ' || customer_company);
        END;
        /
        
        SELECT * FROM invoice;
     /* 5.0 Transactions*/
     /*In this section you will be working with transactions. Transactions are usually nested within a stored procedure.*/
        /*Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).*/
        CREATE OR REPLACE PROCEDURE trans_delete_invoice(invoice_id IN NUMBER)
        IS
        BEGIN
            DELETE FROM invoiceline WHERE invoiceid = invoiceid;
            DELETE FROM invoice WHERE invoiceid = invoice_id;
            COMMIT;
        END;
        /
        
        BEGIN
            trans_delete_invoice(217);
        END;
        /
        
        rollback;
        SELECT * FROM invoice;
        SELECT *FROM invoiceline;
        
        SELECT * FROM customer;
        /*Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table*/
        CREATE OR REPLACE PROCEDURE trans_add_record_customer(c_id IN NUMBER, c_firstname IN VARCHAR2, c_lastname IN VARCHAR2, c_company IN VARCHAR2, c_address IN VARCHAR2, c_city IN VARCHAR2, c_state IN VARCHAR2, c_country IN VARCHAR2, c_postalcode IN VARCHAR2, c_phone IN VARCHAR2, c_fax IN VARCHAR2, c_email IN VARCHAR2, c_supportrepid IN NUMBER)
         IS
         BEGIN
            INSERT INTO customer VALUES(c_id, c_firstname, c_lastname, c_company, c_address, c_city, c_state, c_country, c_postalcode, c_phone, c_fax, c_email, c_supportrepid);
            COMMIT;
         END;   
         /
         
        BEGIN
              trans_add_record_customer(60, 'James', 'Smith', null, '21 IDK Street', 'London', null, 'United Kingdom', 'EH4 1HH', '+44 293 2939 2932', null, 'mm@yahoonet', 4);
        END;
        /
        
        SELECT * FROM customer;
        rollback;
        
        /*6.0 Triggers*/
        /*In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.*/
            /*6.1 AFTER/FOR*/
                /*Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.*/
               CREATE OR REPLACE TRIGGER employee_insert_t
               AFTER INSERT ON employee
               BEGIN
                    DBMS_OUTPUT.PUT_LINE('employee_insert_t fired!');
               END;
               /
               COMMIT;
               INSERT INTO employee VALUES(9, 'Hughes', 'Bronwen', 'IT Staff', ' 6', '09-NOV-94', '09-MAR-04', '221B Baker Street', 'London', null, 'United Kingdon', 'T92 J15', '+1 (493) 392-2931', '+1 (293)231-5931', 'bronwen@hughesnet.org');
               
                /*Task – Create an after update trigger on the album table that fires after a row is inserted in the table*/
                CREATE OR REPLACE TRIGGER album_update_t
               AFTER UPDATE ON album
               BEGIN
                    DBMS_OUTPUT.PUT_LINE('album_update_t fired!');
               END;
               /
               COMMIT;

                UPDATE album SET title = 'Mozart: Chamber Music I' WHERE albumid = 346;
                SELECT * FROM  album;
                /*Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.*/
                CREATE OR REPLACE TRIGGER customer_delete_t
               AFTER DELETE ON customer
               BEGIN
                    DBMS_OUTPUT.PUT_LINE('customer_delete_t fired!');
               END;
               /
               COMMIT;
               SELECT * FROM customer;
               DELETE FROM customer WHERE customerid = 60;
               
               /*7.0 JOINS*/
                /*In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.*/
                    /*7.1 INNER*/
                        /*Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
                        SELECT customer.firstname, customer.lastname, invoice.invoiceid 
                        FROM customer 
                        INNER JOIN invoice ON customer.customerid = invoice.customerid;
                        
                        SELECT * FROM customer;
                        SELECT * FROM invoice;
                    /*7.2 OUTER*/
                        /*Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/
                         SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
                         FROM customer 
                         FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
                    /*7.3 RIGHT*/
                        /*Task – Create a right join that joins album and artist specifying artist name and title.*/
                        SELECT album.title, artist.name 
                        FROM album
                        RIGHT JOIN artist ON album.artistid = artist.artistid;
                        select * from artist;
                        select * from album;
                    /*7.4 CROSS*/
                        /*Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
                        SELECT * 
                        FROM album
                       CROSS JOIN artist
                       ORDER BY name;
                    /*7.5 SELF*/
                        /*Task – Perform a self-join on the employee table, joining on the reportsto column.*/
                        SELECT A.employeeid AS employeeid1, B.employeeid AS employeeid2,
                        A.reportsto
                        FROM employee A, employee B 
                        WHERE A.reportsto <> B.reportsto;
                        SELECT * FROM employee;
            /*9.0 Administration*/
            /*In this section you will be creating backup files of your database. After you create the backup file you
                will also restore the database. Research or try random things then communicate with batchmates, do
                not ask trainer.*/
                    /*Task – Create a .bak file for the Chinook database. */
                    
                    
                    
                    
                    
    /*Join EVERY TABLE in the chinook database in a single join statement.*/
    SELECT employeeid, reportsto
    FROM  employee
    FULL OUTER JOIN customer ON employee.employeeid = customer.colname;