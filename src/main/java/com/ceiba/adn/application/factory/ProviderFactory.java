package com.ceiba.adn.application.factory;

import com.ceiba.adn.application.command.ProviderCommand;
import com.ceiba.adn.domain.Provider;
import com.ceiba.adn.domain.TypeDocument;
import org.springframework.stereotype.Component;

@Component
public class ProviderFactory {

    public Provider create(ProviderCommand providerCommand) {
        return new Provider(
                providerCommand.getId(),
                providerCommand.getFullName(),
                new TypeDocument(providerCommand.getTypeDocument(), null),
                providerCommand.getDocument(),
                providerCommand.getAddress(),
                providerCommand.getPhone()
        );
    }
}
