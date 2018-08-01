package com.szczepanski.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {

    private String operator;
    private BigDecimal firstVal;
    private BigDecimal result;
    private Display display = new Display();

    private String getOperator() {
        return "\\" + operator;
    }

    private void setOperator(String value) {
        if (value.charAt(0) == '-') {
            value = value.substring(1);
        }
        if (value.contains("+")) {
            this.operator = "+";
        } else if (value.contains("*")) {
            this.operator = "*";
        } else if (value.contains("/")) {
            this.operator = "/";
        } else if (value.contains("-"))
            this.operator = "-";
    }

    private String cutZeroes(String input) {
        if (isNotDecimal(input)) {
            return input;
        } else {
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

    public boolean isNotDecimal(String value) {
        return !value.contains(".") && !value.contains(",");

    }

    public String makeCalculation(String value) {
        if (!display.isProperInput(value))
            return "ERR!";
        setOperator(value);
        String[] split = value.split(getOperator());
        if (split[0].equals("")) {
            split = value.substring(1).split(getOperator());
            firstVal = BigDecimal.valueOf(Double.parseDouble(split[0])).negate();
        } else
        firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));

        switch (getOperator()) {
            case "\\+":
                result = firstVal.add(BigDecimal.valueOf(Double.parseDouble(split[1])));
                break;
            case "\\*":
                result = firstVal.multiply(BigDecimal.valueOf(Double.parseDouble(split[1])));
                break;
            case "\\/":
                if (split[1].equals("0") || split[1].equals("") || split[1] == null)
                    return "ERR!";
                else
                    result = firstVal.divide(BigDecimal.valueOf(Double.parseDouble(split[1])), 10, RoundingMode.HALF_UP);
                break;
            case "\\-":
                result = firstVal.subtract(BigDecimal.valueOf(Double.parseDouble(split[1])));
                break;
        }
        return cutZeroes(String.valueOf(result));
    }

    public String squareRoot(String value) {
        if (value.charAt(0) == '-' || !display.isProperInput(value) || display.isLastCharAnOperator(value))
            return "ERR!";
        result = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(value)));
        return cutZeroes(String.valueOf(result));
    }

    public String square(String value) {
        if (!display.isProperInput(value) || display.isLastCharAnOperator(value))
            return "ERR!";
        result = BigDecimal.valueOf(Math.pow(Double.parseDouble(value), 2));
        return cutZeroes(String.valueOf(result));
    }

    public String negate(String value) {
        if (!display.isProperInput(value) || display.isLastCharAnOperator(value))
            return "ERR!";
        result = BigDecimal.valueOf(Double.parseDouble(value)).negate();
        return cutZeroes(String.valueOf(result));
    }
}
