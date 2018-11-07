CREATE USER revBank
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to revBank;
GRANT resource to revBank;
GRANT create session TO revBank;
GRANT create table TO revBank;
GRANT create view TO revBank;



conn revBank/p4ssw0rd

CREATE TABLE Customers
(
    CustId NUMBER NOT NULL,
    Name VARCHAR2(100) NOT NULL,
    Username VARCHAR2(100) NOT NULL,
    Pwd VARCHAR2(100) NOT NULL,
    Accounts VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (CustId)
);

CREATE TABLE Employees
(
    EmplId NUMBER NOT NULL,
    Name VARCHAR2(100) NOT NULL,
    Username VARCHAR2(100) NOT NULL,
    Pwd VARCHAR2(100) NOT NULL,
    Admin VARCHAR(1),
    CONSTRAINT pk_employee PRIMARY KEY (EmplId)
);

CREATE TABLE Accounts
(
    AccId NUMBER NOT NULL,
    Balance NUMBER NOT NULL,
    Approved VARCHAR2(1) NOT NULL,
    Cancelled VARCHAR2(1) NOT NULL,
    Owners VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (AccId)
);

CREATE TABLE Transactions
(
    TransId NUMBER NOT NULL,
    Oper NUMBER NOT NULL,
    TrType VARCHAR2(10) NOT NULL,
    Amount NUMBER NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (TransId)
);

CREATE TABLE RelateTransAcc
(
    id NUMBER NOT NULL,
    Trans NUMBER NOT NULL,
    Acc NUMBER NOT NULL,
    CONSTRAINT pk_rta PRIMARY KEY (id),
    CONSTRAINT fk_trans
        FOREIGN KEY (Trans)
        REFERENCES Transactions(TransId),
    CONSTRAINT fk_acc
        FOREIGN KEY (Acc)
        REFERENCES Accounts(AccId)
);

CREATE TABLE RelateAccCust
(
    id NUMBER NOT NULL,
    Acc NUMBER NOT NULL,
    Cust NUMBER NOT NULL,
    CONSTRAINT pk_rac PRIMARY KEY (id),
    CONSTRAINT fk_acc2
        FOREIGN KEY (Acc)
        REFERENCES Accounts(AccId),
    CONSTRAINT fk_cust
        FOREIGN KEY (Cust)
        REFERENCES Customers(CustId)
);

ALTER TABLE Customers DROP (Accounts);
ALTER TABLE Accounts DROP (Owners);

CREATE OR REPLACE TRIGGER trans_insert_t
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :new.TRANSID IS NULL then
        SELECT trans_seq.nextval INTO :new.TRANSID FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER acc_insert_t
BEFORE INSERT ON Accounts
FOR EACH ROW
BEGIN
    IF :new.ACCID IS NULL then
        SELECT acc_seq.nextval INTO :new.ACCID FROM dual;
    END IF;
END;
/
CREATE OR REPLACE TRIGGER cust_insert_t
BEFORE INSERT ON Customers
FOR EACH ROW
BEGIN
    IF :new.CUSTID IS NULL then
        SELECT cust_seq.nextval INTO :new.CUSTID FROM dual;
    END IF;
END;
/
CREATE OR REPLACE TRIGGER empl_insert_t
BEFORE INSERT ON Employees
FOR EACH ROW
BEGIN
    IF :new.EMPLID IS NULL then
        SELECT empl_seq.nextval INTO :new.EMPLID FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER rac_insert_t
BEFORE INSERT ON RelateAccCust
FOR EACH ROW
BEGIN
    IF :new.ID IS NULL then
        SELECT rac_seq.nextval INTO :new.ID FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER rta_insert_t
BEFORE INSERT ON RelateTransAcc
FOR EACH ROW
BEGIN
    IF :new.ID IS NULL then
        SELECT rta_seq.nextval INTO :new.ID FROM dual;
    END IF;
END;
/

CREATE SEQUENCE trans_seq
    START WITH 10000
    INCREMENT BY 1;

CREATE SEQUENCE acc_seq
    START WITH 1000
    INCREMENT BY 1;

CREATE SEQUENCE cust_seq
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE empl_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE rac_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE rta_seq
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE withdraw (id IN NUMBER, amnt IN NUMBER)
IS
    acc_am NUMBER;
    --CURSOR c1 IS SELECT AMOUNT FROM Accounts WHERE ACCID = id;
    new_am NUMBER;
BEGIN
    --open c1;
    --    FETCH c1 INTO acc_am;
    --close c1;
    SELECT BALANCE INTO acc_am FROM Accounts WHERE ACCID = id;
    --DBMS_OUTPUT.PUT_LINE(acc_am);
    IF ABS(amnt) < acc_am THEN
        new_am := acc_am - ABS(amnt);
        UPDATE Accounts SET BALANCE = new_am WHERE ACCID = id;
    END IF;
END;
/    

CREATE OR REPLACE FUNCTION insert_trans (oper IN NUMBER, amount IN NUMBER, ttype IN VARCHAR2)
RETURN NUMBER
IS
last_id NUMBER;
BEGIN
    INSERT INTO Transactions (OPER, TRTYPE, AMOUNT) VALUES (oper,ttype,amount);
    SELECT TRANSID INTO last_id FROM Transactions WHERE TRANSID IN
    (
        SELECT MAX(TRANSID) FROM Transactions
    );
    commit;
    RETURN last_id;
END;
/  

BEGIN
    withdraw(1001, 192.4);
END;
/

drop function insert_trans;
Select * from transactions;
DROP PROCEDURE withdraw;