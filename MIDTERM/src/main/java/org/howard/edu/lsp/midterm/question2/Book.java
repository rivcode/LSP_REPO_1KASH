package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library with title, author, ISBN, and publication year.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor for creating a new Book
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Overridden equals method that considers two Books equal if they have the same ISBN and author
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Book other = (Book) obj;
        return this.ISBN.equals(other.ISBN) && this.author.equals(other.author);
    }

    /**
     * Overridden toString method that returns a string representation of the Book
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
} 