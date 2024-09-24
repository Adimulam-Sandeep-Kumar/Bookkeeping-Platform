package com.example.bookkeeping.service;

import com.example.bookkeeping.model.Invoice;
import com.example.bookkeeping.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(String id) {
        return invoiceRepository.findById(id);
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(String id, Invoice invoice) {
        invoice.setInvoiceId(id);
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }
}
