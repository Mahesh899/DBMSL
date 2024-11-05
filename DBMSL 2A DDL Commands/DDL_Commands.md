# SQL DDL Commands

Just Copy And Paste command One by One;
IF NOT Work Try to change name of table,database,view,index

## Table of Contents

- [Create User](#create-user)
- [Create Database](#create-database)
- [Use Database](#use-database)
- [Create Table](#create-table)
- [Create Index](#create-index)
- [Create View](#create-view)
- [Alter Table](#alter-table)
- [Constraints](#constraints)
- [Drop View](#drop-view)
- [Drop Table](#drop-table)
- [Drop Database](#drop-database)

### Create User

```sql
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
```

### Create DATABASE

```sql
CREATE DATABASE DBMSL;
```

### USE DATABASE

```sql
USE DBMSL;
```

### CREATE TABLE

```sql
CREATE TABLE Student (Roll_No INT,First_Name VARCHAR(20),Last_Name VARCHAR(20),Age INT,Marks INT);
```

### INSERT SOME VALUES

```sql
INSERT INTO Student VALUES(100,'ABC','CBA',19,98);
```

### Create Index

```sql
CREATE INDEX Mark_index ON Student (Marks);
```

### Create View

```sql

CREATE VIEW Mark_View AS SELECT Roll_No, First_Name, Last_Name, Marks FROM Student;
```

### Alter Table

```sql
ALTER TABLE Student MODIFY Roll_No INT UNIQUE;
```

### Constraints

#### Check constraints

```sql
ALTER TABLE Student ADD CONSTRAINT chk_roll_no CHECK (Roll_No > 0);
```

#### Unique constraint

```sql
 ALTER TABLE Student MODIFY Roll_No INT UNIQUE;
```

#### NOT NULL constraint

```sql
 ALTER TABLE Student MODIFY Marks INT NOT NULL;
```

#### Default constraint

```sql
ALTER TABLE Student MODIFY Age INT  DEFAULT 18;
```

#### Primary key constraint

```sql
 ALTER TABLE Student MODIFY Roll_No INT PRIMARY KEY;
```

### DROP VIEW

```sql
DROP VIEW Mark_View;
```

### Drop Table

```sql
DROP TABLE Student;
```

### Drop Database

```sql
DROP DATABASE DBMSL;
```
