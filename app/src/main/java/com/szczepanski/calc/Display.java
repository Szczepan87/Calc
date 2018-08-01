package com.szczepanski.calc;

public class Display {

    private final char[] operators = new char[]{'+', '-', '*', '/'};

    private final char[] properInput = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ',', '.', '+', '-', '*', '/'};

    public boolean isLastCharAnOperator(String input) {
        for (char operator : operators) {
            if (input.charAt(input.length() - 1) == operator)
                return true;
        }
        return false;
    }

    public boolean isProperInput(String input) {
        char[] inputArr = input.toCharArray();
        int counter = 0;
        for (char anInputArr : inputArr) {
            for (char aProperInput : properInput) {
                if (anInputArr == aProperInput)
                    counter++;
            }
        }
        return counter == input.length();
    }

    public boolean isZero(String input) {
        return input.equals("0");
    }

    public String updateDisplay(String onScreen, String value) {
        if (isProperInput(value)) {
            if (isZero(onScreen)&& !value.equals(".")) {
                onScreen = onScreen.replace("0", value);
            } else if (isLastCharAnOperator(onScreen) && isLastCharAnOperator(value)) {
                onScreen = onScreen.replace(String.valueOf(onScreen.charAt(onScreen.length() - 1)), value);
            } else {
                onScreen += value;
            }
        }
        return onScreen;
    }
}
