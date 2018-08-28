package com.szczepanski.calc.CurrencyConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("timestamp")
    @Expose
    public Long timestamp;
    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("rates")
    @Expose
    public Rates rates;

    public Boolean getSuccess() {
        return success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }
}
