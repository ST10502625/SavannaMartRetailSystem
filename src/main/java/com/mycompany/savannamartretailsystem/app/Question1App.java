package com.mycompany.savannamartretailsystem.app;

import com.mycompany.savannamartretailsystem.exception.InvalidSalesDataException;
import com.mycompany.savannamartretailsystem.model.Category;
import com.mycompany.savannamartretailsystem.model.SalesData;
import com.mycompany.savannamartretailsystem.model.Store;
import com.mycompany.savannamartretailsystem.service.SalesAnalytics;

import java.util.Scanner;

public class Question1App {

    public static void run() {
        Scanner sc = new Scanner(System.in);
        double[][] sales = new double[Store.values().length][Category.values().length];

        for (Store s : Store.values()) {
            for (Category c : Category.values()) {
                System.out.print("Enter " + c.getDisplayName()
                        + " sales for " + s.getDisplayName() + ": ");
                sales[s.ordinal()][c.ordinal()] = sc.nextDouble();
            }
        }

        try {
            SalesAnalytics a = new SalesAnalytics(new SalesData(sales));
            printReport(a);
        } catch (InvalidSalesDataException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    private static void printReport(SalesAnalytics a) {
        double[] storeTotals = a.totalPerStore();
        double[] catTotals   = a.totalPerCategory();
        double   grand       = a.grandTotal();
        int      topStoreIdx = a.topStoreIndex();
        int      lowCatIdx   = a.lowestCategoryIndex();
        Store[]  ranked      = a.rankStoresDescending();

        System.out.println();
        System.out.println("SAVANNAMAT SALES ANALYTICS REPORT");
        System.out.println();

        System.out.printf("%-15s", "");
        for (Category c : Category.values())
            System.out.printf("%-12s", c.getDisplayName().toUpperCase());
        System.out.printf("%-12s%n", "TOTAL");

        for (Store s : Store.values()) {
            System.out.printf("%-15s", s.getDisplayName());
            for (Category c : Category.values())
                System.out.printf("%-12.0f", a.getData().get(s.ordinal(), c.ordinal()));
            System.out.printf("%-12.0f%n", storeTotals[s.ordinal()]);
        }

        System.out.printf("%-15s", "CATEGORY TOTALS");
        for (double t : catTotals) System.out.printf("%-12.0f", t);
        System.out.println();

        System.out.printf("%nGRAND TOTAL SALES: %.0f%n%n", grand);

        System.out.printf("STORE WITH THE HIGHEST TOTAL SALES: %s (%.0f)%n",
                Store.values()[topStoreIdx].getDisplayName(), storeTotals[topStoreIdx]);
        System.out.printf("CATEGORY WITH THE LOWEST TOTAL SALES: %s (%.0f)%n%n",
                Category.values()[lowCatIdx].getDisplayName(), catTotals[lowCatIdx]);

        System.out.println("STORE RANKING (HIGHEST TO LOWEST SALES)");
        System.out.println();
        for (int i = 0; i < ranked.length; i++) {
            int idx = ranked[i].ordinal();
            System.out.printf("%d. %-15s %.0f%n",
                    i + 1, ranked[i].getDisplayName(), storeTotals[idx]);
        }
    }
}