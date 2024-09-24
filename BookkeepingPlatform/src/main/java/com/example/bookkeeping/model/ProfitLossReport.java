package com.example.bookkeeping.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProfitLossReport {
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal netProfitLoss;

    // Getters and Setters
}
