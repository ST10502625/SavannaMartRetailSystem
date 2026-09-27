package com.mycompany.savannamartretailsystem.service;

/**
 * Recursive compounding bonus calculator for Question 3.
 *
 *  - First order earns a base bonus of 50 points.
 *  - Each subsequent order earns 1.5x the bonus of the previous order.
 *
 * Recurrence:
 *      f(1) = 50
 *      f(n) = f(n-1) * 1.5      for n > 1
 */
public class LoyaltyCalculator {

    public static final double BASE_BONUS = 50.0;
    public static final double MULTIPLIER = 1.5;

    /**
     * Recursively calculates the compounded bonus for a given order count.
     *
     * @param orderCount number of orders (must be >= 1)
     * @return compounded bonus (not rounded)
     */
    public static double calculateCompoundedBonus(int orderCount) {
        // Base case
        if (orderCount <= 1) {
            return BASE_BONUS;
        }
        // Recursive case
        return calculateCompoundedBonus(orderCount - 1) * MULTIPLIER;
    }
}