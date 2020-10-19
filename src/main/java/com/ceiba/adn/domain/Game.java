package com.ceiba.adn.domain;

import java.util.Date;

public class Game {

    private long id;
    private String name;
    private Date launch;
    private double price;
    private String image;
    private Platform platform;
    private Language language;

    public Game(long id) {
        this.id = id;
    }

    public Game(long id, String name, Date launch, double price, String image, Platform platform, Language language) {
        this.id = id;
        this.name = name;
        this.launch = launch;
        this.price = price;
        this.image = image;
        this.platform = platform;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLaunch() {
        return launch;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Language getLanguage() {
        return language;
    }
}
