package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Library implements BookManager {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
    
    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    
    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        // Using a Lambda expression to filter books by author
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
        
    @Override
    public List<Book> sortBooksByTitle() {
        // Using a Lambda expression to sort books by title
        return books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Book> sortBooksByYearAscending() {
        return books.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Book> sortBooksByYearDescending() {
        return books.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getYear(), b1.getYear()))
                .collect(Collectors.toList());
    }
    
    @Override
    public void printAllBooks() {
        books.forEach(System.out::println);
    }
    
    public List<Book> findBooksPublishedBefore(int year) {
        return books.stream()
                .filter(book -> book.getYear() < year)
                .collect(Collectors.toList());
    }
    
    public List<Book> findBooksByTitleContaining(String substring) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
    }
}