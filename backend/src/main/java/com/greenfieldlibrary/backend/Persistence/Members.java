package com.greenfieldlibrary.backend.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMember;
    private String name;
    private String lastName;
    private String email;
    private Integer phone;

    public Members(Integer idMember, String name, String lastName, Integer phone, String email) {
        this.idMember = idMember;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // constructor vacio
    public Members() {
    }

    // Getters y Setters
    public Integer getIdMember() {
        return idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

}
