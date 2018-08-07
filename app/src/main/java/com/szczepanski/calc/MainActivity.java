package com.szczepanski.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    private Operation operation = new Operation();
    private Display display = new Display();

    private boolean operatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
    }

    //warunkuje jaki znak jest dodawany do stringa
    public void addOne(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "1"));
    }

    public void addTwo(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "2"));
    }

    public void addThree(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "3"));
    }

    public void addFour(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "4"));
    }

    public void addFive(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "5"));
    }

    public void addSix(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "6"));
    }

    public void addSeven(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "7"));
    }

    public void addEight(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "8"));
    }

    public void addNine(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "9"));
    }

    public void addZero(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "0"));
    }

    //ustawia dziesiętną reprezentację procenta(dzieli na 100)
    public void makePercent(View view) {
        if (operation.isNumerical(String.valueOf(resultTextView.getText())))
            resultTextView.setText(R.string.ERROR);
        else {
            String onScreen = resultTextView.getText().toString();
            String result = operation.makeCalculation(onScreen + "/100");
            resultTextView.setText(String.valueOf(result));
        }
    }

    //tworzy pierwiastek kwadratowy z wyniku
    public void makeSQRT(View view) {
        if (operation.isNumerical(String.valueOf(resultTextView.getText())))
            resultTextView.setText(R.string.ERROR);
        else {
            resultTextView.setText(operation.squareRoot(String.valueOf(resultTextView.getText())));
        }
    }

    //tworzy kwadrat z wyniku
    public void makeSquare(View view) {
        if (operation.isNumerical(String.valueOf(resultTextView.getText())))
            resultTextView.setText(R.string.ERROR);
        else {
            resultTextView.setText(operation.square(String.valueOf(resultTextView.getText())));
        }
    }

    //tworzy ułamek, którego mianownikiem jest wynik
    public void makeFraction(View view) {
        if (operation.isNumerical(String.valueOf(resultTextView.getText())))
            resultTextView.setText(R.string.ERROR);
        else {
            BigDecimal result = BigDecimal.valueOf(1.0).divide(BigDecimal.valueOf(Double.parseDouble
                    (String.valueOf(resultTextView.getText()))), 10, RoundingMode.HALF_UP);
            resultTextView.setText(String.valueOf(result));
        }

    }

    //kasuje wynik i zeruje stringa
    public void CEButton(View view) {
        resultTextView.setText("0");
    }

    //kasuje ostatnią operację, która jest wyświetlana, lecz wynik zostaje niezmieniony
    public void CButton(View view) {
        resultTextView.setText("0");
    }

    public void backspaceButton(View view) {
        if (resultTextView.length() <= 1) {
            resultTextView.setText("0");
        }
        if (!display.isZero(String.valueOf(resultTextView.getText())) &&
                !String.valueOf(resultTextView.getText()).equals("ERR!")) {

            StringBuilder builder = new StringBuilder(String.valueOf(resultTextView.getText()));

            resultTextView.setText(String.valueOf(builder.deleteCharAt(resultTextView.getText().length() - 1)));
        }
    }

    public void divideButton(View view) {
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "/"));

    }

    public void multiplyButton(View view) {
        operatorClicked = true;
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "*"));

    }

    public void minusButton(View view) {
        operatorClicked = true;
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "-"));
    }

    public void plusButton(View view) {
        operatorClicked = true;
        resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "+"));
    }

    public void equalsButton(View view) {
        if (operatorClicked) {
            String onScreen = String.valueOf(resultTextView.getText());
            resultTextView.setText(operation.makeCalculation(onScreen));
        }
    }

    public void negateButton(View view) {
        resultTextView.setText(operation.negate(String.valueOf(resultTextView.getText())));
    }

    public void pointButton(View view) {
        if (operation.isNotDecimal(String.valueOf(resultTextView.getText())) || operatorClicked) {
            resultTextView.setText(display.updateDisplay(resultTextView.getText().toString(), "."));
        }
    }
}

