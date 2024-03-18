package com.greenfieldlibrary.backend.controllers;

public class MembersResponse {

    private Integer idMembers;
    private String name;
    private String lastName;
    private Integer phone;
    private String email;

    public MembersResponse(Integer idMembers, String name, String lastName, Integer phone, String email) {
        this.idMembers = idMembers;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Integer getidMembers() {
        return idMembers;
    }

    public void setidMembers(Integer idMembers) {
        this.idMembers = idMembers;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getphone() {
        return phone;
    }

    public void setphone(Integer phone) {
        this.phone = phone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

}
