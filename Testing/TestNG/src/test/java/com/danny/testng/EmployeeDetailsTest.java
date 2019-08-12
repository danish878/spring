package com.danny.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeDetailsTest {

    private EmpBusinessLogic empBusinessLogic;
    private EmployeeDetails employee;

    @BeforeMethod
    public void setUp() {
        empBusinessLogic = new EmpBusinessLogic();
        employee = new EmployeeDetails();
    }

    @Test
    public void testCalculateAppriasal() {

        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        Assert.assertEquals(500, appraisal, 0.0, "500");
        Assert.assertEquals(appraisal, 500.0);
    }

    // Test to check yearly salary
    @Test
    public void testCalculateYearlySalary() {

        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double salary = empBusinessLogic.calculateYearlySalary(employee);
        Assert.assertEquals(96000, salary, 0.0, "8000");
        Assert.assertEquals(salary, 96000.0);
    }
}