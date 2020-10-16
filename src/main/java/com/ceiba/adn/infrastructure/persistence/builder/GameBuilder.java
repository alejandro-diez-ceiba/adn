package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Language;
import com.ceiba.adn.domain.Game;
import com.ceiba.adn.domain.Platform;
import com.ceiba.adn.infrastructure.persistence.entity.*;

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

    public static GameEntity toEntity(Game game) {

        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setId(game.getPlatform().getId());

        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setId(game.getLanguage().getId());

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(game.getId());
        gameEntity.setName(game.getName());
        gameEntity.setLaunch(game.getLaunch());
        gameEntity.setPrice(game.getPrice());
        gameEntity.setPlatform(platformEntity);
        gameEntity.setLanguage(languageEntity);

        return gameEntity;
    }
}
