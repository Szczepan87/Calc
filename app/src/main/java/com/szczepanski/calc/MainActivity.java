package com.szczepanski.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    private Operation operation = new Operation();
    private Display display = new Display();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
    }

    //warunkuje jaki znak jest dodawany do stringa
    public void addOne(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"1");
    }

    public void addTwo(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"2");
    }

    public void addThree(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"3");
    }

    public void addFour(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"4");
    }

    public void addFive(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"5");
    }

    public void addSix(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"6");
    }

    public void addSeven(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"7");
    }

    public void addEight(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"8");
    }

    public void addNine(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"9");
    }

    public void addZero(View view) {
        display.updateDisplay(resultTextView.getText().toString(),"0");
    }

    //ustawia dziesiętną reprezentację procenta(dzieli na 100)
    public void makePercent(View view) {
        //resultTextView.setText(operation.percent(resultTextView));
    }

    //tworzy pierwiastek kwadratowy z wyniku
    public void makeSQRT(View view) {

    }

    //tworzy kwadrat z wyniku
    public void makeSquare(View view) {

    }

    //tworzy ułamek, którego mianownikiem jest wynik
    public void makeFraction(View view) {

    }

    //kasuje wynik i zeruje stringa
    public void CEButton(View view) {
        resultTextView.setText(0);
    }

    //kasuje ostatnią operację, która jest wyświetlana, lecz wynik zostaje niezmieniony
    public void CButton(View view) {
        resultTextView.setText(0);
    }

    public void backspaceButton(View view) {
        StringBuilder builder = new StringBuilder(String.valueOf(resultTextView.getText()));
        if (resultTextView.getText().length() == 0) {
            resultTextView.setText("0");
        }
        resultTextView.setText(String.valueOf(builder.deleteCharAt(resultTextView.getText().length() - 1)));
    }

    public void divideButton(View view) {

    }

    public void multiplyButton(View view) {

    }

    public void minusButton(View view) {

    }

    public void plusButton(View view) {

    }

    public void equalsButton(View view) {

    }

    public void negateButton(View view) {

    }

    public void pointButton(View view) {
        display.updateDisplay(resultTextView.getText().toString(),".");
    }
}
