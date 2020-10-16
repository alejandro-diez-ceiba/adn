package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.command.ProviderCommand;
import com.ceiba.adn.application.command.UserCommand;
import com.ceiba.adn.application.handler.provider.ProviderHandler;
import com.ceiba.adn.application.handler.provider.ProviderHandlerPersistence;
import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderHandler providerHandler;
    private final ProviderHandlerPersistence providerHandlerPersistence;

    public ProviderController(ProviderHandler providerHandler, ProviderHandlerPersistence providerHandlerPersistence) {
        this.providerHandler = providerHandler;
        this.providerHandlerPersistence = providerHandlerPersistence;
    }

    @GetMapping
    public List<Provider> getAll() {
        return this.providerHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Provider getById(@PathVariable(name = "id") int id) {
        return this.providerHandler.executeGetById(id);
    }

    @PostMapping
    public Provider createOrUpdate(@RequestBody ProviderCommand providerCommand) {
        return this.providerHandlerPersistence.executeCreateOrUpdate(providerCommand);
    }

    @DeleteMapping("/{id}")
    public Provider deleteById(@PathVariable(name = "id") int id) {
        return this.providerHandlerPersistence.executeDeleteById(id);
    }
}
