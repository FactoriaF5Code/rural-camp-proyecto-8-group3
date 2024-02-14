package com.greenfieldlibrary.backend.persistence;

import jakarta.persistence.Id;

@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMember;
    private String name;
    private String last_name;
    private String email;
    private String phone;
}
