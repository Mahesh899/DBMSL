```sql
CREATE TABLE stud_marks(name VARCHAR2(25),total_marks NUMBER)
```

```sql
CREATE TABLE result(roll_number NUMBER , name VARCHAR2(25), class VARCHAR2(30))
```

```sql
CREATE OR REPLACE PROCEDURE proc_grades ( roll_no IN NUMBER, name IN VARCHAR2 ,marks IN NUMBER)
AS
BEGIN
    IF (marks<=1500 and marks>=990) THEN
    DBMS_OUTPUT.PUT_LINE (roll_no||' - '||name||' : DISTINCTION');
	    INSERT INTO result VALUES (roll_no,name,'DISTINCTION');
	    ELSIF (marks<=989 and marks>=900) THEN
    DBMS_OUTPUT.PUT_LINE (roll_no||' - '||name||' : FIRST CLASS');
    INSERT INTO result VALUES (roll_no,name,'FIRST CLASS');
    ELSIF (marks<=899 and marks>825) THEN
    DBMS_OUTPUT.PUT_LINE(roll_no||' - '||name||' : HIGHER SECOND CLASS');
    INSERT INTO result VALUES (roll_no,name,'HIGHER SECOND CLASS');
    ELSE
    DBMS_OUTPUT.PUT_LINE (roll_no||' - '||name||' : FAIL');
    INSERT INTO result VALUES (roll_no,name,'FAIL');
    END IF;
    INSERT INTO stud_marks VALUES (name,marks);
END proc_grades ;
/
```

```sql
BEGIN
proc_grades (54,'SUDARSHAN',1000);
proc_grades (46,'ARYAN ',950);
proc_grades (58,'ARJUN ',1050);
proc_grades (14,'Aanika',995);
proc_grades (19,'Suhani',889);
proc_grades (16,'Kartiki',965);
proc_grades (10,'Shalima',900);
proc_grades (20,'Kusum',777);
END;
/
```

```sql
SELECT * FROM result;
```