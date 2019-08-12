package com.danny;

import org.junit.jupiter.api.*;

public class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called Once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void helloWorld1() {
        System.out.println(greeting.helloWorld("Danny"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After!!! *** - I am only called Once!!!");
    }
}
