package com.danny.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IgnoreTest {
    private String message;
    private MessageUtil messageUtil;

    @BeforeMethod
    public void setUp() {
        message = "Manisha";
        messageUtil = new MessageUtil(message);
    }

    @Test(enabled = false)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Manisha";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}