package com.ceiba.adn.application.handler.type_document;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.repository.TypeDocumentRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TypeDocumentHandler {

    private final TypeDocumentRepository typeDocumentRepository;

    public TypeDocumentHandler(TypeDocumentRepository typeDocumentRepository) {
        this.typeDocumentRepository = typeDocumentRepository;
    }

    public List<TypeDocument> executeGetAll() {
        return this.typeDocumentRepository.getAll();
    }
}
