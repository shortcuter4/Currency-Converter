package com.shortcuter4.currencyconverter.task;

import com.shortcuter4.currencyconverter.model.Currency;
import com.shortcuter4.currencyconverter.model.CurrencyDTO;
import com.shortcuter4.currencyconverter.repository.CurrencyRepo;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyTask {

    // it gets info from application properties
    // @Value("${exchangeRatesApiKey}")
    //  private String exchangeRatesApiKey;

    // constructor
    @Autowired
    private CurrencyRepo currRepo;

    // this simply updates api as scheduled 
    @Scheduled(fixedRate = 5 * 1000 * 60 * 60)
    public void getRatestask() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject("http://api.exchangeratesapi.io/v1/latest?access_key=a27c557740c6596fadfa4f39efbfa17a", CurrencyDTO.class);
            forObject.getRates().forEach((key, value) -> {
                Currency currency = new Currency(key, value);
                this.currRepo.save(currency);
            });
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void getApiData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject("http://api.exchangeratesapi.io/v1/latest?access_key=a27c557740c6596fadfa4f39efbfa17a", CurrencyDTO.class);
            forObject.getRates().forEach((key, value) -> {
                Currency currency = new Currency(key, value);
                this.currRepo.save(currency);
            });
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
