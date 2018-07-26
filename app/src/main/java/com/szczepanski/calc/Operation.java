package com.szczepanski.calc;

import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {

    private final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private final int ROUND = 10;
    private BigDecimal result;
    private BigDecimal fistVal;
    private BigDecimal secondVal;
    private int operator;


    //rozpoznaje operator
    private void setOperator(char operator) {
        if (operator == '+')
            this.operator = 1;
        else if (operator == '-')
            this.operator = 2;
        else if (operator == '*')
            this.operator = 3;
        else if (operator == '/')
            this.operator = 4;
    }

    private String getOperator() {
        if (operator == 1)
            return "+";
        else if (operator == 2)
            return "-";
        else if (operator == 3)
            return "*";
        else if (operator == 4)
            return "/";
        else return "";
    }

    public String add(TextView textView){
        String[] variable = textView.getText().toString().split(getOperator());
        fistVal = BigDecimal.valueOf(Double.parseDouble(variable[0]));
        secondVal = BigDecimal.valueOf(Double.parseDouble(variable[1]));
        result = fistVal.add(secondVal);

        return String.valueOf(result);
    }


}
