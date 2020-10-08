package com.ceiba.adn.application.handler.user;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.service.user.UserGetService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserGetHandler {

    private final UserGetService userGetService;

    public UserGetHandler(UserGetService userGetService) {
        this.userGetService = userGetService;
    }

    public List<User> executeGetAllUser() {
        return this.userGetService.executeGetAllUser();
    }

    public User executeGetUserId(int id) {
        return this.userGetService.executeGetUserId(id);
    }
}
