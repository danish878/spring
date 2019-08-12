package com.danish.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount(String account) {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return false;
    }
}
