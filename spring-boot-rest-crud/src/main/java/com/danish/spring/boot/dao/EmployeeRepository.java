package com.danish.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.danish.spring.boot.entity.Employee;

@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
