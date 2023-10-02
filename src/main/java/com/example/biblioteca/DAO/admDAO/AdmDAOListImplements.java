package com.example.biblioteca.DAO.admDAO;

import com.example.biblioteca.Model.Adm;

import java.util.ArrayList;
import java.util.List;

public class AdmDAOListImplements implements AdmDAO{
    private ArrayList<Adm> AdmList;
    private int nextId;
    public AdmDAOListImplements(){
        this.AdmList = new ArrayList<>();
        this.nextId = 0;
    }

    @Override
    public Adm create(Adm obj) {
        obj.setId(nextId);
        this.AdmList.add(obj);
        nextId++;
        return obj;
    }

    @Override
    public Adm findById(int id) {
        return null;
    }

    @Override
    public List<Adm> findMany() {
        return null;
    }

    @Override
    public void update(Adm obj) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}
