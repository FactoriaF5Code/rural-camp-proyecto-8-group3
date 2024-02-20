package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.Books;
import com.greenfieldlibrary.backend.persistence.BooksRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BooksController {

    private BooksRepository repository;

    public BooksController(@Autowired BooksRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<BooksResponse> showBooks() {
        List<BooksResponse> books = new ArrayList<BooksResponse>();
        List<Books> booksInDataBaseBooks = repository.findAll();
        for (Books book : booksInDataBaseBooks) {
            books.add(new BooksResponse(book.getIdBooks(), book.getTitle(), book.getAuthor(), book.getIsbn(),
                    book.getStatus()));
        }
        return books;
    }

    public static ResponseEntity<Books> getBooksById(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooksById'");
    }

}
