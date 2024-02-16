package com.greenfieldlibrary.backend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.greenfieldlibrary.backend.persistence.LendingsRepository;
import com.greenfieldlibrary.backend.persistence.Members;
import com.greenfieldlibrary.backend.persistence.Books;
import com.greenfieldlibrary.backend.persistence.BooksRepository;
import com.greenfieldlibrary.backend.persistence.Lendings;

@RestController
@RequestMapping("/lendings")
public class LendingController {

    @Autowired
    private LendingsRepository lendingsRepository;

    @PostMapping
    public LendingResponse createLending(@RequestBody LendingRequest request) {
        Lendings lending = new Lendings();
        // Obtención de Books (usando un repo que te facilite búsquedas en Spring)
        Books book = BooksRepository.findById(request.getIdBooks())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        Members member = membersRepository.findById(request.getIdMember())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));

        Lendings lending = new Lendings();
        lending.setBook(book);
        lending.setMember(member);
        // Establecer Book relacionado mediante el id
        Books book = BooksRepository.findById(request.getIdBooks())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        Members member = new Members();
        member.setIdMember(request.getIdMember());
        lending.setMember(member);

        lending.setDataLending(request.getDataLending());
        lending.setDataReturn(request.getDataReturn());

        Lendings savedLending = lendingsRepository.save(lending);

        // Mapeo de propiedades como lo tenías originalmente
        return new LendingResponse(savedLending.getId(), savedLending.getId(),
                savedLending.getBook().getIdBooks(), // obtener ID del libro mediante la relación
                savedLending.getDataLending(),
                savedLending.getDataReturn());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLendingById(@PathVariable Long id) {
        Optional<Lendings> optionalLending = lendingsRepository.findById(id);
        if (optionalLending.isPresent()) {
            lendingsRepository.delete(optionalLending.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lending not found");
        }
    }
}
