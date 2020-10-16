package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Platform;
import com.ceiba.adn.domain.repository.PlatformRepository;
import com.ceiba.adn.infrastructure.persistence.builder.PlatformBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.PlatformEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlatformRepositoryPersistence implements PlatformRepository {

    private static final String FIND_ALL_PLATFORM = "SELECT a FROM Platform a";
    private EntityManager entityManager;

    public PlatformRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<PlatformEntity> getAllPlatformEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_PLATFORM, PlatformEntity.class)
                .getResultList();
    }

    @Override
    public List<Platform> getAll() {
        return this.getAllPlatformEntity()
                .stream()
                .map(typeDocumentEntity -> PlatformBuilder.toDomain(typeDocumentEntity))
                .collect(Collectors.toList());
    }

}
