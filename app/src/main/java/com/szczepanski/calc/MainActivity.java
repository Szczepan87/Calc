package com.szczepanski.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    protected TextView resultTextView;
    private String operations = "";


    private final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private final int ROUND = 10;
    private BigDecimal result;
    private BigDecimal fistVal;
    private BigDecimal secondVal;

    private int operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);

    }

    //sprawdza czy poprzedni znak jest liczbą
    private boolean isOperator() {
        if (operations.charAt(operations.length() - 1) == '/')
            return true;
        else if (operations.charAt(operations.length() - 1) == '*')
            return true;
        else if (operations.charAt(operations.length() - 1) == '-')
            return true;
        else if (operations.charAt(operations.length() - 1) == '+')
            return true;
        else if (operations.charAt(operations.length() - 1) == '.')
            return true;
        else if (operations.charAt(operations.length() - 1) == ',')
            return true;
        else return false;
    }

    //sprawdza zero
    private boolean isNotZero() {
        return result != null && !operations.equals("");
    }

    //sprawdza, czy na ekranie nie ma operatora
    private boolean hasNonOperator() {
        if (operations.contains("+"))
            return false;
        else if (operations.contains("-"))
            return false;
        else if (operations.contains("*"))
            return false;
        else if (operations.contains("/"))
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

    //dokleja znak do stringa
    private void updateTextView(String text) {
        resultTextView = findViewById(R.id.resultTextView);
        this.operations += text;
        resultTextView.setText(operations);
    }

    //warunkuje jaki znak jest dodawany do stringa
    public void addOne(View view) {
        updateTextView("1");
    }

    public void addTwo(View view) {
        updateTextView("2");
    }

    public void addThree(View view) {
        updateTextView("3");
    }

    public void addFour(View view) {
        updateTextView("4");
    }

    public void addFive(View view) {
        updateTextView("5");
    }

    public void addSix(View view) {
        updateTextView("6");
    }

    public void addSeven(View view) {
        updateTextView("7");
    }

    public void addEight(View view) {
        updateTextView("8");
    }

    public void addNine(View view) {
        updateTextView("9");
    }

    public void addZero(View view) {
        if (isNotZero())
            updateTextView("0");
    }

    //ustawia dziesiętną reprezentację procenta(dzieli na 100)
    public void makePercent(View view) {
        if (!isOperator() && hasNonOperator()) {
            result = new BigDecimal(Double.valueOf(operations) / 100);
            result = result.setScale(ROUND, ROUNDING_MODE); // zaokrąglenie do 10 miejsc po przecinku
            operations = String.valueOf(result);
            resultTextView.setText(operations);
        }
    }

    //tworzy pierwiastek kwadratowy z wyniku
    public void makeSQRT(View view) {
        if (!isOperator() && hasNonOperator()) {
            result = new BigDecimal(Math.sqrt(Double.valueOf(operations)));
            result = result.setScale(ROUND, ROUNDING_MODE);
            operations = String.valueOf(result);
            operations = operations.replace(".000000", "");
            resultTextView.setText(operations);
        }
    }

    //tworzy kwadrat z wyniku
    public void makeSquare(View view) {
        if (!isOperator() && hasNonOperator()) {
            result = new BigDecimal(Math.pow(Double.valueOf(operations), 2));
            operations = String.valueOf(result);
            resultTextView.setText(operations);
        }
    }

    //tworzy ułamek, którego mianownikiem jest wynik
    public void makeFraction(View view) {
        if (isNotZero()) {
            result = new BigDecimal(1 / Double.valueOf(operations));
            result = result.setScale(ROUND, ROUNDING_MODE);
            operations = String.valueOf(result);
            resultTextView.setText(operations);
        } else {
            resultTextView.setText("0");
            result = BigDecimal.valueOf(0);
        }
    }

    //kasuje wynik i zeruje stringa
    public void CEButton(View view) {
        this.operations = "0";
        result = new BigDecimal(Double.valueOf(operations));
        resultTextView.setText(operations);
    }

    //kasuje ostatnią operację, która jest wyświetlana, lecz wynik zostaje niezmieniony
    public void CButton(View view) {
        this.operations = "0";
        resultTextView.setText(operations);
    }

    public void backspaceButton(View view) {
        StringBuilder builder = new StringBuilder(operations);
        operations = String.valueOf(builder.deleteCharAt(operations.length() - 1));
        if (operations.length() == 0) {
            resultTextView.setText("0");
        }
        resultTextView.setText(operations);
    }

    public void divideButton(View view) {
        if (!isOperator() && !isNotZero()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(operations));
            updateTextView("/");
            setOperator('/');
        }

    }

    public void multiplyButton(View view) {
        if (!isOperator()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(operations));
            updateTextView("*");
            setOperator('*');
        }
    }

    public void minusButton(View view) {
        if (!isOperator()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(operations));
            updateTextView("-");
            setOperator('-');
        }
    }

    public void plusButton(View view) {
        if (!isOperator()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(operations));
            updateTextView("+");
            setOperator('+');
        }

    }

    public void equalsButton(View view) {
        String[] numbers = operations.split(getOperator());
        secondVal = BigDecimal.valueOf(Double.valueOf(numbers[1]));

    }

    public void negateButton(View view) {
        if (isNotZero() && hasNonOperator()) {
            result = new BigDecimal(Double.valueOf(operations)).negate();
            operations = String.valueOf(result);
            resultTextView.setText(operations);
        } else {
            resultTextView.setText("0");
            result = BigDecimal.valueOf(0);
        }
    }

    public void pointButton(View view) {
        updateTextView(".");
    }
}
