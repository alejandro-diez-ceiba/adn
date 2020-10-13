package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserRepository;
import com.ceiba.adn.infrastructure.persistence.builder.UserBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryPersistence implements UserRepository {

    private static final String FIND_ALL_USER = "SELECT a FROM User a";
    private EntityManager entityManager;

    public UserRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<UserEntity> getAllUserEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_USER, UserEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private UserEntity getUserEntityById(int id) {
        return this.entityManager.find(UserEntity.class, id);
    }

    @Override
    public List<User> getAll() {
        return this.getAllUserEntity()
                .stream()
                .map(userEntity -> UserBuilder.toDomain(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public User getById(int id) {
        return UserBuilder.toDomain(this.getUserEntityById(id));
    }
}
