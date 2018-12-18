package com.szczepanski.calc;

import java.util.Arrays;
import java.util.List;

/**
 * Class ensures the proper values to be shown and prepared for later calculation
 *
 * @author Łukasz Szczepański
 */
class Displayed {

    private final List<Character> operators = Arrays.asList('+', '*', '/', '-');

    private String ensureProperInput(String onScreen, Character input) {
        if (operators.contains(input)) {
            return outputForOperator(onScreen, input);
        } else if (input == '0') {
            return outputForZero(onScreen, input);
        } else if ((input == '.') || (input == ',')) {
            return outputForPoint(onScreen);
        } else if (onScreen.equals("0") || onScreen.equals("ERR!")) {
            return String.valueOf(input);
        } else return onScreen + input;
    }

    /**
     * Prepares output depending on String showed and character to be added ensuring proper
     * String value for later calculations.
     * For a single "0" on the screen it replaces onScreen String with input except '+', '*', '/'.
     * Replaces mathematical operator with a new one except '-' sign allowing operations
     * on negative numbers.
     * When an "ERR!" message is shown it is replaced with a new digit or a '-' sign.
     * @param onScreen String showed on screen to be concatenated.
     * @param input a character to be added to the on screen value.
     * @return new String composed of onScreen value and (if conditions met) input.
     * @see private canOperatorBeConcat(onScreen)
     */
    private String outputForOperator(String onScreen, Character input) {
        char lastCharacter = onScreen.charAt(onScreen.length() - 1);

        if (!canOperatorBeConcat(onScreen)) {
            return onScreen;
        } else {
            switch (lastCharacter) {
                case '0':
                    if (onScreen.length() == 1 && (Character.isDigit(input) || input.equals('-')))
                        onScreen = String.valueOf(input);
                    else onScreen += input;
                    break;
                case '-':
                    if (Character.isDigit(input)) onScreen += input;
                    break;
                case '+':
                    if (Character.isDigit(input) || input.equals('-')) onScreen += input;
                    else onScreen = new StringBuilder(onScreen)
                            .replace(onScreen.length() - 1, onScreen.length() - 1, String.valueOf(input))
                            .toString();
                    break;
                case '*':
                    if (Character.isDigit(input) || input.equals('-')) onScreen += input;
                    else onScreen = new StringBuilder(onScreen)
                            .replace(onScreen.length() - 1, onScreen.length() - 1, String.valueOf(input))
                            .toString();
                    break;
                case '/':
                    if (Character.isDigit(input) || input.equals('-')) onScreen += input;
                    else onScreen = new StringBuilder(onScreen)
                            .replace(onScreen.length() - 1, onScreen.length() - 1, String.valueOf(input))
                            .toString();
                    break;
                case '!':
                    if (Character.isDigit(input) || input.equals('-'))
                        onScreen = String.valueOf(input);
                    break;
            }
        }
        return onScreen+input;
    }

    /**
     * Prepares an output if a point separator is the character to be added to the onScreen value.
     *
     * @param onScreen String showed on screen to be concatenated.
     * @return new String with concatenated "." separator symbol after checking if pointer can be
     * added and there's no "ERR!" message showed on the screen.
     * @see private canPointBeConcat(String onScreen)
     */
    private String outputForPoint(String onScreen) {
        if (canPointBeConcat(onScreen) && !onScreen.equals("ERR!")) {
            return onScreen + ".";
        } else return onScreen.replace(',', '.');
    }

    /**
     * Checks if point separator can be added
     *
     * @param onScreen text showing on the screen to be checked
     * @return true if there are no other pointer separators
     * up to the first mathematical operator symbol
     */
    private boolean canPointBeConcat(String onScreen) {
        int pointCounter = 0;
        for (int i = onScreen.length() - 1; i > 0; i--) {
            if (operators.contains(onScreen.charAt(i))) break;
            if (onScreen.charAt(i) == '.' || onScreen.charAt(i) == ',') pointCounter++;
        }
        return pointCounter < 1;
    }

    /**
     * Prepares an output if a zero is the value to be concatenated.
     *
     * @param onScreen text showed on the screen.
     * @param input    a character to be added to the on screen value.
     * @return new String composed of concatenated values of onScreen and value. If there's "0" or
     * "ERR!" it replaces them with input
     */
    private String outputForZero(String onScreen, Character input) {
        if (onScreen.equals("0") || onScreen.equals("ERR!")) {
            return String.valueOf(input);
        } else return onScreen + input;
    }

    /**
     * Determines if a mathematical operator can be added to String showed on screen. Secures
     * proper String input for later calculation.
     *
     * @param onScreen text showed on the screen.
     * @return false:
     * if there're more than 3 minus signs are in the String
     * more than one mathematical operator (except minus) is present in the String
     */
    private boolean canOperatorBeConcat(String onScreen) {

        int operatorCounter = 0;
        int minusCounter = 0;

        for (int i = 0; i < onScreen.length(); i++) {
            if (onScreen.charAt(i) == '-') minusCounter++;
            if (operators.contains(onScreen.charAt(i)) && onScreen.charAt(i) != '-')
                operatorCounter++;
        }

        if (operatorCounter + minusCounter > 3) return false;
        else if (operatorCounter > 1) return false;
        else if (minusCounter > 3) return false;
        else return true;
    }

    /**
     * Concatenates char to the value showed on the screen after proper result is ensured.
     *
     * @param onScreen String value to be concatenated, showed on the screen.
     * @param input    character to be added.
     * @return String composed of onScreen and input.
     * @see private ensureProperInput(String onScreen, Character input)
     */
    String updateDisplay(String onScreen, Character input) {
        return ensureProperInput(onScreen, input);
    }
}
