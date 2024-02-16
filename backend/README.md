# GREENFIELD API

| Method | Path                    | Comments |
|--------|-----------------|----------|
|   GET  | /api/books      | Mostrar todos los libros existentes.   |
|   GET  | /api/books/{id} | Mostrar datos específicos de un libro.   |
|   GET  | /api/members    | Mostrar todos los socios existentes.   |
|   POST | /api/lendings   | Crea un nuevo préstamo. Hay que indicar los ids de libro y socio.   |
|   POST | /api/members    | Añadir nuevo usuario a la base de datos.   |
|   DELETE  | /api/lendings   | Retornar un libro (terminar el préstamo)   |

# SET UP

- Spring Version 3.2.2 
- Group Id: org.greenfieldlibrary
- Artifact Id: backend
- Packaging Type: Jar
- Java Version: 17
- dependencies: Spring Web , PostgreSQL , Spring Boot Dev Tools , Spring Data JPA , Lombok

