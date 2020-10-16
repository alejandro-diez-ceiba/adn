package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.platform.PlatformHandler;
import com.ceiba.adn.domain.Platform;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    private final PlatformHandler platformHandler;

    public PlatformController(PlatformHandler platformHandler) {
        this.platformHandler = platformHandler;
    }

    @GetMapping
    public List<Platform> getAll() {
        return this.platformHandler.executeGetAll();
    }
}
