package com.szczepanski.calc;

import java.util.ArrayList;

public class Displayed {

    private final ArrayList<Character> nonAlphabetical = new ArrayList<>();
    private final ArrayList<Character> operators = new ArrayList<>();

    public Displayed() {
        fillNonAlphabetical();
        fillOperators();
    }

    private void fillNonAlphabetical() {
        nonAlphabetical.add('1');
        nonAlphabetical.add('2');
        nonAlphabetical.add('3');
        nonAlphabetical.add('4');
        nonAlphabetical.add('5');
        nonAlphabetical.add('6');
        nonAlphabetical.add('7');
        nonAlphabetical.add('8');
        nonAlphabetical.add('9');
        nonAlphabetical.add('0');
        nonAlphabetical.add('+');
        nonAlphabetical.add('-');
        nonAlphabetical.add('*');
        nonAlphabetical.add('/');
        nonAlphabetical.add('=');
        nonAlphabetical.add('.');
        nonAlphabetical.add(',');
    }

    private void fillOperators() {
        operators.add('+');
        operators.add('*');
        operators.add('/');
        operators.add('-');
    }

    private boolean isOperator(char input) {
        return operators.contains(input);
    }

    private boolean isProperDecimal(String input) {

        int counter = 0;

        char[] inputCharArr;

        if (input.charAt(0) == '-') {
            inputCharArr = input.substring(1).toCharArray();
        } else if (!Character.isDigit(input.charAt(0))) {
            return false;
        } else {
            inputCharArr = input.toCharArray();
        }

        for (int i = 0; i < inputCharArr.length; i++) {
            if (!nonAlphabetical.contains(inputCharArr[i])) {
                return false;
            }
            if (i > 0 && (inputCharArr[i - 1] == '.' || inputCharArr[i - 1] == ',') && isOperator(inputCharArr[i])) {
                return false;
            }

            if (i > 0 && isOperator(inputCharArr[i - 1]) && isOperator(inputCharArr[i])) {
                if (i + 1 < inputCharArr.length && inputCharArr[i - 1] != '-' && inputCharArr[i] == '-' && Character.isDigit(inputCharArr[i + 1])) {
                    return true;
                } else return false;

            }
            if (inputCharArr[i] == '.' || inputCharArr[i] == ',') {
                counter++;
            }
            if (isOperator(inputCharArr[i])) {
                counter = 0;
            }
            if (counter > 1) {
                return false;
            }
        }

        for (int i = 0; i < inputCharArr.length; i++) {
            if (inputCharArr[i] == '.' || inputCharArr[i] == ',') {
                if (i > 0 && inputCharArr[i - 1] == '.' && inputCharArr[i - 1] == ',') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isProperInput(String input) {
        return isProperDecimal(input);
    }

}
