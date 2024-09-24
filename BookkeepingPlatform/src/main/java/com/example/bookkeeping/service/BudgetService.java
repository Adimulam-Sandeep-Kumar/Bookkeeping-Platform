package com.example.bookkeeping.service;

import com.example.bookkeeping.model.Budget;
import com.example.bookkeeping.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(String budgetId, BigDecimal amountUsed) {
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RuntimeException("Budget not found"));
        budget.setUsedAmount(budget.getUsedAmount().add(amountUsed));
        return budgetRepository.save(budget);
    }

    public Budget getBudget(String budgetId) {
        return budgetRepository.findById(budgetId).orElseThrow(() -> new RuntimeException("Budget not found"));
    }
}
