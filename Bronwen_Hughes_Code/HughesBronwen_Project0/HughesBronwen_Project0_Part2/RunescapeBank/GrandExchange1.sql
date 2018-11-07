    DROP TABLE accounts;
    DROP TABLE customers;
    DROP TABLE registrations;
    DROP TABLE employees;
    
    DROP SEQUENCE employee_seq;
    DROP SEQUENCE customer_seq;
    DROP SEQUENCE registration_seq;
    DROP SEQUENCE account_seq;
    
CREATE SEQUENCE employee_seq
START WITH 1
INCREMENT BY 1;
    
CREATE SEQUENCE customer_seq
START WITH 1
INCREMENT BY 1;


CREATE SEQUENCE registration_seq
START WITH 1
INCREMENT BY 1;


CREATE SEQUENCE account_seq
START WITH 1
INCREMENT BY 1;

    
CREATE OR REPLACE PROCEDURE insert_employee_null_id(e_username IN VARCHAR2, e_password IN VARCHAR2, e_firstname IN VARCHAR2, e_lastname IN VARCHAR2, e_admin IN NUMBER)
IS  
BEGIN
    INSERT INTO employees VALUES(employee_seq.NEXTVAL, e_username, e_password, e_firstname, e_lastname, e_admin);
    COMMIT;
END;    
/

CREATE OR REPLACE TRIGGER employee_insert_trig
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
        IF :new.employeeid IS NULL THEN
                SELECT employee_seq.nextval INTO :new.employeeid FROM dual;
        END IF;
END;
/

    
    
CREATE OR REPLACE PROCEDURE insert_customer_null_id(c_username IN VARCHAR2, c_password IN VARCHAR2, c_firstname IN VARCHAR2, c_lastname IN VARCHAR2, c_jointpartner IN NUMBER)
IS
BEGIN
    INSERT INTO customers VALUES(customer_seq.NEXTVAL, c_username, c_password, c_firstname, c_lastname, c_jointpartner);
    COMMIT;
END;    
/



CREATE OR REPLACE TRIGGER customer_insert_trig
BEFORE INSERT ON customers
FOR EACH ROW
BEGIN
        IF :new.customerid IS NULL THEN
                SELECT customer_seq.nextval INTO :new.customerid FROM dual;
        END IF;
END;
/


    
    
CREATE OR REPLACE PROCEDURE insert_registration_null_id(r_username IN VARCHAR2, r_password IN VARCHAR2, r_firstname IN VARCHAR2, r_lastname IN VARCHAR2, r_jointpartner IN NUMBER)
IS
BEGIN
    INSERT INTO registrations VALUES(registration_seq.NEXTVAL, r_username, r_password, r_firstname, r_lastname, r_jointpartner);
    COMMIT;
END;    
/

CREATE OR REPLACE TRIGGER registration_insert_trig
BEFORE INSERT ON registrations
FOR EACH ROW
BEGIN
        IF :new.registrationid IS NULL THEN
                SELECT registration_seq.nextval INTO :new.registrationid FROM dual;
        END IF;
END;
/

    
    
CREATE OR REPLACE PROCEDURE insert_account_null_id(a_balance IN DECIMAL,  a_mainuserid IN NUMBER, a_jointuserid IN NUMBER)
IS
BEGIN
    INSERT INTO accounts VALUES(account_seq.NEXTVAL, a_balance, a_mainuserid, a_jointuserid);
    COMMIT;
END;    
/

CREATE OR REPLACE TRIGGER account_insert_trig
BEFORE INSERT ON accounts
FOR EACH ROW
BEGIN
        IF :new.accountid IS NULL THEN
                SELECT account_seq.nextval INTO :new.accountid FROM dual;
        END IF;
END;
/

DROP SEQUENCE account_seq;
DROP SEQUENCE customer_seq;
DROP SEQUENCE employee_seq;
DROP SEQUENCE registration_seq;