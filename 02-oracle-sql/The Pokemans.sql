--THIS IS HOW TO COMMENT
DESC pokemon;
SELECT * FROM pokemon;
--------CREATING A TABLE
--DATATYPES? Number, Varchar, Varchar2, Date, Timestamp, and BLOB and CLOB
--CONSTRAINTS? Primary key, foreign, unique, not null,  check
--      Not null- it can't be empty
--      Unique- no duplicates
--      Primary Key- unique identifier for the record (notnull & unique)
--      Foreign Key- references primary key from another table.
--      Check-  restricts values of attribute.
--          e.g. attribute_name BETWEEN 0 and 75
CREATE TABLE pokemon(
pokemon_id NUMBER(15) PRIMARY KEY,
pokemon_name VARCHAR2(100) UNIQUE,
pokemon_type VARCHAR2(25) NOT NULL,
--PRIMARY KEY(pokemon_id)
CONSTRAINT poke_id CHECK (pokemon_id >0)
);

--alter table has a variety of functionalities. Including
----adding attributes, renaming table, renaming attributes, and more
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);
--how to drop a table?
DROP TABLE pokemon;

----inserting records
SELECT * FROM pokemon;
SELECT pokemon_name, pokemon_secondtype FROM pokemon;

INSERT INTO pokemon VALUES(1, 'bulbasaur', 'grass', 'ice');
INSERT INTO pokemon VALUES(7, 'squirtle', 'water', 'none');
INSERT INTO pokemon VALUES(25, 'pikachu', 'electric', 'none');
INSERT INTO pokemon VALUES(129, 'Magikarp', 'water', 'best');
INSERT INTO pokemon VALUES(1290, 'Magikarp0', 'water', 'best');
INSERT INTO pokemon(pokemon_id, pokemon_type, pokemon_name)
        VALUES(143, 'normal', 'snorlax');
        
--modifying existing records
UPDATE pokemon SET pokemon_secondtype='poison' WHERE pokemon_id=1;

--delete from table?
DELETE FROM pokemon WHERE pokemon_name='Magikarp0';
DELETE FROM pokemon;

SELECT * FROM pokemon;
--truncate the table
TRUNCATE TABLE pokemon;

rollback;
commit;