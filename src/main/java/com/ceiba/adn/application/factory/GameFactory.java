package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.GameCommand;
import com.ceiba.adn.domain.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class GameFactory {

    public Game create(GameCommand gameCommand) {
        return new Game(
                gameCommand.getId(),
                gameCommand.getName(),
                new Date(gameCommand.getLaunch()),
                gameCommand.getPrice(),
                gameCommand.getImage(),
                new Platform(gameCommand.getPlatform(), null),
                new Language(gameCommand.getLanguage(), null)
        );
    }
}
