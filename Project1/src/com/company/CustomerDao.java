package com.company;
import java.sql.SQLException;
import java.util.List;


public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    void deleteCustomer(int id) throws SQLException;

    List<Customer> getCustomer();

    Customer getCustomerById(int id);

    void addDeposit(Customer customer) throws SQLException;
}
