package com.shortcuter4.currencyconverter.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.shortcuter4.currencyconverter.model.Conversion;
import com.shortcuter4.currencyconverter.model.Currency;

import com.shortcuter4.currencyconverter.repository.CurrencyRepo;

import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    
    // @Autowired => constructor
    // more or traditional usage
    private CurrencyRepo currRepo;
    public ServiceLayer(CurrencyRepo currRepo) {
        this.currRepo = currRepo;
    }

    // this gets the list of currency data
    public List<Currency> getCurrencyData() {
        // rusing comparator , list all currency data in a sorted manner
        List<Currency> currList = this.currRepo.findAll();
        currList.sort(Comparator.comparing(Currency::getCurrencyKey));
        return currList;
    }

    // this property was created to calculate how long calculation took
    // start - the start time of calculation, so it is 0
    private long start = System.nanoTime();

    public Optional<Double> calculateConversionData(Conversion conversionCur) {
        /**
         * does not matter what the base currency is (in our case, it is "EUR")
         *  targetRate / sourceRate * monetaryValue
         */

        Optional<Currency> targetOpt = this.currRepo.findById(conversionCur.getTargetCurrency().toUpperCase()); // upper case, so either way it works as an input
        Optional<Currency> sourceOpt = this.currRepo.findById(conversionCur.getSourceCurrency().toUpperCase());
        
        if (targetOpt.isPresent() && sourceOpt.isPresent()) {
            // the given monetary value should be more than zero for conversion
            // checking if it is more than zero
            if (conversionCur.getMonetaryValue() < 0)
                return Optional.empty();
            
            Currency target = targetOpt.get();
            Currency source = sourceOpt.get();

            Double targetValue = target.getCurrencyValue(); // base currency is "EUR" accordingly 
            Double sourceValue = source.getCurrencyValue(); // base currency is "EUR" accordingly

            Double resultConversion = (targetValue * conversionCur.getMonetaryValue()) / sourceValue;

            return Optional.of(resultConversion);

        }
        return Optional.empty();
    }

    // this property was created to calculate how long calculation took
    // end - the end time of calculation
    private long end = System.nanoTime();
    private long elapsedTime = end - start;

    // it calculates the running time of the calculation
    public long calculateElapsedTimeData() {
        System.out.println("start: " + start + "\nend: " + end + "\nelapsed time: " + elapsedTime);
        return elapsedTime;
    }
    
}