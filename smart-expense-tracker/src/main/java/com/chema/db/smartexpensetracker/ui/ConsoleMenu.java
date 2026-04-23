package com.chema.db.smartexpensetracker.ui;

import com.chema.db.smartexpensetracker.service.TransactionService;

import java.util.Scanner;
import com.chema.db.smartexpensetracker.service.TransactionService;

public class ConsoleMenu {

    private TransactionService service;

    public ConsoleMenu(TransactionService service) {
        this.service = service;
    }

    public void start() {

        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("=== MENU ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Transaction");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    double value;

                    while (true) {
                        System.out.println("Please enter the income value:");
                        if (!sc.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a number.");
                            sc.next();
                            continue;
                        }
                        value = sc.nextDouble();
                        if (value < 0) {
                            System.out.println("Value must be 0 or greater.");
                            continue;
                        }
                        break;
                    }

                    break ;
                case 2:
                    break ;
                case 3:
                    break ;
                case 4:
                    break ;
                case 5:
                    run = false;
                    break ;
                default:
                    System.out.println("Please enter a valid value");
            }
        }
    }
}
