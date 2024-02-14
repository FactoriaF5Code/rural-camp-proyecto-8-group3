package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksRepository booksRepository;

}
