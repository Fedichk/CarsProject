SET SERVEROUTPUT ON

DECLARE
    v_First_name EMPLOYEES.FIRSTNAME%TYPE;
    v_Last_name EMPLOYEES.LASTNAME%TYPE;
 
    CURSOR get_employee IS
        SELECT FIRSTNAME, LASTNAME 
        FROM EMPLOYEES;
    
BEGIN
    OPEN get_employee;
        FETCH get_employee INTO v_First_name, v_Last_name;
        
        DBMS_OUTPUT.enable;
        DBMS_OUTPUT.put_line('Employee is: '||v_First_name||' '||v_Last_name);
    CLOSE get_employee;
END;
/
    