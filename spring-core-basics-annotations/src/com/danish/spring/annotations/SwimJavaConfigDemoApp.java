package com.danish.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);

        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        System.out.println(coach.getEmail());

        System.out.println(coach.getTeam());

        context.close();

    }

}
