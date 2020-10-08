package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserGetRepository;
import com.ceiba.adn.infrastructure.persistence.builder.UserBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryPersistence implements UserGetRepository {

    private EntityManager entityManager;

    public UserRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<UserEntity> getAllUserEntity() {
        return this.entityManager
                .createQuery("SELECT a FROM User a", UserEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private UserEntity getUserEntityById(int id) {
        return this.entityManager.find(UserEntity.class, id);
    }

    @Override
    public List<User> getAllUser() {
        List<UserEntity> userEntities = this.getAllUserEntity();
        return userEntities.stream()
                .map(userEntity -> UserBuilder.toDomain(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(int id) {
        return UserBuilder.toDomain(this.getUserEntityById(id));
    }
}
