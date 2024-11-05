# SQL DML Operations

## Create Table

```sql
CREATE TABLE stud( sID int PRIMARY KEY, sName varchar(15) NOT NULL, sAddress varchar(30) DEFAULT 'Varale' );
```

### Insert Rows

```sql
INSERT INTO stud(sID, sName, sAddress) VALUES (1, 'Amit', 'Pune');
```

```sql
INSERT INTO stud(sID, sName, sAddress) VALUES (2, 'Priya', 'PCMC');
```

```sql
INSERT INTO stud(sID, sName) VALUES (3, 'Rahul');
```

```sql
INSERT INTO stud(sID, sName) VALUES (4, 'Rajesh');
```

```sql
INSERT INTO stud(sID, sName) VALUES (5, 'Ram');
```

## Select All Rows

```sql
SELECT * FROM stud;
```

### Select with Condition

```sql
SELECT * FROM stud WHERE sAddress = 'Varale';
```

### Update Row

```sql
UPDATE stud SET sAddress = 'Mumbai' WHERE sID = 3;
```

### Delete Row

```sql
DELETE FROM stud WHERE sID = 5;
```

### Count Rows

```sql
SELECT COUNT( *) AS cnt FROM stud;
```

```sql

SELECT * FROM stud ORDER BY sName;
```

```sql
SELECT  * FROM stud WHERE sName LIKE 'R%';
```

```sql
SELECT  * FROM stud ORDER BY sName DESC;
```

### Update Multiple Rows

```sql
UPDATE stud SET sAddress = 'Talegaon' WHERE sAddress = 'Varale';
```

### Insert Multiple Rows

```sql
INSERT INTO stud (sID, sName, sAddress) VALUES
(6, 'Sita', 'Nashik'),
(7, 'Gita', 'Aurangabad');
```

### Update Multiple Rows

```sql
UPDATE stud SET sAddress = 'Delhi' WHERE sAddress IN ('Mumbai', 'Talegaon');
```

### Using Aggregate Functions

```sql
SELECT sAddress, COUNT(*) AS student_count FROM stud GROUP BY sAddress;
```

```

```
