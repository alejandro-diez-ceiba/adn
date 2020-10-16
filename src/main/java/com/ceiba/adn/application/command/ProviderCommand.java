package com.ceiba.adn.application.command;

public class ProviderCommand {

    private int id;
    private String fullName;
    private int typeDocument;
    private long document;
    private String address;
    private String phone;

    public ProviderCommand() {

    }

    public ProviderCommand(int id, String fullName, int typeDocument, long document, String address, String phone) {
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

    public int getTypeDocument() {
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
