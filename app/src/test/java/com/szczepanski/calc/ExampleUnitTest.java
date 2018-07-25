package com.szczepanski.calc;

import android.widget.TextView;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{

    TextView textView;

    @Test
    public void multiplyTest(){
        BigDecimal firstVal = BigDecimal.valueOf(Double.valueOf("12.0"));
        BigDecimal secondVal = BigDecimal.valueOf(Double.valueOf("10.0"));
        BigDecimal result = firstVal.multiply(secondVal);
        assertEquals(120.0,result);
    }

    @Test
    public void textViewTest() {
        textView.setText("ABCD");
        assertEquals("ABCD", textView.getText());
    }
}