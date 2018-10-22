package com.szczepanski.calc.CurrencyConverter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.szczepanski.calc.App;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exchange {


    private final String BASE_URL = "http://data.fixer.io/api/";
    private final String GET_LATEST = "latest?access_key=";
    private final String API_KEY = "e866751a6bd8ea85ec5e0abe0d11cd93";
    private Currency currency;
    private InputStream inputStream;

    private final List<ExchangeRate> listOfExchangeRates = new ArrayList<>();

    public Exchange() {
        if (!isNetworkAvailable()) {

        }
            openConnection();

            startGson();
            fillListOfExchangeRates();

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void startGson() {
        Scanner scanner = new Scanner(inputStream);
        Gson gson = new Gson();
        currency = gson.fromJson(scanner.next(), Currency.class);
    }

    private void openConnection() {
        try {
            HttpURLConnection getLatestRates = (HttpURLConnection) new URL(BASE_URL + GET_LATEST + API_KEY).openConnection();
            inputStream = getLatestRates.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ExchangeRate> getListOfExchangeRates() {
        return listOfExchangeRates;
    }

    public List<String> getListOfExchangeRatesSymbols() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listOfExchangeRates.size(); i++) {
            list.add(listOfExchangeRates.get(i).getSymbol());
        }
        return list;
    }

    private void fillListOfExchangeRates() {
        listOfExchangeRates.add(new ExchangeRate("Dolar (USA)", "USD", (BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.uSD), RoundingMode.HALF_UP))));
        listOfExchangeRates.add(new ExchangeRate("Euro", "EUR", BigDecimal.valueOf(currency.rates.pLN)));
        listOfExchangeRates.add(new ExchangeRate("Rubel", "RUB", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.rUB),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Białoruski rubel", "BYR", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.bYN),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Ukraińska hrywna", "UAH", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.uAH),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Forint", "HUF", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.hUF),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Korona czeska", "CZK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.cZK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Lej mołdawski", "MDL", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.mDL),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Lej rumuński", "RON", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.rON),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Lew bułgarski", "BGN", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.bGN),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Korona duńska", "DKK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.dKK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Korona szwedzka", "SEK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.sEK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Korona norweska", "NOK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.nOK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Korona islandzka", "ISK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.iSK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Kuna (Chorwacja)", "HRK", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.hRK),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Dinar serbski", "RSD", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.rSD),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Lek albański", "ALL", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.aLL),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Lira turecka", "TRY", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.tRY),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Frank szwajcarski", "CHF", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.cHF),RoundingMode.HALF_UP)));
        listOfExchangeRates.add(new ExchangeRate("Funt szterling", "GBP", BigDecimal.valueOf(currency.rates.pLN).divide(BigDecimal.valueOf(currency.rates.gBP),RoundingMode.HALF_UP)));

    }
}
