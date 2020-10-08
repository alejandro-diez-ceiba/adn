package com.ceiba.adn.infrastructure.controller;

import com.ceiba.adn.application.handler.type_document.TypeDocumentGetHandler;
import com.ceiba.adn.domain.TypeDocument;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/type-document")
public class TypeDocumentController {

    private final TypeDocumentGetHandler typeDocumentGetHandler;

    public TypeDocumentController(TypeDocumentGetHandler typeDocumentGetHandler) {
        this.typeDocumentGetHandler = typeDocumentGetHandler;
    }

    @GetMapping
    public List<TypeDocument> getAllUser() {
        return this.typeDocumentGetHandler.executeGetAllTypeDocument();
    }
}
