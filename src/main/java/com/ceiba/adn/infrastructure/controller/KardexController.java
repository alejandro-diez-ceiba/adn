package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.kardex.KardexHandler;
import com.ceiba.adn.domain.Kardex;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/kardex")
public class KardexController {

    private final KardexHandler kardexHandler;

    public KardexController(KardexHandler kardexHandler) {
        this.kardexHandler = kardexHandler;
    }

    @GetMapping
    public List<Kardex> getAll() {
        return this.kardexHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Kardex getById(@PathVariable(name = "id") long id) {
        return this.kardexHandler.executeGetById(id);
    }
}
