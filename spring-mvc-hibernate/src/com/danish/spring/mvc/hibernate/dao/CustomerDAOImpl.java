package com.danish.spring.mvc.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danish.spring.mvc.hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY last_name", Customer.class);

        // execute query and get result set
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = new Customer();
        customer.setId(id);
        currentSession.delete(customer);
    }

}
