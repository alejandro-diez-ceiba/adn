package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Language;
import com.ceiba.adn.domain.repository.LanguageRepository;
import com.ceiba.adn.infrastructure.persistence.builder.LanguageBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.LanguageEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LanguageRepositoryPersistence implements LanguageRepository {

    private static final String FIND_ALL_LANGUAGE = "SELECT a FROM Language a";
    private EntityManager entityManager;

    public LanguageRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<LanguageEntity> getAllLanguageEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_LANGUAGE, LanguageEntity.class)
                .getResultList();
    }

    @Override
    public List<Language> getAll() {
        return this.getAllLanguageEntity()
                .stream()
                .map(typeDocumentEntity -> LanguageBuilder.toDomain(typeDocumentEntity))
                .collect(Collectors.toList());
    }

}
