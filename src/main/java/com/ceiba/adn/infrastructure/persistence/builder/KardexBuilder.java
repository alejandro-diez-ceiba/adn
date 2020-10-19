package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.*;
import com.ceiba.adn.infrastructure.persistence.entity.*;

public class KardexBuilder {

    private KardexBuilder() { }

    public static Kardex toDomain(KardexEntity kardexEntity) {
        Kardex kardex = null;
        if (kardexEntity != null) {
            kardex = new Kardex(
                    kardexEntity.getId(),
                    kardexEntity.getTransaction(),
                    kardexEntity.isEntryOrExit(),
                    kardexEntity.getQuantity(),
                    kardexEntity.getPrice(),
                    getProvider(kardexEntity),
                    getCustomer(kardexEntity),
                    getGame(kardexEntity)
            );
        }
        return kardex;
    }

    public static KardexEntity toEntity(Kardex kardex) {

        ProviderEntity providerEntity = null;
        if (kardex.getProvider() != null) {
            providerEntity = new ProviderEntity();
            providerEntity.setId(kardex.getProvider().getId());
        }

        CustomerEntity customerEntity = null;
        if (kardex.getCustomer() != null) {
            customerEntity = new CustomerEntity();
            customerEntity.setId(kardex.getCustomer().getId());
        }

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(kardex.getGame().getId());

        KardexEntity kardexEntity = new KardexEntity();
        kardexEntity.setId(kardex.getId());
        kardexEntity.setTransaction(kardex.getTransaction());
        kardexEntity.setEntryOrExit(kardex.isEntryOrExit());
        kardexEntity.setQuantity(kardex.getQuantity());
        kardexEntity.setPrice(kardex.getPrice());
        kardexEntity.setProvider(providerEntity);
        kardexEntity.setCustomer(customerEntity);
        kardexEntity.setGame(gameEntity);

        return kardexEntity;
    }

    private static Provider getProvider(KardexEntity kardexEntity) {
        Provider provider = null;
        if (kardexEntity.getProvider() != null && kardexEntity.getProvider().getFullName() != null) {
            TypeDocument typeDocument = new TypeDocument(
                    kardexEntity.getProvider().getTypeDocument().getId(),
                    kardexEntity.getProvider().getTypeDocument().getDescription()
            );
            provider = new Provider(
                    kardexEntity.getProvider().getId(),
                    kardexEntity.getProvider().getFullName(),
                    typeDocument,
                    kardexEntity.getProvider().getDocument(),
                    kardexEntity.getProvider().getAddress(),
                    kardexEntity.getProvider().getPhone()
            );
        }
        return provider;
    }

    private static Customer getCustomer(KardexEntity kardexEntity) {
        Customer customer = null;
        if (kardexEntity.getCustomer() != null && kardexEntity.getCustomer().getFullName() != null) {
            TypeDocument typeDocument = new TypeDocument(
                    kardexEntity.getCustomer().getTypeDocument().getId(),
                    kardexEntity.getCustomer().getTypeDocument().getDescription()
            );
            customer = new Customer(
                    kardexEntity.getCustomer().getId(),
                    kardexEntity.getCustomer().getFullName(),
                    typeDocument,
                    kardexEntity.getCustomer().getDocument(),
                    kardexEntity.getCustomer().getAddress(),
                    kardexEntity.getCustomer().getPhone()
            );
        }
        return customer;
    }

    private static Game getGame(KardexEntity kardexEntity) {
        Platform platform = new Platform(
                kardexEntity.getGame().getPlatform().getId(),
                kardexEntity.getGame().getPlatform().getName()
        );
        Language language = new Language(
                kardexEntity.getGame().getLanguage().getId(),
                kardexEntity.getGame().getLanguage().getName()
        );
        return new Game(
                kardexEntity.getGame().getId(),
                kardexEntity.getGame().getName(),
                kardexEntity.getGame().getLaunch(),
                kardexEntity.getGame().getPrice(),
                kardexEntity.getGame().getImage(),
                platform,
                language
        );
    }
}
