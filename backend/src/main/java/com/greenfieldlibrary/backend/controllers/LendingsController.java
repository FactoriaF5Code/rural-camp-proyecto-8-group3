package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.Lending;
import com.greenfieldlibrary.backend.persistence.LendingRepository;

@RestController
@RequestMapping("/lendings")
public class LendingsController {
    @Autowired
    private LendingRepository lendingRepository;

    // @PostMapping
public ResponseEntity<Lending>createLending(@RequestBody Lending lending){
    try {
        Lending newLending=lendingRepository.save(lending);
        return new ResponseEntity<>(newLending,HttpStatus.CREATED);
    }

    Catch(Expection e){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping 
    public ResponseEntity<HttpStatus>deleteLending(@PathVariable("id") Long id){

        try{
            lendingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    Catch(Expection e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
             }
}}
