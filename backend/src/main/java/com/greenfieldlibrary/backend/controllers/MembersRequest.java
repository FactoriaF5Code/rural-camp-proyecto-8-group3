package com.greenfieldlibrary.backend.controllers;

public class MembersRequest {
    private Long idMembers;
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public Long getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(Long idMembers) {
        this.idMembers = idMembers;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
