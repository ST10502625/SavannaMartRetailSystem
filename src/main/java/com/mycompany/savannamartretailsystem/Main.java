package com.mycompany.savannamartretailsystem;

import com.mycompany.savannamartretailsystem.app.Question1App;
import com.mycompany.savannamartretailsystem.app.Question2App;
import com.mycompany.savannamartretailsystem.app.Question3App;

import java.util.Scanner;

/**
 * Entry point for the SavannaMart Retail System.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("SavannaMart Retail System");
        System.out.println("1) Question 1 - Sales Analytics");
        System.out.println("2) Question 2 - Order Management");
        System.out.println("3) Question 3 - Repeat Customer Bonus");
        System.out.print("Choose (1/2/3): ");

        String choice = sc.nextLine().trim();

        switch (choice) {
            case "1" -> Question1App.run();
            case "2" -> Question2App.run(sc);
            case "3" -> Question3App.run(sc);
            default  -> System.out.println("Invalid choice.");
        }
    }
}