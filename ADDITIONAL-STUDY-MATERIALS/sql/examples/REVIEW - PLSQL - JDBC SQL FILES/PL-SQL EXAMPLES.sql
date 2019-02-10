--ALWAYS TURN THIS ON TO BE ABLE TO SEE SYSOUT
SET SERVEROUTPUT ON;

--CURSOR AS A PASS BY REFERENCE EXAMPLE
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(JUSTIN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN JUSTIN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--TESTING EXAMPLE 1
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO FIRSTNAME, LASTNAME;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME);
  END LOOP;
END;
/

--TRANSACTIONAL PROCEDURE
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVID NUMBER)
AS
BEGIN
  --DELETING ALL INVOICE LINES
  DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
  
  --DELETING ACTUAL INVOICE
  DELETE FROM INVOICE WHERE INVOICEID = INVID;
  
  COMMIT;
END;
/

--TESTING EXAMPLE 2
EXEC DELETE_INVOICE(137);

--REGULAR RETURN TYPE FUNCTION
CREATE OR REPLACE FUNCTION INVOICELINE_AVG RETURN NUMBER
IS
  AVERAGE NUMBER;
BEGIN
  --FILL VARIABLE WITH QUERY (QUERY INTO VARIABLE)
  SELECT SUM(UNITPRICE)/COUNT(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
  RETURN AVERAGE;
END;
/

--TESTING EXAMPLE 3
SELECT INVOICELINE_AVG FROM DUAL;

--CURSOR RETURN TYPE FUNCTION
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/

--TESTING EXAMPLE 4
SELECT AFTER_1968 FROM DUAL;