# A01643685 - Java-Lambdas-Assignment

## Proyecto con Lambdas y References

Esta actividad tiene como objetivo comprender y aplicar características de Java 8 como expresiones Lambda, Referencias de métodos y Métodos predeterminados en interfaces creando una aplicación simple.

## Descripción General

La aplicación permite gestionar una colección de libros con las siguientes funcionalidades:

- Añadir libros físicos y electrónicos
- Buscar libros por autor, título o año de publicación
- Ordenar libros por título o año
- Mostrar todos los libros de la biblioteca

## Características Java Implementadas

- **Expresiones Lambda**: Para filtrar y ordenar colecciones de libros
- **Referencias a Métodos**: Para operaciones como imprimir libros
- **Métodos por Defecto**: En la interfaz BookManager para proveer implementaciones comunes
- **Streams API**: Para procesamiento de colecciones
- **Herencia**: Con la clase EBook que extiende la clase Book

## Estructura del Proyecto

El proyecto contiene estas clases principales:

- `Book`: Clase base que representa un libro
- `EBook`: Subclase de Book con atributos adicionales
- `BookManager`: Interfaz que define operaciones sobre libros
- `Library`: Implementación de la interfaz BookManager
- `LibraryMenu`: Clase para la interfaz de usuario
- `App`: Clase principal con método main

## Requisitos

- Java 8 o superior
- Maven 3.x

## Comandos Principales

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar la aplicación
```bash
java -cp target/classes com.example.App
```

### Ejecutar las pruebas
```bash
mvn clean test
```

## Ejemplos de Código

### Ejemplo de Lambda para filtrado
```java
// Búsqueda de libros por autor
books.stream()
     .filter(book -> book.getAuthor().equalsIgnoreCase(author))
     .collect(Collectors.toList());
```

### Ejemplo de Método por Defecto
```java
// Método por defecto en la interfaz BookManager
default void printAllBooks() {
    getBooks().forEach(System.out::println);
}
```

## Pruebas

El proyecto incluye pruebas unitarias que verifican:
- Operaciones básicas (añadir/obtener libros)
- Búsqueda de libros
- Ordenamiento de libros
- Funcionalidades específicas de EBook