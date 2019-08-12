package com.danny.testng;

class EmpBusinessLogic {

    // Calculate the yearly salary of employee
    double calculateYearlySalary(EmployeeDetails employeeDetails) {
        return employeeDetails.getMonthlySalary() * 12; //return annual salary
    }

    // Calculate the appraisal amount of employee
    double calculateAppraisal(EmployeeDetails employeeDetails) {
        return employeeDetails.getMonthlySalary() < 10000 ? 500 : 100;
    }
}