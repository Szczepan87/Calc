package com.szczepanski.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    private Operation operation = new Operation();

    @Test
    public void addingStandardTest() {
        assertEquals("5", operation.makeCalculation("2+3"));
        assertEquals("5", operation.makeCalculation("2.0+3.0"));
        assertEquals("5.5", operation.makeCalculation("2.5+3"));
    }

    @Test
    public void addingToNegativesTest() {
        assertEquals("1", operation.makeCalculation("-2+3"));
        assertEquals("1", operation.makeCalculation("-2.0+3.0"));
        assertEquals("0.5", operation.makeCalculation("-2.5+3"));
        assertEquals("-5.5", operation.makeCalculation("-2.5+-3"));
    }

    @Test
    public void addingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0+0"));
        assertEquals("0", operation.makeCalculation("0.0+0.0"));
    }

    @Test
    public void subtractingStandardTest() {
        assertEquals("1", operation.makeCalculation("3-2"));
        assertEquals("-1", operation.makeCalculation("3-4"));
        assertEquals("-1", operation.makeCalculation("3.0-4.0"));
        assertEquals("-0.5", operation.makeCalculation("3.5-4.0"));
    }

    @Test
    public void subtractingNegativesTest() {
        assertEquals("-5", operation.makeCalculation("-2-3"));
        assertEquals("1", operation.makeCalculation("-2+3"));
        assertEquals("-5", operation.makeCalculation("-2.0-3.0"));
        assertEquals("-5.5", operation.makeCalculation("-2-3.5"));
    }

    @Test
    public void subtractingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0-0"));
        assertEquals("0", operation.makeCalculation("0.0-0.0"));
    }

    @Test
    public void multiplyingStandardTest() {
        assertEquals("6", operation.makeCalculation("2*3"));
        assertEquals("6", operation.makeCalculation("2.0*3.0"));
        assertEquals("5", operation.makeCalculation("2.5*2"));
    }

    @Test
    public void multiplyingNegativesTest() {
        assertEquals("6", operation.makeCalculation("-2*-3"));
        assertEquals("-6", operation.makeCalculation("-2*3"));
        assertEquals("-6", operation.makeCalculation("-2.0*3.0"));
        assertEquals("6", operation.makeCalculation("-2.0*-3.0"));
        assertEquals("-5", operation.makeCalculation("-2.5*2"));
    }

    @Test
    public void multiplyingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0*0"));
        assertEquals("0", operation.makeCalculation("0.0*0.0"));
    }

    @Test
    public void dividingStandardTest() {
        assertEquals("0.6666666667", operation.makeCalculation("2/3"));
        assertEquals("-0.6666666667", operation.makeCalculation("2/-3"));
        assertEquals("5", operation.makeCalculation("10/2"));
        assertEquals("-5", operation.makeCalculation("-10/2"));
    }

    @Test
    public void dividingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0/2"));
        assertEquals("ERR!", operation.makeCalculation("0/0"));
    }

    @Test
    public void decimalDividingTest() {
        assertEquals("0.8181818182", operation.makeCalculation("2.25/2.75"));
        assertEquals("-0.8181818182", operation.makeCalculation("2.25/-2.75"));
    }

    @Test
    public void squareRootTest() {
        assertEquals("5", operation.squareRoot("25"));
    }

    @Test
    public void negativeSquareRootTest() {
        assertEquals("ERR!", operation.squareRoot("-5"));
    }

    @Test
    public void badInputSquareRootTest() {
        assertEquals("ERR!", operation.squareRoot("ERR!"));
        assertEquals("ERR!", operation.squareRoot("2-"));
    }

    @Test
    public void squareRootZeroTest() {
        assertEquals("0", operation.squareRoot("0"));
    }

    @Test
    public void squareNormalTest() {
        assertEquals("25", operation.square("5"));
    }

    @Test
    public void squareNegativeTest() {
        assertEquals("25", operation.square("-5"));
    }

    @Test
    public void squareZeroTest() {
        assertEquals("0", operation.square("0"));
    }

    @Test
    public void badInputSquareTest() {
        assertEquals("ERR!", operation.square("ERR!"));
        assertEquals("ERR!", operation.square("2-"));
    }

    @Test
    public void negatePositiveTest() {
        assertEquals("5", operation.negate("-5"));
    }

    @Test
    public void negateNegativeTest() {
        assertEquals("-5", operation.negate("5"));
    }

    @Test
    public void negateZeroTest() {
        assertEquals("0", operation.negate("0"));
    }

    @Test
    public void badInputNegateTest() {
        assertEquals("ERR!", operation.negate("ERR!"));
    }

    @Test
    public void badInputNegateTest2() {
        assertEquals("ERR!", operation.negate("2-"));
    }
}