
-- Full name: Nguyen Hoang Linh

---------------------------------------------------------------------------
-- Group 1: CREATE PROCEDURE
-- Question 1
CREATE OR REPLACE PROCEDURE "dept_info" (
	v_department_id in DEPARTMENTS.DEPARTMENT_ID%type,
	v_result out DEPARTMENTS%rowtype
)
IS
BEGIN
	SELECT * INTO v_result FROM DEPARTMENTS WHERE DEPARTMENTS.DEPARTMENT_ID = v_department_id;
END;


-- Question 2
CREATE OR REPLACE PROCEDURE "add_job" (
	v_job_id in varchar2,
	v_job_name in varchar2
)
IS
BEGIN
	INSERT INTO JOBS(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES (v_job_id, v_job_name, '', '');
END;


-- Question 3
CREATE OR REPLACE PROCEDURE "update_comm" (
	v_employee_id in number
)
IS
BEGIN
	update EMPLOYEES set COMMISSION_PCT = COMMISSION_PCT * 1.05 where EMPLOYEES.EMPLOYEE_ID = v_employee_id;
END;


-- Question 4
CREATE OR REPLACE PROCEDURE "add_emp" (
	v_employee_id IN NUMBER,
	v_first_name IN VARCHAR2,
	v_last_name IN VARCHAR2,
	v_email IN VARCHAR2,
	v_phone_number IN VARCHAR2,
	v_hire_date IN DATE,
	v_job_id IN VARCHAR2,
	v_salary IN NUMBER,
	v_commission_pct IN NUMBER,
	v_manager_id IN NUMBER,
	v_department_id IN NUMBER,
)
IS
BEGIN
	INSERT INTO EMPLOYEES
	( EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID )
VALUES
	( v_employee_id, v_first_name, v_last_name, v_email, v_phone_number, v_hire_date, v_job_id, v_salary, v_commission_pct, v_manager_id, v_department_id );
END;


-- Question 5
CREATE OR REPLACE PROCEDURE "delete_emp" (
	v_employee_id IN NUMBER
)
IS
BEGIN
	DELETE FROM EMPLOYEES WHERE EMPLOYEES.EMPLOYEE_ID = v_employee_id;
END;


-- Question 6
CREATE OR REPLACE PROCEDURE "find_emp" (
	v_result out EMPLOYEES%rowtype
)
IS
BEGIN
	SELECT
		EMPLOYEES.*
	INTO
		v_result
	FROM
		EMPLOYEES
		JOIN jobs ON jobs.JOB_ID = EMPLOYEES.JOB_ID 
	WHERE
		EMPLOYEES.SALARY > jobs.MIN_SALARY 
		AND EMPLOYEES.SALARY < jobs.MAX_SALARY;
END;


-- Question 7
CREATE OR REPLACE PROCEDURE "update_comm"
IS
BEGIN
	update EMPLOYEES set SALARY = CASE
			WHEN ADD_MONTHS( HIRE_DATE, 24 ) < TO_DATE( TRUNC( SYSDATE ) ) THEN SALARY + 200 
			WHEN ADD_MONTHS( HIRE_DATE, 12 ) < TO_DATE( TRUNC( SYSDATE ) ) 
				AND ADD_MONTHS( HIRE_DATE, 24 ) > TO_DATE( TRUNC( SYSDATE ) ) THEN SALARY + 100
			WHEN ADD_MONTHS( HIRE_DATE, 12 ) = TO_DATE( TRUNC( SYSDATE ) ) THEN SALARY + 50
			ELSE SALARY
				END;
END;

-- Question 8
CREATE OR REPLACE PROCEDURE "LINH_HR_COPY"."job_his" (
	v_employee_id in number,
	v_result out JOB_HISTORY%rowtype
)
IS
BEGIN
	SELECT * INTO v_result FROM JOB_HISTORY WHERE JOB_HISTORY.EMPLOYEE_ID = v_employee_id;
END;



---------------------------------------------------------------------------
-- Group 2: CREATE FUNCTION
-- Question 1
CREATE OR REPLACE FUNCTION "sum_salary" (
	v_department_id number
)
RETURN number
IS
	c_number number;
	CURSOR c1 IS
	select sum(SALARY) "Sum_Salary" from EMPLOYEES  where EMPLOYEES.DEPARTMENT_ID = v_department_id;
BEGIN
	OPEN c1;
	fetch c1 into c_number;
	close c1;
	return c_number;
END;



-- Question 2
CREATE OR REPLACE FUNCTION "name_con" (
	v_country_id VARCHAR2
)
RETURN VARCHAR2
IS
	c_result varchar2(100);
	CURSOR c1 IS
	select COUNTRY_NAME from COUNTRIES where COUNTRIES.COUNTRY_ID = v_country_id;
BEGIN
	OPEN c1;
	fetch c1 into c_result;
	close c1;
	return c_result;
END;

-- Question 3
CREATE OR REPLACE FUNCTION "annual_comp" (
	v_month_sal number;
	v_commission number;
)
RETURN number
IS
	c_result number;
BEGIN
	c_result := v_month_sal*12 + (v_commission*v_month_sal*12)
	return c_result;
END;

-- Question 4
CREATE OR REPLACE FUNCTION "avg_salary" (
	v_department_id number
)
RETURN number
IS
	c_result number;
	CURSOR c1 IS
	select avg(SALARY) "Average_Salary" from EMPLOYEES  where EMPLOYEES.DEPARTMENT_ID = v_department_id;
BEGIN
	OPEN c1;
	fetch c1 into c_result;
	close c1;
	return c_result;
END;

-- Question 5
CREATE OR REPLACE FUNCTION "time_work" (
	v_employee_id number
)
RETURN number
IS
	c_result number;
	CURSOR c1 IS
	select MONTHS_BETWEEN(TRUNC( SYSDATE ), HIRE_DATE) "Months" from EMPLOYEES where EMPLOYEES.EMPLOYEE_ID = v_employee_id;
BEGIN
	OPEN c1;
	fetch c1 into c_result;
	close c1;
	return c_result;
END;

---------------------------------------------------------------------
-- Group 3: CREATE TRIGGER
-- Question 1
CREATE OR REPLACE TRIGGER TRIGGER_1
  BEFORE INSERT OR UPDATE ON EMPLOYEES
  FOR EACH ROW
BEGIN
  IF SYSDATE < :NEW.HIRE_DATE THEN
    RAISE_APPLICATION_ERROR(-20789, 'ERROR');
  END IF;
END;

-- Question 2
CREATE OR REPLACE TRIGGER TRIGGER_2
  BEFORE INSERT OR UPDATE ON JOBS
  FOR EACH ROW
BEGIN
  IF :NEW.MIN_SALARY > :NEW.MAX_SALARY THEN
    RAISE_APPLICATION_ERROR(-20789, 'ERROR');
  END IF;
END;

-- Question 3
CREATE OR REPLACE TRIGGER TRIGGER_3
  BEFORE INSERT OR UPDATE ON JOB_HISTORY
  FOR EACH ROW
BEGIN
  IF :NEW.END_DATE > :NEW.START_DATE THEN
    RAISE_APPLICATION_ERROR(-20789, 'ERROR');
  END IF;
END;

-- Question 4
CREATE OR REPLACE TRIGGER TRIGGER_4
  BEFORE UPDATE ON EMPLOYEES
  FOR EACH ROW
BEGIN
  IF :NEW.SALARY <= :OLD.SALARY AND :NEW.COMMISSION_PCT <= :OLD.COMMISSION_PCT THEN
     RAISE_APPLICATION_ERROR(-20789, 'ERROR');
  END IF;
END;

