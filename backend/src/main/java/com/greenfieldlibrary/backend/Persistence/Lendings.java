

// package com.greenfieldlibrary.backend.persistence;

// import java.util.Date;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "lendings")
// public class Lendings {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @ManyToOne
// @JoinColumn(name = "id_books") // Cambiamos "book" a "books"
// private Books book;

// @ManyToOne
// @JoinColumn(name = "id_member")
// private Members member;

// @Column(name = "data_lending")
// private Date dataLending;

// @Column(name = "data_return")
// private Date dataReturn;

// // Constructor (vacío)
// public Lendings() {
// }

// // Getters y Setters
// public Long getId() {
// return id;
// }

// public void setId(Long id) {
// this.id = id;
// }

// public Books getBook() {
// return book;
// }

// public void setBook(Books book) {
// this.book = book;
// }

// public Members getMember() {
// return member;
// }

// public void setMember(Members member) {
// this.member = member;
// }

// public Date getDataLending() {
// return dataLending;
// }

// public void setDataLending(Date dataLending) {
// this.dataLending = dataLending;
// }

// public Date getDataReturn() {
// return dataReturn;
// }

// public void setDataReturn(Date dataReturn) {
// this.dataReturn = dataReturn;
// }
// }
