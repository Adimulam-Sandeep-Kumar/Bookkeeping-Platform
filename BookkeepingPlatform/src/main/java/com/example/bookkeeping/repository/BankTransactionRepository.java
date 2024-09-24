package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.BankTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankTransactionRepository extends MongoRepository<BankTransaction, String> {
}
