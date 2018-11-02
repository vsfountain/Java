---NOTE TO SELF
--under the view menu, you click "dbms output"
--then in the dbms tab click the green plus sign and add
-----your current connection.
--You always forget, so im helping you out, future self.
----I got you, bro.


--EXAMPLES of PL/SQL
--Procedural Language SQL

DROP TABLE pokemon;

CREATE TABLE pokemon(
pokemon_id NUMBER(15),
pokemon_name VARCHAR2(100) UNIQUE,
pokemon_type VARCHAR2(15) NOT NULL,
PRIMARY KEY(pokemon_id)
);

DESC pokemon;

--OBJECTS in PL/SQL, that we are going to talk about
-----functions, stored procedures, triggers, sequences, cursors


---STORED PROCEDURES
--   a block of code that performs one or more tasks
/*
CREATE [OR REPLACE] PROCEDURE proc_name (list of parameters)
IS
    *declaration section*
BEGIN
    *execution section*
EXCEPTION
    *exception section*
END;
/  <----THERE IS A SLASH HERE
*/
--OUR HELLO WORLD PROCEDURE
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD!');
END;
/    
------there is a slash at the end....SLAAAAAASH...
--this is how to execute a stored procedure
BEGIN
    hello_world_procedure;
END;
/


--INSERT stored procedure example
CREATE OR REPLACE PROCEDURE insert_pokemon(p_id IN NUMBER,
                p_name IN VARCHAR2, p_type IN VARCHAR2)
IS
BEGIN
    INSERT INTO pokemon VALUES(p_id, p_name, p_type);
    COMMIT;
END;
/

SELECT * FROM pokemon;
--executing
BEGIN
    insert_pokemon(1001, 'Mike J', 'ground');
    insert_pokemon(1002, 'Vanessa', 'fire');
END;
/


------OUT example-----
CREATE OR REPLACE PROCEDURE get_pokemon(p_id IN NUMBER,
        p_name OUT pokemon.pokemon_name%TYPE)
                        --dynamically find a data type
IS
BEGIN
    SELECT pokemon_name INTO p_name FROM pokemon WHERE pokemon_id=p_id;
END;
/
--exec
DECLARE
    p_name VARCHAR2(4000);
BEGIN
    get_pokemon(1002, p_name);
    DBMS_OUTPUT.PUT_LINE('response ' || p_name);
END;
/

-------FUNCTIONS------
--   a block of code that performs one or more tasks
-------structure similar to procedures, but it has a return type
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS 
    --declaring variable
    max_id NUMBER;
BEGIN
    SELECT MAX(pokemon_id) INTO max_id FROM pokemon;
    RETURN max_id;
END;
/
--execute
DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('max pokemon: ' || max_id);
END;
/
--SELECT * FROM pokemon;

-----
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
--EXEC
DECLARE
    greater NUMBER;
BEGIN
    greater := get_max(550, 100);
    DBMS_OUTPUT.PUT_LINE('max num is: ' || greater);
END;
/
--execute....again
SELECT get_max(33, 79) FROM dual;



-------SEQUENCES
CREATE SEQUENCE poke_seq
    START WITH 1015
    INCREMENT BY 1;
    
---------------------
--DROP SEQUENCE poke_seq;

CREATE OR REPLACE PROCEDURE insert_pokemon_null_id(p_name IN VARCHAR2,
                    p_type IN VARCHAR2)
IS
BEGIN
    INSERT INTO pokemon VALUES(poke_seq.NEXTVAL, p_name, p_type);
    commit;
END;
/
--execute
BEGIN
    insert_pokemon_null_id('missingno4', 'poison');
END;
/
SELECT * FROM pokemon;


-----TRIGGERS
--A trigger is a block structure that fires when a DML statement like
-- ---update, delete, or insert happens. It's automatic.
/*
CREATE [OR REPLACE] TRIGGER trigger_name
BEFORE | AFTER -    INSERT | UPDATE | DELETE
ON table_name
FOR EACH ROW
DECLARE
BEGIN
EXCEPTION
END;
/    <-----SLASH, DON'T FORGET
*/
CREATE OR REPLACE TRIGGER pokemon_insertb
BEFORE INSERT ON pokemon
FOR EACH ROW
BEGIN
    IF :new.pokemon_id IS NULL then
        SELECT poke_seq.nextval INTO :new.pokemon_id FROM dual;
    END IF;
END;
/
DROP TRIGGER pokemon_insertb;
--exec
INSERT INTO pokemon VALUES(null, 'Ryan', 'fire');
SELECT * FROM pokemon;


/*
What are the difference between stored procedure and functions?

   function                        vs                   procedure
   -----------                                  ---------------
   only DQL                                         DQL and DML
   return type                                        no return type
    can't call a stored procedure              can call functions
    IN parameters                           IN and OUT parameters
    called using exec block OR select          called using exec block
    
    (and yes, a procedure can call a procedure)
*/

---CURSORS
-------A temporary work area created in the system memory when a sql statement
--is executed. Cursor contains information on a select statement and the rows of
--data accessed by it.
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
is
    EMPLOYEE_C SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE 
    BIRTHDATE >= TO_DATE('01-01-1968', 'DD-MM-YYYY');
    return EMPLOYEE_C;
END;
/

select after_1968 from dual;
select * from employee;

SET SERVEROUTPUT ON;


