package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.user.UserGetHandler;
import com.ceiba.adn.domain.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserGetHandler userGetHandler;

    public UserController(UserGetHandler userGetHandler) {
        this.userGetHandler = userGetHandler;
    }

    @GetMapping
    public List<User> getAllUser() {
        return this.userGetHandler.executeGetAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") int id) {
        return this.userGetHandler.executeGetUserId(id);
    }
}
