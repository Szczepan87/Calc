package com.szczepanski.calc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DisplayTest {

    private Display display = new Display();

    @Test
    public void checkingOperatorPlus() {
        assertTrue(display.isLastCharAnOperator("2+"));
    }

    @Test
    public void checkingOperatorMinus() {
        assertTrue(display.isLastCharAnOperator("2-"));
    }

    @Test
    public void checkingOperatorMultiply() {
        assertTrue(display.isLastCharAnOperator("2*"));
    }

    @Test
    public void checkingOperatorDivide() {
        assertTrue(display.isLastCharAnOperator("2/"));
    }
}