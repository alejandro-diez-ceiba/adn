package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.customer.CustomerHandler;
import com.ceiba.adn.domain.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @GetMapping
    public List<Customer> getAll() {
        return this.customerHandler.executeGetAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable(name = "id") int id) {
        return this.customerHandler.executeGetCustomerId(id);
    }
}
