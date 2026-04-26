package com.chema.db.smartexpensetracker.ui;

import com.chema.db.smartexpensetracker.model.Transaction;
import com.chema.db.smartexpensetracker.model.TransactionType;
import com.chema.db.smartexpensetracker.service.TransactionService;
import java.util.Scanner;
import com.chema.db.smartexpensetracker.model.Category;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;


public class ConsoleMenu {

    private final TransactionService service;

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

            int option;

            while (true) {
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid option");
                    sc.next();

                    continue;
                }
                option = sc.nextInt();
                sc.nextLine();

                break;
            }


            switch (option) {
                case 1:

                    double value;

                    value = readValue(sc, "Please enter the income value:");

                    Category category;

                    category = readCategory(sc);

                    LocalDate date;

                    date = readDate(sc);

                    String description;

                    description = readDescription(sc);

                    TransactionType type = TransactionType.INCOME;

                    Transaction transaction = new Transaction(value, category, date, description, type);
                    service.addTransaction(transaction);
                    System.out.println("Income added successfully.");
                    System.out.println("--------------------");
                    break ;
                case 2:
                    double valueExpense;

                    valueExpense = readValue(sc, "Please enter the expense value:");

                    Category categoryExpense;

                    categoryExpense = readCategory(sc);

                    LocalDate dateExpense;

                    dateExpense = readDate(sc);

                    String descriptionExpense;

                    descriptionExpense = readDescription(sc);

                    TransactionType typeExpense = TransactionType.EXPENSE;

                    Transaction transactionExpense = new Transaction(valueExpense, categoryExpense, dateExpense, descriptionExpense, typeExpense);
                    service.addTransaction(transactionExpense);
                    System.out.println("Expense added successfully.");
                    System.out.println("--------------------");
                    break ;
                case 3:
                    service.showAllTransactions();
                    System.out.println("--------------------");
                    break ;
                case 4:
                    double balance = service.getBalance();
                    System.out.println("The actual balance is: " + balance + "€");
                    System.out.println("--------------------");
                    break ;
                case 5:
                    System.out.println("Exiting program. Bye!");
                    run = false;
                    break ;
                default:
                    System.out.println("Please enter a valid value");
                    System.out.println("--------------------");
            }
        }
    }

    private double readValue(Scanner sc, String message) {

        double value;

        while (true) {
            System.out.println(message);
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
            return value;
        }
    }

    private Category readCategory(Scanner sc) {
        for (Category c : Category.values()) {
            System.out.println("- " + c);
        }

        while (true) {
            System.out.println("Select a category from the list:");
            String input = sc.nextLine();

            try {
                return Category.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. try again");
            }
        }
    }

    private LocalDate readDate(Scanner sc) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("Please enter a date (YYYY-MM-DD): ");
            String dateInput = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateInput, formatter);
                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Date cannot be in the future");
                    continue ;
                }
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. please enter YYYY-MM-DD");
            }
        }
    }

    private String readDescription(Scanner sc) {
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

            return description;
        }
    }

}
