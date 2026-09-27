package com.mycompany.savannamartretailsystem.service;

import com.mycompany.savannamartretailsystem.model.SalesData;
import com.mycompany.savannamartretailsystem.model.Store;

public class SalesAnalytics {

    private final SalesData data;

    public SalesAnalytics(SalesData data) { this.data = data; }
    public SalesData getData() { return data; }

    public double[] totalPerStore() {
        int rows = data.getStoreCount(), cols = data.getCategoryCount();
        double[] totals = new double[rows];
        for (int r = 0; r < rows; r++) {
            double sum = 0;
            for (int c = 0; c < cols; c++) sum += data.get(r, c);
            totals[r] = sum;
        }
        return totals;
    }

    public double[] totalPerCategory() {
        int rows = data.getStoreCount(), cols = data.getCategoryCount();
        double[] totals = new double[cols];
        for (int c = 0; c < cols; c++) {
            double sum = 0;
            for (int r = 0; r < rows; r++) sum += data.get(r, c);
            totals[c] = sum;
        }
        return totals;
    }

    public double grandTotal() {
        double total = 0;
        for (double v : totalPerStore()) total += v;
        return total;
    }

    public int topStoreIndex() {
        double[] t = totalPerStore();
        int idx = 0;
        for (int i = 1; i < t.length; i++) if (t[i] > t[idx]) idx = i;
        return idx;
    }

    public int lowestCategoryIndex() {
        double[] t = totalPerCategory();
        int idx = 0;
        for (int i = 1; i < t.length; i++) if (t[i] < t[idx]) idx = i;
        return idx;
    }

    public Store[] rankStoresDescending() {
        double[] totals = totalPerStore();
        double[] sorted = totals.clone();
        Sorter.bubbleSortDescending(sorted);

        Store[] ranked = new Store[totals.length];
        boolean[] used = new boolean[totals.length];
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < totals.length; j++) {
                if (!used[j] && totals[j] == sorted[i]) {
                    ranked[i] = Store.values()[j];
                    used[j] = true;
                    break;
                }
            }
        }
        return ranked;
    }
}