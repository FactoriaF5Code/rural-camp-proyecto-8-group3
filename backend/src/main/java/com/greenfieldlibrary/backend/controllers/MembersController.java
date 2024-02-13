package com.greenfieldlibrary.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(/members)
public class MembersController {
    @Autowired
    private MembersRepository memberRepository;

}
