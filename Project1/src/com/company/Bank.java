package com.company;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.*;


class User{
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
           // System.out.println("Please give insert your full name.");
           // Scanner scanner=new Scanner(System.in);

            String url = "jdbc:mysql://localhost:3306/project1";
            String username = "root";
            String password = "Brotherhood#22";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
        System.out.println("Welcome new customer! Please follow instructions to create your account.\n");
        Scanner scanner=new Scanner(System.in);



            String query="insert into customer(cust_id, name,balance) values (?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            //set the values of the query
        System.out.println("Please make your id number.");
            String custId = scanner.nextLine();
        System.out.println("Please give insert your full name.");
            String custName = scanner.nextLine();
        System.out.println("Please give insert your starting amount to deposit.");
            String custBala = scanner.nextLine();

       // System.out.println("Please give id number.");
            preparedStatement.setInt(1, parseInt(custId));
      //  System.out.println("Please give insert your full name.");
            preparedStatement.setString(2, custName);
       // System.out.println("Please give insert your amount to deposit.");
            preparedStatement.setInt(3, (parseInt(custBala)));

            int rowAffected=preparedStatement.executeUpdate();
           System.out.println("("+rowAffected+") row affected");

        System.out.println("Would like to make a 1)Deposit 2)Withdraw 3)Transfer or 4)Quit");
        Scanner scan=new Scanner(System.in);
        int user= scan.nextInt();
        switch(user){
            case 1:
                Deposit();
                break;
            case 2:
               // Withdraw();
                break;
            case 3:
                //Transfer();
            case 4:
                System.exit(0);
                break;



        }



        }

    private static void Deposit() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/project1";
        String username = "root";
        String password = "Brotherhood#22";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String query = "Update customer set balance= balance + (?) where cust_id=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        System.out.println("Please enter amount you wished to deposit.(Do not exceed over 10000)");

        Scanner scanner = new Scanner(System.in);
       // int amt = scanner.nextInt();
        Integer custBala = scanner.nextInt();
        int amount= custBala;
        preparedStatement.setInt(1, custBala);
        if (amount > 0 ) {
            System.out.println("Please give your id number.");
            Integer custId = scanner.nextInt();
            preparedStatement.setInt(2, custId);
            int rowAffected=preparedStatement.executeUpdate();
            System.out.println("("+rowAffected+") row affected");
        } else {
            System.out.println("Invalid entry");
            System.exit(0);


        }
    }

}
