package com.example.bookkeeping.controller;

import com.example.bookkeeping.model.AuditTrail;
import com.example.bookkeeping.service.AuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-trail")
public class AuditTrailController {
    
    @Autowired
    private AuditTrailService auditTrailService;

    // Endpoint to log an action
    @PostMapping("/log")
    public void logAction(@RequestBody AuditTrail auditTrail) {
        // Here you may want to customize the logic for extracting relevant fields
        auditTrailService.logAction(
            auditTrail.getAction(),
            auditTrail.getUser(),
            auditTrail.getBefore(),
            auditTrail.getAfter()
        );
    }

    // Endpoint to retrieve all audit logs
    @GetMapping
    public List<AuditTrail> getAuditTrail() {
        return auditTrailService.getAllAuditLogs();
    }
}
