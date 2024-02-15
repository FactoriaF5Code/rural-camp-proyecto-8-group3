package com.greenfieldlibrary.backend.controllers;

public class MembersResponse {

    private Long idMembers;
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public MembersResponse(Long idMembers, String name, String lastName, String phone, String email) {
        this.idMembers = idMembers;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Long getidMembers() {
        return idMembers;
    }

    public void setidMembers(Long idMembers) {
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

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

}
