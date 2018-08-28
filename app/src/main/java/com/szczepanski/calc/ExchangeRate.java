package com.szczepanski.calc;

import java.math.BigDecimal;

public class ExchangeRate {

    private String fullName;
    private String symbol;
    private BigDecimal rate;

    public ExchangeRate(String fullName, String symbol, BigDecimal rate) {
        this.fullName = fullName;
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
