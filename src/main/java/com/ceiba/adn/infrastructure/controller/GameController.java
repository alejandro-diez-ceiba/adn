package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.game.GameHandler;
import com.ceiba.adn.domain.Game;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameHandler gameHandler;

    public GameController(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    @GetMapping
    public List<Game> getAll() {
        return this.gameHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable(name = "id") long id) {
        return this.gameHandler.executeGetById(id);
    }
}
