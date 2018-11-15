------what is an entity in SQL?
-----------entity = object = table


-----ALIAS in sql
--first method
SELECT albumid, title FROM album;
SELECT albumid AS alBa, title AS DaTitle FROM album;
--second method
SELECT * FROM album WHERE albumid BETWEEN 5 AND 9;
SELECT * FROM album WHERE album.albumid BETWEEN 5 AND 9;
SELECT * FROM album Othername WHERE Othername.albumid BETWEEN 5 AND 9;
----------------------------------------------

SELECT * FROM album;
SELECT * FROM artist;
--INNER
SELECT * FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
SELECT * FROM artist a, album b WHERE a.artistid=b.artistid;
--LEFT, the word "outer" does nothing, it's for readability
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid;
SELECT * FROM artist a, album b WHERE a.artistid=b.artistid(+);
--RIGHT, the word "outer" does nothing, it's for readability
SELECT * FROM artist a RIGHT OUTER JOIN album b ON a.artistid = b.artistid;
SELECT * FROM artist a, album b WHERE a.artistid(+)=b.artistid;
--FULL, the word "outer" does nothing, it's for readability
SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid;

--EXCLUSIVE LEFT outer join
--one method: using subquiries
SELECT count(*) FROM artist a LEFT OUTER JOIN album b ON a.artistid=b.artistid
    WHERE a.artistid NOT IN(
        SELECT a.artistid FROM artist a INNER JOIN
        album b ON a.artistid = b.artistid);
--another method
SELECT count(*) FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid
    WHERE b.artistid IS NULL;



--SELF JOIN
-------SELECT * FROM table1 A INNER JOIN table1 B ON A.id=B.foreignid;

--CROSS JOIN
-----SELECT * FROM table1 CROSS JOIN table2;
SELECT count(*) FROM album;
SELECT count(*) FROM artist;
SELECT count(*) FROM album CROSS JOIN artist;

SELECT 347 * 275 FROM dual;







