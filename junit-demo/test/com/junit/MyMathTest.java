package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.demo.junit.MyMath;

class MyMathTest {

    MyMath myMath = new MyMath();

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }


    @Test
    public void sum_with3numbers() {
        System.out.println("Test1");
        assertEquals(6, myMath.sum(new int[]{1, 2, 3}));
    }

    @Test
    public void sum_with1numbers() {
        System.out.println("Test2");
        assertEquals(7, myMath.sum(new int[]{7}));
    }

}
