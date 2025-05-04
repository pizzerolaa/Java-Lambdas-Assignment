package com.example;

public class App 
{
    public static void main( String[] args )
    {
        Library library = new Library();
        
        library.addBook(new Book("El Quijote", "Miguel de Cervantes", 1605));
        library.addBook(new Book("Cien años de soledad", "Gabriel García Márquez", 1967));
        library.addBook(new Book("El laberinto de la soledad", "Octavio Paz", 1950));
        library.addBook(new Book("Rayuela", "Julio Cortázar", 1963));
        library.addBook(new EBook("El alquimista", "Paulo Coelho", 1988, 2.5));
        library.addBook(new Book("La ciudad y los perros", "Mario Vargas Llosa", 1963));
        library.addBook(new EBook("Don Quijote de la Mancha", "Miguel de Cervantes", 1615, 5.7));
        
        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();
    }
}