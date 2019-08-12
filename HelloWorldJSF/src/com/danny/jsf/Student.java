package com.danny.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

    private String firstName;
    private String lastName;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
