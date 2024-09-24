package com.example.bookkeeping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookkeeping.model.BankTransaction;
import com.example.bookkeeping.model.Transaction; // Assuming you have a Transaction model
import com.example.bookkeeping.repository.BankTransactionRepository;

@Service
public class BankTransactionService {
    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Autowired
    private TransactionService transactionService; // To access accounting transactions
    
    public List<BankTransaction> getAllBankTransactions() {
        return bankTransactionRepository.findAll();
    }

    public Optional<BankTransaction> getBankTransactionById(String id) {
        return bankTransactionRepository.findById(id);
    }

    public BankTransaction createBankTransaction(BankTransaction bankTransaction) {
        return bankTransactionRepository.save(bankTransaction);
    }

    public void deleteBankTransaction(String id) {
        bankTransactionRepository.deleteById(id);
    }
    
    public void reconcileTransactions() {
        List<BankTransaction> bankTransactions = bankTransactionRepository.findAll();
        List<Transaction> accountingTransactions = transactionService.getAllTransactions();

        for (BankTransaction bankTransaction : bankTransactions) {
            for (Transaction accountingTransaction : accountingTransactions) {
                // Simple matching logic based on amount and date
                if (!bankTransaction.isReconciled() && bankTransaction.getAmount().compareTo(accountingTransaction.getAmount()) == 0 
                    && bankTransaction.getTransactionDate().equals(accountingTransaction.getDate())) {
                    // Mark as reconciled
                    bankTransaction.setReconciled(true);
                    bankTransactionRepository.save(bankTransaction); // Save the reconciled transaction
                    break; // Exit the inner loop if matched
                }
            }
        }
    }  
}
