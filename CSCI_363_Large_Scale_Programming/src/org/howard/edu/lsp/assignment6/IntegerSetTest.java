package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for IntegerSet.
 */
public class IntegerSetTest {
    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        setA.add(1);
        setA.add(2);
        setA.clear();
        assertTrue(setA.isEmpty(), "Set should be empty after clear");
        assertEquals(0, setA.length(), "Set length should be 0 after clear");
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, setA.length(), "Length of empty set should be 0");
        setA.add(1);
        assertEquals(1, setA.length(), "Length after adding one element should be 1");
        setA.add(2);
        setA.add(3);
        assertEquals(3, setA.length(), "Length after adding multiple elements");
        setA.add(3); // Adding duplicate
        assertEquals(3, setA.length(), "Length should not change after adding duplicate");
        setA.remove(1);
        assertEquals(2, setA.length(), "Length after removing an element");
        setA.clear();
        assertEquals(0, setA.length(), "Length after clear should be 0");
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(1);
        assertTrue(setA.equals(setB), "Sets with same elements in different order should be equal");

        setB.add(3);
        assertFalse(setA.equals(setB), "Sets with different elements should not be equal");

        setA.add(3);
        assertTrue(setA.equals(setB), "Sets with same elements should be equal");

        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();
        assertTrue(setC.equals(setD), "Two empty sets should be equal");

        setC.add(1);
        assertFalse(setC.equals(setD), "Empty set and non-empty set should not be equal");
        assertFalse(setD.equals(setC), "Non-empty set and empty set should not be equal");

        assertFalse(setA.equals(null), "Set should not be equal to null");
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        assertFalse(setA.contains(1), "Empty set should not contain 1");
        setA.add(1);
        assertTrue(setA.contains(1), "Set should contain 1 after adding it");
        setA.add(2);
        assertTrue(setA.contains(1), "Set should still contain 1");
        assertTrue(setA.contains(2), "Set should contain 2");
        assertFalse(setA.contains(3), "Set should not contain 3");
        setA.remove(1);
        assertFalse(setA.contains(1), "Set should not contain 1 after removing it");
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        setA.add(1);
        setA.add(5);
        setA.add(2);
        assertEquals(5, setA.largest(), "Largest element should be 5");

        setA.add(10);
        assertEquals(10, setA.largest(), "Largest element should be 10");

        setA.remove(10);
        assertEquals(5, setA.largest(), "Largest element should be 5 after removing 10");
    }

    @Test
    @DisplayName("Test case for largest throws exception when set is empty")
    public void testLargest_ThrowsExceptionOnEmptySet() {
        IntegerSetException exception = assertThrows(IntegerSetException.class, () -> {
            setA.largest();
        });
        assertEquals("IntegerSet is empty, cannot find largest element.", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        setA.add(5);
        setA.add(1);
        setA.add(2);
        assertEquals(1, setA.smallest(), "Smallest element should be 1");

        setA.add(0);
        assertEquals(0, setA.smallest(), "Smallest element should be 0");

        setA.remove(0);
        assertEquals(1, setA.smallest(), "Smallest element should be 1 after removing 0");
    }

    @Test
    @DisplayName("Test case for smallest throws exception when set is empty")
    public void testSmallest_ThrowsExceptionOnEmptySet() {
        IntegerSetException exception = assertThrows(IntegerSetException.class, () -> {
            setA.smallest();
        });
        assertEquals("IntegerSet is empty, cannot find smallest element.", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        assertTrue(setA.isEmpty(), "Set should be initially empty");
        setA.add(1);
        assertFalse(setA.isEmpty(), "Set should not be empty after add");
        assertEquals(1, setA.length(), "Length should be 1 after adding one element");
        assertTrue(setA.contains(1), "Set should contain the added element");

        setA.add(1); // Add duplicate
        assertEquals(1, setA.length(), "Length should remain 1 after adding duplicate");

        setA.add(2);
        assertEquals(2, setA.length(), "Length should be 2 after adding second element");
        assertTrue(setA.contains(1), "Set should still contain 1");
        assertTrue(setA.contains(2), "Set should contain 2");
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals(3, setA.length());

        setA.remove(2); // Remove existing element
        assertEquals(2, setA.length(), "Length should decrease after removing existing element");
        assertFalse(setA.contains(2), "Set should not contain removed element");
        assertTrue(setA.contains(1), "Set should still contain other elements");
        assertTrue(setA.contains(3), "Set should still contain other elements");

        setA.remove(4); // Remove non-existent element
        assertEquals(2, setA.length(), "Length should not change after removing non-existent element");

        setA.remove(1);
        setA.remove(3);
        assertTrue(setA.isEmpty(), "Set should be empty after removing all elements");
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);

        setA.union(setB);
        assertEquals(3, setA.length(), "Union should have 3 elements");
        assertTrue(setA.contains(1), "Union should contain 1");
        assertTrue(setA.contains(2), "Union should contain 2");
        assertTrue(setA.contains(3), "Union should contain 3");

        IntegerSet setC = new IntegerSet(); // Empty set
        setA.union(setC);
        assertEquals(3, setA.length(), "Union with empty set should not change the set");

        setC.union(setA);
        assertTrue(setC.equals(setA), "Union of empty set with setA should make it equal to setA");
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);

        setA.intersect(setB);
        assertEquals(2, setA.length(), "Intersection should have 2 elements");
        assertFalse(setA.contains(1), "Intersection should not contain 1");
        assertTrue(setA.contains(2), "Intersection should contain 2");
        assertTrue(setA.contains(3), "Intersection should contain 3");
        assertFalse(setA.contains(4), "Intersection should not contain 4");

        IntegerSet setC = new IntegerSet(); // Empty set
        setA.intersect(setC);
        assertTrue(setA.isEmpty(), "Intersection with empty set should result in an empty set");

        setA.add(1); setA.add(2);
        setC.add(3); setC.add(4);
        setA.intersect(setC);
        assertTrue(setA.isEmpty(), "Intersection of disjoint sets should be empty");
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(4);

        setA.diff(setB);
        assertEquals(2, setA.length(), "Diff should have 2 elements");
        assertTrue(setA.contains(1), "Diff should contain 1");
        assertFalse(setA.contains(2), "Diff should not contain 2");
        assertTrue(setA.contains(3), "Diff should contain 3");
        assertFalse(setA.contains(4), "Diff should not contain 4");

        // Test diff with empty set
        IntegerSet setC = new IntegerSet();
        setA.diff(setC);
        assertEquals(2, setA.length(), "Diff with empty set should not change the set");

        // Test diff resulting in empty set
        setA.add(2);
        setB.clear();
        setB.add(1); setB.add(2); setB.add(3);
        setA.diff(setB);
        assertTrue(setA.isEmpty(), "Diff resulting in empty set");
    }

    @Test
    @DisplayName("Test case for complement - assuming universe -1000 to 1000")
    public void testComplement() {
        // NOTE: This test depends heavily on the specific implementation 
        // of complement which seems to assume a universe of -1000 to 1000.
        setA.add(1);
        setA.add(1000);
        setA.add(-500);

        setA.complement(null); // Parameter not used in current implementation, but testing
        
        assertEquals(2001 - 3, setA.length(), "Complement should contain all numbers from -1000 to 1000 except 1, 1000, -500");
        assertFalse(setA.contains(1), "Complement should not contain 1");
        assertFalse(setA.contains(1000), "Complement should not contain 1000");
        assertFalse(setA.contains(-500), "Complement should not contain -500");
        assertTrue(setA.contains(0), "Complement should contain 0");
        assertTrue(setA.contains(-1000), "Complement should contain -1000");
        assertFalse(setA.contains(1001), "Complement should not contain 1001 (outside assumed universe)");
        assertFalse(setA.contains(-1001), "Complement should not contain -1001 (outside assumed universe)");

        // Test complement of an empty set (should contain all elements in the universe)
        setB.complement(null);
        assertEquals(2001, setB.length(), "Complement of empty set should contain all elements in the universe");
        assertTrue(setB.contains(0));
        assertTrue(setB.contains(1000));
        assertTrue(setB.contains(-1000));
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(setA.isEmpty(), "Newly created set should be empty");
        setA.add(1);
        assertFalse(setA.isEmpty(), "Set should not be empty after adding an element");
        setA.remove(1);
        assertTrue(setA.isEmpty(), "Set should be empty after removing the only element");
        setA.add(1);
        setA.add(2);
        setA.clear();
        assertTrue(setA.isEmpty(), "Set should be empty after clear");
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        assertEquals("[]", setA.toString(), "toString of empty set");
        setA.add(1);
        assertEquals("[1]", setA.toString(), "toString with one element");
        setA.add(3);
        setA.add(2);
        // Note: ArrayList toString order is not guaranteed, but usually insertion order
        // For a Set, order doesn't matter, but the elements should be present.
        // A more robust test might parse the string, but this is simpler.
        String str = setA.toString();
        assertTrue(str.startsWith("[") && str.endsWith("]"), "toString format check");
        assertTrue(str.contains("1"), "toString should contain 1");
        assertTrue(str.contains("2"), "toString should contain 2");
        assertTrue(str.contains("3"), "toString should contain 3");
        assertEquals(3, setA.length()); // Ensure it didn't change the set
    }
} 