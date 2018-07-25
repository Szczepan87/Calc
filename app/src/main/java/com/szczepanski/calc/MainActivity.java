package com.szczepanski.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    NumberFormat numberFormat = NumberFormat.getNumberInstance();
    private TextView resultTextView;
    String stringResutValue;

    private final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private final int ROUND = 10;
    private BigDecimal result;
    private BigDecimal fistVal;

    private int operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);

    }

    //sprawdza czy poprzedni znak jest liczbą
    private boolean isOperator() {
        if (stringResutValue.charAt(resultTextView.length() - 1) == '/')
            return true;
        else if (stringResutValue.charAt(resultTextView.length() - 1) == '*')
            return true;
        else if (stringResutValue.charAt(resultTextView.length() - 1) == '-')
            return true;
        else if (stringResutValue.charAt(resultTextView.length() - 1) == '+')
            return true;
        else if (stringResutValue.charAt(resultTextView.length() - 1) == '.')
            return true;
        else if (stringResutValue.charAt(resultTextView.length() - 1) == ',')
            return true;
        else return false;
    }

    //sprawdza zero
    private boolean isZero() {
        return result != null && !resultTextView.getText().equals("");
    }

    //sprawdza, czy na ekranie nie ma operatora
    private boolean hasNonOperator() {
        if (resultTextView.getText().toString().contains("+"))
            return false;
        else if (resultTextView.getText().toString().contains("-"))
            return false;
        else if (resultTextView.getText().toString().contains("*"))
            return false;
        else if (resultTextView.getText().toString().contains("/"))
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
    private void updateResultTextView(String text) {
        stringResutValue = String.valueOf(resultTextView.getText());
        stringResutValue = String.format("%s%s", String.valueOf(stringResutValue), text);
        resultTextView.setText(stringResutValue);
    }

    //warunkuje jaki znak jest dodawany do stringa
    public void addOne(View view) {
        updateResultTextView("1");
    }

    public void addTwo(View view) {
        updateResultTextView("2");
    }

    public void addThree(View view) {
        updateResultTextView("3");
    }

    public void addFour(View view) {
        updateResultTextView("4");
    }

    public void addFive(View view) {
        updateResultTextView("5");
    }

    public void addSix(View view) {
        updateResultTextView("6");
    }

    public void addSeven(View view) {
        updateResultTextView("7");
    }

    public void addEight(View view) {
        updateResultTextView("8");
    }

    public void addNine(View view) {
        updateResultTextView("9");
    }

    public void addZero(View view) {
        if (isZero())
            updateResultTextView("0");
    }

    //ustawia dziesiętną reprezentację procenta(dzieli na 100)
    public void makePercent(View view) {
        if (!isOperator() && hasNonOperator()) {
            stringResutValue = resultTextView.getText().toString().replace(",",".");
            result = new BigDecimal(Double.valueOf(stringResutValue) / 100);
            result = result.setScale(ROUND, ROUNDING_MODE);// zaokrąglenie do 10 miejsc po przecinku
            stringResutValue = String.valueOf(result);
            resultTextView.setText(stringResutValue);
        }
    }

    //tworzy pierwiastek kwadratowy z wyniku
    public void makeSQRT(View view) {
        if (!isOperator() && hasNonOperator()) {
            resultTextView.setText(numberFormat.format(resultTextView.getText()));
            result = new BigDecimal(Math.sqrt(Double.valueOf(String.valueOf(resultTextView))));
            result = result.setScale(ROUND, ROUNDING_MODE);
            resultTextView.setText(numberFormat.format(String.valueOf(result).replace(".000000", "")));
        }
    }

    //tworzy kwadrat z wyniku
    public void makeSquare(View view) {
        if (!isOperator() && hasNonOperator()) {
            result = new BigDecimal(Math.pow(Double.valueOf(String.valueOf(resultTextView)), 2));
            resultTextView.setText(String.valueOf(result));
        }
    }

    //tworzy ułamek, którego mianownikiem jest wynik
    public void makeFraction(View view) {
        if (isZero()) {
            result = new BigDecimal(1 / Double.valueOf(String.valueOf(resultTextView)));
            result = result.setScale(ROUND, ROUNDING_MODE);
            resultTextView.setText(String.valueOf(result));
        } else {
            resultTextView.setText("0");
            result = BigDecimal.valueOf(0);
        }
    }

    //kasuje wynik i zeruje stringa
    public void CEButton(View view) {
        resultTextView.setText(0);
        result = new BigDecimal(0);
    }

    //kasuje ostatnią operację, która jest wyświetlana, lecz wynik zostaje niezmieniony
    public void CButton(View view) {
        resultTextView.setText(0);
    }

    public void backspaceButton(View view) {
        StringBuilder builder = new StringBuilder(String.valueOf(resultTextView));
        if (resultTextView.length() == 0) {
            resultTextView.setText("0");
        }
        resultTextView.setText(String.valueOf(builder.deleteCharAt(resultTextView.length() - 1)));
    }

    public void divideButton(View view) {
        if (!isOperator() && !isZero()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(resultTextView)));
            updateResultTextView("/");
            setOperator('/');
        }
    }

    public void multiplyButton(View view) {
        if (!isOperator()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(resultTextView)));
            updateResultTextView("*");
            setOperator('*');
        }
    }

    public void minusButton(View view) {
        if (!isOperator()) {
            fistVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(resultTextView)));
            updateResultTextView("-");
            setOperator('-');
        }
    }

    public void plusButton(View view) {
        if (!isOperator()) {
            resultTextView = findViewById(R.id.resultTextView);
            fistVal = BigDecimal.valueOf(Double.parseDouble(String.valueOf(resultTextView)));
            updateResultTextView("+");
            setOperator('+');
        }
    }

    public void equalsButton(View view) {
        String number = String.valueOf(String.valueOf(resultTextView).substring(String.valueOf(resultTextView).indexOf(getOperator())+1));
        BigDecimal secondVal = BigDecimal.valueOf(Double.valueOf(number));
        switch (getOperator()) {
            case "+":
                result = fistVal.add(secondVal);
                break;
            case "-":
                result = fistVal.subtract(secondVal);
                break;
            case "*":
                result = fistVal.multiply(secondVal);
                break;
            case "/":
                result = fistVal.divide(secondVal).setScale(ROUND, ROUNDING_MODE);
                break;
        }
        result = result.setScale(ROUND, ROUNDING_MODE);
        resultTextView.setText(String.valueOf(result));
    }

    public void negateButton(View view) {
        if (isZero() && hasNonOperator()) {
            result = new BigDecimal(Double.valueOf(String.valueOf(resultTextView))).negate();
            resultTextView.setText(String.valueOf(result));
        } else {
            resultTextView.setText("0");
            result = BigDecimal.valueOf(0);
        }
    }

    public void pointButton(View view) {
        updateResultTextView(".");
    }
}
