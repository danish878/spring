package com.danish.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();

    }

}
