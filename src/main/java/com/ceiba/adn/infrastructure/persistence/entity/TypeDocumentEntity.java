package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "TypeDocument")
public class TypeDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
