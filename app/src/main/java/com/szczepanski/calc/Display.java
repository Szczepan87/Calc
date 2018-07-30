package com.szczepanski.calc;

public class Display {

    private final char[] operators = new char[]{'+', '-', '*', '/'};

    public boolean isLastCharAnOperator(String input) {
        for (char operator : operators) {
            if (input.charAt(input.length() - 1) == operator)
                return true;
        }
        return false;
    }

    public boolean isZero(String input){
        return input.equals("0");
    }

    public String updateDisplay(String onScreen, String value){
        onScreen += value;

        return onScreen;
    }
}
