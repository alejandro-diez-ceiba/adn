package com.ceiba.adn.application.handler.platform;

import com.ceiba.adn.domain.Platform;
import com.ceiba.adn.domain.repository.PlatformRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlatformHandler {

    private final PlatformRepository platformRepository;

    public PlatformHandler(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public List<Platform> executeGetAll() {
        return this.platformRepository.getAll();
    }
}
