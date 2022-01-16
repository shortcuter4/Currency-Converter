package com.shortcuter4.currencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * date : 16.01.2022
 * 	
 * Currency Converter using https://exchangeratesapi.io/ api
 * 
 * @author Subhan Ibrahimli
 * 
 */

@SpringBootApplication
@EnableScheduling
public class CurrencyConverterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

}