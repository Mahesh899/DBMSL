# MongoDB Queries for Aggregation and Indexing

## Create Database:

If Database already exist then drop or change name of Database

```javascript
use DBMSLP;
```

## Create Collection

```javascript
db.createCollection("Orders");
```

## Insert Records

```javascript
db.Orders.insertOne({oID:1,cName:'AAA',Product:'Pen',items:6 Status:'pending'});
```

```javascript
db.Orders.insertOne({
  oID: 2,
  cName: "AAA",
  Product: "Pencil",
  items: 5,
  Status: "Delivered",
});
```

```javascript
db.Orders.insertOne({
  oID: 3,
  cName: "ABA",
  Product: "Books",
  items: 11,
  Status: "pending",
});
```

```javascript
db.Orders.insertOne({
  oID: 4,
  cName: "ABA",
  Product: "Pen",
  items: 21,
  Status: "Delivered",
});
```

## Aggregate Function

### Aggregate Sum Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Status", quantity: { $sum: "$items" } } },
]);
```

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", quantity: { $sum: "$items" } } },
]);
```

### Aggregate Max Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", max_orders_quantity: { $max: "$items" } } },
]);
```

### Aggregate Min Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", min_orders_quantity: { $min: "$items" } } },
]);
```

### Aggregate AVG Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", average_orders_quantity: { $avg: "$items" } } },
]);
```

### Aggregate First Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", First_order_quantity: { $first: "$items" } } },
]);
```

### Aggregate Last Function

```javascript
db.Orders.aggregate([
  { $group: { _id: "$Product", Last_order_quantity: { $last: "$items" } } },
]);
```

## Create Index

### Simple Index

```javascript
db.Orders.createIndex({ cName: 1 });
```

### Compound Index

```javascript
db.Orders.createIndex({ cName: 1, Product: -1 });
```
