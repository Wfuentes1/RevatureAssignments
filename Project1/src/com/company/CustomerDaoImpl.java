package com.company;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao {

    Connection connection;
    private Customer customer;

    public CustomerDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        String sql = "insert into customer (user_name, password, balance) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Please make your user_name.");
        String cust_username = scanner.nextLine();
        System.out.println("Please make your password.");
        String cust_password = scanner.nextLine();
        System.out.println("Please give insert your starting amount to deposit.");
        String cust_Bala = scanner.nextLine();

        preparedStatement.setString(1, cust_username);

        preparedStatement.setString(2, cust_password);

        preparedStatement.setInt(3, Integer.parseInt(cust_Bala));
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer saved\n");
        } else {
            System.out.println("Oops!, something went wrong");

        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "update customer (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer updated");
        } else {
            System.out.println("Oops!, something went wrong");
            ;
        }

    }

    @Override
    public void addDeposit(Customer customer) throws SQLException {
        String sql = "Update customer set balance= balance + (?) where username=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        Scanner scanner = new Scanner(System.in);
        // int amt = scanner.nextInt();
        Integer custBala = scanner.nextInt();
        int amount = custBala;
        preparedStatement.setInt(1, custBala);
        if (amount > 0 && amount < 10000) {
            System.out.println("Please give your username.");
            String cust_username = scanner.nextLine();
            preparedStatement.setString(2, cust_username);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Customer saved\n");
            } else {
                System.out.println("Oops!, something went wrong");

            }
        }
    }


    @Override
    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from employee (user_name,password,balance) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getUsername());
        preparedStatement.setString(2, customer.getPassword());
        preparedStatement.setInt(3, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer deleted");
        } else {
            System.out.println("Oops!, something went wrong");
            ;
        }

    }

    @Override
    public List<Customer> getCustomer() {
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }
}