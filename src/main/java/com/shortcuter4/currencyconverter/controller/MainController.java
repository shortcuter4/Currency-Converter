package com.shortcuter4.currencyconverter.controller;

import java.util.List;
import java.util.Optional;

import com.shortcuter4.currencyconverter.model.Conversion;
import com.shortcuter4.currencyconverter.model.Currency;
import com.shortcuter4.currencyconverter.service.ServiceLayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MainController {

    // constructor
    ServiceLayer sLayer;
    public MainController(ServiceLayer sLayer) {
        this.sLayer = sLayer;
    }

    // it lists all currencies 
    @RequestMapping(value = "/rates", produces = { "application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Currency>> convertCurrency() {
        return new ResponseEntity<>(this.sLayer.getCurrencyData(), HttpStatus.OK);
    }

    // it converts the given currencies with given value inpus
    // @RequestMapping(value = "/convert", produces = { "application/json" }, method = RequestMethod.POST)
    @RequestMapping(value = "/currency-converter", consumes = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Double> calculateConversion(@RequestBody Conversion currConversion) {
        Optional<Double> resultOpt = this.sLayer.calculateConversionData(currConversion);
        if ( resultOpt.isPresent())
            return new ResponseEntity<>(resultOpt.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * This is for me to check from Postman what data it gives as a return value
     * though I could see from output as well within vscode
     */
    @RequestMapping(value = "/elapsed-time", method = RequestMethod.GET)
    public long calculateElapsedTime() {
        return sLayer.calculateElapsedTimeData();
    }
    
        
}