package com.greenfieldlibrary.backend.controllers;

import java.util.Date;

public class LendingsRequest {

    private int bookId;
    private int memberId;
    private Date dataLending;
    private Date dataReturn;

   

    public Integer getBookId() {
        return bookId;
    }


    public Integer getMemberId() {
        return memberId;
    }

    public Date getDataLending() {
        return dataLending;
    }


    public Date getDataReturn() {
        return dataReturn;
    }

}
