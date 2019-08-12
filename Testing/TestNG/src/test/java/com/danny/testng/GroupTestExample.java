package com.danny.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestExample {

    private String message = ".com";
    private MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = {"functest", "checkintest"})

    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = ".com";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(groups = {"checkintest"})

    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + ".com";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test(groups = {"functest"})

    public void testingExitMessage() {
        System.out.println("Inside testExitMessage()");
        message = "www.Hi!" + ".com";
        Assert.assertEquals(message, messageUtil.exitMessage());
    }
}