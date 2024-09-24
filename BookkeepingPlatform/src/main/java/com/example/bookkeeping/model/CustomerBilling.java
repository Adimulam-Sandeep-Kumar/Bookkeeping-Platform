package com.example.bookkeeping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "customerBilling")
public class CustomerBilling {
    @Id
    private String customerId;
    private String invoiceId;
    private BigDecimal amount;
    private Date dueDate;
    private String status;
    private List<Item> items;

    // Getters and Setters

    public static class Item {
        private String description;
        private BigDecimal amount;
        private int quantity;

        // Getters and Setters
    }

}
