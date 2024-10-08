package com.example.bookkeeping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.bookkeeping.model.CustomerBilling.Item;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "auditTrail")
public class AuditTrail {
	@Id
    private String id;
    private String action; // Description of the action
    private String user; // User who made the change
    private String before; // Before state
    private String after; // After state
    private LocalDateTime timestamp; // Time of change

    // Getters and Setters
}
