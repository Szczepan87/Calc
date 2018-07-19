package com.szczepanski.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    String operations = "";

    BigDecimal result = new BigDecimal(String.valueOf(resultTextView));


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
    private boolean isZero() {
        if (result != null && !operations.equals("")) {
            if (operations.charAt(0) == '0')
                return true;
            else if (operations.equals("0"))
                return true;
            else if (operations.equals(""))
                return true;
            else if (operations.length() == 0)
                return true;
            else if (result.intValue() == 0)
                return true;
            else return false;
        }
        return false;
    }

    //dokleja znak do stringa
    private void updateTextView(String text) {
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
        if (!isZero())
            updateTextView("0");
    }

    //ustawia dziesiętną reprezentację procenta(dzieli na 100)
    public void makePercent(View view) {
        result = new BigDecimal(Double.valueOf(operations) / 100);
        result = result.setScale(2, RoundingMode.HALF_UP); // zaokrąglenie do dwóch miejsc po przecinku
        operations = String.valueOf(result);
        resultTextView.setText(operations);
    }

    //tworzy pierwiastek kwadratowy z wyniku
    public void makeSQRT(View view) {
        result = new BigDecimal(Math.sqrt(Double.valueOf(operations)));
        result = result.setScale(6, RoundingMode.HALF_UP);
        operations = String.valueOf(result);
        operations = operations.replace(".000000", "");
        resultTextView.setText(operations);
    }

    //tworzy kwadrat z wyniku
    public void makeSquare(View view) {
        result = new BigDecimal(Math.pow(Double.valueOf(operations), 2));
        operations = String.valueOf(result);
        resultTextView.setText(operations);
    }

    //tworzy ułamek, którego mianownikiem jest wynik
    public void makeFraction(View view) {
        result = new BigDecimal(1 / Double.valueOf(operations));
        result = result.setScale(6, RoundingMode.HALF_UP);
        operations = String.valueOf(result);
        operations = operations.replace(".000000", "");
        resultTextView.setText(operations);
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
        if (!isOperator() && !isZero())
            updateTextView("/");
    }

    public void multiplyButton(View view) {
        if (!isOperator())
            updateTextView("*");
    }

    public void minusButton(View view) {
        if (!isOperator())
            updateTextView("-");
    }

    public void plusButton(View view) {
        if (!isOperator())
            updateTextView("+");
    }

    public void equalsButton(View view) {

    }

    public void negateButton(View view) {
        if (!isZero()) {
            result = new BigDecimal(Double.valueOf(operations)).negate();
            operations = String.valueOf(result);
            resultTextView.setText(operations);
        } else resultTextView.setText("0");
    }

    public void pointButton(View view) {
        updateTextView(".");
    }
}
