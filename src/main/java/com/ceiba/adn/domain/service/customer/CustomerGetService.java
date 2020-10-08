package com.ceiba.adn.domain.service.customer;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.repository.CustomerGetRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerGetService {

    private final CustomerGetRepository customerGetRepository;

    public CustomerGetService(CustomerGetRepository customerGetRepository) {
        this.customerGetRepository = customerGetRepository;
    }

    public List<Customer> executeGetAllCustomer() {
        return this.customerGetRepository.getAllCustomer();
    }

    public Customer executeGetCustomerId(int id) {
        return this.customerGetRepository.getCustomerById(id);
    }
}
