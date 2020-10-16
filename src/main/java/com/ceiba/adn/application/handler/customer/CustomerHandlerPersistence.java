package com.ceiba.adn.application.handler.customer;

import com.ceiba.adn.application.command.CustomerCommand;
import com.ceiba.adn.application.factory.CustomerFactory;
import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerHandlerPersistence {

    private final CustomerRepository customerRepository;
    private final CustomerFactory customerFactory;

    public CustomerHandlerPersistence(CustomerRepository customerRepository, CustomerFactory customerFactory) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
    }

    @Transactional
    public Customer executeCreateOrUpdate(CustomerCommand customerCommand) {
        return this.customerRepository.createOrUpdate(this.customerFactory.create(customerCommand));
    }

    @Transactional
    public Customer executeDeleteById(int id) {
        return this.customerRepository.deleteById(id);
    }
}
