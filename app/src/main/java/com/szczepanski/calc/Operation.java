package com.szczepanski.calc;

import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class Operation {

    private String operator;
    private BigDecimal result;
    private Displayed display = new Displayed();
    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");

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

    boolean isNotNumerical(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))&& value.charAt(i) != '-'){
                return true;
            }
        }
        return false;
    }

    private String resultDisplayed(BigDecimal result) {
        result = result.stripTrailingZeros();
        return decimalFormat.format(result).replace(',','.');
    }

    @NonNull
    String makeCalculation(String value) {
        setOperator(value);
        String[] split = value.split(getOperator());
        BigDecimal firstVal;
        if (!display.isProperInput(value) || split.length < 2) {
            return "ERR!";
        }
        if (this.operator == null) {
            return value;
        }
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
                result = firstVal.multiply(BigDecimal.valueOf(Double.parseDouble(split[1])), MathContext.DECIMAL64);
                break;
            case "\\/":
                if (split[1].equals("0") || split[1].equals("") || split[1].equals("ERR!"))
                    return "ERR!";
                else
                    result = firstVal.divide(BigDecimal.valueOf(Double.parseDouble(split[1])), 10, RoundingMode.HALF_UP);
                break;
            case "\\-":
                result = firstVal.subtract(BigDecimal.valueOf(Double.parseDouble(split[1])));
                break;
        }
        this.operator = null;
        return resultDisplayed(result);
    }

    String squareRoot(String value) {
        if (value.charAt(0) == '-' || !display.isProperInput(value) || !Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(value))).setScale(10,RoundingMode.HALF_EVEN);
        return resultDisplayed(result);
    }

    String square(String value) {
        if (!display.isProperInput(value) || !Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Math.pow(Double.parseDouble(value), 2));
        return resultDisplayed(result);
    }

    String negate(String value) {
        if (!display.isProperInput(value) || !Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Double.parseDouble(value)).negate();
        return resultDisplayed(result);
    }
}
