package com.demo.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class User {
    @Override
    public String toString() {
        return "User [name=" + userName + ", Address=" + address + ", Password=" + password + ", phone="
                + phone + "]";
    }

    @NotEmpty
    @Size(min = 3, max = 15)
    private String userName;

    @NotEmpty
    @Size(min = 3, max = 15)
    private String password;

    private String address;

    @Pattern(regexp = "(^$|[0-9]{10})")
    @NotEmpty
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
