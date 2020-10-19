package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.User;
import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getById(int id);

    User createOrUpdate(User user);

    User deleteById(int id);

    User getByDocumentAndPassword(long document, String password);

}
