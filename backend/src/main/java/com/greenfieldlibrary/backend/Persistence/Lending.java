package com.greenfieldlibrary.backend.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Lending {
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

    public Lending() {

    }

    public Lending(Books idBooks, Members idMembers, Date dateLending, Date dateReturn) {
        this.book = book;
        this.member = member;
        this.dateLending = dateLending;
        this.dateReturn = dateReturn;
    }

    public Long getId() {
        return id;
    }

public void setId(Long id){
    this.id=id;
} public Book getBook() {
    return book;
}

public void setBook(Book book) {
    this.book = book;
}

public Member getMember() {
    return member;
}

public void setMember(Member member) {
    this.member = member;
}

public Date getDateLending() {
    return dateLending;
}

public void setDateLending(Date dateLending) {
    this.dateLending = dateLending;
}

public Date getDateReturn() {
    return dateReturn;
}

public void setDateReturn(Date dateReturn) {
    this.dateReturn = dateReturn;
}