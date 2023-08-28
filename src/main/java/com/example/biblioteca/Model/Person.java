package com.example.biblioteca.Model;

public abstract class Person {
    int id;
    String nome;

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

    Person (int identifier, String name){
        setId(identifier);
        setNome(name);
    }
}
