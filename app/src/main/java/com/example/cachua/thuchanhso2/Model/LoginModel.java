package com.example.cachua.thuchanhso2.Model;

public class LoginModel {
    int id;
    String name;
    String password;

    public LoginModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public LoginModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
