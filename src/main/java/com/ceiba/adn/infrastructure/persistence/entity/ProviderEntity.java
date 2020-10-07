package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "Provider")
public class ProviderEntity {

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

}
