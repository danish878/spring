package com.danny.springquartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleJobRunner {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("simple-quartz-context.xml");
    }

}