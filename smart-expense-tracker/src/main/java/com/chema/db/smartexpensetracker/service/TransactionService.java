package com.chema.db.smartexpensetracker.service;

import com.chema.db.smartexpensetracker.model.Category;
import com.chema.db.smartexpensetracker.model.TransactionType;
import com.chema.db.smartexpensetracker.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void showAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return ;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.INCOME) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }

    public void getMonthlySummary(int month, int year) {
        double income = 0;
        double spent = 0;
        double balance;

        for (Transaction t : transactions) {
            if (t.getDate().getMonthValue() == month && t.getDate().getYear() == year) {
                if (t.getType() == TransactionType.INCOME) {
                    income += t.getAmount();
                } else {
                    spent += t.getAmount();
                }
            }
        }
        balance = income - spent;
        System.out.println("The income in the month is: " + income);
        System.out.println("The spent in the month is " + spent);
        System.out.println("The balance is: " + balance);
    }

    public void getExpensesByCategory() {
        Map<Category, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.EXPENSE) {

                Category category = t.getCategory();

                if (!categoryTotals.containsKey(category)) {
                    categoryTotals.put(category, 0.0);
                }

                double currentAmount = categoryTotals.get(category);
                double newAmount = currentAmount + t.getAmount();

                categoryTotals.put(category, newAmount);
            }
        }

        for (Map.Entry<Category, Double> entry : categoryTotals.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
