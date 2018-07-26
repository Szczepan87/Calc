package com.szczepanski.calc;

public class Operation {

    //sprawdza zero
    private boolean isZero() {
        if (operation.equals("0") && resultTextView.getText().equals("0"))
            return true;
        else return false;
    }

    //sprawdza, czy na ekranie nie ma operatora
    private boolean hasNonOperator() {
        if (operation.contains("+"))
            return false;
        else if (operation.contains("-"))
            return false;
        else if (operation.contains("*"))
            return false;
        else if (operation.contains("/"))
            return false;
        return true;
    }

    //rozpoznaje operator
    private void setOperator(char operator) {
        if (operator == '+')
            this.operator = 1;
        else if (operator == '-')
            this.operator = 2;
        else if (operator == '*')
            this.operator = 3;
        else if (operator == '/')
            this.operator = 4;
    }

    private String getOperator() {
        if (operator == 1)
            return "+";
        else if (operator == 2)
            return "-";
        else if (operator == 3)
            return "*";
        else if (operator == 4)
            return "/";
        else return "";
    }
}
