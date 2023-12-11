package com.example.biblioteca.Model;
import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String name;
    private int categoryId;
    private ArrayList<Integer> ISBNlist = new ArrayList<>();

    public Category(String name, int i){
        setName(name);
        addBook(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName(){
        return this.name;
    }
    public void addBook(int ISBN){
        ISBNlist.add(ISBN);
    }
    public ArrayList<Integer> getISBNlist(){
        ArrayList<Integer> listISBN = new ArrayList<>();
        for (Integer i: this.ISBNlist){
            listISBN.add(i);
        }
        return listISBN;
    }
}
