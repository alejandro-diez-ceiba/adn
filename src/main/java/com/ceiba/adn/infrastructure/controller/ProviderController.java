package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.provider.ProviderHandler;
import com.ceiba.adn.domain.Provider;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderHandler providerHandler;

    public ProviderController(ProviderHandler providerHandler) {
        this.providerHandler = providerHandler;
    }

    @GetMapping
    public List<Provider> getAll() {
        return this.providerHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Provider getById(@PathVariable(name = "id") int id) {
        return this.providerHandler.executeGetById(id);
    }
}
