package com.greenfieldlibrary.backend.controllers;

import java.util.Date;

public class LendingRequest {

    private Long idBook;
    private Long idMember;
    private Date dataLending;
    private Date dataReturno;
    public LendingRequest(Long idBook, Long idMember, Date dataLending, Date dataReturno) {
        this.idBook = idBook;
        this.idMember = idMember;
        this.dataLending = dataLending;
        this.dataReturno = dataReturno;
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
