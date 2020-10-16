package com.ceiba.adn.application.command;

public class KardexCommand {

    private long id;
    private long transaction;
    private boolean entryOrExit;
    private double quantity;
    private double price;
    private int provider;
    private int customer;
    private long game;

    public KardexCommand() {

    }

    public long getId() {
        return id;
    }

    public long getTransaction() {
        return transaction;
    }

    public boolean isEntryOrExit() {
        return entryOrExit;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getProvider() {
        return provider;
    }

    public int getCustomer() {
        return customer;
    }

    public long getGame() {
        return game;
    }
}
