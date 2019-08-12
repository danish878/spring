package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.ControllerTests;
import com.danny.sfgpetclinic.exceptions.ValueNotFoundException;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), () -> "Another Expensive Message" + "Make me only if you have to");

        // AssertJ
        Assertions.assertThat(controller.index()).isEqualTo("index");

        // Hamcrest
        MatcherAssert.assertThat(controller.index(), Matchers.is("index"));
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
//        assertTrue("notimplemented".equals(controller.oupsHandler()), ()->"Message printed if assert fails");
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
//            Thread.sleep(1000);
            System.out.println("I got here");
        });
    }

    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            Thread.sleep(1000);
            System.out.println("I got here");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "SYSTEM")
    @Test
    void testIfUserDanish() {

    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Totha")
    @Test
    void testIfUserTotha() {

    }
}