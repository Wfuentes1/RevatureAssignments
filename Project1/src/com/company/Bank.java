package com.company;
import java.sql.*;
import java.util.Scanner;



public class Bank {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to Revature Bank. Are you a 1) New Customer 2)Existing Customer or 3) Employee?");//using switch statement to chose options
        int user = input.nextInt();
        switch (user) {
            case 1:
                System.out.println("Welcome new customer! Please follow instructions to create your account.\n");
                customerDao.addCustomer(customer);
                ex_Customer();
                break;
            case 2:
                System.out.println("Please Login\n");
                customerDao.Login(customer);

                ex_Customer();
                break;
            case 3:
                Employee();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);
        }


    }

    public static void Employee() throws SQLException {//employee will call login then let you decide your course of action
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Login\n");
        EmployeeDao empDao = EmpDaoFactory.getEmployeeDao();
         Employee employee = new Employee();
         empDao.Login(employee);

        System.out.println("What will you like to do 1) Check accounts 2) Status account 3)Check transactions ");
        int user = scanner.nextInt();

        switch (user) {
            case 1:
                empDao.emp_Check(employee);
                break;
            case 2:
                Status();
                break;
            case 3:
                empDao.Log(employee);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);

        }
    }


    public static void Status() throws SQLException {
        System.out.println("Are you going to 1)Approve or 2)Reject account ");
        EmployeeDao employeeDao = EmpDaoFactory.getEmployeeDao();
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);
        //employeeDao.Login(employee);
        int user = scanner.nextInt();
        if (user == 1) {
            employeeDao.app_Status(employee);
        } else {
            employeeDao.rej_Status(employee);
        }
    }

    public static void cust_Status()throws SQLException{
            EmployeeDao employeeDao = EmpDaoFactory.getEmployeeDao();
            Employee employee = new Employee();
            Scanner scanner = new Scanner(System.in);
            employeeDao.Login(employee);
            System.out.println("Are you going to 1) Approve or 2) Reject account status ");

            int user = scanner.nextInt();
            if (user == 1) {
                employeeDao.app_Status(employee);
            } else {
                employeeDao.rej_Status(employee);
            }
        }

public static void coo_Employee() throws SQLException{
    Scanner scanner = new Scanner(System.in);
    EmployeeDao empDao = EmpDaoFactory.getEmployeeDao();
    Employee employee = new Employee();


    System.out.println("What will you like to do 1) Check accounts 2) Status account 3)Check transactions 4)Quit ");
    int user = scanner.nextInt();

    switch (user) {
        case 1:
            empDao.emp_Check(employee);
            break;
        case 2:
            Status();
            break;
        case 3:
            empDao.Log(employee);
            break;
        case 4:
            System.out.println("Thank for your service");
            System.exit(0);
        default:
            throw new IllegalStateException("Unexpected value: " + user);

    }

}
    public static void ex_Customer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        Scanner scan = new Scanner(System.in);

            System.out.println("Would like to make a transaction: 1)Deposit 2)Withdraw 3)Transfer 4)Check or 5)Quit");
            int user = scanner.nextInt();

            switch (user) {
                case 1:
                    System.out.println("Please enter amount you wished to deposit.");
                    customerDao.addDeposit(customer);
                    break;
                case 2:
                    System.out.println("Please enter amount you wished to withdraw.");
                    customerDao.Withdraw(customer);
                    break;
                case 3:
                    customerDao.Transfer_In(customer);
                    break;
                case 4:
                    customerDao.Check(customer);

                    break;
                case 5:
                    System.out.println("Thank for your service");
                    System.exit(0);

                    break;


            }
    }



    public static void new_Employee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeDao employeeDao = EmpDaoFactory.getEmployeeDao();
        Employee employee = new Employee();

        System.out.println("What will you like to do next: 1) Check accounts 2) Status account 3)Check transactions 4) Quit");
        int user = scanner.nextInt();

        switch (user) {
            case 1:
                employeeDao.emp_Check(employee);
                break;
            case 2:
                Status();
                break;
            case 3:
                employeeDao.Log(employee);
                break;
            case 4:
                System.out.println("Thank for your service");
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);

        }
    }
    }