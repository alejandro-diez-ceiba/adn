package com.ceiba.adn.databuilder;

import com.ceiba.adn.application.command.KardexCommand;
import com.ceiba.adn.domain.Kardex;

import java.util.Date;

public class KardexTestDatauilder {

    private static final long ID = 2;
    private static final long TRANSACTION = new Date().getTime();
    private static final boolean ENTRY_OR_EXIT = true;
    private static final int QUANTITY = 1;
    private static final double PRICE = 125899;
    private static final int PROVIDER = 1;
    private static final int CUSTOMER = 0;
    private static final long GAME = 1;

    private long id;
    private long transaction;
    private boolean entryOrExit;
    private int quantity;
    private double price;
    private int provider;
    private int customer;
    private long game;

    public KardexTestDatauilder() {
        this.id = ID;
        this.transaction = TRANSACTION;
        this.entryOrExit = ENTRY_OR_EXIT;
        this.quantity = QUANTITY;
        this.price = PRICE;
        this.provider = PROVIDER;
        this.customer = CUSTOMER;
        this.game = GAME;
    }

    public KardexTestDatauilder withId(long id) {
        this.id = id;
        return this;
    }

    public KardexTestDatauilder withTransaction(long transaction) {
        this.transaction = transaction;
        return this;
    }

    public KardexTestDatauilder withEntryOrExit(boolean entryOrExit) {
        this.entryOrExit = entryOrExit;
        return this;
    }

    public KardexTestDatauilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public KardexTestDatauilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public KardexTestDatauilder withProvider(int provider) {
        this.provider = provider;
        return this;
    }

    public KardexTestDatauilder withCustomer(int customer) {
        this.customer = customer;
        return this;
    }

    public KardexTestDatauilder withGame(long game) {
        this.game = game;
        return this;
    }

    public Kardex build() {
        return new Kardex(
                this.id,
                new Date(this.transaction),
                this.entryOrExit,
                this.quantity,
                this.price,
                null,
                null,
                null
        );
    }

    public KardexCommand buildKardexCommand() {
        return new KardexCommand(
                this.id,
                this.transaction,
                this.entryOrExit,
                this.quantity,
                this.price,
                this.provider,
                this.customer,
                this.game
        );
    }
}
