# Basic MongoDB Queries

## Create or Use Database

```javascript
use DBMSLP;
```

## Creating Collections

```javascript
db.createCollection("students");
```

## Inserting Records

###Inserting Single Record

```javascript
db.students.insertOne({ rollno: 201, sName: "Amit", dept: "CS", city: "Pune" });
```

```javascript
db.students.insertOne({
  rollno: 202,
  sName: "Sneha",
  dept: "IT",
  city: "Mumbai",
});
```

```javascript
db.students.insertOne({
  rollno: 203,
  sName: "Raj",
  dept: "Mechanical",
  city: "Nagpur",
});
```

### Inserting Multiple Records

```javascript
db.students.insertMany([
  { rollno: 204, sName: "Pooja", dept: "Electrical", city: "Nashik" },
  { rollno: 205, sName: "Vikram", dept: "Civil", city: "Pune" },
  { rollno: 206, sName: "Oma", dept: "CS", city: "Pune" },
]);
```

## Showing Records

```javascript
db.students.find();
```

```javascript
db.students.find({ rollno: 205 });
```

## Comparison Operators:

```javascript
db.students.find({ rollno: { $gt: 203 } });
```

```javascript
db.students.find({ rollno: { $lt: 203 } });
```

```javascript
db.students.find({ rollno: { $gte: 203 } });
```

```javascript
db.students.find({ rollno: { $lte: 203 } });
```

```javascript
db.students.find({ rollno: { $ne: 203 } });
```

```javascript
db.students.find({ rollno: { $in: [203, 204] } });
```

```javascript
db.students.find({ rollno: { $nin: [203, 204] } });
```

## Logical Operators

```javascript
db.students.find({ $and: [{ rollno: 205 }, { dept: "Civil" }] });
```

```javascript
db.students.find({ $or: [{ rollno: 205 }, { dept: "Civil" }] });
```

## Sort:

### Ascending Order

```javascript
db.students.find().sort({ sName: 1 });
```

### Descending Order

```javascript
db.students.find().sort({ rollno: -1 });
```

## Limit the records

```javascript
db.students.find().limit(2);
```

## Skipping Records

```javascript
db.students.find().skip(2);
```

## Updating Records

### Update One

```javascript
db.students.updateOne({ dept: "IT" }, { $set: { dept: "CS" } });
```

### Update Many

```javascript
db.students.updateMany({ city: "Pune" }, { $set: { city: "ABB" } });
```

```javascript
db.students.updateMany(
  { city: "Pune" },
  { $set: { city: { city: "Pune", pinCode: 410507 } } }
);
```

## Delete

### Delete One

```javascript
db.students.deleteOne({ rollno: 205 });
```

### Delete Many

```javascript
db.students.deleteMany({ city: "Pune" });
```
