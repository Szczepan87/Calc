package com.szczepanski.calc;

import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation implements BasicCalcOperations{

    private String onScreen;
    private String operator;

    @Override
    public String getOperator(String value) {
        if (value.contains("+"))
            this.operator = "+";
        else if (value.contains("-"))
            this.operator = "-";
        else if (value.contains("*"))
            this.operator = "*";
        else if (value.contains("/"))
            this.operator = "/";
        return operator;
    }

    @Override
    public String add(String value) {
        String[] split = value.split(operator)
        return null;
    }

    @Override
    public String subtract(String value) {
        return null;
    }

    @Override
    public String multiply(String value) {
        return null;
    }

    @Override
    public String divide(String value) {
        return null;
    }
}
