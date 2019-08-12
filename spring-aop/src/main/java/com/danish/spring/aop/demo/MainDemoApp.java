package com.danish.spring.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danish.spring.aop.DemoConfig;
import com.danish.spring.aop.dao.AccountDAO;
import com.danish.spring.aop.dao.MembershipDAO;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountdao bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        accountDAO.addAccount();

        // call the business method
        membershipDAO.addAccount("Savings");

        // close the context
        context.close();
    }
}
