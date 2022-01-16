package com.shortcuter4.currencyconverter.model;

 public class Conversion {

    // as given in the assignment
    // there are 3 inputs will be used for conversion

    // properties
    private String sourceCurrency;
    private String targetCurrency;
    private double monetaryValue;

    // constructor
    public Conversion(String sourceCurrency, String targetCurrency, double monetaryValue) {
        this.setSourceCurrency(sourceCurrency);
        this.setTargetCurrency(targetCurrency);
        this.setMonetaryValue(monetaryValue);
    }

    // getter and setter methods 
    public double getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    

}
