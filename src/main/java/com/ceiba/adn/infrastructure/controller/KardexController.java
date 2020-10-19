package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.command.KardexCommand;
import com.ceiba.adn.application.handler.kardex.KardexHandler;
import com.ceiba.adn.application.handler.kardex.KardexHandlerPersistence;
import com.ceiba.adn.domain.Kardex;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/kardex")
public class KardexController {

    private final KardexHandler kardexHandler;
    private final KardexHandlerPersistence kardexHandlerPersistence;

    public KardexController(KardexHandler kardexHandler, KardexHandlerPersistence kardexHandlerPersistence) {
        this.kardexHandler = kardexHandler;
        this.kardexHandlerPersistence = kardexHandlerPersistence;
    }

    @GetMapping
    public List<Kardex> getAll() {
        return this.kardexHandler.executeGetAll();
    }

    @GetMapping("/{id}")
    public Kardex getById(@PathVariable(name = "id") long id) {
        return this.kardexHandler.executeGetById(id);
    }

    @PostMapping
    public Kardex createOrUpdate(@RequestBody KardexCommand kardexCommand) {
        return this.kardexHandlerPersistence.executeCreateOrUpdate(kardexCommand);
    }

    @DeleteMapping("/{id}")
    public Kardex deleteById(@PathVariable(name = "id") long id) {
        return this.kardexHandlerPersistence.executeDeleteById(id);
    }

    @GetMapping("/dash/{isEntryOrExit}")
    public List<Kardex> getByEntryOrExit(@PathVariable(name = "isEntryOrExit") int isEntryOrExit) {
        return this.kardexHandler.executeGetByEntryOrExit((isEntryOrExit == 1));
    }
}
