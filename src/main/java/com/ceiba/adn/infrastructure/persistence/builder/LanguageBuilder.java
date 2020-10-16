package com.ceiba.adn.infrastructure.persistence.builder;

import com.ceiba.adn.domain.Language;
import com.ceiba.adn.infrastructure.persistence.entity.LanguageEntity;

public class LanguageBuilder {

    private LanguageBuilder() { }

    public static Language toDomain(LanguageEntity languageEntity) {
        return (languageEntity != null)
                ? new Language(
                    languageEntity.getId(),
                    languageEntity.getName()
                ) : null;
    }
}
