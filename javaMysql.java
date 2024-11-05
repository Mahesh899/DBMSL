
import java.sql.*;
import java.util.*;

public class javaMysql {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlconn", "root", "root");
            Statement s = c.createStatement();
//			s.executeUpdate("CREATE DATABASE mysqlConn");
            Scanner sc = new Scanner(System.in);
//			String tbName="";

            boolean d = true;
            int ch = 0;
            while (d) {
                System.out.print("\n-----Dashboard-------\n1.Create Table\n2.Insert into Table.\n3.Delete Records.\n4.Display.\n5.Exist\n");
                System.out.println("Enter choince from Menu(1 to 5):");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
//					System.out.println("Enter Table Name:");
//					tbName=sc.next();
//					System.out.print();
//					s.executeUpdate("CREATE TABLE "+tbName+";");
                        try {
                            s.executeUpdate("CREATE TABLE employee1(id int,name varchar(30),sal float);");
                            System.out.println("Tabale Created Succesfully");
                        } catch (Exception e) {
//						System.out.println("Table already exist.......");
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        System.out.println("Enter empId:");
                        int eI = sc.nextInt();
                        System.out.println("Enter empName:");
                        String eN = sc.next();
                        System.out.println("Enter empSalary:");
                        float eS = sc.nextFloat();
                        try {
                            s.executeUpdate("INSERT INTO employee1 VALUES('" + eI + "','" + eN + "','" + eS + "')");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        System.out.println("Enter EmpId of employee you want to delete:");
                        int del = sc.nextInt();
                        try {
                            s.executeUpdate("DELETE FROM employee1 WHERE id='" + del + "'");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 4:
                        ResultSet result = s.executeQuery("SELECT * FROM employee1");
                        System.out.println("Available Records:\nEmpId\tEmp Name\tEmp Salary");
                        while (result.next()) {
                            int eId = result.getInt(1);
                            String ename = result.getString(2);
                            float eSal = result.getFloat(3);
                            System.out.println(eId + "\t" + ename + "\t\t" + eSal);
                        }
                        break;
                    case 5:
                        System.out.println("Thank Youu");
                        d = false;
                        break;
                    default:
                        System.out.println("Wrong input............");
                }
            }
            c.close();
            s.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
