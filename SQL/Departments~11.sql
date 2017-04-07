SET SERVEROUTPUT ON

DECLARE
    
    CURSOR get_employee IS
        SELECT * 
        FROM EMPLOYEES;
        
        gt get_employee%ROWTYPE;
BEGIN
    
    OPEN get_employee;
    
    LOOP
        
        EXIT WHEN get_employee%NOTFOUND;
        
        DBMS_OUTPUT.enable;
        FETCH get_employee INTO gt;
        DBMS_OUTPUT.put_line('Employee: '||TO_CHAR(gt.ID)||' '||gt.FIRSTNAME||' '||gt.LASTNAME);
        
    END LOOP;
    
    CLOSE get_employee;
    
END;
/