package com.danny.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingAnnotation {

    private String message = "Manisha";
    private MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Manisha";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(dependsOnMethods = {"initEnvironmentTest"})
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test
    public void initEnvironmentTest() {
        System.out.println("This is initEnvironmentTest");
    }
}