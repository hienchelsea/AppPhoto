package com.example.cachua.thuchanhso2.Model;

public class BookModel {
    int id;
    String nameBook;
    String kindBook;

    public BookModel(String nameBook, String kindBook) {
        this.nameBook = nameBook;
        this.kindBook = kindBook;
    }

    public BookModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getKindBook() {
        return kindBook;
    }

    public void setKindBook(String kindBook) {
        this.kindBook = kindBook;
    }
}
