package com.ceiba.adn.infrastructure.config;

import com.ceiba.adn.domain.repository.KardexRepository;
import com.ceiba.adn.domain.service.kardex.KardexService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public KardexService serviceKardex(KardexRepository kardexRepository) {
        return new KardexService(kardexRepository);
    }
}
