package com.danny.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

    private PrimeNumberChecker primeNumberChecker;

    @BeforeMethod
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
    }

    // This test will run 4 times since we have 5 parameters defined
    @Test(dataProvider = "test1")
    public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
        System.out.println(inputNumber + " " + expectedResult);
        Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
    }


//    @Test
//    @Parameters("myName")
//    public void parameterTest(String myName) {
//        System.out.println("Parameterized value is : " + myName);
//    }
   /*
   * <?xml version = "1.0" encoding = "UTF-8"?>
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

    <suite name = "Suite1">
       <test name = "test1">

          <parameter name = "myName" value="manisha"/>

          <classes>
             <class name = "ParameterizedTest" />
          </classes>

       </test>
    </suite>
   * */


}