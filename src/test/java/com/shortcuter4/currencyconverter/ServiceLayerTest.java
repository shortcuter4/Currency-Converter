package com.shortcuter4.currencyconverter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.shortcuter4.currencyconverter.model.Conversion;
import com.shortcuter4.currencyconverter.model.Currency;
import com.shortcuter4.currencyconverter.repository.CurrencyRepo;
import com.shortcuter4.currencyconverter.service.ServiceLayer;

import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

// @ExtendWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    @Mock
    private CurrencyRepo curRepo;

    private ServiceLayer sl;

    @BeforeTestMethod
    public void setup() {
        sl = new ServiceLayer(curRepo);
    }

    @Test
    public void getCurrencyDataEmptyTest() {
        Mockito.when(curRepo.findAll()).thenReturn(Arrays.asList());
        
        List<Currency> curList = sl.getCurrencyData();
        assertTrue(curList.isEmpty());
    }

    @Test
    public void convertEmptyWhenNegativeInputGiven() {
        Currency curEUR = new Currency("EUR", 1);
        Currency curUSD = new Currency("USD", 1.142903);

        Mockito.when(curRepo.findById("EUR")).thenReturn(Optional.of(curEUR));
        Mockito.when(curRepo.findById("USD")).thenReturn(Optional.of(curUSD));

        Conversion currConversion = new Conversion("EUR", "USD", -1);

        Optional<Double> res = this.sl.calculateConversionData(currConversion);

        assertNotNull(res);
        assertFalse(res.isPresent());
    }

    @Test
    public void convertShouldReturnEmptyWhenGivenInputCurrencyNotExist() {
        Currency curUSD = new Currency("USD", 1.142903);

        Mockito.when(curRepo.findById("EUR")).thenReturn(Optional.empty());
        Mockito.when(curRepo.findById("USD")).thenReturn(Optional.of(curUSD));

        Conversion currConversion = new Conversion("EUR", "USD", -1);

        Optional<Double> res = this.sl.calculateConversionData(currConversion);

        assertNotNull(res);
        assertFalse(res.isPresent());
    }

}
