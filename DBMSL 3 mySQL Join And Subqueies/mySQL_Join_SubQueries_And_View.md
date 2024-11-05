# MySQL Join operation and sub queries

## Create Database

Drop or change DB Name if already exist

```sql
CREATE DATABASE DBMSLP;
```

## Use Database

```sql
USE DBMSLP;
```

## Create Table

```sql
CREATE TABLE products( pID INT PRIMARY KEY, pName VARCHAR(100), Category VARCHAR(50), Price DECIMAL(10, 2), Quantity INT, SupplierID INT );
```

## Insert Data into Table

```sql
INSERT INTO products VALUES(101, 'hplaptop', 'electronics', 50000.0, 40, 2);
```

```sql
INSERT INTO products VALUES(102, 'asusplaptop', 'electronics', 60000.0, 50, 32);
```

```sql
INSERT INTO products VALUES(112, 'chair', 'furniture', 5000.0, 20, 24);
```

```sql
INSERT INTO products VALUES(12, "tv", 'electronics', 19000.0, 9, 3);
```

```sql
INSERT INTO products VALUES(151, 'apple laptop', 'electronics', 5000.0, 40, 2);
```

## Select Data FROM Table

```sql
SELECT * FROM products;
```

## Update Prices by Category

```sql
UPDATE products SET Price = Price + Price * 0.1 WHERE Category = 'electronics';
```

## Update Quantity

```sql
UPDATE products SET Quantity = 50 WHERE Quantity < 10 AND Category = 'electronics';
```

## Discount Prices for Specific Product Names

```sql
UPDATE products SET Price = Price - Price * 0.2 WHERE pName LIKE '%laptop%';
```

## Update Supplier ID for Furniture Category

```sql
UPDATE products SET SupplierID = 5 WHERE Category = 'furniture';
```

## Adjust Prices within a Specific Range

```sql
UPDATE products SET Price = Price - 50 WHERE Price BETWEEN 4000 AND 20000;
```

## Create Sale Table

```sql
CREATE TABLE sale(pID int, saleQuantity int);
```

## Insert Data into Sale Table

```sql
INSERT INTO sale VALUES(101, 5);
```

```sql
INSERT INTO sale VALUES(102, 10);
```

```sql
INSERT INTO sale VALUES(112, 5);
```

```sql
INSERT INTO sale VALUES(12, 10);
```

```sql
INSERT INTO sale VALUES(22, 100);
```

## Left Join BETWEEN Products AND Sale Tables

```sql
SELECT products.pID,products.productName, sale.qty FROM products LEFT JOIN sale on products.pID = sale.pID;
```

## Right Join BETWEEN Products AND Sale Tables

```sql
SELECT products.pID,products.productName, sale.qty FROM products RIGHT JOIN sale on products.pID = sale.pID;
```

## Inner Join BETWEEN Products AND Sale Tables

```sql
SELECT products.pID,products.productName, sale.qty FROM products INNER JOIN sale on products.pID = sale.pID;
```
