


CREATE TABLE ERS_Reimbursement_STATUS
(
    REIMB_STATUS_ID NUMBER NOT NULL,
    REIMB_STATUS VARCHAR(10) NOT NULL,
    CONSTRAINT REIMB_STATUS_PK
    PRIMARY KEY (REIMB_STATUS_ID)
);
CREATE TABLE ERS_Reimbursement_TYPE
(
    REIMB_TYPE_ID NUMBER NOT NULL,
    REIMB_TYPE VARCHAR2(10) NOT NULL,
    CONSTRAINT REIMB_TYPE_PK
    PRIMARY KEY (REIMB_TYPE_ID)
);

CREATE TABLE ERS_USER_ROLES
(
    ERS_USER_ROLE_ID NUMBER NOT NULL,
    USER_ROLE VARCHAR2(10) NOT NULL,
    CONSTRAINT ERS_USER_ROLES_PK 
    PRIMARY KEY(ERS_USER_ROLE_ID)
);

CREATE TABLE ERS_USERS
(
    ERS_USERS_ID NUMBER NOT NULL,
    ERS_USERNAME VARCHAR2(50) UNIQUE NOT NULL,
    ERS_PASSWORD VARCHAR2(50) NOT NULL,
    USER_FIRST_NAME VARCHAR2(100) NOT NULL,
    USER_LAST_NAME VARCHAR2(100) NOT NULL,
    USER_EMAIL VARCHAR2(150) UNIQUE NOT NULL,
    USER_ROLE_ID NUMBER NOT NULL,
    CONSTRAINT ERS_USERS_PK
    PRIMARY KEY (ERS_USERS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT
(
   REIMB_ID NUMBER NOT NULL,
   REIMB_AMMOUNT NUMBER NOT NULL,
   REIMB_SUBMITTED TIMESTAMP NOT NULL,
   REIMB_RESOLVED TIMESTAMP,
   REIMB_DESCRIPTION VARCHAR2(250),
   REIMB_RECEIPT BLOB,
   REIMB_AUTHOR NUMBER NOT NULL,
   REIMB_RESOLVER NUMBER,
   REIMB_STATUS_ID NUMBER NOT NULL,
   REIMB_TYPE_ID NUMBER NOT NULL,
   CONSTRAINT ERS_REIMBURSEMENT PRIMARY KEY (REIMB_ID)
);


------------------------------------------------------------
------------------FORIGN KEY CONSTRAINTS--------------------
------------------------------------------------------------

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_AUTH
FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_USERS_FK_RESLVR
FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK
FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_Reimbursement_STATUS(REIMB_STATUS_ID);

ALTER TABLE ERS_REIMBURSEMENT ADD CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK
FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_Reimbursement_TYPE(REIMB_TYPE_ID);

ALTER TABLE ERS_USERS ADD CONSTRAINT ERS_USERS_ROLES_FK
FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID);

------------------------------------------------------------------------------------
------------------------FUNCTION----------------------------------------------------
------------------------------------------------------------------------------------


CREATE SEQUENCE ERS_USERS_ID_SEQ
    START WITH 600000
    INCREMENT BY 1;

CREATE SEQUENCE ERS_REIMBURSEMENT_ID_SEQ
    START WITH 100000
    INCREMENT BY 1;



CREATE OR REPLACE FUNCTION ERS_USERS__UNv1 (USERNAME VARCHAR2, PASSWORD VARCHAR2) RETURN VARCHAR2
IS
EXTRA VARCHAR2(10) := 'PEPPER';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || PASSWORD || EXTRA)));
END;
/



----TRIGGER THAT GETS NEXT SEQUENCE VALUE FOR ID AND HASHES BLANK PASSWORD

CREATE OR REPLACE TRIGGER ERS_USER_INSERT
BEFORE INSERT
ON ERS_USERS
FOR EACH ROW
BEGIN
  -- INCREASE THE SEQUENCE */
  IF :NEW.ERS_USERS_ID IS NULL THEN
    SELECT ERS_USERS_ID_SEQ.NEXTVAL INTO :NEW.ERS_USERS_ID FROM DUAL;
  END IF;
  
  -- SAVE HASH INSTEAD OF PASSWORD */
  SELECT ERS_USERS__UNv1(:NEW.ERS_USERNAME,:NEW.ERS_PASSWORD) INTO :NEW.ERS_PASSWORD FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER REIMBURSEMENT_INSERT
BEFORE INSERT
ON ERS_REIMBURSEMENT
FOR EACH ROW
BEGIN
  /* INCREASE THE SEQUENCE */
  IF :NEW.REIMB_ID IS NULL THEN
    SELECT ERS_REIMBURSEMENT_ID_SEQ.NEXTVAL INTO :NEW.REIMB_ID FROM DUAL;
  END IF;
END;
/



--
--
--ALTER TABLE ERS_Reimbursement DROP CONSTRAINT ERS_USERS_FK_AUTH;
--
--ALTER TABLE ERS_REIMBURSEMENT DROP CONSTRAINT ERS_USERS_FK_RESLVR;
--
--ALTER TABLE ERS_REIMBURSEMENT DROP CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK;
--
--ALTER TABLE ERS_REIMBURSEMENT DROP CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK;
--
--ALTER TABLE ERS_USERS DROP CONSTRAINT ERS_USERS_FK_AUTH;
--
--DROP TABLE ERS_USERS;
--DROP TABLE ERS_Reimbursement_TYPE;
--DROP TABLE ERS_Reimbursement;
--DROP TABLE ERS_Reimbursement_STATUS;
--DROP TABLE ERS_USER_ROLES;
--DROP SEQUENCE ERS_USERS_ID_SEQ;
--DROP SEQUENCE ERS_REIMBURSEMENT_ID_SEQ;


INSERT INTO ers_users VALUES (null, 'jwjibilian', 'scout', 'Joshua', 'Jibilian', 'jwjibilian@', 1);
INSERT INTO ers_users VALUES (null, 'deinstaller', 'pass', 'William', 'Jibilian', 'wjibilian@', 2);
INSERT INTO ers_users VALUES (null, 'Bjorn', 'bear', 'Jeff', 'Smith', 'jsmith@', 2);

INSERT INTO ers_reimbursement VALUES (null, 125.28, '16-nov-2018', null, 'I bougt a thing', null, 600022, null,1,2);
INSERT INTO ers_reimbursement VALUES (null, 1000.28, '10-nov-2018', null, 'I bougt a thing', null, 600022, null,1,3);
INSERT INTO ers_reimbursement VALUES (null, 99.28, '10-nov-2018', null, 'Another thing', null, 600021, null,1,2);


UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = null WHERE REIMB_ID = 100001;
commit;

SELECT REIMB_SUBMITTED, REIMB_AMMOUNT, REIMB_TYPE, REIMB_STATUS, REIMB_RECEIPT, REIMB_DESCRIPTION
FROM
ERS_REIMBURSEMENT re
RIGHT JOIN ERS_REIMBURSEMENT_STATUS status on re.REIMB_STATUS_ID = status.REIMB_STATUS_ID
RIGHT JOIN ERS_REIMBURSEMENT_TYPE reType on re.REIMB_TYPE_ID = reType.REIMB_TYPE_ID
WHERE re.REIMB_AUTHOR = 600022;



INSERT INTO ers_user_roles VALUES (1, 'Admin');
INSERT INTO ers_user_roles VALUES (2, 'Client');
--LODGING, TRAVEL, FOOD, or OTHER.
INSERT INTO ERS_REIMBURSEMENT_TYPE values (1, 'Lodging');
INSERT INTO ERS_REIMBURSEMENT_TYPE values (2, 'Travel');
INSERT INTO ERS_REIMBURSEMENT_TYPE values (3, 'Food');
INSERT INTO ERS_REIMBURSEMENT_TYPE values (4, 'Other');

INSERT INTO ERS_REIMBURSEMENT_STATUS values (1, 'Pending');
INSERT INTO ERS_REIMBURSEMENT_STATUS values (2, 'Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS values (3, 'Denied');
commit;