package com.example.bookkeeping.service;

import com.example.bookkeeping.model.AuditTrail;
import com.example.bookkeeping.repository.AuditTrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditTrailService {
    @Autowired
    private AuditTrailRepository auditTrailRepository;

    public void logAction(String action, String user, String before, String after) {
        AuditTrail auditTrail = new AuditTrail();
        auditTrail.setAction(action);
        auditTrail.setUser(user);
        auditTrail.setBefore(before);
        auditTrail.setAfter(after);
        auditTrail.setTimestamp(LocalDateTime.now());
        auditTrailRepository.save(auditTrail);
    }
}
