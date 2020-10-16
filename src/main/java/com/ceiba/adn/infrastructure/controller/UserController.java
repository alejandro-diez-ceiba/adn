package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.command.UserCommand;
import com.ceiba.adn.application.handler.user.UserHandler;
import com.ceiba.adn.application.handler.user.UserHandlerPersistence;
import com.ceiba.adn.domain.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserHandler userHandler;
    private final UserHandlerPersistence userHandlerPersistence;

    public UserController(UserHandler userHandler, UserHandlerPersistence userHandlerPersistence) {
        this.userHandler = userHandler;
        this.userHandlerPersistence = userHandlerPersistence;
    }

    @GetMapping
    public List<User> getAll() {
        return this.userHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(name = "id") int id) {
        return this.userHandler.executeGetById(id);
    }

    @PostMapping
    public User createOrUpdate(@RequestBody UserCommand userCommand) {
        return this.userHandlerPersistence.executeCreateOrUpdate(userCommand);
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable(name = "id") int id) {
        return this.userHandlerPersistence.executeDeleteById(id);
    }
}
