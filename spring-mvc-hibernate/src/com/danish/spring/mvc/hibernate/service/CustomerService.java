package com.danish.spring.mvc.hibernate.service;

import java.util.List;

import com.danish.spring.mvc.hibernate.entity.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomeById(int id);

    public void deleteCustomer(int id);

}
