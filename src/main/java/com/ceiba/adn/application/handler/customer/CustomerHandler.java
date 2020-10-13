package com.ceiba.adn.application.handler.customer;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerHandler {

    private final CustomerRepository customerRepository;

    public CustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> executeGetAllCustomer() {
        return this.customerRepository.getAll();
    }

    public Customer executeGetCustomerId(int id) {
        return this.customerRepository.getById(id);
    }
}
