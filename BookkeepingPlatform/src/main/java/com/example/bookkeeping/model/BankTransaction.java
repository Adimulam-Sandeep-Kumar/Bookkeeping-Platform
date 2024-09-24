package com.example.bookkeeping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(collection = "bankTransactions")
public class BankTransaction {
    @Id
    private String transactionId;
    private String accountId; // Bank account or customer ID
    private BigDecimal amount;
    private Date transactionDate;
    private String description;
    private boolean reconciled; // Whether this transaction has been reconciled

    // Getters and Setters
}
