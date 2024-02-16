package com.greenfieldlibrary.backend.persistence;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "lending")
public class Lendings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "id_member")
    private Long idMember;

    @Column(name = "data_lending")
    private Date dataLending;

    @Column(name = "data_retorno")
    private Date dataReturno;

    
}


