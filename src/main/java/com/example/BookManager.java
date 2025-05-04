package com.example;
import java.util.List;

public interface BookManager {
    void addBook(Book book);
    List<Book> getBooks();
    List<Book> findBooksByAuthor(String author);
    List<Book> sortBooksByTitle();

    List<Book> sortBooksByYearAscending();
    List<Book> sortBooksByYearDescending();

    default void printAllBooks(){
        getBooks().forEach(System.out::println);
    }
}
