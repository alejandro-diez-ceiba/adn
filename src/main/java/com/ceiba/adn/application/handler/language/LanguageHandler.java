package com.ceiba.adn.application.handler.language;

import com.ceiba.adn.domain.Language;
import com.ceiba.adn.domain.repository.LanguageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageHandler {

    private final LanguageRepository languageRepository;

    public LanguageHandler(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> executeGetAll() {
        return this.languageRepository.getAll();
    }
}
