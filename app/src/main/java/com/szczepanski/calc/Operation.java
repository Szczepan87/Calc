package com.szczepanski.calc;

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

    /**
     * Standard getter for the operator with a two escape characters before it to avoid errors.
     * @return String operator
     */
    private String getOperator() {
        return "\\" + operator;
    }

    /**
     * Sets the operator for later calculations. Starting from the end of the String it finds first
     * non digit value and checks if it is one of the four specified mathematical operators. Also if
     * the searched character is a '-' sign it checks if a neighbouring character is an operator. If
     * that's true it sets the operator to the neighbouring character.
     * @param value String from which the operator is extracted.
     * @see String makeCalculation
     */
    private void setOperator(String value) {

        for (int i = value.length() - 1; i >= 1; i--) {

            if (!Character.isDigit(value.charAt(i))) {

                if (operators.contains(value.charAt(i)) && !operators.contains(value.charAt(i - 1))) {
                    operator = String.valueOf(value.charAt(i));
                    break;
                } else if (value.charAt(i) == '-' && operators.contains(value.charAt(i - 1))) {
                    operator = String.valueOf(value.charAt(i - 1));
                    break;
                }
            }
        }
    }

    boolean isNotNumerical(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '-') {
                return true;
            }
        }
        return false;
    }

    /**
     * Prepares a string to be displayed on screen. It removes unnecessary zeroes at the end of the
     * result and replaces ',' decimal separator to '.'
     *
     * @param result a BigDecimal to be prepared
     * @return String to be showed on screen.
     */
    private String resultDisplayed(BigDecimal result) {
        result = result.stripTrailingZeros();
        return decimalFormat.format(result).replace(',', '.');
    }

    /**
     * Performs appropriate mathematical operation depending on operator value. After the operation
     * the operator value is set back to null.
     *
     * @param value String for performing the appropriate mathematical operation.
     * @return String of the result of the mathematical operation to be displayed on screen.
     */
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
                if (secondVal.equals(BigDecimal.valueOf(0.0)))
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

    /**
     * Sets BigDecimal firstVal and BigDecimal secondVal for later calculations. It uses split
     * method for separating the necessary values. Checks if the first character is '-'. If that
     * is so then the firstVal becomes a negative from split[1] array.
     *
     * @param value String from which the BigDecimal firstVal adn BigDecimal secondVal are set.
     */
    private void setVariablesForCalculation(String value) {
        setOperator(value);

        String[] split = value.split(getOperator());

        if (getOperator().equals("\\-") && value.charAt(0) == '-') {
            firstVal = BigDecimal.valueOf(Double.parseDouble(split[1])).negate();
            secondVal = BigDecimal.valueOf(Double.parseDouble(split[2]));
        } else {
            firstVal = BigDecimal.valueOf(Double.parseDouble(split[0]));
            secondVal = BigDecimal.valueOf(Double.parseDouble(split[1]));
        }
    }

    /**
     * Checks for a non digit value from the end of the String and for a minus sign at the beginning.
     * If the value is a positive number it makes this a square root with a RoundingMode of HALF_EVEN
     * and a scale of 10.
     *
     * @param value String to be modified.
     * @return a String to be showed on the screen. If the value represents an mathematical
     * operation or a negative number returns an "ERR!".
     */
    String squareRoot(String value) {
        if (value.charAt(0) == '-' || !Character.isDigit(value.charAt(value.length() - 1)))
            return "ERR!";
        else for (int i = value.length() - 1; i >= 1; i--) {
            if (!Character.isDigit(value.charAt(i))) return "ERR!";
        }
        result = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(value)))
                .setScale(10, RoundingMode.HALF_EVEN);
        return resultDisplayed(result);
    }

    /**
     * Checks for a non digit value from the end of the String. If the value is a number
     * it makes this number a power of 2.
     *
     * @param value String to be modified.
     * @return a String to be showed on the screen. If the value represents an mathematical
     * operation returns an "ERR!".
     */
    String square(String value) {
        for (int i = value.length() - 1; i >= 1; i--) {
            if (!Character.isDigit(value.charAt(i))) return "ERR!";
        }
        result = BigDecimal.valueOf(Math.pow(Double.parseDouble(value), 2));
        return resultDisplayed(result);
    }

    /**
     * Checks for a non digit value from the end of the String. If the value is a number it reverses
     * the number value from positive to negative and negative to positive.
     *
     * @param value String to be modified.
     * @return a String to be showed on the screen. If the value represents an mathematical
     * operation returns an "ERR!".
     */
    String negate(String value) {
        for (int i = value.length() - 1; i >= 1; i--) {
            if (!Character.isDigit(value.charAt(i))) return "ERR!";
        }
        result = BigDecimal.valueOf(Double.parseDouble(value)).negate();
        return resultDisplayed(result);
    }
}
