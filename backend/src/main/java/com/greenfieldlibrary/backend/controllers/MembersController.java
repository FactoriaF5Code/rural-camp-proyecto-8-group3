package com.greenfieldlibrary.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.greenfieldlibrary.backend.persistence.Member;
import com.greenfieldlibrary.backend.persistence.MemberRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class MembersController {

    public MemberRepository repository;

    public MembersController(@Autowired MemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/members")
    public ResponseEntity<Member> addMember(@RequestBody MembersRequest membersRequest) {
        Member member = new Member();

        member.setLastName(membersRequest.getLastName());
        member.setPhone(membersRequest.getPhone());
        member.setEmail(membersRequest.getEmail());
        memberRepository.save(member);

        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

}
