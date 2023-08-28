package com.example.biblioteca.Model;

public abstract class Person {
    private int id;
    private String nome;

    //getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
