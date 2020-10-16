package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.type_document.TypeDocumentHandler;
import com.ceiba.adn.domain.TypeDocument;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/type-document")
public class TypeDocumentController {

    private final TypeDocumentHandler typeDocumentHandler;

    public TypeDocumentController(TypeDocumentHandler typeDocumentHandler) {
        this.typeDocumentHandler = typeDocumentHandler;
    }

    @GetMapping
    public List<TypeDocument> getAll() {
        return this.typeDocumentHandler.executeGetAll();
    }
}
