package com.shortcuter4.currencyconverter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Currency")
public class Currency {

    //properties
    @Id
    private String currencyKey;
    private double currencyValue;

    // default constructor
    public Currency() {}

    // constructor
    public Currency(String currencyKey, double currencyValue) {
        this.currencyKey = currencyKey;
        this.currencyValue = currencyValue;
    }

    // getter and setter methods
     public String getCurrencyKey() {
         return currencyKey;
     }

     public void setCurrencyKey(String currencyKey) {
         this.currencyKey = currencyKey;
     }

     public double getCurrencyValue() {
         return currencyValue;
     }

     public void setCurValue(double currencyValue) {
         this.currencyValue = currencyValue;
     }

     @Override
     public String toString() {
         return "Currency {" + "currencyName= " + this.currencyKey
                + "/'" + ", currencyValue= " + currencyValue + "}";
     }


    

    
}
