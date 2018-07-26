package com.szczepanski.calc;

import android.widget.TextView;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class OperationTest {

    private TextView textView =  Mockito.mock(TextView.class);

    @Test
    public void addingTest() {
        Operation operation = new Operation();
        textView.setText("2+3");
        assertEquals("5", operation.add(textView));
    }
}