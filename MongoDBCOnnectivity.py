import pymongo
client = pymongo.MongoClient("mongodb://localhost:27017/")
db = client["DBMSL"]
collection = db["Student"]
while True:
    print("\nMenu:")
    print("1. Create")
    print("2. Display")
    print("3. Update")
    print("4. Delete")
    print("5. Exit")

    choice = input("Enter your choice (1-5): ")
    if choice == '1':
        r = int(input("Enter roll number: "))
        n = input("Enter name: ")
        c=input("Enter Class: ")
        data = {'RollNo': r, 'Sname': n,'Sclass':c}
        collection.insert_one(data)
        print("Data Inserted.")
    elif choice == '2':
        records = collection.find()
        print("Data in the collection:")
        for data in records:
            print(data)
    elif choice == '3':
        r = int(input("Enter Roll Number of the Student to update: "))
        n_n = input("Enter new name: ")
        result = collection.update_one({'RollNo': r}, {'$set': {'Sname': n_n}})
        print("Records Updated")
    elif choice == '4':
        r = int(input("Enter roll number of the student to delete: "))
        result = collection.delete_one({'RollNo': r})
        print("Student Data deleted.")
    elif choice == '5':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please try again.")