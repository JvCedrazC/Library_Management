package com.example.biblioteca.Model;

import java.util.Date;

public class Book {
    private int id = -1;
    private int category_id;
    private int ISBN;
    private String name;
    private String author;
    private String publisher;
    private int locked = 0;

    public Book(int isbn, int category_id, String name, String author, String publisher){
        setISBN(isbn);
        setName(name);
        setCategory_id(category_id);
        setAuthor(author);
        setPublisher(publisher);

    }


    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {return category_id;}

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
    public int getLocked() {
        return locked;
    }
}
