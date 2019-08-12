package com.danny.springquartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CronJobRunner {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("cron-quartz-context.xml");
    }

}