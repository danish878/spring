package com.danish.spring.mvc.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danish.spring.mvc.hibernate.dao.CustomerDAO;
import com.danish.spring.mvc.hibernate.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public Customer getCustomeById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

}
