package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "TypeDocument")
public class TypeDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String description;

}
