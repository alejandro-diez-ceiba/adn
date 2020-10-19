package com.ceiba.adn.application.handler.kardex;

import com.ceiba.adn.domain.Kardex;
import com.ceiba.adn.domain.repository.KardexRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class KardexHandler {

    private final KardexRepository kardexRepository;

    public KardexHandler(KardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    public List<Kardex> executeGetAll() {
        return this.kardexRepository.getAll();
    }

    public Kardex executeGetById(long id) {
        return this.kardexRepository.getById(id);
    }

    public List<Kardex> executeGetByEntryOrExit(boolean isEntryOrExit) {
        return this.kardexRepository.getByEntryOrExit(isEntryOrExit);
    }
}
