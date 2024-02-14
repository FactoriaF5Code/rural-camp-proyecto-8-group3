package com.greenfieldlibrary.backend.controllers;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.MembersRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/members")
public class MembersController {

    @Autowired
    private MembersRepository memberRepository;

    @GetMapping // para obtener todos los socios//
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @PostMapping//para añadir nuevo miembro
    public ResponseEntity<Member> addMember(@RequestBody Members Member);try

    {
        Member newMember = memberRepository.sav(Member);

        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }catch(
    Expection e)

    {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}}
