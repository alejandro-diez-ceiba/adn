package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Customer;
import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();

    Customer getById(int id);

    Customer createOrUpdate(Customer user);

    Customer deleteById(int id);

}
