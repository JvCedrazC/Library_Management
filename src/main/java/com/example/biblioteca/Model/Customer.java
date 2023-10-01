package com.example.biblioteca.Model;

import java.time.LocalDate;

public class Customer extends Person {
    public Customer(int id, String name){
        super(id, name);
    }

    public boolean booking(){
        return true;
    }

    public boolean give_Back(LocalDate returningDate){
        return true;
    }

}
