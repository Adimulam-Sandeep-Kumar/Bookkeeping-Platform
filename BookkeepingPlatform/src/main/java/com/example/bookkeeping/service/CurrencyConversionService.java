package com.example.bookkeeping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionService {
    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD"; // Example API

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
        if (response != null) {
            Map<String, BigDecimal> rates = (Map<String, BigDecimal>) response.get("rates");
            BigDecimal conversionRate = rates.get(toCurrency);
            return amount.multiply(conversionRate);
        }
        return BigDecimal.ZERO; // Handle error case
    }
}
