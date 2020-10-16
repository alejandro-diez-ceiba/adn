package com.ceiba.adn.application.handler.game;

import com.ceiba.adn.application.command.GameCommand;
import com.ceiba.adn.application.factory.GameFactory;
import com.ceiba.adn.domain.Game;
import com.ceiba.adn.domain.repository.GameRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GameHandlerPersistence {

    private final GameRepository gameRepository;
    private final GameFactory gameFactory;

    public GameHandlerPersistence(GameRepository gameRepository, GameFactory gameFactory) {
        this.gameRepository = gameRepository;
        this.gameFactory = gameFactory;
    }

    @Transactional
    public Game executeCreateOrUpdate(GameCommand gameCommand) {
        return this.gameRepository.createOrUpdate(this.gameFactory.create(gameCommand));
    }

    @Transactional
    public Game executeDeleteById(long id) {
        return this.gameRepository.deleteById(id);
    }
}
