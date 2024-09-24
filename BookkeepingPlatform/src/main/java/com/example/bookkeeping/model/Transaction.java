package com.example.bookkeeping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String transactionId;
    private BigDecimal amount;
    private String account; // Updated: single account field
    private Date date;
    private String currency;
    private String description;
    private TransactionType type; // New: to distinguish debit/credit

    public enum TransactionType {
        CREDIT,
        DEBIT,
        EXPENSE, // Add this line
        INCOME;  // Add this line
    }

    // Getters and Setters
}
