package com.example.bookkeeping.service;

import com.example.bookkeeping.model.CustomerBilling;
import com.example.bookkeeping.repository.CustomerBillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerBillingService {
    @Autowired
    private CustomerBillingRepository customerBillingRepository;

    public List<CustomerBilling> getAllBillings() {
        return customerBillingRepository.findAll();
    }

    public Optional<CustomerBilling> getBillingById(String id) {
        return customerBillingRepository.findById(id);
    }

    public CustomerBilling createBilling(CustomerBilling billing) {
        return customerBillingRepository.save(billing);
    }

    public CustomerBilling updateBilling(String id, CustomerBilling billing) {
        billing.setCustomerId(id);
        return customerBillingRepository.save(billing);
    }

    public void deleteBilling(String id) {
        customerBillingRepository.deleteById(id);
    }
}
