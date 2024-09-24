package com.example.bookkeeping.repository;

import com.example.bookkeeping.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
}
