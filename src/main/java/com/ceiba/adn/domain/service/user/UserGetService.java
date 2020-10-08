package com.ceiba.adn.domain.service.user;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserGetRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserGetService {

    private final UserGetRepository userGetRepository;

    public UserGetService(UserGetRepository userGetRepository) {
        this.userGetRepository = userGetRepository;
    }

    public List<User> executeGetAllUser() {
        return this.userGetRepository.getAllUser();
    }

    public User executeGetUserId(int id) {
        return this.userGetRepository.getUserById(id);
    }
}
