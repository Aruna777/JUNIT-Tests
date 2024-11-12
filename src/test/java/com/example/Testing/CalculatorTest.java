package com.example.Testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private static CalculatorExample calculatorExample;

    @BeforeAll
    static void setUp(){
         calculatorExample = new CalculatorExample();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculatorExample.add(2, 3));
    }

    @Test
    void testSubtract(){
        assertEquals(2, calculatorExample.subtract(5, 3));
    }

    @Test
    void testMultiply(){
        assertEquals(10, calculatorExample.multiply(5, 2));
    }

    @Test
    void testDivide(){
        assertEquals(4, calculatorExample.divide(8, 2));
    }
}
