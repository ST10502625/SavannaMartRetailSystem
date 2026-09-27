package com.mycompany.savannamartretailsystem.model;

import com.mycompany.savannamartretailsystem.exception.InvalidSalesDataException;

public class SalesData {

    private final double[][] sales;

    public SalesData(double[][] sales) throws InvalidSalesDataException {
        validate(sales);
        this.sales = sales;
    }

    private void validate(double[][] data) throws InvalidSalesDataException {
        if (data == null)
            throw new InvalidSalesDataException("Sales data cannot be null.");
        if (data.length != Store.values().length)
            throw new InvalidSalesDataException("Expected "
                    + Store.values().length + " stores, got " + data.length);
        for (int r = 0; r < data.length; r++) {
            if (data[r] == null || data[r].length != Category.values().length)
                throw new InvalidSalesDataException("Row " + r
                        + " must contain exactly " + Category.values().length + " values.");
            for (int c = 0; c < data[r].length; c++)
                if (data[r][c] < 0)
                    throw new InvalidSalesDataException("Negative value at [" + r + "][" + c + "]");
        }
    }

    public double get(int store, int cat) { return sales[store][cat]; }
    public int getStoreCount()            { return sales.length; }
    public int getCategoryCount()         { return sales[0].length; }
}