package com.greenfieldlibrary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lendings")
public class LendingsController {
    @Autowired
    private LendingRepository lendingRepository;

}