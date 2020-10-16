package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.repository.ProviderRepository;
import com.ceiba.adn.infrastructure.persistence.builder.ProviderBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.ProviderEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProviderRepositoryPersistence implements ProviderRepository {

    private static final String FIND_ALL_PROVIDER = "SELECT a FROM Provider a";
    private EntityManager entityManager;

    public ProviderRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<ProviderEntity> getAllProviderEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_PROVIDER, ProviderEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private ProviderEntity getProviderEntityById(int id) {
        return this.entityManager.find(ProviderEntity.class, id);
    }

    @Override
    public List<Provider> getAll() {
        return this.getAllProviderEntity()
                .stream()
                .map(userEntity -> ProviderBuilder.toDomain(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Provider getById(int id) {
        return ProviderBuilder.toDomain(this.getProviderEntityById(id));
    }

    @Override
    public Provider createOrUpdate(Provider provider) {
        return ProviderBuilder.toDomain(this.entityManager.merge(ProviderBuilder.toEntity(provider)));
    }

    @Override
    public Provider deleteById(int id) {
        ProviderEntity providerEntity = this.getProviderEntityById(id);
        this.entityManager.remove(providerEntity);
        return ProviderBuilder.toDomain(providerEntity);
    }
}
