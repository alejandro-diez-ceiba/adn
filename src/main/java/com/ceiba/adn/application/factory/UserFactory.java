package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.UserCommand;
import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User create(UserCommand userCommand) {
        return new User(
                userCommand.getId(),
                userCommand.getFullName(),
                new TypeDocument(userCommand.getTypeDocument(), null),
                userCommand.getDocument(),
                userCommand.getPassword()
        );
    }
}
