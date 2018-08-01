package com.szczepanski.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    private Operation operation = new Operation();

    @Test
    public void addingStandardTest() {
        assertEquals("5", operation.makeCalculation("2+3"));
    }

    @Test
    public void addingNegativesTest() {
        assertEquals("1", operation.makeCalculation("-2+3"));
    }

    @Test
    public void addingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0+0"));
    }

    @Test
    public void badInputAddTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!+2"));
    }

    @Test
    public void decimalAddingTest() {
        assertEquals("5", operation.makeCalculation("2.25+2.75"));
    }

    @Test
    public void addingNegativeAndPositiveTest() {
        assertEquals("0", operation.makeCalculation("-2+2"));
    }

    @Test
    public void subtractingStandardTest() {
        assertEquals("1", operation.makeCalculation("3-2"));
    }

    @Test
    public void subtractingNegativesTest() {
        assertEquals("-5", operation.makeCalculation("-2-3"));
    }

    @Test
    public void subtractingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0-0"));
    }

    @Test
    public void badInputSubtractTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!-2"));
    }

    @Test
    public void decimalSubtractingTest() {
        assertEquals("-0.5", operation.makeCalculation("2.25-2.75"));
    }

    @Test
    public void multiplyingStandardTest() {
        assertEquals("6", operation.makeCalculation("2*3"));
    }

    @Test
    public void multiplyingNegativesTest() {
        assertEquals("6", operation.makeCalculation("-2*-3"));
    }

    @Test
    public void multiplyingZeroesTest() {
        assertEquals("0", operation.makeCalculation("0*0"));
    }

    @Test
    public void multiplyingNegativeAndPositiveTest() {
        assertEquals("-4", operation.makeCalculation("-2*2"));
    }

    @Test
    public void badInputMultiplyTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!*2"));
    }

    @Test
    public void decimalMultiplyingTest() {
        assertEquals("6.1875", operation.makeCalculation("2.25*2.75"));
    }

    @Test
    public void dividingStandardTest() {
        assertEquals("0.6666666667", operation.makeCalculation("2/3"));
    }

    @Test
    public void dividingNegativesTest() {
        assertEquals("2", operation.makeCalculation("-4*-2"));
    }

    @Test
    public void dividingZeroesTest() {
        assertEquals("ERR!", operation.makeCalculation("0*0"));
    }

    @Test
    public void dividingNegativeAndPositiveTest() {
        assertEquals("-1", operation.makeCalculation("-2/2"));
    }

    @Test
    public void decimalDividingTest() {
        assertEquals("0.8181818182", operation.makeCalculation("2.25/2.75"));
    }

    @Test
    public void badInputDivideTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!/2"));
    }

    @Test
    public void squareRootTest() {
        assertEquals("5", operation.makeCalculation("25"));
    }

    @Test
    public void negativeSquareRootTest() {
        assertEquals("ERR!", operation.makeCalculation("-5"));
    }

    @Test
    public void badInputSquareRootTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!"));
    }

    @Test
    public void squareRootZeroTest() {
        assertEquals("0", operation.makeCalculation("0"));
    }

    @Test
    public void badInputSquareRootTest2() {
        assertEquals("ERR!", operation.makeCalculation("2-"));
    }

    @Test
    public void squareNormalTest() {
        assertEquals("25", operation.makeCalculation("5"));
    }

    @Test
    public void squareNegativeTest() {
        assertEquals("25", operation.makeCalculation("-5"));
    }

    @Test
    public void squareZeroTest() {
        assertEquals("0", operation.makeCalculation("0"));
    }

    @Test
    public void badInputSquareTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!"));
    }

    @Test
    public void badInputSquareTest2() {
        assertEquals("ERR!", operation.makeCalculation("2-"));
    }

    @Test
    public void negatePositiveTest() {
        assertEquals("5", operation.makeCalculation("-5"));
    }

    @Test
    public void negateNegativeTest() {
        assertEquals("-5", operation.makeCalculation("5"));
    }

    @Test
    public void negateZeroTest() {
        assertEquals("0", operation.makeCalculation("0"));
    }

    @Test
    public void badInputNegateTest() {
        assertEquals("ERR!", operation.makeCalculation("ERR!"));
    }

    @Test
    public void badInputNegateTest2() {
        assertEquals("ERR!", operation.makeCalculation("2-"));
    }

}