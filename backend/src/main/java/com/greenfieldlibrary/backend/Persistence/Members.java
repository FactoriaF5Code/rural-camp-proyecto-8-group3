package com.greenfieldlibrary.backend.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMember;
    private String name;
    private String last_name;
    private String email;
    private String phone;
}
//constructor vacio
public Members() {
}

// Constructor con parámetros
public Members(String name, String lastName, String email, String phone) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
}

// Getters y Setters
public Long getIdMember() {
    return idMember;
}

public void setIdMember(Long idMember) {
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

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}
