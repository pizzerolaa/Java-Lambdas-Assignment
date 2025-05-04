package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class LibraryTest {
    
    private Library library;
    
    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("El Quijote", "Miguel de Cervantes", 1605));
        library.addBook(new Book("Cien años de soledad", "Gabriel García Márquez", 1967));
        library.addBook(new Book("El laberinto de la soledad", "Octavio Paz", 1950));
        library.addBook(new Book("Rayuela", "Julio Cortázar", 1963));
        library.addBook(new EBook("El alquimista", "Paulo Coelho", 1988, 2.5));
    }
    
    @Test
    public void testAddBookAndGetBooks() {
        assertEquals(5, library.getBooks().size());
        
        Book newBook = new Book("La ciudad y los perros", "Mario Vargas Llosa", 1963);
        library.addBook(newBook);
        
        // verif. que hay 6 libros ya
        assertEquals(6, library.getBooks().size());
        assertTrue(library.getBooks().contains(newBook));
    }
    
    @Test
    public void testFindBooksByAuthor() {
        List<Book> cervantesBooks = library.findBooksByAuthor("Miguel de Cervantes");
        assertEquals(1, cervantesBooks.size());
        assertEquals("El Quijote", cervantesBooks.get(0).getTitle());
        
        List<Book> unknownAuthorBooks = library.findBooksByAuthor("Autor Desconocido");
        assertTrue(unknownAuthorBooks.isEmpty());
    }
    
    @Test
    public void testSortBooksByTitle() {
        //ordenar los libros por título
        List<Book> sortedBooks = library.sortBooksByTitle();
        assertEquals(5, sortedBooks.size());
        assertEquals("Cien años de soledad", sortedBooks.get(0).getTitle()); 
    }
    
    @Test
    public void testSortBooksByYearAscending() {
        List<Book> sortedBooks = library.sortBooksByYearAscending();
        assertEquals(1605, sortedBooks.get(0).getYear());
        assertEquals(1988, sortedBooks.get(sortedBooks.size()-1).getYear());
    }
    
    @Test
    public void testSortBooksByYearDescending() {
        List<Book> sortedBooks = library.sortBooksByYearDescending();
        assertEquals(1988, sortedBooks.get(0).getYear());
        assertEquals(1605, sortedBooks.get(sortedBooks.size()-1).getYear());
    }
    
    @Test
    public void testFindBooksPublishedBefore() {
        List<Book> oldBooks = library.findBooksPublishedBefore(1960);
        assertEquals(2, oldBooks.size());
        
        //los libros DEBEN de ser anteriores a 1960
        for (Book book : oldBooks) {
            assertTrue(book.getYear() < 1960);
        }
    }
    
    @Test
    public void testFindBooksByTitleContaining() {
        //libros q contengan "soledad" en el título
        List<Book> soledadBooks = library.findBooksByTitleContaining("soledad");
        assertEquals(2, soledadBooks.size());
        
        //debe de funcionar sin distinguir mayúsculas/minúsculas
        List<Book> quijoteBooks = library.findBooksByTitleContaining("QUiJoTe");
        assertEquals(1, quijoteBooks.size());
        assertEquals("El Quijote", quijoteBooks.get(0).getTitle());
    }
    
    @Test
    public void testEBookFunctionality() {
        //verificamos que podemos añadir y recuperar un EBook
        EBook ebook = new EBook("Don Quijote de la Mancha", "Miguel de Cervantes", 1615, 4.2);
        library.addBook(ebook);
        
        //buscamos todos los libros de Cervantes y deben de ser 2 
        List<Book> cervantesBooks = library.findBooksByAuthor("Miguel de Cervantes");
        assertEquals(2, cervantesBooks.size());
        
        boolean foundEBook = false;
        for (Book book : cervantesBooks) {
            if (book instanceof EBook) {
                EBook retrievedEbook = (EBook) book;
                assertEquals(4.2, retrievedEbook.getFileSize(), 0.01);  
                foundEBook = true;
            }
        }
        assertTrue("No se encontró el EBook esperado", foundEBook);
    }
}