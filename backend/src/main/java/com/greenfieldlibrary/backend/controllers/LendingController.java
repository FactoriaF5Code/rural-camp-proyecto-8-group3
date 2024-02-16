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
import com.greenfieldlibrary.backend.persistence.Lendings;

@RestController
@RequestMapping("/lendings")
public class LendingController {

    @Autowired
    private LendingsRepository lendingsRepository;

    @PostMapping
    public LendingResponse createLending(@RequestBody LendingRequest request) {
        Lendings lending = new Lendings();
        lending.setIdBooks(request.getIdBooks());
        lending.setIdMember(request.getIdMember());
        lending.setDataLending(request.getDataLending());
        lending.setDataReturn(request.getDataReturn());
        Lendings savedLending = lendingsRepository.save(lending);

        return new LendingResponse(savedLending.getId(), savedLending.getId(),
                savedLending.getIdBooks(), savedLending.getDataLending(),
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
