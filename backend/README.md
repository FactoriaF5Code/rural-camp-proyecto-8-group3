# GREENFIELD API

| Method | Path                    | Comments |
|--------|-----------------|----------|
|   GET  | /books      | Mostrar todos los libros existentes.   |
|   GET  | /books/{id} | Mostrar datos específicos de un libro.   |
|   GET  | /members    | Mostrar todos los socios existentes.   |
|   POST | /lendings   | Crea un nuevo préstamo. Hay que indicar los ids de libro y socio.   |
|   POST | /members    | Añadir nuevo usuario a la base de datos.   |
|   DELETE  | /lendings   | Retornar un libro (terminar el préstamo)   |

# SET UP

- Spring Version 3.2.2 
- Group Id: org.greenfieldlibrary
- Artifact Id: backend
- Packaging Type: Jar
- Java Version: 17
- dependencies: Spring Web , PostgreSQL , Spring Boot Dev Tools , Spring Data JPA , Lombok

