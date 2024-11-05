# Area of circle Pl/SQL

## Open PL/SQL in an directory using following command:

```sql
sqlplus
```

## Set the server output on

```sql
SET SERVEROUTPUT ON;
```

## Create table to store radius and area :

```sql
CREATE TABLE areas ( radius NUMBER, area NUMBER, circumference NUMBER );
```

## Create a file with .sql extension:

FileName Ex:

```sql
program.sql
```

## Write the following code in the file:

```sql
DECLARE
    r NUMBER;
    a NUMBER;
    c NUMBER;
BEGIN
    FOR r IN 5..9 LOOP
        a := 3.14159 * r * r;
        c := 2 * 3.14159 * r;
        INSERT INTO areas VALUES (r, a, c);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Area and circumference calculated and inserted successfully.');
END;
/
```

## Run the file using following command

```sql
@program.sql
```
