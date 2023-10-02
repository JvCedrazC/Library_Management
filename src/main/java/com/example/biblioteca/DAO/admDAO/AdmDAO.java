package com.example.biblioteca.DAO.admDAO;

import com.example.biblioteca.DAO.CRUD;
import com.example.biblioteca.Model.Adm;

import java.util.List;

public interface AdmDAO extends CRUD<Adm> {
    public Adm create(Adm obj);
    //Read

    public Adm findById(int id);
    public List<Adm> findMany();
    //update
    public void update(Adm obj);
    //delete
    public void deleteById(int id);
    public void deleteMany();
}
