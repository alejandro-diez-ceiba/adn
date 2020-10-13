package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.User;
import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getById(int id);

}
