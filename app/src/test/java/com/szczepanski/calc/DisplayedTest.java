package com.szczepanski.calc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DisplayedTest {

    private Displayed displayed = new Displayed();

    @Test
    public void operatorAfterNumberTest() {
        assertEquals("1+", displayed.updateDisplay("1",'+'));
        assertEquals("1-", displayed.updateDisplay("1",'-'));
        assertEquals("1*", displayed.updateDisplay("1",'*'));
        assertEquals("1/", displayed.updateDisplay("1",'/'));
        assertEquals("-1+", displayed.updateDisplay("-1",'+'));
        assertEquals("-1-", displayed.updateDisplay("-1",'-'));
        assertEquals("-1*", displayed.updateDisplay("-1",'*'));
        assertEquals("-1/", displayed.updateDisplay("-1",'/'));
        assertEquals("1.0+", displayed.updateDisplay("1.0",'+'));
        assertEquals("1.0-", displayed.updateDisplay("1.0",'-'));
        assertEquals("1.0*", displayed.updateDisplay("1.0",'*'));
        assertEquals("1.0/", displayed.updateDisplay("1.0",'/'));
        assertEquals("-1.0+", displayed.updateDisplay("-1.0",'+'));
        assertEquals("-1.0-", displayed.updateDisplay("-1.0",'-'));
        assertEquals("-1.0*", displayed.updateDisplay("-1.0",'*'));
        assertEquals("-1.0/", displayed.updateDisplay("-1.0",'/'));

    }

    @Test
    public void InputAfterZeroTest() {
        assertEquals("1", displayed.updateDisplay("0",'1'));
        assertEquals("2", displayed.updateDisplay("0",'2'));
        assertEquals("3", displayed.updateDisplay("0",'3'));
        assertEquals("4", displayed.updateDisplay("0",'4'));
        assertEquals("5", displayed.updateDisplay("0",'5'));
        assertEquals("6", displayed.updateDisplay("0",'6'));
        assertEquals("7", displayed.updateDisplay("0",'7'));
        assertEquals("8", displayed.updateDisplay("0",'8'));
        assertEquals("9", displayed.updateDisplay("0",'9'));
        assertEquals("0", displayed.updateDisplay("0",'0'));
        assertEquals("0.", displayed.updateDisplay("0",'.'));
        assertEquals("0.", displayed.updateDisplay("0",','));
        assertEquals("0+", displayed.updateDisplay("0",'+'));
        assertEquals("-", displayed.updateDisplay("0",'-'));
        assertEquals("0*", displayed.updateDisplay("0",'*'));
        assertEquals("0/", displayed.updateDisplay("0",'/'));
    }

    @Test
    public void InputAfterNumberTest() {
        assertEquals("10", displayed.updateDisplay("1",'0'));
        assertEquals("11", displayed.updateDisplay("1",'1'));
        assertEquals("12", displayed.updateDisplay("1",'2'));
        assertEquals("13", displayed.updateDisplay("1",'3'));
        assertEquals("14", displayed.updateDisplay("1",'4'));
        assertEquals("15", displayed.updateDisplay("1",'5'));
        assertEquals("16", displayed.updateDisplay("1",'6'));
        assertEquals("17", displayed.updateDisplay("1",'7'));
        assertEquals("18", displayed.updateDisplay("1",'8'));
        assertEquals("19", displayed.updateDisplay("1",'9'));
        assertEquals("1.", displayed.updateDisplay("1",','));
        assertEquals("1.", displayed.updateDisplay("1",'.'));
        assertEquals("1+", displayed.updateDisplay("1",'+'));
        assertEquals("1-", displayed.updateDisplay("1",'-'));
        assertEquals("1*", displayed.updateDisplay("1",'*'));
        assertEquals("1/", displayed.updateDisplay("1",'/'));
        assertEquals("-10", displayed.updateDisplay("-1",'0'));
        assertEquals("-11", displayed.updateDisplay("-1",'1'));
        assertEquals("-12", displayed.updateDisplay("-1",'2'));
        assertEquals("-13", displayed.updateDisplay("-1",'3'));
        assertEquals("-14", displayed.updateDisplay("-1",'4'));
        assertEquals("-15", displayed.updateDisplay("-1",'5'));
        assertEquals("-16", displayed.updateDisplay("-1",'6'));
        assertEquals("-17", displayed.updateDisplay("-1",'7'));
        assertEquals("-18", displayed.updateDisplay("-1",'8'));
        assertEquals("-19", displayed.updateDisplay("-1",'9'));
        assertEquals("-1.", displayed.updateDisplay("-1",','));
        assertEquals("-1.", displayed.updateDisplay("-1",'.'));
        assertEquals("-1+", displayed.updateDisplay("-1",'+'));
        assertEquals("-1-", displayed.updateDisplay("-1",'-'));
        assertEquals("-1*", displayed.updateDisplay("-1",'*'));
        assertEquals("-1/", displayed.updateDisplay("-1",'/'));
    }

    @Test
    public void InputAfterPointerTest() {
        assertEquals("1.0", displayed.updateDisplay("1.",'0'));
        assertEquals("1.1", displayed.updateDisplay("1.",'1'));
        assertEquals("1.2", displayed.updateDisplay("1.",'2'));
        assertEquals("1.3", displayed.updateDisplay("1.",'3'));
        assertEquals("1.4", displayed.updateDisplay("1.",'4'));
        assertEquals("1.5", displayed.updateDisplay("1.",'5'));
        assertEquals("1.6", displayed.updateDisplay("1.",'6'));
        assertEquals("1.7", displayed.updateDisplay("1.",'7'));
        assertEquals("1.8", displayed.updateDisplay("1.",'8'));
        assertEquals("1.9", displayed.updateDisplay("1.9",'9'));
        assertEquals("1.", displayed.updateDisplay("1.",'.'));
        assertEquals("1.", displayed.updateDisplay("1.",','));
        assertEquals("1.", displayed.updateDisplay("1.",'+'));
        assertEquals("1.", displayed.updateDisplay("1.",'-'));
        assertEquals("1.", displayed.updateDisplay("1.",'*'));
        assertEquals("1.", displayed.updateDisplay("1.",'/'));
        assertEquals("-1.0", displayed.updateDisplay("-1.",'0'));
        assertEquals("-1.1", displayed.updateDisplay("-1.",'1'));
        assertEquals("-1.2", displayed.updateDisplay("-1.",'2'));
        assertEquals("-1.3", displayed.updateDisplay("-1.",'3'));
        assertEquals("-1.4", displayed.updateDisplay("-1.",'4'));
        assertEquals("-1.5", displayed.updateDisplay("-1.",'5'));
        assertEquals("-1.6", displayed.updateDisplay("-1.",'6'));
        assertEquals("-1.7", displayed.updateDisplay("-1.",'7'));
        assertEquals("-1.8", displayed.updateDisplay("-1.",'8'));
        assertEquals("-1.9", displayed.updateDisplay("-1.9",'9'));
        assertEquals("-1.", displayed.updateDisplay("-1.",'.'));
        assertEquals("-1.", displayed.updateDisplay("-1.",','));
        assertEquals("-1.", displayed.updateDisplay("-1.",'+'));
        assertEquals("-1.", displayed.updateDisplay("-1.",'-'));
        assertEquals("-1.", displayed.updateDisplay("-1.",'*'));
        assertEquals("-1.", displayed.updateDisplay("-1.",'/'));
    }

    @Test
    public void InputAfterDecimalTest() {
        assertEquals("1.9", displayed.updateDisplay("1.9",'.'));
        assertEquals("1.9", displayed.updateDisplay("1.9",','));
        assertEquals("1.9+", displayed.updateDisplay("1.9",'+'));
        assertEquals("1.9-", displayed.updateDisplay("1.9",'-'));
        assertEquals("1.9*", displayed.updateDisplay("1.9",'*'));
        assertEquals("1.9/", displayed.updateDisplay("1.9",'/'));
        assertEquals("1.90", displayed.updateDisplay("1.9",'0'));
        assertEquals("1.91", displayed.updateDisplay("1.9",'1'));
        assertEquals("1.92", displayed.updateDisplay("1.9",'2'));
        assertEquals("1.93", displayed.updateDisplay("1.9",'3'));
        assertEquals("1.94", displayed.updateDisplay("1.9",'4'));
        assertEquals("1.95", displayed.updateDisplay("1.9",'5'));
        assertEquals("1.96", displayed.updateDisplay("1.9",'6'));
        assertEquals("1.97", displayed.updateDisplay("1.9",'7'));
        assertEquals("1.98", displayed.updateDisplay("1.9",'8'));
        assertEquals("1.99", displayed.updateDisplay("1.9",'9'));
        assertEquals("-1.9", displayed.updateDisplay("-1.9",'.'));
        assertEquals("-1.9", displayed.updateDisplay("-1.9",','));
        assertEquals("-1.9+", displayed.updateDisplay("-1.9",'+'));
        assertEquals("-1.9-", displayed.updateDisplay("-1.9",'-'));
        assertEquals("-1.9*", displayed.updateDisplay("-1.9",'*'));
        assertEquals("-1.9/", displayed.updateDisplay("-1.9",'/'));
        assertEquals("-1.90", displayed.updateDisplay("-1.9",'0'));
        assertEquals("-1.91", displayed.updateDisplay("-1.9",'1'));
        assertEquals("-1.92", displayed.updateDisplay("-1.9",'2'));
        assertEquals("-1.93", displayed.updateDisplay("-1.9",'3'));
        assertEquals("-1.94", displayed.updateDisplay("-1.9",'4'));
        assertEquals("-1.95", displayed.updateDisplay("-1.9",'5'));
        assertEquals("-1.96", displayed.updateDisplay("-1.9",'6'));
        assertEquals("-1.97", displayed.updateDisplay("-1.9",'7'));
        assertEquals("-1.98", displayed.updateDisplay("-1.9",'8'));
        assertEquals("-1.99", displayed.updateDisplay("-1.9",'9'));
    }

    @Test
    public void InputAfterERRTest() {
        assertEquals("1",displayed.updateDisplay("ERR!", '1'));
        assertEquals("2",displayed.updateDisplay("ERR!", '2'));
        assertEquals("3",displayed.updateDisplay("ERR!", '3'));
        assertEquals("4",displayed.updateDisplay("ERR!", '4'));
        assertEquals("5",displayed.updateDisplay("ERR!", '5'));
        assertEquals("6",displayed.updateDisplay("ERR!", '6'));
        assertEquals("7",displayed.updateDisplay("ERR!", '7'));
        assertEquals("8",displayed.updateDisplay("ERR!", '8'));
        assertEquals("9",displayed.updateDisplay("ERR!", '9'));
        assertEquals("0",displayed.updateDisplay("ERR!", '0'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", '+'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", '-'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", '*'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", '/'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", '.'));
        assertEquals("ERR!",displayed.updateDisplay("ERR!", ','));
    }

    @Test
    public void InputAfterOperatorTest() {
        assertEquals("1+1", displayed.updateDisplay("1+",'1'));
        assertEquals("1+2", displayed.updateDisplay("1+",'2'));
        assertEquals("1+3", displayed.updateDisplay("1+",'3'));
        assertEquals("1+4", displayed.updateDisplay("1+",'4'));
        assertEquals("1+5", displayed.updateDisplay("1+",'5'));
        assertEquals("1+6", displayed.updateDisplay("1+",'6'));
        assertEquals("1+7", displayed.updateDisplay("1+",'7'));
        assertEquals("1+8", displayed.updateDisplay("1+",'8'));
        assertEquals("1+9", displayed.updateDisplay("1+",'9'));
        assertEquals("1+0", displayed.updateDisplay("1+",'0'));
        assertEquals("1+", displayed.updateDisplay("1+",'+'));
        assertEquals("1-", displayed.updateDisplay("1+",'-'));
        assertEquals("1*", displayed.updateDisplay("1+",'*'));
        assertEquals("1/", displayed.updateDisplay("1+",'/'));
        assertEquals("1+", displayed.updateDisplay("1+",'.'));
        assertEquals("1+", displayed.updateDisplay("1+",','));
        assertEquals("-1+1", displayed.updateDisplay("-1+",'1'));
        assertEquals("-1+2", displayed.updateDisplay("-1+",'2'));
        assertEquals("-1+3", displayed.updateDisplay("-1+",'3'));
        assertEquals("-1+4", displayed.updateDisplay("-1+",'4'));
        assertEquals("-1+5", displayed.updateDisplay("-1+",'5'));
        assertEquals("-1+6", displayed.updateDisplay("-1+",'6'));
        assertEquals("-1+7", displayed.updateDisplay("-1+",'7'));
        assertEquals("-1+8", displayed.updateDisplay("-1+",'8'));
        assertEquals("-1+9", displayed.updateDisplay("-1+",'9'));
        assertEquals("-1+0", displayed.updateDisplay("-1+",'0'));
        assertEquals("-1+", displayed.updateDisplay("-1+",'+'));
        assertEquals("-1-", displayed.updateDisplay("-1+",'-'));
        assertEquals("-1*", displayed.updateDisplay("-1+",'*'));
        assertEquals("-1/", displayed.updateDisplay("-1+",'/'));
        assertEquals("-1+", displayed.updateDisplay("-1+",'.'));
        assertEquals("-1+", displayed.updateDisplay("-1+",','));
    }

    @Test
    public void InputAfterDecimalAndOperatorTest() {
        assertEquals("1.0+1", displayed.updateDisplay("1.0+",'1'));
        assertEquals("1.0+2", displayed.updateDisplay("1.0+",'2'));
        assertEquals("1.0+3", displayed.updateDisplay("1.0+",'3'));
        assertEquals("1.0+4", displayed.updateDisplay("1.0+",'4'));
        assertEquals("1.0+5", displayed.updateDisplay("1.0+",'5'));
        assertEquals("1.0+6", displayed.updateDisplay("1.0+",'6'));
        assertEquals("1.0+7", displayed.updateDisplay("1.0+",'7'));
        assertEquals("1.0+8", displayed.updateDisplay("1.0+",'8'));
        assertEquals("1.0+9", displayed.updateDisplay("1.0+",'9'));
        assertEquals("1.0+0", displayed.updateDisplay("1.0+",'0'));
        assertEquals("1.0+", displayed.updateDisplay("1.0+",'+'));
        assertEquals("1.0-", displayed.updateDisplay("1.0+",'-'));
        assertEquals("1.0*", displayed.updateDisplay("1.0+",'*'));
        assertEquals("1.0/", displayed.updateDisplay("1.0+",'/'));
        assertEquals("1.0+", displayed.updateDisplay("1.0+",'.'));
        assertEquals("1.0+", displayed.updateDisplay("1.0+",','));
        assertEquals("-1.0+1", displayed.updateDisplay("-1.0+",'1'));
        assertEquals("-1.0+2", displayed.updateDisplay("-1.0+",'2'));
        assertEquals("-1.0+3", displayed.updateDisplay("-1.0+",'3'));
        assertEquals("-1.0+4", displayed.updateDisplay("-1.0+",'4'));
        assertEquals("-1.0+5", displayed.updateDisplay("-1.0+",'5'));
        assertEquals("-1.0+6", displayed.updateDisplay("-1.0+",'6'));
        assertEquals("-1.0+7", displayed.updateDisplay("-1.0+",'7'));
        assertEquals("-1.0+8", displayed.updateDisplay("-1.0+",'8'));
        assertEquals("-1.0+9", displayed.updateDisplay("-1.0+",'9'));
        assertEquals("-1.0+0", displayed.updateDisplay("-1.0+",'0'));
        assertEquals("-1.0+", displayed.updateDisplay("-1.0+",'+'));
        assertEquals("-1.0-", displayed.updateDisplay("-1.0+",'-'));
        assertEquals("-1.0*", displayed.updateDisplay("-1.0+",'*'));
        assertEquals("-1.0/", displayed.updateDisplay("-1.0+",'/'));
        assertEquals("-1.0+", displayed.updateDisplay("-1.0+",'.'));
        assertEquals("-1.0+", displayed.updateDisplay("-1.0+",','));
    }

    @Test
    public void DecimalAfterDecimalAndOperatorTest() {
        assertEquals("1.0+1.1", displayed.updateDisplay("1.0+1.",'1'));
        assertEquals("1.0+1.2", displayed.updateDisplay("1.0+1.",'2'));
        assertEquals("1.0+1.3", displayed.updateDisplay("1.0+1.",'3'));
        assertEquals("1.0+1.4", displayed.updateDisplay("1.0+1.",'4'));
        assertEquals("1.0+1.5", displayed.updateDisplay("1.0+1.",'5'));
        assertEquals("1.0+1.6", displayed.updateDisplay("1.0+1.",'6'));
        assertEquals("1.0+1.7", displayed.updateDisplay("1.0+1.",'7'));
        assertEquals("1.0+1.8", displayed.updateDisplay("1.0+1.",'8'));
        assertEquals("1.0+1.9", displayed.updateDisplay("1.0+1.",'9'));
        assertEquals("1.0+1.0", displayed.updateDisplay("1.0+1.",'0'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",'+'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",'-'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",'*'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",'/'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",'.'));
        assertEquals("1.0+1.", displayed.updateDisplay("1.0+1.",','));
        assertEquals("-1.0+1.1", displayed.updateDisplay("-1.0+1.",'1'));
        assertEquals("-1.0+1.2", displayed.updateDisplay("-1.0+1.",'2'));
        assertEquals("-1.0+1.3", displayed.updateDisplay("-1.0+1.",'3'));
        assertEquals("-1.0+1.4", displayed.updateDisplay("-1.0+1.",'4'));
        assertEquals("-1.0+1.5", displayed.updateDisplay("-1.0+1.",'5'));
        assertEquals("-1.0+1.6", displayed.updateDisplay("-1.0+1.",'6'));
        assertEquals("-1.0+1.7", displayed.updateDisplay("-1.0+1.",'7'));
        assertEquals("-1.0+1.8", displayed.updateDisplay("-1.0+1.",'8'));
        assertEquals("-1.0+1.9", displayed.updateDisplay("-1.0+1.",'9'));
        assertEquals("-1.0+1.0", displayed.updateDisplay("-1.0+1.",'0'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",'+'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",'-'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",'*'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",'/'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",'.'));
        assertEquals("-1.0+1.", displayed.updateDisplay("-1.0+1.",','));
    }
}