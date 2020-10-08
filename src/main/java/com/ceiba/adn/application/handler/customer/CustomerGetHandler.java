package com.ceiba.adn.application.handler.customer;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.service.customer.CustomerGetService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerGetHandler {

    private final CustomerGetService customerGetService;

    public CustomerGetHandler(CustomerGetService customerGetService) {
        this.customerGetService = customerGetService;
    }

    public List<Customer> executeGetAllCustomer() {
        return this.customerGetService.executeGetAllCustomer();
    }

    public Customer executeGetCustomerId(int id) {
        return this.customerGetService.executeGetCustomerId(id);
    }
}
