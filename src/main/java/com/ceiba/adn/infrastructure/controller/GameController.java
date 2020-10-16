package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.command.GameCommand;
import com.ceiba.adn.application.handler.game.GameHandler;
import com.ceiba.adn.application.handler.game.GameHandlerPersistence;
import com.ceiba.adn.domain.Game;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameHandler gameHandler;
    private final GameHandlerPersistence gameHandlerPersistence;

    public GameController(GameHandler gameHandler, GameHandlerPersistence gameHandlerPersistence) {
        this.gameHandler = gameHandler;
        this.gameHandlerPersistence = gameHandlerPersistence;
    }

    @GetMapping
    public List<Game> getAll() {
        return this.gameHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable(name = "id") long id) {
        return this.gameHandler.executeGetById(id);
    }

    @PostMapping
    public Game createOrUpdate(@RequestBody GameCommand gameCommand) {
        return this.gameHandlerPersistence.executeCreateOrUpdate(gameCommand);
    }

    @DeleteMapping("/{id}")
    public Game deleteById(@PathVariable(name = "id") long id) {
        return this.gameHandlerPersistence.executeDeleteById(id);
    }
}
