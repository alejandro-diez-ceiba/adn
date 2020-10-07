package com.ceiba.adn.infrastructure.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Entity(name = "Game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Date launch;

    @Column
    private double price;

    @ManyToOne
    private PlatformEntity platform;

    @Column
    private String image;

    @ManyToOne
    private LanguageEntity language;

}
