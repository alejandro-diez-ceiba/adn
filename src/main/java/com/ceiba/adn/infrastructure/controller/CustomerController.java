package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.command.CustomerCommand;
import com.ceiba.adn.application.handler.customer.CustomerHandler;
import com.ceiba.adn.application.handler.customer.CustomerHandlerPersistence;
import com.ceiba.adn.domain.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerHandler customerHandler;
    private final CustomerHandlerPersistence customerHandlerPersistence;

    public CustomerController(CustomerHandler customerHandler, CustomerHandlerPersistence customerHandlerPersistence) {
        this.customerHandler = customerHandler;
        this.customerHandlerPersistence = customerHandlerPersistence;
    }

    @GetMapping
    public List<Customer> getAll() {
        return this.customerHandler.executeGetAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable(name = "id") int id) {
        return this.customerHandler.executeGetCustomerId(id);
    }

    @PostMapping
    public Customer createOrUpdate(@RequestBody CustomerCommand customerCommand) {
        return this.customerHandlerPersistence.executeCreateOrUpdate(customerCommand);
    }

    @DeleteMapping("/{id}")
    public Customer deleteById(@PathVariable(name = "id") int id) {
        return this.customerHandlerPersistence.executeDeleteById(id);
    }
}
