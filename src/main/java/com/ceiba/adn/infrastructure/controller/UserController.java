package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.user.UserHandler;
import com.ceiba.adn.domain.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserHandler userHandler;

    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @GetMapping
    public List<User> getAll() {
        return this.userHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(name = "id") int id) {
        return this.userHandler.executeGetById(id);
    }
}
