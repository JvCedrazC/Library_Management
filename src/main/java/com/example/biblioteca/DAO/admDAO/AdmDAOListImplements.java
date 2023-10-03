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
        for (Adm adm: this.AdmList){
            if (adm.getId() == id){
                return adm;
            }
        }
        return null;
    }

    @Override
    public List<Adm> findMany() {
        List<Adm> listAdm = new ArrayList<>();
        for (Object o: this.AdmList){
            listAdm.add((Adm) o);
        }
        return listAdm;
    }

    @Override
    public void update(Adm obj) {
        for (int i = 0; i < this.AdmList.size(); i++){
            if (this.AdmList.get(i).getId() == obj.getId()){
                this.AdmList.set(i, obj);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < AdmList.size(); i++){
            if (this.AdmList.get(i).getId() == id){
                this.AdmList.remove(i);
            }
        }
    }

    @Override
    public void deleteMany() {
        this.AdmList = new ArrayList<>();
        this.nextId = 0;
    }
}
