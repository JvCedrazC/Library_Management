package com.example.biblioteca.Model;
import java.util.ArrayList;

public class Category {
    private String name;
    private static ArrayList<Integer> ISBNlist;

    public Category(String name, int i){
        setName(name);
        addBook(i);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addBook(int ISBN){
        ISBNlist.add(ISBN);
    }
}
