package com.shortcuter4.currencyconverter.model;

import java.util.Map;

public class CurrencyDTO {

    // properties
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;

    // default constructor
    public CurrencyDTO() {}
    
    // constructor
    public CurrencyDTO( boolean success, long timestamp, String base, String date, Map<String, Double> rates) {
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    // getter and setter methods 
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "success=" + success + 
                ", timestamp=" + timestamp +
                ", base=" + base + "\'" +
                ", date=" + date + "\'" +
                ", rates" + rates +
                "}";
    }

}   
