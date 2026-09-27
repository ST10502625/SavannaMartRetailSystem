package com.mycompany.savannamartretailsystem.app;

import com.mycompany.savannamartretailsystem.model.RetailOrder;
import com.mycompany.savannamartretailsystem.service.LoyaltyCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Question 3 runner:
 *  - Capture orders (reuses Q2 capture logic).
 *  - Count orders per customer using a HashMap.
 *  - Print a Repeat Customer Bonus Report using the recursive bonus.
 */
public class Question3App {

    public static void run(Scanner sc) {

        // (1) Capture orders using the same logic as Q2
        List<RetailOrder> orders = Question2App.captureOrders(sc);

        // (2) Build HashMap<customerName, orderCount>
        Map<String, Integer> counts = new HashMap<>();
        for (RetailOrder o : orders) {
            counts.merge(o.getCustomerName(), 1, Integer::sum);
        }

        // (3) Report - only customers with more than 1 order
        System.out.println();
        System.out.println("REPEAT CUSTOMER BONUS REPORT");

        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            int count = e.getValue();
            if (count > 1) {
                double bonus   = LoyaltyCalculator.calculateCompoundedBonus(count);
                long   rounded = Math.round(bonus);
                System.out.printf("CUSTOMER: %s%n", e.getKey());
                System.out.printf("ORDERS PLACED: %d%n", count);
                System.out.printf("COMPOUNDED BONUS: %d points%n%n", rounded);
            }
        }
    }
}