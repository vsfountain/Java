

drop table account_user_ref;
drop table users;
drop table unapproved;
drop table accounts;


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE users
(
    userid VARCHAR2(20) NOT NULL,
    pass VARCHAR2(20) NOT NULL,
    firstname VARCHAR2(20),
    lastname VARCHAR2(20),
    email VARCHAR2(20),
    address VARCHAR2(20),
    ssn VARCHAR2(12),
    birthday DATE,
    usertype VARCHAR2(10) NOT NULL,
    CONSTRAINT usertype_check CHECK (usertype IN  ('admin', 'associate', 'client')),
    CONSTRAINT pk_user PRIMARY KEY (userid)
);

CREATE TABLE accounts
(
    accountid NUMBER NOT NULL,
    balance NUMBER NOT NULL,
    acctype VARCHAR2(20),
	CONSTRAINT acctype_check CHECK (acctype IN  ('personal', 'joint')),
    CONSTRAINT pk_account PRIMARY KEY (accountid)
);

CREATE TABLE account_user_ref
(
    refid NUMBER NOT NULL,
    accountid NUMBER NOT NULL,
    userid VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_ref PRIMARY KEY (refid)
);

CREATE TABLE unapproved
(
    unid NUMBER NOT NULL,
    accountid NUMBER NOT NULL,
    CONSTRAINT pk_unap PRIMARY KEY (unid)
);

SELECT * FROM users;
SELECT * FROM accounts;
SELECT * FROM account_user_ref;

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE account_user_ref ADD CONSTRAINT fk_r_accountid
    FOREIGN KEY (accountid) REFERENCES accounts (accountid) ON DELETE CASCADE;

ALTER TABLE unapproved ADD CONSTRAINT fk_u_accountid
    FOREIGN KEY (accountid) REFERENCES accounts (accountid) ON DELETE CASCADE;

ALTER TABLE account_user_ref ADD CONSTRAINT fk_userid
    FOREIGN KEY (userid) REFERENCES users (userid) ON DELETE CASCADE;
    
/*******************************************************************************
   Create Sequences, Procedures, etc.
********************************************************************************/
DROP SEQUENCE ref_seq;
DROP SEQUENCE account_seq;
DROP SEQUENCE un_seq;

CREATE SEQUENCE ref_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE account_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE un_seq
    START WITH 1
    INCREMENT BY 1;



CREATE OR REPLACE FUNCTION insert_new_account(uid IN users.userid%TYPE, atype IN accounts.acctype%TYPE)
RETURN NUMBER
IS
BEGIN
    INSERT INTO accounts(accountid, balance, acctype) VALUES(account_seq.NEXTVAL, 0, atype);
    INSERT INTO account_user_ref VALUES(ref_seq.NEXTVAL, account_seq.CURRVAL, uid);
    INSERT INTO unapproved VALUES(un_seq.NEXTVAL, account_seq.CURRVAL);
    COMMIT;
	RETURN account_seq.CURRVAL;
END;
/

CREATE OR REPLACE PROCEDURE approve_account(uid IN users.userid%TYPE)
IS
BEGIN
    DELETE FROM unapproved WHERE accountid=uid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_user_to_account(aid IN NUMBER, uid IN users.userid%TYPE)
IS
BEGIN
    INSERT INTO account_user_ref VALUES(ref_seq.NEXTVAL, aid, uid);
    INSERT INTO unapproved VALUES(un_seq.NEXTVAL, aid);
    COMMIT;
END;
/



/*******************************************************************************
   Populate Tables
********************************************************************************/
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('root', 'root', 'root', 'root', 'admin');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('pipkin', 'pipkin', 'Louis', 'Louis', 'associate');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('test', 'test', 'Louis', 'Louis', 'associate');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('dvorak', 'dvorak', 'John', 'Dvorak', 'client');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('curry', 'curry', 'Adam', 'Curry', 'client');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('potter', 'potter', 'Harry', 'Potter', 'client');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('baggins', 'baggins', 'Frodo', 'Baggins', 'client');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('ash', 'ash', 'Red', 'Ash', 'client');
INSERT INTO users (userid, pass, firstname, lastname, usertype) VALUES ('ryker', 'ryker', 'Bill', 'Ryker', 'client');

--
--INSERT INTO accounts (accountid, balance, name) VALUES (1, 1000, 'Savings');
--
--INSERT INTO account_user_ref (refid, accountid, userid) VALUES (1, 1, 'dvorak');


DECLARE
   res NUMBER;
BEGIN
    res := insert_new_account('dvorak', 'personal');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
    res := insert_new_account('dvorak', 'joint');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
        res := insert_new_account('curry', 'personal');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
    --res := insert_new_account('curry', 'joint');
    --DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
            res := insert_new_account('potter', 'personal');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
    res := insert_new_account('potter', 'joint');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
            res := insert_new_account('baggins', 'personal');
    DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
    --res := insert_new_account('baggins', 'joint');
    --DBMS_OUTPUT.PUT_LINE('Result is: ' || res);
END;
/

BEGIN
    add_user_to_account(2, 'curry');
    add_user_to_account(5, 'baggins');
END;
/

SELECT * FROM accounts a INNER JOIN unapproved u ON a.accountid=u.accountid;
SELECT DISTINCT a.accountid, a.balance, a.acctype, r.userid FROM unapproved u INNER JOIN accounts a ON a.accountid=u.accountid JOIN account_user_ref r ON a.accountid=r.accountid;



SELECT a.accountid, a.balance, a.acctype, u.userid FROM accounts a INNER JOIN account_user_ref r ON a.accountid = r.accountid INNER JOIN users u ON u.userid = r.userid;  
SELECT a.accountid, a.balance, a.acctype, u.userid FROM accounts a JOIN account_user_ref r ON a.accountid = r.accountid JOIN users u ON u.userid = r.userid WHERE a.accountid = 2;  

SELECT * FROM users;


--DELETE FROM accounts WHERE accountid=6;
SELECT * FROM unapproved;
--DELETE FROM unapproved WHERE accountid=6;

COMMIT;
