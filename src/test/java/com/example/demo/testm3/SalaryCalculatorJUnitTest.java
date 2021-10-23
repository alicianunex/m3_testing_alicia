package com.example.demo.testm3;

import com.example.demo.domain.Employee;
import com.example.demo.service.IRPFCalculator;
import com.example.demo.service.IVACalculator;
import com.example.demo.service.SalaryCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SalaryCalculatorJUnitTest {

    IRPFCalculator irpfCalculator;
    IVACalculator ivaCalculator;
    SalaryCalculatorService salaryCalculatorService;
    Employee employee;

    @BeforeEach
    void setUp() {
        irpfCalculator = new IRPFCalculator();
        ivaCalculator = new IVACalculator();
        salaryCalculatorService = new SalaryCalculatorService(irpfCalculator,ivaCalculator);
        employee = new Employee();
    }

    @Test
    void ConstructorTest() {
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(irpfCalculator,ivaCalculator);
        assertNotNull(salaryCalculatorService);

    }


    @Test
    void calculateSalaryTest(){
        employee.setAge(10);
        assertNotNull(employee.getAge());
        double temp = salaryCalculatorService.calculateSalary(employee);
        assertEquals(43136.5,temp);

    }

}