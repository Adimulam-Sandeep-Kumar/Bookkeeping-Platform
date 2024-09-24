package com.example.bookkeeping.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String invoiceId;
    private String customerId;
    private BigDecimal amount;
    private Date invoiceDate;
    private Date dueDate;
    private String status; // e.g., "PAID", "UNPAID", "OVERDUE"
    private String description;

    // Getters and Setters
}
