# MongoDB Queries for mapReduced Function

## Create an Database

```javascript
use DBMSLP;
```

## Create a Collection

```javascript
db.createCollection("bank");
```

## Insert Queries

Use the following `insertOne()` queries to insert individual documents into the `bank` collection:

```javascript
db.bank.insertOne({ bankName: "SBI", city: "Pune", balance: 500000 });
```

```javascript
db.bank.insertOne({ bankName: "HDFC", city: "Mumbai", balance: 800000 });
```

```javascript
db.bank.insertOne({ bankName: "ICICI", city: "Nagpur", balance: 700000 });
```

```javascript
db.bank.insertOne({ bankName: "BOB", city: "Mumbai", balance: 300000 });
```

```javascript
db.bank.insertOne({ bankName: "SBI", city: "Nagpur", balance: 200000 });
```

```javascript
db.bank.insertOne({ bankName: "HDFC", city: "Pune", balance: 100000 });
```

```javascript
db.bank.insertOne({ bankName: "ICICI", city: "Mumbai", balance: 400000 });
```

```javascript
db.bank.insertOne({ bankName: "BOB", city: "Nagpur", balance: 350000 });
```

## map Function

```javascript
var mapFunction = function () {
  emit(this.bankName, this.balance);
};
```

## Reduce Function

```javascript
var reduceFunction = function (bankName, balances) {
  return Array.sum(balances);
};
```

## mapReduced Function

Executing mapReduced Function

```javascript
db.bank.mapReduce(mapFunction, reduceFunction, { out: "total_balance" });
```
```javascript
db.total_balance.find();
```


