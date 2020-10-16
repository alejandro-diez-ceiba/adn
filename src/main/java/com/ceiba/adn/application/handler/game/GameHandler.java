package com.ceiba.adn.application.handler.game;

import com.ceiba.adn.domain.Game;
import com.ceiba.adn.domain.repository.GameRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GameHandler {

    private final GameRepository gameRepository;

    public GameHandler(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> executeGetAll() {
        return this.gameRepository.getAll();
    }

    public Game executeGetById(long id) {
        return this.gameRepository.getById(id);
    }
}
