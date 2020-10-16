package com.ceiba.adn.databuilder;

import com.ceiba.adn.application.command.ProviderCommand;

public class ProviderTestDataBuilder {

    private static final int ID = 1;
    private static final String FULL_NAME = "GP";
    private static final int TYPE_DOCUMENT = 2;
    private static final long DOCUMENT = 92589647;
    private static final String ADDRESS = "California";
    private static final String PHONE = "124-78945-5810";

    private int id;
    private String fullName;
    private int typeDocument;
    private long document;
    private String address;
    private String phone;

    public ProviderTestDataBuilder() {
        this.id = ID;
        this.fullName = FULL_NAME;
        this.typeDocument = TYPE_DOCUMENT;
        this.document = DOCUMENT;
        this.address = ADDRESS;
        this.phone = PHONE;
    }

    public ProviderTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProviderTestDataBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public ProviderTestDataBuilder withTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
        return this;
    }

    public ProviderTestDataBuilder withDocument(long document) {
        this.document = document;
        return this;
    }

    public ProviderTestDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ProviderTestDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ProviderCommand buildProviderCommand() {
        return new ProviderCommand(
                this.id,
                this.fullName,
                this.typeDocument,
                this.document,
                this.address,
                this.phone
        );
    }
}
