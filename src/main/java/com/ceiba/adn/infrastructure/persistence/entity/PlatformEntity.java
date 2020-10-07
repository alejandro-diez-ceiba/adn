package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity(name = "Platform")
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

}
