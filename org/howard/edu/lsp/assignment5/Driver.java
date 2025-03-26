package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * Driver class to test the IntegerSet implementation
 */
public class Driver {
    public static void main(String[] args) {
        // Test constructor and add methods
        System.out.println("Testing constructor and add methods:");
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1: " + set1.toString());

        // Test contains method
        System.out.println("\nTesting contains method:");
        System.out.println("Does Set1 contain 2? " + set1.contains(2));
        System.out.println("Does Set1 contain 4? " + set1.contains(4));

        // Test largest and smallest methods
        System.out.println("\nTesting largest and smallest methods:");
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());

        // Test length method
        System.out.println("\nTesting length method:");
        System.out.println("Length of Set1: " + set1.length());

        // Test remove method
        System.out.println("\nTesting remove method:");
        System.out.println("Before removing 2: " + set1.toString());
        set1.remove(2);
        System.out.println("After removing 2: " + set1.toString());

        // Test clear method
        System.out.println("\nTesting clear method:");
        set1.clear();
        System.out.println("After clearing Set1: " + set1.toString());

        // Test isEmpty method
        System.out.println("\nTesting isEmpty method:");
        System.out.println("Is Set1 empty? " + set1.isEmpty());

        // Test union operation
        System.out.println("\nTesting union operation:");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("After union: " + set1.toString());

        // Test intersection operation
        System.out.println("\nTesting intersection operation:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("After intersection: " + set1.toString());

        // Test difference operation
        System.out.println("\nTesting difference operation:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("After difference: " + set1.toString());

        // Test complement operation
        System.out.println("\nTesting complement operation:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(1);
        set2.add(2);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.complement(set2);
        System.out.println("After complement: " + set1.toString());

        // Test equals method
        System.out.println("\nTesting equals method:");
        set1.clear();
        set1.add(1);
        set1.add(2);
        set2.clear();
        set2.add(2);
        set2.add(1);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        System.out.println("Are sets equal? " + set1.equals(set2));
    }
}

/*
 * References:
 * 1. Java Development Kit (JDK) Documentation: https://docs.oracle.com/javase/8/docs/
 * 2. Java Compiler (javac) Documentation: https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javac.html
 * 3. Javadoc Tool Documentation: https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html
 * 4. Oracle's Javadoc Guide: https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/
 * 5. Javadoc Tags Reference: https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/javadoc.html#tag
 * 6. Javadoc Best Practices: https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
 */ 