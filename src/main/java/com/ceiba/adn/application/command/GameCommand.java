package com.ceiba.adn.application.command;

public class GameCommand {

    private long id;
    private String name;
    private long launch;
    private double price;
    private String image;
    private int platform;
    private int language;

    public GameCommand() {

    }

    public GameCommand(long id, String name, long launch, double price, String image, int platform, int language) {
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

    public long getLaunch() {
        return launch;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getPlatform() {
        return platform;
    }

    public int getLanguage() {
        return language;
    }
}
