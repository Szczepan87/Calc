package com.szczepanski.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    private Operation operation = new Operation();

    @Test
    public void addingStandardTest() {
        assertEquals("5", operation.add("2+3"));
    }

    @Test
    public void addingNegativesTest() {
        assertEquals("-5", operation.add("-2+-3"));
    }

    @Test
    public void addingZeroesTest() {
        assertEquals("0", operation.add("0+0"));
    }

    @Test
    public void addingNegativeAndPositiveTest() {
        assertEquals("0", operation.add("-2+2"));
    }

    @Test
    public void subtractingStandardTest() {
        assertEquals("1", operation.subtract("3-2"));
    }

    @Test
    public void subtractingNegativesTest() {
        assertEquals("-5", operation.subtract("-2--3"));
    }

    @Test
    public void subtractingZeroesTest() {
        assertEquals("0", operation.subtract("0-0"));
    }

    @Test
    public void subtractingNegativeAndPositiveTest() {
        assertEquals("-4", operation.subtract("-2-2"));
    }

    @Test
    public void multiplyingStandardTest() {
        assertEquals("6", operation.multiply("2*3"));
    }

    @Test
    public void multiplyingNegativesTest() {
        assertEquals("6", operation.multiply("-2*-3"));
    }

    @Test
    public void multiplyingZeroesTest() {
        assertEquals("0", operation.multiply("0*0"));
    }

    @Test
    public void multiplyingNegativeAndPositiveTest() {
        assertEquals("-4", operation.multiply("-2*2"));
    }

    @Test
    public void dividingStandardTest() {
        assertEquals("0.6666666667", operation.divide("2/3"));
    }

    @Test
    public void dividingNegativesTest() {
        assertEquals("2", operation.divide("-4*-2"));
    }

    @Test
    public void dividingZeroesTest() {
        assertEquals("ERR!", operation.divide("0*0"));
    }

    @Test
    public void dividingNegativeAndPositiveTest() {
        assertEquals("-1", operation.divide("-2/2"));
    }
}