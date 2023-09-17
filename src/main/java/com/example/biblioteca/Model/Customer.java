package com.example.biblioteca.Model;

public class Customer extends Person {
    public Customer(int id, String name){
        super(id, name);
    }

    //Methods
    public boolean Loan(){
        return true;
    }

    public boolean booking(){
        return true;
    }

    public boolean give_Back(){
        return true;
    }

}
