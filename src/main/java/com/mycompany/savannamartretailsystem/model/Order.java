package com.mycompany.savannamartretailsystem.model;

/**
 * Abstract base class for all orders.
 */
public abstract class Order {

    private final String orderId;
    private final String customerName;
    private final double orderTotal;
    private final OrderStatus status;

    public Order(String orderId, String customerName,
                 double orderTotal, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
        this.status = status;
    }

    public String getOrderId()        { return orderId; }
    public String getCustomerName()   { return customerName; }
    public double getOrderTotal()     { return orderTotal; }
    public OrderStatus getStatus()    { return status; }

    /** Subclasses decide how loyalty points are calculated. */
    public abstract double calculateLoyaltyPoints();
}