package com.greenfieldlibrary.backend.controllers;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.greenfieldlibrary.backend.persistence.Members;
import com.greenfieldlibrary.backend.persistence.MembersRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MembersController {

    public MembersRepository repository;

    public MembersController(@Autowired MembersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Members>> getAllMembers() {
        List<Members> members = repository.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MembersResponse> getMemberById(@PathVariable Integer id) {
        Optional<Members> member = repository.findById(id);
        if (member.isPresent()) {
            Members existingMember = member.get();
            MembersResponse membersResponse = new MembersResponse(existingMember.getIdMember(),
                    existingMember.getName(), existingMember.getLastName(), existingMember.getPhone(),
                    existingMember.getEmail());
            return ResponseEntity.ok(membersResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/members")
    public MembersResponse createMember(@RequestBody MembersRequest request) {
        Members member = new Members(
                request.getIdMembers(),
                request.getName(),
                request.getLastName(),
                request.getPhone(),
                request.getEmail());

        Members savedMember = repository.save(member);

        return new MembersResponse(
                savedMember.getIdMember(),
                savedMember.getName(),
                savedMember.getLastName(),
                savedMember.getPhone(),
                savedMember.getEmail());
    }

}
