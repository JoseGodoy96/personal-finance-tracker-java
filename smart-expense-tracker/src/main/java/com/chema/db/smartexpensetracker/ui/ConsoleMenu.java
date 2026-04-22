package com.chema.db.smartexpensetracker.ui;

import java.util.Scanner;

public class ConsoleMenu {

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
