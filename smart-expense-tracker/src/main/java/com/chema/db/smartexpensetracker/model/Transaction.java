package com.chema.db.smartexpensetracker.model;

import java.time.LocalDate;

public class Transaction {

    private static int counter = 1;

    private final int id;
    private final double amount;
    private final Category category;
    private final LocalDate date;
    private final String description;
    private final TransactionType type;

    public Transaction(double amount, Category category, LocalDate date, String description, TransactionType type) {
        this.id = counter++;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public  String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
