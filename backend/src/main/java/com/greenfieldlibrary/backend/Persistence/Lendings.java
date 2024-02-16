package com.greenfieldlibrary.backend.persistence;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lendings")
public class Lendings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Lendings(Long id, Long idBooks, Long idMember, Date dataLending, Date dataReturn) {
        this.id = id;
        this.idBooks = idBooks;
        this.idMember = idMember;
        this.dataLending = dataLending;
        this.dataReturn = dataReturn;
    }

    @Column(name = "id_books")
    private Long idBooks;

    @Column(name = "idMember")
    private Long idMember;

    @Column(name = "data_lending")
    private Date dataLending;

    @Column(name = "data_return")
    private Date dataReturn;

    public Lendings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(Long idBooks) {
        this.idBooks = idBooks;
    }

    public Long getIdMember() {
        return idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
    }

    public Date getDataLending() {
        return dataLending;
    }

    public void setDataLending(Date dataLending) {
        this.dataLending = dataLending;
    }

    public Date getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(Date dataReturn) {
        this.dataReturn = dataReturn;
    }

}
