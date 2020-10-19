package com.ceiba.adn.domain;

public class Provider {

    private int id;
    private String fullName;
    private TypeDocument typeDocument;
    private long document;
    private String address;
    private String phone;

    public Provider(int id) {
        this.id = id;
    }

    public Provider(int id, String fullName, TypeDocument typeDocument, long document, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.typeDocument = typeDocument;
        this.document = document;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
