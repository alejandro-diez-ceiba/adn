package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.repository.CustomerGetRepository;
import com.ceiba.adn.infrastructure.persistence.builder.CustomerBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryPersistence implements CustomerGetRepository {

    private EntityManager entityManager;

    public CustomerRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<CustomerEntity> getAllCustomerEntity() {
        return this.entityManager
                .createQuery("SELECT a FROM Customer a", CustomerEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private CustomerEntity getCustomerEntityById(int id) {
        return this.entityManager.find(CustomerEntity.class, id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<CustomerEntity> customerEntities = this.getAllCustomerEntity();
        return customerEntities.stream()
                .map(customerEntity -> CustomerBuilder.toDomain(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(int id) {
        return CustomerBuilder.toDomain(this.getCustomerEntityById(id));
    }
}
