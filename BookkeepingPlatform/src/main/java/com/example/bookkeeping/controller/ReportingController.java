package com.example.bookkeeping.controller;

import com.example.bookkeeping.model.ProfitLossReport;
import com.example.bookkeeping.model.BalanceSheetReport;
import com.example.bookkeeping.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {
    @Autowired
    private ReportingService reportingService;

    @GetMapping("/profit-loss")
    public ResponseEntity<ProfitLossReport> getProfitLossReport() {
        ProfitLossReport report = reportingService.generateProfitLossReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/balance-sheet")
    public ResponseEntity<BalanceSheetReport> getBalanceSheetReport() {
        BalanceSheetReport report = reportingService.generateBalanceSheetReport();
        return ResponseEntity.ok(report);
    }
    
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        ProfitLossReport report = reportingService.generateProfitLossReport();
        model.addAttribute("report", report);
        return "dashboard"; // Thymeleaf will render dashboard.html
    }

}
