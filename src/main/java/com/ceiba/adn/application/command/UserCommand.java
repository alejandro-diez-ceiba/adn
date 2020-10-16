package com.ceiba.adn.application.command;

public class UserCommand  {

    private int id;
    private String fullName;
    private int typeDocument;
    private long document;
    private String password;

    public UserCommand() {

    }

    public UserCommand(int id, String fullName, int typeDocument, long document, String password) {
        this.id = id;
        this.fullName = fullName;
        this.typeDocument = typeDocument;
        this.document = document;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
