package com.example.bookkeeping.controller;

import com.example.bookkeeping.model.CustomerBilling;
import com.example.bookkeeping.service.CustomerBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class CustomerBillingController {
    @Autowired
    private CustomerBillingService customerBillingService;

    @GetMapping
    public ResponseEntity<List<CustomerBilling>> getAllBillings() {
        return ResponseEntity.ok(customerBillingService.getAllBillings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerBilling> getBillingById(@PathVariable String id) {
        return customerBillingService.getBillingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerBilling> createBilling(@RequestBody CustomerBilling billing) {
        return new ResponseEntity<>(customerBillingService.createBilling(billing), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerBilling> updateBilling(@PathVariable String id, @RequestBody CustomerBilling billing) {
        return ResponseEntity.ok(customerBillingService.updateBilling(id, billing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable String id) {
        customerBillingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }
}
