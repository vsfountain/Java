--CREATE USER bankuser
--IDENTIFIED BY p4ssw0rd
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to bankuser;
--GRANT resource to bankuser;
--GRANT create session TO bankuser;
--GRANT create table TO bankuser;
--GRANT create view TO bankuser


CREATE TABLE usertypes
(
   usertypeid NUMBER PRIMARY KEY,
   usertypename VARCHAR2(15) UNIQUE
);
CREATE TABLE Users
(
    userid number PRIMARY KEY,
    email varchar2(50) UNIQUE NOT NULL,
    fisrtname varchar(20),
    lastname varchar(20),
    usertype number,
    userpassword varchar(20) NOT NULL
);
CREATE TABLE accounttypes
(
   accounttypeid NUMBER PRIMARY KEY,
   accounttypename VARCHAR2(15) UNIQUE
);

CREATE TABLE userstoaccounts
(
    userid number,
    accountid number,
    PRIMARY KEY (userid, accountid)
);

CREATE TABLE accounts
(
    accountid number PRIMARY KEY,
    balance number NOT NULL,
    accounttypeid number REFERENCES accounttypes (accounttypeid)
);

CREATE TABLE accountapps
(
    accountid number,
    accounttypeid number REFERENCES accounttypes (accounttypeid),
    userid number REFERENCES users(userid),
    PRIMARY KEY (accountid,userid)
   ); 
   
--DROP TABLE accountapps;
ALTER TABLE users ADD CONSTRAINT FK_usertypeid 
FOREIGN KEY (usertype) REFERENCES usertypes (usertypeid);

ALTER TABLE userstoaccounts ADD CONSTRAINT FK_userid
FOREIGN KEY (userid) REFERENCES users (userid);

ALTER TABLE userstoaccounts ADD CONSTRAINT FK_accountid
FOREIGN KEY (accountid) REFERENCES accounts (accountid);

INSERT INTO accounttypes VALUES(1,'Savings');
INSERT INTO accounttypes VALUES(2,'Checking');
INSERT INTO accounttypes VALUES(3,'Joint');

--SELECT * FROM accounttypes;

INSERT INTO usertypes values(2,'Client');
INSERT INTO usertypes values(1,'Admin');
COMMIT;

INSERT INTO users VALUES(1, 'email@', 'Joshua', 'J', 1);

--select * from users join usertypes on users.USERTYPE = usertypes.USERTYPEID;

--ALTER TABLE users ADD userpassword varchar2(20);
--
--ALTER TABLE users
--  MODIFY email varchar2(50) NOT NULL;
--ALTER TABLE users
--  MODIFY userpassword varchar(20) NOT NULL;
--  
--ALTER TABLE accounts
--MODIFY balance number NOT NULL;
--  
--UPDATE users SET userpassword = '123' WHERE userid = 1;  
--

--email varchar2(50) UNIQUE NOT NULL,
--    userpassword varchar(20) NOT NULL,
ALTER TABLE users
RENAME COLUMN fisrtname TO firstname;
select * from users;
-------SEQUENCES
CREATE SEQUENCE userid_seq
    START WITH 2
    INCREMENT BY 1;

CREATE SEQUENCE accountid_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE PROCEDURE insert_user(newEmail varchar2,
    newFirstName varchar2, newLastName varchar2, newPassword varchar2)
IS
BEGIN
    INSERT INTO users VALUES( userid_seq.NEXTVAL, newEmail,
    newFirstName,newLastName, 2, newPassword);
    COMMIT;
END;
/
Select * from usertypes;
Select * from users;
BEGIN
insert_user('n@', 'namething', 'another', '123');
end;
/

CREATE OR REPLACE PROCEDURE account_app(accounttype NUMBER, userid NUMBER, thing OUT number)
IS
BEGIN
    thing := accountid_seq.nextval;
    INSERT INTO accountapps VALUES( thing, accounttype, userid);
    COMMIT;
END;
/
SELECT * FROM ACCOUNTTYPES;
SELECT *
  FROM all_sequences
 WHERE sequence_name = 'ACCOUNTID_SEQ';