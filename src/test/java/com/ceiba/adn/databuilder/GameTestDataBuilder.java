package com.ceiba.adn.databuilder;

import com.ceiba.adn.application.command.GameCommand;

import java.util.Date;

public class GameTestDataBuilder {

    private static final int ID = 2;
    private static final String NAME = "Good of War";
    private static final long LAUNCH = new Date().getTime();
    private static final double PRICE = 125895.22;
    private static final String IMAGE = null;
    private static final int PLATFORM = 1;
    private static final int LANGUAGE = 1;

    private long id;
    private String name;
    private long launch;
    private double price;
    private String image;
    private int platform;
    private int language;

    public GameTestDataBuilder() {
        this.id = ID;
        this.name = NAME;
        this.launch = LAUNCH;
        this.price = PRICE;
        this.image = IMAGE;
        this.platform = PLATFORM;
        this.language = LANGUAGE;
    }

    public GameTestDataBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public GameTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public GameTestDataBuilder withaunch(long launch) {
        this.launch = launch;
        return this;
    }

    public GameTestDataBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public GameTestDataBuilder withImage(String image) {
        this.image = image;
        return this;
    }

    public GameTestDataBuilder withPlatform(int platform) {
        this.platform = platform;
        return this;
    }

    public GameTestDataBuilder withLanguage(int language) {
        this.language = language;
        return this;
    }

    public GameCommand buildGameCommand() {
        return new GameCommand(
                this.id,
                this.name,
                this.launch,
                this.price,
                this.image,
                this.platform,
                this.language
        );
    }
}
