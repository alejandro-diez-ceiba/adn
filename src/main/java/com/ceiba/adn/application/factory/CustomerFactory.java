package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.CustomerCommand;
import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.TypeDocument;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {

    public Customer create(CustomerCommand customerCommand) {
        return new Customer(
                customerCommand.getId(),
                customerCommand.getFullName(),
                new TypeDocument(customerCommand.getTypeDocument(), null),
                customerCommand.getDocument(),
                customerCommand.getAddress(),
                customerCommand.getPhone()
        );
    }
}
