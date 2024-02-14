package com.greenfieldlibrary.backend.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Books idBooks;
    @ManyToOne
    private Members idMembers;
    private Date dateLending;
    private Date dateReturn;

}
