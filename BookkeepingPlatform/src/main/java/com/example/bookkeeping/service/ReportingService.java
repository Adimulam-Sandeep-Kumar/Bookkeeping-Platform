package com.example.bookkeeping.service;

import com.example.bookkeeping.model.ProfitLossReport;
import com.example.bookkeeping.model.BalanceSheetReport;
import com.example.bookkeeping.model.Transaction;
import com.example.bookkeeping.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportingService {
    @Autowired
    private TransactionRepository transactionRepository;

    public ProfitLossReport generateProfitLossReport() {
        List<Transaction> transactions = transactionRepository.findAll();
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpenses = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == Transaction.TransactionType.CREDIT) {
                totalIncome = totalIncome.add(transaction.getAmount());
            } else if (transaction.getType() == Transaction.TransactionType.DEBIT) {
                totalExpenses = totalExpenses.add(transaction.getAmount());
            }
        }

        ProfitLossReport report = new ProfitLossReport();
        report.setTotalIncome(totalIncome);
        report.setTotalExpenses(totalExpenses);
        report.setNetProfitLoss(totalIncome.subtract(totalExpenses));
        return report;
    }

    public BalanceSheetReport generateBalanceSheetReport() {
        // Fetch all transactions
        List<Transaction> transactions = transactionRepository.findAll();
        BigDecimal totalAssets = BigDecimal.ZERO;
        BigDecimal totalLiabilities = BigDecimal.ZERO;

        // Iterate through transactions to calculate total assets and liabilities
        for (Transaction transaction : transactions) {
            // Assuming "Cash" and "Accounts Receivable" are considered assets
            if (transaction.getAccount().equals("Cash") || transaction.getAccount().equals("Accounts Receivable")) {
                if (transaction.getType() == Transaction.TransactionType.CREDIT) {
                    totalAssets = totalAssets.add(transaction.getAmount());
                } else if (transaction.getType() == Transaction.TransactionType.DEBIT) {
                    totalAssets = totalAssets.subtract(transaction.getAmount());
                }
            }

            // Assuming "Accounts Payable" and "Loans" are considered liabilities
            if (transaction.getAccount().equals("Accounts Payable") || transaction.getAccount().equals("Loans")) {
                if (transaction.getType() == Transaction.TransactionType.CREDIT) {
                    totalLiabilities = totalLiabilities.add(transaction.getAmount());
                } else if (transaction.getType() == Transaction.TransactionType.DEBIT) {
                    totalLiabilities = totalLiabilities.subtract(transaction.getAmount());
                }
            }
        }

        // Create Balance Sheet report
        BalanceSheetReport report = new BalanceSheetReport();
        report.setTotalAssets(totalAssets);
        report.setTotalLiabilities(totalLiabilities);
        report.setEquity(totalAssets.subtract(totalLiabilities)); // Equity = Assets - Liabilities
        return report;
    }
}
