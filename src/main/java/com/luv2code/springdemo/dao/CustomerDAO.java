package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCusomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
