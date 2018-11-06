DROP TABLE allAccounts;
CREATE TABLE allAccounts(
AccountID NUMBER NOT NULL,
UserName VARCHAR2(100) NOT NULL,
UserNameJoint VARCHAR2(100) NOT NULL,
Password VARCHAR2(100) NOT NULL,
AccountType VARCHAR2(100) NOT NULL,
Balance NUMBER NOT NULL,
Pending VARCHAR2(5) NOT NULL,
CONSTRAINT PK_allAccounts PRIMARY KEY (AccountID)
);

DROP TABLE allTransactions;
CREATE TABLE allTransactions(
TransactionID NUMBER NOT NULL,
AccountID NUMBER NOT NULL,
Amount NUMBER NOT NULL,
TransactionType VARCHAR2(100) NOT NULL,
CONSTRAINT PK_allTransactions PRIMARY KEY (TransactionID)
);

SELECT * FROM allAccounts;
SELECT * FROM allTransactions;

CREATE OR REPLACE PROCEDURE customerName(customer_Id IN NUMBER, customer_Name OUT allAccounts.UserName%TYPE)
IS
BEGIN
    SELECT UserName INTO customer_Name FROM allAccounts WHERE AccountID=customer_Id;
END;
/

--DOESN'T WORK don't run, hopefully can work on later
CREATE OR REPLACE TRIGGER transactions
BEFORE UPDATE OF Balance ON allAccounts
FOR EACH ROW
DECLARE
    TransactionID NUMBER;
    Amounts NUMBER;
    TransactionType VARCHAR2(100);
    TransactionAmount NUMBER;
BEGIN
    SELECT trans_seq.nextval INTO TransactionID FROM dual;
    SELECT Balance INTO Amounts FROM allAccounts WHERE AccountID=:new.AccountID;
    IF Amounts > :new.Balance THEN
        TransactionType := 'Withdraw';
        TransactionAmount := Amounts-:new.Balance;
    END IF;
    IF Amounts < :new.Balance THEN
        TransactionType := 'Deposit';
        TransactionAmount := Amounts+:new.Balance;
    END IF;
    IF Amounts = :new.Balance THEN
        TransactionType := 'No Change';
        TransactionAmount := :new.Balance;
    END IF;
    INSERT INTO allTransactions VALUES(TransactionID, :new.AccountID, :new.UserName, :new.UserNameJoint, :new.AccountType, TransactionAmount, TransactionType);
END;
/