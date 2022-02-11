package com.company;
import java.sql.*;
import java.util.Scanner;

import static java.lang.Integer.*;


class Customer{
    int balance;
    String name;
    int account_id;
    //Scanner scanner=new Scanner(System.in);



}

class Employee{

}
public class Bank {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
    Scanner input=new Scanner(System.in);
        System.out.println("Welcome to Revature Bank. Are you a 1) New Customer 2)Existing Customer or 3) Employee?");
        int user=input.nextInt();
            switch(user){
                case 1:
                   new_Customer();
                    break;
                case 2:
                    System.out.println("Please give id to find account details");
                   ex_Customer();
                   break;
                case 3:
                    System.out.println("You are an employee");


                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + user);
            }


    }

    private static void ex_Customer() throws ClassNotFoundException, SQLException {
        Scanner scanner=new Scanner(System.in);
       // System.out.println("Please give id to find account details");
        String url = "jdbc:mysql://localhost:3306/project1";
        String username = "root";
        String password = "Brotherhood#22";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();


        String query="Select balance from customer where id=(?))";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        //set the values of the query
        String custId = scanner.nextLine();


        preparedStatement.setInt(1, parseInt(custId));


        int rowAffected=preparedStatement.executeUpdate();
        System.out.println("("+rowAffected+") row affected");
    }

    private static void new_Customer() throws ClassNotFoundException, SQLException {
            System.out.println("Please name and balance you wish to add.");
            Scanner scanner=new Scanner(System.in);
            scanner.nextLine();
            String url = "jdbc:mysql://localhost:3306/project1";
            String username = "root";
            String password = "Brotherhood#22";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            String query="insert into customer(id, name,balance) values (?,?,?))";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            //set the values of the query
            String custId = scanner.nextLine();
            String custName = scanner.nextLine();
            String custBala = scanner.nextLine();

            preparedStatement.setInt(1, parseInt(custId));
            preparedStatement.setString(2, custName);
            preparedStatement.setInt(3, (parseInt(custBala)));

            int rowAffected=preparedStatement.executeUpdate();
            System.out.println("("+rowAffected+") row affected");

        }


}
