package com.example.demo.testm3;

import com.example.demo.service.IVACalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IVACalculatorJUnitTest {
    IVACalculator ivaCalculator = new IVACalculator();

    // TODO test access level

    @Test
    void calculatePositive() {
        double a = ivaCalculator.calculateIVA(1);
        assertEquals(0.21,a);
    }
    @Test
    void calculate0() {
        double a = ivaCalculator.calculateIVA(0);
        assertEquals(0,a);
    }
    @Test
    void calculateNegative() {
        double a = ivaCalculator.calculateIVA(-1);
        assertEquals(-0.21,a);
    }
    @Test
    void calculateNumchar() {
        double a = ivaCalculator.calculateIVA('1');
        assertTrue(a > 0);
    }
    @Test
    void calculateLetterchar() {
        double a = ivaCalculator.calculateIVA('a');
        System.out.println(a);
        // Char can be converted to double
        // Not intended usage??
        assertTrue(true);
    }
    @Test
    void calculateSymbolchar() {
        double a = ivaCalculator.calculateIVA('\'');
        System.out.println(a);
        // Char can be converted to double
        // Not intended usage??
        assertTrue(true);
    }
    @Test
    void calculateDoubleclass() {
        Double b = 2D;
        double a = ivaCalculator.calculateIVA(2D);
        assertTrue(a > 0);
    }
}

