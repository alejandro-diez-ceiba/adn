package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Platform;
import com.ceiba.adn.infrastructure.persistence.entity.PlatformEntity;

public class PlatformBuilder {

    private PlatformBuilder() { }

    public static Platform toDomain(PlatformEntity platformEntity) {
        return (platformEntity != null)
                ? new Platform(
                    platformEntity.getId(),
                    platformEntity.getName()
                ) : null;
    }
}
