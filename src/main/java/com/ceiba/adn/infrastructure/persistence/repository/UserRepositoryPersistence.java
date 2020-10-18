package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.User;
import com.ceiba.adn.domain.repository.UserRepository;
import com.ceiba.adn.infrastructure.persistence.builder.UserBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryPersistence implements UserRepository {

    private static final String FIND_ALL_USER = "SELECT a FROM User a";
    private static final String DOCUMENT = "document";
    private static final String PASSWORD = "password";
    private static final String FIND_BY_USERNAME_AND_PASSWORD = "SELECT a FROM User a WHERE a.document = :document AND a.password = :password";
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

    @SuppressWarnings("rawtypes")
    private UserEntity getUserEntityByUsernameAndPassword(long document, String password) {
        Query query = this.entityManager.createQuery(FIND_BY_USERNAME_AND_PASSWORD, UserEntity.class);
        query.setParameter(DOCUMENT, document);
        query.setParameter(PASSWORD, password);
        return (UserEntity) query.getSingleResult();
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

    @Override
    public User createOrUpdate(User user) {
        return UserBuilder.toDomain(this.entityManager.merge(UserBuilder.toEntity(user)));
    }

    @Override
    public User deleteById(int id) {
        UserEntity userEntity = this.getUserEntityById(id);
        this.entityManager.remove(userEntity);
        return UserBuilder.toDomain(userEntity);
    }

    @Override
    public User getByDocumentAndPassword(long document, String password) {
        return UserBuilder.toDomain(this.getUserEntityByUsernameAndPassword(document, password));
    }
}
