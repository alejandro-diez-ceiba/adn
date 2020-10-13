package com.ceiba.adn.application.handler.user;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> executeGetAll() {
        return this.userRepository.getAll();
    }

    public User executeGetById(int id) {
        return this.userRepository.getById(id);
    }
}
