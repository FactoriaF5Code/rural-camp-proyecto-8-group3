package com.greenfieldlibrary.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

        if (request.getBookId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book ID not found");
        } else if (request.getMemberId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member ID not found");
        }

        Integer idBooks = request.getBookId(); 
        Books book = booksRepository.findById(idBooks)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        Integer idMember = request.getMemberId(); 
        Members member = membersRepository.findById(idMember)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));

        Lendings lending = new Lendings();
        lending.setBook(book);
        lending.setMember(member);
        lending.setDataLending(request.getDataLending());
        lending.setDataReturn(request.getDataReturn());

        return lendingsRepository.save(lending);
    }


@GetMapping("/Lendings")
public List<LendingsResponse> showLendings() {
    List<LendingsResponse> lendings = new ArrayList<LendingsResponse>();
    List<Lendings> lendingsInDataBaseLendings = repository.findAll();
    for (Lendings lending : lendingsInDataBaseLendings) { 
    lendings.add(new LendingsResponse(lending.getIdLendings(), lending.getBookId(), lending.getMemberId(), lending.getDataLending(), lending.getDataReturn()));
    }
    return lendings;
    }

