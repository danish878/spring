package com.danish.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.danish.spring.aop.Account;

@Component
public class AccountDAO {

    public List<Account> findAccounts(boolean tripWire) {

        // simulate an exeption
        if (tripWire)
            throw new RuntimeException("No soup for you");

        List<Account> accounts = new ArrayList<Account>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

}
