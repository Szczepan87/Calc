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
}