CREATE TABLE trainers(
trainer_id NUMBER(15) PRIMARY KEY,
username VARCHAR2(100) UNIQUE,
password VARCHAR(25) NOT NULL,
hasAppliedForBox NUMBER(15),
hasBoxAccess NUMBER(15),
CONSTRAINT trainer_id CHECK (trainer_id > 0),
CONSTRAINT hasAppliedForBox CHECK (hasAppliedForBox >= 0 AND hasAppliedForBox <2),
CONSTRAINT hasBoxAccess CHECK (hasBoxAccess >= 0 AND hasBoxAccess <2)
);

-- Stored Procedure for creating new trainers
CREATE OR REPLACE PROCEDURE add_trainer(user_name IN VARCHAR2, pass_word IN VARCHAR2)
IS
BEGIN
    INSERT INTO trainers(username, password, hasAppliedForBox, hasBoxAccess) VALUES(user_name,pass_word,0,0);
END;
/

--DROP TABLE trainers;

CREATE TABLE pcbox(
box_id NUMBER(15) PRIMARY KEY,
pokemon VARCHAR2(100) UNIQUE,
trainer_id NUMBER(15) REFERENCES trainers(trainer_id),
CONSTRAINT box_id CHECK (box_id > 0)
);

UPDATE TABLE 

-- Auto set trainer_id
CREATE SEQUENCE next_trainer_id
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trainer_added
BEFORE INSERT ON trainers
FOR EACH ROW
BEGIN
    IF :new.trainer_id IS NULL then
        SELECT next_trainer_id.NEXTVAL INTO :new.trainer_id FROM dual;
    END IF;
END;
/

-- Auto set box_id
CREATE SEQUENCE next_poke_id
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER pokemon_deposit
BEFORE INSERT ON pcbox
FOR EACH ROW
BEGIN
    IF :new.box_id IS NULL then
        SELECT next_poke_id.NEXTVAL INTO :new.box_id FROM dual;
    END IF;
END;
/

SELECT * FROM trainers ORDER BY trainer_id;
SELECT * FROM pcbox ORDER BY trainer_id;
SELECT * FROM trainers a LEFT JOIN pcbox b ON a.trainer_id = b.trainer_id ORDER BY username;


SELECT username FROM trainers WHERE hasAppliedForBox = 1;
-- ALWAYS COMMIT!!!!!!
commit; -- DID YOU COMMIT!!!!!?????