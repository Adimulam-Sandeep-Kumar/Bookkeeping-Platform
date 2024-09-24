package com.example.bookkeeping.controller;

import com.example.bookkeeping.service.ReportingService;
import com.example.bookkeeping.model.ProfitLossReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ReportingService reportingService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        ProfitLossReport report = reportingService.generateProfitLossReport();
        model.addAttribute("report", report);
        return "dashboard";
    }
}
