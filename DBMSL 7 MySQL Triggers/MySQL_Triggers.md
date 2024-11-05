# SQL Triggers

## Open PL/SQL in an directory using following command:

```sql
sqlplus
```

## Set the server output on

```sql
SET SERVEROUTPUT ON;
```

## Table Creation:

```sql
CREATE TABLE Library (  lid INT,  booktype VARCHAR(20),  bookcount INT,  issuebookcount INT );
```

```sql
CREATE TABLE LibraryAudit (  lid INT,  booktype VARCHAR(20),  bookcount INT,  issuebookcount INT );
```

## INSERTING RECORDS

```sql
INSERT INTO Library VALUES (1, 'historic', 50, 10);
```

```sql
INSERT INTO Library VALUES (2, 'story', 56, 20);
```

```sql
INSERT INTO Library VALUES (3, 'novel', 74, 9);
```

## Create a file with .sql extension:

FileName Ex:

```sql
program.sql
```

## Write the following code in the file:

```sql
CREATE OR REPLACE TRIGGER t1
BEFORE UPDATE OR DELETE ON LIBRARY
FOR EACH ROW
DECLARE
    lid INT;
    btype VARCHAR(20);
    bcount INT;
    icount INT;
BEGIN
    lid := :old.lid;
    btype := :old.booktype;
    bcount := :old.bookcount;
    icount := :old.issuebookcount;
    INSERT INTO LibraryAudit VALUES (lid, btype, bcount, icount);
END;
/
```

## Run the file using following command

```sql
@program.sql
```

## Perform the update operation

```sql
UPDATE Library SET lid = 10 WHERE lid = 1;
```

```sql
UPDATE Library SET lid = 10 WHERE lid = 2;
```

```sql
UPDATE Library SET lid = 1000 WHERE lid = 3;
```

## Check Tables

```sql
SELECT * FROM LibraryAudit;
```

```sql
SELECT * FROM Library;
```
