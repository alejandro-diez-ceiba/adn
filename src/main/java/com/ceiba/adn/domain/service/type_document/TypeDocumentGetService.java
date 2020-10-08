package com.ceiba.adn.domain.service.type_document;

import com.ceiba.adn.domain.TypeDocument;
import com.ceiba.adn.domain.repository.TypeDocumentGetRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TypeDocumentGetService {

    private final TypeDocumentGetRepository typeDocumentGetRepository;

    public TypeDocumentGetService(TypeDocumentGetRepository typeDocumentGetRepository) {
        this.typeDocumentGetRepository = typeDocumentGetRepository;
    }

    public List<TypeDocument> executeGetAllTypeDocument() {
        return this.typeDocumentGetRepository.getAllTypeDocument();
    }
}
