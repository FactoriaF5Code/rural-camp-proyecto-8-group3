package com.greenfieldlibrary.backend.controllers;

import java.util.Date;

public class LendingsRequest {

private Integer idBooks;
private Integer idMember;
private Date dataLending;
private Date dataReturn;
public LendingsRequest(Integer idBooks, Integer idMember, Date dataLending, Date
dataReturn) {
this.idBooks = idBooks;
this.idMember = idMember;
this.dataLending = dataLending;
this.dataReturn = dataReturn;
}
public Integer getIdBooks() {
return idBooks;
}
public void setIdBooks(Integer idBooks) {
this.idBooks = idBooks;
}
public Integer getIdMember() {
return idMember;
}
public void setIdMember(Integer idMember) {
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
