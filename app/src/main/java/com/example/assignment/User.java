package com.example.assignment;
public class User {

    private String email;
    private String fullName;
    private String profession;
    private String workplace;
    private String phone;
    private String password;
    private String sex;

    public User() {}

    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
