package com.ceiba.adn.application.handler.provider;

import com.ceiba.adn.application.command.ProviderCommand;
import com.ceiba.adn.application.factory.ProviderFactory;
import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.repository.ProviderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProviderHandlerPersistence {

    private final ProviderRepository providerRepository;
    private final ProviderFactory providerFactory;

    public ProviderHandlerPersistence(ProviderRepository providerRepository, ProviderFactory providerFactory) {
        this.providerRepository = providerRepository;
        this.providerFactory = providerFactory;
    }

    @Transactional
    public Provider executeCreateOrUpdate(ProviderCommand providerCommand) {
        return this.providerRepository.createOrUpdate(this.providerFactory.create(providerCommand));
    }

    @Transactional
    public Provider executeDeleteById(int id) {
        return this.providerRepository.deleteById(id);
    }
}
