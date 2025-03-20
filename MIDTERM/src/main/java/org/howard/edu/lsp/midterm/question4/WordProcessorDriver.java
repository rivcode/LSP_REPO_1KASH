package org.howard.edu.lsp.midterm.question4;

public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results, amazing achievements!");
        System.out.println("Test 1 - Longest words: " + wp1.findLongestWords());
        // Expected Output: [achievements]

        // Test case 2: Sentence with multiple occurrences of the same longest word
        WordProcessor wp2 = new WordProcessor("Java is a powerful  tool!");
        System.out.println("Test 2 - Longest words: " + wp2.findLongestWords());
        // Expected Output: [powerful]

        // Test case 3: Sentence with multiple different words of same length
        WordProcessor wp3 = new WordProcessor("The cat and dog ran fast");
        System.out.println("Test 3 - Longest words: " + wp3.findLongestWords());
        // Expected Output: [cat, dog, ran]

        // Test case 4: Sentence with single character words
        WordProcessor wp4 = new WordProcessor("A B C D E");
        System.out.println("Test 4 - Longest words: " + wp4.findLongestWords());
        // Expected Output: [A, B, C, D, E]

        // Test case 5: Empty string input
        WordProcessor wp5 = new WordProcessor("");
        System.out.println("Test 5 - Longest words: " + wp5.findLongestWords());
        // Expected Output: []

        // Test case 6: String with varying amounts of whitespace
        WordProcessor wp6 = new WordProcessor("This    has    multiple    spaces");
        System.out.println("Test 6 - Longest words: " + wp6.findLongestWords());
        // Expected Output: [multiple]
    }
} 