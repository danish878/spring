package com.danish.spring.aop.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danish.spring.aop.DemoConfig;
import com.danish.spring.aop.service.TrafficFortuneService;

public class AroundDemoApp {

    private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");

        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);

        logger.info("\nMy fortune is: " + data);

        logger.info("Finished");

        // close the context
        context.close();
    }
}
