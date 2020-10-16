package com.ceiba.adn.application.handler.kardex;

import com.ceiba.adn.application.command.KardexCommand;
import com.ceiba.adn.application.factory.KardexFactory;
import com.ceiba.adn.domain.Kardex;
import com.ceiba.adn.domain.repository.KardexRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KardexHandlerPersistence {

    private final KardexRepository kardexRepository;
    private final KardexFactory kardexFactory;

    public KardexHandlerPersistence(KardexRepository kardexRepository, KardexFactory kardexFactory) {
        this.kardexRepository = kardexRepository;
        this.kardexFactory = kardexFactory;
    }

    @Transactional
    public Kardex executeCreateOrUpdate(KardexCommand kardexCommand) {
        return this.kardexRepository.createOrUpdate(this.kardexFactory.create(kardexCommand));
    }

    @Transactional
    public Kardex executeDeleteById(long id) {
        return this.kardexRepository.deleteById(id);
    }
}
