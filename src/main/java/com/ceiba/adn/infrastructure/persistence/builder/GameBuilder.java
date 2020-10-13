package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Language;
import com.ceiba.adn.domain.Game;
import com.ceiba.adn.domain.Platform;
import com.ceiba.adn.infrastructure.persistence.entity.GameEntity;

public class GameBuilder {

    private GameBuilder() { }

    public static Game toDomain(GameEntity gameEntity) {
        Game game = null;
        if (gameEntity != null) {
            Platform platform = new Platform(
                    gameEntity.getPlatform().getId(),
                    gameEntity.getPlatform().getName()
            );
            Language language = new Language(
                    gameEntity.getLanguage().getId(),
                    gameEntity.getLanguage().getName()
            );
            game = new Game(
                    gameEntity.getId(),
                    gameEntity.getName(),
                    gameEntity.getLaunch(),
                    gameEntity.getPrice(),
                    gameEntity.getImage(),
                    platform,
                    language
            );
        }
        return game;
    }
}
