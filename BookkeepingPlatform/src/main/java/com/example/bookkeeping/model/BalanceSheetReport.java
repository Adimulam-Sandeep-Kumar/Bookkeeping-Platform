package com.example.bookkeeping.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BalanceSheetReport {
    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal equity;

    // Getters and Setters
}
