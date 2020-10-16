package com.ceiba.adn.infrastructure.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Entity(name = "Game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private Date launch;

    @Column
    private double price;

    @ManyToOne
    private PlatformEntity platform;

    @Column(nullable = true)
    private String image;

    @ManyToOne
    private LanguageEntity language;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLaunch() {
        return launch;
    }

    public void setLaunch(Date launch) {
        this.launch = launch;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
