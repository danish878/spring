package com.danny.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentThree {

    private String firstName;
    private String lastName;
    private String favouriteLanguage;

    public StudentThree() {
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

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

}
