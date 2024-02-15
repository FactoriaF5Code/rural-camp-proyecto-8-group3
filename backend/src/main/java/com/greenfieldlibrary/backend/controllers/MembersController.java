package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.Member;
import com.greenfieldlibrary.backend.persistence.MemberRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class MembersController {

    private MemberRepository repository;

    public MembersController(@Autowired MemberRepository repository) {
        this.repository = repository;
    }

@PostMapping("/members")
public ResponseEntity<Member> addMember(@RequestBody MembersRequest membersRequest){
    Member member= new Member();
    Member.setName(membersRequest.getName());
    Member.setLastName(membersRequest.getLastName());
    Member.setPhone(membersRequest.getPhone());
    Member.setEmail(membersRequest.getEmail());
    MemberRepository.save(member);

    return new ResponseEntity<>(member, HttpStatus.CREATED);






























    
    
}
