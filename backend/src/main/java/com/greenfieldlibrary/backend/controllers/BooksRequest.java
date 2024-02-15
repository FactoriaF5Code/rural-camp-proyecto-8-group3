package com.greenfieldlibrary.backend.controllers;

public class BooksRequest {
    private Long idBooks;
    private String title;
    private String author;
    private String isbn;
    private String status;
    
    public Long getIdBooks() {
        return idBooks;
    }
    public void setIdBooks(Long idBooks) {
        this.idBooks = idBooks;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public BooksRequest(String title, String author, String isbn, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }
}
