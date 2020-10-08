package com.ceiba.adn.domain;

public class User {

    private int id;
    private String fullName;
    private TypeDocument typeDocument;
    private long document;

    public User(int id, String fullName, TypeDocument typeDocument, long document) {
        this.id = id;
        this.fullName = fullName;
        this.typeDocument = typeDocument;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public long getDocument() {
        return document;
    }
}
