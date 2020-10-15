package com.ceiba.adn.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Kardex")
public class KardexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Date transaction;

    @Column
    private boolean entryOrExit;

    @Column
    private double quantity;

    @Column
    private double price;

    @ManyToOne(optional = true)
    private ProviderEntity provider;

    @ManyToOne(optional = true)
    private CustomerEntity customer;

    @ManyToOne
    private GameEntity game;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTransaction() {
        return transaction;
    }

    public void setTransaction(Date transaction) {
        this.transaction = transaction;
    }

    public boolean isEntryOrExit() {
        return entryOrExit;
    }

    public void setEntryOrExit(boolean entryOrExit) {
        this.entryOrExit = entryOrExit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProviderEntity getProvider() {
        return provider;
    }

    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
