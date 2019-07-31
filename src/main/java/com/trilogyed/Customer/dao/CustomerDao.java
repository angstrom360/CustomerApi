package com.trilogyed.Customer.dao;

import com.trilogyed.Customer.model.Customer;

import java.util.List;

public interface CustomerDao {

    //-------------- Basic CRUD Methods ------------//

    Customer createCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);

    // -------------------------------------------//

}
