package com.ceiba.adn.application.command;

public class KardexCommand {

    private long id;
    private long transaction;
    private boolean entryOrExit;
    private int quantity;
    private double price;
    private int provider;
    private int customer;
    private long game;

    public KardexCommand() {

    }

    public KardexCommand(long id, long transaction, boolean entryOrExit, int quantity, double price, int provider, int customer, long game) {
        this.id = id;
        this.transaction = transaction;
        this.entryOrExit = entryOrExit;
        this.quantity = quantity;
        this.price = price;
        this.provider = provider;
        this.customer = customer;
        this.game = game;
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

    public int getQuantity() {
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
