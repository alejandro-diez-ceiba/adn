package com.ceiba.adn.databuilder;

import com.ceiba.adn.application.command.CustomerCommand;

public class CustomerTestDataBuilder {

    private static final int ID = 1;
    private static final String FULL_NAME = "Luca Modric";
    private static final int TYPE_DOCUMENT = 1;
    private static final long DOCUMENT = 1017896452;
    private static final String ADDRESS = "Croacia";
    private static final String PHONE = "124-78945-5210";

    private int id;
    private String fullName;
    private int typeDocument;
    private long document;
    private String address;
    private String phone;

    public CustomerTestDataBuilder() {
        this.id = ID;
        this.fullName = FULL_NAME;
        this.typeDocument = TYPE_DOCUMENT;
        this.document = DOCUMENT;
        this.address = ADDRESS;
        this.phone = PHONE;
    }

    public CustomerTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CustomerTestDataBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public CustomerTestDataBuilder withTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
        return this;
    }

    public CustomerTestDataBuilder withDocument(long document) {
        this.document = document;
        return this;
    }

    public CustomerTestDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerTestDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerCommand buildCustomerCommand() {
        return new CustomerCommand(
                this.id,
                this.fullName,
                this.typeDocument,
                this.document,
                this.address,
                this.phone
        );
    }
}
