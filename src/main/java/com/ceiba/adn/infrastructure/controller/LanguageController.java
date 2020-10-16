package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.language.LanguageHandler;
import com.ceiba.adn.domain.Language;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageHandler languageHandler;

    public LanguageController(LanguageHandler languageHandler) {
        this.languageHandler = languageHandler;
    }

    @GetMapping
    public List<Language> getAll() {
        return this.languageHandler.executeGetAll();
    }
}
