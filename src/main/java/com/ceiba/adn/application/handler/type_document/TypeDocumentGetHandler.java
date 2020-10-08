package com.ceiba.adn.application.handler.type_document;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.service.type_document.TypeDocumentGetService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TypeDocumentGetHandler {

    private final TypeDocumentGetService typeDocumentGetService;

    public TypeDocumentGetHandler(TypeDocumentGetService typeDocumentGetService) {
        this.typeDocumentGetService = typeDocumentGetService;
    }

    public List<TypeDocument> executeGetAllTypeDocument() {
        return this.typeDocumentGetService.executeGetAllTypeDocument();
    }
}
