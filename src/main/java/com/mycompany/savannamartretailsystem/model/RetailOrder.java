package com.mycompany.savannamartretailsystem.model;

import com.mycompany.savannamartretailsystem.exception.InvalidOrderException;

/**
 * Concrete order type - validates input and awards loyalty points.
 */
public class RetailOrder extends Order {

    public RetailOrder(String orderId, String customerName,
                       double orderTotal, OrderStatus status)
            throws InvalidOrderException {

        super(orderId, customerName, orderTotal, status);

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidOrderException(
                "Invalid order. Order total must be greater than 0 and "
                + "customer name cannot be empty");
        }
        if (orderTotal <= 0) {
            throw new InvalidOrderException(
                "Invalid order. Order total must be greater than 0 and "
                + "customer name cannot be empty");
        }
    }

    /** 1 loyalty point for every full R100 spent. */
    @Override
    public double calculateLoyaltyPoints() {
        return Math.floor(getOrderTotal() / 100.0);
    }

    /** Prints one order block. */
    public void printOrderDetails() {
        System.out.printf("ORDER ID: %s%n",   getOrderId());
        System.out.printf("CUSTOMER: %s%n",   getCustomerName());
        System.out.printf("TOTAL: R%.2f%n",   getOrderTotal());
        System.out.printf("STATUS: %s%n",     getStatus());
        System.out.printf("PTS: %.0f%n",      calculateLoyaltyPoints());
    }
}