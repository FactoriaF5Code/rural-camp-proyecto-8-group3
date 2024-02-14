package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greenfieldlibrary.backend.persistence.BooksRepository;

import java.util.List;
import java.util.Optional;

@RestController

public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping // metodo para todos los libros//
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}








// @GetMapping("/api/books/{id}") // metodo para un libro por id//
// public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
// Optional<Book> bookOptional = booksRespository.findById(id);
// if (bookOptional.isPresent()) {
// return ResponseEntity.ok(bookOptional.get());

// } else {
// return ResponseEntity.notFound().build();
// }
// }
// }
