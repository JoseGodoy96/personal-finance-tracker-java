package com.chema.db.smartexpensetracker.ui;

import com.chema.db.smartexpensetracker.model.TransactionType;
import com.chema.db.smartexpensetracker.service.TransactionService;

import java.lang.reflect.Type;
import java.util.Scanner;
import com.chema.db.smartexpensetracker.service.TransactionService;
import com.chema.db.smartexpensetracker.model.Category;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

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
                        sc.nextLine();
                        if (value < 0) {
                            System.out.println("Value must be 0 or greater.");
                            continue;
                        }
                        break;
                    }

                    Category category = null;
                    for (Category c : Category.values()) {
                        System.out.println("- " + c);
                    }

                    while (category == null) {
                        System.out.println("Select a category from the list:");
                        String input = sc.nextLine();

                        try {
                            category = Category.valueOf(input.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid category. try again");
                        }
                    }

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    LocalDate date = null;
                    while (date == null) {
                        System.out.println("Please enter a date (YYYY-MM-DD): ");
                        String dateInput = sc.nextLine();
                        try {
                            date = LocalDate.parse(dateInput, formatter);
                            if (date.isAfter(LocalDate.now())) {
                                System.out.println("Date cannot be in the future");
                                date = null;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid format. please enter YYYY-MM-DD");
                        }
                    }

                    String description;

                    while (true) {
                        System.out.print("Please enter a description: ");
                        description = sc.nextLine().trim();

                        if (description.isEmpty()) {
                            System.out.println("Description can't be empty");
                            continue;
                        }

                        if (description.length() < 3) {
                            System.out.println("must be at least 3 characters");
                            continue;
                        }

                        TransactionType type = TransactionType.INCOME;
                        
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
