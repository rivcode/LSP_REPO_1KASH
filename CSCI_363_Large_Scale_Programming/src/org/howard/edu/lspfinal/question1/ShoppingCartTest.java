package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Book", 29.99);
        assertEquals(29.99, cart.getTotalCost());
        assertEquals(1, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for adding item with 0 price")
    void testAddItemWithZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Free Item", 0.0);
        });
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for adding item with negative price")
    void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Negative Price Item", -10.0);
        });
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Book", 29.99);
        assertTrue(cart.removeItem("Book"));
        assertEquals(0, cart.getCartSize());
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for removing non-existent item")
    void testRemoveNonExistentItem() {
        assertFalse(cart.removeItem("Non-existent Item"));
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for applying SAVE10")
    void testApplySave10() {
        cart.addItem("Item", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
        assertEquals(90.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for applying SAVE20")
    void testApplySave20() {
        cart.addItem("Item", 100.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
        assertEquals(80.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for applying invalid code")
    void testApplyInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("INVALID");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 20.0);
        assertEquals(30.0, cart.getTotalCost());
        assertEquals(2, cart.getCartSize());
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 100.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(160.0, cart.getTotalCost());
        assertEquals(2, cart.getCartSize());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost());
        assertEquals(0, cart.getCartSize());
    }
}

/**
 * References:
 * 
 * 1. JUnit 5 User Guide:
 *    https://junit.org/junit5/docs/current/user-guide/
 * 
 * 2. JUnit 5 Assertions:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html
 * 
 * 3. JUnit 5 Annotations:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/package-summary.html
 * 
 * 4. JUnit 5 DisplayName:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/DisplayName.html
 * 
 * 5. JUnit 5 BeforeEach:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/BeforeEach.html
 * 
 * 6. JUnit 5 Test:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/Test.html
 * 
 * 7. JUnit 5 assertThrows:
 *    https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/Assertions.html#assertThrows(java.lang.Class,org.junit.jupiter.api.function.Executable)
 */ 