package com.danish.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    // Field injection
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // Constructor injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

    // Setter injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService method");
//		this.fortuneService = fortuneService;
//	}

    // Any method injection
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService method");
//		this.fortuneService = fortuneService;
//	}

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return "Today is your lucky Day!";
    }

    @PostConstruct
    public void PostConstruct() {
        System.out.println(">> Post Construct");
    }

    @PreDestroy
    public void PreDestroy() {
        System.out.println(">> Pre Destroy");
    }

}
