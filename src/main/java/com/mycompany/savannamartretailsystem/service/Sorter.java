package com.mycompany.savannamartretailsystem.service;

public class Sorter {

    /** Custom bubble sort - descending. No built-in sort used. */
    public static void bubbleSortDescending(double[] values) {
        if (values == null || values.length < 2) return;
        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (values[j] < values[j + 1]) {
                    double t = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}