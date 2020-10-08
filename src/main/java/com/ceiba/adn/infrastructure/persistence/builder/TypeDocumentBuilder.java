package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.infrastructure.persistence.entity.TypeDocumentEntity;

public class TypeDocumentBuilder {

    private TypeDocumentBuilder() { }

    public static TypeDocument toDomain(TypeDocumentEntity typeDocumentEntity) {
        return (typeDocumentEntity != null)
                ? new TypeDocument(
                    typeDocumentEntity.getId(),
                    typeDocumentEntity.getDescription()
                ) : null;
    }
}
