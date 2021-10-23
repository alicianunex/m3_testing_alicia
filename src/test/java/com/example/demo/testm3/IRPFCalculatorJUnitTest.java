package com.example.demo.testm3;
import com.example.demo.service.IRPFCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IRPFCalculatorJUnitTest {

    IRPFCalculator irpfCalculator = new IRPFCalculator();

    // TODO test access level

    @Test
    void calculatePositive() {
        double a = irpfCalculator.calculateIRPF(1);
        assertEquals(0.15,a);
    }
    @Test
    void calculate0() {
        double a = irpfCalculator.calculateIRPF(0);
        assertEquals(0,a);
    }
    @Test
    void calculateNegative() {
        double a = irpfCalculator.calculateIRPF(-1);
        assertEquals(-0.15,a);
    }
    @Test
    void calculateNumchar() {
        double a = irpfCalculator.calculateIRPF('1');
        assertTrue(a > 0);
    }

    @Test
    void calculateDoubleclass() {
        double a = irpfCalculator.calculateIRPF(2D);
        assertTrue(a > 0);
    }
}

