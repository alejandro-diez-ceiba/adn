package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String fullName;

    @ManyToOne
    private TypeDocumentEntity typeDocument;

    @Column
    private long document;

    @Column
    private String address;

    @Column
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TypeDocumentEntity getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocumentEntity typeDocument) {
        this.typeDocument = typeDocument;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
