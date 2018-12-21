package com.szczepanski.calc;

import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

class Operation {

    private String operator;
    private BigDecimal result = new BigDecimal(0);
    private BigDecimal firstVal = new BigDecimal(0);
    private BigDecimal secondVal = new BigDecimal(0);
    private final List<Character> operators = Arrays.asList('+', '*', '/', '-');
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    private String getOperator() {
        return "\\" + operator;
    }

    private void setOperator(String value) {

        //pętla idzie od końca, pierwszy znak nie-liczba jest operatorem(chyba, że przed nim
        // jest operator wtedy to jest operator)

        for (int i = value.length(); i > 1; i--) {
            if (operators.contains(value.charAt(i)) && !operators.contains(value.charAt(i - 1)))
                operator = String.valueOf(value.charAt(i));
            else operator = String.valueOf(value.charAt(i - 1));
        }
//
//        if (value.charAt(0) == '-') {
//            value = value.substring(1);
//        }
//        if (value.contains("+")) {
//            this.operator = "+";
//        } else if (value.contains("*")) {
//            this.operator = "*";
//        } else if (value.contains("/")) {
//            this.operator = "/";
//        } else if (value.contains("-"))
//            this.operator = "-";
    }

    boolean isNotNumerical(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '-') {
                return true;
            }
        }
        return false;
    }

    private String resultDisplayed(BigDecimal result) {
        result = result.stripTrailingZeros();
        return decimalFormat.format(result).replace(',', '.');
    }

    @NonNull
    String makeCalculation(String value) {

        // rodzielenie funkcji wyznaczenia zmiennych do działania do innej metody typu void,
        // która będzie setterem dla wartości typu BigDecimal firstVal i secondVal
        setVariablesForCalculation(value);

        switch (getOperator()) {
            case "\\+":
                result = firstVal.add(secondVal);
                break;
            case "\\*":
                result = firstVal.multiply(secondVal, MathContext.DECIMAL64);
                break;
            case "\\/":
                if (secondVal.equals(BigDecimal.valueOf(0)))
                    return "ERR!";
                else
                    result = firstVal.divide((secondVal), 10, RoundingMode.HALF_UP);
                break;
            case "\\-":
                result = firstVal.subtract(secondVal);
                break;
        }
        this.operator = null;
        return resultDisplayed(result);
    }

    private void setVariablesForCalculation(String value) {
        setOperator(value);

        if (getOperator().equals("-")){
            //procedura na rozpoznanie 1, 2 i 3 minusów
        }

        String[] split = value.split(getOperator());
        if (split.length < 2) {
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
    }

    String squareRoot(String value) {
        if (value.charAt(0) == '-' || !Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(value))).setScale(10, RoundingMode.HALF_EVEN);
        return resultDisplayed(result);
    }

    String square(String value) {
        if (!Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Math.pow(Double.parseDouble(value), 2));
        return resultDisplayed(result);
    }

    String negate(String value) {
        if (!Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        result = BigDecimal.valueOf(Double.parseDouble(value)).negate();
        return resultDisplayed(result);
    }
}
