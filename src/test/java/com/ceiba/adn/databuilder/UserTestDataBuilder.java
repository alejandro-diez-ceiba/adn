package com.ceiba.adn.databuilder;

import com.ceiba.adn.application.command.UserCommand;

public class UserTestDataBuilder {

    private static final int ID = 1;
    private static final String FULL_NAME = "Leonel Messi";
    private static final int TYPE_DOCUMENT = 1;
    private static final long DOCUMENT = 1017896451;
    private static final String PASSWORD = "123456";

    private int id;
    private String fullName;
    private int typeDocument;
    private long document;
    private String password;

    public UserTestDataBuilder() {
        this.id = ID;
        this.fullName = FULL_NAME;
        this.typeDocument = TYPE_DOCUMENT;
        this.document = DOCUMENT;
        this.password = PASSWORD;
    }

    public UserTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserTestDataBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserTestDataBuilder withTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
        return this;
    }

    public UserTestDataBuilder withDocument(long document) {
        this.document = document;
        return this;
    }

    public UserTestDataBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserCommand buildUserCommand() {
        return new UserCommand(
                this.id,
                this.fullName,
                this.typeDocument,
                this.document,
                this.password
        );
    }
}
