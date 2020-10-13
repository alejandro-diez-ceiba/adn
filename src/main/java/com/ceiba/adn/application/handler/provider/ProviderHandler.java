package com.ceiba.adn.application.handler.provider;

import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.repository.ProviderRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProviderHandler {

    private final ProviderRepository providerRepository;

    public ProviderHandler(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> executeGetAll() {
        return this.providerRepository.getAll();
    }

    public Provider executeGetById(int id) {
        return this.providerRepository.getById(id);
    }
}
