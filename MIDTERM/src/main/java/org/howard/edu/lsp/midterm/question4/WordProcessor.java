package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private String sentence;

    /**
     * Constructor that initializes the sentence to be processed
     * @param sentence The input sentence
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all words with the maximum length in the sentence
     * @return List of longest words in order of appearance
     */
    public List<String> findLongestWords() {
        // Handle empty input
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Split the sentence into words, handling varying amounts of whitespace
        String[] words = sentence.trim().split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        // First pass: find the maximum word length
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        // Second pass: collect all words of maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
} 