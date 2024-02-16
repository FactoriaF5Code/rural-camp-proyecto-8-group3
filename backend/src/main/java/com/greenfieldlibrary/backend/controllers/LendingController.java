package com.greenfieldlibrary.backend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.greenfieldlibrary.backend.persistence.LendingsRepository;
import com.greenfieldlibrary.backend.persistence.Members;
import com.greenfieldlibrary.backend.persistence.MembersRepository;
import com.greenfieldlibrary.backend.persistence.Books;
import com.greenfieldlibrary.backend.persistence.BooksRepository;
import com.greenfieldlibrary.backend.persistence.Lendings;

@RestController
public class LendingController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private LendingsRepository lendingsRepository;

    @PostMapping("/lendings")
    public Lendings createLending(@RequestBody LendingsRequest request) {

        if (request.getIdBooks() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book ID not found");
        } else if (request.getIdMember() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member ID not found");
        }
        // Buscar libro y miembro por ID
        // ...
        Integer idBooks = request.getIdBooks(); // Asegura que es Integer
        Books book = booksRepository.findById(idBooks)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        // ...

        // ...
        Integer idMember = request.getIdMember(); // Asegura que es Integer
        Members member = membersRepository.findById(idMember)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
        // ...

        // Crear nuevo objeto Lending
        Lendings lending = new Lendings();
        lending.setBook(book);
        lending.setMember(member);
        lending.setDataLending(request.getDataLending());
        lending.setDataReturn(request.getDataReturn());

        // Guardar el préstamo en la base de datos
        return lendingsRepository.save(lending);
    }
}
