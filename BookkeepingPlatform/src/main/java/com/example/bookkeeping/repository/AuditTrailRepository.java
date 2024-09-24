package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.AuditTrail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditTrailRepository extends MongoRepository<AuditTrail, String> {
}
