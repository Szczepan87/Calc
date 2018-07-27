package com.szczepanski.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation implements BasicCalcOperations {

    private String operator;
    private BigDecimal firstVal;
    private BigDecimal result;

    private String getOperator() {
        return "\\" + operator;
    }

    private void setOperator(String value) {
        if (value.charAt(0) == '-') {
            value = value.substring(1);
        }
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
        if (isNotDecimal(input))
            return input;
        else {
            for (int i = input.length() - 1; i >= 0; i--) {
                if (input.charAt(input.length() - 1) == '.' || input.charAt(input.length() - 1) == ',') {
                    input = String.valueOf(new StringBuilder(input).deleteCharAt(input.length() - 1));
                    break;
                }
                if (input.charAt(i) != '0') {
                    break;
                }
                input = String.valueOf(new StringBuilder(input).deleteCharAt(i));
            }
        }
        return input;
    }

    private boolean isNotDecimal(String value) {
        if (value.contains("."))
            return false;
        else if (value.contains(","))
            return false;
        else return true;

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
        setOperator(value);
        String[] split = value.split(getOperator());
        firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));
        result = firstVal.subtract(BigDecimal.valueOf(Double.parseDouble(split[1])));
        return cutZeroes(String.valueOf(result));
    }

    @Override
    public String multiply(String value) {
        setOperator(value);
        String[] split = value.split(getOperator());
        firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));
        result = firstVal.multiply(BigDecimal.valueOf(Double.parseDouble(split[1])));
        return cutZeroes(String.valueOf(result));
    }

    @Override
    public String divide(String value) {
        setOperator(value);
        String[] split = value.split(getOperator());
        if (split[1].equals("0") || split[1].equals("") || split[1] == null)
            return "ERR!";
        firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));
        result = firstVal.divide(BigDecimal.valueOf(Double.parseDouble(split[1])), 10, RoundingMode.HALF_UP);
        return cutZeroes(String.valueOf(result));
    }
}
