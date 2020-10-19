package com.ceiba.adn.domain;

import java.util.Date;

public class Kardex {

    private long id;
    private Date transaction;
    private boolean entryOrExit;
    private double quantity;
    private double price;
    private Provider provider;
    private Customer customer;
    private Game game;

    public Kardex(long id, Date transaction, boolean entryOrExit, double quantity, double price, Provider provider, Customer customer, Game game) {
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

    public Date getTransaction() {
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

    public Provider getProvider() {
        return provider;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Game getGame() {
        return game;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
