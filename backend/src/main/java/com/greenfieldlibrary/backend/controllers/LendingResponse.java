package com.greenfieldlibrary.backend.controllers;

import java.util.Date;

public class LendingResponse {

    private Long id;
    private Long idBook;
    private Long idMember;
    private Date dataLending;
    private Date dataReturno;

    public LendingResponse(Long id, Long idBook, Long idMember, Date dataLending, Date dataReturno) {
        this.id = id;
        this.idBook = idBook;
        this.idMember = idMember;
        this.dataLending = dataLending;
        this.dataReturno = dataReturno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
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

    public Date getDataReturno() {
        return dataReturno;
    }

    public void setDataReturno(Date dataReturno) {
        this.dataReturno = dataReturno;
    }

}
