package com.szczepanski.calc;

import java.util.Arrays;
import java.util.List;

class Displayed {

    private final List<Character> nonAlphabetical = Arrays.asList('1','2','3','4','5','6','7','8','9','0','+','-','*','/','.');
    private final List<Character> operators = Arrays.asList('+','*','/','-');

    private boolean isOperator(char input) {
        return operators.contains(input);
    }

    private boolean isProperInput(String onScreen, Character input) {
        if (operators.contains(input)) {
            return canOperatorBeConcat(onScreen);
        } else if (input == '0'){
            return canZeroBeConcat(onScreen);
        } else if ((input == '.') || (input == ',')){
            return canPointBeConcat(onScreen);
        } else return false;
    }

    private boolean canPointBeConcat(String onScreen) {
        return false;
    }

    private boolean canZeroBeConcat(String onScreen) {
        return false;
    }

    private boolean canOperatorBeConcat(String onScreen) {
        return false;
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
        if (isProperInput(s,value)) {
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
