package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.Customer;
import java.util.List;

public interface CustomerGetRepository {

    List<Customer> getAllCustomer();

    Customer getCustomerById(int id);

}
