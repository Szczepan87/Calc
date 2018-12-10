package com.szczepanski.calc;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.szczepanski.calc.CurrencyConverter.Exchange;
import com.szczepanski.calc.CurrencyConverter.ExchangeRate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyActivity extends AppCompatActivity {

    class Task extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            exchange = new Exchange();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    initCurrencySpinner();
                }
            });
            return null;
        }

    }
    private Exchange exchange;
    private ExchangeRate exchangeRate;
    private String symbolSet;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");
    @BindView(R.id.currencyValueEditText)
    EditText currencyValueEditText;
    @BindView(R.id.currencySpinner)
    Spinner currencySpinner;
    @BindView(R.id.currencyResultTextView)
    TextView currencyResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        new Task().execute();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.outline_money_on_white_24dp);
        getSupportActionBar().setTitle(R.string.currency_convert);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu,menu);
        ButterKnife.bind(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calc:
                Intent intent = new Intent(CurrencyActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.unitConvert:
                Intent intent2 = new Intent(CurrencyActivity.this, UnitActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initCurrencySpinner(){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, exchange.getListOfExchangeRatesSymbols());
        currencySpinner.setAdapter(adapter);

        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // porównywanie do listy
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CurrencyActivity.this, exchange.getListOfExchangeRates().get(i).getFullName(), Toast.LENGTH_LONG).show();
                if (adapterView.getSelectedItem().equals("USD")){
                    symbolSet = "USD";
                }
                else if (adapterView.getSelectedItem().equals("EUR")){
                    symbolSet = "EUR";
                }
                else if (adapterView.getSelectedItem().equals("RUB")){
                    symbolSet = "RUB";
                }
                else if (adapterView.getSelectedItem().equals("BYR")){
                    symbolSet = "BYR";
                }
                else if (adapterView.getSelectedItem().equals("UAH")){
                    symbolSet = "UAH";
                }
                else if (adapterView.getSelectedItem().equals("HUF")){
                    symbolSet = "HUF";
                }
                else if (adapterView.getSelectedItem().equals("CZK")){
                    symbolSet = "CZK";
                }
                else if (adapterView.getSelectedItem().equals("MDL")){
                    symbolSet = "MDL";
                }
                else if (adapterView.getSelectedItem().equals("RON")){
                    symbolSet = "RON";
                }
                else if (adapterView.getSelectedItem().equals("BGN")){
                    symbolSet = "BGN";
                }
                else if (adapterView.getSelectedItem().equals("DKK")){
                    symbolSet = "DKK";
                }
                else if (adapterView.getSelectedItem().equals("SEK")){
                    symbolSet = "SEK";
                }
                else if (adapterView.getSelectedItem().equals("NOK")){
                    symbolSet = "NOK";
                }
                else if (adapterView.getSelectedItem().equals("ISK")){
                    symbolSet = "ISK";
                }
                else if (adapterView.getSelectedItem().equals("HRK")){
                    symbolSet = "HRK";
                }
                else if (adapterView.getSelectedItem().equals("RSD")){
                    symbolSet = "RSD";
                }
                else if (adapterView.getSelectedItem().equals("ALL")){
                    symbolSet = "ALL";
                }
                else if (adapterView.getSelectedItem().equals("TRY")){
                    symbolSet = "TRY";
                }
                else if (adapterView.getSelectedItem().equals("CHF")){
                    symbolSet = "CHF";
                }
                else if (adapterView.getSelectedItem().equals("GBP")){
                    symbolSet = "GBP";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(CurrencyActivity.this, R.string.please_select_value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initExchangeRate() {
        List<ExchangeRate> list = exchange.getListOfExchangeRates();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSymbol().equals(symbolSet)){
                exchangeRate = list.get(i);
            }
        }
    }

    // nasłuchiwanie na kliknięcie enter na klawiaturze i ustawienie wyniku
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        initExchangeRate();

        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
            BigDecimal result = BigDecimal.valueOf(Double.parseDouble(String.valueOf(currencyValueEditText.getText()))).stripTrailingZeros();
            result = result.multiply(exchangeRate.getRate());
            currencyResultTextView.setText(String.format("%s PLN", decimalFormat.format(result)));
            return true;
        }
        else return super.onKeyUp(keyCode,event);
    }
}
