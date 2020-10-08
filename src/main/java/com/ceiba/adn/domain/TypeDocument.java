package com.ceiba.adn.domain;

public class TypeDocument {

    private int id;
    private String description;

    public TypeDocument(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
