package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BudgetRepository extends MongoRepository<Budget, String> {
}
