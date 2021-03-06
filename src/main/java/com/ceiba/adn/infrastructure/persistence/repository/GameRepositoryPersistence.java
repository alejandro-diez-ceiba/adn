package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Game;
import com.ceiba.adn.domain.repository.GameRepository;
import com.ceiba.adn.infrastructure.persistence.builder.GameBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.GameEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryPersistence implements GameRepository {

    private static final String FIND_ALL_GAME = "SELECT a FROM Game a";
    private EntityManager entityManager;

    public GameRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<GameEntity> getAllGameEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_GAME, GameEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private GameEntity getGameEntityById(long id) {
        return this.entityManager.find(GameEntity.class, id);
    }

    @Override
    public List<Game> getAll() {
        return this.getAllGameEntity()
                .stream()
                .map(customerEntity -> GameBuilder.toDomain(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Game getById(long id) {
        return GameBuilder.toDomain(this.getGameEntityById(id));
    }

    @Override
    public Game createOrUpdate(Game game) {
        return GameBuilder.toDomain(this.entityManager.merge(GameBuilder.toEntity(game)));
    }

    @Override
    public Game deleteById(long id) {
        GameEntity gameEntity = this.getGameEntityById(id);
        this.entityManager.remove(gameEntity);
        return GameBuilder.toDomain(gameEntity);
    }
}
