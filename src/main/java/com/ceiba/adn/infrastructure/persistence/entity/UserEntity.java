package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "User")
public class UserEntity {

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
    private String password;

}
