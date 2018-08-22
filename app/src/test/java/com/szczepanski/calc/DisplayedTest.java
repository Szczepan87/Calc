package com.szczepanski.calc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisplayedTest {

    Displayed displayed = new Displayed();

    @Test
    public void properInputTest() {
        assertTrue(displayed.isProperInput("1+2"));
    }

    @Test
    public void properInputTest2() {
        assertTrue(displayed.isProperInput("1+"));
    }

    @Test
    public void properInputTest3() {
        assertTrue(displayed.isProperInput("1"));
    }

    @Test
    public void properInputTest4() {
        assertTrue(displayed.isProperInput("12"));
    }

    @Test
    public void properInputTest5() {
        assertTrue(displayed.isProperInput("1."));
    }

    @Test
    public void properInputTest6() {
        assertTrue(displayed.isProperInput("1.0"));
    }

    @Test
    public void properInputTest7() {
        assertTrue(displayed.isProperInput("1.0+"));
    }

    @Test
    public void properInputTest8() {
        assertTrue(displayed.isProperInput("1.0+2"));
    }

    @Test
    public void properInputTest9() {
        assertTrue(displayed.isProperInput("1.0+2."));
    }

    @Test
    public void properInputTest10() {
        assertTrue(displayed.isProperInput("1.0+2.0"));
    }

    @Test
    public void properInputTest11() {
        assertTrue(displayed.isProperInput("-1.0+2.0"));
    }

    @Test
    public void properInputTest12() {
        assertTrue(displayed.isProperInput("-1.0-2.0"));
    }

    @Test
    public void properInputTest13() {
        assertTrue(displayed.isProperInput("-1.0*-2.0"));
    }

    @Test
    public void properInputTest14() {
        assertTrue(displayed.isProperInput("-"));
    }

    @Test
    public void properInputTest15() {
        assertEquals("0.1-", displayed.updateDisplay("0.1+", '-'));
    }

    @Test
    public void properInputTest16() {
        assertEquals("0.1*-", displayed.updateDisplay("0.1*", '-'));
    }

    @Test
    public void properInputTest17() {
        assertEquals("10", displayed.updateDisplay("1", '0'));
    }

    @Test
    public void properInputTest18() {
        assertEquals("-", displayed.updateDisplay("0", '-'));
    }

    @Test
    public void properInputTest19() {
        assertEquals("1", displayed.updateDisplay("0", '1'));
    }

    @Test
    public void properInputTest20() {
        assertEquals("0", displayed.updateDisplay("0", '+'));
    }


    //wrong input types below

    @Test
    public void wrongInputTest1() {
        assertFalse(displayed.isProperInput("1.+"));
    }

    @Test
    public void wrongInputTest2() {
        assertFalse(displayed.isProperInput("1.."));
    }

    @Test
    public void wrongInputTest3() {
        assertFalse(displayed.isProperInput("1.0."));
    }

    @Test
    public void wrongInputTest4() {
        assertFalse(displayed.isProperInput("1.0+2.0."));
    }

    @Test
    public void wrongInputTest5() {
        assertFalse(displayed.isProperInput("1.0+2.."));
    }

    @Test
    public void wrongInputTest6() {
        assertFalse(displayed.isProperInput("abc"));
    }

    @Test
    public void wrongInputTest7() {
        assertFalse(displayed.isProperInput("2+abc"));
    }

    @Test
    public void wrongInputTest8() {
        assertFalse(displayed.isProperInput("2++"));
    }

    @Test
    public void wrongInputTest9() {
        assertFalse(displayed.isProperInput("2--"));
    }

    @Test
    public void wrongInputTest10() {
        assertFalse(displayed.isProperInput("2.321.3"));
    }

    @Test
    public void wrongInputTest11() {
        assertFalse(displayed.isProperInput("-2.321.3"));
    }

    @Test
    public void wrongInputTest12() {
        assertFalse(displayed.isProperInput("-2.321.3+321.123"));
    }

    @Test
    public void wrongInputTest13() {
        assertFalse(displayed.isProperInput("-2.321.3*-321.123.321"));
    }

    @Test
    public void wrongInputTest14() {
        assertFalse(displayed.isProperInput("-2*-/321"));
    }

    @Test
    public void wrongInputTest15() {
        assertFalse(displayed.isProperInput("-2*/-321"));
    }

    @Test
    public void wrongInputTest16() {
        assertFalse(displayed.isProperInput("-2*/321"));
    }

    @Test
    public void wrongInputTest17() {
        assertFalse(displayed.isProperInput("-2--321"));
    }

    @Test
    public void wrongInputTest18() {
        assertFalse(displayed.isProperInput("/2-321"));
    }

    @Test
    public void wrongInputTest19() {
        assertFalse(displayed.isProperInput("/2"));
    }

    @Test
    public void wrongInputTest20() {
        assertFalse(displayed.isProperInput("*"));
    }

    @Test
    public void wrongInputTest21() {
        assertEquals("0", displayed.updateDisplay("0", '0'));
    }

    @Test
    public void wrongInputTest22() {
        assertEquals("0.", displayed.updateDisplay("0.", '.'));
    }

    @Test
    public void wrongInputTest23() {
        assertEquals("0.", displayed.updateDisplay("0.", '+'));
    }

    @Test
    public void wrongInputTest24() {
        assertEquals("0.", displayed.updateDisplay("0.", '+'));
    }

    @Test
    public void wrongInputTest25() {
        assertEquals("0.1+", displayed.updateDisplay("0.1+", '+'));
    }

    @Test
    public void wrongInputTest26() {
        assertEquals("0.1-", displayed.updateDisplay("0.1-", '-'));
    }

}