package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.LendingRepository;
import com.greenfieldlibrary.backend.persistence.Lendings;

@RestController
@RequestMapping("/api/lending")
public class LendingController {

    @Autowired
    private LendingRepository lendingRepository;

    @PostMapping
    public LendingResponse createLending(@RequestBody LendingRequest request) {
        Lendings lending = new Lendings();
        lending.setIdBook(request.getIdBook());
        lending.setIdMember(request.getIdMember());
        lending.setDataLending(request.getDataLending());
        lending.setDataReturno(request.getDataReturno());
        Lendings savedLending = lendingRepository.save(lending);
        return new LendingResponse(savedLending.getId(), savedLending.getIdBook(), savedLending.getIdMember(), savedLending.getDataLending(), savedLending.getDataReturno());
    }

    @DeleteMapping("/{id}")
    public void deleteLending(@PathVariable Long id) {
        lendingRepository.deleteById(id);
    }
}

