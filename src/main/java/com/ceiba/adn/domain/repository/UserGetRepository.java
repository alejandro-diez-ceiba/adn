package com.ceiba.adn.domain.repository;

import com.ceiba.adn.domain.User;
import java.util.List;

public interface UserGetRepository {

    List<User> getAllUser();

    User getUserById(int id);

}
