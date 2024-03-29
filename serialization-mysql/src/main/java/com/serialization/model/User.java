package com.serialization.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -7214686239042891684L;

    private String name;
    private String dept;
    transient private Long salary;

    public User() {}

    public User(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
