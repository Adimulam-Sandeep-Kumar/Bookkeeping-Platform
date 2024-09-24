package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
