package com.danish.spring.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danish.spring.aop.Account;
import com.danish.spring.aop.DemoConfig;
import com.danish.spring.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call methods to find the accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simulate exception
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\n Main Program ... caught exception: " + e);
        }
        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(accounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
