package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.howard.edu.lsp.assignment6.IntegerSetException;

/**
 * A class representing a set of integers with various set operations.
 * This implementation ensures no duplicate elements are stored.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor
     */
    public IntegerSet() {
    }

    /**
     * Constructor that takes an ArrayList of integers
     * @param set The ArrayList to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set
     * @return The number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal
     * @param o The object to compare with
     * @return true if the sets contain the same elements (in any order), false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        if (set.size() != that.set.size()) return false;
        return set.containsAll(that.set) && that.set.containsAll(set);
    }

    /**
     * Checks if the set contains a specific value
     * @param value The value to check for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set
     * @return The largest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("IntegerSet is empty, cannot find largest element.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set
     * @return The smallest integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("IntegerSet is empty, cannot find smallest element.");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it's not already present
     * @param item The integer to add
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists
     * @param item The integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs set union operation
     * @param intSetb The set to union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            add(item);
        }
    }

    /**
     * Performs set intersection operation
     * @param intSetb The set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs set difference operation (s1 - s2)
     * @param intSetb The set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs set complement operation
     * @param intSetb The set to complement against
     */
    public void complement(IntegerSet intSetb) {
        IntegerSet temp = new IntegerSet();
        temp.set = new ArrayList<>(set);
        set.clear();
        for (int i = -1000; i <= 1000; i++) {
            if (!temp.contains(i)) {
                set.add(i);
            }
        }
    }

    /**
     * Checks if the set is empty
     * @return true if the set contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns string representation of the set
     * @return A string containing the elements of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * @param b The IntegerSet to compare against.
     * @return true if the sets are equal, false otherwise.
     */
    public boolean equals(IntegerSet b) {
        if (b == null) return false;
        return this.equals((Object)b);
    }

    /*
     * References:
     * 1. Java ArrayList Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
     * 2. Java Collections Framework: https://docs.oracle.com/javase/8/docs/technotes/guides/collections/
     * 3. Java Set Interface: https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
     * 4. Set Theory in Mathematics: https://www.mathsisfun.com/sets/sets-introduction.html
     * 5. Set Operations in Java: https://www.geeksforgeeks.org/set-operations-in-java/
     */
} 