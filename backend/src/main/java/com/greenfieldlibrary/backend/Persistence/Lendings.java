package com.greenfieldlibrary.backend.persistence;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lendings")
public class Lendings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_books") // Cambiamos "book" a "books"
    private Books book;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private Members member;

    @Column(name = "data_lending")
    private Date dataLending;

    @Column(name = "data_return")
    private Date dataReturn;

    // Constructor (vacío)
    public Lendings() {
    }

    public Lendings(int i, int j, String string, String string2, String string3) {
        // TODO Auto-generated constructor stub
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
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

    public Short getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    public Long getIdBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdBooks'");
    }
}
