package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.repository.TypeDocumentRepository;
import com.ceiba.adn.infrastructure.persistence.builder.TypeDocumentBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.TypeDocumentEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TypeDocumentRepositoryPersistence implements TypeDocumentRepository {

    private static final String FIND_ALL_TYPE_DOCUMENT = "SELECT a FROM TypeDocument a";
    private EntityManager entityManager;

    public TypeDocumentRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<TypeDocumentEntity> getAllTypeDocumentEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_TYPE_DOCUMENT, TypeDocumentEntity.class)
                .getResultList();
    }

    @Override
    public List<TypeDocument> getAll() {
        return this.getAllTypeDocumentEntity()
                .stream()
                .map(typeDocumentEntity -> TypeDocumentBuilder.toDomain(typeDocumentEntity))
                .collect(Collectors.toList());
    }
}
