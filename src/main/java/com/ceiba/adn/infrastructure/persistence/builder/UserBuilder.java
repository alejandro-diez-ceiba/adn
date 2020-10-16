package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.User;
import com.ceiba.adn.infrastructure.persistence.entity.TypeDocumentEntity;
import com.ceiba.adn.infrastructure.persistence.entity.UserEntity;

public class UserBuilder {

    private UserBuilder() { }

    public static User toDomain(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            TypeDocument typeDocument = new TypeDocument(
                    userEntity.getTypeDocument().getId(),
                    userEntity.getTypeDocument().getDescription()
            );
            user = new User(userEntity.getId(), userEntity.getFullName(), typeDocument, userEntity.getDocument(), userEntity.getPassword());
        }
        return user;
    }

    public static UserEntity toEntity(User user) {

        TypeDocumentEntity typeDocumentEntity = new TypeDocumentEntity();
        typeDocumentEntity.setId(user.getTypeDocument().getId());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFullName(user.getFullName());
        userEntity.setTypeDocument(typeDocumentEntity);
        userEntity.setDocument(user.getDocument());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }
}
