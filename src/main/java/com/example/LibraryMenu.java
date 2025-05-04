package com.example;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private Scanner scanner;
    
    public LibraryMenu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== BIBLIOTECA VIRTUAL =====");
            System.out.println("1. Añadir un nuevo libro");
            System.out.println("2. Añadir un nuevo libro electrónico");
            System.out.println("3. Ver todos los libros");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Buscar libros por parte del título");
            System.out.println("6. Buscar libros publicados antes de un año");
            System.out.println("7. Ordenar libros por título");
            System.out.println("8. Ordenar libros por año (ascendente)");
            System.out.println("9. Ordenar libros por año (descendente)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = getIntInput();
            
            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addEbook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    findBooksByAuthor();
                    break;
                case 5:
                    findBooksByTitle();
                    break;
                case 6:
                    findBooksBeforeYear();
                    break;
                case 7:
                    sortByTitle();
                    break;
                case 8:
                    sortByYearAscending();
                    break;
                case 9:
                    sortByYearDescending();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Gracias por usar la Biblioteca Virtual. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
    
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, introduzca un número válido: ");
            }
        }
    }
    
    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, introduzca un número válido: ");
            }
        }
    }
    
    private void addBook() {
        System.out.print("Introduzca el título del libro: ");
        String title = scanner.nextLine();
        
        System.out.print("Introduzca el autor: ");
        String author = scanner.nextLine();
        
        System.out.print("Introduzca el año de publicación: ");
        int year = getIntInput();
        
        library.addBook(new Book(title, author, year));
        System.out.println("Libro añadido con éxito.");
    }
    
    private void addEbook() {
        System.out.print("Introduzca el título del libro electrónico: ");
        String title = scanner.nextLine();
        
        System.out.print("Introduzca el autor: ");
        String author = scanner.nextLine();
        
        System.out.print("Introduzca el año de publicación: ");
        int year = getIntInput();
        
        System.out.print("Introduzca el tamaño del archivo (MB): ");
        double fileSize = getDoubleInput();
        
        library.addBook(new EBook(title, author, year, fileSize));
        System.out.println("Libro electrónico añadido con éxito.");
    }
    
    private void displayAllBooks() {
        System.out.println("\n=== TODOS LOS LIBROS ===");
        library.printAllBooks();
    }
    
    private void findBooksByAuthor() {
        System.out.print("Introduzca el nombre del autor: ");
        String author = scanner.nextLine();
        
        List<Book> foundBooks = library.findBooksByAuthor(author);
        displayBooks(foundBooks, "Libros de " + author);
    }
    
    private void findBooksByTitle() {
        System.out.print("Introduzca parte del título: ");
        String title = scanner.nextLine();
        
        List<Book> foundBooks = library.findBooksByTitleContaining(title);
        displayBooks(foundBooks, "Libros que contienen '" + title + "' en el título");
    }
    
    private void findBooksBeforeYear() {
        System.out.print("Introduzca el año: ");
        int year = getIntInput();
        
        List<Book> foundBooks = library.findBooksPublishedBefore(year);
        displayBooks(foundBooks, "Libros publicados antes de " + year);
    }
    
    private void sortByTitle() {
        List<Book> sortedBooks = library.sortBooksByTitle();
        displayBooks(sortedBooks, "Libros ordenados por título");
    }
    
    private void sortByYearAscending() {
        List<Book> sortedBooks = library.sortBooksByYearAscending();
        displayBooks(sortedBooks, "Libros ordenados por año (ascendente)");
    }
    
    private void sortByYearDescending() {
        List<Book> sortedBooks = library.sortBooksByYearDescending();
        displayBooks(sortedBooks, "Libros ordenados por año (descendente)");
    }
    
    private void displayBooks(List<Book> books, String title) {
        System.out.println("\n=== " + title + " ===");
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            books.forEach(System.out::println);
        }
    }
}