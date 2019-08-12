package com.danish.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danish.jpa.hibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    // Insert an employee
    public void insert(Employee employee) {
        em.persist(employee);
    }

    // Retrieve all employees
    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
}
