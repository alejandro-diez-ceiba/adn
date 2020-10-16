package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.infrastructure.persistence.entity.CustomerEntity;
import com.ceiba.adn.infrastructure.persistence.entity.TypeDocumentEntity;

public class CustomerBuilder {

    private CustomerBuilder() { }

    public static Customer toDomain(CustomerEntity customerEntity) {
        Customer customer = null;
        if (customerEntity != null) {
            TypeDocument typeDocument = new TypeDocument(
                    customerEntity.getTypeDocument().getId(),
                    customerEntity.getTypeDocument().getDescription()
            );
            customer = new Customer(
                    customerEntity.getId(),
                    customerEntity.getFullName(),
                    typeDocument,
                    customerEntity.getDocument(),
                    customerEntity.getAddress(),
                    customerEntity.getPhone()
            );
        }
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {

        TypeDocumentEntity typeDocumentEntity = new TypeDocumentEntity();
        typeDocumentEntity.setId(customer.getTypeDocument().getId());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setFullName(customer.getFullName());
        customerEntity.setTypeDocument(typeDocumentEntity);
        customerEntity.setDocument(customer.getDocument());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPhone(customer.getPhone());

        return customerEntity;
    }
}
