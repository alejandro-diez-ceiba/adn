package com.ceiba.adn.infrastructure.persistence.repository;

import com.ceiba.adn.domain.Kardex;
import com.ceiba.adn.domain.repository.KardexRepository;
import com.ceiba.adn.infrastructure.persistence.builder.KardexBuilder;
import com.ceiba.adn.infrastructure.persistence.entity.KardexEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class KardexRepositoryPersistence implements KardexRepository {

    private static final String FIND_ALL_KARDEX = "SELECT a FROM Kardex a";
    private static final String FIND_BY_ENTRY_OR_EXIT = "SELECT a FROM Kardex a WHERE a.entryOrExit = :entryOrExit";
    private static final String ENTRY_OR_EXIT = "entryOrExit";
    private EntityManager entityManager;

    public KardexRepositoryPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("rawtypes")
    private List<KardexEntity> getAllKardexEntity() {
        return this.entityManager
                .createQuery(FIND_ALL_KARDEX, KardexEntity.class)
                .getResultList();
    }

    @SuppressWarnings("rawtypes")
    private KardexEntity getKardexEntityById(long id) {
        return this.entityManager.find(KardexEntity.class, id);
    }

    @SuppressWarnings("rawtypes")
    private List<KardexEntity> getByEntryOrExitKardexEntity(boolean isEntryOrExit) {
        Query query = this.entityManager.createQuery(FIND_BY_ENTRY_OR_EXIT, KardexEntity.class);
        query.setParameter(ENTRY_OR_EXIT, isEntryOrExit);
        return query.getResultList();
    }

    @Override
    public List<Kardex> getAll() {
        return this.getAllKardexEntity()
                .stream()
                .map(customerEntity -> KardexBuilder.toDomain(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Kardex getById(long id) {
        return KardexBuilder.toDomain(this.getKardexEntityById(id));
    }

    @Override
    public Kardex createOrUpdate(Kardex kardex) {
        return KardexBuilder.toDomain(this.entityManager.merge(KardexBuilder.toEntity(kardex)));
    }

    @Override
    public Kardex deleteById(long id) {
        KardexEntity kardexEntity = this.getKardexEntityById(id);
        this.entityManager.remove(kardexEntity);
        return KardexBuilder.toDomain(kardexEntity);
    }

    @Override
    public List<Kardex> getByEntryOrExit(boolean isEntryOrExit) {
        return this.getByEntryOrExitKardexEntity(isEntryOrExit)
                .stream()
                .map(customerEntity -> KardexBuilder.toDomain(customerEntity))
                .collect(Collectors.toList());
    }
}
