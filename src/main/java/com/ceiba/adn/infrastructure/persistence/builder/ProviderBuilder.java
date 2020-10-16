package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.infrastructure.persistence.entity.ProviderEntity;
import com.ceiba.adn.infrastructure.persistence.entity.TypeDocumentEntity;

public class ProviderBuilder {

    private ProviderBuilder() { }

    public static Provider toDomain(ProviderEntity providerEntity) {
        Provider provider = null;
        if (providerEntity != null) {
            TypeDocument typeDocument = new TypeDocument(
                    providerEntity.getTypeDocument().getId(),
                    providerEntity.getTypeDocument().getDescription()
            );
            provider = new Provider(
                    providerEntity.getId(),
                    providerEntity.getFullName(),
                    typeDocument,
                    providerEntity.getDocument(),
                    providerEntity.getAddress(),
                    providerEntity.getPhone()
            );
        }
        return provider;
    }

    public static ProviderEntity toEntity(Provider provider) {

        TypeDocumentEntity typeDocumentEntity = new TypeDocumentEntity();
        typeDocumentEntity.setId(provider.getTypeDocument().getId());

        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setId(provider.getId());
        providerEntity.setFullName(provider.getFullName());
        providerEntity.setTypeDocument(typeDocumentEntity);
        providerEntity.setDocument(provider.getDocument());
        providerEntity.setAddress(provider.getAddress());
        providerEntity.setPhone(provider.getPhone());

        return providerEntity;
    }
}
