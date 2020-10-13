package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Customer;
import com.ceiba.adn.domain.repository.CustomerRepository;
import com.ceiba.adn.infrastructure.persistence.builder.CustomerBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryPersistence implements CustomerRepository {

    private static final String FIND_ALL_CUSTOMER = "SELECT a FROM Customer a";
    private EntityManager entityManager;

    public CustomerRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<CustomerEntity> getAllCustomerEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_CUSTOMER, CustomerEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private CustomerEntity getCustomerEntityById(int id) {
        return this.entityManager.find(CustomerEntity.class, id);
    }

    @Override
    public List<Customer> getAll() {
        return this.getAllCustomerEntity()
                .stream()
                .map(customerEntity -> CustomerBuilder.toDomain(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(int id) {
        return CustomerBuilder.toDomain(this.getCustomerEntityById(id));
    }
}
