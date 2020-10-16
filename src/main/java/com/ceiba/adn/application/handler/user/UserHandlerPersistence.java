package com.ceiba.adn.application.handler.user;

import com.ceiba.adn.application.command.UserCommand;
import com.ceiba.adn.application.factory.UserFactory;
import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserHandlerPersistence {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserHandlerPersistence(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Transactional
    public User executeCreateOrUpdate(UserCommand userCommand) {
        return this.userRepository.createOrUpdate(this.userFactory.create(userCommand));
    }

    @Transactional
    public User executeDeleteById(int id) {
        return this.userRepository.deleteById(id);
    }
}
