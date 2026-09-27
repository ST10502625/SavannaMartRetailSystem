package com.mycompany.savannamartretailsystem.app;

import com.mycompany.savannamartretailsystem.exception.InvalidOrderException;
import com.mycompany.savannamartretailsystem.model.OrderStatus;
import com.mycompany.savannamartretailsystem.model.RetailOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Question 2 runner - capture orders, sort by total, print report.
 */
public class Question2App {

    public static void run(Scanner sc) {
        List<RetailOrder> orders = captureOrders(sc);

        // Sort by order total DESC using Comparator / Collections.sort
        Collections.sort(orders,
                Comparator.comparingDouble(RetailOrder::getOrderTotal).reversed());

        System.out.println();
        System.out.println("==============================================");
        System.out.println("SAVANNAMART ORDER REPORT (SORTED BY TOTAL, HIGHEST FIRST)");
        System.out.println("==============================================");

        double totalPoints = 0;
        for (RetailOrder o : orders) {
            o.printOrderDetails();
            System.out.println();
            totalPoints += o.calculateLoyaltyPoints();
        }

        System.out.println("==============================================");
        System.out.printf("TOTAL LOYALTY POINTS EARNED ACROSS ALL ORDERS: %.0f%n",
                totalPoints);
        System.out.println("==============================================");
    }

    /** Capture loop with validation — reusable by Question 3. */
    public static List<RetailOrder> captureOrders(Scanner sc) {
        List<RetailOrder> orders = new ArrayList<>();
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("- - - Capture Order - - -");

            while (true) {
                System.out.print("Enter order ID: ");
                String id = sc.nextLine().trim();

                System.out.print("Enter customer name: ");
                String name = sc.nextLine().trim();

                System.out.print("Enter order total: ");
                String totalStr = sc.nextLine().trim();

                System.out.print("Enter order status (PENDING, SHIPPED, DELIVERED, RETURNED): ");
                String statusStr = sc.nextLine().trim().toUpperCase();

                try {
                    double total = Double.parseDouble(totalStr);
                    OrderStatus status = OrderStatus.valueOf(statusStr);
                    RetailOrder order = new RetailOrder(id, name, total, status);
                    orders.add(order);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: Invalid order. Order total must be greater "
                            + "than 0 and customer name cannot be empty");
                } catch (InvalidOrderException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }

            System.out.print("Add another order? (y/n): ");
            keepGoing = sc.nextLine().trim().equalsIgnoreCase("y");
        }
        return orders;
    }
}