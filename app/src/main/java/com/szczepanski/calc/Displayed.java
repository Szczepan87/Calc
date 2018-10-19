package com.szczepanski.calc;

import java.util.Arrays;
import java.util.List;

class Displayed {

    private final List<Character> nonAlphabetical = Arrays.asList('1','2','3','4','5','6','7','8','9','0','+','-','*','/','.');
    private final List<Character> operators = Arrays.asList('+','*','/','-');

    private boolean isOperator(char input) {
        return operators.contains(input);
    }

    boolean isProperInput(String input) {

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
                return i + 1 < inputCharArr.length && inputCharArr[i - 1] != '-' && inputCharArr[i] == '-' && Character.isDigit(inputCharArr[i + 1]);

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

    String updateDisplay(String onScreen, char value) {
        String s = onScreen + value;
        if (isOperator(onScreen.charAt(onScreen.length() - 1))) {
            if (value == '-' && (onScreen.charAt(onScreen.length() - 1) == '-' || onScreen.charAt(onScreen.length() - 1) == '+')) {
                onScreen = onScreen.replace(onScreen.charAt(onScreen.length() - 1), value);
                return onScreen;
            } else if (value == '-' && (onScreen.charAt(onScreen.length() - 1) == '*' || onScreen.charAt(onScreen.length() - 1) == '/'))
                return s;
        }
        if (isProperInput(s)) {
            if (onScreen.length() == 1 && onScreen.charAt(0) == '0' ) {
                if (isOperator(value) && (value == '-')) {
                    return String.valueOf(value);
                }
                else if (Character.isDigit(value)){
                    return String.valueOf(value);
                }
            }
            return s;
        } else return onScreen;
    }
}
