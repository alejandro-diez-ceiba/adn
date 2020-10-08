package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.User;
import com.ceiba.adn.infrastructure.persistence.entity.UserEntity;

public class UserBuilder {

    private UserBuilder() {

    }

    public static User toDomain(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            TypeDocument typeDocument = new TypeDocument(
                    userEntity.getTypeDocument().getId(),
                    userEntity.getTypeDocument().getDescription()
            );
            user = new User(userEntity.getId(), userEntity.getFullName(), typeDocument, userEntity.getDocument());
        }
        return user;
    }

}
