package com.greenfieldlibrary.backend.controllers;

public class MembersRequest {


    private Integer idMembers;
    private String name;
    private String lastName;
    private Integer phone;
    private String email;

    public Integer getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(Integer idMembers) {
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MembersRequest(Integer idMembers, String name, String lastName, Integer phone, String email) {
        this.idMembers = idMembers;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
}
