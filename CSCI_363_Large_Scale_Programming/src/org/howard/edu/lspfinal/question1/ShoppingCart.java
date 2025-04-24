package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be non-negative)
     * @throws IllegalArgumentException if price is negative
     */
    public void addItem(String itemName, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the shopping cart.
     * 
     * @param itemName the name of the item to remove
     * @return true if the item was removed, false if the item was not found
     */
    public boolean removeItem(String itemName) {
        return items.remove(itemName) != null;
    }

    /**
     * Returns the current number of items in the cart.
     * 
     * @return the number of items in the cart
     */
    public int getCartSize() {
        return items.size();
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     * 
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     * 
     * @param code  the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     * Useful for testing.
     * 
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}

/**
 * References:
 * 
 * 1. Java HashMap Documentation:
 *    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html
 * 
 * 2. Java Exception Handling:
 *    https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * 
 * 3. Java Switch Statement:
 *    https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
 * 
 * 4. Java Collections Framework:
 *    https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
 * 
 * 5. Java Map Interface:
 *    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
 */ 