package com.szczepanski.calc;

import java.math.BigDecimal;

public class Operation implements BasicCalcOperations {

    private String operator;
    private BigDecimal firstVal;
    private BigDecimal result;

    private String getOperator() {
        return "\\" + operator;
    }

    private void setOperator(String value) {
        if (value.contains("+"))
            this.operator = "+";
        else if (value.contains("-"))
            this.operator = "-";
        else if (value.contains("*"))
            this.operator = "*";
        else if (value.contains("/"))
            this.operator = "/";
    }

    private String cutZeroes(String input) {
        if (!input.contains(".") || !input.contains(","))
            return input;
        for (int i = input.length() - 1; i <= 0; i--) {
            if (input.charAt(i) != '0' || input.charAt(i) == '.' || input.charAt(i) == ',')
                break;
            if (input.charAt(i) == '0')
                input = String.valueOf(new StringBuilder().deleteCharAt(i));
        }
        return input;
    }

    @Override
    public String add(String value) {
        setOperator(value);
        String[] split = value.split(getOperator());
        firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));
        result = firstVal.add(BigDecimal.valueOf(Double.parseDouble(split[1])));
        return cutZeroes(String.valueOf(result));
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
