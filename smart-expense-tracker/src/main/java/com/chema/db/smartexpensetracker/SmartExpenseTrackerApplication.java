package com.chema.db.smartexpensetracker;

import com.chema.db.smartexpensetracker.service.TransactionService;
import com.chema.db.smartexpensetracker.ui.ConsoleMenu;

public class SmartExpenseTrackerApplication {

    public static void main(String[] args) {

        TransactionService service = new TransactionService();
        ConsoleMenu menu = new ConsoleMenu(service);
        menu.start();
    }
}
