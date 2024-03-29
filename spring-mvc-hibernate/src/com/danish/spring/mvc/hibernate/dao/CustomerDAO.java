package com.danish.spring.mvc.hibernate.dao;

import java.util.List;

import com.danish.spring.mvc.hibernate.entity.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomer(int id);
}
