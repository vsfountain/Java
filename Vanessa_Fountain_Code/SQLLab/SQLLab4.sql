--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid;
SELECT * FROM invoice;
select * from invoiceline;


DELETE FROM INVOICE,invoiceline WHERE INVOICElineid = '670'; 
commit;

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
Select * from customer,invoice;
SELECT * FROM artist a right JOIN album b ON a.artistid=b.artistid
    WHERE a.artistid IN(
        SELECT a.artistid FROM artist a INNER JOIN
        album b ON a.artistid = b.artistid);

SELECT * FROM album CROSS JOIN artist;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM artist A INNER JOIN album B ON A.artistid=B.artistid;
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Research or try random things then communicate with batchmates, do not ask trainer.
--Task – Create a .bak file for the Chinook database.

