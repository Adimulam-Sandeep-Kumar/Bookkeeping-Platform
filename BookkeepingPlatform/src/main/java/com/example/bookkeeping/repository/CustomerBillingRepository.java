package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.CustomerBilling;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerBillingRepository extends MongoRepository<CustomerBilling, String> {
}
