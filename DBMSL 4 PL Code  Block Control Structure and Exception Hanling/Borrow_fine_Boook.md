# Borrow Fine in Pl/SQL

## Open PL/SQL in an directory using following command:

```sql
sqlplus
```

## Set the server output on

```sql
SET SERVEROUTPUT ON;
```

### Create the Borrow and Fine Table

```sql
CREATE TABLE Borrow ( rollno INT UNIQUE, name VARCHAR(20), bookname VARCHAR(20), issuedate DATE, status VARCHAR(5) );
```

```sql
CREATE TABLE Fine ( rollno INT, rdate DATE, amt INT );
```

### Insert Data in Borrow Table

```sql
INSERT INTO Borrow VALUES (101, 'Ram', 'DBMS', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'i');
```

```sql
INSERT INTO Borrow VALUES (102, 'Hari', 'OOP', TO_DATE('2024-09-01', 'YYYY-MM-DD'), 'i');
```

```sql
INSERT INTO Borrow VALUES (103, 'Om', 'DM', TO_DATE('2024-11-01', 'YYYY-MM-DD'), 'i');
```

```sql
INSERT INTO Borrow VALUES (104, 'Adi', 'DELD', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'i');
```

```sql
INSERT INTO Borrow VALUES (105, 'Mahesh', 'CNS', TO_DATE('2024-09-05', 'YYYY-MM-DD'), 'i');
```

```sql
INSERT INTO Borrow VALUES (106, 'Sahil', 'CG', TO_DATE('2024-10-06', 'YYYY-MM-DD'), 'i');
```

### Now Commit to save the changes

```sql
COMMIT;
```

### Now create an file and save it with .sql extension and paste following code

FileName Ex:

```
program.sql
```

CODE:

```sql
DECLARE

    r INT;
    bn VARCHAR(20);
    idate DATE;
    rdate DATE;
    d INT;
    amt INT := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Enter Roll Number: ');
    r := &r;
    DBMS_OUTPUT.PUT_LINE('Enter Book Name: ');
    bn := '&bn';
    SELECT issuedate INTO idate
    FROM Borrow
    WHERE rollno = r AND bookname = bn AND status = 'i';
    rdate := SYSDATE;
    d := rdate - idate;
    IF d < 15 THEN
        DBMS_OUTPUT.PUT_LINE('No fine; book return date is not overdue');
    ELSIF d >= 15 AND d < 30 THEN
        amt := d * 5;
        DBMS_OUTPUT.PUT_LINE('Fine applied: ' || amt || ' (Rs. 5 per day)');
    ELSE
        amt := d * 50;
        DBMS_OUTPUT.PUT_LINE('Fine applied: ' || amt || ' (Rs. 50 per day)');
    END IF;
    UPDATE Borrow
    SET status = 'r'
    WHERE rollno = r AND bookname = bn AND status = 'i';
    IF amt > 0 THEN
        INSERT INTO Finee (rollno, rdate, amt)
        VALUES (r, rdate, amt);
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No record found.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Multiple records found.');
END;
/
```

### Now run the file in sqlplus using the following command

```sql
@program.sql
```
