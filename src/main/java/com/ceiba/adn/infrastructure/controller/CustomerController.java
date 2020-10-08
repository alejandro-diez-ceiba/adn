package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.customer.CustomerGetHandler;
import com.ceiba.adn.domain.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerGetHandler customerGetHandler;

    public CustomerController(CustomerGetHandler customerGetHandler) {
        this.customerGetHandler = customerGetHandler;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {
        return this.customerGetHandler.executeGetAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable(name = "id") int id) {
        return this.customerGetHandler.executeGetCustomerId(id);
    }
}
