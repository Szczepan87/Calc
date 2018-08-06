package com.szczepanski.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisplayTest {

    private Display display = new Display();

    @Test
    public void checkingOperatorPlusTest() {
        assertTrue(display.isLastCharAnOperator("123+"));
    }

    @Test
    public void checkingOperatorMinusTest() {
        assertTrue(display.isLastCharAnOperator("123-"));
    }

    @Test
    public void checkingOperatorMultiplyTest() {
        assertTrue(display.isLastCharAnOperator("123*"));
    }

    @Test
    public void checkingOperatorDivideTest() {
        assertTrue(display.isLastCharAnOperator("123/"));
    }

    @Test
    public void checkingNonOperatorTest() {
        assertFalse(display.isLastCharAnOperator("123"));
    }

    @Test
    public void isZeroTest() {
        assertFalse(display.isZero("123"));
    }

    @Test
    public void isZeroTrueTest() {
        assertTrue(display.isZero("0"));
    }

    @Test
    public void updateDisplayByOperatorTest() {
        assertEquals("123+", display.updateDisplay("123", "+"));
    }

    @Test
    public void updateDisplayByNumberTest() {
        assertEquals("123", display.updateDisplay("12", "3"));
    }

    @Test
    public void updateDisplayByZeroTest() {
        assertEquals("0", display.updateDisplay("0", "0"));
    }

    @Test
    public void updateDisplayByNumberWithZeroOnScreenTest() {
        assertEquals("9", display.updateDisplay("0", "9"));
    }

    @Test
    public void updateDisplayByTwoSameOperatorsTest() {
        assertEquals("123+", display.updateDisplay("123+", "+"));
    }

    @Test
    public void updateDisplayByTwoOperatorsTest() {
        assertEquals("123-", display.updateDisplay("123+", "-"));
    }

    @Test
    public void updateDisplayBySecondValueTest() {
        assertEquals("123+456", display.updateDisplay("123+", "456"));
    }

    @Test
    public void checkWrongInputTest() {
        assertEquals("123+", display.updateDisplay("123+", "abc"));
    }

    @Test
    public void checkWrongInputTest2() {
        assertFalse(display.isProperInput("ERR!"));
    }

    @Test
    public void updateDecimalTest() {
        assertEquals("1.0",display.updateDisplay("1.0", "."));
    }

    @Test
    public void updateDecimalInOperationTest() {
        assertEquals("1.0+0.3",display.updateDisplay("1.0+0.3", "."));
    }
}