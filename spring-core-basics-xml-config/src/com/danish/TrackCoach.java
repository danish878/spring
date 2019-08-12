package com.danish;

public class TrackCoach implements Coach {

    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TrackCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartUpStuff() {
        System.out.println("Track Coach: inside method doMyStartUpStuff");
    }

    // add a destroy method
    public void doMyCleanUpStuff() {
        System.out.println("Track Coach: inside method doMyCleanUpStuff");
    }
}
